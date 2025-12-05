package app.totemlocadora.service;

import app.totemlocadora.model.Totem;
import java.util.List;

public interface TotemService {
  Totem criar(Totem t);
  Totem atualizar(Long id, Totem novo);
  void deletar(Long id);
  Totem buscar(Long id);
  List<Totem> listar();
}
