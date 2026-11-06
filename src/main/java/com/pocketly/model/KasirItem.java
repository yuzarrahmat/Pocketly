/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.pocketly.model;

/** Model sementara item belanja di halaman kasir offline (belum disimpan ke DB). */
public class KasirItem {

    public String idProduk;
    public String nama;
    public double harga;
    public int jumlah;

    public double subtotal() {
        return harga * jumlah;
    }
}
