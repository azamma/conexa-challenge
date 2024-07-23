package com.azamma.conexa.controller.impl;

import com.azamma.conexa.client.starwarsapi.dto.response.people.PeopleResponseDTO;
import com.azamma.conexa.client.starwarsapi.dto.response.people.PersonResponseDTO;
import com.azamma.conexa.client.starwarsapi.dto.response.people.PersonSearchResponseDTO;
import com.azamma.conexa.controller.StarWarsPeopleController;
import com.azamma.conexa.service.StarWarsPeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/people")
@PreAuthorize("hasRole('USER_CONEXA')")
public class StarWarsPeopleControllerImpl implements StarWarsPeopleController {

    @Autowired
    private StarWarsPeopleService starWarsPeopleService;

    @Override
    @GetMapping()
    public ResponseEntity<PeopleResponseDTO> getAllPeople(
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "limit", required = false, defaultValue = "10") Integer limit) {
        PeopleResponseDTO response = starWarsPeopleService.getAllPeople(page, limit);
        return ResponseEntity.ok(response);
    }

    @Override
    @GetMapping("/search")
    public ResponseEntity<PersonSearchResponseDTO> searchPeople(
            @RequestParam(value = "name") String name) {
        PersonSearchResponseDTO response = starWarsPeopleService.searchPeople(name);
        return ResponseEntity.ok(response);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<PersonResponseDTO> getPersonById(@PathVariable int id) {
        PersonResponseDTO response = starWarsPeopleService.getPersonById(id);
        return ResponseEntity.ok(response);
    }
}
