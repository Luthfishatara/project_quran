package com.example.myquran.modal;

public class Modal {

    private String nomor;
    private String nama;
    private String asma;
    private String arti;

    public Modal(String nomor, String nama, String asma, String arti) {
        this.nomor = nomor;
        this.nama = nama;
        this.asma = asma;
        this.arti = arti;
    }

    public String getNomor() {
        return nomor;
    }

    public void setNomor(String nomor) {
        this.nomor = nomor;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAsma() {
        return asma;
    }

    public void setAsma(String asma) {
        this.asma = asma;
    }

    public String getArti() {
        return arti;
    }

    public void setArti(String arti) {
        this.arti = arti;
    }
}
