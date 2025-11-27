package app.totemlocadora.model;

import app.totemlocadora.model.enums.StatusLocacao;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "locacao")
@Getter @Setter
@JsonIgnoreProperties(
        value = {"cliente", "veiculo", "totem", "acessorios"},
        allowSetters = true
)
public class Locacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    @NotNull(message = "O campo cliente é obrigatório")
    @JsonIgnoreProperties({"locacoes"})
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "veiculo_id")
    @NotNull(message = "O campo veículo é obrigatório")
    @JsonIgnoreProperties({"locacoes"})
    private Veiculo veiculo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "totem_id")
    @NotNull(message = "O campo totem é obrigatório")
    @JsonIgnoreProperties({"locacoes"})
    private Totem totem;

    @NotNull(message = "O campo data de início é obrigatório")
    private LocalDateTime dataInicio;

    @NotNull(message = "O campo data de fim é obrigatório")
    private LocalDateTime dataFim;

    @Min(value = 1, message = "Horas deve ser maior que zero")
    private Integer horas;

    @Column(precision = 12, scale = 2)
    private BigDecimal valorTotal;

    @Enumerated(EnumType.STRING)
    private StatusLocacao status = StatusLocacao.PENDENTE;

    @ManyToMany
    @JoinTable(name = "locacao_acessorio",
            joinColumns = @JoinColumn(name = "locacao_id"),
            inverseJoinColumns = @JoinColumn(name = "acessorio_id"))
    @JsonIgnoreProperties({"locacoes"})
    private Set<Acessorio> acessorios = new HashSet<>();
}