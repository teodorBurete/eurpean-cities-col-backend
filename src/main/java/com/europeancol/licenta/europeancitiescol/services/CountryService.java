package com.europeancol.licenta.europeancitiescol.services;

import com.europeancol.licenta.europeancitiescol.entities.Country;
import com.europeancol.licenta.europeancitiescol.repositories.CountryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CountryService {
    private final CountryRepository countryRepository;


    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }


    @Transactional
    public Country findCountryByCountryCode(String countryCode) {
        return countryRepository.findCountryByCountryCode(countryCode);
    }
}
