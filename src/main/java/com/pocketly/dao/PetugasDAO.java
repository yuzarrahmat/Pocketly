/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package com.pocketly.dao;

import com.pocketly.model.Petugas;
import com.pocketly.util.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PetugasDAO {

    public Petugas getByUsername(String username) {
        String sql = "SELECT username, nip, jabatan FROM petugas WHERE username = ?";
        try (Connection c = DB.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Petugas p = new Petugas();
                    p.username = rs.getString("username");
                    p.nip = rs.getString("nip");
                    p.jabatan = rs.getString("jabatan");
                    return p;
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Gagal membaca petugas: " + ex.getMessage(), ex);
        }
        return null;
    }

    public String kasirDefault() {
        String sql = "SELECT username FROM petugas WHERE jabatan = 'Kasir' ORDER BY username LIMIT 1";
        try (Connection c = DB.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getString(1);
            }
        } catch (SQLException ex) {
            System.err.println("[PetugasDAO] kasirDefault: " + ex.getMessage());
        }
        return "ptg_dewi";
    }
}
