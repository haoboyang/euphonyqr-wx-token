package com.euphonyr.wx_token_server_java.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;

/**
 * ClassName Device
 * Descricption TOOD
 *
 * @Authorhaobaoyang
 * @Dage 2020/3/10  16:55
 * @VERSION 1.0
 **/


public class Device implements Serializable {

    private static final long SeriaUIDVersion = 1L;
    private String device_id;
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private String os;
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private String osv;
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private String device_type;
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private String brand;
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private String operator;
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private String network;
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private String lon;
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private String lat;
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private String mac;

    public Device(String device_id, String os, String osv,
                  String device_type, String brand, String operator,
                  String network, String lon, String lat, String mac) {
        this.device_id = device_id;
        this.os = os;
        this.osv = osv;
        this.device_type = device_type;
        this.brand = brand;
        this.operator = operator;
        this.network = network;
        this.lon = lon;
        this.lat = lat;
        this.mac = mac;
    }

    public Device(String device_id) {
        this.device_id = device_id;
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getOsv() {
        return osv;
    }

    public void setOsv(String osv) {
        this.osv = osv;
    }

    public String getDevice_type() {
        return device_type;
    }

    public void setDevice_type(String device_type) {
        this.device_type = device_type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    @Override
    public String toString() {
        return "Device{" +
                "device_id='" + device_id + '\'' +
                ", os='" + os + '\'' +
                ", osv='" + osv + '\'' +
                ", device_type='" + device_type + '\'' +
                ", brand='" + brand + '\'' +
                ", operator='" + operator + '\'' +
                ", network='" + network + '\'' +
                ", lon='" + lon + '\'' +
                ", lat='" + lat + '\'' +
                ", mac='" + mac + '\'' +
                '}';
    }
}
