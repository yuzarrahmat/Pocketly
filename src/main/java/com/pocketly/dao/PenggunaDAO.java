package com.pocketly.dao;

import com.pocketly.model.Pengguna;
import com.pocketly.util.DB;
import com.pocketly.util.PasswordHasher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/** DAO akun pengguna: login dan pengecekan username registrasi. */
public class PenggunaDAO {

    /**
     * Mengembalikan akun bila username + password cocok, selain itu null.
     * Password di database boleh berupa hash PBKDF2 (akun baru) maupun
     * teks biasa (akun lama), keduanya diverifikasi.
     */
    public Pengguna login(String username, String password) {
        String sql = "SELECT username, password, peran_pengguna FROM pengguna WHERE username = ?";
        try (Connection c = DB.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next() && PasswordHasher.cocok(password, rs.getString(2))) {
                    return new Pengguna(rs.getString(1), rs.getString(2), rs.getString(3));
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Gagal terhubung ke database: " + ex.getMessage(), ex);
        }
        return null;
    }

    /** true bila username sudah dipakai akun lain. */
    public boolean usernameTerpakai(String username) {
        return DB.scalarInt("SELECT COUNT(*) FROM pengguna WHERE username = ?", username) > 0;
    }

    /**
     * Menyimpan akun pelanggan baru (password sudah di-hash) beserta
     * data profilnya: nama, alamat, email, dan no. telepon.
     */
    public void registrasiPelanggan(String username, String passwordHash, String nama,
                                    String alamat, String email, String noTelp) {
        Connection c = null;
        try {
            c = DB.getConnection();
            c.setAutoCommit(false);
            try (PreparedStatement p1 = c.prepareStatement(
                    "INSERT INTO pengguna (username, password, peran_pengguna) VALUES (?, ?, 'Pelanggan')")) {
                p1.setString(1, username);
                p1.setString(2, passwordHash);
                p1.executeUpdate();
            }
            try (PreparedStatement p2 = c.prepareStatement(
                    "INSERT INTO pelanggan (username, alamat, tanggal_registrasi, email, nama, no_telp) "
                  + "VALUES (?, ?, CURDATE(), ?, ?, ?)")) {
                p2.setString(1, username);
                p2.setString(2, alamat);
                p2.setString(3, email);
                p2.setString(4, nama);
                p2.setString(5, noTelp);
                p2.executeUpdate();
            }
            c.commit();
        } catch (SQLException ex) {
            if (c != null) {
                try { c.rollback(); } catch (SQLException ignore) {}
            }
            throw new RuntimeException("Gagal menyimpan registrasi: " + ex.getMessage(), ex);
        } finally {
            if (c != null) {
                try { c.setAutoCommit(true); c.close(); } catch (SQLException ignore) {}
            }
        }
    }
}
