package com.liderit.liderit.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "showcase_id", referencedColumnName = "id")
    private Showcase showcase;

    @Column(name = "position_on_showcase")
    private String position_on_showcase;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "price")
    private String price;

    @Column(name = "created_at")
    @Temporal(TemporalType.DATE)
    private LocalDate createdAt;

    @Column(name = "last_update_date")
    @Temporal(TemporalType.DATE)
    private LocalDate lastUpdateDate;

    public Product(Long id, Showcase showcase, String position_on_showcase, String name, String type, String price, LocalDate created_at, LocalDate last_update_date) {
        this.id = id;
        this.showcase = showcase;
        this.position_on_showcase = position_on_showcase;
        this.name = name;
        this.type = type;
        this.price = price;
        this.createdAt = created_at;
        this.lastUpdateDate = last_update_date;
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Showcase getShowcase() {
        return showcase;
    }

    public void setShowcase(Showcase showcase) {
        this.showcase = showcase;
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

    public void setCreatedAt(LocalDate created_at) {
        this.createdAt = created_at;
    }

    public LocalDate getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDate last_update_date) {
        this.lastUpdateDate = last_update_date;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", showcase=" + showcase.getName() +
                ", position_on_showcase='" + position_on_showcase + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", price='" + price + '\'' +
                ", created_at=" + createdAt +
                ", last_update_date=" + lastUpdateDate +
                '}';
    }
}
