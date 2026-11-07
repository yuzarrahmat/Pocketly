/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.pocketly.controller;

import com.pocketly.dao.KategoriDAO;
import com.pocketly.dao.KeranjangDAO;
import com.pocketly.dao.ProdukDAO;
import com.pocketly.model.Kategori;
import com.pocketly.model.Produk;
import java.util.List;


public class KatalogController {

    private final KategoriDAO kategoriDao = new KategoriDAO();
    private final ProdukDAO produkDao = new ProdukDAO();
    private final KeranjangDAO keranjangDao = new KeranjangDAO();

    public List<Kategori> daftarKategori() {
        return kategoriDao.semua();
    }

    public List<Produk> produkPerKategori(String idKategori) {
        return produkDao.aktifPerKategori(idKategori);
    }

    public String tambahKeKeranjang(String username, String idProduk, int jumlah) {
        if (jumlah <= 0) {
            return "Jumlah harus lebih dari 0";
        }
        Produk p = produkDao.getById(idProduk);
        if (p == null) {
            return "Produk tidak ditemukan";
        }
        int stokSisa = produkDao.stokSaatIni(idProduk);
        if (stokSisa < jumlah) {
            return "Stok tidak mencukupi";
        }
        produkDao.sesuaikanStok(idProduk, -jumlah);             // pesan stok
        keranjangDao.tambah(username, idProduk, jumlah, p.hargaSatuan);
        return "Item ditambahkan";
    }
}
