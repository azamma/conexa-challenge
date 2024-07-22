package com.azamma.conexa.client.starwarsapi.dto.response.people;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonPropertiesDTO {
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

    @JsonProperty("url")
    private String url;

    @JsonProperty("created")
    private String created;

    @JsonProperty("edited")
    private String edited;
}
