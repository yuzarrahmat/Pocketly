/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.pocketly.dao;

import com.pocketly.model.Produk;
import com.pocketly.util.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/** DAO produk: katalog pelanggan, kelola produk petugas, dan penyesuaian stok. */
public class ProdukDAO {

    private static Produk map(ResultSet rs) throws SQLException {
        Produk p = new Produk();
        p.id = rs.getString("id_produk");
        p.nama = rs.getString("nama_produk");
        p.hargaSatuan = rs.getDouble("harga_satuan");
        p.stok = rs.getInt("stok");
        p.satuan = rs.getString("satuan_barang");
        p.idKategori = rs.getString("id_kategori");
        p.namaKategori = rs.getString("nama_kategori");
        p.petugasUsername = rs.getString("petugas_username");
        p.status = rs.getString("status_produk");
        p.gambar = rs.getString("gambar_produk");
        return p;
    }

    private static final String BASE_SELECT =
            "SELECT p.id_produk, p.nama_produk, p.harga_satuan, p.stok, p.satuan_barang, "
          + "p.id_kategori, k.nama_kategori, p.petugas_username, p.status_produk, p.gambar_produk "
          + "FROM produk p LEFT JOIN kategori_produk k ON k.id_kategori = p.id_kategori ";

    /** Daftar produk aktif pada satu kategori (katalog pelanggan). */
    public List<Produk> aktifPerKategori(String idKategori) {
        List<Produk> list = new ArrayList<>();
        String sql = BASE_SELECT + "WHERE p.status_produk = 'Aktif' AND p.id_kategori = ? ORDER BY p.nama_produk";
        try (Connection c = DB.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, idKategori);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(map(rs));
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Gagal membaca produk: " + ex.getMessage(), ex);
        }
        return list;
    }

    /** Seluruh produk (aktif + nonaktif) untuk halaman kelola produk. */
    public List<Produk> semua() {
        List<Produk> list = new ArrayList<>();
        String sql = BASE_SELECT + "ORDER BY p.id_produk";
        try (Connection c = DB.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(map(rs));
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Gagal membaca produk: " + ex.getMessage(), ex);
        }
        return list;
    }

    public Produk getById(String id) {
        String sql = BASE_SELECT + "WHERE p.id_produk = ?";
        try (Connection c = DB.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return map(rs);
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Gagal membaca produk: " + ex.getMessage(), ex);
        }
        return null;
    }

    public void insert(Produk p) {
        String sql = "INSERT INTO produk (id_produk, nama_produk, harga_satuan, stok, satuan_barang, "
                   + "id_kategori, petugas_username, status_produk, gambar_produk) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection c = DB.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, p.id);
            ps.setString(2, p.nama);
            ps.setDouble(3, p.hargaSatuan);
            ps.setInt(4, p.stok);
            ps.setString(5, p.satuan);
            ps.setString(6, p.idKategori);
            ps.setString(7, p.petugasUsername);
            ps.setString(8, p.status == null ? "Aktif" : p.status);
            if (p.gambar == null || p.gambar.isBlank()) {
                ps.setNull(9, java.sql.Types.VARCHAR);
            } else {
                ps.setString(9, p.gambar);
            }
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Gagal menambah produk: " + ex.getMessage(), ex);
        }
    }

    public void update(Produk p) {
        String sql = "UPDATE produk SET nama_produk = ?, harga_satuan = ?, stok = ?, satuan_barang = ?, "
                   + "id_kategori = ?, status_produk = ?, gambar_produk = ? WHERE id_produk = ?";
        try (Connection c = DB.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, p.nama);
            ps.setDouble(2, p.hargaSatuan);
            ps.setInt(3, p.stok);
            ps.setString(4, p.satuan);
            ps.setString(5, p.idKategori);
            ps.setString(6, p.status);
            if (p.gambar == null || p.gambar.isBlank()) {
                ps.setNull(7, java.sql.Types.VARCHAR);
            } else {
                ps.setString(7, p.gambar);
            }
            ps.setString(8, p.id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Gagal mengubah produk: " + ex.getMessage(), ex);
        }
    }

    /** Ubah stok cepat (+/- atau input angka) di halaman kelola produk. */
    public void updateStok(String idProduk, int stokBaru) {
        String sql = "UPDATE produk SET stok = ? WHERE id_produk = ?";
        try (Connection c = DB.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, stokBaru);
            ps.setString(2, idProduk);
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Gagal mengubah stok: " + ex.getMessage(), ex);
        }
    }

    /** Stok terkini sebuah produk. */
    public int stokSaatIni(String idProduk) {
        return DB.scalarInt("SELECT stok FROM produk WHERE id_produk = ?", idProduk);
    }

    /** Menambah/mengurangi stok (qty boleh negatif). */
    public void sesuaikanStok(String idProduk, int delta) {
        String sql = "UPDATE produk SET stok = stok + ? WHERE id_produk = ?";
        try (Connection c = DB.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, delta);
            ps.setString(2, idProduk);
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Gagal menyesuaikan stok: " + ex.getMessage(), ex);
        }
    }
}
