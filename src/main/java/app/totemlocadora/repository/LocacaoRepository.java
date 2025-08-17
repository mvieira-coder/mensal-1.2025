package app.totemlocadora.repository;
import app.totemlocadora.model.Locacao;
import app.totemlocadora.model.enums.StatusLocacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.time.LocalDateTime;
import java.util.List;
public interface LocacaoRepository extends JpaRepository<Locacao, Long> {
  List<Locacao> findByDataInicioBetween(LocalDateTime ini, LocalDateTime fim);
  List<Locacao> findByStatus(StatusLocacao status);
  @Query("""
  select l.totem.id as totemId, sum(l.valorTotal) as faturamento
  from Locacao l
  where l.dataInicio between :ini and :fim
  group by l.totem.id
  """)
  List<Object[]> faturamentoPorTotem(LocalDateTime ini, LocalDateTime fim);
}
