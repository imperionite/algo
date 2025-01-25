package com.imperionite.algo.entities;

import com.imperionite.algo.utils.DateUtils;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "inventory")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate inventoryDate; // Date of stock entry

    @Column(nullable = false)
    private String status; // Status of stock in relation to previous 

    @Column(unique = true, nullable = false)
    private String engineNumber; // Unique engine number for the stock

    @Column(nullable = false)
    private String brand; // Brand of the stock

    @Column(nullable = false)
    private String purchasedStatus; // Purchase status of the stock

    // Getters and Setters
    public Long getId() {

        return id;

    }

    public void setId(Long id) {

        this.id = id;

    }

    public LocalDate getInventoryDate() {

        return inventoryDate;

    }

    // Method to set inventory date from string
    public void setInventoryDate(String dateString) {

        this.inventoryDate = LocalDate.parse(dateString, DateUtils.formatter);

    }

    public String getStatus() {

        return status;

    }

    public void setStatus(String status) {

        this.status = status;

    }
    
    public String getEngineNumber() {

        return engineNumber;

    }

    public void setEngineNumber(String engineNumber) {

        this.engineNumber = engineNumber;

    }
    
     public String getBrand() {

        return brand;

    }

    public void setBrand(String brand) {

        this.brand = brand;

    }
    
     public String getPurchasedStatus() {

        return purchasedStatus;

    }

    public void setPurchasedStatus(String purchasedStatus) {

        this.purchasedStatus = purchasedStatus;

    }

}
