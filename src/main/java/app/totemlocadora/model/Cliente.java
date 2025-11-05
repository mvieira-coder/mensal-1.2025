package app.totemlocadora.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Cliente {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nome;
  private String cpf;
  private String telefone;

  @OneToMany(mappedBy = "cliente")
  @JsonIgnoreProperties("cliente")
  private List<Locacao> locacoes = new ArrayList<>();
}
