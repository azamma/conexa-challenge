package com.azamma.conexa.client.starwarsapi.dto.response.films;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilmResponseDTO {
    private String message;
    private FilmResultDTO result;
}
