package com.services.Escapian.payload;

import com.services.Escapian.Entity.Price;
import lombok.Data;

@Data
public class ProductDTO {
    private long id;
    private String product_name;
    private String product_desc;

    private Price price;
}
