package com.cheikhlo.gestiondestock.dto;

import com.cheikhlo.gestiondestock.model.Adresse;
import com.cheikhlo.gestiondestock.model.Category;
import com.cheikhlo.gestiondestock.model.Client;
import com.cheikhlo.gestiondestock.model.CommandeClient;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Builder
public class ClientDto {

    private Integer id;

    private String nom;

    private String prenom;

    private AdresseDto adresse;

    private String photo;

    private String mail;

    private String numTel;

    @JsonIgnore
    private List<CommandeClientDto> commandeClients;

    public static ClientDto fromEntity(Client client){
        if (client == null) {
            //TODO à reconstruire par les exception
            return null;
        }
        return ClientDto.builder()
                .id(client.getId())
                .nom(client.getNom())
                .prenom(client.getPrenom())
                .adresse(AdresseDto.fromEntity(client.getAdresse()))
                .photo(client.getPhoto())
                .mail(client.getMail())
                .numTel(client.getNumTel())
                .build();
    }

    public static Client toEntity(ClientDto clientDto){
        if (clientDto == null) {
            //TODO à reconstruire par les exception
            return null;
        }
        Client client = new Client();
        client.setId(client.getId());
        client.setNom(clientDto.getNom());
        client.setPrenom(clientDto.getPrenom());
        client.setAdresse(AdresseDto.toEntity(clientDto.getAdresse()));
        client.setPhoto(clientDto.getPhoto());
        client.setMail(clientDto.getMail());
        client.setNumTel(clientDto.getNumTel());

        return client;
    }
}
