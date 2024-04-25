package com.europeancol.licenta.europeancitiescol.cliapp.numbeo_collector;

import com.europeancol.licenta.europeancitiescol.cliapp.numbeo_collector.dtos.CategoryDTO;
import com.europeancol.licenta.europeancitiescol.cliapp.numbeo_collector.dtos.CityDTO;
import com.europeancol.licenta.europeancitiescol.cliapp.numbeo_collector.dtos.EntryDTO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class NumbeoDataParser {

    public CityDTO parseData(String html, String city) {
        Document document = Jsoup.parse(html);
        Elements trHeaders = parseTable(document);
        return collectCityData(trHeaders, city);
    }

    private Elements parseTable(Document document) {
        Element table = document.getElementsByClass("data_wide_table new_bar_table").first();
        Elements trs = table.getElementsByTag("tr");
        Elements trHeaders = new Elements();
        trs.stream().filter(tr -> tr.child(0).is("th")).forEach(trHeaders::add);

        return trHeaders;
    }

    private CityDTO collectCityData(Elements trHeaders, String city) {
        ArrayList<CategoryDTO> categoryDTOS = collectCategories(trHeaders);
        return new CityDTO(city, categoryDTOS);
    }

    private ArrayList<CategoryDTO> collectCategories(Elements trHeaders) {
        ArrayList<CategoryDTO> categoryDTOs = new ArrayList<>();
        for (Element trHeader : trHeaders) {
            collectEntities(trHeader, categoryDTOs);
        }
        return categoryDTOs;
    }

    private void collectEntities(Element trHeader, ArrayList<CategoryDTO> categoryDTOs) {
        String categoryTitle = trHeader.getElementsByClass("category_title").text();

        Element currentRow = trHeader.nextElementSibling();
        ArrayList<EntryDTO> entries = new ArrayList<>();
        while (currentRow != null && currentRow.child(0).is("td")) {
            String entryName = currentRow.child(0).text();
            String price = currentRow.child(1).text();
            entries.add(new EntryDTO(entryName, price));

            currentRow = currentRow.nextElementSibling();
        }
        categoryDTOs.add(new CategoryDTO(categoryTitle, entries));
    }
}
