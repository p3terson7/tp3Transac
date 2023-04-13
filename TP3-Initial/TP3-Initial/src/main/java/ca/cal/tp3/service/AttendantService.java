package ca.cal.tp3.service;

import ca.cal.tp3.dto.CdDTO;
import ca.cal.tp3.dto.ClientDTO;
import ca.cal.tp3.dto.DvdDTO;
import ca.cal.tp3.dto.LivreDTO;
import ca.cal.tp3.model.CD;
import ca.cal.tp3.model.Client;
import ca.cal.tp3.model.DVD;
import ca.cal.tp3.model.Livre;
import ca.cal.tp3.persistence.ClientRepository;
import ca.cal.tp3.persistence.DocumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AttendantService {
    private ClientRepository clientRepository;
    private DocumentRepository documentRepository;

    public void saveDVD(DvdDTO dvdDTO) {
        DVD dvd = DVD.builder()
                .titre(dvdDTO.getTitre())
                .auteur(dvdDTO.getAuteur())
                .duree(dvdDTO.getDuree())
                .nbCopies(dvdDTO.getNbCopies())
                .annee(dvdDTO.getAnnee())
                .build();
        documentRepository.save(dvd);
    }

    public void saveCD(CdDTO cdDTO) {
        CD cd = CD.builder()
                .titre(cdDTO.getTitre())
                .auteur(cdDTO.getAuteur())
                .duree(cdDTO.getDuree())
                .nbCopies(cdDTO.getNbCopies())
                .annee(cdDTO.getAnnee())
                .build();
        documentRepository.save(cd);
    }

    public void saveLivre(LivreDTO livreDTO) {
        Livre livre = Livre.builder()
                .titre(livreDTO.getTitre())
                .auteur(livreDTO.getAuteur())
                .nbCopies(livreDTO.getNbCopies())
                .annee(livreDTO.getAnnee())
                .editeur(livreDTO.getEditeur())
                .genre(livreDTO.getGenre())
                .nbPages(livreDTO.getNbPages())
                .build();
        documentRepository.save(livre);
    }

    public void saveClient(ClientDTO clientDTO) {
        Client client = Client.builder()
                .name(clientDTO.getName())
                .password(clientDTO.getPassword())
                .build();
        clientRepository.save(client);
    }

    public List<ClientDTO> getAllClients() {
        return objectsToDTO.clientsToDTO(clientRepository.findAll());
    }

    public ClientDTO getClient(long id) {
        Client client = clientRepository.findById(id);
        return objectsToDTO.clientToDTO(client);
    }
}
