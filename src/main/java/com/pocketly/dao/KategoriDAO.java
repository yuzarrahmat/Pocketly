/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package com.pocketly.dao;

import com.pocketly.model.Kategori;
import com.pocketly.util.DB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/** DAO kategori produk. */
public class KategoriDAO {

    public List<Kategori> semua() {
        List<Kategori> list = new ArrayList<>();
        String sql = "SELECT id_kategori, nama_kategori, lokasi_rak FROM kategori_produk ORDER BY id_kategori";
        try (Connection c = DB.getConnection();
             Statement st = c.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Kategori k = new Kategori();
                k.id = rs.getString(1);
                k.nama = rs.getString(2);
                k.lokasiRak = rs.getString(3);
                list.add(k);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Gagal membaca kategori: " + ex.getMessage(), ex);
        }
        return list;
    }
}
