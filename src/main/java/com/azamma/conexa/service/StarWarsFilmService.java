package com.azamma.conexa.service;

import com.azamma.conexa.client.starwarsapi.dto.response.films.FilmResponseDTO;
import com.azamma.conexa.client.starwarsapi.dto.response.films.FilmSearchResponseDTO;
import com.azamma.conexa.client.starwarsapi.dto.response.films.FilmsResponseDTO;

/**
 * Servicio para interactuar con la API de Films de Star Wars.
 * Proporciona métodos para obtener todos los recursos de Films y para obtener un recurso específico por ID.
 */
public interface StarWarsFilmService {

    /**
     * Obtiene todos los recursos de Films.
     *
     * @return El objeto {@link FilmsResponseDTO} que contiene una lista de recursos de Films.
     */
    FilmsResponseDTO getAllFilms();

    /**
     * Busca Films por título.
     *
     * @param title El título del Film para buscar.
     * @return Un objeto {@link FilmSearchResponseDTO} que contiene los resultados de la búsqueda.
     */
    FilmSearchResponseDTO searchFilms(String title);

    /**
     * Obtiene un recurso específico de Films por ID.
     *
     * @param id El ID del recurso de Films.
     * @return El objeto {@link FilmResponseDTO} que contiene los datos del recurso de Films.
     */
    FilmResponseDTO getFilmById(int id);
}
