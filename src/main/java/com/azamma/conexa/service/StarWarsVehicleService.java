package com.azamma.conexa.service;

import com.azamma.conexa.client.starwarsapi.dto.response.vehicles.VehicleResponseDTO;
import com.azamma.conexa.client.starwarsapi.dto.response.vehicles.VehicleSearchResponseDTO;
import com.azamma.conexa.client.starwarsapi.dto.response.vehicles.VehiclesResponseDTO;

/**
 * Servicio para interactuar con la API de Vehicles de Star Wars.
 * Proporciona métodos para obtener todos los recursos de Vehicles y para obtener un recurso específico por ID.
 */
public interface StarWarsVehicleService {

    /**
     * Obtiene todos los recursos de Vehicles.
     *
     * @param page  El número de página.
     * @param limit El número de elementos por página.
     * @return El objeto {@link VehiclesResponseDTO} que contiene una lista de recursos de Vehicles.
     */
    VehiclesResponseDTO getAllVehicles(Integer page, Integer limit);

    /**
     * Busca recursos de Vehicles por nombre y modelo.
     *
     * @param name  El nombre del vehículo.
     * @param model El modelo del vehículo.
     * @return El objeto {@link VehicleSearchResponseDTO} que contiene una lista de recursos de Vehicles que coinciden con los criterios de búsqueda.
     */
    VehicleSearchResponseDTO searchVehicles(String name, String model);


    /**
     * Obtiene un recurso específico de Vehicles por ID.
     *
     * @param id El ID del recurso de Vehicles.
     * @return El objeto {@link VehicleResponseDTO} que contiene los datos del recurso de Vehicles.
     */
    VehicleResponseDTO getVehicleById(int id);
}
