package com.europeancol.licenta.europeancitiescol.cliapp;

import com.europeancol.licenta.europeancitiescol.cliapp.cities_collector.CitiesDataCollector;
import com.europeancol.licenta.europeancitiescol.cliapp.countries_collector.CountriesDataCollector;
import com.europeancol.licenta.europeancitiescol.cliapp.prices_collector.PricesDataCollector;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;

@Component
@Order(1)
public class DataCollectorCLIApp implements CommandLineRunner {
    private final CountriesDataCollector countriesDataCollector;
    private final PricesDataCollector pricesDataCollector;
    private final CitiesDataCollector citiesDataCollector;

    public DataCollectorCLIApp(CountriesDataCollector countriesDataCollector, PricesDataCollector pricesDataCollector, CitiesDataCollector citiesDataCollector) {
        this.countriesDataCollector = countriesDataCollector;
        this.pricesDataCollector = pricesDataCollector;
        this.citiesDataCollector = citiesDataCollector;
    }

    @Override
    public void run(String... args) throws InterruptedException, FileNotFoundException {

        //countriesDataCollector.saveCountries();
        //ArrayDeque<CityDTO> cities =  numbeoDataCollector.collectNumbeoData();
        // citiesDataCollector.saveCities();
        //     citiesDataCollector.saveCities();
        //pricesDataCollector.savePriceEntries();

    }
}
