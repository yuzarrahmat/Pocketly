package com.pocketly.component;

import com.pocketly.util.Theme;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import javax.swing.BorderFactory;
import javax.swing.JButton;

/**
 * Tombol pill (sudut penuh membulat) sesuai desain Figma Pocketly.
 *
 * JavaBean yang bisa dipakai langsung di NetBeans GUI Builder:
 * cukup ubah properti "text" dan "styleName" di Properties - Other.
 * Nilai styleName yang tersedia:
 * primary, action, success, danger, dangerSoft, secondary, ghost, navy.
 */
public class RoundButton extends JButton {

    public static final String PRIMARY = "primary";
    public static final String ACTION = "action";
    public static final String SUCCESS = "success";
    public static final String DANGER = "danger";
    public static final String DANGER_SOFT = "dangerSoft";
    public static final String SECONDARY = "secondary";
    public static final String GHOST = "ghost";
    public static final String NAVY = "navy";

    private String styleName = PRIMARY;
    private boolean hover;
    private boolean bergaris;

    public RoundButton() {
        this("");
    }

    public RoundButton(String text) {
        super(text);
        setFont(Theme.font(Font.BOLD, 13));
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
        setOpaque(false);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setBorder(BorderFactory.createEmptyBorder(9, 16, 9, 16));
        terapkanGaya(PRIMARY);
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

    public String getStyleName() {
        return styleName;
    }

    public void setStyleName(String nama) {
        this.styleName = nama == null ? PRIMARY : nama;
        terapkanGaya(this.styleName);
        repaint();
    }

    private void terapkanGaya(String nama) {
        Color bg, fg;
        bergaris = false;
        switch (nama == null ? "" : nama) {
            case ACTION -> { bg = Theme.BLUE; fg = Color.WHITE; }
            case SUCCESS -> { bg = Theme.SUCCESS; fg = Color.WHITE; }
            case DANGER -> { bg = Theme.DANGER; fg = Color.WHITE; }
            case DANGER_SOFT -> { bg = Theme.DANGER_SOFT; fg = Theme.DANGER; }
            case SECONDARY -> { bg = Theme.BLUE_LIGHT; fg = Theme.NAVY; bergaris = true; }
            case GHOST -> { bg = Color.WHITE; fg = Theme.TEXT_DARK; bergaris = true; }
            case NAVY -> { bg = Theme.NAVY; fg = Color.WHITE; }
            default -> { bg = Theme.NAVY; fg = Color.WHITE; }
        }
        setBackground(bg);
        setForeground(fg);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Color bg = getBackground();
        if (hover) {
            bg = new Color(Math.max(0, bg.getRed() - 24),
                    Math.max(0, bg.getGreen() - 24),
                    Math.max(0, bg.getBlue() - 24));
        }
        if (!isEnabled()) {
            bg = new Color(0xCB, 0xD5, 0xE1);
        }
        g2.setColor(bg);
        int arc = Math.min(getHeight() - 1, 28);
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1, arc, arc));
        if (bergaris) {
            g2.setColor(Theme.BORDER);
            g2.setStroke(new BasicStroke(1f));
            g2.draw(new RoundRectangle2D.Double(0.5, 0.5, getWidth() - 1.5, getHeight() - 1.5, arc, arc));
        }
        g2.dispose();
        super.paintComponent(g);
    }
}
