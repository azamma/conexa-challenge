package com.azamma.conexa.controller;

import com.azamma.conexa.client.starwarsapi.dto.response.films.FilmResponseDTO;
import com.azamma.conexa.client.starwarsapi.dto.response.films.FilmSearchResponseDTO;
import com.azamma.conexa.client.starwarsapi.dto.response.films.FilmsResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

/**
 * Controlador para gestionar los recursos de Films de la API de Star Wars.
 */
@Tag(name = "Films", description = "Gestión de recursos de Films de Star Wars")
public interface StarWarsFilmController {

    @Operation(summary = "Obtener todos los recursos de Films.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Los recursos de Films fueron consultados correctamente", content = @Content(schema = @Schema(implementation = FilmsResponseDTO.class))),
            @ApiResponse(responseCode = "500", description = "Error interno al procesar la respuesta")
    })
    ResponseEntity<FilmsResponseDTO> getAllFilms();

    @Operation(summary = "Buscar Films por título.")
    @Parameters({
            @Parameter(name = "title", description = "Nombre de la película a buscar", in = ParameterIn.QUERY, schema = @Schema(type = "string"))
    })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Los resultados de la búsqueda de Films fueron consultados correctamente", content = @Content(schema = @Schema(implementation = FilmSearchResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Título de Film inválido"),
            @ApiResponse(responseCode = "500", description = "Error interno al procesar la respuesta")
    })
    ResponseEntity<FilmSearchResponseDTO> searchFilms(
            @Parameter(description = "Título del Film para buscar", required = true) @RequestParam @NotBlank String title);

    @Operation(summary = "Obtener un recurso específico de Films por ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "El recurso de Films fue consultado correctamente", content = @Content(schema = @Schema(implementation = FilmResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Recurso de Films no encontrado"),
            @ApiResponse(responseCode = "500", description = "Error interno al procesar la respuesta")
    })
    ResponseEntity<FilmResponseDTO> getFilmById(
            @Parameter(description = "ID del recurso de Films", required = true) @PathVariable @Positive int id);
}
