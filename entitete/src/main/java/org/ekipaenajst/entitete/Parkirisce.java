package org.ekipaenajst.entitete;

import javax.persistence.*;
import java.io.Serializable;


public class Parkirisce implements Serializable {


    private int id;

    private String ime;
    private int zacetekDneva;
    private int konecDneva;
    private double cenaDnevnaPrviDveUri;
    private double cenaDnevnaTretjaUra;
    private double cenaDefault;
    private double cenaNocna;
    private String lokacija;
    private Zasedenost zasedenost; //CE BO PROBLEM Z DESERIALIZACIJO DODAJ ĐE ZASEDENOST IN VSE POVEZANO
    private Oddaljenost oddaljenost;

    @Override
    public String toString() {
        return String.format("Ime: %s Zasedenost: %s Lokacija: %s\n", ime, zasedenost, lokacija);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public int getZacetekDneva() {
        return zacetekDneva;
    }

    public void setZacetekDneva(int zacetekDneva) {
        this.zacetekDneva = zacetekDneva;
    }

    public int getKonecDneva() {
        return konecDneva;
    }

    public void setKonecDneva(int konecDneva) {
        this.konecDneva = konecDneva;
    }

    public double getCenaDnevnaPrviDveUri() {
        return cenaDnevnaPrviDveUri;
    }

    public void setCenaDnevnaPrviDveUri(double cenaDnevnaPrviDveUri) {
        this.cenaDnevnaPrviDveUri = cenaDnevnaPrviDveUri;
    }

    public double getCenaDnevnaTretjaUra() {
        return cenaDnevnaTretjaUra;
    }

    public void setCenaDnevnaTretjaUra(double cenaDnevnaTretjaUra) {
        this.cenaDnevnaTretjaUra = cenaDnevnaTretjaUra;
    }

    public double getCenaDefault() {
        return cenaDefault;
    }

    public void setCenaDefault(double cenaDefault) {
        this.cenaDefault = cenaDefault;
    }

    public double getCenaNocna() {
        return cenaNocna;
    }

    public void setCenaNocna(double cenaNocna) {
        this.cenaNocna = cenaNocna;
    }

    public String getLokacija() {
        return lokacija;
    }

    public void setLokacija(String lokacija) {
        this.lokacija = lokacija;
    }

    public Zasedenost getZasedenost() {
        return zasedenost;
    }

    public void setZasedenost(Zasedenost zasedenost) {
        this.zasedenost = zasedenost;
    }

    public Oddaljenost getOddaljenost() {
        return oddaljenost;
    }

    public void setOddaljenost(Oddaljenost oddaljenost) {
        this.oddaljenost = oddaljenost;
    }
}
