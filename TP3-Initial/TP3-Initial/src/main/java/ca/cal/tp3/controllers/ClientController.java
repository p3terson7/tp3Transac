package ca.cal.tp3.controllers;

import ca.cal.tp3.dto.AmendeDTO;
import ca.cal.tp3.dto.DocumentDTO;
import ca.cal.tp3.dto.EmpruntDTO;
import ca.cal.tp3.dto.LivreDTO;
import ca.cal.tp3.exceptions.ClientInexistantException;
import ca.cal.tp3.exceptions.DocumentAucunEmpruntEnCoursException;
import ca.cal.tp3.exceptions.DocumentInexistantException;
import ca.cal.tp3.service.ClientService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/documents")
    public List<DocumentDTO> getAllDocuments() {
        return clientService.getAllDocuments();
    }

    @GetMapping("/livres")
    public List<LivreDTO> getAllLivres() {
        return clientService.getAllLivres();
    }

    @GetMapping("/documents/titre/{titre}")
    public List<DocumentDTO> getDocumentsByTitre(@PathVariable String titre) {
        return clientService.getDocumentsByTitre(titre);
    }

    @GetMapping("/documents/auteur/{auteur}")
    public List<DocumentDTO> getDocumentsByAuteur(@PathVariable String auteur) {
        return clientService.getDocumentsByAuteur(auteur);
    }

    @GetMapping("/documents/annee/{annee}")
    public List<DocumentDTO> getDocumentsByAnnee(@PathVariable int annee) {
        return clientService.getDocumentsByAnnee(annee);
    }

    @GetMapping("/livres/genre/{genre}")
    public List<LivreDTO> getLivresByGenre(@PathVariable String genre) {
        return clientService.getLivresByGenre(genre);
    }

    @GetMapping("/{id}/emprunts")
    public List<EmpruntDTO> getEmpruntsClientById(@PathVariable long id) {
        return clientService.getEmpruntsClientById(id);
    }

    @GetMapping("/{id}/amendes")
    public List<AmendeDTO> getAmendesClientById(@PathVariable long id) {
        return clientService.getAmendesClientById(id);
    }

    @PostMapping("/{cltId}/emprunts/{docId}")
    public void emprunterDocument(@PathVariable long docId, @PathVariable long cltId)
            throws ClientInexistantException, DocumentInexistantException {
        clientService.emprunterDocument(docId, cltId);
    }

    @PostMapping("/{cltId}/retours/{docId}")
    public void retournerDocument(@PathVariable long docId, @PathVariable long cltId)
            throws ClientInexistantException, DocumentInexistantException, DocumentAucunEmpruntEnCoursException {
        clientService.retournerDocument(docId, cltId);
    }
}
