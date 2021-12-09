package com.mobdev.rickandmortyapiclient.service;

import java.util.Map;

import com.mobdev.rickandmortyapiclient.exception.ResponseException;
import com.mobdev.rickandmortyapiclient.pojo.CharacterResponse;


public interface RickAndMortyApiClientService {
	
	CharacterResponse getCharacterResponse(Map<String, Object> params) throws ResponseException;
	
}
