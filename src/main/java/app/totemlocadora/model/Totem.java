package app.totemlocadora.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Totem {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String codigo;
  private String local;

  @OneToMany(mappedBy = "totem")
  @JsonIgnoreProperties({"totem","cliente","veiculo","acessorios"})
  private List<Locacao> locacoes = new ArrayList<>();
}
