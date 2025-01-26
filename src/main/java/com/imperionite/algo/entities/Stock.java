package com.imperionite.algo.entities;

import com.imperionite.algo.utils.DateUtils;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

@Entity
@Table(name = "stocks")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_entered", nullable = false)
    private LocalDate dateEntered; // Date of stock entry

    @Column(name = "stock_label", nullable = false)
    @Pattern(regexp = "Old|New", message = "Must be either 'Old' or 'New'")
    private String stockLabel; // Status of stock in relation to previous 

    @Column(name = "engine_number", unique = true, nullable = false)
    private String engineNumber; // Unique engine number for the stock

    @Column(name = "brand", nullable = false)
    private String brand; // Brand of the stock

    @Column(name = "status", nullable = false)
    @Pattern(regexp = "On-hand|Sold", message = "Must be either 'On-hand' or 'Sold'")
    private String status; // Purchase status of the stock

    // Default constructor (required for JPA)
    public Stock() {

    }

    // Constructor with paramaters
    public Stock(LocalDate dateEntered, String stockLabel, String brand, String engineNumber, String status) {
      this.dateEntered = dateEntered;
      this.stockLabel = stockLabel;
      this.brand = brand;
      this.engineNumber = engineNumber;
      this.status = status;
    }


    // Getters and Setters
    public Long getId() {

        return id;

    }

    public void setId(Long id) {

        this.id = id;

    }

    public LocalDate getDateEntered() {

        return dateEntered;

    }

    // Method to set stock date from string
    public void setDateEntered(String dateEntered) {

        this.dateEntered = LocalDate.parse(dateEntered, DateUtils.formatter);

    }

    public String getStockLabel() {

        return stockLabel;

    }

    public void setStockLabel(String stockLabel) {

        this.stockLabel = stockLabel;

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

    public String getStatus() {

        return status;

    }

    public void setStatus(String status) {

        this.status = status;

    }
    
   
}
