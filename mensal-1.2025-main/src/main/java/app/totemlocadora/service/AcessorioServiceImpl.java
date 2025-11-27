package app.totemlocadora.service;

import app.totemlocadora.model.Acessorio;
import app.totemlocadora.repository.AcessorioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AcessorioServiceImpl implements AcessorioService {

    private final AcessorioRepository acessorioRepository;

    public AcessorioServiceImpl(AcessorioRepository acessorioRepository) {
        this.acessorioRepository = acessorioRepository;
    }

    @Override
    public Acessorio criar(Acessorio a) { return acessorioRepository.save(a); }

    @Override
    public Acessorio atualizar(Long id, Acessorio novo) {
        Acessorio atual = buscar(id);
        novo.setId(atual.getId());
        return acessorioRepository.save(novo);
    }

    @Override
    public void deletar(Long id) { acessorioRepository.deleteById(id); }

    @Override
    public Acessorio buscar(Long id) {
        return acessorioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Acessório não encontrado: " + id));
    }

    @Override
    public List<Acessorio> listar() { return acessorioRepository.findAll(); }

}
