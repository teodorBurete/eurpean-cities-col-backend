package com.europeancol.licenta.europeancitiescol.controllers;

import com.europeancol.licenta.europeancitiescol.dto.CityPriceResponseDTO;
import com.europeancol.licenta.europeancitiescol.entities.PriceEntry;
import com.europeancol.licenta.europeancitiescol.services.PriceEntryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/price-entries")
public class PriceEntryController {

    private final PriceEntryService priceEntryService;

    public PriceEntryController(PriceEntryService priceEntryService) {
        this.priceEntryService = priceEntryService;
    }

    @GetMapping("/{cityId}")
    public ResponseEntity<CityPriceResponseDTO> getCityPriceEntries(@PathVariable Long cityId) {
        CityPriceResponseDTO responseDTO = priceEntryService.getCityPriceResponse(cityId);
        return ResponseEntity.ok(responseDTO);
    }
}
