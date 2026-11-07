/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.pocketly.model;

import java.time.LocalDate;

public class PendapatanRow {

    public String idTransaksi;
    public LocalDate tanggal;
    public String jenis;   // Offline / Online
    public String metode;  // Cash / E-Wallet / M-Bangking
    public double total;
}
