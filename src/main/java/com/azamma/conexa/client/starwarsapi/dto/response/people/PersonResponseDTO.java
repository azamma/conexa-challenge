package com.azamma.conexa.client.starwarsapi.dto.response.people;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonResponseDTO {
    private String message;
    private PersonDetail result;

    @Getter
    @Setter
    public static class PersonDetail {
        private PersonProperties properties;
        private String description;

        @JsonProperty("_id")
        private String id;

        private String uid;

        @JsonProperty("__v")
        private int version;

        @Getter
        @Setter
        public static class PersonProperties {
            private String height;
            private String mass;

            @JsonProperty("hair_color")
            private String hairColor;

            @JsonProperty("skin_color")
            private String skinColor;

            @JsonProperty("eye_color")
            private String eyeColor;

            @JsonProperty("birth_year")
            private String birthYear;

            private String gender;

            private String created;
            private String edited;
            private String name;

            private String homeworld;
            private String url;
        }
    }
}
