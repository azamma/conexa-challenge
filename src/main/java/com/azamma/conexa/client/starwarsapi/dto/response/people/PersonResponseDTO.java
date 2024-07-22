package com.azamma.conexa.client.starwarsapi.dto.response.people;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonResponseDTO {
    private String message;
    private PersonResultDTO result;
}
