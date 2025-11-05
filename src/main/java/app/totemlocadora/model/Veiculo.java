package app.totemlocadora.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import app.totemlocadora.model.enums.StatusVeiculo;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Veiculo {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String placa;
  private String modelo;
  private String categoria;
  private BigDecimal valorHora;
  @Enumerated(EnumType.STRING)
  private StatusVeiculo status = StatusVeiculo.DISPONIVEL;

  @OneToMany(mappedBy = "veiculo")
  @JsonIgnoreProperties({"veiculo","cliente","totem","acessorios"})
  private List<Locacao> locacoes = new ArrayList<>();
}
