package com.cabral.portifoliobank.domain.enums;

public enum MetodoPagamentoEnum {
    BOLETO,
    PIX,
    CARTAO_CREDITO,
    CARTAO_DEBITO;

    public static MetodoPagamentoEnum fromString(String metodo) {
        for (MetodoPagamentoEnum m : MetodoPagamentoEnum.values()) {
            if (m.name().equalsIgnoreCase(metodo)) {
                return m;
            }
        }
        throw new IllegalArgumentException("Método de pagamento inválido: " + metodo);
    }
    public String getNome() {
        return this.name();
    }
}
