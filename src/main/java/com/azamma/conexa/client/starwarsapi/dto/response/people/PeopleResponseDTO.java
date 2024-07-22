package com.azamma.conexa.client.starwarsapi.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PeopleResponseDTO {
    private int count;
    private List<PersonDTO> results;
}
