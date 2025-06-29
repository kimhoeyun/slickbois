package com.slickbois.demo.clothes.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ClothesResponse {
    private String clothName;
    private int price;
    private int size;
    private String description;

    public ClothesResponse(String clothName, int price, int size, String description) {
        this.clothName = clothName;
        this.price = price;
        this.size = size;
        this.description = description;
    }
}
