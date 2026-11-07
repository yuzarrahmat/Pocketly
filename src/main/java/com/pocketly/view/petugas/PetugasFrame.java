package com.pocketly.view.petugas;

import com.pocketly.component.NavPill;
import com.pocketly.dao.PetugasDAO;
import com.pocketly.model.Petugas;
import com.pocketly.util.Theme;
import com.pocketly.util.UIs;
import com.pocketly.view.LoginFrame;
import java.awt.CardLayout;

public class PetugasFrame extends javax.swing.JFrame implements PetugasNav {
    private final String username;
    private final PetugasDAO petugasDao = new PetugasDAO();

    private CardLayout cards;
    private final BerandaPetugasPanel berandaPanel;
    private final KelolaProdukPanel kelolaPanel;
    private final VerifikasiPanel verifikasiPanel;
    private final StatusPanel statusPanel;
    private final KasirPanel kasirPanel;
    private NavPill[] pills;
    private int aktif = 0;

    public PetugasFrame(String username) {
        this.username = username;
        berandaPanel = new BerandaPetugasPanel(username, this);
        kelolaPanel = new KelolaProdukPanel(username, this);
        verifikasiPanel = new VerifikasiPanel(username, this);
        statusPanel = new StatusPanel(username, this);
        kasirPanel = new KasirPanel(username, this);

        initComponents();
        lblKeluar.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
        konten.add(berandaPanel, "beranda");
        konten.add(kelolaPanel, "produk");
        konten.add(verifikasiPanel, "verifikasi");
        konten.add(statusPanel, "status");
        konten.add(kasirPanel, "kasir");
        cards = (CardLayout) konten.getLayout();

        pills = new NavPill[]{pillBeranda, pillKelola, pillVerifikasi, pillStatus, pillKasir};
        pillBeranda.setAksi(() -> tampilkan(0));
        pillKelola.setAksi(() -> tampilkan(1));
        pillVerifikasi.setAksi(() -> tampilkan(2));
        pillStatus.setAksi(() -> tampilkan(3));
        pillKasir.setAksi(() -> tampilkan(4));

        avatar.setText(username == null ? "?" : username.substring(0, 1).toUpperCase());
        lblUser.setText(username == null ? "-" : username);
        isiJabatan();
        if (username != null) {
            tampilkan(0);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgPanel = new javax.swing.JPanel();
        sidebar = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        strut1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 26), new java.awt.Dimension(0, 26), new java.awt.Dimension(32767, 26));
        lblSeksi = new javax.swing.JLabel();
        pillBeranda = new com.pocketly.component.NavPill();
        strut2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 8), new java.awt.Dimension(0, 8), new java.awt.Dimension(32767, 8));
        pillKelola = new com.pocketly.component.NavPill();
        strut3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 8), new java.awt.Dimension(0, 8), new java.awt.Dimension(32767, 8));
        pillVerifikasi = new com.pocketly.component.NavPill();
        strut4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 8), new java.awt.Dimension(0, 8), new java.awt.Dimension(32767, 8));
        pillStatus = new com.pocketly.component.NavPill();
        pillKasir = new com.pocketly.component.NavPill();
        strut5 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 8), new java.awt.Dimension(0, 8), new java.awt.Dimension(32767, 8));
        glue1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        kartuUser = new com.pocketly.component.RoundPanel();
        avatarWrap = new javax.swing.JPanel();
        avatar = new com.pocketly.component.AvatarLabel();
        identitas = new javax.swing.JPanel();
        lblJabatan = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        strut6 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 8), new java.awt.Dimension(0, 8), new java.awt.Dimension(32767, 8));
        lblKeluar = new javax.swing.JLabel();
        kontenBungkus = new javax.swing.JPanel();
        konten = new com.pocketly.component.RoundPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pocketly - Petugas");
        setMinimumSize(new java.awt.Dimension(1180, 720));
        getContentPane().setLayout(new java.awt.BorderLayout());

        bgPanel.setBackground(Theme.PAGE_BG);
        bgPanel.setLayout(new java.awt.BorderLayout());

        sidebar.setBackground(Theme.BLUE_LIGHT);
        sidebar.setBorder(javax.swing.BorderFactory.createEmptyBorder(24, 20, 18, 12));
        sidebar.setPreferredSize(new java.awt.Dimension(236, 0));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ui/logo-pocketly.png"))); // NOI18N

        lblSeksi.setFont(Theme.font(java.awt.Font.PLAIN, 13));
        lblSeksi.setForeground(Theme.TEXT);
        lblSeksi.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 12, 6, 0));

        pillBeranda.setIconFile("icon-beranda.png");
        pillBeranda.setText("Beranda");

        pillKelola.setIconFile("icon-produk.png");
        pillKelola.setText("Kelola Produk");

        pillVerifikasi.setIconFile("icon-pendapatan.png");
        pillVerifikasi.setText("Verifikasi Bayar");

        pillStatus.setIconFile("icon-transaksi.png");
        pillStatus.setText("Ubah Status");

        pillKasir.setIconFile("icon-kasir.png");
        pillKasir.setText("Kasir Offline");

        kartuUser.setBackground(Theme.CARD);
        kartuUser.setBorder(javax.swing.BorderFactory.createEmptyBorder(9, 10, 9, 10));
        kartuUser.setPreferredSize(new java.awt.Dimension(204, 60));

        avatarWrap.setOpaque(false);
        avatarWrap.setPreferredSize(new java.awt.Dimension(42, 42));
        avatarWrap.setLayout(new java.awt.FlowLayout(1, 0, 0));

        avatar.setFont(Theme.font(java.awt.Font.BOLD, 15));
        avatar.setPreferredSize(new java.awt.Dimension(40, 40));
        avatar.setMaximumSize(new java.awt.Dimension(40, 40));
        avatarWrap.add(avatar);

        identitas.setOpaque(false);
        identitas.setLayout(new javax.swing.BoxLayout(identitas, javax.swing.BoxLayout.PAGE_AXIS));

        lblJabatan.setFont(Theme.font(java.awt.Font.PLAIN, 13));
        lblJabatan.setForeground(Theme.TEXT);
        lblJabatan.setText("Petugas");
        identitas.add(lblJabatan);

        lblUser.setText(" ");
        lblUser.setFont(Theme.font(java.awt.Font.PLAIN, 10));
        lblUser.setForeground(Theme.TEXT_MUTED);
        identitas.add(lblUser);

        javax.swing.GroupLayout kartuUserLayout = new javax.swing.GroupLayout(kartuUser);
        kartuUser.setLayout(kartuUserLayout);
        kartuUserLayout.setHorizontalGroup(
            kartuUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kartuUserLayout.createSequentialGroup()
                .addComponent(avatarWrap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(identitas, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        kartuUserLayout.setVerticalGroup(
            kartuUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(avatarWrap, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(identitas, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        lblKeluar.setFont(Theme.font(java.awt.Font.PLAIN, 12));
        lblKeluar.setForeground(Theme.TEXT_MUTED);
        lblKeluar.setText("Keluar");
        lblKeluar.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 12, 0, 0));
        lblKeluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblKeluarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout sidebarLayout = new javax.swing.GroupLayout(sidebar);
        sidebar.setLayout(sidebarLayout);
        sidebarLayout.setHorizontalGroup(
            sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidebarLayout.createSequentialGroup()
                .addComponent(pillBeranda, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(strut2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(pillKelola, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(sidebarLayout.createSequentialGroup()
                .addComponent(pillStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(strut3, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(sidebarLayout.createSequentialGroup()
                .addGap(199, 199, 199)
                .addComponent(strut4, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(sidebarLayout.createSequentialGroup()
                .addComponent(pillKasir, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(strut5, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(sidebarLayout.createSequentialGroup()
                .addGap(193, 193, 193)
                .addComponent(glue1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(kartuUser, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(sidebarLayout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(lblKeluar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(strut6, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(sidebarLayout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(lblSeksi))
            .addComponent(strut1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pillVerifikasi, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        sidebarLayout.setVerticalGroup(
            sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidebarLayout.createSequentialGroup()
                .addComponent(logo)
                .addGap(0, 0, 0)
                .addComponent(strut1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblSeksi)
                .addGap(48, 48, 48)
                .addGroup(sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(strut2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pillBeranda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sidebarLayout.createSequentialGroup()
                        .addComponent(strut3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(strut4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pillStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pillVerifikasi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sidebarLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(strut5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(glue1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(kartuUser, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(sidebarLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pillKasir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pillKelola, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addGroup(sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(strut6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblKeluar))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        bgPanel.add(sidebar, java.awt.BorderLayout.WEST);

        kontenBungkus.setBorder(javax.swing.BorderFactory.createEmptyBorder(14, 0, 14, 14));
        kontenBungkus.setMaximumSize(new java.awt.Dimension(1920, 1080));
        kontenBungkus.setMinimumSize(new java.awt.Dimension(1920, 1080));
        kontenBungkus.setOpaque(false);
        kontenBungkus.setPreferredSize(new java.awt.Dimension(1920, 1080));
        kontenBungkus.setLayout(new java.awt.BorderLayout());

        konten.setBackground(Theme.CONTENT_BG);
        konten.setLayout(new java.awt.CardLayout());
        kontenBungkus.add(konten, java.awt.BorderLayout.CENTER);

        bgPanel.add(kontenBungkus, java.awt.BorderLayout.CENTER);

        getContentPane().add(bgPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblKeluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKeluarMouseClicked
        dispose();
        new LoginFrame().setVisible(true);
    }//GEN-LAST:event_lblKeluarMouseClicked

    
    private void isiJabatan() {
        try {
            Petugas p = username == null ? null : petugasDao.getByUsername(username);
            lblJabatan.setText(p == null ? "Petugas" : p.jabatan);
        } catch (RuntimeException ex) {
            lblJabatan.setText("Petugas");
        }
    }

    private void tampilkan(int idx) {
        if (username == null) {
            return;
        }
        aktif = idx;
        cards.show(berandaPanel.getParent(),
                new String[]{"beranda", "produk", "verifikasi", "status", "kasir"}[idx]);
        for (int i = 0; i < pills.length; i++) {
            pills[i].setDipilih(i == idx);
        }
        switch (idx) {
            case 0 -> reloadSafe(berandaPanel::muatUlang);
            case 1 -> reloadSafe(kelolaPanel::muatUlang);
            case 2 -> reloadSafe(verifikasiPanel::muatUlang);
            case 3 -> reloadSafe(statusPanel::muatUlang);
            case 4 -> reloadSafe(kasirPanel::muatUlang);
        }
    }

    private void reloadSafe(Runnable reload) {
        try {
            reload.run();
        } catch (RuntimeException | ExceptionInInitializerError | NoClassDefFoundError ex) {
            UIs.error(this, String.valueOf(ex.getMessage()));
        }
    }


    @Override
    public void keBeranda() {
        tampilkan(0);
    }

    @Override
    public void keKelolaProduk() {
        tampilkan(1);
    }

    @Override
    public void keVerifikasi() {
        tampilkan(2);
    }

    @Override
    public void keStatus() {
        tampilkan(3);
    }

    @Override
    public void keKasir() {
        tampilkan(4);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.pocketly.component.AvatarLabel avatar;
    private javax.swing.JPanel avatarWrap;
    private javax.swing.JPanel bgPanel;
    private javax.swing.Box.Filler glue1;
    private javax.swing.JPanel identitas;
    private com.pocketly.component.RoundPanel kartuUser;
    private com.pocketly.component.RoundPanel konten;
    private javax.swing.JPanel kontenBungkus;
    private javax.swing.JLabel lblJabatan;
    private javax.swing.JLabel lblKeluar;
    private javax.swing.JLabel lblSeksi;
    private javax.swing.JLabel lblUser;
    private javax.swing.JLabel logo;
    private com.pocketly.component.NavPill pillBeranda;
    private com.pocketly.component.NavPill pillKasir;
    private com.pocketly.component.NavPill pillKelola;
    private com.pocketly.component.NavPill pillStatus;
    private com.pocketly.component.NavPill pillVerifikasi;
    private javax.swing.JPanel sidebar;
    private javax.swing.Box.Filler strut1;
    private javax.swing.Box.Filler strut2;
    private javax.swing.Box.Filler strut3;
    private javax.swing.Box.Filler strut4;
    private javax.swing.Box.Filler strut5;
    private javax.swing.Box.Filler strut6;
    // End of variables declaration//GEN-END:variables
}
