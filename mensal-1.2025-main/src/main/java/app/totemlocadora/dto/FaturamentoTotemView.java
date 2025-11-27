package app.totemlocadora.dto;

public interface FaturamentoTotemView {
    Long getTotemId();
    String getCodigo();
    java.math.BigDecimal getTotal();
    Long getQuantidade();
}

