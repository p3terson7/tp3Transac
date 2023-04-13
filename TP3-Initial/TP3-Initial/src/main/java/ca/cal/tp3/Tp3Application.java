package ca.cal.tp3;

import ca.cal.tp3.dto.ClientDTO;
import ca.cal.tp3.dto.LivreDTO;
import ca.cal.tp3.service.AttendantService;
import ca.cal.tp3.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@RequiredArgsConstructor
@SpringBootApplication

public class Tp3Application implements CommandLineRunner {

    private AttendantService attendantService;
    private ClientService clientService;

    public static void main(String[] args) {
        SpringApplication.run(Tp3Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception
    {
        attendantService.saveLivre(new LivreDTO(0, "Malevil", "Nekfeu", 2020, 7, "aaa", 12, "Drame"));
        attendantService.saveClient(new ClientDTO(0, "Kylian", "Mbappe"));
        System.out.println(clientService.getDocumentsByAnnee(2020).get(0).toString());
        System.out.println(clientService.getAllDocuments().get(0).toString());
        System.out.println(clientService.getAllLivres().get(0).toString());
    }
}
