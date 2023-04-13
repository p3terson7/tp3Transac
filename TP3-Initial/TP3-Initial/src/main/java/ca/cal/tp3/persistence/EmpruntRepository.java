package ca.cal.tp3.persistence;

import ca.cal.tp3.model.Emprunt;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Qualifier("emprunt")
@Repository
public interface EmpruntRepository extends JpaRepository<Emprunt, Long> {
    List<Emprunt> findAllByClientId(long id);
}
