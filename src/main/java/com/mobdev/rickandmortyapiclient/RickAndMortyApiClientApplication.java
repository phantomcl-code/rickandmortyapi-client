package com.mobdev.rickandmortyapiclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.mobdev.rickandmortyapiclient.config.Properties;


@SpringBootApplication
@EnableConfigurationProperties(Properties.class)
public class RickAndMortyApiClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(RickAndMortyApiClientApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
	   // Do any additional configuration here
	   return builder.build();
	}
}
