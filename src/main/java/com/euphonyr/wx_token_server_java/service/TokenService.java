package com.euphonyr.wx_token_server_java.service;

import com.euphonyr.wx_token_server_java.utils.DetectResult;

import java.io.Serializable;

public interface TokenService {
     /**
      *
      * 获取和刷新箧书服务器声波解析token
      * @param appkey
      * @param oldToken
      * @return
      */
     public boolean getToken(String appkey, String oldToken) ;

     /**
      * @deprecated   校验特定appid
      * @param referer  微信小程序访问连接
      * @return
      */
     public boolean checkWxAPPID(String referer) ;

     /**
      *  @deprecated 获取app识别结果
      * @return
      */
     public DetectResult getDetectResult(String appkey, String url, String platform, String device_id,
                                         String refer, String ip, String UA);

     public class QSTokenVO implements Serializable {

          private int code ;

          private String token ;

          public int getCode() {
               return code;
          }

          public void setCode(int code) {
               this.code = code;
          }

          public String getToken() {
               return token;
          }

          public void setToken(String token) {
               this.token = token;
          }
     }

}
