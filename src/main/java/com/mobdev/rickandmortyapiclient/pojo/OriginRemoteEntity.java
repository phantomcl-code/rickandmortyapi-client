package com.mobdev.rickandmortyapiclient.pojo;

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
public class OriginRemoteEntity {
	
	@Setter
    @Getter
	private String name, url;
}
