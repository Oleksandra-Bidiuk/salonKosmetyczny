package com.example.lab1.controller;

import com.example.lab1.domain.wizyta;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


public class DatabaseDump {
    private static final List<wizyta> wizyty = new ArrayList<>();

    private static long nextId = 3;

    static {
        wizyty.add(new wizyta(
                1L,
                "Anna",
                "546564564",
                "Manicure",
                LocalDate.now(),
                LocalTime.of(10, 0)
        ));

        wizyty.add(new wizyta(
                2L,
                "Katarzyna",
                "6546546",
                "Henna brwi",
                LocalDate.now().plusDays(1),
                LocalTime.of(12, 30)
        ));
    }

    public static List<wizyta> getAllWizyty() {
        return wizyty;
    }

    public static wizyta findById(Long id) {
        for (wizyta w : wizyty) {
            if (w.getId().equals(id)) {
                return w;
            }
        }
        return null;
    }

    public static void save(wizyta wizyta) {
        if (wizyta.getId() == null) {
            wizyta.setId(nextId++);
            wizyty.add(wizyta);
        } else {
            wizyta stara = findById(wizyta.getId());

            if (stara != null) {
                int index = wizyty.indexOf(stara);
                wizyty.set(index, wizyta);
            }
        }
    }

    public static void deleteById(Long id) {
        wizyty.removeIf(w -> w.getId().equals(id));
    }
}

