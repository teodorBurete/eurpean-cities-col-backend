package com.europeancol.licenta.europeancitiescol.repositories;

import com.europeancol.licenta.europeancitiescol.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country,Long> {

     Optional<Country> findCountryByCountryCode(String countryCode);
}

