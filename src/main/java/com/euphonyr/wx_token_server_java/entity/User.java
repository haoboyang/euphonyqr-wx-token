package com.euphonyr.wx_token_server_java.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;

/**
 * ClassName User
 * Descricption TOOD
 *
 * @Authorhaobaoyang
 * @Dage 2020/3/10  16:52
 * @VERSION 1.0
 **/


public class User implements Serializable {
	private static final  long SeriaUIDVersion = 1L;
	@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
	private String user_id;
	@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
	private String wx_open_id;
	@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
	private String wx_union_id;

	public User(String user_id, String wx_open_id, String wx_union_id) {
		this.user_id = user_id;
		this.wx_open_id = wx_open_id;
		this.wx_union_id = wx_union_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getWx_open_id() {
		return wx_open_id;
	}

	public void setWx_open_id(String wx_open_id) {
		this.wx_open_id = wx_open_id;
	}

	public String getWx_union_id() {
		return wx_union_id;
	}

	public void setWx_union_id(String wx_union_id) {
		this.wx_union_id = wx_union_id;
	}
}
