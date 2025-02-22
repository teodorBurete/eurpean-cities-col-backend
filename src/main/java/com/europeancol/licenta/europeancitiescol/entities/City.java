package com.europeancol.licenta.europeancitiescol.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import jakarta.persistence.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Entity
@Table(name = "cities")
public class City implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id",nullable = false,unique = true)
    private Long id;
    @CsvBindByName
    @Column
    private String name;
    @CsvBindByName
    @Column
    private String countryCode;
    @CsvBindByName
    @Column
    private Boolean isCapital;
    @CsvBindByName
    @Column
    private Integer population;
    @CsvBindByName
    @Column
    private Double area;
    @CsvBindByName
    @Column
    private Double annualPopulationChange;
    @CsvBindByName
    @Column
    private Integer rankByPopulation;
    @CsvBindByName
    @Column
    private Double gdp;
    @CsvBindByName
    @Column
    private Double latitude;
    @CsvBindByName
    @Column
    private Double longitude;
    @ManyToOne
    @JoinColumn(name = "country_id")
    @JsonBackReference
    private Country country;
    public City() {
    }

    public String getName() {
        return name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public Boolean isCapital() {
        return isCapital;
    }

    public Integer getPopulation() {
        return population;
    }

    public Double getArea() {
        return area;
    }

    public Double getAnnualPopulationChange() {
        return annualPopulationChange;
    }

    public Integer getRankByPopulation() {
        return rankByPopulation;
    }

    public Double getGdp() {
        return gdp;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setIsCapital(Boolean capital) {
        isCapital = capital;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public void setAnnualPopulationChange(Double annualPopulationChange) {
        this.annualPopulationChange = annualPopulationChange;
    }

    public void setRankByPopulation(Integer rankByPopulation) {
        this.rankByPopulation = rankByPopulation;
    }

    public void setGdp(Double gdp) {
        this.gdp = gdp;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Country getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", isCapital=" + isCapital +
                ", population=" + population +
                ", area=" + area +
                ", annualPopulationChange=" + annualPopulationChange +
                ", rankByPopulation=" + rankByPopulation +
                ", gdp=" + gdp +
                '}';
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
