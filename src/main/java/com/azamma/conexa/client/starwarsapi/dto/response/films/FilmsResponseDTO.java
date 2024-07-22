package com.azamma.conexa.client.starwarsapi.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FilmsResponseDTO {
    private int count;
    private List<FilmDTO> results;
}
