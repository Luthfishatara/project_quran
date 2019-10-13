package com.example.myquran.modal;

public class ModalJadwal {

    private String kota;
    private String idKota;

    public ModalJadwal(String kota, String idKota) {
        this.kota = kota;
        this.idKota = idKota;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public String getIdKota() {
        return idKota;
    }

    public void setIdKota(String idKota) {
        this.idKota = idKota;
    }
}
