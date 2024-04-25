package com.europeancol.licenta.europeancitiescol.cliapp.numbeo_collector;

import com.europeancol.licenta.europeancitiescol.cliapp.numbeo_collector.dtos.CategoryDTO;
import com.europeancol.licenta.europeancitiescol.cliapp.numbeo_collector.dtos.CityDTO;
import com.europeancol.licenta.europeancitiescol.cliapp.numbeo_collector.dtos.EntryDTO;
import com.europeancol.licenta.europeancitiescol.entities.PriceEntry;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CityDTOConverter {

    public List<PriceEntry> convertCityDTOtoPriceEntryList(CityDTO cityDTO) {
        List<PriceEntry> res = new ArrayList<>();
        for (CategoryDTO categoryDTO : cityDTO.getCategoryDTOs()) {
            for (EntryDTO entryDTO : categoryDTO.getEntryDTOs()) {
                PriceEntry priceEntry = new PriceEntry();

                priceEntry.setName(entryDTO.getEntryName());
                priceEntry.setPrice(Double.valueOf(entryDTO.getPrice()));
                priceEntry.setCategory(categoryDTO.getCategoryName());
                res.add(priceEntry);
            }
        }
        return res;
    }
}
