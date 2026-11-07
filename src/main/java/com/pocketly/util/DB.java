package com.pocketly.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public final class DB {

    public static final String DEFAULT_URL = "jdbc:mysql://localhost:3306/db_pocketly";

    private static String url = DEFAULT_URL;
    private static String user = "root";
    private static String pass = "";

    private static boolean driverOk = false;

    static {
        loadConfig();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            driverOk = true;
        } catch (ClassNotFoundException ex) {
            System.err.println("[DB] PERINGATAN: Driver MySQL (mysql-connector-j) tidak ditemukan di classpath.");
            System.err.println("[DB] Solusi: klik kanan project -> Clean and Build di NetBeans,");
            System.err.println("[DB] atau pastikan mysql-connector-j ada di daftar Libraries project.");
        }
    }

    private DB() {
    }

    public static boolean driverTersedia() {
        return driverOk;
    }

    private static void loadConfig() {
        File f = new File("db.properties");
        if (!f.exists()) {
            return;
        }
        try (FileInputStream in = new FileInputStream(f)) {
            Properties p = new Properties();
            p.load(in);
            if (p.getProperty("db.url") != null && !p.getProperty("db.url").isBlank()) {
                url = p.getProperty("db.url").trim();
            }
            if (p.getProperty("db.user") != null && !p.getProperty("db.user").isBlank()) {
                user = p.getProperty("db.user").trim();
            }
            pass = p.getProperty("db.password", "").trim();
        } catch (IOException ex) {
            System.err.println("[DB] Gagal membaca db.properties: " + ex.getMessage());
        }
    }

    public static Connection getConnection() throws SQLException {
        if (!driverOk) {
            throw new SQLException("Driver MySQL tidak ada di classpath. "
                    + "Klik kanan project di NetBeans -> 'Clean and Build' agar Maven mengunduh "
                    + "dependensi mysql-connector-j, lalu jalankan ulang aplikasi.");
        }
        return DriverManager.getConnection(url, user, pass);
    }

    public static void ensurePatch() {
        String[] alters = {
            "ALTER TABLE pengguna MODIFY COLUMN password VARCHAR(255) NOT NULL",
            "ALTER TABLE produk ADD COLUMN gambar_produk VARCHAR(255) NULL",
            "ALTER TABLE keranjang ADD COLUMN tipe_pemesanan ENUM('Pesan antar','Pick up') NULL DEFAULT NULL"
        };
        try (Connection c = getConnection(); Statement st = c.createStatement()) {
            for (String sql : alters) {
                try {
                    st.execute(sql);
                } catch (SQLException ex) {
                    if (ex.getErrorCode() != 1060) { // 1060 = kolom sudah ada
                        System.err.println("[DB] Patch dilewati: " + ex.getMessage());
                    }
                }
            }
            isiGambarContoh(c);
        } catch (SQLException ex) {
            System.err.println("[DB] ensurePatch: " + ex.getMessage());
        }
    }

    private static void isiGambarContoh(Connection c) {
        String[][] seeds = {
            {"PRD001", "indomie-goreng.jpg"}, {"PRD002", "roti-sari-roti.jpg"},
            {"PRD004", "aqua-600ml.jpg"}, {"PRD005", "teh-botol-sosro.jpg"},
            {"PRD007", "minyak-bimoli.jpg"}, {"PRD008", "beras-pandan-wangi.jpg"},
            {"PRD009", "gula-pasir.jpg"}, {"PRD010", "pampers-baby-dry.jpg"},
            {"PRD011", "sgm-eksplor.jpg"}, {"PRD012", "bedak-bayi-zwitsal.jpg"},
            {"PRD013", "whiskas-tuna.jpg"}, {"PRD015", "meo-kitten.jpg"},
            {"PRD016", "sunsilk-shampoo.jpg"}, {"PRD017", "pepsodent-pasta-gigi.jpg"},
            {"PRD018", "lifebuoy-sabun.jpg"}, {"PRD019", "panadol-biru.jpg"},
            {"PRD020", "wipol-karbol.jpg"}, {"PRD021", "antis-hand-sanitizer.jpg"},
            {"PRD022", "baterai-abc-aa.jpg"}, {"PRD023", "korek-api-tokai.jpg"},
            {"PRD024", "tisu-paseo.jpg"}
        };
        String sql = "UPDATE produk SET gambar_produk = ? "
                   + "WHERE id_produk = ? AND (gambar_produk IS NULL OR gambar_produk = '')";
        try (PreparedStatement ps = c.prepareStatement(sql)) {
            for (String[] s : seeds) {
                ps.setString(1, s[1]);
                ps.setString(2, s[0]);
                ps.addBatch();
            }
            ps.executeBatch();
        } catch (SQLException ex) {
            System.err.println("[DB] isiGambarContoh: " + ex.getMessage());
        }
    }

    public static String nextId(String prefix, String table, String column) {
        String sql = "SELECT " + column + " FROM " + table;
        int max = 0;
        try (Connection c = getConnection(); Statement st = c.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
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
        } catch (SQLException ex) {
            System.err.println("[DB] nextId " + prefix + ": " + ex.getMessage());
        }
        return String.format("%s%03d", prefix, max + 1);
    }


    public static void close(AutoCloseable... rs) {
        for (AutoCloseable r : rs) {
            if (r != null) {
                try {
                    r.close();
                } catch (Exception ignore) {
                }
            }
        }
    }

    public static int scalarInt(String sql, Object... params) {
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? rs.getInt(1) : 0;
            }
        } catch (SQLException ex) {
            System.err.println("[DB] scalarInt: " + ex.getMessage());
            return 0;
        }
    }
}
