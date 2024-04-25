package com.europeancol.licenta.europeancitiescol.cliapp.countries_collector;

public enum EUCountriesEnum {
    ROMANIA("RO"),
    BULGARIA("BG"),
    POLAND("PL"),
    AUSTRIA("AT"),
    GERMANY("DE"),
    ITALY("IT"),
    FRANCE("FR"),
    BELGIUM("BE"),
    NETHERLANDS("NL"),
    LUXEMBOURG("LU"),
    SLOVENIA("SI"),
    SLOVAKIA("SK"),
    CZECH_REPUBLIC("CZ"),
    CROATIA("HR"),
    GREECE("GR"),
    IRELAND("IE"),
    PORTUGAL("PT"),
    HUNGARY("HU"),
    SPAIN("ES"),
    SWEDEN("SE"),
    MALTA("MT"),
    LATVIA("LV"),
    LITHUANIA("LT"),
    ESTONIA("EE"),
    DENMARK("DK"),
    CYPRUS("CY"),
    FINLAND("FI");


    private final String countryCode;

    EUCountriesEnum(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryCode() {
        return countryCode;
    }
}
