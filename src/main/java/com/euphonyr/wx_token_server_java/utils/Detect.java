package com.euphonyr.wx_token_server_java.utils;

/**
 * ClassName Detect
 * Descricption TOOD
 *
 * @Authorhaobaoyang
 * @Dage 2020/3/10  17:09
 * @VERSION 1.0
 **/


public class Detect {
    private String[] tags;
    private double power;
    private int channel;
    private double distance;
    private double range;

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getRange() {
        return range;
    }

    public void setRange(double range) {
        this.range = range;
    }
}
