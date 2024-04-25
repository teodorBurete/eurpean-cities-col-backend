package com.europeancol.licenta.europeancitiescol.cliapp.numbeo_collector;

import com.europeancol.licenta.europeancitiescol.cliapp.numbeo_collector.dtos.CityDTO;
import com.europeancol.licenta.europeancitiescol.entities.PriceEntry;
import com.europeancol.licenta.europeancitiescol.services.PriceEntryService;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

@Component
public class NumbeoDataCollector {

    private final NumbeoDataParser numbeoDataParser;
    private final PriceEntryService priceEntryService;
    private final CityDTOConverter cityDTOConverter;
    private static final List<String> cities = new ArrayList<>();

    static {
        cities.add("Bucharest");
    }

    public NumbeoDataCollector(NumbeoDataParser numbeoDataParser, PriceEntryService priceEntryService, CityDTOConverter cityDTOConverter) {
        this.numbeoDataParser = numbeoDataParser;
        this.priceEntryService = priceEntryService;
        this.cityDTOConverter = cityDTOConverter;
    }

    private ArrayDeque<CityDTO> collectNumbeoData() throws InterruptedException {

        ArrayDeque<CityDTO> citiesData = new ArrayDeque<>();
        for (String city : cities) {
            try {
                System.out.println("CITY: " + city);
                String html = getResponse(city);
                citiesData.add(numbeoDataParser.parseData(html, city));

            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            Thread.sleep(4000); //to avoid suspicious behaviour
        }

        return citiesData;
    }

    private String getResponse(String city) throws IOException {
        WebClient client = WebClient.create();
        return client.get()
                .uri("https://www.numbeo.com/cost-of-living/in/" + city + "?displayCurrency=EUR")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    public void savePriceEntries() throws InterruptedException {
        ArrayDeque<CityDTO> cityDTOs = this.collectNumbeoData();
        for (CityDTO cityDTO : cityDTOs) {

            List<PriceEntry> priceEntries = cityDTOConverter.convertCityDTOtoPriceEntryList(cityDTO);
            priceEntryService.savePriceEntries(cityDTO.getCityName(), priceEntries);

        }
    }

}
