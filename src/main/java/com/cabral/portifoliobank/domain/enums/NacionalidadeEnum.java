package com.cabral.portifoliobank.domain.enums;

public enum NacionalidadeEnum {

    BRASILEIRA("Brasileira"), ESTRANGEIRA("Estrangeira");

    private final  String descricao;

    NacionalidadeEnum(String descricao) {
        this.descricao = descricao;
    }

    public NacionalidadeEnum fromDescricao(String descricao){
        for (NacionalidadeEnum nacionalidadeEnum : NacionalidadeEnum.values()){
            if (nacionalidadeEnum.descricao.equalsIgnoreCase(descricao)) {
                return nacionalidadeEnum;
            }
        }
        throw new IllegalArgumentException("Descrição de nacionalidade inválida: " + descricao);
    }
}
