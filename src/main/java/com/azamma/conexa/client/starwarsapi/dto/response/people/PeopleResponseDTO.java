package com.azamma.conexa.client.starwarsapi.dto.response.people;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PeopleResponseDTO {
    @JsonProperty("total_records")
    private int count;

    @JsonProperty("next")
    private String next;

    @JsonProperty("previous")
    private String previous;

    @JsonProperty("results")
    private List<PersonShortResultDTO> results;
}
