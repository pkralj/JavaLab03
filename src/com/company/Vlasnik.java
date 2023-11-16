package com.company;

public class Vlasnik {
    final private String oib;
    private String ime;
    private String prezime;
    private String adresa;

    public Vlasnik(String oib, String ime, String prezime) {
        this.oib = oib;
        this.ime = ime;
        this.prezime = prezime;
    }

    public Vlasnik(String oib, String ime, String prezime, String adresa) {
        this.oib = oib;
        this.ime = ime;
        this.prezime = prezime;
        this.adresa = adresa;
    }

    public String getOib() {
        return oib;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }


}
