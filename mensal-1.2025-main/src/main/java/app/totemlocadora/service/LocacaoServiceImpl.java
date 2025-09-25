package app.totemlocadora.service;

import app.totemlocadora.dto.FaturamentoTotemView;
import app.totemlocadora.model.Locacao;
import app.totemlocadora.repository.LocacaoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class LocacaoServiceImpl implements LocacaoService {

    private final LocacaoRepository locacaoRepository;

    public LocacaoServiceImpl(LocacaoRepository locacaoRepository) {
        this.locacaoRepository = locacaoRepository;
    }

    @Override
    public Locacao criar(Locacao l) { return locacaoRepository.save(l); }

    @Override
    public Locacao atualizar(Long id, Locacao nova) {
        Locacao atual = buscar(id);
        nova.setId(atual.getId());
        return locacaoRepository.save(nova);
    }

    @Override
    public void deletar(Long id) { locacaoRepository.deleteById(id); }

    @Override
    public Locacao buscar(Long id) {
        return locacaoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Locação não encontrada: " + id));
    }

    @Override
    public List<Locacao> listar() { return locacaoRepository.findAll(); }


    @Override
    @Transactional(readOnly = true)
    public List<FaturamentoTotemView> faturamentoPorTotem(LocalDateTime inicio, LocalDateTime fim) {
        return locacaoRepository.faturamentoPorTotem(inicio, fim);
    }

}
