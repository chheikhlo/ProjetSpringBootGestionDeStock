package com.cheikhlo.gestiondestock.dto;

import com.cheikhlo.gestiondestock.model.Article;
import com.cheikhlo.gestiondestock.model.Category;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Builder
public class CategoryDto {

    private Integer id;

    private String code;

    private String designation;

    //On ignore le mapping des articles puisqu'on vas les mapper dans le Dto de Article. Eviter boucle infinie
    @JsonIgnore
    private List<ArticleDto> articles;

    // RECTIFICATION --> Afin de m'assurer le mapping de l'entité vers le Dto : Category vers CategoryDTO
    public static CategoryDto fromEntity(Category category){
        if (category == null) {
            //TODO à reconstruire par les exception
            return null;
        }
        return CategoryDto.builder()
                .id(category.getId())
                .code(category.getCode())
                .designation(category.getDesignation())
                .build(); //et c'est ce methode build qui va créer un objet de type categoryDto
    }

    //Afin de m'assurer le mapping de l'entité vers le Dto : CategoryDTO vers Category
    public static Category toEntity(CategoryDto categoryDto){
        if (categoryDto == null) {
            //TODO à reconstruire par les exception
            return null;
        }
        Category category = new Category();
        category.setId(categoryDto.getId());
        category.setCode(categoryDto.getCode());
        category.setDesignation(categoryDto.getDesignation());

        return category;
    }

}
