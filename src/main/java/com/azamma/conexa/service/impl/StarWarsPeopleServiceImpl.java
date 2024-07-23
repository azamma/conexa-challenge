package com.azamma.conexa.service.impl;

import com.azamma.conexa.client.starwarsapi.StarWarsPeopleApiClient;
import com.azamma.conexa.client.starwarsapi.dto.response.people.PeopleResponseDTO;
import com.azamma.conexa.client.starwarsapi.dto.response.people.PersonResponseDTO;
import com.azamma.conexa.client.starwarsapi.dto.response.people.PersonSearchResponseDTO;
import com.azamma.conexa.exception.ConexaBadRequestException;
import com.azamma.conexa.service.StarWarsPeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class StarWarsPeopleServiceImpl implements StarWarsPeopleService {

    public static final String SEARCH_BAD_REQUEST_MESSAGE = "El campo nombre debe ser completado.";

    @Autowired
    private StarWarsPeopleApiClient starWarsPeopleApiClient;

    @Override
    public PeopleResponseDTO getAllPeople(Integer page, Integer limit) {
        return this.starWarsPeopleApiClient.getAllPeople(page, limit);
    }

    @Override
    public PersonSearchResponseDTO searchPeople(String name) {
        if (Objects.equals(name, ""))
            throw new ConexaBadRequestException(SEARCH_BAD_REQUEST_MESSAGE);
        return this.starWarsPeopleApiClient.searchPeople(name);
    }

    @Override
    public PersonResponseDTO getPersonById(int id) {
        return this.starWarsPeopleApiClient.getPersonById(id);
    }
}
