package app.totemlocadora.service;
import app.totemlocadora.model.Acessorio;
import java.util.List;
public interface AcessorioService {
  Acessorio criar(Acessorio a);
  Acessorio atualizar(Long id, Acessorio a);
  void deletar(Long id);
  Acessorio buscar(Long id);
  List<Acessorio> listar();
}
