package com.azamma.conexa.client.starwarsapi;

import com.azamma.conexa.client.starwarsapi.annotation.ResponseErrorMessage;
import com.azamma.conexa.client.starwarsapi.config.FeignErrorDecoder;
import com.azamma.conexa.client.starwarsapi.dto.response.people.PeopleResponseDTO;
import com.azamma.conexa.client.starwarsapi.dto.response.people.PersonResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Interfaz Feign para comunicarse con los endpoints de People de la API de Star Wars.
 */
@FeignClient(name = "star-wars-people-api", url = "${feign.client.starwars-api.base-url}", configuration = FeignErrorDecoder.class)
public interface StarWarsPeopleApiClient {

    @GetMapping(value = "${feign.client.starwars-people-api.method.get-all-people}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseErrorMessage(value = "Ocurrió un error al obtener los datos de People.")
    PeopleResponseDTO getAllPeople(@RequestParam("page") int page, @RequestParam("limit") int limit);

    @GetMapping(value = "${feign.client.starwars-people-api.method.get-person-by-id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseErrorMessage(value = "Ocurrió un error al obtener los datos del recurso de People.")
    PersonResponseDTO getPersonById(@PathVariable("id") int id);
}
