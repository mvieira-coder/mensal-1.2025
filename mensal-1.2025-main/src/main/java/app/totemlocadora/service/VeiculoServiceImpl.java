package app.totemlocadora.service;

import app.totemlocadora.model.Veiculo;
import app.totemlocadora.model.enums.StatusVeiculo;
import app.totemlocadora.repository.VeiculoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VeiculoServiceImpl implements VeiculoService {

    private final VeiculoRepository veiculoRepository;

    public VeiculoServiceImpl(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    @Override
    public Veiculo criar(Veiculo v) { return veiculoRepository.save(v); }

    @Override
    public Veiculo atualizar(Long id, Veiculo novo) {
        Veiculo atual = buscar(id);
        novo.setId(atual.getId());
        return veiculoRepository.save(novo);
    }

    @Override
    public void deletar(Long id) { veiculoRepository.deleteById(id); }

    @Override
    public Veiculo buscar(Long id) {
        return veiculoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Veículo não encontrado: " + id));
    }

    @Override
    public List<Veiculo> listar() { return veiculoRepository.findAll(); }

    @Override
    public List<Veiculo> listarDisponiveis() {
        return veiculoRepository.findByStatus(StatusVeiculo.DISPONIVEL);
    }

}
