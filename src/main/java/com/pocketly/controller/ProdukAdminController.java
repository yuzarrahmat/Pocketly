/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.pocketly.controller;

import com.pocketly.dao.KategoriDAO;
import com.pocketly.dao.ProdukDAO;
import com.pocketly.model.Kategori;
import com.pocketly.model.Produk;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;


public class ProdukAdminController {

    private final ProdukDAO produkDao = new ProdukDAO();
    private final KategoriDAO kategoriDao = new KategoriDAO();

    private static final String IMG_DIR = "img/produk";

    public List<Produk> semuaProduk() {
        return produkDao.semua();
    }

    public List<Kategori> daftarKategori() {
        return kategoriDao.semua();
    }

    /**
     * Validasi form produk. Mengembalikan pesan error spesifik
     * sesuai kesalahan input (flowchart: "Tampilkan pesan error
     * berdasarkan kesalahannya"), atau null bila valid.
     */
    public String validasi(String nama, String hargaText, String stokText, String satuan, String idKategori) {
        if (nama == null || nama.isBlank()) {
            return "Nama produk wajib diisi.";
        }
        double harga;
        try {
            harga = Double.parseDouble(hargaText.trim().replace(",", "."));
            if (harga <= 0) {
                return "Harga satuan harus lebih besar dari 0.";
            }
        } catch (NumberFormatException ex) {
            return "Harga satuan harus berupa angka.";
        }
        int stok;
        try {
            stok = Integer.parseInt(stokText.trim());
            if (stok < 0) {
                return "Stok tidak boleh negatif.";
            }
        } catch (NumberFormatException ex) {
            return "Stok harus berupa angka bulat.";
        }
        if (satuan == null || satuan.isBlank()) {
            return "Satuan barang wajib diisi (contoh: bungkus, botol).";
        }
        if (idKategori == null || idKategori.isBlank()) {
            return "Kategori produk wajib dipilih.";
        }
        return null; // valid
    }

    /** Menyimpan produk baru; mengembalikan pesan hasil operasi. */
    public String tambahProduk(String nama, String hargaText, String stokText, String satuan,
                               String idKategori, String status, File gambar, String petugas) {
        String err = validasi(nama, hargaText, stokText, satuan, idKategori);
        if (err != null) {
            return err;
        }
        Produk p = new Produk();
        p.id = com.pocketly.util.DB.nextId("PRD", "produk", "id_produk");
        isiProduk(p, nama, hargaText, stokText, satuan, idKategori, status);
        p.petugasUsername = petugas;
        p.gambar = salinGambar(gambar, p.id);
        produkDao.insert(p);
        return "Berhasil menambah produk";
    }

    /** Menyimpan perubahan produk; mengembalikan pesan hasil operasi. */
    public String ubahProduk(Produk asli, String nama, String hargaText, String stokText,
                             String satuan, String idKategori, String status, File gambarBaru) {
        String err = validasi(nama, hargaText, stokText, satuan, idKategori);
        if (err != null) {
            return err;
        }
        Produk p = new Produk();
        p.id = asli.id;
        isiProduk(p, nama, hargaText, stokText, satuan, idKategori, status);
        p.petugasUsername = asli.petugasUsername;
        if (gambarBaru != null) {
            p.gambar = salinGambar(gambarBaru, asli.id); // ganti gambar
        } else {
            p.gambar = asli.gambar;                      // pertahankan
        }
        produkDao.update(p);
        return "Berhasil merubah data produk";
    }

    private void isiProduk(Produk p, String nama, String hargaText, String stokText,
                           String satuan, String idKategori, String status) {
        p.nama = nama.trim();
        p.hargaSatuan = Double.parseDouble(hargaText.trim().replace(",", "."));
        p.stok = Integer.parseInt(stokText.trim());
        p.satuan = satuan.trim();
        p.idKategori = idKategori;
        p.status = status == null ? "Aktif" : status;
    }

    /** Menyalin file gambar pilihan ke img/produk dengan nama rapi. */
    private String salinGambar(File src, String idProduk) {
        if (src == null) {
            return null;
        }
        try {
            new File(IMG_DIR).mkdirs();
            String nama = idProduk.toLowerCase() + ekstensi(src.getName());
            Files.copy(src.toPath(), Path.of(IMG_DIR, nama), StandardCopyOption.REPLACE_EXISTING);
            return nama;
        } catch (IOException ex) {
            System.err.println("[ProdukAdminController] salinGambar: " + ex.getMessage());
            return null;
        }
    }

    private static String ekstensi(String nama) {
        int i = nama.lastIndexOf('.');
        return i < 0 ? ".jpg" : nama.substring(i).toLowerCase();
    }

    /** Ubah stok cepat pada tabel kelola produk. */
    public String ubahStok(String idProduk, int stokBaru) {
        if (stokBaru < 0) {
            return "Stok tidak boleh negatif.";
        }
        produkDao.updateStok(idProduk, stokBaru);
        return "Berhasil merubah data produk";
    }
}
