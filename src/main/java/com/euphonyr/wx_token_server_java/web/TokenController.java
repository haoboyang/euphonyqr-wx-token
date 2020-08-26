package com.euphonyr.wx_token_server_java.web;

import com.euphonyr.wx_token_server_java.entity.TokenATO;
import com.euphonyr.wx_token_server_java.service.TokenService;
import com.euphonyr.wx_token_server_java.utils.DetectResult;
import com.euphonyr.wx_token_server_java.utils.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import static com.euphonyr.wx_token_server_java.utils.HttpUtils.NOT_FOUND;
import static com.euphonyr.wx_token_server_java.utils.HttpUtils.OK;

@RestController
@ResponseBody
public class TokenController {

    @Autowired
    public TokenService tokenService;

    @GetMapping(name = "生成解析token", path = "/wx/qieshutoken")
    public Result getToken(@RequestParam(value = "appkey", required = true) String appkey,
                           @RequestParam(value = "refresh", required = false) boolean refreshToken,
                           HttpServletRequest httpRequest) {

        if (!TokenATO.appkey.equals(appkey)) {
            return new Result(NOT_FOUND, "Invalid appkey ,the mini parogrm of appkey is different from" +
                    " token service ", null);
        }
        String refer = httpRequest.getHeader("Referer");
        //检查请求是否来自特定的微信小程序
        if (!tokenService.checkWxAPPID(refer)) {
            return new Result(NOT_FOUND, "Invalid appkey ,the mini parogrm of WxAPPID is different from " +
                    "token service ", null);
        } else {
            //像箧书服务器获取token
            if (StringUtils.isBlank(TokenATO.token) || refreshToken) {
                if (!tokenService.getToken(appkey, TokenATO.token)) {
                    return new Result(NOT_FOUND, "Invalid appkey or seckey  , please check server Resource " +
                            "of appkey and seckey");
                }
            }

            if (StringUtils.isBlank(TokenATO.token)) {
                return new Result(NOT_FOUND, "the server product token without empty", null);
            }
        }
        return new Result(OK, TokenATO.token);
    }

    @GetMapping(name = "获取识别结果", path = "/wx/fetchinfo")
    public DetectResult featchinfo(@RequestParam("appkey") String appkey,
                                   @RequestParam("url") String url,
                                   @RequestParam("platform") String platform,
                                   @RequestParam(value = "device_id", required = false) String device_id,
                                   HttpServletRequest httpRequest) {
        String refer = httpRequest.getHeader("referer");
        String ip = httpRequest.getHeader("X-real-ip");
        System.out.println("httpRequest.getHeader(\"url===\")" + httpRequest.getHeader("url"));
        if (ip == null || ip.equals("")) {
            String emoteAddr = httpRequest.getHeader("RemoteAddr");
            ip = StringUtils.isBlank(emoteAddr) ? "" : emoteAddr.split(":")[0];
        }
        String UA = httpRequest.getHeader("User-Agent");

        return tokenService.getDetectResult(appkey, url, platform, device_id, refer, ip, UA);
    }
}

