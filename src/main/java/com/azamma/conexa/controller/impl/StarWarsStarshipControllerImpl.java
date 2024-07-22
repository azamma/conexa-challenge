package com.azamma.conexa.controller.impl;

import com.azamma.conexa.client.starwarsapi.dto.response.starships.StarshipResponseDTO;
import com.azamma.conexa.client.starwarsapi.dto.response.starships.StarshipsResponseDTO;
import com.azamma.conexa.controller.StarWarsStarshipController;
import com.azamma.conexa.service.StarWarsStarshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/starships")
public class StarWarsStarshipControllerImpl implements StarWarsStarshipController {

    @Autowired
    private StarWarsStarshipService starWarsStarshipsService;

    @Override
    @GetMapping()
    public ResponseEntity<StarshipsResponseDTO> getAllStarships(
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "limit", required = false, defaultValue = "10") Integer limit) {
        StarshipsResponseDTO response = this.starWarsStarshipsService.getAllStarships(page, limit);
        return ResponseEntity.ok(response);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<StarshipResponseDTO> getStarshipById(@PathVariable int id) {
        StarshipResponseDTO response = this.starWarsStarshipsService.getStarshipById(id);
        return ResponseEntity.ok(response);
    }
}
