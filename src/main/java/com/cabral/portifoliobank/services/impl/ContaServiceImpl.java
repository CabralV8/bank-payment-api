package com.cabral.portifoliobank.services.impl;

import com.cabral.portifoliobank.domain.models.Conta;
import com.cabral.portifoliobank.repositories.ContaRepository;
import com.cabral.portifoliobank.services.ContaService;
import org.springframework.stereotype.Service;

@Service
public class ContaServiceImpl implements ContaService {


    private final ContaRepository contaRepository;

    public ContaServiceImpl(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    @Override
    public Conta save(Conta conta) {
        validarConta(conta);
        return contaRepository.save(conta);
    }

    private void validarConta(Conta conta) {
        // Se for conta de pessoa jurídica (CNPJ presente)
        if (conta.getCnpj() != null && !conta.getCnpj().isBlank()) {
            if (contaRepository.existsByCnpj(conta.getCnpj())) {
                throw new IllegalArgumentException("CNPJ já cadastrado: " + conta.getCnpj());
            }
        }

        // Se for conta de pessoa física (CPF do titular presente)
        if (conta.getTitular() != null && conta.getTitular().getCpf() != null) {
            if (contaRepository.existsByTitularCpf(conta.getTitular().getCpf())) {
                throw new IllegalArgumentException("Conta já cadastrada para CPF: " + conta.getTitular().getCpf());
            }
        }
    }
}
