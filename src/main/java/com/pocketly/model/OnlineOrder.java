/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.pocketly.model;

import java.time.LocalDate;

public class OnlineOrder {

    public String idTransaksi;
    public LocalDate tanggal;
    public String tipePemesanan;      // "Pick up" / "Pesan antar"
    public String kodeTransaksiCash;  // terisi bila bayar tunai (COD)
    public String buktiPembayaran;    // path file bukti (e-wallet)
    public String statusPesanan;      // Dikemas / Siap diambil / Dikirim / Selesai / Dibatalkan
    public double biayaOngkir;
    public String usernamePelanggan;
    public String namaPelanggan;
    public String alamatPelanggan;
    public String metodePembayaran;   // Cash / E-Wallet / M-Bangking
    public String statusPembayaran;   // Menunggu verifikasi / Berhasil / Dibatalkan
    public double totalBayar;

    public boolean bayarTunai() {
        return kodeTransaksiCash != null && !kodeTransaksiCash.isBlank();
    }

    public double subtotalProduk() {
        return totalBayar - biayaOngkir;
    }
}
