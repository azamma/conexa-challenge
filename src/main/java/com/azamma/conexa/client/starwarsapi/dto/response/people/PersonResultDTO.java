package com.azamma.conexa.client.starwarsapi.dto.response.people;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonResultDTO {
    private PersonPropertiesDTO properties;
    private String description;
    private String _id;
    private String uid;
    private int __v;
}
