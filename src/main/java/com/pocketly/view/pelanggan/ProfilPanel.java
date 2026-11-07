package com.pocketly.view.pelanggan;

import com.pocketly.controller.ProfilController;
import com.pocketly.model.Pelanggan;
import com.pocketly.util.Theme;
import com.pocketly.util.UIs;


public class ProfilPanel extends javax.swing.JPanel {
    private final String username;
    private final PelangganNav nav;
    private final ProfilController ctl = new ProfilController();

    public ProfilPanel(String username, PelangganNav nav) {
        this.username = username;
        this.nav = nav;
        initComponents();
    }


    public ProfilPanel() {
        this(null, null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        lblJudul = new javax.swing.JLabel();
        tengah = new javax.swing.JPanel();
        kartu = new com.pocketly.component.RoundPanel();
        lingkaran = new javax.swing.JPanel();
        lblAvatar = new com.pocketly.component.AvatarLabel();
        strut1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 8), new java.awt.Dimension(0, 8), new java.awt.Dimension(32767, 8));
        lblNama = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        strut2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 12), new java.awt.Dimension(0, 12), new java.awt.Dimension(32767, 12));
        stat = new com.pocketly.component.RoundPanel();
        lblAngka = new javax.swing.JLabel();
        lblKet = new javax.swing.JLabel();
        strut3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 12), new java.awt.Dimension(0, 12), new java.awt.Dimension(32767, 12));
        Nama = new javax.swing.JPanel();
        lblKunciNama = new javax.swing.JLabel();
        lblNilaiNama = new javax.swing.JLabel();
        strut4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 8), new java.awt.Dimension(0, 8), new java.awt.Dimension(32767, 8));
        Username = new javax.swing.JPanel();
        lblKunciUsername = new javax.swing.JLabel();
        lblNilaiUsername = new javax.swing.JLabel();
        strut5 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 8), new java.awt.Dimension(0, 8), new java.awt.Dimension(32767, 8));
        Hp = new javax.swing.JPanel();
        lblKunciHp = new javax.swing.JLabel();
        lblNilaiHp = new javax.swing.JLabel();
        strut6 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 8), new java.awt.Dimension(0, 8), new java.awt.Dimension(32767, 8));
        Email = new javax.swing.JPanel();
        lblKunciEmail = new javax.swing.JLabel();
        lblNilaiEmail = new javax.swing.JLabel();
        strut7 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 8), new java.awt.Dimension(0, 8), new java.awt.Dimension(32767, 8));
        Alamat = new javax.swing.JPanel();
        lblKunciAlamat = new javax.swing.JLabel();
        lblNilaiAlamat = new javax.swing.JLabel();
        strut8 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 8), new java.awt.Dimension(0, 8), new java.awt.Dimension(32767, 8));
        Sejak = new javax.swing.JPanel();
        lblKunciSejak = new javax.swing.JLabel();
        lblNilaiSejak = new javax.swing.JLabel();
        strut9 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 14), new java.awt.Dimension(0, 14), new java.awt.Dimension(32767, 14));
        btnLogout = new com.pocketly.component.RoundButton();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(22, 26, 22, 26));
        setOpaque(false);
        setLayout(new java.awt.BorderLayout());

        lblJudul.setFont(Theme.font(java.awt.Font.BOLD, 20));
        lblJudul.setForeground(Theme.TEXT);
        lblJudul.setText("Profil");
        lblJudul.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 10, 0));
        add(lblJudul);

        tengah.setOpaque(false);
        tengah.setLayout(new java.awt.GridBagLayout());

        kartu.setBackground(Theme.CARD);
        kartu.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 28, 20, 28));
        kartu.setMaximumSize(new java.awt.Dimension(420, 32767));

        lingkaran.setOpaque(false);
        lingkaran.setPreferredSize(new java.awt.Dimension(64, 64));
        lingkaran.setLayout(new java.awt.FlowLayout(1, 0, 0));

        lblAvatar.setFont(Theme.font(java.awt.Font.BOLD, 26));
        lblAvatar.setPreferredSize(new java.awt.Dimension(64, 64));
        lblAvatar.setMaximumSize(new java.awt.Dimension(64, 64));
        lingkaran.add(lblAvatar);

        lblNama.setFont(Theme.font(java.awt.Font.BOLD, 17));
        lblNama.setForeground(Theme.NAVY);
        lblNama.setText("(Nama Pengguna)");

        lblUser.setFont(Theme.font(java.awt.Font.PLAIN, 12));
        lblUser.setForeground(Theme.TEXT_MUTED);
        lblUser.setText("(Username)");

        stat.setBackground(Theme.CARD);
        stat.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 16, 10, 16));
        stat.setRadius(16);
        stat.setLayout(new javax.swing.BoxLayout(stat, javax.swing.BoxLayout.PAGE_AXIS));

        lblAngka.setFont(Theme.font(java.awt.Font.BOLD, 21));
        lblAngka.setForeground(Theme.BLUE);
        lblAngka.setText("0");
        stat.add(lblAngka);

        lblKet.setFont(Theme.font(java.awt.Font.PLAIN, 12));
        lblKet.setForeground(Theme.TEXT_MUTED);
        lblKet.setText("Total transaksi online");
        stat.add(lblKet);

        Nama.setMaximumSize(new java.awt.Dimension(420, 24));
        Nama.setOpaque(false);
        Nama.setLayout(new java.awt.BorderLayout());

        lblKunciNama.setText("Nama");
        lblKunciNama.setFont(Theme.font(java.awt.Font.PLAIN, 13));
        lblKunciNama.setForeground(Theme.TEXT_MUTED);
        Nama.add(lblKunciNama);

        lblNilaiNama.setText("-");
        lblNilaiNama.setFont(Theme.font(java.awt.Font.BOLD, 13));
        lblNilaiNama.setForeground(Theme.TEXT);
        Nama.add(lblNilaiNama);

        Username.setMaximumSize(new java.awt.Dimension(420, 24));
        Username.setOpaque(false);
        Username.setLayout(new java.awt.BorderLayout());

        lblKunciUsername.setText("Username");
        lblKunciUsername.setFont(Theme.font(java.awt.Font.PLAIN, 13));
        lblKunciUsername.setForeground(Theme.TEXT_MUTED);
        Username.add(lblKunciUsername);

        lblNilaiUsername.setText("-");
        lblNilaiUsername.setFont(Theme.font(java.awt.Font.BOLD, 13));
        lblNilaiUsername.setForeground(Theme.TEXT);
        Username.add(lblNilaiUsername);

        Hp.setMaximumSize(new java.awt.Dimension(420, 24));
        Hp.setOpaque(false);
        Hp.setLayout(new java.awt.BorderLayout());

        lblKunciHp.setText("No. HP");
        lblKunciHp.setFont(Theme.font(java.awt.Font.PLAIN, 13));
        lblKunciHp.setForeground(Theme.TEXT_MUTED);
        Hp.add(lblKunciHp);

        lblNilaiHp.setFont(Theme.font(java.awt.Font.BOLD, 13));
        lblNilaiHp.setForeground(Theme.TEXT);
        lblNilaiHp.setText("-");
        Hp.add(lblNilaiHp);

        Email.setMaximumSize(new java.awt.Dimension(420, 24));
        Email.setOpaque(false);
        Email.setLayout(new java.awt.BorderLayout());

        lblKunciEmail.setText("Email");
        lblKunciEmail.setFont(Theme.font(java.awt.Font.PLAIN, 13));
        lblKunciEmail.setForeground(Theme.TEXT_MUTED);
        Email.add(lblKunciEmail);

        lblNilaiEmail.setFont(Theme.font(java.awt.Font.BOLD, 13));
        lblNilaiEmail.setForeground(Theme.TEXT);
        lblNilaiEmail.setText("(Email Pengguna)");
        Email.add(lblNilaiEmail);

        Alamat.setMaximumSize(new java.awt.Dimension(420, 24));
        Alamat.setOpaque(false);
        Alamat.setLayout(new java.awt.BorderLayout());

        lblKunciAlamat.setText("Alamat");
        lblKunciAlamat.setFont(Theme.font(java.awt.Font.PLAIN, 13));
        lblKunciAlamat.setForeground(Theme.TEXT_MUTED);
        Alamat.add(lblKunciAlamat);

        lblNilaiAlamat.setFont(Theme.font(java.awt.Font.BOLD, 13));
        lblNilaiAlamat.setForeground(Theme.TEXT);
        lblNilaiAlamat.setText("(Alamat Pengguna)");
        Alamat.add(lblNilaiAlamat);

        Sejak.setMaximumSize(new java.awt.Dimension(420, 24));
        Sejak.setOpaque(false);
        Sejak.setLayout(new java.awt.BorderLayout());

        lblKunciSejak.setText("Terdaftar sejak");
        lblKunciSejak.setFont(Theme.font(java.awt.Font.PLAIN, 13));
        lblKunciSejak.setForeground(Theme.TEXT_MUTED);
        Sejak.add(lblKunciSejak);

        lblNilaiSejak.setFont(Theme.font(java.awt.Font.BOLD, 13));
        lblNilaiSejak.setForeground(Theme.TEXT);
        lblNilaiSejak.setText("(Tanggal)");
        Sejak.add(lblNilaiSejak);

        btnLogout.setText("Logout");
        btnLogout.setMaximumSize(new java.awt.Dimension(32767, 40));
        btnLogout.setStyleName("dangerSoft");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kartuLayout = new javax.swing.GroupLayout(kartu);
        kartu.setLayout(kartuLayout);
        kartuLayout.setHorizontalGroup(
            kartuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kartuLayout.createSequentialGroup()
                .addGroup(kartuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lingkaran, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(strut1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(strut2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(strut3, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Nama, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(strut4, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Username, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(strut5, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Hp, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(strut6, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(strut7, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Alamat, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(strut8, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Sejak, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(strut9, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(kartuLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(kartuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(stat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNama, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        kartuLayout.setVerticalGroup(
            kartuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kartuLayout.createSequentialGroup()
                .addComponent(lingkaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(strut1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblNama)
                .addGap(0, 0, 0)
                .addComponent(lblUser)
                .addGap(0, 0, 0)
                .addComponent(strut2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(stat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(strut3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(strut4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(strut5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Hp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(strut6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(strut7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Alamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(strut8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Sejak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(strut9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        tengah.add(kartu, gridBagConstraints);

        add(tengah, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {
        nav.logout();
    }


    public void muatUlang() {
        Pelanggan p = ctl.profil(username);
        int totalTrx = ctl.totalTransaksi(username);

        String namaTampil = p != null && p.nama != null && !p.nama.isBlank() ? p.nama : username;
        lblAvatar.setText(namaTampil.substring(0, 1).toUpperCase());
        lblNama.setText(namaTampil);
        lblUser.setText("@" + username);
        lblAngka.setText(String.valueOf(totalTrx));

        lblNilaiNama.setText(namaTampil);
        lblNilaiUsername.setText(username);
        lblNilaiHp.setText(p == null || p.noTelp == null || p.noTelp.isBlank() ? "-" : p.noTelp);
        lblNilaiEmail.setText(p == null || p.email == null || p.email.isBlank() ? "-" : p.email);
        lblNilaiAlamat.setText(p == null || p.alamat == null ? "-" : p.alamat);
        lblNilaiSejak.setText(p == null || p.tglRegistrasi == null ? "-" : UIs.dateInd(p.tglRegistrasi));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Alamat;
    private javax.swing.JPanel Email;
    private javax.swing.JPanel Hp;
    private javax.swing.JPanel Nama;
    private javax.swing.JPanel Sejak;
    private javax.swing.JPanel Username;
    private com.pocketly.component.RoundButton btnLogout;
    private com.pocketly.component.RoundPanel kartu;
    private javax.swing.JLabel lblAngka;
    private com.pocketly.component.AvatarLabel lblAvatar;
    private javax.swing.JLabel lblJudul;
    private javax.swing.JLabel lblKet;
    private javax.swing.JLabel lblKunciAlamat;
    private javax.swing.JLabel lblKunciEmail;
    private javax.swing.JLabel lblKunciHp;
    private javax.swing.JLabel lblKunciNama;
    private javax.swing.JLabel lblKunciSejak;
    private javax.swing.JLabel lblKunciUsername;
    private javax.swing.JLabel lblNama;
    private javax.swing.JLabel lblNilaiAlamat;
    private javax.swing.JLabel lblNilaiEmail;
    private javax.swing.JLabel lblNilaiHp;
    private javax.swing.JLabel lblNilaiNama;
    private javax.swing.JLabel lblNilaiSejak;
    private javax.swing.JLabel lblNilaiUsername;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPanel lingkaran;
    private com.pocketly.component.RoundPanel stat;
    private javax.swing.Box.Filler strut1;
    private javax.swing.Box.Filler strut2;
    private javax.swing.Box.Filler strut3;
    private javax.swing.Box.Filler strut4;
    private javax.swing.Box.Filler strut5;
    private javax.swing.Box.Filler strut6;
    private javax.swing.Box.Filler strut7;
    private javax.swing.Box.Filler strut8;
    private javax.swing.Box.Filler strut9;
    private javax.swing.JPanel tengah;
    // End of variables declaration//GEN-END:variables
}
