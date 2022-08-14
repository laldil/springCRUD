package com.example.springCRUD.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GameModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name, description, img;
    private double price;

    public GameModel(){}

    public GameModel(String name, String description, String img, double price) {
        this.name = name;
        this.description = description;
        this.img = img;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
