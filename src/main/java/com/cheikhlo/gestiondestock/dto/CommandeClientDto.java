package com.cheikhlo.gestiondestock.dto;

import com.cheikhlo.gestiondestock.model.Client;
import com.cheikhlo.gestiondestock.model.CommandeClient;
import com.cheikhlo.gestiondestock.model.LigneCommandeClient;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.Instant;
import java.util.List;

@Data
@Builder
public class CommandeClientDto {

    private Integer id;

    private String code;

    private Instant dateCommande;

    private ClientDto client;

    @JsonIgnore
    private List<LigneCommandeClientDto> ligneCommandeClients;

    public CommandeClientDto fromEntity(CommandeClient commandeClient){
        if (commandeClient == null) {
            //TODO à reconstruire par les exception
            return null;
        }
        return CommandeClientDto.builder()
                .id(commandeClient.getId())
                .code(commandeClient.getCode())
                .dateCommande(commandeClient.getDateCommande())
                .client(ClientDto.fromEntity(commandeClient.getClient()))
                .build();

    }

    public Client toEntity(ClientDto clientDto){
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
