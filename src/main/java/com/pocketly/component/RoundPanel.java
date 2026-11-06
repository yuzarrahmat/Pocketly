package com.pocketly.component;

import com.pocketly.util.Theme;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

/**
 * Panel berwarna dengan sudut membulat untuk kartu konten sesuai Figma.
 * JavaBean untuk NetBeans GUI Builder - atur lewat Properties:
 * "background" (warna kartu) dan "radius" (kelengkungan sudut).
 */
public class RoundPanel extends JPanel {

    private int radius = 25;

    public RoundPanel() {
        setOpaque(false);
        setBackground(Theme.CARD);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = Math.max(0, radius);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
        g2.dispose();
        super.paintComponent(g);
    }
}
