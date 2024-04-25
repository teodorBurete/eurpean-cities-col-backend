package com.europeancol.licenta.europeancitiescol.cliapp.countries_collector;

import com.europeancol.licenta.europeancitiescol.entities.Country;
import com.europeancol.licenta.europeancitiescol.repositories.CountryRepository;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayDeque;

@Component
public class CountriesParser {
    public ArrayDeque<Country> collectCountries() {
        java.util.ArrayDeque<com.europeancol.licenta.europeancitiescol.entities.Country> countries = new ArrayDeque<>();
        WebClient client = WebClient.create("https://kering-group.opendatasoft.com");
        for (EUCountriesEnum euCountry : EUCountriesEnum.values()) {
            String countryCode = euCountry.getCountryCode();

            com.europeancol.licenta.europeancitiescol.entities.Country countryResponse = client.get()
                    .uri(uriBuilder -> uriBuilder.path("/api/explore/v2.1/catalog/datasets/geonames-countries/records") ///?select=impact_country%2C%20population%2C%20area%2C%20currency_name%2C%20phone%2C%20continent&where=impact_country%20%3D%20%27Romania%27&limit=20")
                            .queryParam("select", "impact_country, population, capital, area, currency_code, currency_name, phone, iso_a2") //impact_country%2C%20population%2C%20area%2C%20currency_name%2C%20phone%2C%20continent
                            .queryParam("where", "iso_a2= '" + countryCode + "'")
                            .queryParam("limit", "1")
                            .build())
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToMono(CountryDTO.class)
                    .block().getCountry();
            System.out.println("Retrieved country: " + countryCode);
            countries.add(countryResponse);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        countries.forEach(System.out::println);
        return countries;
    }
}
