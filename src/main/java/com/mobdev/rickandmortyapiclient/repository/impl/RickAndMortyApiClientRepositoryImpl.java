package com.mobdev.rickandmortyapiclient.repository.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.mobdev.rickandmortyapiclient.config.Properties;
import com.mobdev.rickandmortyapiclient.exception.ResponseException;
import com.mobdev.rickandmortyapiclient.pojo.response.get.GetCharacterRemoteResponse;
import com.mobdev.rickandmortyapiclient.pojo.response.get.GetLocationRemoteResponse;
import com.mobdev.rickandmortyapiclient.repository.RickAndMortyApiClientRepository;
import com.mobdev.rickandmortyapiclient.util.Constants;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class RickAndMortyApiClientRepositoryImpl implements RickAndMortyApiClientRepository {
	@Autowired
	private Properties properties;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public GetCharacterRemoteResponse getCharacterResponse(Map<String, Object> params) throws ResponseException {
		log.info("getCharacterResponse: {}", params);
		
		String uriApiRickAndMorty = properties.getProperties().get(Constants.URIRICKANDMORTY) + params.get(Constants.ID);
		log.info("uriApiRickAndMorty: {}", uriApiRickAndMorty);
		
		GetCharacterRemoteResponse respuesta = null;
		try {
			respuesta = restTemplate.getForObject(uriApiRickAndMorty, GetCharacterRemoteResponse.class);
			
		} catch(HttpClientErrorException e) {
			log.error("HttpClientErrorException: {}", e.getMessage());
		}
		
		return respuesta;
	}
	
	public GetLocationRemoteResponse getLocationResponse(String uri) throws ResponseException {
		log.info("getCharacterResponse: {}", uri);
		
		log.info("uri: {}", uri);
		
		GetLocationRemoteResponse respuesta = null;
		try {
			respuesta = restTemplate.getForObject(uri, GetLocationRemoteResponse.class);
			
		} catch(HttpClientErrorException e) {
			log.error("HttpClientErrorException: {}", e.getMessage());
		}
		
		return respuesta;
	}
	
}
