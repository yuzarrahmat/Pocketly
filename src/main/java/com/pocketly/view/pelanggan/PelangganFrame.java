package com.pocketly.view.pelanggan;

import com.pocketly.component.NavPill;
import com.pocketly.controller.KeranjangController;
import com.pocketly.dao.PelangganDAO;
import com.pocketly.model.Pelanggan;
import com.pocketly.util.Theme;
import com.pocketly.util.UIs;
import com.pocketly.view.LoginFrame;
import java.awt.CardLayout;

public class PelangganFrame extends javax.swing.JFrame implements PelangganNav {
    private final String username;
    private final KeranjangController keranjangCtl = new KeranjangController();
    private final PelangganDAO pelangganDao = new PelangganDAO();

    private CardLayout cards;
    private final BerandaPanel berandaPanel;
    private final KeranjangPanel keranjangPanel;
    private final TransaksiPanel transaksiPanel;
    private final ProfilPanel profilPanel;
    private NavPill[] pills;
    private int aktif = 0;

    public PelangganFrame(String username) {
        this.username = username;
        berandaPanel = new BerandaPanel(username, this);
        keranjangPanel = new KeranjangPanel(username, this);
        transaksiPanel = new TransaksiPanel(username, this);
        profilPanel = new ProfilPanel(username, this);

        initComponents();
        kartuUser.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
        lblKeluar.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
        konten.add(berandaPanel, "beranda");
        konten.add(keranjangPanel, "keranjang");
        konten.add(transaksiPanel, "transaksi");
        konten.add(profilPanel, "profil");
        cards = (CardLayout) konten.getLayout();


        pills = new NavPill[]{pillBeranda, pillKeranjang, pillTransaksi, };
        pillBeranda.setAksi(() -> tampilkan(0));
        pillKeranjang.setAksi(() -> tampilkan(1));
        pillTransaksi.setAksi(() -> tampilkan(2));

        avatar.setText(username == null ? "?" : username.substring(0, 1).toUpperCase());
        lblBadge.setVisible(false);
        isiDataPengguna();
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
        strut2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 8), new java.awt.Dimension(0, 8), new java.awt.Dimension(32767, 8));
        barisKeranjang = new javax.swing.JPanel();
        pillKeranjang = new com.pocketly.component.NavPill();
        lblBadge = new com.pocketly.component.BadgeLabel();
        pillBeranda = new com.pocketly.component.NavPill();
        strut3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 8), new java.awt.Dimension(0, 8), new java.awt.Dimension(32767, 8));
        pillTransaksi = new com.pocketly.component.NavPill();
        strut4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 8), new java.awt.Dimension(0, 8), new java.awt.Dimension(32767, 8));
        glue1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        kartuUser = new com.pocketly.component.RoundPanel();
        avatarWrap = new javax.swing.JPanel();
        avatar = new com.pocketly.component.AvatarLabel();
        identitas = new javax.swing.JPanel();
        lblNamaUser = new javax.swing.JLabel();
        lblEmailUser = new javax.swing.JLabel();
        strut5 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 8), new java.awt.Dimension(0, 8), new java.awt.Dimension(32767, 8));
        lblKeluar = new javax.swing.JLabel();
        kontenBungkus = new javax.swing.JPanel();
        konten = new com.pocketly.component.RoundPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pocketly - Pelanggan");
        setMinimumSize(new java.awt.Dimension(1140, 700));
        getContentPane().setLayout(new java.awt.BorderLayout());

        bgPanel.setBackground(Theme.PAGE_BG);
        bgPanel.setLayout(new java.awt.BorderLayout());

        sidebar.setBackground(Theme.BLUE_LIGHT);
        sidebar.setBorder(javax.swing.BorderFactory.createEmptyBorder(24, 20, 18, 12));
        sidebar.setPreferredSize(new java.awt.Dimension(236, 0));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ui/logo-pocketly.png"))); // NOI18N

        barisKeranjang.setMaximumSize(new java.awt.Dimension(32767, 48));
        barisKeranjang.setOpaque(false);

        pillKeranjang.setIconFile("icon-keranjang.png");
        pillKeranjang.setText("Keranjang");

        lblBadge.setBackground(new java.awt.Color(102, 204, 255));
        lblBadge.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 8));
        lblBadge.setForeground(new java.awt.Color(0, 0, 0));
        lblBadge.setText("");

        pillBeranda.setIconFile("icon-beranda.png");
        pillBeranda.setText("Beranda");

        javax.swing.GroupLayout barisKeranjangLayout = new javax.swing.GroupLayout(barisKeranjang);
        barisKeranjang.setLayout(barisKeranjangLayout);
        barisKeranjangLayout.setHorizontalGroup(
            barisKeranjangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barisKeranjangLayout.createSequentialGroup()
                .addGroup(barisKeranjangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pillKeranjang, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pillBeranda, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBadge, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(136, Short.MAX_VALUE))
        );
        barisKeranjangLayout.setVerticalGroup(
            barisKeranjangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barisKeranjangLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(pillBeranda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pillKeranjang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, barisKeranjangLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblBadge, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pillTransaksi.setIconFile("icon-transaksi.png");
        pillTransaksi.setText("Transaksi");

        kartuUser.setBackground(Theme.CARD);
        kartuUser.setBorder(javax.swing.BorderFactory.createEmptyBorder(9, 10, 9, 10));
        kartuUser.setPreferredSize(new java.awt.Dimension(204, 60));
        kartuUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kartuUserMouseClicked(evt);
            }
        });

        avatarWrap.setOpaque(false);
        avatarWrap.setPreferredSize(new java.awt.Dimension(42, 42));
        avatarWrap.setLayout(new java.awt.FlowLayout(1, 0, 0));

        avatar.setFont(Theme.font(java.awt.Font.BOLD, 15));
        avatar.setPreferredSize(new java.awt.Dimension(40, 40));
        avatar.setMaximumSize(new java.awt.Dimension(40, 40));
        avatarWrap.add(avatar);

        identitas.setOpaque(false);

        lblNamaUser.setFont(Theme.font(java.awt.Font.PLAIN, 12));
        lblNamaUser.setForeground(Theme.TEXT);
        lblNamaUser.setText(" ");

        lblEmailUser.setFont(Theme.font(java.awt.Font.PLAIN, 10));
        lblEmailUser.setForeground(Theme.TEXT_MUTED);
        lblEmailUser.setText(" ");

        javax.swing.GroupLayout identitasLayout = new javax.swing.GroupLayout(identitas);
        identitas.setLayout(identitasLayout);
        identitasLayout.setHorizontalGroup(
            identitasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblNamaUser)
            .addComponent(lblEmailUser)
        );
        identitasLayout.setVerticalGroup(
            identitasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(identitasLayout.createSequentialGroup()
                .addComponent(lblNamaUser)
                .addGap(0, 0, 0)
                .addComponent(lblEmailUser)
                .addContainerGap(293, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout kartuUserLayout = new javax.swing.GroupLayout(kartuUser);
        kartuUser.setLayout(kartuUserLayout);
        kartuUserLayout.setHorizontalGroup(
            kartuUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kartuUserLayout.createSequentialGroup()
                .addComponent(avatarWrap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(identitas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        kartuUserLayout.setVerticalGroup(
            kartuUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(avatarWrap, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(identitas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        lblKeluar.setFont(Theme.font(java.awt.Font.PLAIN, 12));
        lblKeluar.setForeground(Theme.TEXT_MUTED);
        lblKeluar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblKeluar.setVerticalAlignment(javax.swing.SwingConstants.TOP);
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
                .addComponent(pillTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(strut3, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(sidebarLayout.createSequentialGroup()
                .addGroup(sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(strut2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(barisKeranjang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(sidebarLayout.createSequentialGroup()
                        .addGroup(sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(kartuUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(strut4, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(glue1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(sidebarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(sidebarLayout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(strut1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(sidebarLayout.createSequentialGroup()
                                .addComponent(lblKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(strut5, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(logo))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        sidebarLayout.setVerticalGroup(
            sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidebarLayout.createSequentialGroup()
                .addComponent(logo)
                .addGap(0, 0, 0)
                .addComponent(strut1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(strut2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(barisKeranjang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(strut3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pillTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(strut4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sidebarLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(glue1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(sidebarLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kartuUser, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(strut5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblKeluar))
                .addContainerGap())
        );

        bgPanel.add(sidebar, java.awt.BorderLayout.WEST);

        kontenBungkus.setBackground(Theme.PAGE_BG);
        kontenBungkus.setBorder(javax.swing.BorderFactory.createEmptyBorder(14, 0, 14, 14));
        kontenBungkus.setOpaque(false);
        kontenBungkus.setLayout(new java.awt.BorderLayout());

        konten.setBackground(Theme.CONTENT_BG);
        konten.setMaximumSize(new java.awt.Dimension(1920, 1080));
        konten.setMinimumSize(new java.awt.Dimension(1920, 1080));
        konten.setLayout(new java.awt.CardLayout());
        kontenBungkus.add(konten, java.awt.BorderLayout.CENTER);

        bgPanel.add(kontenBungkus, java.awt.BorderLayout.CENTER);

        getContentPane().add(bgPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kartuUserMouseClicked(java.awt.event.MouseEvent evt) {
        tampilkan(3);
    }

    private void lblKeluarMouseClicked(java.awt.event.MouseEvent evt) {
        logout();
    }


    private void isiDataPengguna() {
        String nama = username;
        String email = "-";
        try {
            if (username != null) {
                Pelanggan p = pelangganDao.getByUsername(username);
                if (p != null) {
                    if (p.nama != null && !p.nama.isBlank()) {
                        nama = p.nama;
                    }
                    if (p.email != null && !p.email.isBlank()) {
                        email = p.email;
                    }
                }
            }
        } catch (RuntimeException ex) {
            System.err.println("[PelangganFrame] " + ex.getMessage());
        }
        lblNamaUser.setText(UIs.potong(nama, 19));
        lblEmailUser.setText(UIs.potong(email, 24));
    }

    private void tampilkan(int idx) {
        if (username == null) {
            return;
        }
        aktif = idx;
        cards.show(berandaPanel.getParent(), new String[]{"beranda", "keranjang", "transaksi", "profil"}[idx]);
        for (int i = 0; i < pills.length; i++) {
            pills[i].setDipilih(i == idx);
        }
        switch (idx) {
            case 0 -> reloadSafe(berandaPanel::muatUlang);
            case 1 -> reloadSafe(keranjangPanel::muatUlang);
            case 2 -> reloadSafe(transaksiPanel::muatUlang);
            case 3 -> reloadSafe(profilPanel::muatUlang);
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
    public void keKeranjang() {
        tampilkan(1);
    }

    @Override
    public void keTransaksi() {
        tampilkan(2);
    }

    @Override
    public void keProfil() {
        tampilkan(3);
    }

    @Override
    public void perbaruiBadgeKeranjang() {
        int n = keranjangCtl.isiKeranjang(username).size();
        lblBadge.setText(String.valueOf(n));
        lblBadge.setVisible(n > 0);
    }

    @Override
    public void logout() {
        dispose();
        new LoginFrame().setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.pocketly.component.AvatarLabel avatar;
    private javax.swing.JPanel avatarWrap;
    private javax.swing.JPanel barisKeranjang;
    private javax.swing.JPanel bgPanel;
    private javax.swing.Box.Filler glue1;
    private javax.swing.JPanel identitas;
    private com.pocketly.component.RoundPanel kartuUser;
    private com.pocketly.component.RoundPanel konten;
    private javax.swing.JPanel kontenBungkus;
    private com.pocketly.component.BadgeLabel lblBadge;
    private javax.swing.JLabel lblEmailUser;
    private javax.swing.JLabel lblKeluar;
    private javax.swing.JLabel lblNamaUser;
    private javax.swing.JLabel logo;
    private com.pocketly.component.NavPill pillBeranda;
    private com.pocketly.component.NavPill pillKeranjang;
    private com.pocketly.component.NavPill pillTransaksi;
    private javax.swing.JPanel sidebar;
    private javax.swing.Box.Filler strut1;
    private javax.swing.Box.Filler strut2;
    private javax.swing.Box.Filler strut3;
    private javax.swing.Box.Filler strut4;
    private javax.swing.Box.Filler strut5;
    // End of variables declaration//GEN-END:variables
}
