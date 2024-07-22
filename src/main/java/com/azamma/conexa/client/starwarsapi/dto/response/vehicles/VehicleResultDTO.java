package com.azamma.conexa.client.starwarsapi.dto.response.vehicles;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleResponseDTO {
    private VehicleDTO properties;
    private String description;
    private String _id;
    private String uid;
    private int __v;
}
