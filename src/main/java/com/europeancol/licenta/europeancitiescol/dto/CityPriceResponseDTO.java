package com.europeancol.licenta.europeancitiescol.dto;

import java.util.List;

public class CityPriceResponseDTO {

    private CityDTO city;
    private List<CategoryDTO> categories;

    public CityDTO getCity() {
        return city;
    }

    public void setCity(CityDTO city) {
        this.city = city;
    }

    public List<CategoryDTO> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryDTO> categories) {
        this.categories = categories;
    }
}
