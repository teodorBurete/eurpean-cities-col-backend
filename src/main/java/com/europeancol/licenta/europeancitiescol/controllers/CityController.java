package com.europeancol.licenta.europeancitiescol.controllers;

import com.europeancol.licenta.europeancitiescol.entities.City;
import com.europeancol.licenta.europeancitiescol.entities.Country;
import com.europeancol.licenta.europeancitiescol.services.CityService;
import com.europeancol.licenta.europeancitiescol.services.CountryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    public List<City> findAll() {
        return cityService.findAll();
    }

    @GetMapping("/{id}")
    public City findCityById(@PathVariable(value = "id") Long id) {
        return cityService.findCityById(id);
    }

    @GetMapping("/search")
    public List<City> searchCitiesByName(@RequestParam String query) {
        return cityService.searchCitiesByName(query);
    }
}
