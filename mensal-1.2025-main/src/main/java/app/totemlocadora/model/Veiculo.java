package app.totemlocadora.model;

import app.totemlocadora.model.enums.CategoriaVeiculo;
import app.totemlocadora.model.enums.StatusVeiculo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.DecimalMin;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "veiculo")
@Getter @Setter
@JsonIgnoreProperties({"locacoes"})
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 10)
    @NotBlank(message = "O campo placa é obrigatório")
    private String placa;

    @NotBlank(message = "O campo modelo é obrigatório")
    private String modelo;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "O campo categoria é obrigatório")
    private CategoriaVeiculo categoria;

    @Enumerated(EnumType.STRING)
    private StatusVeiculo status = StatusVeiculo.DISPONIVEL;

    @Column(precision = 12, scale = 2)
    @NotNull(message = "O campo valor por hora é obrigatório")
    @DecimalMin(value = "0.01", message = "Valor por hora deve ser maior que zero")
    private BigDecimal valorHora;

    @OneToMany(mappedBy = "veiculo")
    @JsonIgnoreProperties({"cliente", "veiculo", "totem", "acessorios"})
    private List<Locacao> locacoes = new ArrayList<>();
}