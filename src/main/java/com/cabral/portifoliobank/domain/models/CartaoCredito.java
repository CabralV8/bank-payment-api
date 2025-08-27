package com.cabral.portifoliobank.domain.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;

@Entity
@Table(name = "cartao_credito")
public class CartaoCredito extends Cartao{

    @DecimalMin(value = "0.0", inclusive = false, message = "O Limite deve ser maior que zero.")
    private double limite;

    @Column(columnDefinition = "double default 0.0")
    private Double fatura = 0.0;

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public Double getFatura() {
        return fatura;
    }

    public void setFatura(Double fatura) {
        this.fatura = fatura;
    }
}
