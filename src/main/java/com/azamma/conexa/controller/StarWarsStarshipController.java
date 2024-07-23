package com.azamma.conexa.controller;

import com.azamma.conexa.client.starwarsapi.dto.response.starships.StarshipResponseDTO;
import com.azamma.conexa.client.starwarsapi.dto.response.starships.StarshipSearchResponseDTO;
import com.azamma.conexa.client.starwarsapi.dto.response.starships.StarshipsResponseDTO;
import com.azamma.conexa.exception.ErrorDetails;
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

import javax.validation.constraints.Positive;

/**
 * Controlador para gestionar los recursos de Starships de la API de Star Wars.
 * Proporciona endpoints para obtener todos los recursos de Starships y para obtener un recurso específico por ID.
 */
@Tag(name = "Starships", description = "Gestión de recursos de Starships de Star Wars")
public interface StarWarsStarshipController {

    /**
     * Obtiene todos los recursos de Starships.
     *
     * @param page  El número de página (debe ser un valor positivo).
     * @param limit El número de elementos por página (debe ser un valor positivo).
     * @return Una respuesta {@link ResponseEntity} con el objeto {@link StarshipsResponseDTO} que contiene una lista de recursos de Starships.
     */
    @Operation(summary = "Obtener todos los recursos de Starships.")
    @Parameters({
            @Parameter(name = "page", description = "Número de página (0..N).", required = true, in = ParameterIn.QUERY, schema = @Schema(type = "integer", defaultValue = "1")),
            @Parameter(name = "limit", description = "Número de elementos por página.", required = true, in = ParameterIn.QUERY, schema = @Schema(type = "integer", defaultValue = "10"))
    })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Los recursos de Starships fueron consultados correctamente", content = @Content(schema = @Schema(implementation = StarshipsResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "La petición es inválida", content = @Content(schema = @Schema(implementation = ErrorDetails.class))),
            @ApiResponse(responseCode = "500", description = "Error interno al procesar la respuesta", content = @Content(schema = @Schema(implementation = ErrorDetails.class)))
    })
    ResponseEntity<StarshipsResponseDTO> getAllStarships(
            @RequestParam(value = "page", defaultValue = "1") @Positive @Parameter(description = "Número de página para la consulta") Integer page,
            @RequestParam(value = "limit", defaultValue = "10") @Positive @Parameter(description = "Número de elementos por página") Integer limit);

    /**
     * Busca recursos de Starships con filtros.
     *
     * @param name  Nombre de la nave para filtrar.
     * @param model Modelo de la nave para filtrar.
     * @return Una respuesta {@link ResponseEntity} con el objeto {@link StarshipsResponseDTO} que contiene una lista filtrada de recursos de Starships.
     */
    @Operation(summary = "Buscar recursos de Starships con filtros.")
    @Parameters({
            @Parameter(name = "name", description = "Nombre de la nave para filtrar.", in = ParameterIn.QUERY, schema = @Schema(type = "string")),
            @Parameter(name = "model", description = "Modelo de la nave para filtrar.", in = ParameterIn.QUERY, schema = @Schema(type = "string"))
    })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Búsqueda de Starships realizada correctamente", content = @Content(schema = @Schema(implementation = StarshipsResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "La petición es inválida", content = @Content(schema = @Schema(implementation = ErrorDetails.class))),
            @ApiResponse(responseCode = "500", description = "Error interno al procesar la respuesta", content = @Content(schema = @Schema(implementation = ErrorDetails.class)))
    })
    ResponseEntity<StarshipSearchResponseDTO> searchStarships(
            @RequestParam(value = "name", required = false) @Parameter(description = "Nombre de la nave para filtrar") String name,
            @RequestParam(value = "model", required = false) @Parameter(description = "Modelo de la nave para filtrar") String model
    );

    /**
     * Obtiene un recurso específico de Starships por ID.
     *
     * @param id El ID del recurso de Starships (debe ser un valor positivo).
     * @return Una respuesta {@link ResponseEntity} con el objeto {@link StarshipResponseDTO} que contiene los datos del recurso de Starships.
     */
    @Operation(summary = "Obtener un recurso específico de Starships por ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "El recurso de Starships fue consultado correctamente", content = @Content(schema = @Schema(implementation = StarshipResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Recurso de Starships no encontrado", content = @Content(schema = @Schema(implementation = ErrorDetails.class))),
            @ApiResponse(responseCode = "500", description = "Error interno al procesar la respuesta", content = @Content(schema = @Schema(implementation = ErrorDetails.class)))
    })
    ResponseEntity<StarshipResponseDTO> getStarshipById(
            @Parameter(description = "ID del recurso de Starships", required = true) @PathVariable @Positive int id);
}
