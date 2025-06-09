package com.slickbois.demo.clothes.controller;

import com.slickbois.demo.clothes.model.Clothes;
import com.slickbois.demo.clothes.dto.ClothesRequest;
import com.slickbois.demo.clothes.service.ClothesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clothes")
@RequiredArgsConstructor
public class ClothesController {

    private final ClothesService clothesService;

    @PostMapping("/create")
    public ResponseEntity<Clothes> registerClothes(@RequestBody ClothesRequest request) {
        Clothes saved = clothesService.saveClothes(request);
        return ResponseEntity.ok(saved);
    }
}