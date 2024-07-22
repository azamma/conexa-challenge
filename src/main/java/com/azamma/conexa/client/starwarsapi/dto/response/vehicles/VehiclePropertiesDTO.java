package com.azamma.conexa.client.starwarsapi.dto.response.vehicles;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class VehicleDTO {
    private String name;
    private String model;
    private String manufacturer;
    private String costInCredits;
    private String length;
    private String maxAtmospheringSpeed;
    private String crew;
    private String passengers;
    private String cargoCapacity;
    private String consumables;
    private String vehicleClass;
    private List<String> pilots;
    private List<String> films;
    private String created;
    private String edited;
    private String url;
}
