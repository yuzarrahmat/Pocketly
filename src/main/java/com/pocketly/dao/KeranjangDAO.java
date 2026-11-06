/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package com.pocketly.dao;

import com.pocketly.model.KeranjangItem;
import com.pocketly.util.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/** DAO keranjang belanja pelanggan. */
public class KeranjangDAO {

    private static KeranjangItem map(ResultSet rs) throws SQLException {
        KeranjangItem k = new KeranjangItem();
        k.idKeranjang = rs.getString("id_keranjang");
        k.idProduk = rs.getString("id_produk");
        k.namaProduk = rs.getString("nama_produk");
        k.hargaSatuan = rs.getDouble("harga_satuan");
        k.satuan = rs.getString("satuan_barang");
        k.gambar = rs.getString("gambar_produk");
        k.jumlah = rs.getInt("jumlah_barang");
        k.subtotalEstimasi = rs.getDouble("subtotal_estimasi");
        return k;
    }

    /** Seluruh isi keranjang milik satu pelanggan. */
    public List<KeranjangItem> isiKeranjang(String username) {
        List<KeranjangItem> list = new ArrayList<>();
        String sql = "SELECT kr.id_keranjang, kr.id_produk, p.nama_produk, p.harga_satuan, "
                   + "p.satuan_barang, p.gambar_produk, kr.jumlah_barang, kr.subtotal_estimasi "
                   + "FROM keranjang kr JOIN produk p ON p.id_produk = kr.id_produk "
                   + "WHERE kr.pelanggan_username = ? ORDER BY kr.id_keranjang";
        try (Connection c = DB.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(map(rs));
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Gagal membaca keranjang: " + ex.getMessage(), ex);
        }
        return list;
    }

    /** Baris keranjang untuk satu pelanggan + produk (null bila belum ada). */
    public KeranjangItem cari(String username, String idProduk) {
        String sql = "SELECT kr.id_keranjang, kr.id_produk, p.nama_produk, p.harga_satuan, "
                   + "p.satuan_barang, p.gambar_produk, kr.jumlah_barang, kr.subtotal_estimasi "
                   + "FROM keranjang kr JOIN produk p ON p.id_produk = kr.id_produk "
                   + "WHERE kr.pelanggan_username = ? AND kr.id_produk = ?";
        try (Connection c = DB.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, idProduk);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return map(rs);
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Gagal membaca keranjang: " + ex.getMessage(), ex);
        }
        return null;
    }

    /** Menambah jumlah produk pada keranjang (atau membuat baris baru). */
    public void tambah(String username, String idProduk, int tambahan, double hargaSatuan) {
        KeranjangItem existing = cari(username, idProduk);
        int baru = (existing == null ? 0 : existing.jumlah) + tambahan;
        try (Connection c = DB.getConnection()) {
            if (existing == null) {
                try (PreparedStatement ps = c.prepareStatement(
                        "INSERT INTO keranjang (id_keranjang, jumlah_barang, subtotal_estimasi, id_produk, pelanggan_username) "
                      + "VALUES (?, ?, ?, ?, ?)")) {
                    ps.setString(1, DB.nextId("KRJ", "keranjang", "id_keranjang"));
                    ps.setInt(2, baru);
                    ps.setDouble(3, baru * hargaSatuan);
                    ps.setString(4, idProduk);
                    ps.setString(5, username);
                    ps.executeUpdate();
                }
            } else {
                try (PreparedStatement ps = c.prepareStatement(
                        "UPDATE keranjang SET jumlah_barang = ?, subtotal_estimasi = ? "
                      + "WHERE id_keranjang = ?")) {
                    ps.setInt(1, baru);
                    ps.setDouble(2, baru * hargaSatuan);
                    ps.setString(3, existing.idKeranjang);
                    ps.executeUpdate();
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Gagal memperbarui keranjang: " + ex.getMessage(), ex);
        }
    }

    /** Mengubah jumlah barang satu baris keranjang. */
    public void setJumlah(String idKeranjang, int jumlah, double hargaSatuan) {
        String sql = "UPDATE keranjang SET jumlah_barang = ?, subtotal_estimasi = ? WHERE id_keranjang = ?";
        try (Connection c = DB.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, jumlah);
            ps.setDouble(2, jumlah * hargaSatuan);
            ps.setString(3, idKeranjang);
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Gagal mengubah keranjang: " + ex.getMessage(), ex);
        }
    }

    public void hapus(String idKeranjang) {
        try (Connection c = DB.getConnection();
             PreparedStatement ps = c.prepareStatement("DELETE FROM keranjang WHERE id_keranjang = ?")) {
            ps.setString(1, idKeranjang);
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Gagal menghapus dari keranjang: " + ex.getMessage(), ex);
        }
    }

    /**
     * Tipe pemesanan tersimpan pelanggan ("Pesan antar" / "Pick up").
     * Mengembalikan null bila pelanggan belum memilih (dropdown kosong).
     */
    public String tipePemesanan(String username) {
        String sql = "SELECT tipe_pemesanan FROM keranjang WHERE pelanggan_username = ? "
                   + "AND tipe_pemesanan IS NOT NULL LIMIT 1";
        try (Connection c = DB.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getString(1);
                }
            }
        } catch (SQLException ex) {
            System.err.println("[KeranjangDAO] tipePemesanan: " + ex.getMessage());
        }
        return null;
    }

    /** Menyimpan tipe pemesanan untuk seluruh baris keranjang pelanggan. */
    public void setTipePemesanan(String username, String tipe) {
        String sql = "UPDATE keranjang SET tipe_pemesanan = ? WHERE pelanggan_username = ?";
        try (Connection c = DB.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, tipe);
            ps.setString(2, username);
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Gagal menyimpan tipe pemesanan: " + ex.getMessage(), ex);
        }
    }
}
