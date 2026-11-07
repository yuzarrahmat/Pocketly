/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.pocketly.controller;

import com.pocketly.dao.TransaksiDAO;
import com.pocketly.model.DetailTransaksi;
import com.pocketly.model.OnlineOrder;
import java.util.List;


public class RiwayatController {

    private final TransaksiDAO dao = new TransaksiDAO();

    public List<OnlineOrder> riwayat(String username) {
        return dao.riwayatPelanggan(username);
    }

    public OnlineOrder detail(String idTransaksi) {
        return dao.detailOnline(idTransaksi);
    }

    public List<DetailTransaksi> itemTransaksi(String idTransaksi) {
        return dao.detailItem(idTransaksi);
    }

    public int jumlahTransaksi(String username) {
        return dao.jumlahTransaksiPelanggan(username);
    }
}
