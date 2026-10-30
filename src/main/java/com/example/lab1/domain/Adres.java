package com.example.lab1.domain;

public class Adres {
    private String ulica;
    private String nrBudynku;
    private String kodPocztowy;
    private String miejscowosc;

    public Adres() {}

    public Adres(String ulica, String nrBudynku, String kodPocztowy, String miejscowosc) {
        this.ulica = ulica;
        this.nrBudynku = nrBudynku;
        this.kodPocztowy = kodPocztowy;
        this.miejscowosc = miejscowosc;
    }

    public String getUlica() { return ulica; }
    public void setUlica(String ulica) { this.ulica = ulica; }

    public String getNrBudynku() { return nrBudynku; }
    public void setNrBudynku(String nrBudynku) { this.nrBudynku = nrBudynku; }

    public String getKodPocztowy() { return kodPocztowy; }
    public void setKodPocztowy(String kodPocztowy) { this.kodPocztowy = kodPocztowy; }

    public String getMiejscowosc() { return miejscowosc; }
    public void setMiejscowosc(String miejscowosc) { this.miejscowosc = miejscowosc; }

    @Override
    public String toString() {
        return ulica + "; " + nrBudynku + "; " + kodPocztowy + "; " + miejscowosc;
    }
}