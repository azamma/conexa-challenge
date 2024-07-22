package com.azamma.conexa.client.starwarsapi;

import com.azamma.conexa.client.starwarsapi.annotation.ResponseErrorMessage;
import com.azamma.conexa.client.starwarsapi.config.FeignErrorDecoder;
import com.azamma.conexa.client.starwarsapi.dto.response.films.FilmResponseDTO;
import com.azamma.conexa.client.starwarsapi.dto.response.films.FilmsResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Interfaz Feign para comunicarse con los endpoints de Films de la API de Star Wars.
 */
@FeignClient(name = "star-wars-films-api", url = "${feign.client.starwars-api.base-url}", configuration = FeignErrorDecoder.class)
public interface StarWarsFilmsApiClient {

    @GetMapping(value = "${feign.client.starwars-films-api.method.get-all-films}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseErrorMessage(value = "Ocurrió un error al obtener los datos de Films.")
    FilmsResponseDTO getAllFilms();

    @GetMapping(value = "${feign.client.starwars-films-api.method.get-film-by-id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseErrorMessage(value = "Ocurrió un error al obtener los datos del recurso de Films.")
    FilmResponseDTO getFilmById(@PathVariable("id") int id);
}
