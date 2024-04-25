package com.europeancol.licenta.europeancitiescol.cliapp.countries_collector;


import com.fasterxml.jackson.annotation.JsonSetter;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "countries")
public class Country implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private Integer population;
    @Column
    private String capitalCity;
    @Column
    private Double area;
    @Column
    private String currencyCode;
    @Column
    private String currencyName;
    @Column
    private Integer phone;
    @Column
    String countryCode;

    public Country() {
    }

    public Country(String name, Integer population, String capitalCity, Double area, String currencyCode, String currencyName, Integer phone, String countryCode) {
        this.name = name;
        this.population = population;
        this.capitalCity = capitalCity;
        this.area = area;
        this.currencyCode = currencyCode;
        this.currencyName = currencyName;
        this.phone = phone;
        this.countryCode = countryCode;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @JsonSetter("impact_country")
    public void setName(String name) {
        this.name = name;
    }

    public Integer getPopulation() {
        return population;
    }

    @JsonSetter("population")
    public void setPopulation(Integer population) {
        this.population = population;
    }

    public String getCapitalCity() {
        return capitalCity;
    }

    @JsonSetter("capital")
    public void setCapitalCity(String capitalCity) {
        this.capitalCity = capitalCity;
    }

    public Double getArea() {
        return area;
    }

    @JsonSetter("area")
    public void setArea(Double area) {
        this.area = area;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    @JsonSetter("currency_code")
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    @JsonSetter("currency_name")
    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public Integer getPhone() {
        return phone;
    }

    @JsonSetter("phone")
    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getCountryCode() {
        return countryCode;
    }

    @JsonSetter("iso_a2")
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", population=" + population +
                ", capitalCity='" + capitalCity + '\'' +
                ", area=" + area +
                ", currencyCode='" + currencyCode + '\'' +
                ", currencyName='" + currencyName + '\'' +
                ", phone=" + phone +
                '}';
    }
}
