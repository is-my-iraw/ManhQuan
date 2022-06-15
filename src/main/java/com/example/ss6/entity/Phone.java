package com.example.ss6.entity;

import javax.persistence.*;

@Entity
@Table(name = "phone")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private String name;
    private int price;

    private String description;
    @Column(name = "brand_id")
    private int brandId;

    @ManyToOne()
    @JoinColumn(name = "brand_id", insertable = false, updatable = false)
    private Brand brand;

    public Phone() {
    }

    public Phone(String name, int price, String description, int brandId) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.brandId = brandId;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
