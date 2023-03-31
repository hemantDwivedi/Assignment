package com.services.Escapian.repository;

import com.services.Escapian.Entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<Price, Integer> {
}
