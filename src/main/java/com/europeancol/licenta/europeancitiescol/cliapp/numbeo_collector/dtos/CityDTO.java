package com.europeancol.licenta.europeancitiescol.cliapp.numbeo_collector.dtos;

import java.util.List;

public class CityDTO {

    private final String cityName;
    private final List<CategoryDTO> categoryDTOs;

    public CityDTO(String city, List<CategoryDTO> categoryDTOs) {
        this.cityName = city;
        this.categoryDTOs = categoryDTOs;
    }

    public String getCityName() {
        return cityName;
    }

    public List<CategoryDTO> getCategoryDTOs() {
        return categoryDTOs;
    }

    @Override
    public String toString() {
        return "CityDTO{" +
                "city='" + cityName + '\'' +
                ", categoryDTOs=" + categoryDTOs +
                "}\n";
    }
}
