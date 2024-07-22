package com.azamma.conexa.client.starwarsapi.dto.response.starships;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StarshipDTO {
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
    private String hyperdriveRating;
    private String mglt;
    private String starshipClass;
    private List<String> pilots;
    private List<String> films;
    private String created;
    private String edited;
    private String url;
}
