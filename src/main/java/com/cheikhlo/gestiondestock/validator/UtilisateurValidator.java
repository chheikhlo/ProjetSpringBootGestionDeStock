package com.cheikhlo.gestiondestock.validator;

import com.cheikhlo.gestiondestock.dto.CategoryDto;
import com.cheikhlo.gestiondestock.dto.UtilisateurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurValidator {

    public static List<String> validate(UtilisateurDto utilisateurDto) {
        List<String> errors = new ArrayList<>();

        //Pour obliger la une valeur sur l'attribut nom et du coup le valider
        if (utilisateurDto == null || !StringUtils.hasLength(utilisateurDto.getNom())) {
            errors.add("veuiller renseigner le nom de l'utilisateur");
        }
        if (utilisateurDto == null || utilisateurDto.getDateDeNaissance()==null) {
            errors.add("veuiller renseigner la date de naissance de l'utilisateur");
        }
        if (utilisateurDto == null || !StringUtils.hasLength(utilisateurDto.getNom())) {
            errors.add("veuiller renseigner le nom de l'utilisateur");
        }
        if (utilisateurDto == null || !StringUtils.hasLength(utilisateurDto.getEmail())) {
            errors.add("veuiller renseigner l'email de l'utilisateur");
        }
        if (utilisateurDto == null || !StringUtils.hasLength(utilisateurDto.getPrenom())) {
            errors.add("veuiller renseigner le prenom de l'utilisateur");
        }
        if (utilisateurDto == null || !StringUtils.hasLength(utilisateurDto.getMotDePasse())) {
            errors.add("veuiller renseigner le mot de passe de l'utilisateur");
        }
        if (utilisateurDto == null || !StringUtils.hasLength((CharSequence) utilisateurDto.getAdresse())) {
            errors.add("veuiller renseigner l'adresse de l'utilisateur");
        }else {
            if (utilisateurDto == null || !StringUtils.hasLength(utilisateurDto.getAdresse().getAdresse1())) {
                errors.add("veuiller renseigner l'adresse 1 de l'utilisateur");
            }
            if (utilisateurDto == null || !StringUtils.hasLength(utilisateurDto.getAdresse().getVille())) {
                errors.add("veuiller renseigner le champs ville de l'utilisateur");
            }
            if (utilisateurDto == null || !StringUtils.hasLength(utilisateurDto.getAdresse().getCodePostale())) {
                errors.add("veuiller renseigner le code postale de l'utilisateur");
            }
            if (utilisateurDto == null || !StringUtils.hasLength((CharSequence) utilisateurDto.getAdresse().getPays())) {
                errors.add("veuiller renseigner le pays de l'utilisateur");
            }
        }
        return errors;
    }
}
