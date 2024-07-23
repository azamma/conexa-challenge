package com.azamma.conexa.controller.impl;

import com.azamma.conexa.client.starwarsapi.dto.response.films.FilmResponseDTO;
import com.azamma.conexa.client.starwarsapi.dto.response.films.FilmSearchResponseDTO;
import com.azamma.conexa.client.starwarsapi.dto.response.films.FilmsResponseDTO;
import com.azamma.conexa.controller.StarWarsFilmController;
import com.azamma.conexa.service.StarWarsFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/api/films")
@PreAuthorize("hasRole('USER_CONEXA')")
public class StarWarsFilmControllerImpl implements StarWarsFilmController {

    @Autowired
    private StarWarsFilmService starWarsFilmsService;

    @Override
    @GetMapping()
    public ResponseEntity<FilmsResponseDTO> getAllFilms() {
        FilmsResponseDTO response = starWarsFilmsService.getAllFilms();
        return ResponseEntity.ok(response);
    }

    @Override
    @GetMapping("/search")
    public ResponseEntity<FilmSearchResponseDTO> searchFilms(@RequestParam @NotBlank String title) {
        FilmSearchResponseDTO response = starWarsFilmsService.searchFilms(title);
        return ResponseEntity.ok(response);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<FilmResponseDTO> getFilmById(@PathVariable int id) {
        FilmResponseDTO response = starWarsFilmsService.getFilmById(id);
        return ResponseEntity.ok(response);
    }

}
