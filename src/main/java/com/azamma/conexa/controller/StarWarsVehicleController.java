package com.azamma.conexa.controller;

import com.azamma.conexa.client.starwarsapi.dto.response.vehicles.VehicleResponseDTO;
import com.azamma.conexa.client.starwarsapi.dto.response.vehicles.VehicleSearchResponseDTO;
import com.azamma.conexa.client.starwarsapi.dto.response.vehicles.VehiclesResponseDTO;
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
 * Controlador para gestionar los recursos de Vehicles de la API de Star Wars.
 */
@Tag(name = "Vehicles", description = "Gestión de recursos de Vehicles de Star Wars")
public interface StarWarsVehicleController {

    @Operation(summary = "Obtener todos los recursos de Vehicles.")
    @Parameters({
            @Parameter(name = "page", description = "Número de página (0..N).", required = true, in = ParameterIn.QUERY, schema = @Schema(type = "integer", defaultValue = "1")),
            @Parameter(name = "limit", description = "Número de elementos por página.", required = true, in = ParameterIn.QUERY, schema = @Schema(type = "integer", defaultValue = "10"))
    })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Los recursos de Vehicles fueron consultados correctamente", content = @Content(schema = @Schema(implementation = VehiclesResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "La petición es inválida", content = @Content(schema = @Schema(implementation = ErrorDetails.class))),
            @ApiResponse(responseCode = "500", description = "Error interno al procesar la respuesta", content = @Content(schema = @Schema(implementation = ErrorDetails.class)))
    })
    ResponseEntity<VehiclesResponseDTO> getAllVehicles(
            @RequestParam(value = "page", defaultValue = "1") @Positive @Parameter(description = "Número de página para la consulta") Integer page,
            @RequestParam(value = "limit", defaultValue = "10") @Positive @Parameter(description = "Número de elementos por página") Integer limit);

    @Operation(summary = "Buscar recursos de Vehicles por nombre y modelo.")
    @Parameters({
            @Parameter(name = "name", description = "Nombre del vehículo.", in = ParameterIn.QUERY, schema = @Schema(type = "string")),
            @Parameter(name = "model", description = "Modelo del vehículo.", in = ParameterIn.QUERY, schema = @Schema(type = "string"))
    })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Recursos de Vehicles encontrados correctamente", content = @Content(schema = @Schema(implementation = VehicleSearchResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "La petición es inválida", content = @Content(schema = @Schema(implementation = ErrorDetails.class))),
            @ApiResponse(responseCode = "500", description = "Error interno al procesar la respuesta", content = @Content(schema = @Schema(implementation = ErrorDetails.class)))
    })
    ResponseEntity<VehicleSearchResponseDTO> searchVehicles(
            @RequestParam(value = "name", required = false) @Parameter(description = "Nombre del vehículo") String name,
            @RequestParam(value = "model", required = false) @Parameter(description = "Modelo del vehículo") String model);


    @Operation(summary = "Obtener un recurso específico de Vehicles por ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "El recurso de Vehicles fue consultado correctamente", content = @Content(schema = @Schema(implementation = VehicleResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Recurso de Vehicles no encontrado"),
            @ApiResponse(responseCode = "500", description = "Error interno al procesar la respuesta")
    })
    ResponseEntity<VehicleResponseDTO> getVehicleById(
            @Parameter(description = "ID del recurso de Vehicles", required = true) @PathVariable @Positive int id);
}
