package app.totemlocadora.controller;
import app.totemlocadora.model.Acessorio;
import app.totemlocadora.service.AcessorioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/acessorios") @RequiredArgsConstructor
public class AcessorioController {
  private final AcessorioService service;
  @PostMapping public Acessorio criar(@RequestBody Acessorio a){ return service.criar(a); }
  @PutMapping("/{id}") public Acessorio atualizar(@PathVariable Long id, @RequestBody Acessorio a){ return service.atualizar(id,a); }
  @DeleteMapping("/{id}") public void deletar(@PathVariable Long id){ service.deletar(id); }
  @GetMapping("/{id}") public Acessorio buscar(@PathVariable Long id){ return service.buscar(id); }
  @GetMapping public List<Acessorio> listar(){ return service.listar(); }
}
