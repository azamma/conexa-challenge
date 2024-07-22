package com.azamma.conexa.service.impl;

import com.azamma.conexa.client.starwarsapi.StarWarsVehiclesApiClient;
import com.azamma.conexa.client.starwarsapi.dto.response.vehicles.VehicleResponseDTO;
import com.azamma.conexa.client.starwarsapi.dto.response.vehicles.VehiclesResponseDTO;
import com.azamma.conexa.service.StarWarsVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StarWarsVehiclesServiceImpl implements StarWarsVehicleService {

    @Autowired
    private StarWarsVehiclesApiClient starWarsVehiclesApiClient;

    @Override
    public VehiclesResponseDTO getAllVehicles(Integer page, Integer limit) {
        return this.starWarsVehiclesApiClient.getAllVehicles(page, limit);
    }

    @Override
    public VehicleResponseDTO getVehicleById(int id) {
        return this.starWarsVehiclesApiClient.getVehicleById(id);
    }

}
