package app.totemlocadora.repository;

import app.totemlocadora.model.Veiculo;
import app.totemlocadora.model.enums.CategoriaVeiculo;
import app.totemlocadora.model.enums.StatusVeiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
    List<Veiculo> findByStatus(app.totemlocadora.model.enums.StatusVeiculo status);
    List<Veiculo> findByCategoria(CategoriaVeiculo categoria);
    Optional<Veiculo> findByPlacaIgnoreCase(String placa);
    List<Veiculo> findByModeloContainingIgnoreCase(String modelo);
}
