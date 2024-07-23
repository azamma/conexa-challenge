package com.azamma.conexa.client.starwarsapi.dto.response.starships;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StarshipSearchResponseDTO {
    private String message;

    @JsonProperty("result")
    private List<StarshipDetail> results;

    @Getter
    @Setter
    public static class StarshipDetail {
        @JsonProperty("properties")
        private StarshipProperties starshipProperties;

        private String description;

        @JsonProperty("_id")
        private String id;

        private String uid;

        @JsonProperty("__v")
        private int version;

        @Getter
        @Setter
        public static class StarshipProperties {
            private String model;

            @JsonProperty("starship_class")
            private String starshipClass;

            private String manufacturer;

            @JsonProperty("cost_in_credits")
            private String costInCredits;

            private String length;

            private String crew;

            private String passengers;

            @JsonProperty("max_atmosphering_speed")
            private String maxAtmospheringSpeed;

            @JsonProperty("hyperdrive_rating")
            private String hyperdriveRating;

            @JsonProperty("MGLT")
            private String MGLT;

            @JsonProperty("cargo_capacity")
            private String cargoCapacity;

            private String consumables;

            private List<String> pilots;

            private String created;

            private String edited;

            private String name;

            private String url;
        }
    }
}
