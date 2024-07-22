package com.azamma.conexa.client.starwarsapi;

import com.azamma.conexa.client.starwarsapi.annotation.ResponseErrorMessage;
import com.azamma.conexa.client.starwarsapi.config.FeignErrorDecoder;
import com.azamma.conexa.client.starwarsapi.dto.response.starships.StarshipResponseDTO;
import com.azamma.conexa.client.starwarsapi.dto.response.starships.StarshipsResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Interfaz Feign para comunicarse con los endpoints de Starships de la API de Star Wars.
 */
@FeignClient(name = "star-wars-starships-api", url = "${feign.client.starwars-api.base-url}", configuration = FeignErrorDecoder.class)
public interface StarWarsStarshipsApiClient {

    @GetMapping(value = "${feign.client.starwars-starships-api.method.get-all-starships}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseErrorMessage(value = "Ocurrió un error al obtener los datos de Starships.")
    StarshipsResponseDTO getAllStarships(@RequestParam("page") int page, @RequestParam("limit") int limit);

    @GetMapping(value = "${feign.client.starwars-starships-api.method.get-starship-by-id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseErrorMessage(value = "Ocurrió un error al obtener los datos del recurso de Starships.")
    StarshipResponseDTO getStarshipById(@PathVariable("id") int id);
}
