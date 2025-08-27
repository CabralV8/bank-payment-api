package com.cabral.portifoliobank.domain.enums;

public enum GeneroEnum {
    MASCULINO("Masculino"), FEMININO("Feminino"), OUTRO("Outro");

    private final String descricao;


    GeneroEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static GeneroEnum fromDescricao(String descricao) {
        for (GeneroEnum generoEnum : GeneroEnum.values()) {
            if (generoEnum.descricao.equalsIgnoreCase(descricao)) {
                return generoEnum;
            }
        }
    throw new IllegalArgumentException("Descrição de genêro inválida: " + descricao);
    }

}
