package app.totemlocadora.controller;
import app.totemlocadora.model.Cliente;
import app.totemlocadora.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController 
@RequestMapping("/clientes") 
@RequiredArgsConstructor

public class ClienteController {
  private final ClienteService service;

  @PostMapping 
  public Cliente criar(@RequestBody Cliente c){ return service.criar(c); }

  @PutMapping("/{id}") 
  public Cliente atualizar(@PathVariable Long id, @RequestBody Cliente c){ return service.atualizar(id,c); }

  @DeleteMapping("/{id}") 
  public void deletar(@PathVariable Long id){ service.deletar(id); }

  @GetMapping("/{id}") 
  public Cliente buscar(@PathVariable Long id){ return service.buscar(id); }

  @GetMapping public List<Cliente> listar(@RequestParam(required=false) String nome){
    return (nome==null)? service.listar() : service.buscarPorNome(nome);
  }
}
