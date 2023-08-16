package com.liderit.liderit.entity.DTO;

import com.liderit.liderit.entity.Product;

import java.time.LocalDate;

public class ProductDTO {
    public ProductDTO(Product product) {
        this.id = product.getId();
        this.position_on_showcase = product.getPosition_on_showcase();
        this.name = product.getName();
        this.type = product.getType();
        this.price = product.getPrice();
        this.createdAt = product.getCreatedAt();
        this.lastUpdateDate = product.getLastUpdateDate();
    }

    public ProductDTO() {
    }

    private Long id;

    private String position_on_showcase;

    private String name;

    private String type;

    private String price;

    private LocalDate createdAt;

    private LocalDate lastUpdateDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPosition_on_showcase() {
        return position_on_showcase;
    }

    public void setPosition_on_showcase(String position_on_showcase) {
        this.position_on_showcase = position_on_showcase;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
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
