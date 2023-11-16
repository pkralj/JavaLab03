package com.company;

import java.math.BigDecimal;

public class TekuciRacun extends Racun{
    private double dozvoljeniMinus;
    private double zateznaKamata;
    private double kamate;

    public double getDozvoljeniMinus() {
        return dozvoljeniMinus;
    }

    public void setDozvoljeniMinus(double dozvoljeniMinus) {
        this.dozvoljeniMinus = dozvoljeniMinus;
    }

    public double getZateznaKamata() {
        return zateznaKamata;
    }

    public void setZateznaKamata(double zateznaKamata) {
        this.zateznaKamata = zateznaKamata;
    }

    public double getKamate() {
        return kamate;
    }

    public void setKamate(double kamate) {
        this.kamate = kamate;
    }

    public TekuciRacun(String brojRacuna, Vlasnik vlasnik, double zateznaKamata, double dozvoljeniMinus, double kamate) {
        super(brojRacuna, vlasnik);
        this.dozvoljeniMinus = dozvoljeniMinus;
        this.zateznaKamata = zateznaKamata;
        this.kamate = kamate;
    }

    @Override
    public boolean uplata(Iznos iznos) {
        System.out.println("Metoda: uplata, Klasa: TekuciRacun");
        Promet p1 = Promet.kreirajIznosPot(iznos);
        prometi.add(p1);
        return true;
    }

    @Override
    public boolean isplata (Iznos iznos) {
        System.out.println("Metoda: isplata, Klasa: TekuciRacun");
        Promet p1 = Promet.kreirajIznosDug(iznos);
        if ((getTrenutnoStanje() + getDozvoljeniMinus()) >= p1.getIznosPot()) {
            prometi.add(p1);
            return true;
        }
        else
            System.out.println("Isplata nije moguca. Nedovoljno sredstava na racunu");
        return false;
    }

    @Override
    public double izracunajKamatu(){
        System.out.println("Metoda: izracunajKamatu, Klasa: TekuciRacun");
        BigDecimal kamatniFaktor;
        if (getTrenutnoStanje() >= 0 && getKamate() != 0) {
            BigDecimal temp1 = new BigDecimal(Double.toString(getKamate()));
            kamatniFaktor = new BigDecimal("1").add((temp1).divide(new BigDecimal("100"),4));
        }
        else {
            BigDecimal temp2 = new BigDecimal(Double.toString(getZateznaKamata()));
            kamatniFaktor = new BigDecimal("1").add((temp2).divide(new BigDecimal("100"),4));
        }
        BigDecimal stanjePrijeKamata = trenutnoStanje;
        BigDecimal stanjePlusKamate = new BigDecimal(String.valueOf(getTrenutnoStanje())).multiply(kamatniFaktor);
        double razlika = stanjePlusKamate.subtract(stanjePrijeKamata).doubleValue();
        if (razlika > 0) {
            Promet p = Promet.kreirajIznosPot(new Iznos(razlika, "HRK"));
            prometi.add(p);
        }
        else {
            Promet p = Promet.kreirajIznosDug(new Iznos(Math.abs(razlika), "HRK"));
            prometi.add(p);
        }
        return razlika;
    }
}
