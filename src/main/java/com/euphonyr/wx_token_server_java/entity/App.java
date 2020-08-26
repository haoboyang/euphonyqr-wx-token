package com.euphonyr.wx_token_server_java.entity;

import java.io.Serializable;

/**
 * ClassName App
 * Descricption TOOD
 *
 * @Authorhaobaoyang
 * @Dage 2020/3/10  16:49
 * @VERSION 1.0
 **/


public class App implements Serializable {
    private static final long SeriaUIDVersion = 1L;
    private String app_name;
    private String package_name;
    private String platform;

    public App(String app_name, String package_name, String platform) {
        this.app_name = app_name;
        this.package_name = package_name;
        this.platform = platform;
    }

    public String getApp_name() {
        return app_name;
    }

    public void setApp_name(String app_name) {
        this.app_name = app_name;
    }

    public String getPackage_name() {
        return package_name;
    }

    public void setPackage_name(String package_name) {
        this.package_name = package_name;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    @Override
    public String toString() {
        return "App{" +
                "app_name='" + app_name + '\'' +
                ", package_name='" + package_name + '\'' +
                ", platform='" + platform + '\'' +
                '}';
    }
}
