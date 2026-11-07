/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.pocketly.model;

public class Produk {

    public String id;
    public String nama;
    public double hargaSatuan;
    public int stok;
    public String satuan;
    public String idKategori;
    public String namaKategori; // hasil JOIN, untuk tampilan
    public String petugasUsername;
    public String status;       // "Aktif" / "Nonaktif"
    public String gambar;       // nama file di img/produk/, boleh null

    /** true bila produk belum memiliki gambar. */
    public boolean belumAdaGambar() {
        return gambar == null || gambar.isBlank();
    }
}
