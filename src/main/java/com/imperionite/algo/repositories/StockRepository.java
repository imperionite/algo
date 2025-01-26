package com.imperionite.algo.repositories;

import com.imperionite.algo.entities.Stock;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StockRepository extends JpaRepository<Stock, Long> {
    List<Stock> findByBrand(String brand); // Method to find stocks by brand
    List<Stock> findByEngineNumber(String engineNumber); // Method to find stocks by engine number
}
