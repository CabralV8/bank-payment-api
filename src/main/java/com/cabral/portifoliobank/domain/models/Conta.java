package com.cabral.portifoliobank.domain.models;

import com.cabral.portifoliobank.domain.enums.TipoContaEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

@Entity
@Table(name = "conta")
public class Conta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O número da conta é obrigatório.")
    @Size(max = 20, message = "O número da conta deve ter no máximo 20 caracteres.")
    private String numeroConta;

    @NotNull(message = "O saldo é obrigatório.")
    private Double saldo;

    @Size(max = 14 , message = "O número da conta deve ter no máximo 14 caracteres.")
    private String cnpj;

    @NotNull(message = "O tipo de conta é obrigatório.")
    private TipoContaEnum tipoContaEnum;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa titular;

    public Long getId() {
        return id;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public TipoContaEnum getTipoConta() {
        return tipoContaEnum;
    }

    public Pessoa getTitular() {
        return titular;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public void setTipoConta(TipoContaEnum tipoContaEnum) {
        this.tipoContaEnum = tipoContaEnum;
    }

    public void setTitular(Pessoa titular) {
        this.titular = titular;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public TipoContaEnum getTipoContaEnum() {
        return tipoContaEnum;
    }

    public void setTipoContaEnum(TipoContaEnum tipoContaEnum) {
        this.tipoContaEnum = tipoContaEnum;
    }
}
