package com.mobdev.rickandmortyapiclient.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mobdev.rickandmortyapiclient.exception.ResponseException;
import com.mobdev.rickandmortyapiclient.pojo.CharacterResponse;
import com.mobdev.rickandmortyapiclient.pojo.request.CharacterEntity;
import com.mobdev.rickandmortyapiclient.pojo.response.DetailResponse;
import com.mobdev.rickandmortyapiclient.pojo.response.GenericResponse;
import com.mobdev.rickandmortyapiclient.pojo.response.get.GetCharacterResponse;
import com.mobdev.rickandmortyapiclient.service.RickAndMortyApiClientService;

import com.mobdev.rickandmortyapiclient.util.Constants;
import com.mobdev.rickandmortyapiclient.validate.RickAndMortyApiClientValidate;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class RickAndMortyApiClientController {
	
	public static final Logger LOG_ERROR = LoggerFactory.getLogger("error");
	
	@Autowired
	private RickAndMortyApiClientService rickAndMortyApiClientService;
	
	@ControllerAdvice
	public class ErrorHandler {
		@ExceptionHandler(ResponseException.class)
		public ResponseEntity<GenericResponse> methodCatchResponseException(HttpServletRequest request,
				ResponseException e) {
			LOG_ERROR.error("Error info ", e);
			GenericResponse errorInfo = new GenericResponse(e);
			return new ResponseEntity<>(errorInfo,
					HttpStatus.valueOf(Integer.parseInt(e.getStatusResponseEnum().getStatusCode())));
		}

		@ExceptionHandler(Exception.class)
		public ResponseEntity<GenericResponse> methodCatchException(HttpServletRequest request, Exception e) {
			GenericResponse errorInfo = new GenericResponse(e);
			LOG_ERROR.error("BAD REQUEST : ", e);
			return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/")
	public String apiTest() {
		log.info("Inicio apiTest endpoint");
		return "Api responde.";
	}
	
	@PostMapping(value = "/character", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value = "Obtencion de un personaje mediante el id")
	@CrossOrigin
	@ApiResponses(value = { @ApiResponse(code = 200, message = "La solicitud fue exitosa", response = Integer[].class),
			@ApiResponse(code = 204, message = "No se encontraron registros", response = GenericResponse.class),
			@ApiResponse(code = 400, message = "Existen en errores de validación", response = GenericResponse.class),
			@ApiResponse(code = 500, message = "Ha ocurrido un error interno", response = GenericResponse.class) })
	public ResponseEntity<GetCharacterResponse> getCharacter(@RequestBody(required = true) CharacterEntity body)
			throws IOException, ResponseException, ParseException {

		log.info("Inicio getCharacter endpoint");

		log.info("::Parametros de entrada desde el canal");
		log.info(body.toString());

		//Genera params
		Map<String, Object> params = RickAndMortyApiClientValidate.validateGetCharacter(body);
		
		//Obtiene data BD
		CharacterResponse characterResponse = rickAndMortyApiClientService.getCharacterResponse(params);
		
		
		List<CharacterResponse> listCharacterResponse = new ArrayList<>();
		listCharacterResponse.add(characterResponse);
		
		GetCharacterResponse respuesta = new GetCharacterResponse();
		DetailResponse detailResponse = new DetailResponse(HttpStatus.OK.toString(), Constants.OK_REQUEST);
		respuesta.setSuccess(true);
		respuesta.setBody(listCharacterResponse);
		
		if (listCharacterResponse == null || listCharacterResponse.isEmpty()) {
			detailResponse = new DetailResponse(HttpStatus.NO_CONTENT.toString(), Constants.NO_DATA_FOUND_REQUEST);
		}

		respuesta.setDetailResponse(detailResponse);

		return new ResponseEntity<>(respuesta, HttpStatus.OK);

	}

}
