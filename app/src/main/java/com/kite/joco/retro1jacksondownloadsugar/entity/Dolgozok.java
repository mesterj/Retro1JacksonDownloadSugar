package com.kite.joco.retro1jacksondownloadsugar.entity;

import com.orm.SugarRecord;

import java.util.Date;

/**
 * Created by Joco on 2015.11.28..
 */
public class Dolgozok extends SugarRecord<Dolgozok>{
    private String tosz;
    private String nev;
    private String beosztas;
    private String email;
    private String mellek;
    private String mobil;
    private String regio;
    private String szervezet;
    private String uazo;
    private Date modifiedTime;
    private String uzletkotokod;
    private String alkrovidkod;


    public Dolgozok() {
    }

    public Dolgozok(String tosz, String nev, String beosztas, String email, String mellek, String mobil, String regio, String szervezet, String uazo, Date modifiedTime, String uzletkotokod, String alkrovidkod) {
        this.tosz = tosz;
        this.nev = nev;
        this.beosztas = beosztas;
        this.email = email;
        this.mellek = mellek;
        this.mobil = mobil;
        this.regio = regio;
        this.szervezet = szervezet;
        this.uazo = uazo;
        this.modifiedTime = modifiedTime;
        this.uzletkotokod = uzletkotokod;
        this.alkrovidkod = alkrovidkod;
    }

    public String getTosz() {
        return tosz;
    }

    public void setTosz(String tosz) {
        this.tosz = tosz;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getBeosztas() {
        return beosztas;
    }

    public void setBeosztas(String beosztas) {
        this.beosztas = beosztas;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMellek() {
        return mellek;
    }

    public void setMellek(String mellek) {
        this.mellek = mellek;
    }

    public String getMobil() {
        return mobil;
    }

    public void setMobil(String mobil) {
        this.mobil = mobil;
    }

    public String getRegio() {
        return regio;
    }

    public void setRegio(String regio) {
        this.regio = regio;
    }

    public String getSzervezet() {
        return szervezet;
    }

    public void setSzervezet(String szervezet) {
        this.szervezet = szervezet;
    }

    public String getUazo() {
        return uazo;
    }

    public void setUazo(String uazo) {
        this.uazo = uazo;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getUzletkotokod() {
        return uzletkotokod;
    }

    public void setUzletkotokod(String uzletkotokod) {
        this.uzletkotokod = uzletkotokod;
    }

    public String getAlkrovidkod() {
        return alkrovidkod;
    }

    public void setAlkrovidkod(String alkrovidkod) {
        this.alkrovidkod = alkrovidkod;
    }
}
