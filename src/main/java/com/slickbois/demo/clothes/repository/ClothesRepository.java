package com.slickbois.demo.clothes.repository;

import com.slickbois.demo.clothes.model.Clothes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClothesRepository extends JpaRepository<Clothes, Long> {

}
