package app.totemlocadora.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.DecimalMin;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "acessorio")
@Getter @Setter
@JsonIgnoreProperties({"locacoes"})
public class Acessorio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "O campo nome é obrigatório")
    private String nome;

    @Column(precision = 12, scale = 2)
    @NotNull(message = "O campo taxa por hora é obrigatório")
    @DecimalMin(value = "0.00", message = "Taxa por hora deve ser maior ou igual a zero")
    private BigDecimal taxaHora;

    @ManyToMany(mappedBy = "acessorios")
    @JsonIgnoreProperties({"cliente", "veiculo", "totem", "acessorios"})
    private Set<Locacao> locacoes = new HashSet<>();
}