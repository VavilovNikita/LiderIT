package com.liderit.liderit.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "showcase")
public class Showcase {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @OneToMany(mappedBy = "showcase", fetch = FetchType.LAZY)
    private List<Product> product;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "type")
    private String type;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "last_update_date")
    private LocalDate lastUpdateDate;

    public Showcase() {
    }

    public Showcase(String name, String address, String type, LocalDate createdAt, LocalDate lastUpdateDate) {
        this.name = name;
        this.address = address;
        this.type = type;
        this.createdAt = createdAt;
        this.lastUpdateDate = lastUpdateDate;
    }

    public Showcase(int id, List<Product> product, String name, String address, String type, LocalDate created_at, LocalDate last_update_date) {
        this.id = id;
        this.product = product;
        this.name = name;
        this.address = address;
        this.type = type;
        this.createdAt = created_at;
        this.lastUpdateDate = last_update_date;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate created_at) {
        this.createdAt = created_at;
    }

    public LocalDate getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDate last_update_date) {
        this.lastUpdateDate = last_update_date;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
