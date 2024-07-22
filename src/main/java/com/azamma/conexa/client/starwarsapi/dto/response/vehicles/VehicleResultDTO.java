package com.azamma.conexa.client.starwarsapi.dto.response.vehicles;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleResultDTO {
    private VehiclePropertiesDTO properties;
    private String description;
    private String _id;
    private String uid;
    private int __v;
}
