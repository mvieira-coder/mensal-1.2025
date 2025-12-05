package app.totemlocadora.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import app.totemlocadora.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByUsername(String username);
}
