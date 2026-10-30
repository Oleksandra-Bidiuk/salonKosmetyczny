package com.example.lab1.domain;

import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import java.time.LocalDate;
import java.time.LocalTime;

public class wizyta {

    private Long id;

    @NotBlank(message = "Imię nie może być puste")
    private String imie;

    private String telefon;

    @NotBlank(message = "Nazwa usługi nie może być pusta")
    @Size(min = 3, max = 50, message = "Nazwa usługi musi mieć od 3 do 50 znaków")
    private String nazwa;

    @NotNull(message = "Cena nie może być pusta")
    @Min(value = 10, message = "Cena minimalna to 10 zł")
    @Max(value = 2000, message = "Cena maksymalna to 2000 zł")
    @NumberFormat(pattern = "#.00")
    private Float cena;

    @NotNull(message = "Data wizyty jest wymagana")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataWizyty;

    private LocalTime godzina;

    private Adres adres;

    // Konstruktor bezargumentowy (wymagany przez Springa i formularze)
    public wizyta() {}

    // Konstruktor wieloargumentowy używany w DatabaseDump
    public wizyta(Long id, String imie, String telefon, String nazwa, LocalDate dataWizyty, LocalTime godzina) {
        this.id = id;
        this.imie = imie;
        this.telefon = telefon;
        this.nazwa = nazwa;
        this.dataWizyty = dataWizyty;
        this.godzina = godzina;
        this.cena = 100.0f; // domyślna cena dla danych początkowych
    }

    // Gettery i settery dla wszystkich pól (w tym id, wymagane przez DatabaseDump)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Float getCena() {
        return cena;
    }

    public void setCena(Float cena) {
        this.cena = cena;
    }

    public LocalDate getDataWizyty() {
        return dataWizyty;
    }

    public void setDataWizyty(LocalDate dataWizyty) {
        this.dataWizyty = dataWizyty;
    }

    public LocalTime getGodzina() {
        return godzina;
    }

    public void setGodzina(LocalTime godzina) {
        this.godzina = godzina;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }
}