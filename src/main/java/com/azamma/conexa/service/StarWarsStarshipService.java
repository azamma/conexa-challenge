package com.azamma.conexa.service;

import com.azamma.conexa.client.starwarsapi.dto.response.starships.StarshipResponseDTO;
import com.azamma.conexa.client.starwarsapi.dto.response.starships.StarshipSearchResponseDTO;
import com.azamma.conexa.client.starwarsapi.dto.response.starships.StarshipsResponseDTO;

/**
 * Servicio para interactuar con la API de Starships de Star Wars.
 * Proporciona métodos para obtener todos los recursos de Starships, para obtener un recurso específico por ID,
 * y para buscar Starships por nombre y modelo.
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

    /**
     * Busca recursos de Starships por nombre y modelo.
     *
     * @param name  El nombre del Starship para filtrar (opcional).
     * @param model El modelo del Starship para filtrar (opcional).
     * @return El objeto {@link StarshipsResponseDTO} que contiene una lista filtrada de recursos de Starships.
     */
    StarshipSearchResponseDTO searchStarships(String name, String model);
}