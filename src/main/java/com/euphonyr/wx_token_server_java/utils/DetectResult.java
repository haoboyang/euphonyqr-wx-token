package com.euphonyr.wx_token_server_java.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName DetectResult
 * Descricption TOOD
 *
 * @Authorhaobaoyang
 * @Dage 2020/3/10  16:37
 * @VERSION 1.0
 **/


public class DetectResult {
	private String msg;
	private List<String> tags = new ArrayList<>();
	private String record_id;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public String getRecord_id() {
		return record_id;
	}

	public void setRecord_id(String record_id) {
		this.record_id = record_id;
	}


}
