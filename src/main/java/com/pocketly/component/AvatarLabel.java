package com.pocketly.component;

import com.pocketly.util.Theme;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class AvatarLabel extends JLabel {

    public AvatarLabel() {
        super("?", SwingConstants.CENTER);
        setOpaque(false);
        setBackground(Theme.NAVY);
        setForeground(Color.WHITE);
        setFont(Theme.font(Font.BOLD, 15));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillOval(0, 0, getWidth() - 1, getHeight() - 1);
        g2.dispose();
        super.paintComponent(g);
    }
}
