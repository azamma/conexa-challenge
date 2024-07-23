package com.azamma.conexa.service.impl;

import com.azamma.conexa.client.starwarsapi.StarWarsVehiclesApiClient;
import com.azamma.conexa.client.starwarsapi.dto.response.vehicles.VehicleResponseDTO;
import com.azamma.conexa.client.starwarsapi.dto.response.vehicles.VehicleSearchResponseDTO;
import com.azamma.conexa.client.starwarsapi.dto.response.vehicles.VehiclesResponseDTO;
import com.azamma.conexa.exception.ConexaBadRequestException;
import com.azamma.conexa.service.StarWarsVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StarWarsVehiclesServiceImpl implements StarWarsVehicleService {

    public static final String SEARCH_BAD_REQUEST_MESSAGE = "Debe completarse al menos uno campo de búsqueda.";
    @Autowired
    private StarWarsVehiclesApiClient starWarsVehiclesApiClient;

    @Override
    public VehiclesResponseDTO getAllVehicles(Integer page, Integer limit) {
        // Llamar al cliente Feign con los parámetros de búsqueda.
        return this.starWarsVehiclesApiClient.getAllVehicles(page, limit);
    }

    @Override
    public VehicleSearchResponseDTO searchVehicles(String name, String model) {
        if (name == null && model == null)
            throw new ConexaBadRequestException(SEARCH_BAD_REQUEST_MESSAGE);
        return this.starWarsVehiclesApiClient.searchVehicles(name, model);
    }

    @Override
    public VehicleResponseDTO getVehicleById(int id) {
        return this.starWarsVehiclesApiClient.getVehicleById(id);
    }

}
