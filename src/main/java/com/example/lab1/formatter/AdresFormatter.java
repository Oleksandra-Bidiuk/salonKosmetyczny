package com.example.lab1.formatter;

import com.example.lab1.domain.Adres;
import org.springframework.format.Formatter;
import java.text.ParseException;
import java.util.Locale;

public class AdresFormatter implements Formatter<Adres> {

    @Override
    public Adres parse(String text, Locale locale) throws ParseException {
        if (text == null || text.trim().isEmpty()) {
            return null;
        }
        String[] parts = text.split(";");
        if (parts.length != 4) {
            throw new ParseException("Niepoprawny format. Wymagany format: ulica; nrBudynku; kodPocztowy; miejscowosc", 0);
        }
        return new Adres(parts[0].trim(), parts[1].trim(), parts[2].trim(), parts[3].trim());
    }

    @Override
    public String print(Adres object, Locale locale) {
        return object != null ? object.toString() : "";
    }
}