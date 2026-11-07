/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.pocketly.dao;

import com.pocketly.model.DetailTransaksi;
import com.pocketly.model.KeranjangItem;
import com.pocketly.model.KasirItem;
import com.pocketly.model.OnlineOrder;
import com.pocketly.model.PendapatanRow;
import com.pocketly.util.DB;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TransaksiDAO {

    // ================= PEMBACAAN =================

    private static OnlineOrder mapOnline(ResultSet rs) throws SQLException {
        OnlineOrder o = new OnlineOrder();
        o.idTransaksi = rs.getString("id_transaksi");
        o.tanggal = rs.getObject("tanggal_transaksi", LocalDate.class);
        o.tipePemesanan = rs.getString("tipe_pemesanan");
        o.kodeTransaksiCash = rs.getString("kode_transaksi_cash");
        o.buktiPembayaran = rs.getString("bukti_pembayaran");
        o.statusPesanan = rs.getString("status_pesanan");
        o.biayaOngkir = rs.getDouble("biaya_ongkir");
        o.usernamePelanggan = rs.getString("pelanggan_username");
        o.namaPelanggan = rs.getString("nama");
        o.alamatPelanggan = rs.getString("alamat");
        o.metodePembayaran = rs.getString("metode_pembayaran");
        o.statusPembayaran = rs.getString("status_pembayaran");
        o.totalBayar = rs.getDouble("total_bayar");
        return o;
    }

    private static final String ONLINE_SELECT =
            "SELECT t.id_transaksi, t.tanggal_transaksi, o.tipe_pemesanan, o.kode_transaksi_cash, "
          + "o.bukti_pembayaran, o.status_pesanan, o.biaya_ongkir, o.pelanggan_username, "
          + "pl.nama, pl.alamat, t.metode_pembayaran, t.status_pembayaran, t.total_bayar "
          + "FROM transaksi t "
          + "JOIN online o ON o.id_transaksi = t.id_transaksi "
          + "LEFT JOIN pelanggan pl ON pl.username = o.pelanggan_username ";

    /** Riwayat transaksi online milik satu pelanggan (terbaru di atas). */
    public List<OnlineOrder> riwayatPelanggan(String username) {
        List<OnlineOrder> list = new ArrayList<>();
        String sql = ONLINE_SELECT + "WHERE o.pelanggan_username = ? ORDER BY t.tanggal_transaksi DESC, t.id_transaksi DESC";
        try (Connection c = DB.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(mapOnline(rs));
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Gagal membaca riwayat transaksi: " + ex.getMessage(), ex);
        }
        return list;
    }

    public OnlineOrder detailOnline(String idTransaksi) {
        String sql = ONLINE_SELECT + "WHERE t.id_transaksi = ?";
        try (Connection c = DB.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, idTransaksi);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapOnline(rs);
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Gagal membaca transaksi: " + ex.getMessage(), ex);
        }
        return null;
    }

    public List<DetailTransaksi> detailItem(String idTransaksi) {
        List<DetailTransaksi> list = new ArrayList<>();
        String sql = "SELECT d.id_detail_transaksi, d.id_transaksi, d.id_produk, p.nama_produk, "
                   + "d.jumlah_beli, d.harga_transaksi, d.subtotal_item "
                   + "FROM detail_transaksi d JOIN produk p ON p.id_produk = d.id_produk "
                   + "WHERE d.id_transaksi = ? ORDER BY d.id_detail_transaksi";
        try (Connection c = DB.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, idTransaksi);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    DetailTransaksi d = new DetailTransaksi();
                    d.idDetail = rs.getString(1);
                    d.idTransaksi = rs.getString(2);
                    d.idProduk = rs.getString(3);
                    d.namaProduk = rs.getString(4);
                    d.jumlahBeli = rs.getInt(5);
                    d.hargaSaatTransaksi = rs.getDouble(6);
                    d.subtotalItem = rs.getDouble(7);
                    list.add(d);
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Gagal membaca detail transaksi: " + ex.getMessage(), ex);
        }
        return list;
    }

    public List<OnlineOrder> menungguVerifikasi() {
        List<OnlineOrder> list = new ArrayList<>();
        String sql = ONLINE_SELECT + "WHERE t.status_pembayaran = 'Menunggu verifikasi' "
                   + "ORDER BY t.tanggal_transaksi, t.id_transaksi";
        try (Connection c = DB.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(mapOnline(rs));
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Gagal membaca antrean verifikasi: " + ex.getMessage(), ex);
        }
        return list;
    }

    public List<OnlineOrder> semuaPesananOnline() {
        List<OnlineOrder> list = new ArrayList<>();
        String sql = ONLINE_SELECT + "ORDER BY t.tanggal_transaksi DESC, t.id_transaksi DESC";
        try (Connection c = DB.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(mapOnline(rs));
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Gagal membaca pesanan online: " + ex.getMessage(), ex);
        }
        return list;
    }

    public int jumlahTransaksiPelanggan(String username) {
        return DB.scalarInt("SELECT COUNT(*) FROM online WHERE pelanggan_username = ?", username);
    }

    public List<PendapatanRow> pendapatan() {
        List<PendapatanRow> list = new ArrayList<>();
        String sql = "SELECT id_transaksi, tanggal_transaksi, jenis_transaksi, metode_pembayaran, total_bayar "
                   + "FROM transaksi WHERE status_pembayaran = 'Berhasil' "
                   + "ORDER BY tanggal_transaksi DESC, id_transaksi DESC";
        try (Connection c = DB.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                PendapatanRow r = new PendapatanRow();
                r.idTransaksi = rs.getString(1);
                r.tanggal = rs.getObject(2, LocalDate.class);
                r.jenis = rs.getString(3);
                r.metode = rs.getString(4);
                r.total = rs.getDouble(5);
                list.add(r);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Gagal membaca pendapatan: " + ex.getMessage(), ex);
        }
        return list;
    }

    /** Tanggal transaksi berhasil terakhir (null bila belum ada). */
    public LocalDate tanggalPendapatanTerakhir() {
        String sql = "SELECT MAX(tanggal_transaksi) FROM transaksi WHERE status_pembayaran = 'Berhasil'";
        try (Connection c = DB.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            return rs.next() ? rs.getObject(1, LocalDate.class) : null;
        } catch (SQLException ex) {
            throw new RuntimeException("Gagal membaca tanggal pendapatan: " + ex.getMessage(), ex);
        }
    }

    /**
     * Total pendapatan per tanggal pada satu bulan tertentu
     * (hanya transaksi berstatus Berhasil).
     */
    public java.util.Map<LocalDate, Double> pendapatanHarian(int tahun, int bulan) {
        java.util.Map<LocalDate, Double> map = new java.util.LinkedHashMap<>();
        String sql = "SELECT tanggal_transaksi, SUM(total_bayar) FROM transaksi "
                   + "WHERE status_pembayaran = 'Berhasil' AND YEAR(tanggal_transaksi) = ? "
                   + "AND MONTH(tanggal_transaksi) = ? GROUP BY tanggal_transaksi "
                   + "ORDER BY tanggal_transaksi";
        try (Connection c = DB.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, tahun);
            ps.setInt(2, bulan);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    map.put(rs.getObject(1, LocalDate.class), rs.getDouble(2));
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Gagal membaca pendapatan harian: " + ex.getMessage(), ex);
        }
        return map;
    }

    public double totalPendapatan() {
        String sql = "SELECT COALESCE(SUM(total_bayar), 0) FROM transaksi WHERE status_pembayaran = 'Berhasil'";
        try (Connection c = DB.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            return rs.next() ? rs.getDouble(1) : 0;
        } catch (SQLException ex) {
            throw new RuntimeException("Gagal menghitung pendapatan: " + ex.getMessage(), ex);
        }
    }

    public void checkoutOnline(String username, List<KeranjangItem> items, String tipePemesanan,
                               String metodePembayaran, String kodeCash, String buktiPath,
                               double ongkir, String petugasDefault) {
        Connection c = null;
        try {
            c = DB.getConnection();
            c.setAutoCommit(false);
            String idTrx = DB.nextId("TRX", "transaksi", "id_transaksi");

            double subtotal = 0;
            for (KeranjangItem i : items) {
                subtotal += i.hargaSatuan * i.jumlah;
            }
            double total = subtotal + ongkir;

            try (PreparedStatement ps = c.prepareStatement(
                    "INSERT INTO transaksi (id_transaksi, tanggal_transaksi, jenis_transaksi, metode_pembayaran, "
                  + "status_pembayaran, total_bayar, waktu_lunas, petugas_username) "
                  + "VALUES (?, ?, 'Online', ?, 'Menunggu verifikasi', ?, NULL, ?)")) {
                ps.setString(1, idTrx);
                ps.setDate(2, Date.valueOf(LocalDate.now()));
                ps.setString(3, metodePembayaran);
                ps.setDouble(4, total);
                ps.setString(5, petugasDefault);
                ps.executeUpdate();
            }
            try (PreparedStatement ps = c.prepareStatement(
                    "INSERT INTO online (id_transaksi, tipe_pemesanan, kode_transaksi_cash, bukti_pembayaran, "
                  + "status_pesanan, biaya_ongkir, pelanggan_username) VALUES (?, ?, ?, ?, 'Dikemas', ?, ?)")) {
                ps.setString(1, idTrx);
                ps.setString(2, tipePemesanan);
                if (kodeCash == null) {
                    ps.setNull(3, java.sql.Types.VARCHAR);
                } else {
                    ps.setString(3, kodeCash);
                }
                if (buktiPath == null) {
                    ps.setNull(4, java.sql.Types.VARCHAR);
                } else {
                    ps.setString(4, buktiPath);
                }
                ps.setDouble(5, ongkir);
                ps.setString(6, username);
                ps.executeUpdate();
            }
            for (KeranjangItem i : items) {
                try (PreparedStatement ps = c.prepareStatement(
                        "INSERT INTO detail_transaksi (id_detail_transaksi, jumlah_beli, harga_transaksi, "
                      + "subtotal_item, id_transaksi, id_produk) VALUES (?, ?, ?, ?, ?, ?)")) {
                    // id dihitung lewat koneksi transaksi yang sama agar
                    // baris yang baru disisipkan ikut terhitung (tidak duplikat)
                    ps.setString(1, nextId(c, "DTL", "detail_transaksi", "id_detail_transaksi"));
                    ps.setInt(2, i.jumlah);
                    ps.setDouble(3, i.hargaSatuan);
                    ps.setDouble(4, i.hargaSatuan * i.jumlah);
                    ps.setString(5, idTrx);
                    ps.setString(6, i.idProduk);
                    ps.executeUpdate();
                }
                try (PreparedStatement ps = c.prepareStatement(
                        "DELETE FROM keranjang WHERE id_keranjang = ?")) {
                    ps.setString(1, i.idKeranjang);
                    ps.executeUpdate();
                }
            }
            c.commit();
        } catch (SQLException ex) {
            if (c != null) {
                try { c.rollback(); } catch (SQLException ignore) {}
            }
            throw new RuntimeException("Gagal menyimpan checkout: " + ex.getMessage(), ex);
        } finally {
            if (c != null) {
                try { c.setAutoCommit(true); c.close(); } catch (SQLException ignore) {}
            }
        }
    }

    // ================= VERIFIKASI PEMBAYARAN =================

    /**
     * Hasil verifikasi bukti pembayaran oleh petugas.
     * Valid   -> status Berhasil + waktu lunas + petugas verifikator.
     * Invalid -> status Dibatalkan (transaksi & pesanan) + stok dikembalikan.
     */
    public void verifikasiPembayaran(String idTransaksi, boolean valid, String petugas) {
        Connection c = null;
        try {
            c = DB.getConnection();
            c.setAutoCommit(false);
            String status = valid ? "Berhasil" : "Dibatalkan";
            try (PreparedStatement ps = c.prepareStatement(
                    "UPDATE transaksi SET status_pembayaran = ?, waktu_lunas = ?, petugas_username = ? "
                  + "WHERE id_transaksi = ?")) {
                ps.setString(1, status);
                if (valid) {
                    ps.setDate(2, Date.valueOf(LocalDate.now()));
                } else {
                    ps.setNull(2, java.sql.Types.DATE);
                }
                ps.setString(3, petugas);
                ps.setString(4, idTransaksi);
                ps.executeUpdate();
            }
            if (!valid) {
                try (PreparedStatement ps = c.prepareStatement(
                        "UPDATE online SET status_pesanan = 'Dibatalkan' WHERE id_transaksi = ?")) {
                    ps.setString(1, idTransaksi);
                    ps.executeUpdate();
                }
                // kembalikan stok produk yang sudah dipesan
                try (PreparedStatement ps = c.prepareStatement(
                        "UPDATE produk p JOIN detail_transaksi d ON d.id_produk = p.id_produk "
                      + "SET p.stok = p.stok + d.jumlah_beli WHERE d.id_transaksi = ?")) {
                    ps.setString(1, idTransaksi);
                    ps.executeUpdate();
                }
            }
            c.commit();
        } catch (SQLException ex) {
            if (c != null) {
                try { c.rollback(); } catch (SQLException ignore) {}
            }
            throw new RuntimeException("Gagal verifikasi pembayaran: " + ex.getMessage(), ex);
        } finally {
            if (c != null) {
                try { c.setAutoCommit(true); c.close(); } catch (SQLException ignore) {}
            }
        }
    }

    /** Mengubah status pesanan online (Dikemas / Siap diambil / Dikirim / Selesai). */
    public void updateStatusPesanan(String idTransaksi, String statusBaru) {
        String sql = "UPDATE online SET status_pesanan = ? WHERE id_transaksi = ?";
        try (Connection c = DB.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, statusBaru);
            ps.setString(2, idTransaksi);
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Gagal mengubah status pesanan: " + ex.getMessage(), ex);
        }
    }

    // ================= KASIR OFFLINE =================

    /**
     * Menyimpan transaksi kasir offline: transaksi + offline + detail,
     * serta mengurangi stok produk.
     */
    public void simpanKasirOffline(List<KasirItem> items, String metodePembayaran,
                                   double nominalBayar, double kembalian,
                                   String namaPembeli, String petugas) {
        Connection c = null;
        try {
            c = DB.getConnection();
            c.setAutoCommit(false);
            String idTrx = DB.nextId("TRX", "transaksi", "id_transaksi");

            double total = 0;
            for (KasirItem i : items) {
                total += i.subtotal();
            }

            try (PreparedStatement ps = c.prepareStatement(
                    "INSERT INTO transaksi (id_transaksi, tanggal_transaksi, jenis_transaksi, metode_pembayaran, "
                  + "status_pembayaran, total_bayar, waktu_lunas, petugas_username) "
                  + "VALUES (?, ?, 'Offline', ?, 'Berhasil', ?, ?, ?)")) {
                ps.setString(1, idTrx);
                ps.setDate(2, Date.valueOf(LocalDate.now()));
                ps.setString(3, metodePembayaran);
                ps.setDouble(4, total);
                ps.setDate(5, Date.valueOf(LocalDate.now()));
                ps.setString(6, petugas);
                ps.executeUpdate();
            }
            try (PreparedStatement ps = c.prepareStatement(
                    "INSERT INTO offline (id_transaksi, nominal_bayar, nominal_kembalian, nama_pembeli) "
                  + "VALUES (?, ?, ?, ?)")) {
                ps.setString(1, idTrx);
                ps.setDouble(2, nominalBayar);
                ps.setDouble(3, kembalian);
                if (namaPembeli == null || namaPembeli.isBlank()) {
                    ps.setNull(4, java.sql.Types.VARCHAR);
                } else {
                    ps.setString(4, namaPembeli.trim());
                }
                ps.executeUpdate();
            }
            for (KasirItem i : items) {
                try (PreparedStatement ps = c.prepareStatement(
                        "INSERT INTO detail_transaksi (id_detail_transaksi, jumlah_beli, harga_transaksi, "
                      + "subtotal_item, id_transaksi, id_produk) VALUES (?, ?, ?, ?, ?, ?)")) {
                    ps.setString(1, nextId(c, "DTL", "detail_transaksi", "id_detail_transaksi"));
                    ps.setInt(2, i.jumlah);
                    ps.setDouble(3, i.harga);
                    ps.setDouble(4, i.subtotal());
                    ps.setString(5, idTrx);
                    ps.setString(6, i.idProduk);
                    ps.executeUpdate();
                }
                try (PreparedStatement ps = c.prepareStatement(
                        "UPDATE produk SET stok = stok - ? WHERE id_produk = ?")) {
                    ps.setInt(1, i.jumlah);
                    ps.setString(2, i.idProduk);
                    ps.executeUpdate();
                }
            }
            c.commit();
        } catch (SQLException ex) {
            if (c != null) {
                try { c.rollback(); } catch (SQLException ignore) {}
            }
            throw new RuntimeException("Gagal menyimpan transaksi kasir: " + ex.getMessage(), ex);
        } finally {
            if (c != null) {
                try { c.setAutoCommit(true); c.close(); } catch (SQLException ignore) {}
            }
        }
    }

    /**
     * Membuat id berurutan berikutnya menggunakan koneksi transaksi yang
     * sama, sehingga baris yang baru disisipkan (belum di-commit) tetap
     * terhitung dan id tidak akan duplikat.
     */
    private static String nextId(Connection c, String prefix, String table, String column) throws SQLException {
        String sql = "SELECT " + column + " FROM " + table;
        int max = 0;
        try (PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String id = rs.getString(1);
                if (id != null && id.startsWith(prefix) && id.length() > prefix.length()) {
                    try {
                        int n = Integer.parseInt(id.substring(prefix.length()).replaceAll("\\D", ""));
                        if (n > max) {
                            max = n;
                        }
                    } catch (NumberFormatException ignore) {
                    }
                }
            }
        }
        return String.format("%s%03d", prefix, max + 1);
    }

    /** Membuat kode transaksi tunai: CSH-yymmdd-xxx (urutan per hari). */
    public String buatKodeCash() {
        String prefix = "CSH-" + LocalDate.now().format(java.time.format.DateTimeFormatter.ofPattern("yyMMdd")) + "-";
        int max = 0;
        String sql = "SELECT kode_transaksi_cash FROM online WHERE kode_transaksi_cash LIKE ?";
        try (Connection c = DB.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, prefix + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String kode = rs.getString(1);
                    try {
                        int n = Integer.parseInt(kode.substring(prefix.length()));
                        if (n > max) {
                            max = n;
                        }
                    } catch (NumberFormatException ignore) {
                    }
                }
            }
        } catch (SQLException ex) {
            System.err.println("[TransaksiDAO] buatKodeCash: " + ex.getMessage());
        }
        return String.format("%s%03d", prefix, max + 1);
    }
}
