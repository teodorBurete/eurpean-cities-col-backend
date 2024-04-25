package com.europeancol.licenta.europeancitiescol.repositories;

import com.europeancol.licenta.europeancitiescol.entities.City;
import com.europeancol.licenta.europeancitiescol.entities.PriceEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceEntryRepository extends JpaRepository<PriceEntry, Long> {

    void deleteAllByCity(City city);
}
