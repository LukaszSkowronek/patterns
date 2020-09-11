package com.check.locale;

import java.util.HashMap;
import java.util.Locale;

public class LocaleTesty {

    public static void main(String[] args) {
        mapCountryToCountryCode("Polska");
    }

    private static void mapCountryToCountryCode(String country) {
        HashMap<String, String> countryNameToCuntryCode = new HashMap<>();

        for(String countryCode:  Locale.getISOCountries()) {
            Locale locale = new Locale("pl", countryCode);
            System.out.println(locale.getDisplayCountry());
            countryNameToCuntryCode.put(locale.getDisplayCountry(new Locale("pl", countryCode)), countryCode);
        }


        System.out.println(countryNameToCuntryCode.get("Włochy"));
        Locale obj = new Locale("PL", country);

    }
}
