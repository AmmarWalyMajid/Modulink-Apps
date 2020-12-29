package com.ammar.modulink.dataset;

public class Modul {

    String Modulke;
    String judul;
    String tanggal;

    String nama;
    String info;
    int foto;


    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getModulke() {
        return Modulke;
    }

    public void setModulke(String modulke) {
        Modulke = modulke;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }


    //contructorlistview
    public Modul(String nama, int foto, String info) {
        this.nama = nama;
        this.foto = foto;
        this.info = info;
    }

}


