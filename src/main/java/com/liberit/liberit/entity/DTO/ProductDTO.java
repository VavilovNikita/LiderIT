package com.liberit.liberit.entity.DTO;

import com.liberit.liberit.entity.Product;

import java.sql.Date;

public class ProductDTO {
    public ProductDTO(Product product) {
        this.id = product.getId();
        this.position_on_showcase = product.getPosition_on_showcase();
        this.name = product.getName();
        this.type = product.getType();
        this.price = product.getPrice();
        this.created_at = product.getCreated_at();
        this.last_update_date = product.getLast_update_date();
    }

    private Long id;

    private String position_on_showcase;

    private String name;

    private String type;

    private String price;

    private Date created_at;

    private Date last_update_date;

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

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getLast_update_date() {
        return last_update_date;
    }

    public void setLast_update_date(Date last_update_date) {
        this.last_update_date = last_update_date;
    }
}
