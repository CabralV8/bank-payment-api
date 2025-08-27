package com.cabral.portifoliobank.domain.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

@MappedSuperclass
public abstract class Cartao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O número do cartão é obrigatório.")
    @Size(max = 20, message = "O número do cartão deve ter no máximo 20 caracteres.")
    @Pattern(regexp = "\\d{16,20}", message = "O número do cartão deve conter apenas dígitos e ter entre 16 e 20 caracteres.")
    private String numeroCartao;

    @NotBlank(message = "O nome do titular é obrigatório.")
    @Size(max = 100, message = "O nome do titular deve ter no máximo 100 caracteres.")
    private String nomeTitular;

    @NotBlank(message = "A data de validade é obrigatória")
    @Pattern(regexp = "(0[1-9]|1[0-2])/[0-9]{2}", message = "A data de validade deve estar no formato MM/AA")
    private String dataValidade;

    @NotBlank(message = "O CVV é obrigatório")
    @Pattern(regexp = "\\d{3,4}", message = "O CVV deve conter apenas 3 ou 4 dígitos")
    private String cvv;

    @ManyToOne
    @JoinColumn(name = "conta_id")
    private Conta conta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
}
