package com.services.Escapian.service;

import com.services.Escapian.Entity.Product;
import com.services.Escapian.payload.ProductDTO;

import java.util.List;


public interface ProductService {
    ProductDTO createProduct(ProductDTO product, int priceId);

    ProductDTO getProductById(Long productId);


    List<ProductDTO> getAllProduct();

    ProductDTO updateProduct(Long productId, ProductDTO productDTO);

    void delete(Long productId);
}
