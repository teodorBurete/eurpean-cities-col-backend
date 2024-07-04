package com.europeancol.licenta.europeancitiescol.cliapp.prices_collector.dtos;

import java.util.List;

public class CategoryDTO {

    private final String categoryName;
    private final List<EntryDTO> entryDTOs;

    public CategoryDTO(String categoryName, List<EntryDTO> entryDTOs) {
        this.categoryName = categoryName;
        this.entryDTOs = entryDTOs;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public List<EntryDTO> getEntryDTOs() {
        return entryDTOs;
    }

    @Override
    public String toString() {
        return "CategoryDTO{" +
                "categoryName='" + categoryName + '\'' +
                ", entryList=" + entryDTOs +
                "}\n";
    }
}