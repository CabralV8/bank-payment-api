package com.cabral.portifoliobank.domain.dtos;

import com.cabral.portifoliobank.domain.enums.MetodoPagamentoEnum;
import jakarta.validation.constraints.*;

import java.io.Serializable;

public record PagamentoBoletoPixRecord (
        @NotBlank(message = "CPF ou CNPJ do pagador é obrigatório.")
        @Size(max = 14, message = "O número do CNPJ deve ter no máximo 14 caracteres")
        @Min(value = 11, message = "O número do CPF deve ter no mínimo 11 caracteres")
        String cpfCnpjPagador,

        @NotNull(message = "O método de pagamento é obrigatório")
        MetodoPagamentoEnum metodoPagamento,

        @NotNull(message = "O valor do pagamento é obrigatório")
        @DecimalMin(value = "0.01", message = "O valor do pagamento deve ser maior que zero")
        Double valorPagamento
) implements Serializable {
}
