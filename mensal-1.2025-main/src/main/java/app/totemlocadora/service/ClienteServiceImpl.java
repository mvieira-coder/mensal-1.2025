package app.totemlocadora.service;

import app.totemlocadora.model.Cliente;
import app.totemlocadora.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente criar(Cliente c) { return clienteRepository.save(c); }

    @Override
    public Cliente atualizar(Long id, Cliente novo) {
        Cliente atual = buscar(id);
        novo.setId(atual.getId());
        return clienteRepository.save(novo);
    }

    @Override
    public void deletar(Long id) { clienteRepository.deleteById(id); }

    @Override
    public Cliente buscar(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado: " + id));
    }

    @Override
    public List<Cliente> listar() { return clienteRepository.findAll(); }

    @Override
    public List<Cliente> buscarPorNome(String nome) {
        return clienteRepository.findByNomeContainingIgnoreCase(nome);
    }

}
