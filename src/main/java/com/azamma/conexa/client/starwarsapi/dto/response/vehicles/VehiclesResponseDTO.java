package com.azamma.conexa.client.starwarsapi.dto.response.vehicles;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class VehiclesResponseDTO {
    private String message;
    private int totalRecords;
    private int totalPages;
    private String previous;
    private String next;
    private List<VehicleShortResultDTO> results;
}
