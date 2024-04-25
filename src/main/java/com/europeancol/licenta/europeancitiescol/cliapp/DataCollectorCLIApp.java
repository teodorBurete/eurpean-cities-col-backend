package com.europeancol.licenta.europeancitiescol.cliapp;

import com.europeancol.licenta.europeancitiescol.cliapp.countries_collector.CountriesDataCollector;
import com.europeancol.licenta.europeancitiescol.cliapp.numbeo_collector.NumbeoDataCollector;
import com.europeancol.licenta.europeancitiescol.cliapp.numbeo_collector.dtos.CityDTO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayDeque;

@Component
@Order(1)
public class DataCollectorCLIApp implements CommandLineRunner {
    CountriesDataCollector countriesDataCollector;
    NumbeoDataCollector numbeoDataCollector;

    public DataCollectorCLIApp(CountriesDataCollector countriesDataCollector, NumbeoDataCollector numbeoDataCollector) {
        this.countriesDataCollector = countriesDataCollector;
        this.numbeoDataCollector = numbeoDataCollector;
    }

    @Override
    public void run(String... args) throws InterruptedException {

        //countriesDataCollector.saveCountries();
        ArrayDeque<CityDTO> cities =  numbeoDataCollector.collectNumbeoData();
        cities.forEach(System.out::println);

    }
}
