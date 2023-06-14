package com.example.bisniskita.model;

public class Item {

    String nama;
    int harga, gambar;

    public Item(String nama, int harga, int gambar) {
        this.nama = nama;
        this.harga = harga;
        this.gambar = gambar;
    }

    public String getNama() {
        return nama;
    }

    public int getHarga() {
        return harga;
    }

    public int getGambar() {
        return gambar;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }
}
