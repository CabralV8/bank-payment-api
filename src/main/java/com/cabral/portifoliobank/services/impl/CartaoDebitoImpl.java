package com.cabral.portifoliobank.services.impl;

import com.cabral.portifoliobank.domain.models.CartaoDebito;
import com.cabral.portifoliobank.repositories.CartaoDebitoRepository;
import com.cabral.portifoliobank.services.CartaoDebitoService;
import org.springframework.stereotype.Service;

@Service
public class CartaoDebitoImpl implements CartaoDebitoService {

    private final CartaoDebitoRepository cartaoDebitoRepository;

    public CartaoDebitoImpl(CartaoDebitoRepository cartaoDebitoRepository){
        this.cartaoDebitoRepository = cartaoDebitoRepository;
    }

    @Override
    public CartaoDebito save(CartaoDebito cartao) {
        return cartaoDebitoRepository.save(cartao);
    }
}
