package com.mobdev.rickandmortyapiclient.repository;

import java.util.Map;

import com.mobdev.rickandmortyapiclient.exception.ResponseException;
import com.mobdev.rickandmortyapiclient.pojo.response.get.GetCharacterRemoteResponse;
import com.mobdev.rickandmortyapiclient.pojo.response.get.GetLocationRemoteResponse;

public interface RickAndMortyApiClientRepository {

	GetCharacterRemoteResponse getCharacterResponse(Map<String, Object> params) throws ResponseException;
	GetLocationRemoteResponse getLocationResponse(String url) throws ResponseException;
}
