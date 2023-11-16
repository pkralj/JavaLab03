package com.company;

import java.math.BigDecimal;
import java.util.LinkedList;

public class Racun {
    final private String brojRacuna;
    final private Vlasnik vlasnik;
    final private double pocetnoStanje;
    BigDecimal trenutnoStanje;
    LinkedList<Promet> prometi = new LinkedList<Promet>();

    public Racun(String brojRacuna, Vlasnik vlasnik) {
        this.brojRacuna = brojRacuna;
        this.vlasnik = vlasnik;
        this.pocetnoStanje = 0.0;
    }
    public String getBrojRacuna() {
        return brojRacuna;
    }

    public Vlasnik getVlasnik() {
        return vlasnik;
    }

    public double getPocetnoStanje() {
        return pocetnoStanje;
    }

    public double getTrenutnoStanje() {
        trenutnoStanje = new BigDecimal(pocetnoStanje);
        for (Promet p : prometi){
            BigDecimal tempDug = new BigDecimal(String.valueOf(p.getIznosDug()));
            BigDecimal tempPot = new BigDecimal(String.valueOf(p.getIznosPot()));

            BigDecimal temp1 = new BigDecimal(String.valueOf(trenutnoStanje.add(tempPot)));
            BigDecimal temp2 = new BigDecimal(String.valueOf(temp1.subtract(tempDug)));
            trenutnoStanje = new BigDecimal(String.valueOf(temp2));
        }
        return trenutnoStanje.doubleValue();
    }

    public boolean uplata(Iznos iznos) {
        System.out.println("Metoda: uplata, Klasa: Racun");
        Promet p1 = Promet.kreirajIznosPot(iznos);
        prometi.add(p1);
        return true;
    }

    public boolean isplata(Iznos iznos) {
        System.out.println("Metoda: isplata, Klasa: Racun");
        Promet p1 = Promet.kreirajIznosDug(iznos);
        if (getTrenutnoStanje() >= p1.getIznosPot()) {
            prometi.add(p1);
            return true;
        }
        else
            System.out.println("Isplata nije moguca. Nedovoljno sredstava na racunu");
            return false;
    }

    public double izracunajKamatu() {
        return 0;
    }

    @Override
    public String toString() {
        return "Racun{" +
                "brojRacuna='" + brojRacuna + '\'' +
                ", vlasnik=" + vlasnik.getIme() +  " " + vlasnik.getPrezime() +
                ", trenutnoStanje=" + getTrenutnoStanje() +
                '}';
    }
}
