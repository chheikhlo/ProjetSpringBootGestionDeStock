package com.cheikhlo.gestiondestock.repository;

import java.util.Optional;

import com.cheikhlo.gestiondestock.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

  Optional<Category> findCategoryByCode(String code);

}
