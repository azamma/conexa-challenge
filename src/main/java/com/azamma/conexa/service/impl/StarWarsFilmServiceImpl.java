package com.azamma.conexa.service.impl;

import com.azamma.conexa.client.starwarsapi.StarWarsFilmsApiClient;
import com.azamma.conexa.client.starwarsapi.dto.response.films.FilmResponseDTO;
import com.azamma.conexa.client.starwarsapi.dto.response.films.FilmResultDTO;
import com.azamma.conexa.client.starwarsapi.dto.response.films.FilmsResponseDTO;
import com.azamma.conexa.service.StarWarsFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StarWarsFilmServiceImpl implements StarWarsFilmService {

    @Autowired
    private StarWarsFilmsApiClient starWarsFilmsApiClient;

    @Override
    public FilmsResponseDTO getAllFilms() {
        return this.starWarsFilmsApiClient.getAllFilms();
    }

    @Override
    public FilmResponseDTO getFilmById(int id) {
        return this.starWarsFilmsApiClient.getFilmById(id);
    }

}
