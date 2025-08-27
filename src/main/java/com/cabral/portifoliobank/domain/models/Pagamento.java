package com.cabral.portifoliobank.domain.models;

import com.cabral.portifoliobank.domain.enums.MetodoPagamentoEnum;
import com.cabral.portifoliobank.domain.enums.StatusPagamentoEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "pagamento")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoDebito;

    @Size(max = 14, message = "O número do CNPJ deve ter no máximo 14 caracteres.")
    @Min(value = 11, message = "O número do CPF deve ter no mínimo 11 caracteres.")
    private String cpfCnpjPagador;

    @NotNull(message = "O método do pagamento é obrigatório")
    private MetodoPagamentoEnum metodoPagamento;

    private String numeroCartao;

    @NotNull(message = "O valor do pagamento é obrigatório.")
    @DecimalMin(value = "0.01", message = "O valor do pagamento deve ser maior que zero.")
    private Double valorPagamento;

    private StatusPagamentoEnum statusPagamento;

    public Long getCodigoDebito() {
        return codigoDebito;
    }

    public void setCodigoDebito(Long codigoDebito) {
        this.codigoDebito = codigoDebito;
    }

    public String getCpfCnpjPagador() {
        return cpfCnpjPagador;
    }

    public void setCpfCnpjPagador(String cpfCnpjPagador) {
        this.cpfCnpjPagador = cpfCnpjPagador;
    }

    public MetodoPagamentoEnum getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(MetodoPagamentoEnum metodoPagamentoEnum) {
        this.metodoPagamento = metodoPagamentoEnum;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public Double getValorPagamento() {
        return valorPagamento;
    }

    public void setValorPagamento(Double valorPagamento) {
        this.valorPagamento = valorPagamento;
    }

    public StatusPagamentoEnum getStatus() {
        return statusPagamento;
    }

    public void setStatus(StatusPagamentoEnum statusPagamento) {
        this.statusPagamento = statusPagamento;
    }
}
