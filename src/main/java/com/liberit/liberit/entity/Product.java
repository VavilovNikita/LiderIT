package com.liberit.liberit.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

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
    private Date created_at;

    @Column(name = "last_update_date")
    @Temporal(TemporalType.DATE)
    private Date last_update_date;

    public Product(int id, Showcase showcase, String position_on_showcase, String name, String type, String price, Date created_at, Date last_update_date) {
        this.id = id;
        this.showcase = showcase;
        this.position_on_showcase = position_on_showcase;
        this.name = name;
        this.type = type;
        this.price = price;
        this.created_at = created_at;
        this.last_update_date = last_update_date;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", showcase=" + showcase.getName() +
                ", position_on_showcase='" + position_on_showcase + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", price='" + price + '\'' +
                ", created_at=" + created_at +
                ", last_update_date=" + last_update_date +
                '}';
    }
}
