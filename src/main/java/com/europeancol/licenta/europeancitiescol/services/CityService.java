package com.europeancol.licenta.europeancitiescol.services;

import com.europeancol.licenta.europeancitiescol.entities.City;
import com.europeancol.licenta.europeancitiescol.entities.Country;
import com.europeancol.licenta.europeancitiescol.exceptions.ResourceNotFoundException;
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
        if (cityName.equals("Krakow-Cracow"))
            return cityRepository.findByName("Krakow").orElseThrow(() -> new ResourceNotFoundException("Could not find the following city: " + cityName));
        else if (cityName.equals("Gent"))
            return cityRepository.findByName("Ghent").orElseThrow(() -> new ResourceNotFoundException("Could not find the following city: " + cityName));
        else if (cityName.equals("The-Hague-Den-Haag-Netherlands"))
            return cityRepository.findByName("The Hague").orElseThrow(() -> new ResourceNotFoundException("Could not find the following city: " + cityName));
        else if (cityName.equals("Esch-sur-alzette-Luxembourg"))
            return cityRepository.findByName("Esch-sur-Alzette").orElseThrow(() -> new ResourceNotFoundException("Could not find the following city: " + cityName));
        else if (cityName.equals("Luxembourg"))
            return cityRepository.findByName("Luxembourg City").orElseThrow(() -> new ResourceNotFoundException("Could not find the following city: " + cityName));
        else if (cityName.equals("Differdange-Luxembourg"))
            return cityRepository.findByName("Differdange").orElseThrow(() -> new ResourceNotFoundException("Could not find the following city: " + cityName));
        else if (cityName.equals("Vila-Nova-De-Gaia-Portugal"))
            return cityRepository.findByName("Vila Nova de Gaia").orElseThrow(() -> new ResourceNotFoundException("Could not find the following city: " + cityName));
        else if (cityName.equals("Las-Palmas"))
            return cityRepository.findByName("Las Palmas").orElseThrow(() -> new ResourceNotFoundException("Could not find the following city: " + cityName));
        else if (cityName.equals("Daugavpils-Latvia"))
            return cityRepository.findByName("Daugavpils").orElseThrow(() -> new ResourceNotFoundException("Could not find the following city: " + cityName));
        else if (cityName.equals("Narva-Estonia"))
            return cityRepository.findByName("Narva").orElseThrow(() -> new ResourceNotFoundException("Could not find the following city: " + cityName));
        else if (cityName.equals("Aarhus-Denmark"))
            return cityRepository.findByName("Aarhus").orElseThrow(() -> new ResourceNotFoundException("Could not find the following city: " + cityName));


        return cityRepository.findByName(cityName).orElseThrow(() -> new ResourceNotFoundException("Could not find the following city: " + cityName));
    }

    public City findCityById(Long id) {
        return cityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Could not find city with id=" + id));
    }

    public List<City> searchCitiesByName(String query) {
        return cityRepository.findByNameContainingIgnoreCase(query);
    }

    public List<String> getAllCityNames() {
        return cityRepository.findAllCityNames();
    }
}
