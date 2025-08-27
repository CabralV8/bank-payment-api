package com.cabral.portifoliobank.domain.enums;

public enum StatusPagamentoEnum {
    PENDENTE,
    PROCESSADO_COM_SUCESSO,
    PROCESSADO_COM_FALHA;

    public static StatusPagamentoEnum fromString(String status) {
        for (StatusPagamentoEnum s : StatusPagamentoEnum.values()) {
            if (s.name().equalsIgnoreCase(status)) {
                return s;
            }
        }
        throw new IllegalArgumentException("Status de pagamento inválido: " + status);
    }


    public String getNome() {
        return this.name();
    }
}
