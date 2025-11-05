package app.totemlocadora.service;
import app.totemlocadora.model.Veiculo;
import java.util.List;
public interface VeiculoService {
  Veiculo criar(Veiculo v);
  Veiculo atualizar(Long id, Veiculo v);
  void deletar(Long id);
  Veiculo buscar(Long id);
  List<Veiculo> listar();
  List<Veiculo> listarDisponiveis();
}
