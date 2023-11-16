package com.company;

public class Main {

    public static void main(String[] args) {
        //prviZadatak();
        drugiZadatak();
    }

    public static void prviZadatak() {
        Vlasnik v1 = new Vlasnik("1", "Ivo", "Ivić", "Maksimir 22");
        Vlasnik v2 = new Vlasnik("2", "Mate", "Matić", "Maksimir 11");
        Racun b1 = new Racun("1", v1);
        Racun b2 = new Racun("2", v2);
        System.out.println(b1);
        System.out.println(b2);
        System.out.println();

        b1.uplata(new Iznos(100,"HRK"));
        b2.isplata(new Iznos(90, "HRK"));
        System.out.println(b1);
        System.out.println(b2);
        System.out.println();

        Racun b3 = b1;
        System.out.println(b3);
        System.out.println();

        b3.isplata(new Iznos(100, "HRK"));
        b2.uplata(new Iznos(200, "HRK"));
        System.out.println(b2);
        System.out.println(b3);
        System.out.println();

        b3 = new Racun("3", v1);
        System.out.println(b1);
        System.out.println(b3);
        System.out.println();

        b3.uplata(new Iznos(300, "HRK"));
        System.out.println(b3);
        System.out.println();
    }

    public static void drugiZadatak() {
        Vlasnik v3 = new Vlasnik("3", "Ivan", "Horvat");
        Vlasnik v5 = new PravniVlasnik(new Vlasnik("4", "Petar","Perić"), "JDOO", "Maksimir 1a", "5");

        Racun b1;
        Racun b2;

        b1 = new TekuciRacun("11", v3, 14, 100, 4);
        b2 = new Orocenje("12", v5, 5);

        System.out.println(b1);
        System.out.println(b2);

        b1.uplata(new Iznos(100, "HRK"));
        b2.uplata(new Iznos(200, "HRK"));

        System.out.println(b1);
        System.out.println(b2);

        System.out.println(b1.izracunajKamatu());
        System.out.println(b2.izracunajKamatu());

        System.out.println(b1);
        System.out.println(b2);

        b1.isplata(new Iznos(200, "HRK"));
        b2.isplata(new Iznos(10, "HRK"));

        System.out.println(b1);
        System.out.println(b2);

        System.out.println(b1.izracunajKamatu());
        System.out.println(b2.izracunajKamatu());

        System.out.println(b1);
        System.out.println(b2);
    }
}
