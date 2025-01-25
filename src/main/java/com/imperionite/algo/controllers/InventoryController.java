package com.imperionite.algo.controllers;

import com.imperionite.algo.entities.Inventory;
import com.imperionite.algo.services.InventoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// REST Controller for handling HTTP requests related to inventory management
@RestController // Marks this class as a REST controller 
@RequestMapping("/api") // Base URL for all endpoints in this controller 
public class InventoryController {
    
    @Autowired // Automatically injects InventoryService bean into this controller 
    private InventoryService inventoryService;

    @PostMapping("/inventory") // Endpoint to add new stocks 
    public ResponseEntity<Inventory> addInventory(@RequestBody Inventory inventory) {
        return ResponseEntity.ok(inventoryService.addInventory(inventory)); // Returns added stock item 
    }

    @DeleteMapping("/inventory/{engineNumber}") // Endpoint to delete stocks by engine number 
    public ResponseEntity<Void> deleteInventoryByEngineNumber(@PathVariable String engineNumber) {
        inventoryService.deleteInventoryByEngineNumber(engineNumber); // Calls service method to delete stock 
        return ResponseEntity.noContent().build(); // Returns 204 No Content response 
    }
    
    @DeleteMapping("/inventory/{id}")
    public ResponseEntity<Void> deleteIncorrectInventory(@PathVariable Long id) {
        inventoryService.deleteIncorrectInventoryById(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/inventory/sorted") // Endpoint to get sorted stocks 
    public ResponseEntity<List<Inventory>> sortInventory() {
        return ResponseEntity.ok(inventoryService.sortInventoryByBrand()); // Returns sorted list of stocks 
    }
    
    @GetMapping("/inventory/sorted/{brand}") // Endpoint to get stocks of a specific brand 
    public ResponseEntity<List<Inventory>> getStocksByBrand(@PathVariable String brand) {
        return ResponseEntity.ok(inventoryService.getByBrandSorted(brand)); // Returns list of stocks for the specified brand sorted by date descending
    }

    @GetMapping("/inventory/search/{criteria}") // Endpoint to search for stocks 
    public ResponseEntity<List<Inventory>> searchInventory(@PathVariable String criteria) {
        return ResponseEntity.ok(inventoryService.searchInventory(criteria)); // Returns list of found stocks 
    }
}