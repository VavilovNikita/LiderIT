package com.liderit.liderit.entity.DTO;

import com.liderit.liderit.entity.Showcase;

import java.time.LocalDate;

public class ShowcaseDTO {
    public ShowcaseDTO(Showcase showcase) {
        this.id = showcase.getId();
        this.name = showcase.getName();
        this.address = showcase.getAddress();
        this.type = showcase.getType();
        this.createdAt = showcase.getCreatedAt();
        this.lastUpdateDate = showcase.getLastUpdateDate();
    }

    public ShowcaseDTO() {
    }

    private int id;

    private String name;

    private String address;

    private String type;

    private LocalDate createdAt;

    private LocalDate lastUpdateDate;

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

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDate lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
