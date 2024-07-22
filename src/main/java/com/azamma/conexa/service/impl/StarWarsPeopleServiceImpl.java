package com.azamma.conexa.service.impl;

import com.azamma.conexa.client.starwarsapi.StarWarsPeopleApiClient;
import com.azamma.conexa.client.starwarsapi.dto.response.people.PeopleResponseDTO;
import com.azamma.conexa.client.starwarsapi.dto.response.people.PersonResponseDTO;
import com.azamma.conexa.service.StarWarsPeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StarWarsPeopleServiceImpl implements StarWarsPeopleService {

    @Autowired
    private StarWarsPeopleApiClient starWarsPeopleApiClient;

    @Override
    public PeopleResponseDTO getAllPeople(Integer page, Integer limit) {
        return this.starWarsPeopleApiClient.getAllPeople(page, limit);
    }

    @Override
    public PersonResponseDTO getPersonById(int id) {
        return this.starWarsPeopleApiClient.getPersonById(id);
    }
}
