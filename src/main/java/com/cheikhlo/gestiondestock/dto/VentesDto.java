package com.cheikhlo.gestiondestock.dto;

import com.cheikhlo.gestiondestock.model.LigneVente;
import com.cheikhlo.gestiondestock.model.Ventes;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Builder
public class VentesDto {

    private Integer id;

    private String code;

    private List<LigneVenteDto> ligneVentes;

    private String dateVente;

    private String commentaire;

    public static VentesDto fromEntity(Ventes vente) {
        if (vente == null) {
            return null;
        }
        return VentesDto.builder()
                .id(vente.getId())
                .code(vente.getCode())
                .commentaire(vente.getCommentaire())
                .build();
    }

    public static Ventes toEntity(VentesDto dto) {
        if (dto == null) {
            return null;
        }
        Ventes ventes = new Ventes();
        ventes.setId(dto.getId());
        ventes.setCode(ventes.getCode());
        ventes.setCommentaire(dto.getCommentaire());
        return ventes;
    }
}
