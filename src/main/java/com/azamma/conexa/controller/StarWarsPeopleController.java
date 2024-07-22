package com.azamma.conexa.controller;

import com.azamma.conexa.client.starwarsapi.dto.response.people.PeopleResponseDTO;
import com.azamma.conexa.client.starwarsapi.dto.response.people.PersonResponseDTO;
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
 * Controlador para gestionar los recursos de People de la API de Star Wars.
 */
@Tag(name = "People", description = "Gestión de recursos de People de Star Wars")
public interface StarWarsPeopleController {

    @Operation(summary = "Obtener todos los recursos de People.")
    @Parameters({
            @Parameter(name = "page", description = "Número de página (0..N).", required = true, in = ParameterIn.QUERY, schema = @Schema(type = "integer", defaultValue = "1")),
            @Parameter(name = "limit", description = "Número de elementos por página.", required = true, in = ParameterIn.QUERY, schema = @Schema(type = "integer", defaultValue = "10"))
    })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Los recursos de People fueron consultados correctamente", content = @Content(schema = @Schema(implementation = PeopleResponseDTO.class))),
            @ApiResponse(responseCode = "500", description = "Error interno al procesar la respuesta")
    })
    ResponseEntity<PeopleResponseDTO> getAllPeople(
            @RequestParam(value = "page", defaultValue = "1") @Positive @Parameter(description = "Número de página para la consulta") Integer page,
            @RequestParam(value = "limit", defaultValue = "10") @Positive @Parameter(description = "Número de elementos por página") Integer limit);

    @Operation(summary = "Obtener un recurso específico de People por ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "El recurso de People fue consultado correctamente", content = @Content(schema = @Schema(implementation = PersonResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Recurso de People no encontrado"),
            @ApiResponse(responseCode = "500", description = "Error interno al procesar la respuesta")
    })
    ResponseEntity<PersonResponseDTO> getPersonById(
            @Parameter(description = "ID del recurso de People", required = true) @PathVariable @Positive int id);

}
