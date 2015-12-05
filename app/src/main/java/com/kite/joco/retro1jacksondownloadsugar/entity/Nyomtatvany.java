package com.kite.joco.retro1jacksondownloadsugar.entity;

import com.orm.SugarRecord;

import java.util.Date;

/**
 * Created by Joco on 2015.11.28..
 */
public class Nyomtatvany extends SugarRecord {

    private String nyomtKod;

    private String nyomtNev;
    private String nyomtLeiras;

    private Date ervenyessegKezdete;

    private Date ervenyessegVege;

    private String status;
    private Float verzio;

    private Date modifiedTime;

    public Nyomtatvany (){}

    public Nyomtatvany(String nyomtKod, String nyomtNev, String nyomtLeiras, Date ervenyessegKezdete, Date ervenyessegVege, String status, Float verzio, Date modifiedTime) {
        this.nyomtKod = nyomtKod;
        this.nyomtNev = nyomtNev;
        this.nyomtLeiras = nyomtLeiras;
        this.ervenyessegKezdete = ervenyessegKezdete;
        this.ervenyessegVege = ervenyessegVege;
        this.status = status;
        this.verzio = verzio;
        this.modifiedTime = modifiedTime;
    }

    public String getNyomtKod() {
        return nyomtKod;
    }

    public void setNyomtKod(String nyomtKod) {
        this.nyomtKod = nyomtKod;
    }

    public String getNyomtNev() {
        return nyomtNev;
    }

    public void setNyomtNev(String nyomtNev) {
        this.nyomtNev = nyomtNev;
    }

    public String getNyomtLeiras() {
        return nyomtLeiras;
    }

    public void setNyomtLeiras(String nyomtLeiras) {
        this.nyomtLeiras = nyomtLeiras;
    }

    public Date getErvenyessegKezdete() {
        return ervenyessegKezdete;
    }

    public void setErvenyessegKezdete(Date ervenyessegKezdete) {
        this.ervenyessegKezdete = ervenyessegKezdete;
    }

    public Date getErvenyessegVege() {
        return ervenyessegVege;
    }

    public void setErvenyessegVege(Date ervenyessegVege) {
        this.ervenyessegVege = ervenyessegVege;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Float getVerzio() {
        return verzio;
    }

    public void setVerzio(Float verzio) {
        this.verzio = verzio;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}
