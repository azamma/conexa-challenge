package com.azamma.conexa.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Clase de prueba de integración para el controlador de Vehicles de Star Wars.
 * Esta clase verifica la funcionalidad de los endpoints del controlador de Vehicles a través de pruebas de integración.
 */
@SpringBootTest
@Slf4j
public class StarWarsVehicleControllerIntegrationTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    /**
     * Configura el entorno de pruebas antes de cada prueba.
     * Inicializa el objeto MockMvc que se utiliza para realizar solicitudes HTTP y verificar respuestas.
     */
    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        log.info("Se inicializa MockMvc para las pruebas de integración con swapi endpoint Vehicles.");
    }

    /**
     * Prueba la obtención de todos los recursos de Vehicles.
     * Verifica que la respuesta tenga un código de estado 200 OK, el tipo de contenido sea JSON,
     * el mensaje de la respuesta sea "ok" y que la respuesta contenga 10 elementos.
     *
     * @throws Exception Si ocurre un error al realizar la solicitud o procesar la respuesta.
     */
    @Test
    @WithMockUser(roles = "ADMIN_CONEXA")
    public void testGetAllVehicles() throws Exception {
        log.info("Testing getAllVehicles endpoint.");
        mockMvc.perform(get("/api/vehicles")
                        .param("page", "1")
                        .param("limit", "10")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message", is("ok")))
                .andExpect(jsonPath("$.results.length()", is(10)));

        log.info("getAllVehicles endpoint test passed.");
    }

    /**
     * Prueba la obtención de un recurso específico de Vehicles por ID.
     * Verifica que la respuesta tenga un código de estado 200 OK, el tipo de contenido sea JSON,
     * el mensaje de la respuesta sea "ok" y que el modelo del vehículo en la respuesta sea "FC-20 speeder bike".
     *
     * @throws Exception Si ocurre un error al realizar la solicitud o procesar la respuesta.
     */
    @Test
    @WithMockUser(roles = "ADMIN_CONEXA")
    public void testGetVehicleById() throws Exception {
        log.info("Testing getVehicleById endpoint for ID 42.");
        mockMvc.perform(get("/api/vehicles/42")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message", is("ok")))
                .andExpect(jsonPath("$.result.properties.model", is("FC-20 speeder bike")));

        log.info("getVehicleById endpoint test passed.");
    }

    /**
     * Prueba la búsqueda de vehículos por nombre.
     * Verifica que la respuesta tenga un código de estado 200 OK, el tipo de contenido sea JSON,
     * el mensaje de la respuesta sea "ok", que la respuesta contenga 1 elemento y que el nombre del vehículo en la respuesta sea "Sith speeder".
     *
     * @throws Exception Si ocurre un error al realizar la solicitud o procesar la respuesta.
     */
    @Test
    @WithMockUser(roles = "ADMIN_CONEXA")
    public void testSearchVehicles() throws Exception {
        log.info("Testing searchVehicles endpoint with name 'Sith'.");
        mockMvc.perform(get("/api/vehicles/search")
                        .param("name", "Sith")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message", is("ok")))
                .andExpect(jsonPath("$.result.length()", is(1)))
                .andExpect(jsonPath("$.result[0].properties.name", is("Sith speeder")));

        log.info("searchVehicles endpoint test passed.");
    }
}
