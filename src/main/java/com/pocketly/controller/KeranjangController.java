/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.pocketly.controller;

import com.pocketly.dao.KeranjangDAO;
import com.pocketly.dao.PelangganDAO;
import com.pocketly.dao.PetugasDAO;
import com.pocketly.dao.ProdukDAO;
import com.pocketly.dao.TransaksiDAO;
import com.pocketly.model.KeranjangItem;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

public class KeranjangController {

    public static final double ONGKIR_PESAN_ANTAR = 5000;

    private final KeranjangDAO keranjangDao = new KeranjangDAO();
    private final ProdukDAO produkDao = new ProdukDAO();
    private final PelangganDAO pelangganDao = new PelangganDAO();
    private final TransaksiDAO transaksiDao = new TransaksiDAO();
    private final PetugasDAO petugasDao = new PetugasDAO();

    public List<KeranjangItem> isiKeranjang(String username) {
        return keranjangDao.isiKeranjang(username);
    }

    public boolean kosong(String username) {
        return isiKeranjang(username).isEmpty();
    }

    public String tipePemesanan(String username) {
        return keranjangDao.tipePemesanan(username);
    }

    public void simpanTipePemesanan(String username, String tipe) {
        keranjangDao.setTipePemesanan(username, tipe);
    }

    public void simpanAlamatBaru(String username, String alamat) {
        pelangganDao.updateAlamat(username, alamat);
    }

    /**
     * Mengubah jumlah satu item keranjang (tombol +/- atau input angka).
     * Bila jumlah bertambah, stok dicek dulu; bila berkurang, stok dikembalikan.
     */
    public String ubahJumlah(KeranjangItem item, int jumlahBaru) {
        if (jumlahBaru <= 0) {
            hapusItem(item);
            return "Produk dihapus dari Keranjang";
        }
        int delta = jumlahBaru - item.jumlah;
        if (delta > 0) {
            int stokSisa = produkDao.stokSaatIni(item.idProduk);
            if (stokSisa < delta) {
                return "Stok tidak mencukupi";
            }
            produkDao.sesuaikanStok(item.idProduk, -delta);
        } else if (delta < 0) {
            produkDao.sesuaikanStok(item.idProduk, -delta); // kembalikan stok
        }
        keranjangDao.setJumlah(item.idKeranjang, jumlahBaru, item.hargaSatuan);
        return "Berhasil merubah data produk";
    }

    /** Menghapus item dari keranjang dan mengembalikan stoknya. */
    public void hapusItem(KeranjangItem item) {
        produkDao.sesuaikanStok(item.idProduk, item.jumlah);
        keranjangDao.hapus(item.idKeranjang);
    }

    public double ongkir(String tipePemesanan) {
        return "Pick up".equals(tipePemesanan) ? 0 : ONGKIR_PESAN_ANTAR;
    }

    public double subtotal(List<KeranjangItem> items) {
        return items.stream().mapToDouble(i -> i.hargaSatuan * i.jumlah).sum();
    }

    public double totalBayar(List<KeranjangItem> items, String tipePemesanan) {
        return subtotal(items) + ongkir(tipePemesanan);
    }

    public String buatKodeCash() {
        return transaksiDao.buatKodeCash();
    }

    /**
     * Checkout item terpilih dengan metode Cash (tunai di toko).
     * Transaksi berstatus "Menunggu verifikasi" sampai petugas
     * menerima pembayaran tunainya.
     */
    public String checkoutCash(String username, List<KeranjangItem> items, String tipePemesanan) {
        String kode = transaksiDao.buatKodeCash();
        transaksiDao.checkoutOnline(username, items, tipePemesanan, "Cash",
                kode, null, ongkir(tipePemesanan), petugasDao.kasirDefault());
        return kode;
    }

    /**
     * Checkout item terpilih dengan E-Wallet / M-Bangking: pelanggan
     * mengunggah bukti pembayaran (file gambar disalin ke folder bukti/
     * dengan nama unik agar tidak saling menimpa).
     */
    public String checkoutEwallet(String username, List<KeranjangItem> items, String tipePemesanan,
                                  File fileBukti, String idAcuan, String metode) {
        String pathRelatif = null;
        if (fileBukti != null) {
            try {
                new File(BUKTI_DIR).mkdirs();
                String suffix = "M-Bangking".equals(metode) ? "transfer" : "ewallet";
                String nama = (idAcuan != null ? idAcuan : "TRX") + "_" + suffix + ekstensi(fileBukti.getName());
                Path target = Path.of(BUKTI_DIR, nama);
                int salinan = 1;
                while (Files.exists(target)) {
                    target = Path.of(BUKTI_DIR, idAcuan + "_" + suffix + "_" + salinan + ekstensi(fileBukti.getName()));
                    salinan++;
                }
                Files.copy(fileBukti.toPath(), target, StandardCopyOption.REPLACE_EXISTING);
                pathRelatif = BUKTI_DIR + "/" + target.getFileName();
            } catch (IOException ex) {
                return "Gagal menyalin bukti pembayaran: " + ex.getMessage();
            }
        }
        transaksiDao.checkoutOnline(username, items, tipePemesanan, metode,
                null, pathRelatif, ongkir(tipePemesanan), petugasDao.kasirDefault());
        return null; // sukses
    }

    private static final String BUKTI_DIR = "bukti";

    private static String ekstensi(String nama) {
        int i = nama.lastIndexOf('.');
        return i < 0 ? ".jpg" : nama.substring(i);
    }
}
