
package com.imperionite.algo.services;


import com.imperionite.algo.entities.Inventory;
import com.imperionite.algo.repositories.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

import java.util.List;

// Service class for business logic related to inventory management
@Service // Marks this class as a service component in Spring context
public class InventoryService {
    
    @Autowired // Automatically injects StockRepository bean into this service class
    private InventoryRepository inventoryRepository;

    public Inventory addInventory(Inventory inventory) {
        return inventoryRepository.save(inventory); // Saves a new stock item to the database
    }

    public void deleteInventoryByEngineNumber(String engineNumber) {
        inventoryRepository.deleteByEngineNumber(engineNumber); // Deletes stock by engine number
    }
    
    public void deleteIncorrectInventoryById(Long id) {
        inventoryRepository.deleteById(id);
    }

    public List<Inventory> sortInventoryByBrand() {
        return inventoryRepository.findAll(Sort.by("brand")); // Returns all stocks sorted by brand name
    }

    public List<Inventory> searchInventory(String criteria) {
        return inventoryRepository.findByEngineNumber(criteria); // Searches for stocks based on criteria (engine number)
    }
    
    public List<Inventory> getByBrandSorted(String brand) {
        return inventoryRepository.findByBrand(brand); 
    }
}
