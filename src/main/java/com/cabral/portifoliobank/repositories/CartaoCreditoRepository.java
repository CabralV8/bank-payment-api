package com.cabral.portifoliobank.repositories;

import com.cabral.portifoliobank.domain.models.CartaoCredito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaoCreditoRepository extends JpaRepository<CartaoCredito, Long> {

    CartaoCredito findByContaCnpjOrContaTitularCpf(String cnpj, String cpf);

    CartaoCredito findByNumeroCartao(String numero);
}
