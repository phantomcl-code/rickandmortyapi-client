package com.mobdev.rickandmortyapiclient.pojo.response;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mobdev.rickandmortyapiclient.exception.ResponseException;
import com.mobdev.rickandmortyapiclient.exception.StatusResponseEnum;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "result", "status" })
public class GenericResponse {

	@JsonProperty("result")
	@JsonAlias({"result", "success"})
	private Boolean success;
	
	@JsonProperty("status")
	@JsonAlias({"status", "return"})
	private DetailResponse detailResponse;

	public GenericResponse(ResponseException e) {
		super();
		this.success = false;
		this.detailResponse = new DetailResponse(e.getStatusResponseEnum().getStatusCode(), e.getMessage());
	}
	
	public GenericResponse(Boolean success, DetailResponse detailResponse) {
		super();
		this.success = success;
		this.detailResponse = detailResponse;
	}

	public GenericResponse(Exception e) {
		super();
		this.success = false;
		this.detailResponse = new DetailResponse(StatusResponseEnum.INTERNAL_SERVER_ERROR.getStatusCode(),
				e.getMessage());
	}
	
	public GenericResponse() {
		super();
	}

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

}
