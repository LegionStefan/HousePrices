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

    // Private since I don't see a reason to expose this.
    private Integer getPrice() {
        return this.price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getPriceFormatted() {
        Locale currentLocale = new Locale.Builder().setLanguage("nl").setRegion("NL").build();
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(currentLocale);
        return numberFormat.format(this.price);
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
