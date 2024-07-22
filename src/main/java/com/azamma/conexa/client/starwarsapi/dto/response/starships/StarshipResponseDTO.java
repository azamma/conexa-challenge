package com.azamma.conexa.client.starwarsapi.dto.response.starships;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StarshipResponseDTO {
    private String message;
    private StarshipResultDTO result;
}
