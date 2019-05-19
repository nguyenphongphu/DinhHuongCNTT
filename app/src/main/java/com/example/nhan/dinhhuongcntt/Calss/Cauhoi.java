package com.example.nhan.dinhhuongcntt.Calss;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Cauhoi {
    public String cauA;
    public String cauB;
    public String cauC;
    public String cauD;
    public String cauhoi;
    public String dapan;

    public Cauhoi(String cauA, String cauB, String cauC, String cauD, String cauhoi, String dapan) {
        this.cauA = cauA;
        this.cauB = cauB;
        this.cauC = cauC;
        this.cauD = cauD;
        this.cauhoi = cauhoi;
        this.dapan = dapan;
    }

    public Cauhoi(){

    }
    public String getCauA() {
        return cauA;
    }

    public void setCauA(String cauA) {
        this.cauA = cauA;
    }

    public String getCauB() {
        return cauB;
    }

    public void setCauB(String cauB) {
        this.cauB = cauB;
    }

    public String getCauC() {
        return cauC;
    }

    public void setCauC(String cauC) {
        this.cauC = cauC;
    }

    public String getCauD() {
        return cauD;
    }

    public void setCauD(String cauD) {
        this.cauD = cauD;
    }

    public String getCauhoi() {
        return cauhoi;
    }

    public void setCauhoi(String cauhoi) {
        this.cauhoi = cauhoi;
    }

    public String getDapan() {
        return dapan;
    }

    public void setDapan(String dapan) {
        this.dapan = dapan;
    }
}
