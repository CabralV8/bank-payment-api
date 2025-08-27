package com.cabral.portifoliobank.services;

import com.cabral.portifoliobank.domain.dtos.AlterarPagamentoRecord;
import com.cabral.portifoliobank.domain.dtos.ExcluirPagamentoRecord;
import com.cabral.portifoliobank.domain.enums.StatusPagamentoEnum;
import com.cabral.portifoliobank.domain.models.Pagamento;

import java.util.List;

public interface PagamentoService {

    String realizarPagamento(Pagamento pagamento);

    List<Pagamento> findAllPagamentos(Long codigoDebito, String cpfCnpj, StatusPagamentoEnum status);

    String alterarPagamento(AlterarPagamentoRecord pagamento);

    String excluirPagamento(ExcluirPagamentoRecord pagamento);
}
