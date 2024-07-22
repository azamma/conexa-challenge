package com.azamma.conexa.client.starwarsapi.dto.response.people;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PersonResponseDTO {
    @JsonProperty("name")
    private String name;

    @JsonProperty("birth_year")
    private String birthYear;

    @JsonProperty("eye_color")
    private String eyeColor;

    @JsonProperty("gender")
    private String gender;

    @JsonProperty("hair_color")
    private String hairColor;

    @JsonProperty("height")
    private String height;

    @JsonProperty("homeworld")
    private String homeworld;

    @JsonProperty("mass")
    private String mass;

    @JsonProperty("skin_color")
    private String skinColor;

    @JsonProperty("films")
    private List<String> films;

    @JsonProperty("species")
    private List<String> species;

    @JsonProperty("starships")
    private List<String> starships;

    @JsonProperty("vehicles")
    private List<String> vehicles;

    @JsonProperty("url")
    private String url;

    @JsonProperty("created")
    private String created;

    @JsonProperty("edited")
    private String edited;
}
