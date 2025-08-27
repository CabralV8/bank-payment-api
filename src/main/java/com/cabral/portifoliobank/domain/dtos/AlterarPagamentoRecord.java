package com.cabral.portifoliobank.domain.dtos;

import com.cabral.portifoliobank.domain.enums.StatusPagamentoEnum;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

public record AlterarPagamentoRecord(@NotNull(message = "Id do pagamento é obrigatória.")
                                     Long id,

                                     @NotNull(message = "O método de pagamento é obrigatório.")
                                     StatusPagamentoEnum statusPagamento
)implements Serializable {
}
