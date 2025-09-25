package app.totemlocadora.repository;

import app.totemlocadora.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByNomeContainingIgnoreCase(String nome);
    Optional<Cliente> findByCpf(String cpf);
    boolean existsByCpf(String cpf);
}
