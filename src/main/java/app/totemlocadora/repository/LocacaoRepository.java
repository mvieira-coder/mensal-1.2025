package app.totemlocadora.repository;

import app.totemlocadora.model.Locacao;
import app.totemlocadora.model.enums.StatusLocacao;
import app.totemlocadora.dto.FaturamentoTotemView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.time.LocalDateTime;
import java.util.List;

public interface LocacaoRepository extends JpaRepository<Locacao, Long> {
    List<Locacao> findByStatus(StatusLocacao status);
    List<Locacao> findByDataInicioBetween(LocalDateTime inicio, LocalDateTime fim);
    List<Locacao> findByClienteId(Long clienteId);
    List<Locacao> findByVeiculoId(Long veiculoId);

    @Query("""
        select 
            l.totem.id as totemId,
            l.totem.codigo as codigo,
            sum(l.valorTotal) as total,
            count(l.id) as quantidade
        from Locacao l
        where l.status = app.totemlocadora.model.enums.StatusLocacao.CONFIRMADA
          and l.dataInicio >= :inicio and l.dataFim <= :fim
        group by l.totem.id, l.totem.codigo
        order by total desc
       """)
    List<FaturamentoTotemView> faturamentoPorTotem(LocalDateTime inicio, LocalDateTime fim);

}
