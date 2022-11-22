package com.cheikhlo.gestiondestock.validator;

import com.cheikhlo.gestiondestock.dto.CategoryDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CategoryValidator {

    public static List<String> validate(CategoryDto categoryDto) {
        List<String> errors = new ArrayList<>();

        //Pour obliger la une valeur sur l'attribut code et du coup le valider
        if (categoryDto == null || !StringUtils.hasLength(categoryDto.getCode())) {
            errors.add("veuiller renseigner le code de la categorie");

        }

        return errors;
    }
}
