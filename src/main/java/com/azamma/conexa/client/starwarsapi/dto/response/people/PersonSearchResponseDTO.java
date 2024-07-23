package com.azamma.conexa.client.starwarsapi.dto.response.people;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PersonSearchResponseDTO {
    @JsonProperty("message")
    private String message;

    @JsonProperty("result")
    private List<PersonDetail> result;

    @Getter
    @Setter
    public static class PersonDetail {
        @JsonProperty("properties")
        private PersonProperties properties;

        @JsonProperty("description")
        private String description;

        @JsonProperty("_id")
        private String id;

        @JsonProperty("uid")
        private String uid;

        @JsonProperty("__v")
        private int v;

        @Getter
        @Setter
        public static class PersonProperties {
            @JsonProperty("height")
            private String height;

            @JsonProperty("mass")
            private String mass;

            @JsonProperty("hair_color")
            private String hairColor;

            @JsonProperty("skin_color")
            private String skinColor;

            @JsonProperty("eye_color")
            private String eyeColor;

            @JsonProperty("birth_year")
            private String birthYear;

            @JsonProperty("gender")
            private String gender;

            @JsonProperty("created")
            private String created;

            @JsonProperty("edited")
            private String edited;

            @JsonProperty("name")
            private String name;

            @JsonProperty("homeworld")
            private String homeworld;

            @JsonProperty("url")
            private String url;
        }
    }
}
