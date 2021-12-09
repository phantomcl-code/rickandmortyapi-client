package com.mobdev.rickandmortyapiclient.pojo.request;

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
public class CharacterEntity {
    @Setter
    @Getter
    private String id;
}
