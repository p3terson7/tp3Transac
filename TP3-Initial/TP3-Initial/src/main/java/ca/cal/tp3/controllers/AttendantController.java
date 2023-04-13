package ca.cal.tp3.controllers;


import ca.cal.tp3.dto.CdDTO;
import ca.cal.tp3.dto.ClientDTO;
import ca.cal.tp3.dto.DvdDTO;
import ca.cal.tp3.dto.LivreDTO;
import ca.cal.tp3.service.AttendantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AttendantController {
    private final AttendantService attendantService;

    @PostMapping("/dvd")
    public ResponseEntity<Void> saveDVD(@RequestBody DvdDTO dvdDTO) {
        attendantService.saveDVD(dvdDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/cd")
    public ResponseEntity<Void> saveCD(@RequestBody CdDTO cdDTO) {
        attendantService.saveCD(cdDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/livre")
    public ResponseEntity<Void> saveLivre(@RequestBody LivreDTO livreDTO) {
        attendantService.saveLivre(livreDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/client")
    public ResponseEntity<Void> saveClient(@RequestBody ClientDTO clientDTO) {
        attendantService.saveClient(clientDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/clients")
    public ResponseEntity<List<ClientDTO>> getAllClients() {
        return ResponseEntity.ok(attendantService.getAllClients());
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<ClientDTO> getClient(@PathVariable long id) {
        ClientDTO clientDTO = attendantService.getClient(id);
        if (clientDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clientDTO);
    }
}
