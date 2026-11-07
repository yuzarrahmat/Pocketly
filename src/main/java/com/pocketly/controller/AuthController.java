package com.pocketly.controller;

import com.pocketly.dao.PenggunaDAO;
import com.pocketly.model.Pengguna;
import com.pocketly.util.PasswordHasher;
import java.util.regex.Pattern;

public class AuthController {

    private final PenggunaDAO dao = new PenggunaDAO();

    public static final int USERNAME_MIN = 5;
    public static final int USERNAME_MAX = 20;
    public static final int PASSWORD_MIN = 8;
    public static final int PASSWORD_MAX = 20;

    private static final Pattern POLA_USERNAME = Pattern.compile("^[a-zA-Z0-9_]+$");
    private static final Pattern POLA_EMAIL = Pattern.compile("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$");
    private static final Pattern POLA_TELP = Pattern.compile("^0[0-9]{9,12}$");

    public record Hasil(boolean sukses, String pesan, Pengguna akun) {
    }

    public Hasil login(String username, String password) {
        if (username == null || username.isBlank() || password == null || password.isBlank()) {
            return new Hasil(false, "Username dan password wajib diisi.", null);
        }
        try {
            Pengguna akun = dao.login(username.trim(), password);
            if (akun == null) {
                return new Hasil(false, "Username atau password salah", null);
            }
            return new Hasil(true, "Selamat datang, " + akun.username + "!", akun);
        } catch (RuntimeException ex) {
            return new Hasil(false, ex.getMessage(), null);
        }
    }


    public Hasil registrasi(String username, String password, String nama,
                            String alamat, String email, String noTelp) {
        String err = validasiRegistrasi(username, password, nama, alamat, email, noTelp);
        if (err != null) {
            return new Hasil(false, err, null);
        }
        username = username.trim();
        try {
            if (dao.usernameTerpakai(username)) {
                return new Hasil(false, "Username telah digunakan", null);
            }
            dao.registrasiPelanggan(username, PasswordHasher.hash(password), nama.trim(),
                    alamat.trim(), email.trim(), noTelp.trim());
            return new Hasil(true, "Registrasi Berhasil", null);
        } catch (RuntimeException ex) {
            return new Hasil(false, ex.getMessage(), null);
        }
    }

    public String validasiRegistrasi(String username, String password, String nama,
                                     String alamat, String email, String noTelp) {
        if (username == null || username.isBlank()) {
            return "Username wajib diisi.";
        }
        username = username.trim();
        if (username.length() < USERNAME_MIN || username.length() > USERNAME_MAX) {
            return "Username harus " + USERNAME_MIN + "-" + USERNAME_MAX + " karakter.";
        }
        if (!POLA_USERNAME.matcher(username).matches()) {
            return "Username hanya boleh huruf, angka, dan garis bawah (tanpa spasi).";
        }
        if (password == null || password.isBlank()) {
            return "Password wajib diisi.";
        }
        if (password.length() < PASSWORD_MIN || password.length() > PASSWORD_MAX) {
            return "Password harus " + PASSWORD_MIN + "-" + PASSWORD_MAX + " karakter.";
        }
        if (password.startsWith(" ") || password.endsWith(" ")) {
            return "Password tidak boleh diawali/diakhiri spasi.";
        }
        if (nama == null || nama.isBlank()) {
            return "Nama wajib diisi.";
        }
        if (nama.trim().length() < 3 || nama.trim().length() > 50) {
            return "Nama harus 3-50 karakter.";
        }
        if (alamat == null || alamat.isBlank()) {
            return "Alamat wajib diisi.";
        }
        if (alamat.trim().length() < 5) {
            return "Alamat terlalu pendek (minimal 5 karakter).";
        }
        if (email == null || email.isBlank()) {
            return "Email wajib diisi.";
        }
        if (!POLA_EMAIL.matcher(email.trim()).matches()) {
            return "Format email tidak valid (contoh: nama@email.com).";
        }
        if (noTelp == null || noTelp.isBlank()) {
            return "No. telepon wajib diisi.";
        }
        if (!POLA_TELP.matcher(noTelp.trim()).matches()) {
            return "No. telepon harus 10-13 digit angka dan diawali 0.";
        }
        return null;
    }
}
