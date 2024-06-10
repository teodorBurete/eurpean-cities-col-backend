package com.europeancol.licenta.europeancitiescol.entities;

import com.fasterxml.jackson.annotation.JsonSetter;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "country_economic_indicators")
public class CountryEconomicIndicators implements Serializable {
    @Id
    @Column(name = "country_id")
    private Long countryId;

    @Column
    private Double gdp;
    @Column
    private Double minimumWage;
    @Column
    private Double inflation;
    @Column
    private Double gdpGrowthRate;
    @Column
    private Double unemploymentRate;
    @Column
    private Double cpi;
    @Column
    private Double homeOwnershipRate;

    public CountryEconomicIndicators() {
    }

    public Long getCountryId() {
        return countryId;
    }

    @JsonSetter("country_id")
    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public Double getGdp() {
        return gdp;
    }

    @JsonSetter("gdp")
    public void setGdp(Double gdp) {
        this.gdp = gdp;
    }

    public Double getMinimumWage() {
        return minimumWage;
    }

    @JsonSetter("minimum_wage")
    public void setMinimumWage(Double minimumWage) {
        this.minimumWage = minimumWage;
    }

    public Double getInflation() {
        return inflation;
    }

    @JsonSetter("inflation")
    public void setInflation(Double inflation) {
        this.inflation = inflation;
    }

    public Double getGdpGrowthRate() {
        return gdpGrowthRate;
    }

    @JsonSetter("gdp_growth_rate")
    public void setGdpGrowthRate(Double gdpGrowthRate) {
        this.gdpGrowthRate = gdpGrowthRate;
    }

    public Double getUnemploymentRate() {
        return unemploymentRate;
    }

    @JsonSetter("unemployment_rate")
    public void setUnemploymentRate(Double unemploymentRate) {
        this.unemploymentRate = unemploymentRate;
    }

    public Double getCpi() {
        return cpi;
    }

    @JsonSetter("cpi")
    public void setCpi(Double cpi) {
        this.cpi = cpi;
    }

    public Double getHomeOwnershipRate() {
        return homeOwnershipRate;
    }

    @JsonSetter("home_ownership_rate")
    public void setHomeOwnershipRate(Double homeOwnershipRate) {
        this.homeOwnershipRate = homeOwnershipRate;
    }
}
