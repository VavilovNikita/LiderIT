package com.liderit.liderit.dto;

import com.liderit.liderit.entity.Product;

import java.time.LocalDate;

public class ProductDto {
    public ProductDto(Product product) {
        this.id = product.getId();
        this.positionOnShowcase = product.getPosition_on_showcase();
        this.name = product.getName();
        this.type = product.getType();
        this.price = product.getPrice();
        this.createdAt = product.getCreatedAt();
        this.lastUpdateDate = product.getLastUpdateDate();
    }

    public ProductDto() {
    }

    private Long id;

    private String positionOnShowcase;

    private String name;

    private String type;

    private Double price;

    private LocalDate createdAt;

    private LocalDate lastUpdateDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPositionOnShowcase() {
        return positionOnShowcase;
    }

    public void setPositionOnShowcase(String positionOnShowcase) {
        this.positionOnShowcase = positionOnShowcase;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDate lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
}
