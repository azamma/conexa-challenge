package com.azamma.conexa.client.starwarsapi.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StarshipsResponseDTO {
    private int count;
    private List<StarshipDTO> results;
}
