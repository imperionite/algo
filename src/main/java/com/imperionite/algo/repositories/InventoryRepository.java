package com.imperionite.algo.repositories;

import com.imperionite.algo.entities.Inventory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository; // Import JPA repository interface

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    List<Inventory> findByBrand(String brand); // Method to find stocks by brand

    List<Inventory> findByEngineNumber(String engineNumber); // Method to find stocks by engine number

    void deleteByEngineNumber(String engineNumber); // Method to delete stocks by engine number
    
}
