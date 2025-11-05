package app.totemlocadora.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Acessorio {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nome;
  private BigDecimal taxaHora;

  @ManyToMany
  @JoinTable(name = "locacao_acessorio",
          joinColumns = @JoinColumn(name = "acessorio_id"),
          inverseJoinColumns = @JoinColumn(name = "locacao_id"))
  @JsonIgnoreProperties({"acessorios","cliente","veiculo","totem"})
  private List<Locacao> locacoes = new ArrayList<>();
}
