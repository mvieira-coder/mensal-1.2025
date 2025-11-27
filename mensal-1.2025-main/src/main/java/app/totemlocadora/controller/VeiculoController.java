package app.totemlocadora.controller;
import app.totemlocadora.model.Veiculo;
import app.totemlocadora.service.VeiculoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController 
@RequestMapping("/veiculos") 
@RequiredArgsConstructor

public class VeiculoController {
  private final VeiculoService service;

  @PostMapping 
  public Veiculo criar(@RequestBody Veiculo v){ return service.criar(v); }

  @PutMapping("/{id}") 
  public Veiculo atualizar(@PathVariable Long id, @RequestBody Veiculo v){ return service.atualizar(id,v); }

  @DeleteMapping("/{id}") 
  public void deletar(@PathVariable Long id){ service.deletar(id); }

  @GetMapping("/{id}") 
  public Veiculo buscar(@PathVariable Long id){ return service.buscar(id); }

  @GetMapping public List<Veiculo> listar(@RequestParam(required=false) Boolean disponiveis){
    return (disponiveis!=null && disponiveis)? service.listarDisponiveis() : service.listar();
  }
}
