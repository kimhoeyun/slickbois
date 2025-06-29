package com.slickbois.demo.clothes.controller;

import com.slickbois.demo.clothes.dto.ClothesListResponse;
import com.slickbois.demo.clothes.dto.ClothesResponse;
import com.slickbois.demo.clothes.dto.EditClothesRequest;
import com.slickbois.demo.clothes.model.Clothes;
import com.slickbois.demo.clothes.dto.ClothesRequest;
import com.slickbois.demo.clothes.service.ClothesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/edit")
    public ResponseEntity<Void> editClothes(@RequestBody EditClothesRequest request) {
        clothesService.modifyClothes(request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{clothesId}")
    public ResponseEntity<Void> deleteClothes(@PathVariable Long clothesId) {
        clothesService.deleteClothes(clothesId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/detail/{clothesId}")
    public ResponseEntity<ClothesResponse> getClothes(@PathVariable Long clothesId) {
        Clothes clothes = clothesService.getClothes(clothesId);
        ClothesResponse clothesResponse = new ClothesResponse(clothes.getClothName(), clothes.getPrice(), clothes.getSize(), clothes.getDescription());
        return ResponseEntity.ok(clothesResponse);
    }
}