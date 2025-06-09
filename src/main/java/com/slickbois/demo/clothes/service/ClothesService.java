// 요청 DTO를 엔티티로 변환해 DB에 저장

package com.slickbois.demo.clothes.service;

import com.slickbois.demo.clothes.model.Clothes;
import com.slickbois.demo.clothes.dto.ClothesRequest;
import com.slickbois.demo.clothes.repository.ClothesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ClothesService {

    private final ClothesRepository clothesRepository;

    @Transactional
    public Clothes saveClothes(ClothesRequest request) {
        Clothes clothes = Clothes.builder()
                .clothName(request.getClothName())
                .price(request.getPrice())
                .size(request.getSize())
                .description(request.getDescription())
                .build();

        return clothesRepository.save(clothes);
    }
}