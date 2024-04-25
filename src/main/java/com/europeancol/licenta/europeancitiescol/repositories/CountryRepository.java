package com.europeancol.licenta.europeancitiescol.repositories;

import com.europeancol.licenta.europeancitiescol.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country,Long> {

     Country findCountryByCountryCode(String countryCode);
}

