package com.cabral.portifoliobank.repositories;

import com.cabral.portifoliobank.domain.models.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {

    Conta findByTitularCpf(String cpf);

    boolean existsByCnpj(String cnpj);

    boolean existsByTitularCpf(String cpf);

    Conta findByCnpjOrTitularCpf(String cnpj, String cpf);

    Optional<Conta> findByCnpj(String cnpj);
}
