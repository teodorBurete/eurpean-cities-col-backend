package com.europeancol.licenta.europeancitiescol.services;

import com.europeancol.licenta.europeancitiescol.entities.Country;
import com.europeancol.licenta.europeancitiescol.exceptions.ResourceNotFoundException;
import com.europeancol.licenta.europeancitiescol.repositories.CountryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayDeque;
import java.util.List;

@Service
public class CountryService {
    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public Country findCountryByCountryCode(String countryCode) {
        return countryRepository.findCountryByCountryCode(countryCode).orElseThrow(() ->
                new ResourceNotFoundException("Could not find country with code: " + countryCode));
    }

    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    public Country findCountryById(Long id) {
        return countryRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Could not find country with id: " + id));
    }

    @Transactional
    public void saveCountries(ArrayDeque<Country> countries) {
        countryRepository.deleteAll();
        countryRepository.flush();
        countryRepository.saveAll(countries);
    }
}
