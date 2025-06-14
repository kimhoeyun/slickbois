package com.slickbois.demo.clothes.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class EditClothesRequest {
    private Long id;
    private String clothName;
    private int price;
    private int size;
    private String description;
}
