package com.europeancol.licenta.europeancitiescol.cliapp;

import com.europeancol.licenta.europeancitiescol.cliapp.cities_collector.CitiesDataCollector;
import com.europeancol.licenta.europeancitiescol.cliapp.countries_collector.CountriesDataCollector;
import com.europeancol.licenta.europeancitiescol.cliapp.numbeo_collector.NumbeoDataCollector;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;

@Component
@Order(1)
public class DataCollectorCLIApp implements CommandLineRunner {
    private final CountriesDataCollector countriesDataCollector;
    private final NumbeoDataCollector numbeoDataCollector;
    private final CitiesDataCollector citiesDataCollector;

    public DataCollectorCLIApp(CountriesDataCollector countriesDataCollector, NumbeoDataCollector numbeoDataCollector, CitiesDataCollector citiesDataCollector) {
        this.countriesDataCollector = countriesDataCollector;
        this.numbeoDataCollector = numbeoDataCollector;

        this.citiesDataCollector = citiesDataCollector;
    }

    @Override
    public void run(String... args) throws InterruptedException, FileNotFoundException {

        //countriesDataCollector.saveCountries();
        //ArrayDeque<CityDTO> cities =  numbeoDataCollector.collectNumbeoData();
         // citiesDataCollector.saveCities();
       // numbeoDataCollector.savePriceEntries();

    }
}
