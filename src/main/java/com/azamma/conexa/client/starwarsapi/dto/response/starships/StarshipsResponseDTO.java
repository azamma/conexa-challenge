package com.azamma.conexa.client.starwarsapi.dto.response.starships;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StarshipsResponseDTO {
    @JsonProperty("message")
    private String message;

    @JsonProperty("total_records")
    private int totalRecords;

    @JsonProperty("total_pages")
    private int totalPages;

    @JsonProperty("previous")
    private String previous;

    @JsonProperty("next")
    private String next;

    @JsonProperty("results")
    private List<StarshipResult> results;

    @Getter
    @Setter
    public static class StarshipResult {
        @JsonProperty("uid")
        private String uid;

        @JsonProperty("name")
        private String name;

        @JsonProperty("url")
        private String url;
    }
}
