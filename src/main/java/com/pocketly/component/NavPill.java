package com.pocketly.component;

import com.pocketly.util.Theme;
import com.pocketly.util.UIs;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Pil navigasi putih di sidebar sesuai desain Figma (Rectangle 55 + ikon).
 * JavaBean untuk NetBeans GUI Builder dengan properti:
 * "text" (nama menu), "iconFile" (nama file ikon di img/ui), dan
 * "dipilih" (status sedang aktif). Aksi klik dipasang dari kode
 * lewat setAksi(...).
 */
public class NavPill extends JPanel {

    private final JLabel lblIkon = new JLabel();
    private final JLabel label = new JLabel();
    private boolean dipilih;
    private Runnable aksi;

    public NavPill() {
        setLayout(new BorderLayout(10, 0));
        setOpaque(false);
        setPreferredSize(new Dimension(204, 48));
        setMaximumSize(new Dimension(204, 48));
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        lblIkon.setBorder(BorderFactory.createEmptyBorder(0, 12, 0, 0));
        add(lblIkon, BorderLayout.WEST);

        label.setFont(Theme.font(Font.PLAIN, 14));
        label.setForeground(Theme.TEXT);
        add(label, BorderLayout.CENTER);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (aksi != null) {
                    aksi.run();
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (!dipilih) {
                    label.setForeground(Theme.BLUE);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (!dipilih) {
                    label.setForeground(Theme.TEXT);
                }
            }
        });
    }

    public String getText() {
        return label.getText();
    }

    public void setText(String teks) {
        label.setText(teks == null ? "" : teks);
    }

    public String getIconFile() {
        return (String) lblIkon.getClientProperty("fileIkon");
    }

    public void setIconFile(String namaFile) {
        lblIkon.putClientProperty("fileIkon", namaFile);
        if (namaFile != null && !namaFile.isBlank()) {
            java.net.URL url = getClass().getResource("/img/ui/" + namaFile);
            if (url == null) {
                lblIkon.setIcon(UIs.asset(namaFile, 24, 24)); // placeholder
                return;
            }
            javax.swing.ImageIcon ikon = new javax.swing.ImageIcon(url);
            // ikon tampil pada ukuran asli filenya (sedekakan file ikon 24x24).
            // Pengaman saja: bila file yang ditempel jauh lebih besar dari
            // slot pil (32px), diperkecil agar sidebar tidak rusak.
            if (ikon.getIconWidth() > 32 || ikon.getIconHeight() > 32) {
                lblIkon.setIcon(UIs.asset(namaFile, 24, 24));
            } else {
                lblIkon.setIcon(ikon);
            }
        }
    }

    public boolean isDipilih() {
        return dipilih;
    }

    public void setDipilih(boolean dipilih) {
        this.dipilih = dipilih;
        label.setForeground(dipilih ? Theme.BLUE : Theme.TEXT);
        label.setFont(dipilih ? Theme.font(Font.BOLD, 14) : Theme.font(Font.PLAIN, 14));
        repaint();
    }

    /** Memasang aksi yang dijalankan saat pil diklik. */
    public void setAksi(Runnable aksi) {
        this.aksi = aksi;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (dipilih) {
            g2.setColor(Theme.PAGE_BG);
            g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 25, 25);
            g2.setColor(Color.WHITE);
            g2.fillRoundRect(2, 2, getWidth() - 5, getHeight() - 5, 23, 23);
        } else {
            g2.setColor(Color.WHITE);
            g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 25, 25);
        }
        g2.dispose();
    }
}
