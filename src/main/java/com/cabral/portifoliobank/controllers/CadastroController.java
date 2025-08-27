package com.cabral.portifoliobank.controllers;

import com.cabral.portifoliobank.domain.models.Conta;
import com.cabral.portifoliobank.domain.models.Pessoa;
import com.cabral.portifoliobank.services.ContaService;
import com.cabral.portifoliobank.services.PessoaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cadastro")
public class CadastroController {

    private final PessoaService pessoaService;
    private final ContaService contaService;


    public CadastroController(PessoaService pessoaService, ContaService contaService) {
        this.pessoaService = pessoaService;
        this.contaService = contaService;
    }

    @PostMapping("/pessoa")
    public ResponseEntity<Pessoa> cadastrarPessoa(@RequestBody @Valid Pessoa pessoa){
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.save(pessoa));
    }

    @PostMapping("/conta")
    public ResponseEntity<Conta> cadastrarConta(@RequestBody @Valid Conta conta){
        return ResponseEntity.status(HttpStatus.CREATED).body(contaService.save(conta));
    }

}
