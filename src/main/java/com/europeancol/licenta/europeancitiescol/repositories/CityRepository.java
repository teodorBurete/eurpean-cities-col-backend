package com.europeancol.licenta.europeancitiescol.repositories;

import com.europeancol.licenta.europeancitiescol.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CityRepository extends JpaRepository<City, Long> {

    Optional<City> findByName(String name);

    List<City> findByNameContainingIgnoreCase(String query);

    @Query(value = "SELECT c.name FROM cities c LIMIT 5", nativeQuery = true)
    List<String> findAllCityNames();
}
