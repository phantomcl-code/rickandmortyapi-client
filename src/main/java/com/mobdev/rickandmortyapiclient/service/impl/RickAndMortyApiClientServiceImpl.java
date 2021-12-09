package com.mobdev.rickandmortyapiclient.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobdev.rickandmortyapiclient.exception.ResponseException;
import com.mobdev.rickandmortyapiclient.pojo.CharacterResponse;
import com.mobdev.rickandmortyapiclient.pojo.OriginEntity;
import com.mobdev.rickandmortyapiclient.pojo.response.get.GetCharacterRemoteResponse;
import com.mobdev.rickandmortyapiclient.pojo.response.get.GetLocationRemoteResponse;
import com.mobdev.rickandmortyapiclient.repository.RickAndMortyApiClientRepository;
import com.mobdev.rickandmortyapiclient.service.RickAndMortyApiClientService;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class RickAndMortyApiClientServiceImpl implements RickAndMortyApiClientService {
	
	@Autowired
	private RickAndMortyApiClientRepository rickAndMortyApiClientRepository;
	
	@Override
	public CharacterResponse getCharacterResponse(Map<String, Object> params) throws ResponseException {
		log.info("getCharacterResponse: {}", params);
		
		GetCharacterRemoteResponse getCharacterOriginResponse = rickAndMortyApiClientRepository.getCharacterResponse(params);

		CharacterResponse characterResponse = new CharacterResponse();
		characterResponse.setId(getCharacterOriginResponse.getId());
		characterResponse.setName(getCharacterOriginResponse.getName());
		characterResponse.setStatus(getCharacterOriginResponse.getStatus());
		characterResponse.setSpecies(getCharacterOriginResponse.getSpecies());
		characterResponse.setType(getCharacterOriginResponse.getType());
		characterResponse.setEpisodeCount(getCharacterOriginResponse.getEpisode().size());
		
		GetLocationRemoteResponse getLocationRemoteResponse = rickAndMortyApiClientRepository.getLocationResponse(getCharacterOriginResponse.getOrigin().getUrl());
		
		OriginEntity originEntity = new OriginEntity();
		originEntity.setName(getCharacterOriginResponse.getOrigin().getName());
		originEntity.setUrl(getCharacterOriginResponse.getOrigin().getUrl());
		originEntity.setDimension(getLocationRemoteResponse.getDimension());
		originEntity.setResidents(getLocationRemoteResponse.getResidents());
		characterResponse.setOrigin(originEntity);
		
		return characterResponse;
		
	}

}
