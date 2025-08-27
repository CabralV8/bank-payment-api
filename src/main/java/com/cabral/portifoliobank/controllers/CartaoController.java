package com.cabral.portifoliobank.controllers;

import com.cabral.portifoliobank.domain.models.CartaoCredito;
import com.cabral.portifoliobank.domain.models.CartaoDebito;
import com.cabral.portifoliobank.services.CartaoCreditoService;
import com.cabral.portifoliobank.services.CartaoDebitoService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cartao")
public class CartaoController {

    private final CartaoCreditoService cartaoCreditoService;
    private final CartaoDebitoService cartaoDebitoService;


    public CartaoController(CartaoCreditoService cartaoCreditoService, CartaoDebitoService cartaoDebitoService) {
        this.cartaoCreditoService = cartaoCreditoService;
        this.cartaoDebitoService = cartaoDebitoService;
    }

    @PostMapping("/debito")
    public ResponseEntity<CartaoDebito> criarCartaoDebito(@RequestBody @Valid CartaoDebito cartao) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cartaoDebitoService.save(cartao));
    }

    @PostMapping("/credito")
    public ResponseEntity<CartaoCredito> criarCartaoCredito(@RequestBody @Valid CartaoCredito cartao) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cartaoCreditoService.save(cartao));
    }
}
