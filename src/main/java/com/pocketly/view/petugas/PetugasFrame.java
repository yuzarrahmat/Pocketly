package com.pocketly.view.petugas;

import com.pocketly.component.NavPill;
import com.pocketly.dao.PetugasDAO;
import com.pocketly.model.Petugas;
import com.pocketly.util.Theme;
import com.pocketly.util.UIs;
import com.pocketly.view.LoginFrame;
import java.awt.CardLayout;

/**
 * Kerangka halaman petugas: sidebar putih gaya Figma + area konten
 * membulat dengan CardLayout. Form NetBeans GUI Builder - buka
 * PetugasFrame.form di tab Design untuk melihat dan mengedit tata letak.
 */
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

        // panel halaman dibuat dengan data petugas lalu dipasang ke
        // area konten (CardLayout) yang dideklarasikan di file .form
        berandaPanel = new BerandaPetugasPanel(username, this);
        kelolaPanel = new KelolaProdukPanel(username, this);
        verifikasiPanel = new VerifikasiPanel(username, this);
        statusPanel = new StatusPanel(username, this);
        kasirPanel = new KasirPanel(username, this);

        initComponents();
        konten.add(berandaPanel, "beranda");
        konten.add(kelolaPanel, "produk");
        konten.add(verifikasiPanel, "verifikasi");
        konten.add(statusPanel, "status");
        konten.add(kasirPanel, "kasir");
        cards = (CardLayout) konten.getLayout();

        // aksi navigasi pada sidebar
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
        strut5 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 8), new java.awt.Dimension(0, 8), new java.awt.Dimension(32767, 8));
        pillKasir = new com.pocketly.component.NavPill();
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
        pillKelola.setText("Kelola Produk");
        pillKelola.setIconFile("icon-produk.png");
        strut3.setMaximumSize(new java.awt.Dimension(32767, 8));
        strut3.setMinimumSize(new java.awt.Dimension(0, 8));
        strut3.setPreferredSize(new java.awt.Dimension(0, 8));
        pillVerifikasi.setText("Verifikasi Bayar");
        pillVerifikasi.setIconFile("icon-pendapatan.png");
        strut4.setMaximumSize(new java.awt.Dimension(32767, 8));
        strut4.setMinimumSize(new java.awt.Dimension(0, 8));
        strut4.setPreferredSize(new java.awt.Dimension(0, 8));
        pillStatus.setText("Ubah Status");
        pillStatus.setIconFile("icon-transaksi.png");
        strut5.setMaximumSize(new java.awt.Dimension(32767, 8));
        strut5.setMinimumSize(new java.awt.Dimension(0, 8));
        strut5.setPreferredSize(new java.awt.Dimension(0, 8));
        pillKasir.setText("Kasir Offline");
        pillKasir.setIconFile("icon-pickup.png");
        glue1.setMaximumSize(new java.awt.Dimension(32767, 32767));
        kartuUser.setBackground(Theme.CARD);
        kartuUser.setRadius(25);
        kartuUser.setPreferredSize(new java.awt.Dimension(204, 60));
        kartuUser.setBorder(javax.swing.BorderFactory.createEmptyBorder(9, 10, 9, 10));
        kartuUser.setLayout(new java.awt.BorderLayout(12, 0));
        avatarWrap.setOpaque(false);
        avatarWrap.setPreferredSize(new java.awt.Dimension(42, 42));
        avatarWrap.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));
        avatar.setFont(Theme.font(java.awt.Font.BOLD, 15));
        avatar.setPreferredSize(new java.awt.Dimension(40, 40));
        avatar.setMaximumSize(new java.awt.Dimension(40, 40));
        avatarWrap.add(avatar);
        identitas.setOpaque(false);
        identitas.setLayout(new javax.swing.BoxLayout(identitas, javax.swing.BoxLayout.Y_AXIS));
        lblJabatan.setText("Petugas");
        lblJabatan.setFont(Theme.font(java.awt.Font.PLAIN, 13));
        lblJabatan.setForeground(Theme.TEXT);
        lblUser.setText(" ");
        lblUser.setFont(Theme.font(java.awt.Font.PLAIN, 10));
        lblUser.setForeground(Theme.TEXT_MUTED);
        identitas.add(lblJabatan);
        identitas.add(lblUser);
        kartuUser.add(avatarWrap, java.awt.BorderLayout.WEST);
        kartuUser.add(identitas, java.awt.BorderLayout.CENTER);
        strut6.setMaximumSize(new java.awt.Dimension(32767, 8));
        strut6.setMinimumSize(new java.awt.Dimension(0, 8));
        strut6.setPreferredSize(new java.awt.Dimension(0, 8));
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
        sidebar.add(pillKelola);
        sidebar.add(strut3);
        sidebar.add(pillVerifikasi);
        sidebar.add(strut4);
        sidebar.add(pillStatus);
        sidebar.add(strut5);
        sidebar.add(pillKasir);
        sidebar.add(glue1);
        sidebar.add(kartuUser);
        sidebar.add(strut6);
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

    private void lblKeluarMouseClicked(java.awt.event.MouseEvent evt) {
        dispose();
        new LoginFrame().setVisible(true); // flowchart: logout -> Halaman Login
    }

    /** Mengisi jabatan petugas pada kartu di sidebar. */
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
    private javax.swing.JPanel bgPanel;
    private javax.swing.JPanel sidebar;
    private javax.swing.JLabel logo;
    private javax.swing.Box.Filler strut1;
    private javax.swing.JLabel lblSeksi;
    private com.pocketly.component.NavPill pillBeranda;
    private javax.swing.Box.Filler strut2;
    private com.pocketly.component.NavPill pillKelola;
    private javax.swing.Box.Filler strut3;
    private com.pocketly.component.NavPill pillVerifikasi;
    private javax.swing.Box.Filler strut4;
    private com.pocketly.component.NavPill pillStatus;
    private javax.swing.Box.Filler strut5;
    private com.pocketly.component.NavPill pillKasir;
    private javax.swing.Box.Filler glue1;
    private com.pocketly.component.RoundPanel kartuUser;
    private javax.swing.JPanel avatarWrap;
    private com.pocketly.component.AvatarLabel avatar;
    private javax.swing.JPanel identitas;
    private javax.swing.JLabel lblJabatan;
    private javax.swing.JLabel lblUser;
    private javax.swing.Box.Filler strut6;
    private javax.swing.JLabel lblKeluar;
    private javax.swing.JPanel kontenBungkus;
    private com.pocketly.component.RoundPanel konten;
    // End of variables declaration//GEN-END:variables
}
