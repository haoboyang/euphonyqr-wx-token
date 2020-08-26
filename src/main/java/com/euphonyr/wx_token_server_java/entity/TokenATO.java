package com.euphonyr.wx_token_server_java.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * ClassName TokenATO
 * Descricption TOOD
 *
 * @Authorhaobaoyang
 * @Dage 2018/12/23  17:16
 * @VERSION 1.0
 **/

@Component
public class TokenATO {

    public static String appkey;

    public static String seckey;

    public static String token;

    public static String wxAppID;

    public static String packageName;

    public static String boundId;

    public static boolean useSandbox;

    public static boolean checkWxAPPID;

    public static String checkWxPrefix = "https://servicewechat.com/";

    @Value("${QIESHU.APPKEY}")
    public void setAppkey(String appkey) {
        TokenATO.appkey = appkey;
    }

    @Value("${QIESHU.SECKEY}")
    public void setSeckey(String seckey) {
        TokenATO.seckey = seckey;
    }

    public void setToken(String token) {
        TokenATO.token = token;
    }

    @Value("${QIESHU.WXAPPID}")
    public void setWxAppID(String wxAppID) {
        TokenATO.wxAppID = wxAppID;
    }

    @Value("${QIESHU.PACKAGE_NAME}")
    public static void setPackageName(String packageName) {
        TokenATO.packageName = packageName;
    }

    @Value("${QIESHU.BOUND_ID}")
    public static void setBoundId(String boundId) {
        TokenATO.boundId = boundId;
    }

    @Value("${QIESHU.SANDBOX}")
    public void setUseSandbox(boolean useSandbox) {
        TokenATO.useSandbox = useSandbox;
    }

    @Value("${QIESHU.CHECKWXAPPID}")
    public void setCheckWxAPPID(boolean checkWxAPPID) {
        TokenATO.checkWxAPPID = checkWxAPPID;
    }

    @Value("${QIESHU.WXAPPID}")
    public void setCheckWxPrefix(String wxAppID) {
        TokenATO.checkWxPrefix = checkWxPrefix + wxAppID + "/";
    }
}
