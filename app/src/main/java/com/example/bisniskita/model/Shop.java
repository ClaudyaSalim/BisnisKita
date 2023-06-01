package com.example.bisniskita.model;

public class Shop {

    String nama,kategori;
    int gambar;

    public Shop(String nama, String kategori, int gambar) {
        this.nama = nama;
        this.kategori = kategori;
        this.gambar = gambar;
    }

    public String getNama() {
        return nama;
    }

    public String getkategori() {
        return kategori;
    }

    public int getGambar() {
        return gambar;
    }

}
