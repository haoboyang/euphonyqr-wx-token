package com.euphonyr.wx_token_server_java.utils;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * ClassName Result
 * Descricption TOOD
 *
 * @Authorhaobaoyang
 * @Dage 2018/12/23  17:15
 * @VERSION 1.0
 **/


public class Result {

    private int code ;

    @JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
    private String token ;

    @JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
    private String message;

    public Result( int code, String token ){
        this.code = code;
        this.token = token;
    }

    public Result( int code, String message, String token) {
        this.code = code;
        this.message = message;
        this.token = token;
    }

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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
