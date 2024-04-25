package com.europeancol.licenta.europeancitiescol.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class PriceEntry {
    @Id
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
}
