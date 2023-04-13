package ca.cal.tp3.service;

import ca.cal.tp3.dto.*;
import ca.cal.tp3.model.*;

import java.util.ArrayList;
import java.util.List;

public class objectsToDTO {
    private objectsToDTO() {}

    public static List<DocumentDTO> documentsToDTO(List<Document> documents) {
        List<DocumentDTO> documentsDTO = new ArrayList<>();
        for (Document d : documents) {
            if (d instanceof DVD dvd) {
                DocumentDTO documentDTO = DocumentDTO.builder()
                        .id(dvd.getId())
                        .titre(dvd.getTitre())
                        .annee(dvd.getAnnee())
                        .duree(dvd.getDuree())
                        .nbCopies(dvd.getNbCopies())
                        .docType("DVD")
                        .build();
                documentsDTO.add(documentDTO);
            }
            if (d instanceof CD cd) {
                DocumentDTO documentDTO = DocumentDTO.builder()
                        .id(cd.getId())
                        .titre(cd.getTitre())
                        .annee(cd.getAnnee())
                        .nbCopies(cd.getNbCopies())
                        .duree(cd.getDuree())
                        .docType("CD")
                        .build();
                documentsDTO.add(documentDTO);
            }
            if (d instanceof Livre livre) {
                DocumentDTO documentDTO = DocumentDTO.builder()
                        .id(livre.getId())
                        .titre(livre.getTitre())
                        .annee(livre.getAnnee())
                        .editeur(livre.getEditeur())
                        .nbPages(livre.getNbPages())
                        .nbCopies(livre.getNbCopies())
                        .docType("Livre")
                        .auteur(livre.getAuteur())
                        .build();
                documentsDTO.add(documentDTO);
            }
        }
        return documentsDTO;
    }

    public static List<AmendeDTO> amendesToDTO(List<Amende> amendes) {
        List<AmendeDTO> amendesDTO = new ArrayList<>();
        for (Amende a : amendes) {
            AmendeDTO amendeDTO = AmendeDTO.builder()
                    .id(a.getId())
                    .cltId(a.getClient().getId())
                    .cout(a.getAmendeCout())
                    .paid(a.isAmendePaid())
                    .build();
            amendesDTO.add(amendeDTO);
        }
        return amendesDTO;
    }

    public static List<EmpruntDTO> empruntsToDTO(List<Emprunt> emprunts) {
        List<EmpruntDTO> empruntsDTO = new ArrayList<>();
        for (Emprunt e : emprunts) {
            EmpruntDTO empruntDTO = EmpruntDTO.builder()
                    .id(e.getId())
                    .cltId(e.getClient().getId())
                    .docId(e.getDocument().getId())
                    .empruntDate(e.getEmpruntDate())
                    .emprunteDateEcheance(e.getEmpruntDateEcheance())
                    .empruntReturned(e.isEmpruntReturned())
                    .build();
            empruntsDTO.add(empruntDTO);
        }
        return empruntsDTO;
    }

    public static List<ClientDTO> clientsToDTO(List<Client> clients) {
        List<ClientDTO> clientsDTO = new ArrayList<>();
        for (Client c : clients) {
            clientsDTO.add(new ClientDTO(c.getId(), c.getName(), c.getPassword()));
        }
        return clientsDTO;
    }

    public static ClientDTO clientToDTO(Client client) {
        return new ClientDTO(client.getId(), client.getName(), client.getPassword());
    }

    public static List<LivreDTO> livresToDTO(List<Livre> livres) {
        List<LivreDTO> livresDTO = new ArrayList<>();
        for (Livre l : livres) {
            LivreDTO livreDTO = LivreDTO.builder()
                    .id(l.getId())
                    .titre(l.getTitre())
                    .editeur(l.getEditeur())
                    .nbPages(l.getNbPages())
                    .nbCopies(l.getNbCopies())
                    .annee(l.getAnnee())
                    .auteur(l.getAuteur())
                    .genre(l.getGenre())
                    .build();
            livresDTO.add(livreDTO);
        }
        return livresDTO;
    }

}
