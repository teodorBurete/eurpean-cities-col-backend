package com.europeancol.licenta.europeancitiescol.cliapp.numbeo_collector;

import com.europeancol.licenta.europeancitiescol.cliapp.numbeo_collector.dtos.CityDTO;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

@Component
public class NumbeoDataCollector {

    private final NumbeoDataParser numbeoDataParser;
    private static final List<String> cities = new ArrayList<>();

    static {
        cities.add("Bucharest");
       // cities.add("Thessaloniki");
    }

    public NumbeoDataCollector(NumbeoDataParser numbeoDataParser) {
        this.numbeoDataParser = numbeoDataParser;
    }

    public ArrayDeque<CityDTO> collectNumbeoData() throws InterruptedException {

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
                .uri("https://www.numbeo.com/cost-of-living/in/"+city+"?displayCurrency=EUR")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
