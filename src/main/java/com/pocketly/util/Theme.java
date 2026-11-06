package com.pocketly.util;

import java.awt.Color;
import java.awt.Font;
import java.io.InputStream;
import javax.swing.UIManager;

/**
 * Palet warna dan tipografi Pocketly, mengikuti desain Figma
 * "TIM 4 - UI/UX" (font Lato, latar biru muda, tombol pill navy).
 */
public final class Theme {

    // ===== Palet warna dari file Figma =====
    public static final Color NAVY        = new Color(0x06, 0x23, 0x49); // tombol utama & teks judul
    public static final Color NAVY_DARK   = new Color(0x03, 0x27, 0x57); // judul hero
    public static final Color BLUE        = new Color(0x00, 0x71, 0xE1); // aksi (Checkout)
    public static final Color BLUE_DARK   = new Color(0x00, 0x5F, 0xBE); // hover aksi
    public static final Color BLUE_LIGHT  = new Color(0xDA, 0xEC, 0xF1); // latar halaman
    public static final Color PAGE_BG     = new Color(0xDA, 0xEC, 0xF1); // latar halaman (Figma)
    public static final Color CONTENT_BG  = new Color(0xF6, 0xFC, 0xFF); // area konten (Figma)
    public static final Color CARD        = Color.WHITE;
    public static final Color FIELD_BG    = new Color(0xF1, 0xEE, 0xEE); // kolom input (Figma)
    public static final Color PILL_NEUTRAL= new Color(0xEB, 0xEC, 0xED); // pill jumlah netral
    public static final Color BORDER      = new Color(0xE2, 0xE8, 0xF0);
    public static final Color TEXT        = new Color(0x07, 0x0B, 0x16); // teks utama (Figma)
    public static final Color TEXT_DARK   = new Color(0x06, 0x23, 0x49); // teks judul (Figma)
    public static final Color TEXT_MUTED  = new Color(0x64, 0x74, 0x8B);
    public static final Color SUCCESS     = new Color(0x15, 0x9B, 0x4A);
    public static final Color SUCCESS_LT  = new Color(0xE3, 0xF5, 0xEA);
    public static final Color DANGER      = new Color(0xFF, 0x00, 0x00); // teks hapus (Figma)
    public static final Color DANGER_SOFT = new Color(0xFF, 0xC4, 0xC4); // latar hapus (Figma)
    public static final Color DANGER_LT   = new Color(0xFD, 0xEA, 0xEA);
    public static final Color WARNING     = new Color(0xB4, 0x53, 0x09);
    public static final Color WARNING_LT  = new Color(0xFE, 0xF3, 0xC7);
    public static final Color AMBER       = new Color(0xF5, 0x9E, 0x0B);

    // ===== Font Lato (dibundel di resources/fonts) =====
    private static final String FALLBACK = "Tahoma";
    private static String fontFamily = FALLBACK;
    private static boolean latoSiap = false;

    private Theme() {
    }

    public static Font font(int style, float size) {
        return new Font(fontFamily, style, Math.round(size));
    }

    public static Font h1()   { return font(Font.BOLD, 26f); }
    public static Font h2()   { return font(Font.BOLD, 20f); }
    public static Font h3()   { return font(Font.BOLD, 15f); }
    public static Font body() { return font(Font.PLAIN, 13f); }
    public static Font small(){ return font(Font.PLAIN, 12f); }

    /**
     * Memuat font Lato dari resources lalu memasangnya secara global.
     * Dipanggil sekali dari Main sebelum jendela pertama dibuka.
     */
    public static void installGlobalFonts() {
        muatLato();
        UIManager.put("Label.font", body());
        UIManager.put("Button.font", body());
        UIManager.put("TextField.font", body());
        UIManager.put("PasswordField.font", body());
        UIManager.put("ComboBox.font", body());
        UIManager.put("Table.font", body());
        UIManager.put("Table.header.font", h3());
        UIManager.put("OptionPane.messageFont", body());
        UIManager.put("OptionPane.buttonFont", body());
        if (latoSiap) {
            System.out.println("[Theme] Font Lato aktif.");
        } else {
            System.out.println("[Theme] Lato tidak tersedia, memakai " + fontFamily + ".");
        }
    }

    /** Mendaftarkan Lato (Regular/Bold/Light/Black) ke sistem Swing. */
    private static void muatLato() {
        String[] berkas = {"Lato-Regular.ttf", "Lato-Bold.ttf", "Lato-Light.ttf", "Lato-Black.ttf"};
        try {
            java.awt.GraphicsEnvironment ge = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment();
            boolean semua = true;
            for (String nama : berkas) {
                try (InputStream in = Theme.class.getResourceAsStream("/fonts/" + nama)) {
                    if (in == null) {
                        semua = false;
                        break;
                    }
                    ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, in));
                }
            }
            if (semua && fontTersedia("Lato")) {
                fontFamily = "Lato";
                latoSiap = true;
            }
        } catch (Exception ex) {
            System.err.println("[Theme] Gagal memuat Lato: " + ex.getMessage());
        }
        if (!latoSiap) {
            fontFamily = fontTersedia("Segoe UI") ? "Segoe UI" : FALLBACK;
        }
    }

    private static boolean fontTersedia(String family) {
        for (String f : java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames()) {
            if (f.equals(family)) {
                return true;
            }
        }
        return false;
    }
}
