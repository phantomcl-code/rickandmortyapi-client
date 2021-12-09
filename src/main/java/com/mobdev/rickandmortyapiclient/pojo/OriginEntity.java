package com.mobdev.rickandmortyapiclient.pojo;

import java.util.List;

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
public class OriginEntity {
	
	@Setter
    @Getter
	private String name, url, dimension;
	
	@Setter
    @Getter
	private List<String> residents;
}
