package com.azamma.conexa.client.starwarsapi.dto.response.films;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilmResultDTO {
    private FilmPropertiesDTO properties;
    private String description;
    private String _id;
    private String uid;
    private int __v;

}
