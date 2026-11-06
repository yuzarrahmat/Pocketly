package com.pocketly.util;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.function.IntConsumer;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

/**
 * Kumpulan komponen UI Pocketly sesuai desain Figma: tombol pill,
 * kartu bersudut membulat, kolom input abu lembut, dan utilitas gambar.
 */
public final class UIs {

    public static final String IMG_DIR = "/img/produk";
    public static final String KATEGORI_DIR = "/img/kategori";
    public static final String UI_DIR = "/img/ui";
    public static final String BUKTI_DIR = "bukti";

    private UIs() {
    }

    // ================= Format =================

    /** Format uang gaya Indonesia: 17500 -> "Rp 17.500". */
    public static String money(double v) {
        NumberFormat nf = NumberFormat.getIntegerInstance(new Locale("id", "ID"));
        return "Rp " + nf.format(v);
    }

    public static String dateInd(LocalDate d) {
        if (d == null) {
            return "-";
        }
        return d.format(DateTimeFormatter.ofPattern("dd MMM yyyy", new Locale("id", "ID")));
    }

    // ================= Panel & label =================

    /** Panel putih dengan sudut membulat untuk kartu konten. */
    public static JPanel card(int radius) {
        JPanel p = new RoundedPanel(radius, Theme.CARD);
        p.setOpaque(false);
        return p;
    }

    public static JLabel title(String text) {
        JLabel l = new JLabel(text);
        l.setFont(Theme.h1());
        l.setForeground(Theme.TEXT);
        return l;
    }

    public static JLabel subtitle(String text) {
        JLabel l = new JLabel(text);
        l.setFont(Theme.body());
        l.setForeground(Theme.TEXT_MUTED);
        return l;
    }

    public static JLabel fieldLabel(String text) {
        JLabel l = new JLabel(text);
        l.setFont(Theme.h3());
        l.setForeground(Theme.TEXT_DARK);
        return l;
    }

    // ================= Tombol modern (gaya Figma) =================

    public enum Btn {
        PRIMARY(Theme.NAVY, Color.WHITE),
        ACTION(Theme.BLUE, Color.WHITE),
        SUCCESS(Theme.SUCCESS, Color.WHITE),
        DANGER(Theme.DANGER, Color.WHITE),
        DANGER_SOFT(Theme.DANGER_SOFT, Theme.DANGER),
        SECONDARY(Theme.BLUE_LIGHT, Theme.NAVY),
        GHOST(Color.WHITE, Theme.TEXT_DARK),
        NAVY(Theme.NAVY, Color.WHITE);

        final Color bg, fg;

        Btn(Color bg, Color fg) {
            this.bg = bg;
            this.fg = fg;
        }
    }

    public static JButton button(String text, Btn style) {
        return new ModernButton(text, style);
    }

    /** Tombol pill gaya Figma: sudut penuh membulat, warna flat, hover halus. */
    public static class ModernButton extends JButton {

        private final Btn style;
        private boolean hover;

        public ModernButton(String text, Btn style) {
            super(text);
            this.style = style;
            setFont(Theme.font(Font.BOLD, 13f));
            setForeground(style.fg);
            setContentAreaFilled(false);
            setBorderPainted(false);
            setFocusPainted(false);
            setOpaque(false);
            setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            setBorder(BorderFactory.createEmptyBorder(9, 16, 9, 16));
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    hover = true;
                    repaint();
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    hover = false;
                    repaint();
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            Color bg = style.bg;
            if (hover) {
                bg = darken(bg);
            }
            if (!isEnabled()) {
                bg = new Color(0xCB, 0xD5, 0xE1);
            }
            // pill: busur setinggi tombol (menyerupai radius 25,5 di Figma)
            g2.setColor(bg);
            int arc = Math.min(getHeight() - 1, 28);
            g2.fill(new RoundRectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1, arc, arc));
            if (style == Btn.GHOST || style == Btn.SECONDARY) {
                g2.setColor(Theme.BORDER);
                g2.setStroke(new BasicStroke(1f));
                g2.draw(new RoundRectangle2D.Double(0.5, 0.5, getWidth() - 1.5, getHeight() - 1.5, arc, arc));
            }
            g2.dispose();
            super.paintComponent(g);
        }

