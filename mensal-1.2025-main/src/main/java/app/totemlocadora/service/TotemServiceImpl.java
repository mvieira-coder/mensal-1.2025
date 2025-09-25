package app.totemlocadora.service;

import app.totemlocadora.model.Totem;
import app.totemlocadora.repository.TotemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TotemServiceImpl implements TotemService {

    private final TotemRepository totemRepository;

    public TotemServiceImpl(TotemRepository totemRepository) {
        this.totemRepository = totemRepository;
    }

    @Override
    public Totem criar(Totem t) { return totemRepository.save(t); }

    @Override
    public Totem atualizar(Long id, Totem novo) {
        Totem atual = buscar(id);
        novo.setId(atual.getId());
        return totemRepository.save(novo);
    }

    @Override
    public void deletar(Long id) { totemRepository.deleteById(id); }

    @Override
    public Totem buscar(Long id) {
        return totemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Totem não encontrado: " + id));
    }

    @Override
    public List<Totem> listar() { return totemRepository.findAll(); }

}
