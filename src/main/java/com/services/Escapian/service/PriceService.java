package com.services.Escapian.service;

import com.services.Escapian.payload.PriceDTO;

import java.util.List;

public interface PriceService {
    PriceDTO createPrice(PriceDTO priceDTO);
    PriceDTO updatePrice(int priceId, PriceDTO priceDTO);

    void deletePrice(int priceId);
}
