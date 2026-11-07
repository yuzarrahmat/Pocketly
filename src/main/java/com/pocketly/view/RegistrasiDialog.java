package com.pocketly.view;

import com.pocketly.controller.AuthController;
import com.pocketly.util.Theme;
import com.pocketly.util.UIs;

public class RegistrasiDialog extends javax.swing.JDialog {
    private final AuthController auth = new AuthController();

    public RegistrasiDialog() {
        this(null);
    }

    public RegistrasiDialog(java.awt.Window owner) {
        super(owner);
        initComponents();
        lblMasuk.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
        ((javax.swing.JPanel) getContentPane()).setBackground(Theme.PAGE_BG);
        scrollDaftar.setOpaque(false);
        scrollDaftar.getViewport().setOpaque(false);
        scrollDaftar.getVerticalScrollBar().setUnitIncrement(18);
        setLocationRelativeTo(owner); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollDaftar = new javax.swing.JScrollPane();
        kartu = new com.pocketly.component.RoundPanel();
        lblJudul = new javax.swing.JLabel();
        lblSub = new javax.swing.JLabel();
        strut1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 12), new java.awt.Dimension(0, 12), new java.awt.Dimension(32767, 12));
        barisDuo = new javax.swing.JPanel();
        barisNama = new javax.swing.JPanel();
        lbltfNama = new javax.swing.JLabel();
        strut_tfNama = new javax.swing.Box.Filler(new java.awt.Dimension(0, 4), new java.awt.Dimension(0, 4), new java.awt.Dimension(32767, 4));
        tfNama = new com.pocketly.component.RoundTextField();
        barisUsername = new javax.swing.JPanel();
        lbltfUsername = new javax.swing.JLabel();
        strut_tfUsername = new javax.swing.Box.Filler(new java.awt.Dimension(0, 4), new java.awt.Dimension(0, 4), new java.awt.Dimension(32767, 4));
        tfUsername = new com.pocketly.component.RoundTextField();
        strut2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 8), new java.awt.Dimension(0, 8), new java.awt.Dimension(32767, 8));
        barisAlamat = new javax.swing.JPanel();
        lbltfAlamat = new javax.swing.JLabel();
        strut_tfAlamat = new javax.swing.Box.Filler(new java.awt.Dimension(0, 4), new java.awt.Dimension(0, 4), new java.awt.Dimension(32767, 4));
        tfAlamat = new com.pocketly.component.RoundTextField();
        strut3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 8), new java.awt.Dimension(0, 8), new java.awt.Dimension(32767, 8));
        barisEmail = new javax.swing.JPanel();
        strut_tfEmail = new javax.swing.Box.Filler(new java.awt.Dimension(0, 4), new java.awt.Dimension(0, 4), new java.awt.Dimension(32767, 4));
        lbltfEmail = new javax.swing.JLabel();
        tfEmail = new com.pocketly.component.RoundTextField();
        strut4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 8), new java.awt.Dimension(0, 8), new java.awt.Dimension(32767, 8));
        barisTelp = new javax.swing.JPanel();
        lbltfTelp = new javax.swing.JLabel();
        strut_tfTelp = new javax.swing.Box.Filler(new java.awt.Dimension(0, 4), new java.awt.Dimension(0, 4), new java.awt.Dimension(32767, 4));
        tfTelp = new com.pocketly.component.RoundTextField();
        strut5 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 8), new java.awt.Dimension(0, 8), new java.awt.Dimension(32767, 8));
        barisPassword = new javax.swing.JPanel();
        lblpfPassword = new javax.swing.JLabel();
        strut_pfPassword = new javax.swing.Box.Filler(new java.awt.Dimension(0, 4), new java.awt.Dimension(0, 4), new java.awt.Dimension(32767, 4));
        pfPassword = new com.pocketly.component.RoundPasswordField();
        lblError = new javax.swing.JLabel();
        btnDaftar = new com.pocketly.component.RoundButton();
        strut6 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 10));
        lblSudah = new javax.swing.JLabel();
        lblMasuk = new javax.swing.JLabel();

        setTitle("Registrasi Akun Pelanggan");
        setResizable(false);
        setModal(true);

        scrollDaftar.setPreferredSize(new java.awt.Dimension(600, 560));
        scrollDaftar.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

        kartu.setBackground(Theme.CARD);
        kartu.setBorder(javax.swing.BorderFactory.createEmptyBorder(22, 32, 18, 32));

        lblJudul.setFont(Theme.font(java.awt.Font.BOLD, 22));
        lblJudul.setForeground(Theme.NAVY);
        lblJudul.setText("Buat akun dulu ya!");

        lblSub.setFont(Theme.font(java.awt.Font.PLAIN, 12));
        lblSub.setForeground(Theme.NAVY);
        lblSub.setText("Bergabung dengan Pocketly dan rasakan kemudahan berbelanja.");

        barisDuo.setMaximumSize(new java.awt.Dimension(32767, 96));
        barisDuo.setOpaque(false);
        barisDuo.setLayout(new java.awt.GridLayout(1, 2, 12, 0));

        barisNama.setOpaque(false);

        lbltfNama.setFont(Theme.font(java.awt.Font.PLAIN, 13));
        lbltfNama.setForeground(Theme.NAVY);
        lbltfNama.setText("Nama Kamu");

        tfNama.setMaximumSize(new java.awt.Dimension(32767, 36));
        tfNama.setPlaceholder("Masukkan nama lengkap");

        javax.swing.GroupLayout barisNamaLayout = new javax.swing.GroupLayout(barisNama);
        barisNama.setLayout(barisNamaLayout);
        barisNamaLayout.setHorizontalGroup(
            barisNamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barisNamaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(barisNamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(barisNamaLayout.createSequentialGroup()
                        .addComponent(lbltfNama, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(strut_tfNama, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(barisNamaLayout.createSequentialGroup()
                        .addComponent(tfNama, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        barisNamaLayout.setVerticalGroup(
            barisNamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barisNamaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(barisNamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(strut_tfNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbltfNama))
                .addGap(18, 18, 18)
                .addComponent(tfNama, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        barisDuo.add(barisNama);

        barisUsername.setOpaque(false);

        lbltfUsername.setFont(Theme.font(java.awt.Font.PLAIN, 13));
        lbltfUsername.setForeground(Theme.NAVY);
        lbltfUsername.setText("Username");

        tfUsername.setMaximumSize(new java.awt.Dimension(32767, 36));
        tfUsername.setPlaceholder("Masukkan username");
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
                .addComponent(lbltfUsername)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(strut_tfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(tfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        barisUsernameLayout.setVerticalGroup(
            barisUsernameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barisUsernameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(barisUsernameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(strut_tfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbltfUsername))
                .addGap(18, 18, 18)
                .addComponent(tfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        barisDuo.add(barisUsername);

        barisAlamat.setOpaque(false);

        lbltfAlamat.setFont(Theme.font(java.awt.Font.PLAIN, 13));
        lbltfAlamat.setForeground(Theme.NAVY);
        lbltfAlamat.setText("Alamat");

        tfAlamat.setMaximumSize(new java.awt.Dimension(32767, 36));
        tfAlamat.setPlaceholder("Masukkan alamat");

        javax.swing.GroupLayout barisAlamatLayout = new javax.swing.GroupLayout(barisAlamat);
        barisAlamat.setLayout(barisAlamatLayout);
        barisAlamatLayout.setHorizontalGroup(
            barisAlamatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(strut_tfAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(barisAlamatLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lbltfAlamat))
            .addComponent(tfAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        barisAlamatLayout.setVerticalGroup(
            barisAlamatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barisAlamatLayout.createSequentialGroup()
                .addComponent(lbltfAlamat)
                .addGap(0, 0, 0)
                .addComponent(strut_tfAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(tfAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        barisEmail.setOpaque(false);

        lbltfEmail.setFont(Theme.font(java.awt.Font.PLAIN, 13));
        lbltfEmail.setForeground(Theme.NAVY);
        lbltfEmail.setText("Email");

        tfEmail.setMaximumSize(new java.awt.Dimension(32767, 36));
        tfEmail.setPlaceholder("Masukkan email");

        javax.swing.GroupLayout barisEmailLayout = new javax.swing.GroupLayout(barisEmail);
        barisEmail.setLayout(barisEmailLayout);
        barisEmailLayout.setHorizontalGroup(
            barisEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(strut_tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(barisEmailLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lbltfEmail))
            .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        barisEmailLayout.setVerticalGroup(
            barisEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barisEmailLayout.createSequentialGroup()
                .addComponent(strut_tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lbltfEmail)
                .addGap(0, 0, 0)
                .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        barisTelp.setOpaque(false);

        lbltfTelp.setFont(Theme.font(java.awt.Font.PLAIN, 13));
        lbltfTelp.setForeground(Theme.NAVY);
        lbltfTelp.setText("No Telpon");

        tfTelp.setMaximumSize(new java.awt.Dimension(32767, 36));
        tfTelp.setPlaceholder("Masukkan nomor telepon");

        javax.swing.GroupLayout barisTelpLayout = new javax.swing.GroupLayout(barisTelp);
        barisTelp.setLayout(barisTelpLayout);
        barisTelpLayout.setHorizontalGroup(
            barisTelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barisTelpLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lbltfTelp))
            .addComponent(strut_tfTelp, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(tfTelp, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        barisTelpLayout.setVerticalGroup(
            barisTelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barisTelpLayout.createSequentialGroup()
                .addComponent(lbltfTelp)
                .addGap(0, 0, 0)
                .addComponent(strut_tfTelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(tfTelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        barisPassword.setOpaque(false);

        lblpfPassword.setFont(Theme.font(java.awt.Font.PLAIN, 13));
        lblpfPassword.setForeground(Theme.NAVY);
        lblpfPassword.setText("Password");

        pfPassword.setMaximumSize(new java.awt.Dimension(32767, 36));
        pfPassword.setPlaceholder("Masukkan password");

        javax.swing.GroupLayout barisPasswordLayout = new javax.swing.GroupLayout(barisPassword);
        barisPassword.setLayout(barisPasswordLayout);
        barisPasswordLayout.setHorizontalGroup(
            barisPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barisPasswordLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblpfPassword))
            .addComponent(strut_pfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        barisPasswordLayout.setVerticalGroup(
            barisPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barisPasswordLayout.createSequentialGroup()
                .addComponent(lblpfPassword)
                .addGap(0, 0, 0)
                .addComponent(strut_pfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        lblError.setFont(Theme.font(java.awt.Font.PLAIN, 12));
        lblError.setForeground(new java.awt.Color(0xC0, 0x3A, 0x2B));
        lblError.setText(" ");
        lblError.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 0, 8, 0));

        btnDaftar.setText("Registrasi");
        btnDaftar.setMaximumSize(new java.awt.Dimension(32767, 42));
        btnDaftar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDaftarActionPerformed(evt);
            }
        });

        lblSudah.setFont(Theme.font(java.awt.Font.PLAIN, 12));
        lblSudah.setForeground(Theme.TEXT);
        lblSudah.setText("Sudah memiliki akun?");

        lblMasuk.setFont(Theme.font(java.awt.Font.BOLD, 12));
        lblMasuk.setForeground(Theme.NAVY);
        lblMasuk.setText("Masuk");
        lblMasuk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMasukMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout kartuLayout = new javax.swing.GroupLayout(kartu);
        kartu.setLayout(kartuLayout);
        kartuLayout.setHorizontalGroup(
            kartuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kartuLayout.createSequentialGroup()
                .addGroup(kartuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(strut1, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(barisDuo, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(strut2, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(strut3, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(barisEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(strut4, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(barisTelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(strut5, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(barisPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(strut6, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(kartuLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(kartuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblError)
                            .addComponent(btnDaftar, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSudah)
                            .addComponent(lblMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(barisAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblJudul)
                    .addComponent(lblSub))
                .addContainerGap())
        );
        kartuLayout.setVerticalGroup(
            kartuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kartuLayout.createSequentialGroup()
                .addComponent(lblJudul)
                .addGap(0, 0, 0)
                .addComponent(lblSub)
                .addGap(0, 0, 0)
                .addComponent(strut1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(barisDuo, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(strut2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(barisAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(strut3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(barisEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(strut4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(barisTelp, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(strut5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(barisPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblError)
                .addGap(0, 0, 0)
                .addComponent(btnDaftar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(strut6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblSudah)
                .addGap(0, 0, 0)
                .addComponent(lblMasuk))
        );

        scrollDaftar.setViewportView(kartu);

        getContentPane().add(scrollDaftar, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfUsernameActionPerformed
        
    }//GEN-LAST:event_tfUsernameActionPerformed

    private void btnDaftarActionPerformed(java.awt.event.ActionEvent evt) {
        prosesRegistrasi();
    }

    private void lblMasukMouseClicked(java.awt.event.MouseEvent evt) {
        dispose();
    }

    private void prosesRegistrasi() {
        lblError.setText(" ");
        var hasil = auth.registrasi(tfUsername.getText(),
                new String(pfPassword.getPassword()),
                tfNama.getText(), tfAlamat.getText(),
                tfEmail.getText(), tfTelp.getText());
        if (!hasil.sukses()) {
            lblError.setText(hasil.pesan()); 
            return;
        }
        UIs.info(this, "Registrasi Berhasil");
        dispose(); 
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel barisAlamat;
    private javax.swing.JPanel barisDuo;
    private javax.swing.JPanel barisEmail;
    private javax.swing.JPanel barisNama;
    private javax.swing.JPanel barisPassword;
    private javax.swing.JPanel barisTelp;
    private javax.swing.JPanel barisUsername;
    private com.pocketly.component.RoundButton btnDaftar;
    private com.pocketly.component.RoundPanel kartu;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblJudul;
    private javax.swing.JLabel lblMasuk;
    private javax.swing.JLabel lblSub;
    private javax.swing.JLabel lblSudah;
    private javax.swing.JLabel lblpfPassword;
    private javax.swing.JLabel lbltfAlamat;
    private javax.swing.JLabel lbltfEmail;
    private javax.swing.JLabel lbltfNama;
    private javax.swing.JLabel lbltfTelp;
    private javax.swing.JLabel lbltfUsername;
    private com.pocketly.component.RoundPasswordField pfPassword;
    private javax.swing.JScrollPane scrollDaftar;
    private javax.swing.Box.Filler strut1;
    private javax.swing.Box.Filler strut2;
    private javax.swing.Box.Filler strut3;
    private javax.swing.Box.Filler strut4;
    private javax.swing.Box.Filler strut5;
    private javax.swing.Box.Filler strut6;
    private javax.swing.Box.Filler strut_pfPassword;
    private javax.swing.Box.Filler strut_tfAlamat;
    private javax.swing.Box.Filler strut_tfEmail;
    private javax.swing.Box.Filler strut_tfNama;
    private javax.swing.Box.Filler strut_tfTelp;
    private javax.swing.Box.Filler strut_tfUsername;
    private com.pocketly.component.RoundTextField tfAlamat;
    private com.pocketly.component.RoundTextField tfEmail;
    private com.pocketly.component.RoundTextField tfNama;
    private com.pocketly.component.RoundTextField tfTelp;
    private com.pocketly.component.RoundTextField tfUsername;
    // End of variables declaration//GEN-END:variables
}
