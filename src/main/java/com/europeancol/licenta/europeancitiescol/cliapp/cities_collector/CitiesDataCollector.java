package com.europeancol.licenta.europeancitiescol.cliapp.cities_collector;

import com.europeancol.licenta.europeancitiescol.entities.City;
import com.europeancol.licenta.europeancitiescol.repositories.CityRepository;
import com.europeancol.licenta.europeancitiescol.services.CityService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileNotFoundException;
import java.util.List;

@Component
public class CitiesDataCollector {

    private final CitiesCSVParser citiesCSVParser;
    private final CityService cityService;

    public CitiesDataCollector(CitiesCSVParser citiesCSVParser, CityService cityService) {
        this.citiesCSVParser = citiesCSVParser;
        this.cityService = cityService;
    }

    public void saveCities() throws FileNotFoundException {
        List<City> cities = citiesCSVParser.readCSV();
        cityService.saveCities(cities);
    }
}
