package com.cheikhlo.gestiondestock.dto;

import com.cheikhlo.gestiondestock.model.Article;
import com.cheikhlo.gestiondestock.model.Category;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import java.math.BigDecimal;

@Builder
@Data
public class ArticleDto {

    //On mets juste les attributs qu'on veut afficher
    private Integer id;

    private String codeArticle;

    private String designation;

    private BigDecimal prixUnitaireHt;

    private BigDecimal prixUnitaireTtc;

    private BigDecimal tauxTva;

    private String photo;//c'est mis en string car on va pas le délégué directement à la base de donnée mais à notre api

    private CategoryDto category;

    //Afin de md'assurer le mapping de l'entité vers le Dto : Article vers Article DTO
    public static ArticleDto fromEntity(Article article) {
        if (article == null) {
            //TODO à reconstruire par les exception
            return null;
        }
        return ArticleDto.builder()
                .id(article.getId())
                .codeArticle(article.getCodeArticle())
                .designation(article.getDesignation())
                .prixUnitaireHt(article.getPrixUnitaireHt())
                .prixUnitaireTtc(article.getPrixUnitaireTtc())
                .tauxTva(article.getTauxTva())
                .photo(article.getPhoto())
                .category(CategoryDto.fromEntity(article.getCategory()))
                .build();
     }

    public static Article toEntity(ArticleDto articleDto) {
        if (articleDto == null) {
            //TODO à reconstruire par les exception
            return null;
        }

        Article article = new Article();
        article.setCodeArticle(articleDto.getCodeArticle());
        article.setDesignation(articleDto.getDesignation());
        article.setPrixUnitaireHt(articleDto.getPrixUnitaireHt());
        article.setPrixUnitaireTtc(articleDto.getPrixUnitaireTtc());
        article.setTauxTva(articleDto.getTauxTva());
        article.setPhoto(articleDto.getPhoto());
        article.setCategory(CategoryDto.toEntity(articleDto.getCategory()));

        return article;
    }
}
