package com.mobdev.rickandmortyapiclient.pojo.response.get;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mobdev.rickandmortyapiclient.pojo.CharacterResponse;
import com.mobdev.rickandmortyapiclient.pojo.response.DetailResponse;


public class GetCharacterResponse {

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonPropertyOrder({ "success", "return", "body" })
	
	@JsonProperty("success")
	private boolean success;
	
	@JsonProperty("return")
	private DetailResponse detailResponse;
	
	@JsonProperty("body")
	private List<CharacterResponse> body;

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public DetailResponse getDetailResponse() {
		return detailResponse;
	}

	public void setDetailResponse(DetailResponse detailResponse) {
		this.detailResponse = detailResponse;
	}

	public List<CharacterResponse> getBody() {
		return body;
	}

	public void setBody(List<CharacterResponse> body) {
		this.body = body;
	}
}
