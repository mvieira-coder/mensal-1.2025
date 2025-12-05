package app.totemlocadora.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "totem")
@Getter @Setter
@JsonIgnoreProperties({"locacoes"})
public class Totem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 30)
    @NotBlank(message = "O campo código é obrigatório")
    private String codigo;

    @NotBlank(message = "O campo local é obrigatório")
    private String local;

    @OneToMany(mappedBy = "totem")
    @JsonIgnoreProperties({"cliente", "veiculo", "totem", "acessorios"})
    private List<Locacao> locacoes = new ArrayList<>();
}