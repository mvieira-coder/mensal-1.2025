package app.totemlocadora.repository;
import app.totemlocadora.model.Totem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;
public interface TotemRepository extends JpaRepository<Totem, Long> {
  Optional<Totem> findByCodigo(String codigo);
  List<Totem> findByLocalContainingIgnoreCase(String local);
}
