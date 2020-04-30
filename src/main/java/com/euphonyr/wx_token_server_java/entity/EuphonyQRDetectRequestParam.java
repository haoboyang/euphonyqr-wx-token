package com.euphonyr.wx_token_server_java.entity;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;


/**
 * ClassName EuphonyQRDetectRequestParam
 * Descricption TOOD
 *
 * @Authorhaobaoyang
 * @Dage 2020/3/10  16:42
 * @VERSION 1.0
 **/


public class EuphonyQRDetectRequestParam implements Serializable {
	private int version;
	@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
	private String request_id;
	private String appkey;
	private String seckey;
	@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
	private boolean test;
	@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
	private String ip;
	@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
	private String user_agent;
	@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
	private String language;
	private App App;
	private Device Device;
	private User User;

	public EuphonyQRDetectRequestParam(int version, String request_id, String appkey,
		String seckey, boolean test, String ip, String user_agent, String language,
		App app,
		Device device,
		User user) {
		this.version = version;
		this.request_id = request_id;
		this.appkey = appkey;
		this.seckey = seckey;
		this.test = test;
		this.ip = ip;
		this.user_agent = user_agent;
		this.language = language;
		App = app;
		Device = device;
		User = user;
	}

	@Override
	public String toString() {
		return "EuphonyQRDetectRequestParam{" +
				"version=" + version +
				", request_id='" + request_id + '\'' +
				", appkey='" + appkey + '\'' +
				", seckey='" + seckey + '\'' +
				", test=" + test +
				", ip='" + ip + '\'' +
				", user_agent='" + user_agent + '\'' +
				", language='" + language + '\'' +
				", App=" + App +
				", Device=" + Device +
				", User=" + User +
				'}';
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getRequest_id() {
		return request_id;
	}

	public void setRequest_id(String request_id) {
		this.request_id = request_id;
	}

	public String getAppkey() {
		return appkey;
	}

	public void setAppkey(String appkey) {
		this.appkey = appkey;
	}

	public String getSeckey() {
		return seckey;
	}

	public void setSeckey(String seckey) {
		this.seckey = seckey;
	}

	public boolean isTest() {
		return test;
	}

	public void setTest(boolean test) {
		this.test = test;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getUser_agent() {
		return user_agent;
	}

	public void setUser_agent(String user_agent) {
		this.user_agent = user_agent;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public App getApp() {
		return App;
	}

	public void setApp(App app) {
		App = app;
	}

	public Device getDevice() {
		return Device;
	}

	public void setDevice(Device device) {
		Device = device;
	}

	public User getUser() {
		return User;
	}

	public void setUser(User user) {
		User = user;
	}
}
