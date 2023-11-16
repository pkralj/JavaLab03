package com.company;

import java.math.BigDecimal;

public class Orocenje extends Racun{

    private double kamate;

    public double getKamate() {
        return kamate;
    }

    public void setKamate(double kamate) {
        this.kamate = kamate;
    }

    public Orocenje(String brojRacuna, Vlasnik vlasnik, double kamate) {
        super(brojRacuna, vlasnik);
        this.kamate = kamate;
    }

    @Override
    public boolean isplata(Iznos iznos){
        System.out.println("Metoda: isplata, Klasa: Orocenje");
        System.out.println("Nije moguce izvrsiti isplatu sa Orocenja");
        return false;
    }

    @Override
    public boolean uplata(Iznos iznos) {
        System.out.println("Metoda: uplata, Klasa: Orocenje");
        Promet p1 = Promet.kreirajIznosPot(iznos);
        prometi.add(p1);
        return true;
    }

    @Override
    public double izracunajKamatu(){
        System.out.println("Metoda: izracunajKamatu, Klasa: Orocenje");
        BigDecimal kamatniFaktor;
        BigDecimal temp1 = new BigDecimal(Double.toString(getKamate()));
        kamatniFaktor = new BigDecimal("1").add((temp1).divide(new BigDecimal("100"), 4));
        BigDecimal stanjePrijeKamata = trenutnoStanje;
        BigDecimal stanjePlusKamate = new BigDecimal(String.valueOf(getTrenutnoStanje())).multiply(kamatniFaktor);
        double razlika = stanjePlusKamate.subtract(stanjePrijeKamata).doubleValue();
        Promet p = Promet.kreirajIznosPot(new Iznos(razlika, "HRK"));
        prometi.add(p);
        return razlika;
    }
}
