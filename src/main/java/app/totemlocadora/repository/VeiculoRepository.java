package app.totemlocadora.repository;
import app.totemlocadora.model.Veiculo;
import app.totemlocadora.model.enums.StatusVeiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
  Optional<Veiculo> findByPlaca(String placa);
  List<Veiculo> findByModeloContainingIgnoreCase(String modelo);
  List<Veiculo> findByStatus(StatusVeiculo status);
}
