package app.totemlocadora.controller;
import app.totemlocadora.model.Locacao;
import app.totemlocadora.service.LocacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;
@RestController @RequestMapping("/locacoes") @RequiredArgsConstructor
public class LocacaoController {
  private final LocacaoService service;
  @PostMapping public Locacao criar(@RequestBody Locacao l){ return service.criar(l); }
  @PutMapping("/{id}") public Locacao atualizar(@PathVariable Long id, @RequestBody Locacao l){ return service.atualizar(id,l); }
  @DeleteMapping("/{id}") public void deletar(@PathVariable Long id){ service.deletar(id); }
  @GetMapping("/{id}") public Locacao buscar(@PathVariable Long id){ return service.buscar(id); }
  @GetMapping public List<Locacao> listar(){ return service.listar(); }
  @GetMapping("/relatorio/faturamento-por-totem")
  public List<Object[]> faturamento(@RequestParam String inicio, @RequestParam String fim){
    return service.faturamentoPorTotem(LocalDateTime.parse(inicio), LocalDateTime.parse(fim));
  }
}
