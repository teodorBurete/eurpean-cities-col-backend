package com.europeancol.licenta.europeancitiescol.dto;

import java.util.List;


public class CategoryDTO {
    private String name;
    private List<PriceEntryDTO> entries;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PriceEntryDTO> getEntries() {
        return entries;
    }

    public void setEntries(List<PriceEntryDTO> entries) {
        this.entries = entries;
    }
}
