package com.azamma.conexa.service.impl;

import com.azamma.conexa.client.starwarsapi.StarWarsPeopleApiClient;
import com.azamma.conexa.client.starwarsapi.dto.response.people.PeopleResponseDTO;
import com.azamma.conexa.client.starwarsapi.dto.response.people.PersonDTO;
import com.azamma.conexa.service.StarWarsPeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StarWarsPeopleServiceImpl implements StarWarsPeopleService {

    @Autowired
    private StarWarsPeopleApiClient starWarsPeopleApiClient;

    @Override
    public PeopleResponseDTO getAllPeople() {
        return this.starWarsPeopleApiClient.getAllPeople();
    }

    @Override
    public PersonDTO getPersonById(int id) {
        return this.starWarsPeopleApiClient.getPersonById(id);
    }
}
