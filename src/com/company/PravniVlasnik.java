package com.company;

public class PravniVlasnik extends Vlasnik {
    private Vlasnik vlasnik;
    private String naziv;
    private String adresa;
    private final String oib;

    public PravniVlasnik(Vlasnik vlasnik, String naziv, String adresa, String oib){
        super(vlasnik.getOib(), vlasnik.getIme(), vlasnik.getPrezime());
        this.vlasnik = vlasnik;
        this.naziv = naziv;
        this.adresa = adresa;
        this.oib = oib;
    }


}
