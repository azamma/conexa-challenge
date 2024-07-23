package com.azamma.conexa.service;

import com.azamma.conexa.client.starwarsapi.StarWarsStarshipsApiClient;
import com.azamma.conexa.client.starwarsapi.dto.response.starships.StarshipResponseDTO;
import com.azamma.conexa.service.impl.StarWarsStarshipServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class StarWarsStarshipServiceImplTest {

    @InjectMocks
    private StarWarsStarshipServiceImpl starWarsStarshipService;

    @Mock
    private StarWarsStarshipsApiClient starWarsStarshipsApiClient;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);  // Inicializa los mocks
    }

    @Test
    public void testGetStarshipById() {
        // Arrange
        StarshipResponseDTO mockResponse = new StarshipResponseDTO();
        mockResponse.setMessage("ok");
        StarshipResponseDTO.StarshipDetail detail = new StarshipResponseDTO.StarshipDetail();
        StarshipResponseDTO.StarshipDetail.StarshipProperties properties = new StarshipResponseDTO.StarshipDetail.StarshipProperties();
        properties.setModel("YT-1300 light freighter");
        properties.setName("Millennium Falcon");
        properties.setStarshipClass("Light freighter");
        properties.setManufacturer("Corellian Engineering Corporation");
        properties.setCostInCredits("100000");
        properties.setLength("34.37");
        properties.setCrew("4");
        properties.setPassengers("6");
        properties.setMaxAtmospheringSpeed("1050");
        properties.setHyperdriveRating("0.5");
        properties.setMGLT("75");
        properties.setCargoCapacity("100000");
        properties.setConsumables("2 months");
        properties.setPilots(Collections.singletonList("https://www.swapi.tech/api/people/13"));
        properties.setCreated("2020-09-17T17:55:06.604Z");
        properties.setEdited("2020-09-17T17:55:06.604Z");
        properties.setUrl("https://www.swapi.tech/api/starships/10");
        detail.setProperties(properties);
        detail.setDescription("A Starship");
        detail.setId("10");
        detail.setUid("10");
        detail.setVersion(0);
        mockResponse.setResult(detail);

        when(starWarsStarshipsApiClient.getStarshipById(10)).thenReturn(mockResponse);

        // Act
        StarshipResponseDTO response = starWarsStarshipService.getStarshipById(10);

        // Assert
        assertEquals("ok", response.getMessage());
        assertEquals("YT-1300 light freighter", response.getResult().getProperties().getModel());
        assertEquals("Millennium Falcon", response.getResult().getProperties().getName());
        assertEquals("Light freighter", response.getResult().getProperties().getStarshipClass());
        assertEquals("Corellian Engineering Corporation", response.getResult().getProperties().getManufacturer());
        verify(starWarsStarshipsApiClient, times(1)).getStarshipById(10);
    }
}
