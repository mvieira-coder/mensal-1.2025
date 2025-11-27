package app.totemlocadora.service;

import app.totemlocadora.model.Cliente;
import java.util.List;

public interface ClienteService {
  Cliente criar(Cliente c);
  Cliente atualizar(Long id, Cliente novo);
  void deletar(Long id);
  Cliente buscar(Long id);
  List<Cliente> listar();
  List<Cliente> buscarPorNome(String nome);
}
