package com.liderit.liderit.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@SequenceGenerator(name = "showcase_sequence", initialValue = 5, sequenceName = "showcase_sequence")
@Table(name = "showcase")
public class Showcase {
    @Id
    @GeneratedValue(generator = "showcase_id_sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "showcase_id_sequence", initialValue = 5, sequenceName = "showcase_id_sequence")
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

    public Showcase(List<Product> product, String name, String address, String type, LocalDate createdAt, LocalDate lastUpdateDate) {
        this.product = product;
        this.name = name;
        this.address = address;
        this.type = type;
        this.createdAt = createdAt;
        this.lastUpdateDate = lastUpdateDate;
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
