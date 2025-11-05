package app.totemlocadora.service;
import app.totemlocadora.model.Locacao;
import java.time.LocalDateTime;
import java.util.List;
public interface LocacaoService {
  Locacao criar(Locacao l);
  Locacao atualizar(Long id, Locacao l);
  void deletar(Long id);
  Locacao buscar(Long id);
  List<Locacao> listar();
  List<Object[]> faturamentoPorTotem(LocalDateTime ini, LocalDateTime fim);
}
