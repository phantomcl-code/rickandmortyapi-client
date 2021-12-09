package com.mobdev.rickandmortyapiclient.pojo.response.get;

import java.util.List;

import com.mobdev.rickandmortyapiclient.pojo.OriginRemoteEntity;

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
public class GetCharacterRemoteResponse {

	@Setter
    @Getter
	private int id;
	
    @Setter
    @Getter
    private String name, status, species, type;
    
    @Setter
    @Getter
    private List<String> episode;
    
    @Setter
    @Getter
    private OriginRemoteEntity origin;
    
    
}
