package com.azamma.conexa.client.starwarsapi.dto.response.people;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PeopleResponseDTO {
    private String message;

    @JsonProperty("total_records")
    private int totalRecords;

    @JsonProperty("total_pages")
    private int totalPages;

    private String previous;
    private String next;
    private List<PersonResult> results;

    @Getter
    @Setter
    public static class PersonResult {
        private String uid;
        private String name;
        private String url;
    }

}
