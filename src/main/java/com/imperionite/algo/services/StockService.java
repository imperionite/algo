package com.imperionite.algo.services;

import com.imperionite.algo.entities.Stock;
import com.imperionite.algo.repositories.StockRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
import java.util.List;
import java.util.Optional;

@Service
public class StockService {
    @Autowired
    private StockRepository stockRepository;

    public Stock addStock(Stock stock) {
        return stockRepository.save(stock);
    }

    public void deleteStock(Long id) {
        stockRepository.deleteById(id);
    }

    public List<Stock> sortStocksByBrand() {
        return stockRepository.findAll(Sort.by("brand"));
    }
    
    public List<Stock> searchStockByEngineNumber(String criteria) {
        return stockRepository.findByEngineNumber(criteria); // Searches for stocks based on criteria (engine number)
    }

    public Optional<Stock> searchStockById(Long id) {
        return stockRepository.findById(id);
    }
}
