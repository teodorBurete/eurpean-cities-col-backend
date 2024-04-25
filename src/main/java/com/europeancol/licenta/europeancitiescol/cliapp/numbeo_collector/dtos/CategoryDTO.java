package com.europeancol.licenta.europeancitiescol.cliapp.numbeo_collector.dtos;

import java.util.List;

public class CategoryDTO {

    private final String categoryName;
    private final List<EntryDTO> entryDTOs;

    public CategoryDTO(String categoryName, List<EntryDTO> entryDTOs) {
        this.categoryName = categoryName;
        this.entryDTOs = entryDTOs;
    }

    @Override
    public String toString() {
        return "CategoryDTO{" +
                "categoryName='" + categoryName + '\'' +
                ", entryList=" + entryDTOs +
                "}\n";
    }
}