package com.europeancol.licenta.europeancitiescol.cliapp.numbeo_collector.dtos;

import java.util.List;

public class CityDTO {

    private final String city;
    private final List<CategoryDTO> categoryDTOs;

    public CityDTO(String city, List<CategoryDTO> categoryDTOs) {
        this.city = city;
        this.categoryDTOs = categoryDTOs;
    }

    @Override
    public String toString() {
        return "CityDTO{" +
                "city='" + city + '\'' +
                ", categoryDTOs=" + categoryDTOs +
                "}\n";
    }
}
