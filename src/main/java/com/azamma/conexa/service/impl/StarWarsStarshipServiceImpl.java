package com.azamma.conexa.service.impl;

import com.azamma.conexa.client.starwarsapi.StarWarsStarshipsApiClient;
import com.azamma.conexa.client.starwarsapi.dto.response.starships.StarshipResponseDTO;
import com.azamma.conexa.client.starwarsapi.dto.response.starships.StarshipSearchResponseDTO;
import com.azamma.conexa.client.starwarsapi.dto.response.starships.StarshipsResponseDTO;
import com.azamma.conexa.exception.ConexaBadRequestException;
import com.azamma.conexa.service.StarWarsStarshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StarWarsStarshipServiceImpl implements StarWarsStarshipService {

    public static final String SEARCH_BAD_REQUEST_MESSAGE = "Debe completarse al menos uno campo de búsqueda.";

    @Autowired
    private StarWarsStarshipsApiClient starWarsStarshipsApiClient;

    @Override
    public StarshipsResponseDTO getAllStarships(Integer page, Integer limit) {
        return this.starWarsStarshipsApiClient.getAllStarships(page, limit);
    }

    @Override
    public StarshipResponseDTO getStarshipById(int id) {
        return this.starWarsStarshipsApiClient.getStarshipById(id);
    }

    @Override
    public StarshipSearchResponseDTO searchStarships(String name, String model) {
        if (name == null && model == null)
            throw new ConexaBadRequestException(SEARCH_BAD_REQUEST_MESSAGE);
        return this.starWarsStarshipsApiClient.searchStarships(name, model);
    }

}