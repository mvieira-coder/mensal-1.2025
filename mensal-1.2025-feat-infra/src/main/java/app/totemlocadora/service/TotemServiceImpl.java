package app.totemlocadora.service;

import app.totemlocadora.model.Totem;
import app.totemlocadora.repository.TotemRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TotemServiceImpl implements TotemService {

    private final TotemRepository totemRepository;

    public TotemServiceImpl(TotemRepository totemRepository) {
        this.totemRepository = totemRepository;
    }

    @Override
    public List<Totem> findAll() {
        return totemRepository.findAll();
    }

    @Override
    public Totem save(Totem totem) {
        return totemRepository.save(totem);
    }

    @Override
    public void delete(Long id) {
        totemRepository.deleteById(id);
    }
}
