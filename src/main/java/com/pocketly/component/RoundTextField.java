package com.pocketly.component;

import com.pocketly.util.Theme;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import javax.swing.BorderFactory;
import javax.swing.JTextField;


public class RoundTextField extends JTextField {

    private String placeholder = "";

    public RoundTextField() {
        setBackground(Theme.FIELD_BG);
        setForeground(Theme.TEXT_DARK);
        setFont(Theme.body());
        setOpaque(false);
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(1, 4, 1, 4),
                BorderFactory.createEmptyBorder(10, 12, 10, 12)));
        setCaretColor(Theme.TEXT_DARK);
    }

    public String getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder == null ? "" : placeholder;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 14, 14);
        g2.dispose();
        super.paintComponent(g);
        if (placeholder != null && !placeholder.isBlank()
                && getText().isBlank() && !isFocusOwner()) {
            Graphics2D gp = (Graphics2D) g.create();
            gp.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            gp.setColor(Theme.TEXT_MUTED);
            gp.setFont(getFont().deriveFont(Font.PLAIN));
            Insets i = getInsets();
            gp.drawString(placeholder, i.left, getHeight() - i.bottom - gp.getFontMetrics().getDescent());
            gp.dispose();
        }
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension d = super.getPreferredSize();
        return new Dimension(Math.max(d.width, 60), Math.max(d.height, 36));
    }
}
