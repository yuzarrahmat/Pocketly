/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.pocketly.controller;

import com.pocketly.dao.ProdukDAO;
import com.pocketly.dao.TransaksiDAO;
import com.pocketly.model.KasirItem;
import com.pocketly.model.Produk;
import java.util.ArrayList;
import java.util.List;


public class KasirController {

    private final ProdukDAO produkDao = new ProdukDAO();
    private final TransaksiDAO transaksiDao = new TransaksiDAO();

    /** Hasil penambahan item: sukses + pesan / item yang ditambahkan. */
    public record TambahHasil(boolean sukses, String pesan, KasirItem item) {
    }

    public TambahHasil tambahItem(List<KasirItem> items, String idProduk, String jumlahText) {
        if (idProduk == null || idProduk.isBlank()) {
            return new TambahHasil(false, "ID produk wajib diisi.", null);
        }
        final String idProdukFinal = idProduk.trim();
        int jumlah;
        try {
            jumlah = Integer.parseInt(jumlahText.trim());
        } catch (NumberFormatException ex) {
            return new TambahHasil(false, "Jumlah produk harus berupa angka bulat.", null);
        }
        if (jumlah <= 0) {
            return new TambahHasil(false, "Jumlah produk harus lebih dari 0.", null);
        }
        Produk p = produkDao.getById(idProduk);
        if (p == null) {
            return new TambahHasil(false, "Produk dengan ID " + idProduk + " tidak ditemukan.", null);
        }
        if (!"Aktif".equals(p.status)) {
            return new TambahHasil(false, "Produk sedang nonaktif dan tidak dapat dijual.", null);
        }
        // hitung jumlah yang sudah ada di tabel belanja
        int sudahAda = items.stream()
                .filter(i -> i.idProduk.equalsIgnoreCase(idProdukFinal))
                .mapToInt(i -> i.jumlah).sum();
        if (p.stok - sudahAda < jumlah) {
            return new TambahHasil(false, "Stok tidak mencukupi (sisa stok: " + p.stok + ").", null);
        }
        KasirItem item = new KasirItem();
        item.idProduk = p.id;
        item.nama = p.nama;
        item.harga = p.hargaSatuan;
        item.jumlah = jumlah;
        return new TambahHasil(true, "Produk ditambahkan.", item);
    }

    /**
     * Mengubah jumlah satu item (tombol +/-/input angka).
     * Stok tersisa = stok DB - jumlah yang sudah di tabel.
     */
    public String ubahJumlah(List<KasirItem> items, KasirItem item, int jumlahBaru) {
        if (jumlahBaru <= 0) {
            items.remove(item);
            return "Item dihapus dari daftar belanja.";
        }
        int stokSisa = produkDao.stokSaatIni(item.idProduk)
                - items.stream().filter(i -> i.idProduk.equals(item.idProduk) && i != item)
                        .mapToInt(i -> i.jumlah).sum();
        if (jumlahBaru > stokSisa) {
            return "Stok tidak mencukupi (sisa stok: " + stokSisa + ").";
        }
        item.jumlah = jumlahBaru;
        return "Berhasil merubah data produk";
    }

    public double totalBelanja(List<KasirItem> items) {
        return items.stream().mapToDouble(KasirItem::subtotal).sum();
    }

    /**
     * Menyimpan transaksi tunai (cash): nominal bayar & kembalian dihitung.
     * Mengembalikan pesan hasil.
     */
    public String bayarTunai(List<KasirItem> items, double uangDiterima,
                             String namaPembeli, String petugas) {
        double total = totalBelanja(items);
        if (uangDiterima < total) {
            return "Uang yang diterima kurang dari total belanja.";
        }
        transaksiDao.simpanKasirOffline(items, "Cash", uangDiterima,
                uangDiterima - total, namaPembeli, petugas);
        return "transaksi selesai";
    }

    /** Menyimpan transaksi E-Wallet / M-Bangking (langsung dianggap berhasil). */
    public String bayarDigital(List<KasirItem> items, String namaPembeli, String petugas, String metode) {
        double total = totalBelanja(items);
        transaksiDao.simpanKasirOffline(new ArrayList<>(items), metode, total, 0,
                namaPembeli, petugas);
        return "transaksi selesai";
    }
}
