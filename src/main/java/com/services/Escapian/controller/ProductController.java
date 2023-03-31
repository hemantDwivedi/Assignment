package com.services.Escapian.controller;

import com.services.Escapian.Entity.Product;
import com.services.Escapian.config.APIResponse;
import com.services.Escapian.payload.ProductDTO;
import com.services.Escapian.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/products")
public class ProductController {
    private ProductService productService;

    // Build create product api
    @PostMapping("/price/{priceId}")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO, @PathVariable int priceId){
        return new ResponseEntity<>(this.productService.createProduct(productDTO, priceId), HttpStatus.CREATED);
    }

    // Get product by id.
    // http://localhost:8080/api/products/1
    @GetMapping("{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable("id") Long productId){
        return new ResponseEntity<>(this.productService.getProductById(productId), HttpStatus.FOUND);
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProduct(){
        List<ProductDTO> productDTOList = this.productService.getAllProduct();
        return new ResponseEntity<>(productDTOList, HttpStatus.FOUND);
    }

    // Update product by id
    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable("id") Long productId, @RequestBody ProductDTO productDTO){
        return new ResponseEntity<>(this.productService.updateProduct(productId, productDTO), HttpStatus.OK);
    }


    // Delete product
    @DeleteMapping("{id}")
    public ResponseEntity<APIResponse> deleteProduct(@PathVariable("id") Long productId){
        this.productService.delete(productId);
        return new ResponseEntity<>(new APIResponse("Product deleted with id: " + productId), HttpStatus.OK);
    }

}
