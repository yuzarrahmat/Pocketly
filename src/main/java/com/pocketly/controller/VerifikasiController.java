/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.pocketly.controller;

import com.pocketly.dao.TransaksiDAO;
import com.pocketly.model.OnlineOrder;
import java.util.List;

public class VerifikasiController {

    private final TransaksiDAO dao = new TransaksiDAO();

    /** Antrean transaksi online berstatus "Menunggu verifikasi". */
    public List<OnlineOrder> antrean() {
        return dao.menungguVerifikasi();
    }

    public String verifikasi(String idTransaksi, boolean valid, String petugas) {
        dao.verifikasiPembayaran(idTransaksi, valid, petugas);
        return valid ? "Bukti pembayaran diterima" : "Bukti pembayaran ditolak";
    }
}
