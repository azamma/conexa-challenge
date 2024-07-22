package com.azamma.conexa.client.starwarsapi.dto.response.vehicles;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleResponseDTO {
    private String message;
    private VehicleResultDTO result;
}
