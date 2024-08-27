package com.example.demo.model;


import jakarta.persistence.*;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Currency;
import java.util.Locale;

@Entity
public class HousePrice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer price;
    private LocalDate date;

    public HousePrice() {}

    public HousePrice(Integer price, LocalDate date) {
        this.price = price;
        this.date = date;
    }

    public Integer getId() {
        return this.id;
    }

    public Integer getPrice() {
        return this.price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
