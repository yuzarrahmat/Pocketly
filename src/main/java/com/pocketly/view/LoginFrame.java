package com.pocketly.view;

import com.pocketly.controller.AuthController;
import com.pocketly.model.Pengguna;
import com.pocketly.util.Theme;
import com.pocketly.util.UIs;
import com.pocketly.view.pelanggan.PelangganFrame;
import com.pocketly.view.petugas.PetugasFrame;

public class LoginFrame extends javax.swing.JFrame {
    private final AuthController auth = new AuthController();

    public LoginFrame() {
        initComponents();
        lblBuatAkun.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
        getRootPane().setDefaultButton(btnLogin); 
        setLocationRelativeTo(null); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgPanel = new javax.swing.JPanel();
        panelKanan = new javax.swing.JPanel();
        bungkus = new javax.swing.JPanel();
        kartu = new com.pocketly.component.RoundPanel();
        logoKanan = new javax.swing.JLabel();
        lblJudulForm = new javax.swing.JLabel();
        lblSubForm = new javax.swing.JLabel();
        strut4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 22), new java.awt.Dimension(0, 22), new java.awt.Dimension(32767, 22));
        barisUsername = new javax.swing.JPanel();
        lblUsername = new javax.swing.JLabel();
        strut5 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 5), new java.awt.Dimension(0, 5), new java.awt.Dimension(32767, 5));
        tfUsername = new com.pocketly.component.RoundTextField();
        strut6 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 10));
        barisPassword = new javax.swing.JPanel();
        lblPassword = new javax.swing.JLabel();
        strut7 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 5), new java.awt.Dimension(0, 5), new java.awt.Dimension(32767, 5));
        pfPassword = new com.pocketly.component.RoundPasswordField();
        strut8 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 8), new java.awt.Dimension(0, 8), new java.awt.Dimension(32767, 8));
        lblError = new javax.swing.JLabel();
        strut9 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 8), new java.awt.Dimension(0, 8), new java.awt.Dimension(32767, 8));
        btnLogin = new com.pocketly.component.RoundButton();
        strut10 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 16), new java.awt.Dimension(0, 16), new java.awt.Dimension(32767, 16));
        lblDaftar = new javax.swing.JLabel();
        lblBuatAkun = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pocketly - Masuk");
        setMinimumSize(new java.awt.Dimension(980, 620));
        getContentPane().setLayout(new java.awt.BorderLayout());

        bgPanel.setBackground(Theme.PAGE_BG);
        bgPanel.setLayout(new java.awt.BorderLayout());

        panelKanan.setOpaque(false);
        panelKanan.setLayout(new java.awt.BorderLayout());

        bungkus.setBackground(Theme.PAGE_BG);
        bungkus.setBorder(javax.swing.BorderFactory.createEmptyBorder(26, 40, 26, 40));
        bungkus.setMaximumSize(new java.awt.Dimension(1920, 1080));
        bungkus.setOpaque(false);
        bungkus.setPreferredSize(new java.awt.Dimension(1920, 1080));

        kartu.setBackground(Theme.CARD);
        kartu.setBorder(javax.swing.BorderFactory.createEmptyBorder(34, 40, 30, 40));

        logoKanan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ui/logo-pocketly-login.png"))); // NOI18N

        lblJudulForm.setBackground(Theme.TEXT_DARK);
        lblJudulForm.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        lblJudulForm.setForeground(new java.awt.Color(0, 0, 51));
        lblJudulForm.setText("Login");

        lblSubForm.setBackground(Theme.TEXT_DARK);
        lblSubForm.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        lblSubForm.setForeground(new java.awt.Color(0, 0, 51));
        lblSubForm.setText("Login ke akun anda dan rasakan kemudahan berbelanja.");

        barisUsername.setOpaque(false);

        lblUsername.setFont(Theme.font(java.awt.Font.PLAIN, 14));
        lblUsername.setForeground(Theme.NAVY);
        lblUsername.setText("Username");

        tfUsername.setMaximumSize(new java.awt.Dimension(32767, 42));
        tfUsername.setPlaceholder("Masukkan Username");
        tfUsername.setPreferredSize(new java.awt.Dimension(320, 42));
        tfUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfUsernameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout barisUsernameLayout = new javax.swing.GroupLayout(barisUsername);
        barisUsername.setLayout(barisUsernameLayout);
        barisUsernameLayout.setHorizontalGroup(
            barisUsernameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barisUsernameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUsername))
            .addComponent(strut5, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(tfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        barisUsernameLayout.setVerticalGroup(
            barisUsernameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barisUsernameLayout.createSequentialGroup()
                .addComponent(lblUsername)
                .addGap(0, 0, 0)
                .addComponent(strut5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(tfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        barisPassword.setOpaque(false);

        lblPassword.setFont(Theme.font(java.awt.Font.PLAIN, 14));
        lblPassword.setForeground(Theme.NAVY);
        lblPassword.setText("Password");

        pfPassword.setMaximumSize(new java.awt.Dimension(32767, 42));
        pfPassword.setPlaceholder("Masukkan Password");
        pfPassword.setPreferredSize(new java.awt.Dimension(320, 42));

        javax.swing.GroupLayout barisPasswordLayout = new javax.swing.GroupLayout(barisPassword);
        barisPassword.setLayout(barisPasswordLayout);
        barisPasswordLayout.setHorizontalGroup(
            barisPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barisPasswordLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPassword))
            .addComponent(strut7, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        barisPasswordLayout.setVerticalGroup(
            barisPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barisPasswordLayout.createSequentialGroup()
                .addComponent(lblPassword)
                .addGap(0, 0, 0)
                .addComponent(strut7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        lblError.setFont(Theme.font(java.awt.Font.PLAIN, 12));
        lblError.setForeground(new java.awt.Color(0xC0, 0x3A, 0x2B));
        lblError.setText(" ");

        btnLogin.setText("Masuk");
        btnLogin.setMaximumSize(new java.awt.Dimension(32767, 46));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        lblDaftar.setFont(Theme.font(java.awt.Font.PLAIN, 13));
        lblDaftar.setForeground(Theme.TEXT);
        lblDaftar.setText("                         Belum memiliki akun?");

        lblBuatAkun.setFont(Theme.font(java.awt.Font.BOLD, 14));
        lblBuatAkun.setForeground(Theme.NAVY);
        lblBuatAkun.setText("Buat Akun");
        lblBuatAkun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBuatAkunMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblBuatAkunMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblBuatAkunMouseExited(evt);
            }
        });

        javax.swing.GroupLayout kartuLayout = new javax.swing.GroupLayout(kartu);
        kartu.setLayout(kartuLayout);
        kartuLayout.setHorizontalGroup(
            kartuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(strut4, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(barisUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(strut6, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(barisPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(strut8, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(strut9, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(strut10, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(kartuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kartuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kartuLayout.createSequentialGroup()
                        .addComponent(btnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(kartuLayout.createSequentialGroup()
                        .addGroup(kartuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(logoKanan)
                            .addComponent(lblJudulForm)
                            .addComponent(lblSubForm)
                            .addComponent(lblError)
                            .addGroup(kartuLayout.createSequentialGroup()
                                .addComponent(lblDaftar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblBuatAkun)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        kartuLayout.setVerticalGroup(
            kartuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kartuLayout.createSequentialGroup()
                .addComponent(logoKanan)
                .addGap(18, 18, 18)
                .addComponent(lblJudulForm)
                .addGap(0, 0, 0)
                .addComponent(lblSubForm)
                .addGap(0, 0, 0)
                .addComponent(strut4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(barisUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(strut6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(barisPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(strut8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblError)
                .addGap(0, 0, 0)
                .addComponent(strut9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(116, 116, 116)
                .addComponent(strut10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kartuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDaftar)
                    .addComponent(lblBuatAkun))
                .addGap(16, 16, 16))
        );

        jPanel1.setBackground(Theme.PAGE_BG);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 625, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 718, Short.MAX_VALUE)
        );

        jLabel1.setBackground(Theme.PAGE_BG);
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ui/login-hero.png"))); // NOI18N

        javax.swing.GroupLayout bungkusLayout = new javax.swing.GroupLayout(bungkus);
        bungkus.setLayout(bungkusLayout);
        bungkusLayout.setHorizontalGroup(
            bungkusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bungkusLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bungkusLayout.createSequentialGroup()
                .addGap(0, 279, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 761, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(kartu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(296, 296, 296))
        );
        bungkusLayout.setVerticalGroup(
            bungkusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bungkusLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(bungkusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(kartu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 638, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelKanan.add(bungkus, java.awt.BorderLayout.CENTER);

        bgPanel.add(panelKanan, java.awt.BorderLayout.CENTER);

        getContentPane().add(bgPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfUsernameActionPerformed
        
    }//GEN-LAST:event_tfUsernameActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {
        prosesLogin();
    }

    private void lblBuatAkunMouseClicked(java.awt.event.MouseEvent evt) {
        new RegistrasiDialog(this).setVisible(true);
    }

    private void lblBuatAkunMouseEntered(java.awt.event.MouseEvent evt) {
        lblBuatAkun.setForeground(Theme.BLUE);
    }

    private void lblBuatAkunMouseExited(java.awt.event.MouseEvent evt) {
        lblBuatAkun.setForeground(Theme.NAVY);
    }

    private void prosesLogin() {
        lblError.setText(" ");
        var hasil = auth.login(tfUsername.getText(), new String(pfPassword.getPassword()));
        if (!hasil.sukses()) {
            lblError.setText(hasil.pesan()); 
            pfPassword.setText("");
            return;
        }
        Pengguna akun = hasil.akun();
        dispose();
        if (akun.isPetugas()) {
            new PetugasFrame(akun.username).setVisible(true);
        } else {
            new PelangganFrame(akun.username).setVisible(true);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel barisPassword;
    private javax.swing.JPanel barisUsername;
    private javax.swing.JPanel bgPanel;
    private com.pocketly.component.RoundButton btnLogin;
    private javax.swing.JPanel bungkus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private com.pocketly.component.RoundPanel kartu;
    private javax.swing.JLabel lblBuatAkun;
    private javax.swing.JLabel lblDaftar;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblJudulForm;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblSubForm;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel logoKanan;
    private javax.swing.JPanel panelKanan;
    private com.pocketly.component.RoundPasswordField pfPassword;
    private javax.swing.Box.Filler strut10;
    private javax.swing.Box.Filler strut4;
    private javax.swing.Box.Filler strut5;
    private javax.swing.Box.Filler strut6;
    private javax.swing.Box.Filler strut7;
    private javax.swing.Box.Filler strut8;
    private javax.swing.Box.Filler strut9;
    private com.pocketly.component.RoundTextField tfUsername;
    // End of variables declaration//GEN-END:variables
}
