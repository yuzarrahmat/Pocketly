package com.pocketly.dao;

import com.pocketly.model.Pelanggan;
import com.pocketly.util.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/** DAO data profil pelanggan. */
public class PelangganDAO {

    public Pelanggan getByUsername(String username) {
        String sql = "SELECT username, nama, alamat, email, no_telp, tanggal_registrasi "
                   + "FROM pelanggan WHERE username = ?";
        try (Connection c = DB.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Pelanggan p = new Pelanggan();
                    p.username = rs.getString("username");
                    p.nama = rs.getString("nama");
                    p.alamat = rs.getString("alamat");
                    p.email = rs.getString("email");
                    p.noTelp = rs.getString("no_telp");
                    p.tglRegistrasi = rs.getObject("tanggal_registrasi", LocalDate.class);
                    return p;
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Gagal membaca pelanggan: " + ex.getMessage(), ex);
        }
        return null;
    }

    /** Mengubah alamat pelanggan (digunakan di halaman keranjang). */
    public void updateAlamat(String username, String alamatBaru) {
        String sql = "UPDATE pelanggan SET alamat = ? WHERE username = ?";
        try (Connection c = DB.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, alamatBaru);
            ps.setString(2, username);
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Gagal mengubah alamat: " + ex.getMessage(), ex);
        }
    }
}
