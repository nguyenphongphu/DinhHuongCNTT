package com.example.nhan.dinhhuongcntt.Calss;

public class Danhsach {
    public int id;
    public String lam;
    public String dau;

    public Danhsach(int id, String lam, String dau) {
        this.id = id;
        this.lam = lam;
        this.dau = dau;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLam() {
        return lam;
    }

    public void setLam(String lam) {
        this.lam = lam;
    }

    public String getDau() {
        return dau;
    }

    public void setDau(String dau) {
        this.dau = dau;
    }
}
