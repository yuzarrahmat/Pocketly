/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.pocketly.controller;

import com.pocketly.dao.PelangganDAO;
import com.pocketly.dao.TransaksiDAO;
import com.pocketly.model.Pelanggan;


public class ProfilController {

    private final PelangganDAO pelangganDao = new PelangganDAO();
    private final TransaksiDAO transaksiDao = new TransaksiDAO();

    public Pelanggan profil(String username) {
        return pelangganDao.getByUsername(username);
    }

    public int totalTransaksi(String username) {
        return transaksiDao.jumlahTransaksiPelanggan(username);
    }
}
