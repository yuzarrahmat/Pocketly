package com.pocketly.component;

import com.pocketly.util.Theme;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.beans.Beans;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.swing.JPanel;

public class ChartPanel extends JPanel {

    private static final String[] NAMA_BULAN = {"Jan", "Feb", "Mar", "Apr", "Mei", "Jun",
        "Jul", "Agu", "Sep", "Okt", "Nov", "Des"};

    private Map<LocalDate, Double> data = new HashMap<>();
    private Map<Integer, Double> dataBulanan = new HashMap<>();
    private boolean modeBulanan = false;
    private int tahun = LocalDate.now().getYear();
    private int bulan = LocalDate.now().getMonthValue();
    private final NumberFormat nf = NumberFormat.getIntegerInstance(new Locale("id", "ID"));

    public ChartPanel() {
        setOpaque(false);
        if (Beans.isDesignTime()) {
            tahun = LocalDate.now().getYear();
            bulan = LocalDate.now().getMonthValue();
            for (int i = 1; i <= 12; i += 2) {
                data.put(LocalDate.of(tahun, bulan, i), 60_000d + i * 25_000d);
            }
        }
    }

    public void setData(int tahun, int bulan, Map<LocalDate, Double> data) {
        modeBulanan = false;
        this.data = data == null ? new HashMap<>() : data;
        this.tahun = tahun;
        this.bulan = bulan;
        repaint();
    }

    /** Mengisi grafik pendapatan bulanan (12 batang: Jan-Des). */
    public void setDataBulanan(int tahun, Map<Integer, Double> data) {
        modeBulanan = true;
        this.dataBulanan = data == null ? new HashMap<>() : data;
        this.tahun = tahun;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int w = getWidth();
        int h = getHeight();
        int padKiri = 64;
        int padBawah = 26;
        int padAtas = 14;
        g2.setColor(Theme.CARD);
        g2.fillRoundRect(0, 0, w - 1, h - 1, 16, 16);

        double maks = 1;
        if (modeBulanan) {
            for (double v : dataBulanan.values()) {
                maks = Math.max(maks, v);
            }
        } else {
            for (double v : data.values()) {
                maks = Math.max(maks, v);
            }
        }
        long skala = (long) Math.ceil(maks / 50_000.0) * 50_000;
        if (skala <= 0) {
            skala = 50_000;
        }

        double areaH = h - padAtas - padBawah;
        double areaW = w - padKiri - 14;

        g2.setFont(Theme.font(Font.PLAIN, 10f));
        FontMetrics fm = g2.getFontMetrics();
        for (int i = 0; i <= 4; i++) {
            int y = (int) (padAtas + areaH * i / 4.0);
            g2.setColor(new Color(0xE8, 0xEE, 0xF5));
            g2.drawLine(padKiri, y, w - 18, y);
            String label = singkat(skala * (4 - i) / 4.0);
            g2.setColor(Theme.TEXT_MUTED);
            g2.drawString(label, padKiri - 10 - fm.stringWidth(label), y + 4);
        }

        LocalDate hariIni = LocalDate.now();
        if (modeBulanan) {
            double lebarBatang = Math.max(10, Math.min(46, areaW / 12.0 - 18));
            for (int b = 1; b <= 12; b++) {
                double v = dataBulanan.getOrDefault(b, 0.0);
                double x = padKiri + (b - 1) * (areaW / 12.0) + (areaW / 12.0 - lebarBatang) / 2.0;
                double tinggi = v <= 0 ? 0 : Math.max(3, v / skala * areaH);
                int y = (int) (padAtas + areaH - tinggi);
                if (v > 0) {
                    g2.setColor(Theme.NAVY);
                    g2.fillRoundRect((int) x, y, (int) lebarBatang, (int) tinggi, 6, 6);
                    String nilai = singkat(v);
                    g2.setColor(Theme.TEXT_MUTED);
                    g2.drawString(nilai, (int) (x + (lebarBatang - fm.stringWidth(nilai)) / 2.0), y - 4);
                    if (hariIni.getYear() == tahun && hariIni.getMonthValue() == b) {
                        g2.setColor(Theme.BLUE);
                        g2.drawRoundRect((int) x - 1, y - 1, (int) lebarBatang + 2, (int) tinggi + 2, 7, 7);
                    }
                }
                String lbl = NAMA_BULAN[b - 1];
                g2.setColor(Theme.TEXT_MUTED);
                g2.drawString(lbl,
                        (int) (padKiri + (b - 1) * (areaW / 12.0) + (areaW / 12.0 - fm.stringWidth(lbl)) / 2.0),
                        h - 8);
            }
        } else {
            LocalDate acuan = LocalDate.of(tahun, bulan, 1);
            int hari = acuan.lengthOfMonth();
            double lebarBatang = Math.max(4, areaW / hari - 4);
            for (int tgl = 1; tgl <= hari; tgl++) {
                LocalDate tglL = LocalDate.of(tahun, bulan, tgl);
                double v = data.getOrDefault(tglL, 0.0);
                double x = padKiri + (tgl - 1) * (areaW / hari) + (areaW / hari - lebarBatang) / 2.0;
                double tinggi = v <= 0 ? 0 : Math.max(3, v / skala * areaH);
                int y = (int) (padAtas + areaH - tinggi);
                if (v > 0) {
                    g2.setColor(Theme.NAVY);
                    g2.fillRoundRect((int) x, y, (int) lebarBatang, (int) tinggi, 6, 6);
                    if (tgl == hariIni.getDayOfMonth() && hariIni.getMonthValue() == bulan) {
                        g2.setColor(Theme.BLUE);
                        g2.drawRoundRect((int) x - 1, y - 1, (int) lebarBatang + 2, (int) tinggi + 2, 7, 7);
                    }
                }
                if (tgl == 1 || tgl % 5 == 0) {
                    String lbl = String.valueOf(tgl);
                    g2.setColor(Theme.TEXT_MUTED);
                    g2.drawString(lbl,
                            (int) (padKiri + (tgl - 1) * (areaW / hari) + (areaW / hari - fm.stringWidth(lbl)) / 2.0),
                            h - 8);
                }
            }
        }
        g2.dispose();
    }

    private String singkat(double v) {
        if (v >= 1_000_000) {
            return String.format("%.1fjt", v / 1_000_000).replace(".0jt", "jt");
        }
        if (v >= 1_000) {
            return Math.round(v / 1000.0) + "rb";
        }
        return String.valueOf(Math.round(v));
    }
}
