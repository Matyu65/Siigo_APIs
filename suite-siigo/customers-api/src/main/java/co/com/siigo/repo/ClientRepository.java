package co.com.siigo.repo;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import co.com.siigo.domain.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByIdentification(String identification);
}
