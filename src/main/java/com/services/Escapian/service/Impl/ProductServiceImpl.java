package com.services.Escapian.service.Impl;


import com.services.Escapian.Entity.Price;
import com.services.Escapian.Entity.Product;
import com.services.Escapian.config.ModelMap;
import com.services.Escapian.exception.ResourceNotFoundException;
import com.services.Escapian.payload.ProductDTO;
import com.services.Escapian.repository.PriceRepository;
import com.services.Escapian.repository.ProductRepository;
import com.services.Escapian.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMap modelMap;

    @Autowired
    private PriceRepository priceRepository;

    @Override
    public ProductDTO createProduct(ProductDTO productDTO, int priceId) {
        Product product = this.modelMap.modelMapper().map(productDTO, Product.class);
        Price price = this.priceRepository.findById(priceId).orElseThrow(
                () -> new ResourceNotFoundException("price not found id: " + priceId)
        );
        product.setPrice(price);
        this.productRepository.save(product);
        return this.modelMap.modelMapper().map(product, ProductDTO.class);
    }

    @Override
    public ProductDTO getProductById(Long productId) {
        Product product = this.productRepository.findById(productId).orElseThrow(
                () -> new ResourceNotFoundException("product not found" + productId)
        );
        return this.modelMap.modelMapper().map(product, ProductDTO.class);
    }

    @Override
    public List<ProductDTO> getAllProduct() {
        List<Product> productList = this.productRepository.findAll();

        return productList
                .stream()
                .map(
                        product -> this.modelMap.modelMapper().map(product, ProductDTO.class)
                ).collect(Collectors.toList());
    }

    @Override
    public ProductDTO updateProduct(Long productId, ProductDTO productDTO) {
        Product product = this.productRepository.findById(productId).orElseThrow(
                () -> new ResourceNotFoundException("product not found" + productId)
        );

        product.setProduct_name(productDTO.getProduct_name());
        product.setProduct_desc(productDTO.getProduct_desc());
        this.productRepository.save(product);
        return this.modelMap.modelMapper().map(product, ProductDTO.class);
    }

    @Override
    public void delete(Long productId) {
        Product product = this.productRepository.findById(productId).orElseThrow(
                () -> new ResourceNotFoundException("product not found" + productId)
        );

        this.productRepository.delete(product);
    }
}
