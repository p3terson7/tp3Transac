package ca.cal.tp3.persistence;

import ca.cal.tp3.model.Amende;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Qualifier("amende")
@Repository
public interface AmendeRepository extends JpaRepository<Amende, Long> {
    List<Amende> findAllByClientId(long id);
}
