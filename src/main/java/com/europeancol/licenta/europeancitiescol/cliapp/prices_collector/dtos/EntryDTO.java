package com.europeancol.licenta.europeancitiescol.cliapp.prices_collector.dtos;

public class EntryDTO {

    private final String entryName;
    private final String price;

    public EntryDTO(String entryName, String price) {
        this.entryName = entryName;
        this.price = price;
    }

    public String getEntryName() {
        return entryName;
    }

    public String getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "entryName='" + entryName + '\'' +
                ", price='" + price + '\'' +
                "}\n";
    }
}
