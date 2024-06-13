package com.europeancol.licenta.europeancitiescol.services;

import com.europeancol.licenta.europeancitiescol.dto.CityDTO;
import com.europeancol.licenta.europeancitiescol.dto.CategoryDTO;
import com.europeancol.licenta.europeancitiescol.dto.CityPriceResponseDTO;
import com.europeancol.licenta.europeancitiescol.dto.PriceEntryDTO;
import com.europeancol.licenta.europeancitiescol.entities.City;
import com.europeancol.licenta.europeancitiescol.entities.PriceEntry;
import com.europeancol.licenta.europeancitiescol.exceptions.ResourceNotFoundException;
import com.europeancol.licenta.europeancitiescol.repositories.PriceEntryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public CityPriceResponseDTO getCityPriceResponse(Long cityId) {
        City city = cityService.findCityById(cityId);

        List<PriceEntry> priceEntries = priceEntryRepository.findAllByCityId(cityId);

        CityDTO cityDTO = convertToCityDTO(city);
        List<CategoryDTO> categoryDTOs = convertToCategoryDTOs(priceEntries);

        CityPriceResponseDTO responseDTO = new CityPriceResponseDTO();
        responseDTO.setCity(cityDTO);
        responseDTO.setCategories(categoryDTOs);

        return responseDTO;
    }

    private CityDTO convertToCityDTO(City city) {
        CityDTO cityDTO = new CityDTO();
        cityDTO.setId(city.getId());
        cityDTO.setName(city.getName());
        cityDTO.setCountryCode(city.getCountryCode());
        cityDTO.setPopulation(city.getPopulation());
        cityDTO.setArea(city.getArea());
        cityDTO.setAnnualPopulationChange(city.getAnnualPopulationChange());
        cityDTO.setRankByPopulation(city.getRankByPopulation());
        cityDTO.setGdp(city.getGdp());
        cityDTO.setLatitude(city.getLatitude());
        cityDTO.setLongitude(city.getLongitude());
        cityDTO.setIsCapital(city.isCapital());
        return cityDTO;
    }

    private List<CategoryDTO> convertToCategoryDTOs(List<PriceEntry> priceEntries) {
        Map<String, List<PriceEntryDTO>> categoryMap = new HashMap<>();

        for (PriceEntry priceEntry : priceEntries) {
            String category = priceEntry.getCategory();
            categoryMap.computeIfAbsent(category, k -> new ArrayList<>())
                    .add(convertToPriceEntryDTO(priceEntry));
        }

        return categoryMap.entrySet().stream()
                .map(entry -> {
                    CategoryDTO categoryDTO = new CategoryDTO();
                    categoryDTO.setName(entry.getKey());
                    categoryDTO.setEntries(entry.getValue());
                    return categoryDTO;
                })
                .collect(Collectors.toList());
    }

    private PriceEntryDTO convertToPriceEntryDTO(PriceEntry priceEntry) {
        PriceEntryDTO dto = new PriceEntryDTO();
        dto.setId(priceEntry.getId());
        dto.setName(priceEntry.getName());
        dto.setPrice(priceEntry.getPrice());
        return dto;
    }
}
