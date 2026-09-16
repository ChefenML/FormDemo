package org.example.formdemo.api;

import java.io.IOException;

public class Main {
    static void main() throws IOException {
        CurrencyService service = new CurrencyService();
        CurrencyRates rates = service.getRates();
        System.out.println("Valutakurser baseret på USD dollar\n" + rates);
    }
}

