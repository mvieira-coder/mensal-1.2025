package app.totemlocadora.service;

import app.totemlocadora.dto.FaturamentoTotemView;
import app.totemlocadora.model.Locacao;

import java.time.LocalDateTime;
import java.util.List;

public interface LocacaoService {
  Locacao criar(Locacao l);
  Locacao atualizar(Long id, Locacao nova);
  void deletar(Long id);
  Locacao buscar(Long id);
  List<Locacao> listar();


  List<FaturamentoTotemView> faturamentoPorTotem(LocalDateTime inicio, LocalDateTime fim);

}
