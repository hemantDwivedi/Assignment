package com.services.Escapian.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String product_name;

    @Column(nullable = false)
    private String product_desc;

    @OneToOne(cascade = CascadeType.ALL)
    private Price price;
}
