package com.example.model;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Created by Karol on 23.12.2016.
 */
@Entity(name = "products")
@SequenceGenerator(initialValue = 1, name = "idGen", sequenceName = "productId")
@Table(name = "products")
public class mProduct extends mBaseObject {

    @NotNull
    private String name;

    @NotNull
    private double weight;

    @NotNull
    private double price;

    @NotNull
    private Long type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }
}
