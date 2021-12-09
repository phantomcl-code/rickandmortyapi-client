package com.mobdev.rickandmortyapiclient.pojo.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DetailResponse {

	@JsonProperty("code")
	private String code;

	@JsonProperty("message")
	private String message;

	public DetailResponse(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public DetailResponse() {
		super();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "DetailResponse [code=" + code + ", message=" + message + "]";
	}

}
