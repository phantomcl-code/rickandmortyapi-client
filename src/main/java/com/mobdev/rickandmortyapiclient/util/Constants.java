package com.mobdev.rickandmortyapiclient.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Constants {
	// respuestas Apis
	public static final String NO_DATA_FOUND_REQUEST = "No se han encontrado resultados";
	public static final String OK_REQUEST = "Respuesta exitosa";
	public static final String OK_CREATED = "Creado exitosamente";
	public static final String INVALID_DATA = "Tipo de campo inválido: ";
	public static final String NULL_DATA = "Campo Nulo: ";
	public static final String EMPTY_DATA = "Campo Vacio: ";
	public static final String EXCEEDS_MAXIMUM = "Excede el largo maximo: ";

	public static final String ID = "Id";
	public static final String NAME = "Name";
	
	// numeros
	public static final int LENGTH_3 = 3;
	
	// expresiones regulares de validacion
	public static final String REGEX_NUMBERS = "[0-9]*";
	
	public static final String URIRICKANDMORTY = "uriRickAndMorty";
}
