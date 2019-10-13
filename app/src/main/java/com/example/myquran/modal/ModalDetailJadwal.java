package com.example.myquran.modal;

public class ModalDetailJadwal {

    private String tanggal;
    private String imsyak;
    private String subuh;
    private String terbit;
    private String dhuha;
    private String dzuhur;
    private String ashar;
    private String maghrib;
    private String isya;

    public ModalDetailJadwal(String tanggal, String imsyak, String subuh, String terbit, String dhuha, String dzuhur, String ashar, String maghrib, String isya) {
        this.tanggal = tanggal;
        this.imsyak = imsyak;
        this.subuh = subuh;
        this.terbit = terbit;
        this.dhuha = dhuha;
        this.dzuhur = dzuhur;
        this.ashar = ashar;
        this.maghrib = maghrib;
        this.isya = isya;
    }


    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getImsyak() {
        return imsyak;
    }

    public void setImsyak(String imsyak) {
        this.imsyak = imsyak;
    }

    public String getSubuh() {
        return subuh;
    }

    public void setSubuh(String subuh) {
        this.subuh = subuh;
    }

    public String getTerbit() {
        return terbit;
    }

    public void setTerbit(String terbit) {
        this.terbit = terbit;
    }

    public String getDhuha() {
        return dhuha;
    }

    public void setDhuha(String dhuha) {
        this.dhuha = dhuha;
    }

    public String getDzuhur() {
        return dzuhur;
    }

    public void setDzuhur(String dzuhur) {
        this.dzuhur = dzuhur;
    }

    public String getAshar() {
        return ashar;
    }

    public void setAshar(String ashar) {
        this.ashar = ashar;
    }

    public String getMaghrib() {
        return maghrib;
    }

    public void setMaghrib(String maghrib) {
        this.maghrib = maghrib;
    }

    public String getIsya() {
        return isya;
    }

    public void setIsya(String isya) {
        this.isya = isya;
    }
}
