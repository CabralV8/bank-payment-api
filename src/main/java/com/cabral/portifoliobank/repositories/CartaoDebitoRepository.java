package com.cabral.portifoliobank.repositories;

import com.cabral.portifoliobank.domain.models.CartaoDebito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaoDebitoRepository extends JpaRepository<CartaoDebito, Long> {

    CartaoDebito findByContaCnpjOrContaTitularCpf(String cnpj, String cpf);

    CartaoDebito findByNumeroCartao(String numero);
}
