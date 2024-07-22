package com.azamma.conexa.service.impl;

import com.azamma.conexa.client.starwarsapi.StarWarsStarshipsApiClient;
import com.azamma.conexa.client.starwarsapi.dto.response.starships.StarshipResponseDTO;
import com.azamma.conexa.client.starwarsapi.dto.response.starships.StarshipsResponseDTO;
import com.azamma.conexa.exception.ConexaBadRequestException;
import com.azamma.conexa.service.StarWarsStarshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StarWarsStarshipServiceImpl implements StarWarsStarshipService {

    @Autowired
    private StarWarsStarshipsApiClient starWarsStarshipsApiClient;

    @Override
    public StarshipsResponseDTO getAllStarships(Integer page, Integer limit) {
        if (page == null || limit == null || page <= 0 || limit <= 0) {
            throw new ConexaBadRequestException("Page and limit parameters must be provided and greater than zero", "400");
        }
        return this.starWarsStarshipsApiClient.getAllStarships(page, limit);
    }

    @Override
    public StarshipResponseDTO getStarshipById(int id) {
        return this.starWarsStarshipsApiClient.getStarshipById(id);
    }
}
