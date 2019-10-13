package com.example.myquran.modal;

public class ModalDetailQuran {

    private String nomor;
    private String name;
    private String arti;

    public ModalDetailQuran(String nomor, String name, String arti) {
        this.nomor = nomor;
        this.name = name;
        this.arti = arti;
    }

    public String getNomor() {
        return nomor;
    }

    public void setNomor(String nomor) {
        this.nomor = nomor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArti() {
        return arti;
    }

    public void setArti(String arti) {
        this.arti = arti;
    }
}
