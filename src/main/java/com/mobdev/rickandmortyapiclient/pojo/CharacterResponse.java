package com.mobdev.rickandmortyapiclient.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CharacterResponse {
	@JsonPropertyOrder({ "id", "name", "status", "species", "type", "episode_count", "origin" })
	
	@Setter
    @Getter
	private int id;
	
    @Setter
    @Getter
	private String name, status, species, type;
    
	@Setter
    @Getter
    @JsonProperty("episode_count")
	private int episodeCount;
	
	@Setter
    @Getter
	private OriginEntity origin;
}
