package app.totemlocadora.repository;

import app.totemlocadora.model.Acessorio;
import org.springframework.data.jpa.repository.JpaRepository;
import java.math.BigDecimal;
import java.util.List;

public interface AcessorioRepository extends JpaRepository<Acessorio, Long> {
    List<Acessorio> findByNomeContainingIgnoreCase(String nome);
    List<Acessorio> findByTaxaHoraBetween(BigDecimal min, BigDecimal max);
}
