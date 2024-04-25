package com.europeancol.licenta.europeancitiescol.cliapp.cities_collector;


import com.europeancol.licenta.europeancitiescol.entities.City;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.List;

@Component
public class CitiesCSVParser {

    private final static String PATH = "src/main/resources/csv/cities.csv";

    public List<City> readCSV() throws FileNotFoundException {
        List<City> citiesList;
        Reader reader = new BufferedReader(new FileReader(PATH));

        CsvToBean<City> csvToBean = new CsvToBeanBuilder<City>(reader)
                .withType(City.class)
                .withSeparator(',')
                .withIgnoreLeadingWhiteSpace(true)
                .withIgnoreEmptyLine(true)
                .build();

        citiesList = csvToBean.parse();
        return citiesList;
    }
}
