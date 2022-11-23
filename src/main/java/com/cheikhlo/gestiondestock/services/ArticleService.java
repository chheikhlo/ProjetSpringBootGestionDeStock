package com.cheikhlo.gestiondestock.services;


import com.cheikhlo.gestiondestock.dto.LigneCommandeClientDto;
import com.cheikhlo.gestiondestock.dto.LigneCommandeFournisseurDto;
import com.cheikhlo.gestiondestock.dto.LigneVenteDto;
import com.cheikhlo.gestiondestock.dto.ArticleDto;

import java.util.List;

public interface ArticleService {

  ArticleDto save(ArticleDto dto);

  ArticleDto findById(Integer id);

  ArticleDto findByCodeArticle(String codeArticle);

  List<ArticleDto> findAll();

  List<LigneVenteDto> findHistoriqueVentes(Integer idArticle);

  List<LigneCommandeClientDto> findHistoriaueCommandeClient(Integer idArticle);

  List<LigneCommandeFournisseurDto> findHistoriqueCommandeFournisseur(Integer idArticle);

  List<ArticleDto> findAllArticleByIdCategory(Integer idCategory);

  void delete(Integer id);

}
