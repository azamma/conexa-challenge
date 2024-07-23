package com.azamma.conexa.service.impl;

import com.azamma.conexa.client.starwarsapi.StarWarsFilmsApiClient;
import com.azamma.conexa.client.starwarsapi.dto.response.films.FilmResponseDTO;
import com.azamma.conexa.client.starwarsapi.dto.response.films.FilmSearchResponseDTO;
import com.azamma.conexa.client.starwarsapi.dto.response.films.FilmsResponseDTO;
import com.azamma.conexa.exception.ConexaBadRequestException;
import com.azamma.conexa.service.StarWarsFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class StarWarsFilmServiceImpl implements StarWarsFilmService {

    public static final String SEARCH_BAD_REQUEST_MESSAGE = "El campo title debe ser completado.";

    @Autowired
    private StarWarsFilmsApiClient starWarsFilmsApiClient;

    @Override
    public FilmsResponseDTO getAllFilms() {
        return this.starWarsFilmsApiClient.getAllFilms();
    }

    @Override
    public FilmSearchResponseDTO searchFilms(String title) {
        if (Objects.equals(title, ""))
            throw new ConexaBadRequestException(SEARCH_BAD_REQUEST_MESSAGE);
        return this.starWarsFilmsApiClient.searchFilms(title);
    }

    @Override
    public FilmResponseDTO getFilmById(int id) {
        return this.starWarsFilmsApiClient.getFilmById(id);
    }

}
