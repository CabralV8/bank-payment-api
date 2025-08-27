package com.cabral.portifoliobank.domain.enums;

public enum EstadoCivilEnum {
    SOLTEIRO("Solteiro(a)"),
    CASADO("Casado(a)"),
    DIVORCIADO("Divorciado(a)"),
    VIUVO("Viúvo(a)");

    private final String descricao;


    EstadoCivilEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static EstadoCivilEnum fromDescricao(String descricao){
    for(EstadoCivilEnum estadoCivilEnum : EstadoCivilEnum.values()) {
        if (estadoCivilEnum.descricao.equalsIgnoreCase(descricao)) {
            return estadoCivilEnum;
        }
    }
throw new IllegalArgumentException("Descrição de estado cívil inválida: " + descricao);
    }
}
