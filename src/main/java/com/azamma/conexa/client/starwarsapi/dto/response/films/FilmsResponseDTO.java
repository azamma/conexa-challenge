package com.azamma.conexa.client.starwarsapi.dto.response.films;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FilmsResponseDTO {

    private String message;
    private List<FilmResultDTO> result;
}
