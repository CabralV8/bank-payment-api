package com.cabral.portifoliobank.domain.dtos;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

public record ExcluirPagamentoRecord(
        @NotNull(message = "Id do pagamento é obrigatória.")
        Long id) implements Serializable {
}
