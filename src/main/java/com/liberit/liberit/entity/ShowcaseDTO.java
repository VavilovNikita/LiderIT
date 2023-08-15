package com.liberit.liberit.entity;

import java.sql.Date;

public class ShowcaseDTO {
    public ShowcaseDTO(Showcase showcase) {
        this.id = showcase.getId();
        this.name = showcase.getName();
        this.type = showcase.getType();
        this.created_at = showcase.getCreated_at();
        this.last_update_date = showcase.getLast_update_date();
    }

    private int id;

    private String name;

    private String type;

    private Date created_at;

    private Date last_update_date;

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
