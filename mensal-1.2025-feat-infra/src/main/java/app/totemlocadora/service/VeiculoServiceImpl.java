package app.totemlocadora.service;

import app.totemlocadora.model.Veiculo;
import app.totemlocadora.repository.VeiculoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VeiculoServiceImpl implements VeiculoService {

    private final VeiculoRepository veiculoRepository;

    public VeiculoServiceImpl(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    @Override
    public List<Veiculo> findAll() {
        return veiculoRepository.findAll();
    }

    @Override
    public Veiculo save(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    @Override
    public void delete(Long id) {
        veiculoRepository.deleteById(id);
    }
}
