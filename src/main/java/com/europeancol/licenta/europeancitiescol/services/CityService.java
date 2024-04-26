package com.europeancol.licenta.europeancitiescol.services;

import com.europeancol.licenta.europeancitiescol.entities.City;
import com.europeancol.licenta.europeancitiescol.entities.Country;
import com.europeancol.licenta.europeancitiescol.repositories.CityRepository;
import com.europeancol.licenta.europeancitiescol.repositories.CountryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CityService {

    private final CityRepository cityRepository;
    private final CountryService countryService;

    public CityService(CityRepository cityRepository, CountryService countryService) {
        this.cityRepository = cityRepository;
        this.countryService = countryService;
    }

    @Transactional
    public List<City> findAll() {
        return cityRepository.findAll();
    }

    @Transactional
    public void saveCities(List<City> cities) {
        cities.forEach(this::assignCountry);
        cityRepository.deleteAll();
        cityRepository.flush();
        cityRepository.saveAll(cities);
    }


    private void assignCountry(City city) {
        Country country = countryService.findCountryByCountryCode(city.getCountryCode());
        city.setCountry(country);
    }

    @Transactional
    public City findCityByName(String cityName) {
        return cityRepository.findByName(cityName);
    }
}
