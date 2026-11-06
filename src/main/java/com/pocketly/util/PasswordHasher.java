package com.pocketly.util;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 * Hash kata sandi dengan PBKDF2-HMAC-SHA256 (bawaan JDK, tanpa library
 * tambahan). Format tersimpan di database:
 *
 *   pbkdf2$iterasi$salt$hash     contoh: pbkdf2$120000$xxxx$xxxx
 *
 * Untuk kompatibilitas data lama, login memakai mode ganda:
 * nilai yang tidak berawalan "pbkdf2$" dianggap kata sandi lama
 * (teks biasa) sehingga akun lama tetap bisa masuk.
 */
public final class PasswordHasher {

    private static final int ITERASI = 120_000;
    private static final int PANJANG_KUNCI = 256;
    private static final String PREFIX = "pbkdf2$";
    private static final SecureRandom RNG = new SecureRandom();

    private PasswordHasher() {
    }

    /** true bila nilai di database sudah berbentuk hash PBKDF2. */
    public static boolean berbentukHash(String tersimpan) {
        return tersimpan != null && tersimpan.startsWith(PREFIX);
    }

    /** Menghasilkan hash kata sandi baru (dengan salt acak). */
    public static String hash(String kataSandi) {
        byte[] salt = new byte[16];
        RNG.nextBytes(salt);
        byte[] kunci = hitung(kataSandi, salt, ITERASI, PANJANG_KUNCI);
        return PREFIX + ITERASI + "$"
                + Base64.getUrlEncoder().withoutPadding().encodeToString(salt) + "$"
                + Base64.getUrlEncoder().withoutPadding().encodeToString(kunci);
    }

    /**
     * Memeriksa kata sandi masukan terhadap nilai di database.
     * Mendukung hash PBKDF2 maupun kata sandi lama (teks biasa).
     */
    public static boolean cocok(String kataSandi, String tersimpan) {
        if (tersimpan == null || kataSandi == null) {
            return false;
        }
        if (!berbentukHash(tersimpan)) {
            return tersimpan.equals(kataSandi);
        }
        try {
            String[] bagian = tersimpan.split("\\$");
            int iterasi = Integer.parseInt(bagian[1]);
            byte[] salt = Base64.getUrlDecoder().decode(bagian[2]);
            byte[] hashTersimpan = Base64.getUrlDecoder().decode(bagian[3]);
            byte[] hashMasukan = hitung(kataSandi, salt, iterasi, hashTersimpan.length * 8);
            return MessageDigest.isEqual(hashTersimpan, hashMasukan);
        } catch (Exception ex) {
            return false;
        }
    }

    private static byte[] hitung(String kataSandi, byte[] salt, int iterasi, int panjangBit) {
        try {
            PBEKeySpec spec = new PBEKeySpec(kataSandi.toCharArray(), salt, iterasi, panjangBit);
            return SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256").generateSecret(spec).getEncoded();
        } catch (Exception ex) {
            throw new IllegalStateException("Gagal menghitung hash kata sandi", ex);
        }
    }
}
