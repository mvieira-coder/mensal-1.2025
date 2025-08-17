package app.totemlocadora.controller;
import app.totemlocadora.model.Totem;
import app.totemlocadora.service.TotemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/totens") @RequiredArgsConstructor
public class TotemController {
  private final TotemService service;
  @PostMapping public Totem criar(@RequestBody Totem t){ return service.criar(t); }
  @PutMapping("/{id}") public Totem atualizar(@PathVariable Long id, @RequestBody Totem t){ return service.atualizar(id,t); }
  @DeleteMapping("/{id}") public void deletar(@PathVariable Long id){ service.deletar(id); }
  @GetMapping("/{id}") public Totem buscar(@PathVariable Long id){ return service.buscar(id); }
  @GetMapping public List<Totem> listar(){ return service.listar(); }
}
