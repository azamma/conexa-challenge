package com.azamma.conexa.exception;

import lombok.Data;

@Data
public class ClientDetails {

    private String clientName;
    private String clientUrl;
    private String clientMethod;

    public ClientDetails(String clientName, String clientUrl, String clientMethod) {
        this.clientName = clientName;
        this.clientUrl = clientUrl;
        this.clientMethod = clientMethod;
    }
}
