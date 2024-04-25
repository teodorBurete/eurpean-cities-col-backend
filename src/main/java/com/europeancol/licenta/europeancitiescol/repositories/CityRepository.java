package com.europeancol.licenta.europeancitiescol.repositories;

import com.europeancol.licenta.europeancitiescol.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}
