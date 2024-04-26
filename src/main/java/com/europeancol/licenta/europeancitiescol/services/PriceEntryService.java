package com.europeancol.licenta.europeancitiescol.services;

import com.europeancol.licenta.europeancitiescol.cliapp.numbeo_collector.dtos.CityDTO;
import com.europeancol.licenta.europeancitiescol.entities.City;
import com.europeancol.licenta.europeancitiescol.entities.PriceEntry;
import com.europeancol.licenta.europeancitiescol.repositories.PriceEntryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayDeque;
import java.util.List;

@Service
public class PriceEntryService {

    private final PriceEntryRepository priceEntryRepository;
    private final CityService cityService;

    public PriceEntryService(PriceEntryRepository priceEntryRepository, CityService cityService) {
        this.priceEntryRepository = priceEntryRepository;
        this.cityService = cityService;
    }

    @Transactional
    public void savePriceEntries(String cityName, List<PriceEntry> priceEntries) {

        City city = cityService.findCityByName(cityName);
        priceEntries.forEach(priceEntry -> priceEntry.setCity(city));

        priceEntryRepository.deleteAllByCity(city);
        priceEntryRepository.flush();
        priceEntryRepository.saveAll(priceEntries);
    }


    public List<PriceEntry> getByCityId(Long cityId) {
        return priceEntryRepository.findAllByCityId(cityId);
    }
}
