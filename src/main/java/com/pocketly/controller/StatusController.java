/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package com.pocketly.controller;

import com.pocketly.dao.TransaksiDAO;
import com.pocketly.model.OnlineOrder;
import java.util.List;

public class StatusController {

    private final TransaksiDAO dao = new TransaksiDAO();

    /** Pilihan status pada dropdown (sesuai enum DB). */
    public static final String[] STATUS = {"Dikemas", "Siap diambil", "Dikirim", "Selesai"};

    public List<OnlineOrder> daftarPesanan() {
        return dao.semuaPesananOnline();
    }

    public String ubahStatus(String idTransaksi, String statusBaru) {
        dao.updateStatusPesanan(idTransaksi, statusBaru);
        return "Status pesanan diperbarui";
    }
}
