/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.pocketly.controller;

import com.pocketly.dao.TransaksiDAO;
import com.pocketly.model.PendapatanRow;
import java.util.List;


public class PendapatanController {

    private final TransaksiDAO dao = new TransaksiDAO();

    public List<PendapatanRow> barisPendapatan() {
        return dao.pendapatan();
    }

    public double totalPendapatan() {
        return dao.totalPendapatan();
    }

    /** Bulan pendapatan untuk grafik beserta datanya per tanggal. */
    public record BulanGrafik(int tahun, int bulan, java.util.Map<java.time.LocalDate, Double> data) {
    }

    public BulanGrafik bulanGrafik() {
        java.time.LocalDate now = java.time.LocalDate.now();
        java.util.Map<java.time.LocalDate, Double> data = dao.pendapatanHarian(now.getYear(), now.getMonthValue());
        if (!data.isEmpty()) {
            return new BulanGrafik(now.getYear(), now.getMonthValue(), data);
        }
        java.time.LocalDate terakhir = dao.tanggalPendapatanTerakhir();
        if (terakhir != null) {
            data = dao.pendapatanHarian(terakhir.getYear(), terakhir.getMonthValue());
            return new BulanGrafik(terakhir.getYear(), terakhir.getMonthValue(), data);
        }
        return new BulanGrafik(now.getYear(), now.getMonthValue(), data);
    }
}
