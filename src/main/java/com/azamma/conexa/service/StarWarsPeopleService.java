package com.azamma.conexa.service;

import com.azamma.conexa.client.starwarsapi.dto.response.people.PeopleResponseDTO;
import com.azamma.conexa.client.starwarsapi.dto.response.people.PersonResponseDTO;
import com.azamma.conexa.client.starwarsapi.dto.response.people.PersonSearchResponseDTO;

public interface StarWarsPeopleService {

    /**
     * Obtiene todos los recursos de People.
     *
     * @return El objeto {@link PeopleResponseDTO} que contiene los datos de People.
     */
    PeopleResponseDTO getAllPeople(Integer page, Integer limit);

    /**
     * Obtiene un recurso específico de People por ID.
     *
     * @param id El ID del recurso de People.
     * @return El objeto {@link PersonResponseDTO} que contiene los datos del recurso de People.
     */
    PersonResponseDTO getPersonById(int id);

    /**
     * Busca recursos de People con filtros.
     *
     * @param name Nombre de la persona para filtrar.
     * @return El objeto {@link PersonSearchResponseDTO} que contiene los datos filtrados de People.
     */
    PersonSearchResponseDTO searchPeople(String name);

}