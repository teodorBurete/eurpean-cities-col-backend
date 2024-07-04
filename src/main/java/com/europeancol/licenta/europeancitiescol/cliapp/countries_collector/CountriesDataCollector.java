package com.europeancol.licenta.europeancitiescol.cliapp.countries_collector;

import com.europeancol.licenta.europeancitiescol.entities.Country;
import com.europeancol.licenta.europeancitiescol.repositories.CountryRepository;
import com.europeancol.licenta.europeancitiescol.services.CountryService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayDeque;

@Component
public class CountriesDataCollector {
    private final CountryService countryService;
    private final CountriesParser countriesParser;

    public CountriesDataCollector(CountryService countryService, CountriesParser countriesParser) {
        this.countryService = countryService;
        this.countriesParser = countriesParser;
    }


    @Transactional
    public void saveCountries() {
        ArrayDeque<Country> countries = countriesParser.collectCountries();
        countryService.saveCountries(countries);

    }
}
