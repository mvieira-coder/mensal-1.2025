package app.totemlocadora.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import app.totemlocadora.model.enums.StatusLocacao;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Locacao {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private LocalDateTime dataInicio;
  private LocalDateTime dataFim;
  private Integer horas;
  private BigDecimal valorTotal;
  @Enumerated(EnumType.STRING)
  private StatusLocacao status = StatusLocacao.PENDENTE;

  @ManyToOne @JsonIgnoreProperties("locacoes")
  private Cliente cliente;

  @ManyToOne @JsonIgnoreProperties("locacoes")
  private Veiculo veiculo;

  @ManyToOne @JsonIgnoreProperties("locacoes")
  private Totem totem;

  @ManyToMany(mappedBy = "locacoes")
  @JsonIgnoreProperties({"locacoes"})
  private List<Acessorio> acessorios = new ArrayList<>();
}
