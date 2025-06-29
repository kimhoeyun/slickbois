// 요청 DTO를 엔티티로 변환해 DB에 저장

package com.slickbois.demo.clothes.service;

import ch.qos.logback.core.net.server.Client;
import com.slickbois.demo.clothes.dto.ClothesListResponse;
import com.slickbois.demo.clothes.dto.EditClothesRequest;
import com.slickbois.demo.clothes.model.Clothes;
import com.slickbois.demo.clothes.dto.ClothesRequest;
import com.slickbois.demo.clothes.repository.ClothesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClothesService {

    private final ClothesRepository clothesRepository;

    @Transactional // 메서드가 트랜잭션(데이터베이스 작업 최소 단위) 안에서 실행되어야 하고 한 가지의 조건도 충족되지 않을 경우 전체 롤백
    public Clothes saveClothes(ClothesRequest request) {
        Clothes clothes = Clothes.builder()
                .clothName(request.getClothName())
                .price(request.getPrice())
                .size(request.getSize())
                .description(request.getDescription())
                .build();

        Clothes saved = clothesRepository.save(clothes);
        return saved;
    }


    @Transactional
    public void modifyClothes(EditClothesRequest request) {
        Clothes clothes = clothesRepository.findById(request.getId()).get();

        clothes.setClothName(request.getClothName());
        clothes.setPrice(request.getPrice());
        clothes.setSize(request.getSize());
        clothes.setDescription(request.getDescription());

        clothesRepository.save(clothes);
    }


    @Transactional
    public void deleteClothes(Long id) {
        clothesRepository.deleteById(id);
    }

    public List<ClothesListResponse> getClothesList() {
        List<Clothes> clothesList = clothesRepository.findAll();

        return clothesList.stream()
                .map(clothes -> new ClothesListResponse(clothes.getClothName(), clothes.getPrice()))
                .collect(Collectors.toList());
    }

    public Clothes getClothes(Long clothesId) {
        return clothesRepository.findById(clothesId).get();
    }
}