package com.cabral.portifoliobank.controllers;

import com.cabral.portifoliobank.domain.dtos.AlterarPagamentoRecord;
import com.cabral.portifoliobank.domain.dtos.ExcluirPagamentoRecord;
import com.cabral.portifoliobank.domain.enums.StatusPagamentoEnum;
import com.cabral.portifoliobank.domain.models.Pagamento;
import com.cabral.portifoliobank.services.PagamentoService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pagamento")
public class TransacaoController {

    private final PagamentoService pagamentoService;

    public TransacaoController(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    @Transactional
    @PostMapping("/realizar")
    public ResponseEntity<String> realizarPagamento(@RequestBody @Valid Pagamento pagamento) {
        pagamentoService.realizarPagamento(pagamento);
        return ResponseEntity.ok("Pagamento realizado com sucesso!");
    }

    @GetMapping("/consultar")
    public ResponseEntity<Object> findAllPagamentos(@RequestParam(required = false) Long codigoDebito,
                                                    @RequestParam(required = false) String cpfCnpj,
                                                    @RequestParam(required = false) StatusPagamentoEnum status) {
        Optional<List<Pagamento>> product0 = Optional.ofNullable(pagamentoService.findAllPagamentos(codigoDebito, cpfCnpj, status));

        if (product0.isEmpty()) {
            return ResponseEntity.ok("Produto not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(product0);
    }

    @Transactional
    @PostMapping("/alterar")
    public ResponseEntity<String> alterarPagamento(@RequestBody @Valid AlterarPagamentoRecord pagamento){
        pagamentoService.alterarPagamento(pagamento);
        return ResponseEntity.ok("Pagamento alterado com sucesso!");
    }

    @Transactional
    @PostMapping("/excluir")
    public ResponseEntity<String> excluir(@RequestBody @Valid ExcluirPagamentoRecord pagamento){
        pagamentoService.excluirPagamento(pagamento);
        return ResponseEntity.ok("Pagamento alterado com sucesso!");
    }

}
