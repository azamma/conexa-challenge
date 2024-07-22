package com.azamma.conexa.client.starwarsapi.dto.response.starships;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StarshipResultDTO {
    private StarshipPropertiesDTO properties;
    private String description;
    private String _id;
    private String uid;
    private int __v;
}
