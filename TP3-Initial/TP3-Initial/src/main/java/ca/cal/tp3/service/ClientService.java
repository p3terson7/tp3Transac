package ca.cal.tp3.service;

import ca.cal.tp3.dto.AmendeDTO;
import ca.cal.tp3.dto.DocumentDTO;
import ca.cal.tp3.dto.EmpruntDTO;
import ca.cal.tp3.dto.LivreDTO;
import ca.cal.tp3.exceptions.ClientInexistantException;
import ca.cal.tp3.exceptions.DocumentAucunEmpruntEnCoursException;
import ca.cal.tp3.exceptions.DocumentInexistantException;
import ca.cal.tp3.model.Amende;
import lombok.*;
import ca.cal.tp3.model.Client;
import ca.cal.tp3.model.Document;
import ca.cal.tp3.model.Emprunt;
import ca.cal.tp3.persistence.AmendeRepository;
import ca.cal.tp3.persistence.ClientRepository;
import ca.cal.tp3.persistence.DocumentRepository;
import ca.cal.tp3.persistence.EmpruntRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static java.time.temporal.ChronoUnit.DAYS;

@EntityScan(basePackages = "ca.cal.tp3.model")
@RequiredArgsConstructor
@Service
public class ClientService {
    private AmendeRepository amendeRepository;
    private EmpruntRepository empruntRepository;
    private final ClientRepository clientRepository;

    private final DocumentRepository documentRepository;

    public List<DocumentDTO> getAllDocuments() {
        return objectsToDTO.documentsToDTO(documentRepository.findAll());
    }

    public List<LivreDTO> getAllLivres() {
        return objectsToDTO.livresToDTO(documentRepository.findAllLivres());
    }

    public List<DocumentDTO> getDocumentsByTitre(String titre) {
        return objectsToDTO.documentsToDTO(documentRepository.findAllByTitreIgnoreCase(titre));
    }
    public List<DocumentDTO> getDocumentsByAuteur(String auteur) {
        return objectsToDTO.documentsToDTO(documentRepository.findAllByAuteurIgnoreCase(auteur));
    }
    public List<DocumentDTO> getDocumentsByAnnee(int annee) {
        return objectsToDTO.documentsToDTO(documentRepository.findAllByAnnee(annee));
    }
    public List<LivreDTO> getLivresByGenre(String genre) {
        return objectsToDTO.livresToDTO(documentRepository.findAllLivresByGenre(genre));
    }

    public List<EmpruntDTO> getEmpruntsClientById(long id) {
        return objectsToDTO.empruntsToDTO(empruntRepository.findAllByClientId(id));
    }

    public List<AmendeDTO> getAmendesClientById(long id) {
        return objectsToDTO.amendesToDTO(amendeRepository.findAllByClientId(id));
    }

    @Transactional
    public void emprunterDocument(long docId, long cltId) throws ClientInexistantException, DocumentInexistantException {
        Client client = getClientById(cltId);
        Document document = getDocumentById(docId);

        document.setNbCopies(document.getNbCopies() - 1);
        LocalDate localDate = LocalDate.now();

        Emprunt emprunt = Emprunt.builder()
                .empruntDate(localDate)
                .document(document)
                .client(client)
                .empruntDateEcheance(localDate.plusDays(document.getEmpruntDuree()))
                .empruntReturned(false)
                .build();

        client.getEmprunts().add(emprunt);
        empruntRepository.save(emprunt);
        documentRepository.save(document);
        clientRepository.save(client);
    }

    @Transactional
    public void retournerDocument(long docId, long cltId) throws ClientInexistantException, DocumentInexistantException, DocumentAucunEmpruntEnCoursException {
        Client client = getClientById(cltId);
        Document document = getDocumentById(docId);

        if (client.getEmprunt(document.getId()).isEmpruntReturned()) throw new DocumentAucunEmpruntEnCoursException();
        Emprunt emprunt = client.getEmprunt(document.getId());
        emprunt.setEmpruntReturned(true);

        document.setNbCopies(document.getNbCopies() + 1);

        if (LocalDate.now().isAfter(emprunt.getEmpruntDateEcheance())) {
            Amende amende = Amende.builder()
                    .client(client)
                    .amendeCout(DAYS.between(LocalDate.now(), emprunt.getEmpruntDateEcheance()) * 0.75)
                    .build();
            client.getAmendes().add(amende);
            amendeRepository.save(amende);
        }

        empruntRepository.save(emprunt);
        documentRepository.save(document);
        clientRepository.save(client);
    }


    private Client getClientById(long id) throws ClientInexistantException {
        if (clientRepository.findByIdWithAmendes(id) == null) throw new ClientInexistantException();

        Client client = clientRepository.findByIdWithAmendes(id);
        client.setEmprunts(empruntRepository.findAllByClientId(id));
        return client;
    }

    private Document getDocumentById(long id) throws DocumentInexistantException {
        if (documentRepository.findById(id) == null) throw new DocumentInexistantException();

        return documentRepository.findById(id);
    }
}
