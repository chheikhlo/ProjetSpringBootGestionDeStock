package com.cheikhlo.gestiondestock.dto;

import com.cheikhlo.gestiondestock.model.Article;
import com.cheikhlo.gestiondestock.model.MvtStk;
import com.cheikhlo.gestiondestock.model.TypeMvtStk;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
public class MvtStkDto {

    private Integer id;

    private ArticleDto article;

    private Instant dateMvt;

    private BigDecimal quantite;

    private TypeMvtStk typeMvt;

    public static MvtStkDto fromEntity(MvtStk mvtStk) {
        if (mvtStk == null) {
            return null;
        }

        return MvtStkDto.builder()
                .id(mvtStk.getId())
                .dateMvt(mvtStk.getDateMvt())
                .quantite(mvtStk.getQuantite())
                .article(ArticleDto.fromEntity(mvtStk.getArticle()))
                .typeMvt(mvtStk.getTypeMvt())
                .build();
    }

    public static MvtStk toEntity(MvtStkDto dto) {
        if (dto == null) {
            return null;
        }

        MvtStk mvtStk = new MvtStk();
        mvtStk.setId(dto.getId());
        mvtStk.setDateMvt(dto.getDateMvt());
        mvtStk.setQuantite(dto.getQuantite());
        mvtStk.setArticle(ArticleDto.toEntity(dto.getArticle()));
        mvtStk.setTypeMvt(dto.getTypeMvt());
        return mvtStk;
    }

}
