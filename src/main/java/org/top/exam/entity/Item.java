package org.top.exam.entity;

import jakarta.persistence.*;

@Entity
@Table(name="item_t")

public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double price;
    private Boolean isInStock;
    @Override
    public String toString() {
        return id + " - " + name + " - " + price + " - " + isInStock;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getInStock() {
        return isInStock;
    }

    public void setInStock(Boolean inStock) {
        isInStock = inStock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
