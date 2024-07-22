package com.azamma.conexa.client.starwarsapi.dto.response.films;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FilmDTO {
    private String title;
    private int episodeId;
    private String openingCrawl;
    private String director;
    private String producer;
    private String releaseDate;
    private List<String> characters;
    private List<String> planets;
    private List<String> starships;
    private List<String> vehicles;
    private List<String> species;
    private String created;
    private String edited;
    private String url;

}
