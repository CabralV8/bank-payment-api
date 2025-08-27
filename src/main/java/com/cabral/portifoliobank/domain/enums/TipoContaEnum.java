package com.cabral.portifoliobank.domain.enums;

public enum TipoContaEnum {
    FISICA("Fisica"),
    JURIDICA("Juridica");
    private final String descricao;

    TipoContaEnum(String descricao) {
        this.descricao = descricao;
    }


    public static TipoContaEnum fromDescricao(String descricao) {
        for (TipoContaEnum tipoContaEnum : TipoContaEnum.values()) {
            if (tipoContaEnum.descricao.equalsIgnoreCase(descricao)) {
                return tipoContaEnum;
            }
        }
        throw new IllegalArgumentException("Descrição de tipo de conta inválida: " + descricao);
    }
}
