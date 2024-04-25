package com.europeancol.licenta.europeancitiescol.cliapp.countries_collector;

import com.europeancol.licenta.europeancitiescol.entities.Country;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class CountryDTO implements Serializable {

    @JsonProperty("results")
    private List<Country> country;

    public CountryDTO() {
    }

    public CountryDTO(List<Country> country) {
        this.country = country;
    }

    public Country getCountry() {
        return country.get(0);
    }

    public void setCountry(List<Country> country) {
        this.country = country;
    }
}
