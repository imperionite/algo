package com.imperionite.algo.controllers;

import com.imperionite.algo.entities.Stock;
import com.imperionite.algo.services.StockService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
public class StockController {
    
    @Autowired
    private StockService stockService;

    @PostMapping
    public ResponseEntity<Stock> addStock(@RequestBody Stock stock) {
        return ResponseEntity.ok(stockService.addStock(stock));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStock(@PathVariable Long id) {
        stockService.deleteStock(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/sort")
    public ResponseEntity<List<Stock>> getSortedStocks() {
        return ResponseEntity.ok(stockService.sortStocksByBrand());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<Stock> getStockById(@PathVariable Long id) {
        return ResponseEntity.of(stockService.searchStockById(id));
    }
    
    @GetMapping("/criteria/{criteria}") // Endpoint to search for stocks 
    public ResponseEntity<List<Stock>> searchByEN(@PathVariable String criteria) {
        return ResponseEntity.ok(stockService.searchStockByEngineNumber(criteria)); // Returns list of found stocks 
    }
}
