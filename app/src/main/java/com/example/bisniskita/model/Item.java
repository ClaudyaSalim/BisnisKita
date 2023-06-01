package com.example.bisniskita.model;

public class Item {

    String nama,harga;
    int gambar;

    public Item(String nama, String harga, int gambar) {
        this.nama = nama;
        this.harga = harga;
        this.gambar = gambar;
    }

    public String getNama() {
        return nama;
    }

    public String getHarga() {
        return harga;
    }

    public int getGambar() {
        return gambar;
    }

}
