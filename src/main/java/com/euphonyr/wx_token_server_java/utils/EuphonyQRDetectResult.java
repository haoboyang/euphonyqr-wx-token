package com.euphonyr.wx_token_server_java.utils;

import java.util.List;

/**
 * ClassName EuphonyQRDetectResult
 * Descricption TOOD
 *
 * @Authorhaobaoyang
 * @Dage 2020/3/10  17:05
 * @VERSION 1.0
 **/


public class EuphonyQRDetectResult {
	private String msg;
	private String response_id;
	private String count;
	private List<Detect> result;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getResponse_id() {
		return response_id;
	}

	public void setResponse_id(String response_id) {
		this.response_id = response_id;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public List<Detect> getResult() {
		return result;
	}

	public void setResult(List<Detect> result) {
		this.result = result;
	}
}
