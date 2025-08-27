package com.cabral.portifoliobank.repositories;

import com.cabral.portifoliobank.domain.models.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long>, PagingAndSortingRepository<Pagamento, Long>, JpaSpecificationExecutor<Pagamento> {
}
