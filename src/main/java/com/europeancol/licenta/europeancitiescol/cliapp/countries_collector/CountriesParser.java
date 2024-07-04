package com.europeancol.licenta.europeancitiescol.cliapp.countries_collector;

import com.europeancol.licenta.europeancitiescol.entities.Country;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayDeque;

@Component
public class CountriesParser {
    public ArrayDeque<Country> collectCountries() {
        ArrayDeque<Country> countries = new ArrayDeque<>();
        WebClient client = WebClient.create("https://kering-group.opendatasoft.com");
        for (EUCountriesEnum euCountry : EUCountriesEnum.values()) {
            String countryCode = euCountry.getCountryCode();

            Country countryResponse = client.get()
                    .uri(uriBuilder -> uriBuilder.path("/api/explore/v2.1/catalog/datasets/geonames-countries/records")
                            .queryParam("select", "impact_country, population, capital, area, currency_code, currency_name, phone, iso_a2")
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
