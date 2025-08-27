package com.cabral.portifoliobank.repositories;

import com.cabral.portifoliobank.domain.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    boolean existsByCpf(String cpf);

    Optional<Pessoa> findByCpf(String cpf);
}
