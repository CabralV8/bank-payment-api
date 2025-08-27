package com.cabral.portifoliobank.services.impl;

import com.cabral.portifoliobank.domain.models.Pessoa;
import com.cabral.portifoliobank.repositories.PessoaRepository;
import com.cabral.portifoliobank.services.PessoaService;
import org.springframework.stereotype.Service;

@Service
public class PessoaServiceImpl implements PessoaService{

    private final PessoaRepository pessoaRepository;

    public PessoaServiceImpl(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @Override
    public Pessoa save(Pessoa pessoa) {
        validarCpf(pessoa.getCpf());
        return pessoaRepository.save(pessoa);
    }

    private void validarCpf(String cpf) {
        if (pessoaRepository.existsByCpf(cpf)) {
            throw new IllegalArgumentException("CPF já cadastrado: " + cpf);
        }
    }
}
