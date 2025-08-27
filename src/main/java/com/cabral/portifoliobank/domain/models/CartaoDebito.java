package com.cabral.portifoliobank.domain.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "cartao_debito")
public class CartaoDebito extends Cartao {

    public Double getSaldo() {
        return getConta().getSaldo();
    }

    public void setSaldo(Double saldo) {
        getConta().setSaldo(saldo);
    }
}
