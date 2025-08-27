package com.cabral.portifoliobank.services.impl;

import com.cabral.portifoliobank.domain.models.CartaoCredito;
import com.cabral.portifoliobank.repositories.CartaoCreditoRepository;
import com.cabral.portifoliobank.services.CartaoCreditoService;
import org.springframework.stereotype.Service;

@Service
public class CartaoCreditoImpl implements CartaoCreditoService {

    private final CartaoCreditoRepository cartaoCreditoRepository;

    public CartaoCreditoImpl(CartaoCreditoRepository cartaoCreditoRepository){
        this.cartaoCreditoRepository = cartaoCreditoRepository;
    }

    @Override
    public CartaoCredito save(CartaoCredito cartao){
        return cartaoCreditoRepository.save(cartao);
    }
}
