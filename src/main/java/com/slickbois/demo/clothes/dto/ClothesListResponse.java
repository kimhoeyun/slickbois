package com.slickbois.demo.clothes.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClothesListResponse {
    private String clothName;
    private int price;

    public ClothesListResponse(String clothName, int price) {
        this.clothName = clothName;
        this.price = price;
    }
}
