package com.europeancol.licenta.europeancitiescol.dto;

public class CityDTO {

    private Long id;
    private String name;
    private String countryCode;
    private Integer population;
    private Double area;
    private Double annualPopulationChange;
    private Double gdp;
    private Double latitude;
    private Double longitude;
    private Boolean isCapital;
    private Integer rankByPopulation;


    public Integer getRankByPopulation() {
        return rankByPopulation;
    }

    public void setRankByPopulation(Integer rankByPopulation) {
        this.rankByPopulation = rankByPopulation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getAnnualPopulationChange() {
        return annualPopulationChange;
    }

    public void setAnnualPopulationChange(Double annualPopulationChange) {
        this.annualPopulationChange = annualPopulationChange;
    }

    public Double getGdp() {
        return gdp;
    }

    public void setGdp(Double gdp) {
        this.gdp = gdp;
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

    public Boolean isCapital() {
        return isCapital;
    }

    public void setIsCapital(Boolean isCapital) {
        this.isCapital = isCapital;
    }
}

