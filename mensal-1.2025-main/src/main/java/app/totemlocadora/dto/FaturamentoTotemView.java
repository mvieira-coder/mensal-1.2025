package app.totemlocadora.dto;

import java.math.BigDecimal;

public interface FaturamentoTotemView {
    Long getTotemId();
    String getCodigo();
    java.math.BigDecimal getTotal();
    Long getQuantidade();
}

