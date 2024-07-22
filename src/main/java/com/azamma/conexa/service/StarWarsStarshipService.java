package com.azamma.conexa.service;

import com.azamma.conexa.client.starwarsapi.dto.response.starships.StarshipResponseDTO;
import com.azamma.conexa.client.starwarsapi.dto.response.starships.StarshipsResponseDTO;

/**
 * Servicio para interactuar con la API de Starships de Star Wars.
 * Proporciona métodos para obtener todos los recursos de Starships y para obtener un recurso específico por ID.
 */
public interface StarWarsStarshipService {

    /**
     * Obtiene todos los recursos de Starships.
     *
     * @param page  El número de página.
     * @param limit El número de elementos por página.
     * @return El objeto {@link StarshipsResponseDTO} que contiene una lista de recursos de Starships.
     */
    StarshipsResponseDTO getAllStarships(Integer page, Integer limit);

    /**
     * Obtiene un recurso específico de Starships por ID.
     *
     * @param id El ID del recurso de Starships.
     * @return El objeto {@link StarshipResponseDTO} que contiene los datos del recurso de Starships.
     */
    StarshipResponseDTO getStarshipById(int id);
}