        private static Color darken(Color c) {
            return new Color(Math.max(0, c.getRed() - 24), Math.max(0, c.getGreen() - 24), Math.max(0, c.getBlue() - 24));
        }
    }

    /** Panel dengan sudut membulat. */
    public static class RoundedPanel extends JPanel {

        private final int radius;
        private final Color fill;

        public RoundedPanel(int radius, Color fill) {
            this.radius = radius;
            this.fill = fill;
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(fill);
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
            g2.dispose();
        }
    }

    /** TextField gaya Figma: latar #F1EEEE, sudut membulat. */
    public static JTextField textField() {
        JTextField tf = new JTextField() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getBackground());
                g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 14, 14);
                g2.dispose();
                super.paintComponent(g);
            }
        };
        styleField(tf, 10);
        return tf;
    }

    public static JPasswordField passwordField() {
        JPasswordField pf = new JPasswordField() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getBackground());
                g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 14, 14);
                g2.dispose();
                super.paintComponent(g);
            }
        };
        styleField(pf, 10);
        return pf;
    }

    private static void styleField(JTextField tf, int pad) {
        tf.setBackground(Theme.FIELD_BG);
        tf.setForeground(Theme.TEXT_DARK);
        tf.setFont(Theme.body());
        tf.setOpaque(false);
        tf.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(1, 4, 1, 4),
                BorderFactory.createEmptyBorder(pad, 12, pad, 12)));
        tf.setCaretColor(Theme.TEXT_DARK);
    }

    /** Versi ramping untuk kolom jumlah berukuran kecil. */
    public static void jadikanFieldKompak(JTextField tf) {
        tf.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(1, 2, 1, 2),
                BorderFactory.createEmptyBorder(6, 8, 6, 8)));
    }

    // ================= Gambar produk, kategori, dan aset UI =================

    /**
     * Mengambil gambar produk dari img/produk lalu menyesuaikan ukuran.
     * Bila produk belum punya gambar, tampil placeholder khusus.
     */
    public static ImageIcon productImage(String gambar, int w, int h) {
        // Gambar produk diupload admin saat runtime (lihat ProdukAdminController),
        // jadi harus tetap dibaca dari disk, bukan dari classpath.
        if (gambar != null && !gambar.isBlank()) {
            File f = new File("img/produk", gambar);
            if (f.exists()) {
                try {
                    return scaled(f.toURI().toURL(), w, h, Theme.CARD);
                } catch (java.net.MalformedURLException ex) {
                    return placeholder(w, h, "gambar tidak dapat dibaca");
                }
            }
        }
        return placeholder(w, h, "produk ini belum ada gambar");
    }

    /** Gambar ilustrasi kategori dari img/kategori (dimuat dari classpath). */
    public static ImageIcon kategoriImage(String namaFile, int w, int h) {
        if (namaFile != null && !namaFile.isBlank()) {
            java.net.URL url = UIs.class.getResource(KATEGORI_DIR + "/" + namaFile);
            if (url != null) {
                return scaled(url, w, h, Theme.CARD);
            }
        }
        return placeholder(w, h, "kategori");
    }

    /** Ikon/aset dekoratif dari img/ui (logo, hero, ikon navigasi), dimuat dari classpath. */
    public static ImageIcon asset(String namaFile, int w, int h) {
        java.net.URL url = UIs.class.getResource(UI_DIR + "/" + namaFile);
        if (url != null) {
            return scaled(url, w, h, null);
        }
        return placeholder(w, h, namaFile);
    }

    /** Gambar bukti pembayaran; placeholder bila file tidak ditemukan. */
    public static ImageIcon buktiImage(String path, int w, int h) {
        if (path != null && !path.isBlank()) {
            File f = new File(path);
            if (!f.exists()) {
                f = new File(path.replaceFirst("^bukti/", BUKTI_DIR + "/"));
            }
            if (f.exists()) {
                try {
                    return scaled(f.toURI().toURL(), w, h, Color.WHITE);
                } catch (java.net.MalformedURLException ex) {
                    return placeholder(w, h, "gambar tidak dapat dibaca");
                }
            }
        }
        return placeholder(w, h, "bukti pembayaran tidak ditemukan");
    }

    private static ImageIcon scaled(java.net.URL url, int w, int h, Color bg) {
        ImageIcon icon = new ImageIcon(url);
        if (icon.getIconWidth() <= 0) {
            return placeholder(w, h, "gambar tidak dapat dibaca");
        }
        BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = img.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        // muat ke dalam kotak (rasio tetap), lalu tengah; latar putih bila diberikan
        double scale = Math.min((double) w / icon.getIconWidth(), (double) h / icon.getIconHeight());
        int dw = (int) (icon.getIconWidth() * scale);
        int dh = (int) (icon.getIconHeight() * scale);
        int x = (w - dw) / 2, y = (h - dh) / 2;
        if (bg != null) {
            g.setColor(bg);
            g.fillRoundRect(0, 0, w - 1, h - 1, 14, 14);
        }
        g.drawImage(icon.getImage(), x, y, dw, dh, bg, null);
        g.dispose();
        return new ImageIcon(img);
    }

    /** Membuat gambar placeholder abu-biru dengan teks di tengah. */
    public static ImageIcon placeholder(int w, int h, String text) {
        BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = img.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(new Color(0xEE, 0xF2, 0xF7));
        g.fillRoundRect(0, 0, w - 1, h - 1, 12, 12);
        g.setColor(new Color(0xD3, 0xDC, 0xE8));
        g.drawRoundRect(0, 0, w - 1, h - 1, 12, 12);

        int cx = w / 2, cy = h / 2 - 16;
        int iw = Math.min(w / 3, 46), ih = iw * 2 / 3;
        g.setColor(new Color(0xB9, 0xC5, 0xD6));
        g.fillRoundRect(cx - iw / 2, cy - ih / 2, iw, ih, 8, 8);
        g.setColor(new Color(0xEE, 0xF2, 0xF7));
        g.fillOval(cx - iw / 2 + 6, cy - ih / 2 + 5, 7, 7);
        Polygon poly = new Polygon();
        poly.addPoint(cx - iw / 2 + 2, cy + ih / 2 - 3);
        poly.addPoint(cx - iw / 8, cy - ih / 12);
        poly.addPoint(cx + iw / 8, cy + ih / 4);
        poly.addPoint(cx + iw / 4, cy);
        poly.addPoint(cx + iw / 2 - 3, cy + ih / 2 - 3);
        g.setColor(new Color(0xC7, 0xD2, 0xE0));
        g.fillPolygon(poly);

        if (w >= 110 && h >= 70) {
            g.setColor(Theme.TEXT_MUTED);
            g.setFont(Theme.small());
            drawStringCentered(g, text, cx, cy + ih / 2 + 16, w - 16);
        }
        g.dispose();
        return new ImageIcon(img);
    }

    private static void drawStringCentered(Graphics2D g, String text, int cx, int y, int maxWidth) {
        FontMetrics fm = g.getFontMetrics();
        StringBuilder line = new StringBuilder();
        int yy = y;
        for (String word : text.split("\\s+")) {
            String test = line.isEmpty() ? word : line + " " + word;
            if (fm.stringWidth(test) > maxWidth && !line.isEmpty()) {
                g.drawString(line.toString(), cx - fm.stringWidth(line.toString()) / 2, yy);
                line = new StringBuilder(word);
                yy += fm.getHeight();
            } else {
                line = new StringBuilder(test);
            }
        }
        if (!line.isEmpty()) {
            g.drawString(line.toString(), cx - fm.stringWidth(line.toString()) / 2, yy);
        }
    }

    // ================= Dialog & notifikasi =================

    public static void info(Component parent, String msg) {
        JOptionPane.showMessageDialog(parent, msg, "Pocketly", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void error(Component parent, String msg) {
        JOptionPane.showMessageDialog(parent, msg, "Terjadi Kesalahan", JOptionPane.ERROR_MESSAGE);
    }

    public static boolean confirm(Component parent, String msg) {
        return JOptionPane.showConfirmDialog(parent, msg, "Konfirmasi",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION;
    }

    /** Latar halaman standar Pocketly. */
    public static JComponent pageBg() {
        JPanel p = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Theme.PAGE_BG);
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        p.setOpaque(false);
        return p;
    }

    /** Label badge status (Berhasil / Menunggu / Dibatalkan / ...). */
    public static JLabel statusBadge(String status) {
        Color bg, fg;
        switch (status == null ? "" : status) {
            case "Berhasil", "Selesai", "Aktif" -> { bg = Theme.SUCCESS_LT; fg = Theme.SUCCESS; }
            case "Nonaktif" -> { bg = new Color(0xEF, 0xF1, 0xF4); fg = Theme.TEXT_MUTED; }
            case "Menunggu verifikasi", "Dikemas", "Dikirim", "Siap diambil" -> { bg = Theme.WARNING_LT; fg = Theme.WARNING; }
            case "Dibatalkan" -> { bg = Theme.DANGER_LT; fg = new Color(0xB9, 0x1C, 0x1C); }
            default -> { bg = Theme.BLUE_LIGHT; fg = Theme.NAVY; }
        }
        JLabel l = new JLabel(status == null ? "-" : status, SwingConstants.CENTER) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(bg);
                g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 10, 10);
                g2.dispose();
                super.paintComponent(g);
            }
        };
        l.setFont(Theme.small());
        l.setForeground(fg);
        l.setOpaque(false);
        l.setBorder(BorderFactory.createEmptyBorder(3, 10, 3, 10));
        return l;
    }

    /** Gaya tabel standar Pocketly (header, baris, grid). */
    public static void styleTable(javax.swing.JTable t) {
        t.setRowHeight(30);
        t.setFont(Theme.body());
        t.setForeground(Theme.TEXT);
        t.setBackground(Color.WHITE);
        t.getTableHeader().setFont(Theme.h3());
        t.getTableHeader().setBackground(new Color(0xED, 0xF1, 0xF7));
        t.getTableHeader().setForeground(Theme.TEXT_DARK);
        t.setGridColor(Theme.BORDER);
        t.setSelectionBackground(Theme.BLUE_LIGHT);
        t.setSelectionForeground(Theme.TEXT);
        t.setFillsViewportHeight(true);
    }

    // ================= Tombol di dalam sel tabel =================

    /**
     * Membuat sel pada satu kolom tabel berperilaku seperti tombol.
     * Klik pada sel kolom tersebut memanggil aksi dengan nomor baris
     * model (bukan baris tampilan).
     */
    public static void pasangAksiKolom(JTable tabel, int kolom, String teksTombol, Btn gaya, IntConsumer aksi) {
        // renderer: hanya menampilkan gambar tombol
        tabel.getColumnModel().getColumn(kolom).setCellRenderer((t, value, isSelected, hasFocus, row, column) -> {
            JPanel p = new JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0)) {
                @Override
                protected void paintComponent(Graphics g) {
                    g.setColor(isSelected ? Theme.BLUE_LIGHT : Color.WHITE);
                    g.fillRect(0, 0, getWidth(), getHeight());
                }
            };
            p.setOpaque(false);
            JButton b = button(teksTombol, gaya);
            b.setPreferredSize(new Dimension(Math.max(104, b.getPreferredSize().width), 28));
            p.add(b);
            return p;
        });
        // listener: meneruskan klik asli pada sel ke aksi
        tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int kolomKlik = tabel.columnAtPoint(e.getPoint());
                if (kolomKlik != kolom) {
                    return;
                }
                int barisTampil = tabel.rowAtPoint(e.getPoint());
                if (barisTampil >= 0) {
                    aksi.accept(tabel.convertRowIndexToModel(barisTampil));
                }
            }
        });
        // kursor tangan saat melayang di atas kolom tombol
        tabel.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                int kolomKlik = tabel.columnAtPoint(e.getPoint());
                tabel.setCursor(kolomKlik == kolom && tabel.rowAtPoint(e.getPoint()) >= 0
                        ? Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)
                        : Cursor.getDefaultCursor());
            }
        });
    }

    /** Memotong teks dengan elipsis (...) bila melebihi jumlah karakter. */
    public static String potong(String teks, int maks) {
        if (teks == null) {
            return "-";
        }
        return teks.length() <= maks ? teks : teks.substring(0, maks - 1) + "\u2026";
    }

    /** Menjalankan runnable di EDT. */
    public static void edt(Runnable r) {
        if (SwingUtilities.isEventDispatchThread()) {
            r.run();
        } else {
            SwingUtilities.invokeLater(r);
        }
    }
}
