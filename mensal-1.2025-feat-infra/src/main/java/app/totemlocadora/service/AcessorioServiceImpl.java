package app.totemlocadora.service;

import app.totemlocadora.model.Acessorio;
import app.totemlocadora.repository.AcessorioRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AcessorioServiceImpl implements AcessorioService {

    private final AcessorioRepository acessorioRepository;

    public AcessorioServiceImpl(AcessorioRepository acessorioRepository) {
        this.acessorioRepository = acessorioRepository;
    }

    @Override
    public List<Acessorio> findAll() {
        return acessorioRepository.findAll();
    }

    @Override
    public Acessorio save(Acessorio acessorio) {
        return acessorioRepository.save(acessorio);
    }

    @Override
    public void delete(Long id) {
        acessorioRepository.deleteById(id);
    }
}
