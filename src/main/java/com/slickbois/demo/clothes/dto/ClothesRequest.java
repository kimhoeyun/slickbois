package com.slickbois.demo.clothes.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ClothesRequest {
    private String clothName;
    private int price;
    private int size;
    private String description;
}
