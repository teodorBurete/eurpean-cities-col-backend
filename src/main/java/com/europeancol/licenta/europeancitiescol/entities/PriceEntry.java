package com.europeancol.licenta.europeancitiescol.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "price_entries")
public class PriceEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private City city;
    @Column
    private String name;
    @Column
    private String category;
    @Column
    private Double price;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public PriceEntry() {
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
