package com.azamma.conexa.client.starwarsapi.dto.response.films;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FilmSearchResponseDTO {

    @JsonProperty("message")
    private String message;

    @JsonProperty("result")
    private List<Result> result;

    @Getter
    @Setter
    public static class Result {

        @JsonProperty("properties")
        private Properties properties;

        @JsonProperty("_id")
        private String id;

        @JsonProperty("uid")
        private String uid;

        @JsonProperty("description")
        private String description;

        @Getter
        @Setter
        public static class Properties {

            @JsonProperty("characters")
            private List<String> characters;

            @JsonProperty("planets")
            private List<String> planets;

            @JsonProperty("starships")
            private List<String> starships;

            @JsonProperty("vehicles")
            private List<String> vehicles;

            @JsonProperty("species")
            private List<String> species;

            @JsonProperty("created")
            private String created;

            @JsonProperty("edited")
            private String edited;

            @JsonProperty("producer")
            private String producer;

            @JsonProperty("title")
            private String title;

            @JsonProperty("episode_id")
            private int episodeId;

            @JsonProperty("director")
            private String director;

            @JsonProperty("release_date")
            private String releaseDate;

            @JsonProperty("opening_crawl")
            private String openingCrawl;

            @JsonProperty("url")
            private String url;
        }
    }
}
