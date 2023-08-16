package com.liderit.liderit.entity.DTO;

import com.liderit.liderit.entity.Showcase;

import java.time.LocalDate;

public class ShowcaseDTO {
    public ShowcaseDTO(Showcase showcase) {
        this.id = showcase.getId();
        this.name = showcase.getName();
        this.address = showcase.getAddress();
        this.type = showcase.getType();
        this.created_at = showcase.getCreatedAt();
        this.last_update_date = showcase.getLastUpdateDate();
    }

    public ShowcaseDTO() {
    }

    private int id;

    private String name;

    private String address;

    private String type;

    private LocalDate created_at;

    private LocalDate last_update_date;

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

    public LocalDate getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }

    public LocalDate getLast_update_date() {
        return last_update_date;
    }

    public void setLast_update_date(LocalDate last_update_date) {
        this.last_update_date = last_update_date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
