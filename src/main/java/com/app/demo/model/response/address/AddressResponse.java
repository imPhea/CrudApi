package com.app.demo.model.response.address;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
public class AddressResponse implements Serializable {
    private Long id;
    private String address;

    public AddressResponse(Long id, String address) {
        this.id = id;
        this.address = address;
    }
}
