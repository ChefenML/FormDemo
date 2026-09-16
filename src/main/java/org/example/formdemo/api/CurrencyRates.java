package org.example.formdemo.api;

import com.google.gson.annotations.SerializedName; // Brug denne ved Gson
// import com.fasterxml.jackson.annotation.JsonProperty; // Brug denne ved Jackson

public class CurrencyRates {
    private String base;
    private String disclaimer;
    private String license;
    private String source;

    @SerializedName("ts") // Mapper JSON-feltet "ts" til variablen "lastupdate"
    private String lastupdate; // Eller Instans/Date alt efter parser

    private Rate rates;

    // Tom konstruktør (påkrævet af mange JSON-parser biblioteker)
    public CurrencyRates() {}

    public CurrencyRates(String base, String disclaimer, String license, String source, String lastupdate, Rate rates) {
        this.base = base;
        this.disclaimer = disclaimer;
        this.license = license;
        this.source = source;
        this.lastupdate = lastupdate;
        this.rates = rates;
    }

    public String getBase() { return base; }
    public String getDisclaimer() { return disclaimer; }
    public String getLicense() { return license; }
    public String getSource() { return source; }
    public String getLastupdate() { return lastupdate; }
    public Rate getRates() { return rates; }

    @Override
    public String toString() {
        return "Valutakurser hentet fra skyen {" +
                "base: '" + base + '\'' +
                ", source: '" + source + '\'' +
                ", rates: {" + rates + '}' +
                ", lastupdate: '" + lastupdate + '\'' +
                '}';
    }

    public static class Rate {
        @SerializedName("DKK")
        private double DKK;

        @SerializedName("EUR")
        private double EUR;

        @SerializedName("USD")
        private double USD;

        public Rate() {}

        public Rate(double DKK, double EUR, double USD) {
            this.DKK = DKK;
            this.EUR = EUR;
            this.USD = USD;
        }

        public double getDKK() { return DKK; }
        public double getEUR() { return EUR; }
        public double getUSD() { return USD; }

        @Override
        public String toString() {
            return "DKK: " + DKK + ", " +
                    "EUR: " + EUR + ", " +
                    "USD: " + USD;
        }
    }
}