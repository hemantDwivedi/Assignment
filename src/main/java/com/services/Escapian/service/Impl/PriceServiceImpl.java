package com.services.Escapian.service.Impl;

import com.services.Escapian.Entity.Price;
import com.services.Escapian.config.ModelMap;
import com.services.Escapian.exception.ResourceNotFoundException;
import com.services.Escapian.payload.PriceDTO;
import com.services.Escapian.repository.PriceRepository;
import com.services.Escapian.repository.ProductRepository;
import com.services.Escapian.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    private PriceRepository priceRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMap modelMap;

    @Override
    public PriceDTO createPrice(PriceDTO priceDTO) {
        Price price = this.modelMap.modelMapper().map(priceDTO, Price.class);
        this.priceRepository.save(price);
        return this.modelMap.modelMapper().map(price, PriceDTO.class);
    }

    @Override
    public PriceDTO updatePrice(int priceId, PriceDTO priceDTO) {
        Price price = this.priceRepository.findById(priceId).orElseThrow(
                () -> new ResourceNotFoundException("product not found" + priceId)
        );
        price.setPrice(priceDTO.getPrice());
        this.priceRepository.save(price);
        return this.modelMap.modelMapper().map(price, PriceDTO.class);
    }

    @Override
    public void deletePrice(int priceId) {
        Price price = this.priceRepository.findById(priceId).orElseThrow(
                () -> new ResourceNotFoundException("product not found" + priceId)
        );

        this.priceRepository.delete(price);
    }
}
