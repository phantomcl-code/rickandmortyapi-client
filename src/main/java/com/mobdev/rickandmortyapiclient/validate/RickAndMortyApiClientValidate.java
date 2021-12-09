package com.mobdev.rickandmortyapiclient.validate;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobdev.rickandmortyapiclient.exception.ResponseException;
import com.mobdev.rickandmortyapiclient.exception.StatusResponseEnum;
import com.mobdev.rickandmortyapiclient.pojo.request.CharacterEntity;
import com.mobdev.rickandmortyapiclient.util.Constants;
import com.mobdev.rickandmortyapiclient.util.ValidateUtil;


public class RickAndMortyApiClientValidate {
	public static final Logger LOG_ERROR = LoggerFactory.getLogger("error");
	public static final Logger LOGGER = LoggerFactory.getLogger("info");
	
	private RickAndMortyApiClientValidate() {
		throw new IllegalStateException("Utility class");
	}
	
	public static Map<String, Object> validateGetCharacter(CharacterEntity body) throws ResponseException {

		Map<String, Object> params = new HashMap<>();
		String id = body.getId();
		
		ValidateUtil.validateData(Constants.ID, id, Constants.LENGTH_3, Constants.REGEX_NUMBERS, true);
		
		params.put(Constants.ID, id);
		
		if(Integer.parseInt(id)>826) {
			throw new ResponseException("solo hay 826 personajes en la lista", StatusResponseEnum.PRECONDITION_FAILED, true);
		}
		
		return params;
	}
}
