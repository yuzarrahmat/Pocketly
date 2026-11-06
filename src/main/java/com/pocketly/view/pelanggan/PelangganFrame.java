package com.pocketly.view.pelanggan;

import com.pocketly.component.NavPill;
import com.pocketly.controller.KeranjangController;
import com.pocketly.dao.PelangganDAO;
import com.pocketly.model.Pelanggan;
import com.pocketly.util.Theme;
import com.pocketly.util.UIs;
import com.pocketly.view.LoginFrame;
import java.awt.CardLayout;

/**
 * Kerangka halaman pelanggan: sidebar putih gaya Figma + area konten
 * membulat dengan CardLayout. Form NetBeans GUI Builder - buka
 * PelangganFrame.form di tab Design untuk melihat dan mengedit tata letak.
 */
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

        // panel halaman dibuat dengan data pengguna lalu dipasang ke
        // area konten (CardLayout) yang dideklarasikan di file .form
        berandaPanel = new BerandaPanel(username, this);
        keranjangPanel = new KeranjangPanel(username, this);
        transaksiPanel = new TransaksiPanel(username, this);
        profilPanel = new ProfilPanel(username, this);

        initComponents();
        konten.add(berandaPanel, "beranda");
        konten.add(keranjangPanel, "keranjang");
        konten.add(transaksiPanel, "transaksi");
        konten.add(profilPanel, "profil");
        cards = (CardLayout) konten.getLayout();

        // aksi navigasi pada sidebar (Figma: Rectangle 55)
        pills = new NavPill[]{pillBeranda, pillKeranjang, pillTransaksi, pillProfil};
        pillBeranda.setAksi(() -> tampilkan(0));
        pillKeranjang.setAksi(() -> tampilkan(1));
        pillTransaksi.setAksi(() -> tampilkan(2));
        pillProfil.setAksi(() -> tampilkan(3));

        avatar.setText(username == null ? "?" : username.substring(0, 1).toUpperCase());
        lblBadge.setVisible(false); // badge hanya tampil bila keranjang terisi
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
        lblSeksi = new javax.swing.JLabel();
        pillBeranda = new com.pocketly.component.NavPill();
        strut2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 8), new java.awt.Dimension(0, 8), new java.awt.Dimension(32767, 8));
        barisKeranjang = new javax.swing.JPanel();
        pillKeranjang = new com.pocketly.component.NavPill();
        lblBadge = new com.pocketly.component.BadgeLabel();
        strut3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 8), new java.awt.Dimension(0, 8), new java.awt.Dimension(32767, 8));
        pillTransaksi = new com.pocketly.component.NavPill();
        strut4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 8), new java.awt.Dimension(0, 8), new java.awt.Dimension(32767, 8));
        pillProfil = new com.pocketly.component.NavPill();
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
        getContentPane().setLayout(new java.awt.BorderLayout(0, 0));
        bgPanel.setBackground(Theme.PAGE_BG);
        bgPanel.setLayout(new java.awt.BorderLayout(0, 0));
        sidebar.setPreferredSize(new java.awt.Dimension(236, 0));
        sidebar.setBorder(javax.swing.BorderFactory.createEmptyBorder(24, 20, 18, 12));
        sidebar.setLayout(new javax.swing.BoxLayout(sidebar, javax.swing.BoxLayout.Y_AXIS));
        logo.setIcon(UIs.asset("logo-pocketly.png", 140, 46));
        logo.setAlignmentX(0.0F);
        strut1.setMaximumSize(new java.awt.Dimension(32767, 26));
        strut1.setMinimumSize(new java.awt.Dimension(0, 26));
        strut1.setPreferredSize(new java.awt.Dimension(0, 26));
        lblSeksi.setText("Utama");
        lblSeksi.setFont(Theme.font(java.awt.Font.PLAIN, 13));
        lblSeksi.setForeground(Theme.TEXT);
        lblSeksi.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 12, 6, 0));
        pillBeranda.setText("Beranda");
        pillBeranda.setIconFile("icon-beranda.png");
        strut2.setMaximumSize(new java.awt.Dimension(32767, 8));
        strut2.setMinimumSize(new java.awt.Dimension(0, 8));
        strut2.setPreferredSize(new java.awt.Dimension(0, 8));
        barisKeranjang.setOpaque(false);
        barisKeranjang.setMaximumSize(new java.awt.Dimension(32767, 48));
        barisKeranjang.setLayout(new java.awt.BorderLayout(10, 0));
        pillKeranjang.setText("Keranjang");
        pillKeranjang.setIconFile("icon-keranjang.png");
        lblBadge.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 8));
        barisKeranjang.add(pillKeranjang, java.awt.BorderLayout.CENTER);
        barisKeranjang.add(lblBadge, java.awt.BorderLayout.EAST);
        strut3.setMaximumSize(new java.awt.Dimension(32767, 8));
        strut3.setMinimumSize(new java.awt.Dimension(0, 8));
        strut3.setPreferredSize(new java.awt.Dimension(0, 8));
        pillTransaksi.setText("Transaksi");
        pillTransaksi.setIconFile("icon-transaksi.png");
        strut4.setMaximumSize(new java.awt.Dimension(32767, 8));
        strut4.setMinimumSize(new java.awt.Dimension(0, 8));
        strut4.setPreferredSize(new java.awt.Dimension(0, 8));
        pillProfil.setText("Profil");
        pillProfil.setIconFile("icon-profil.png");
        glue1.setMaximumSize(new java.awt.Dimension(32767, 32767));
        kartuUser.setBackground(Theme.CARD);
        kartuUser.setRadius(25);
        kartuUser.setPreferredSize(new java.awt.Dimension(204, 60));
        kartuUser.setBorder(javax.swing.BorderFactory.createEmptyBorder(9, 10, 9, 10));
        kartuUser.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
        kartuUser.setLayout(new java.awt.BorderLayout(12, 0));
        kartuUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kartuUserMouseClicked(evt);
            }
        });
        avatarWrap.setOpaque(false);
        avatarWrap.setPreferredSize(new java.awt.Dimension(42, 42));
        avatarWrap.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));
        avatar.setFont(Theme.font(java.awt.Font.BOLD, 15));
        avatar.setPreferredSize(new java.awt.Dimension(40, 40));
        avatar.setMaximumSize(new java.awt.Dimension(40, 40));
        avatarWrap.add(avatar);
        identitas.setOpaque(false);
        identitas.setLayout(new javax.swing.BoxLayout(identitas, javax.swing.BoxLayout.Y_AXIS));
        lblNamaUser.setText(" ");
        lblNamaUser.setFont(Theme.font(java.awt.Font.PLAIN, 12));
        lblNamaUser.setForeground(Theme.TEXT);
        lblEmailUser.setText(" ");
        lblEmailUser.setFont(Theme.font(java.awt.Font.PLAIN, 10));
        lblEmailUser.setForeground(Theme.TEXT_MUTED);
        identitas.add(lblNamaUser);
        identitas.add(lblEmailUser);
        kartuUser.add(avatarWrap, java.awt.BorderLayout.WEST);
        kartuUser.add(identitas, java.awt.BorderLayout.CENTER);
        strut5.setMaximumSize(new java.awt.Dimension(32767, 8));
        strut5.setMinimumSize(new java.awt.Dimension(0, 8));
        strut5.setPreferredSize(new java.awt.Dimension(0, 8));
        lblKeluar.setText("Keluar");
        lblKeluar.setFont(Theme.font(java.awt.Font.PLAIN, 12));
        lblKeluar.setForeground(Theme.TEXT_MUTED);
        lblKeluar.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 12, 0, 0));
        lblKeluar.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
        lblKeluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblKeluarMouseClicked(evt);
            }
        });
        sidebar.add(logo);
        sidebar.add(strut1);
        sidebar.add(lblSeksi);
        sidebar.add(pillBeranda);
        sidebar.add(strut2);
        sidebar.add(barisKeranjang);
        sidebar.add(strut3);
        sidebar.add(pillTransaksi);
        sidebar.add(strut4);
        sidebar.add(pillProfil);
        sidebar.add(glue1);
        sidebar.add(kartuUser);
        sidebar.add(strut5);
        sidebar.add(lblKeluar);
        kontenBungkus.setOpaque(false);
        kontenBungkus.setBorder(javax.swing.BorderFactory.createEmptyBorder(14, 0, 14, 14));
        kontenBungkus.setLayout(new java.awt.BorderLayout(0, 0));
        konten.setBackground(Theme.CONTENT_BG);
        konten.setRadius(25);
        konten.setLayout(new java.awt.CardLayout());
        kontenBungkus.add(konten, java.awt.BorderLayout.CENTER);
        bgPanel.add(sidebar, java.awt.BorderLayout.WEST);
        bgPanel.add(kontenBungkus, java.awt.BorderLayout.CENTER);
        getContentPane().add(bgPanel, java.awt.BorderLayout.CENTER);
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kartuUserMouseClicked(java.awt.event.MouseEvent evt) {
        tampilkan(3); // buka halaman Profil
    }

    private void lblKeluarMouseClicked(java.awt.event.MouseEvent evt) {
        logout(); // flowchart: logout -> Halaman Login
    }

    /** Mengisi nama dan email pengguna pada kartu di sidebar. */
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

    /** Memuat ulang isi halaman; gangguan koneksi database ditampilkan
     *  sebagai dialog, bukan menghentikan aplikasi. */
    private void reloadSafe(Runnable reload) {
        try {
            reload.run();
        } catch (RuntimeException | ExceptionInInitializerError | NoClassDefFoundError ex) {
            UIs.error(this, String.valueOf(ex.getMessage()));
        }
    }

    // ================= API navigasi untuk panel =================

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
        new LoginFrame().setVisible(true); // Halaman Login
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bgPanel;
    private javax.swing.JPanel sidebar;
    private javax.swing.JLabel logo;
    private javax.swing.Box.Filler strut1;
    private javax.swing.JLabel lblSeksi;
    private com.pocketly.component.NavPill pillBeranda;
    private javax.swing.Box.Filler strut2;
    private javax.swing.JPanel barisKeranjang;
    private com.pocketly.component.NavPill pillKeranjang;
    private com.pocketly.component.BadgeLabel lblBadge;
    private javax.swing.Box.Filler strut3;
    private com.pocketly.component.NavPill pillTransaksi;
    private javax.swing.Box.Filler strut4;
    private com.pocketly.component.NavPill pillProfil;
    private javax.swing.Box.Filler glue1;
    private com.pocketly.component.RoundPanel kartuUser;
    private javax.swing.JPanel avatarWrap;
    private com.pocketly.component.AvatarLabel avatar;
    private javax.swing.JPanel identitas;
    private javax.swing.JLabel lblNamaUser;
    private javax.swing.JLabel lblEmailUser;
    private javax.swing.Box.Filler strut5;
    private javax.swing.JLabel lblKeluar;
    private javax.swing.JPanel kontenBungkus;
    private com.pocketly.component.RoundPanel konten;
    // End of variables declaration//GEN-END:variables
}
