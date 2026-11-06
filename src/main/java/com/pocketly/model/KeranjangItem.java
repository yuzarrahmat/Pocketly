/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.pocketly.model;

/** Model satu baris keranjang pelanggan (tabel keranjang JOIN produk). */
public class KeranjangItem {

    public String idKeranjang;
    public String idProduk;
    public String namaProduk;
    public double hargaSatuan;
    public String satuan;
    public String gambar;              // nama file gambar produk (bisa null)
    public int jumlah;            // jumlah barang di keranjang
    public double subtotalEstimasi;
    public boolean dipilih;       // centang untuk checkout / hapus
}
