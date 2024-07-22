package com.azamma.conexa.client.starwarsapi;

import com.azamma.conexa.client.starwarsapi.annotation.ResponseErrorMessage;
import com.azamma.conexa.client.starwarsapi.config.FeignErrorDecoder;
import com.azamma.conexa.client.starwarsapi.dto.response.vehicles.VehicleResponseDTO;
import com.azamma.conexa.client.starwarsapi.dto.response.vehicles.VehiclesResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Interfaz Feign para comunicarse con los endpoints de Vehicles de la API de Star Wars.
 */
@FeignClient(name = "star-wars-vehicles-api", url = "${feign.client.starwars-api.base-url}", configuration = FeignErrorDecoder.class)
public interface StarWarsVehiclesApiClient {

    @GetMapping(value = "${feign.client.starwars-vehicles-api.method.get-all-vehicles}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseErrorMessage(value = "Ocurrió un error al obtener los datos de Vehicles.")
    VehiclesResponseDTO getAllVehicles(@RequestParam("page") int page, @RequestParam("limit") int limit);

    @GetMapping(value = "${feign.client.starwars-vehicles-api.method.get-vehicle-by-id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseErrorMessage(value = "Ocurrió un error al obtener los datos del recurso de Vehicles.")
    VehicleResponseDTO getVehicleById(@PathVariable("id") int id);
}
