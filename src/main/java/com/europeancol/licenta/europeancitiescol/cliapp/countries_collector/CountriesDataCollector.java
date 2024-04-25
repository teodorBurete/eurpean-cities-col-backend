package com.europeancol.licenta.europeancitiescol.cliapp.countries_collector;

import com.europeancol.licenta.europeancitiescol.entities.Country;
import com.europeancol.licenta.europeancitiescol.repositories.CountryRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayDeque;

@Component
public class CountriesDataCollector {
    private final CountryRepository countryRepository;
    private final CountriesParser countriesParser;

    public CountriesDataCollector(CountryRepository countryRepository, CountriesParser countriesParser) {
        this.countryRepository = countryRepository;
        this.countriesParser = countriesParser;
    }


    @Transactional
    public void saveCountries() {
        ArrayDeque<Country> countries = countriesParser.collectCountries();
        countryRepository.deleteAll();
        countryRepository.flush();
        countryRepository.saveAll(countries);
        //throw new RuntimeException();
    }


}
