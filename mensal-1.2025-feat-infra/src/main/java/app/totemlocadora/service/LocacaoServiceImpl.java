package app.totemlocadora.service;

import app.totemlocadora.model.Locacao;
import app.totemlocadora.repository.LocacaoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LocacaoServiceImpl implements LocacaoService {

    private final LocacaoRepository locacaoRepository;

    public LocacaoServiceImpl(LocacaoRepository locacaoRepository) {
        this.locacaoRepository = locacaoRepository;
    }

    @Override
    public List<Locacao> findAll() {
        return locacaoRepository.findAll();
    }

    @Override
    public Locacao save(Locacao locacao) {
        return locacaoRepository.save(locacao);
    }

    @Override
    public void delete(Long id) {
        locacaoRepository.deleteById(id);
    }
}
