package ca.cal.tp3.persistence;



import ca.cal.tp3.model.Client;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@EntityScan(basePackages = "ca.cal.tp3.")
@Qualifier("client")
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findById(long id);
    @Query("SELECT c FROM Client c LEFT JOIN FETCH c.amendes a WHERE c.id = :id ")
    Client findByIdWithAmendes(@Param("clt_id") long id);

    @Query("SELECT c FROM Client c LEFT JOIN FETCH c.emprunts b WHERE c.id = :id")
    Client findByIdWithEmprunts(@Param("clt_id") long id);
}
