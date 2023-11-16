package com.company;

public class Iznos {
    final private double iznos;
    final private String valuta;

    public Iznos(double iznos, String valuta) {
        this.iznos = iznos;
        this.valuta = valuta;
    }

    public double getIznos() {
        return iznos;
    }

    public String getValuta() {
        return valuta;
    }
}
