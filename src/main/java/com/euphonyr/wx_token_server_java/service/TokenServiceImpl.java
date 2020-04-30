package com.euphonyr.wx_token_server_java.service;

import com.euphonyr.wx_token_server_java.entity.App;
import com.euphonyr.wx_token_server_java.entity.Device;
import com.euphonyr.wx_token_server_java.entity.EuphonyQRDetectRequestParam;
import com.euphonyr.wx_token_server_java.entity.TokenATO;
import com.euphonyr.wx_token_server_java.utils.Detect;
import com.euphonyr.wx_token_server_java.utils.DetectResult;
import com.euphonyr.wx_token_server_java.utils.EuphonyQRDetectResult;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.util.*;

/**
 * ClassName TokenServiceImpl Descricption TOOD
 *
 * @Authorhaobaoyang
 * @Dage 2018/12/23 17:13
 * @VERSION 1.0
 **/

@Service
public class TokenServiceImpl implements TokenService {

    private static String RES_URL = "https://api.euphonyqr.com/api/token/v1";

    @Autowired
    RestTemplate restTemplate;

    @Override
    public boolean getToken(String appkey, String oldToken) {
        if (!TokenATO.appkey.equals(appkey)) {
            return false;
        }
        return getQieshuToken(appkey, oldToken);
    }

    // 通过请求获取箧书解析token，缓存到本地
    private synchronized boolean getQieshuToken(String appkey, String oldToken) {
        if (TokenATO.token != oldToken) { // 防止多线程
            return true;
        }

        Random random = new Random();

        String url = RES_URL + "?nocache=" + random.nextInt() + "&appkey=" +
                TokenATO.appkey + "&seckey=" + TokenATO.seckey + "&test=" + TokenATO.useSandbox;

        ResponseEntity<QSTokenVO> responseEntity = restTemplate.getForEntity(url,  QSTokenVO.class);

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            QSTokenVO result = responseEntity.getBody();
            if (null != result) {

                switch (result.getCode()) {

                    case 0: // OK
                    {
                        TokenATO.token = result.getToken();
                        break;
                    }
                    case 304: // 现有Token未过期，可以继续使用
                    {
                        break;
                    }
                    case 401: // Token过期，更新缓存
                    {
                        TokenATO.token = result.getToken();
                        break;
                    }
                    case 404: // appkey & seckey 是错的
                    {
                        TokenATO.token = null;
                        return false;
                    }
                }
            }
        }



        return true;
    }

    @Override
    public boolean checkWxAPPID(String referer) {
        if (!TokenATO.checkWxAPPID) {
            return true;
        }
        if (!StringUtils.isEmpty(referer)) {
            System.out.println("referer == " + referer);
            System.out.println(TokenATO.checkWxPrefix + TokenATO.wxAppID);
            if (referer.startsWith(TokenATO.checkWxPrefix)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public DetectResult getDetectResult(String appkey, String resRrl, String platform, String device_id, String refer,
                                        String ip, String UA) {

        DetectResult req = new DetectResult();
        if (TokenATO.appkey == null || !TokenATO.appkey.equals(appkey)) {
            req.setMsg("Error1");
            return req;
        }
        if (!checkWxAPPID(refer)) {
            req.setMsg("Error2");
            return req;
        }
        EuphonyQRDetectRequestParam queryData = makeQueryData(appkey, platform, device_id, refer, ip, UA);

        return queryData(queryData, resRrl);
    }

    public EuphonyQRDetectRequestParam makeQueryData(String appkey, String platform, String device_id, String refer,
            String ip, String UA) {
        String packageName = TokenATO.wxAppID;
        if (platform == null || platform.equals("")) {
            platform = "wx_app";
        }

        switch (platform) {
            case "ios":
                packageName = TokenATO.packageName;
                break;
            case "android":
                packageName = TokenATO.boundId;
                break;
            default:
                packageName = TokenATO.wxAppID;
                break;
        }

        return new EuphonyQRDetectRequestParam(1, UUID.randomUUID().toString().replaceAll("-", ""), appkey,
                TokenATO.seckey, TokenATO.useSandbox, ip, UA, null, new App("app_name", packageName, platform),
                new Device(device_id), null);
    }

    public DetectResult queryData(EuphonyQRDetectRequestParam requestParam, String resUrl) {

        DetectResult detectResult = new DetectResult();
        Random random = new Random();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        Gson gson = new Gson();

        HttpEntity<String> request = new HttpEntity<>(gson.toJson(requestParam), headers);
        ResponseEntity<EuphonyQRDetectResult> responseEntity = restTemplate.postForEntity(resUrl, request, EuphonyQRDetectResult.class);

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            EuphonyQRDetectResult result = responseEntity.getBody();
            if (result == null || result.getMsg() == null || !result.getMsg().equals("OK")) {
                detectResult.setMsg(String.format("Server return error: %s", result.getMsg()));
            } else {
                detectResult.setMsg("OK");
                detectResult.setRecord_id(requestParam.getRequest_id());
                detectResult.setTags(makeResultTag(result.getResult()));
            }
        } else {
            detectResult.setMsg("http network error");
        }
        return detectResult;
    }

    public List<String> makeResultTag(List<Detect> detectList) {
        List<String> result = new ArrayList<>();
        if (detectList == null || detectList.isEmpty()) {
            return result;
        }
        detectList.forEach(item -> {
            if (item.getTags() != null && item.getTags().length > 0) {
                for (String s : item.getTags()) {
                    if (!result.contains(s)) {
                        result.add(s);
                    }
                }
            }
        });
        return result;
    }
}
