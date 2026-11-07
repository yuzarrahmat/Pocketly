package com.pocketly.view.petugas;

import com.pocketly.controller.ProdukAdminController;
import com.pocketly.model.Kategori;
import com.pocketly.model.Produk;
import com.pocketly.util.Theme;
import com.pocketly.util.UIs;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class KelolaProdukPanel extends javax.swing.JPanel {
    private final String username;
    private final PetugasNav nav;
    private final ProdukAdminController ctl = new ProdukAdminController();

    private DefaultTableModel model;
    private List<Produk> produkTampil;

    private static final int KOLOM_STOK = 5;
    private static final int KOLOM_EDIT = 7;

    public KelolaProdukPanel(String username, PetugasNav nav) {
        this.username = username;
        this.nav = nav;
        initComponents();
        siapkanTabel();
        pasangAksiTabel();
    }

    public KelolaProdukPanel() {
        this(null, null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelAtas = new javax.swing.JPanel();
        lblJudul = new javax.swing.JLabel();
        btnTambah = new com.pocketly.component.RoundButton();
        lblCatatan = new javax.swing.JLabel();
        kartu = new com.pocketly.component.RoundPanel();
        scrollTabel = new javax.swing.JScrollPane();
        tblProduk = new javax.swing.JTable();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(22, 26, 22, 26));
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(1920, 1080));

        panelAtas.setOpaque(false);
        panelAtas.setLayout(new java.awt.BorderLayout());

        lblJudul.setFont(Theme.font(java.awt.Font.BOLD, 22));
        lblJudul.setForeground(Theme.TEXT);
        lblJudul.setText("Kelola Produk & Stok");
        panelAtas.add(lblJudul, java.awt.BorderLayout.CENTER);

        btnTambah.setText("+ Tambah Produk");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });
        panelAtas.add(btnTambah, java.awt.BorderLayout.LINE_END);

        lblCatatan.setFont(Theme.font(java.awt.Font.PLAIN, 12));
        lblCatatan.setForeground(Theme.TEXT_MUTED);
        lblCatatan.setText("Tips: klik tombol +/- pada kolom stok untuk penyesuaian cepat, klik judul kolom \"Ubah Stok\" untuk mengetik angka langsung.");
        panelAtas.add(lblCatatan, java.awt.BorderLayout.PAGE_END);

        kartu.setBackground(Theme.CARD);
        kartu.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 12, 10, 12));
        kartu.setRadius(18);
        kartu.setLayout(new java.awt.BorderLayout());

        scrollTabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        scrollTabel.setOpaque(false);

        tblProduk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Gambar", "ID", "Nama Produk", "Kategori", "Harga / Satuan", "Ubah Stok (+/-)", "Status", "Edit"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProduk.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblProduk.setFillsViewportHeight(true);
        tblProduk.setRowHeight(56);
        scrollTabel.setViewportView(tblProduk);

        kartu.add(scrollTabel, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelAtas, javax.swing.GroupLayout.DEFAULT_SIZE, 1868, Short.MAX_VALUE)
            .addComponent(kartu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelAtas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kartu, javax.swing.GroupLayout.PREFERRED_SIZE, 989, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {
        new ProdukFormDialog(null).setVisible(true); // flowchart: form tambah produk
    }

    private void siapkanTabel() {
        UIs.styleTable(tblProduk);
        tblProduk.setRowHeight(56); 
        model = (DefaultTableModel) tblProduk.getModel();
        int[] lebarKolom = {64, 64, 190, 130, 120, 140, 84, 86};
        for (int i = 0; i < lebarKolom.length && i < tblProduk.getColumnCount(); i++) {
            tblProduk.getColumnModel().getColumn(i).setPreferredWidth(lebarKolom[i]);
        }

        
        tblProduk.getColumnModel().getColumn(0).setCellRenderer((t, value, isSelected, hasFocus, row, column) -> {
            JLabel l = new JLabel(UIs.productImage(String.valueOf(value), 48, 44));
            l.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            l.setBackground(isSelected ? Theme.BLUE_LIGHT : Color.WHITE);
            l.setOpaque(true);
            return l;
        });

        tblProduk.getColumnModel().getColumn(KOLOM_STOK).setCellRenderer((t, value, isSelected, hasFocus, row, column) -> {
            JPanel p = new JPanel(new FlowLayout(FlowLayout.CENTER, 3, 0)) {
                @Override
                protected void paintComponent(Graphics g) {
                    g.setColor(isSelected ? Theme.BLUE_LIGHT : Color.WHITE);
                    g.fillRect(0, 0, getWidth(), getHeight());
                }
            };
            p.setOpaque(false);
            int stok = (value instanceof Integer i) ? i : 0;
            int modelRow = tblProduk.convertRowIndexToModel(row);
            if (produkTampil != null && modelRow < produkTampil.size()) {
                stok = produkTampil.get(modelRow).stok; 
            }
            p.add(tombolMini("\u2212"));
            JLabel lblStok = new JLabel(String.valueOf(stok));
            lblStok.setFont(Theme.font(Font.BOLD, 14f));
            lblStok.setForeground(stok == 0 ? new Color(0xB9, 0x1C, 0x1C) : Theme.TEXT);
            lblStok.setPreferredSize(new Dimension(40, 24));
            lblStok.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            p.add(lblStok);
            p.add(tombolMini("+"));
            return p;
        });

        tblProduk.getColumnModel().getColumn(6).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(javax.swing.JTable t, Object value, boolean isSelected,
                    boolean hasFocus, int row, int column) {
                JLabel l = UIs.statusBadge(String.valueOf(value));
                l.setAlignmentX(CENTER_ALIGNMENT);
                JPanel p = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0)) {
                    @Override
                    protected void paintComponent(Graphics g) {
                        g.setColor(isSelected ? Theme.BLUE_LIGHT : Color.WHITE);
                        g.fillRect(0, 0, getWidth(), getHeight());
                    }
                };
                p.setOpaque(false);
                p.add(l);
                return p;
            }
        });

        tblProduk.getColumnModel().getColumn(KOLOM_EDIT).setCellRenderer((t, value, isSelected, hasFocus, row, column) -> {
            JPanel p = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0)) {
                @Override
                protected void paintComponent(Graphics g) {
                    g.setColor(isSelected ? Theme.BLUE_LIGHT : Color.WHITE);
                    g.fillRect(0, 0, getWidth(), getHeight());
                }
            };
            p.setOpaque(false);
            JButton b = UIs.button("Edit", UIs.Btn.SECONDARY);
            b.setPreferredSize(new Dimension(70, 28));
            p.add(b);
            return p;
        });

        DefaultTableCellRenderer kanan = new DefaultTableCellRenderer();
        kanan.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tblProduk.getColumnModel().getColumn(4).setCellRenderer(kanan);
    }

    private JButton tombolMini(String teks) {
        JButton b = new JButton(teks) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(Theme.NAVY);
                g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 12, 12);
                g2.dispose();
                super.paintComponent(g);
            }
        };
        b.setForeground(Color.WHITE);
        b.setFont(Theme.font(Font.BOLD, 13f));
        b.setContentAreaFilled(false);
        b.setBorderPainted(false);
        b.setFocusPainted(false);
        b.setBorder(BorderFactory.createEmptyBorder());
        b.setPreferredSize(new Dimension(28, 28));
        return b;
    }

    private void pasangAksiTabel() {
        tblProduk.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int kolom = tblProduk.columnAtPoint(e.getPoint());
                int barisTampil = tblProduk.rowAtPoint(e.getPoint());
                if (barisTampil < 0 || produkTampil == null) {
                    return;
                }
                int baris = tblProduk.convertRowIndexToModel(barisTampil);
                if (baris >= produkTampil.size()) {
                    return;
                }
                Produk p = produkTampil.get(baris);
                if (kolom == KOLOM_STOK) {
                    // tentukan area minus / plus dari posisi klik dalam sel
                    java.awt.Rectangle sel = tblProduk.getCellRect(barisTampil, kolom, false);
                    double relatif = (e.getPoint().x - sel.x) / (double) sel.width;
                    if (relatif < 0.36) {
                        ubahStok(p, -1);
                    } else if (relatif > 0.64) {
                        ubahStok(p, +1);
                    } else {
                        inputStokManual(p);
                    }
                } else if (kolom == KOLOM_EDIT) {
                    new ProdukFormDialog(p).setVisible(true);
                }
            }
        });
        tblProduk.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                int kolom = tblProduk.columnAtPoint(e.getPoint());
                tblProduk.setCursor(kolom == KOLOM_STOK || kolom == KOLOM_EDIT
                        ? Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)
                        : Cursor.getDefaultCursor());
            }
        });
        tblProduk.getTableHeader().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int col = tblProduk.columnAtPoint(e.getPoint());
                if (col == KOLOM_STOK) {
                    int[] sel = tblProduk.getSelectedRows();
                    if (sel.length != 1) {
                        UIs.error(KelolaProdukPanel.this, "Pilih satu baris produk terlebih dahulu.");
                        return;
                    }
                    inputStokManual(produkTampil.get(tblProduk.convertRowIndexToModel(sel[0])));
                }
            }
        });
    }

    private void ubahStok(Produk p, int arah) {
        if (p.stok + arah < 0) {
            UIs.error(this, "Stok tidak boleh negatif.");
            return;
        }
        // flowchart: klik +/- -> konfirmasi perubahan -> Database Produk
        if (UIs.confirm(this, "Ubah stok " + p.nama + " menjadi " + (p.stok + arah) + "?")) {
            try {
                String pesan = ctl.ubahStok(p.id, p.stok + arah);
                UIs.info(this, pesan); // "Berhasil merubah data produk"
                muatUlang();
            } catch (RuntimeException ex) {
                UIs.error(this, ex.getMessage());
            }
        }
    }

    private void inputStokManual(Produk p) {
        JTextField input = UIs.textField();
        input.setText(String.valueOf(p.stok));
        Object[] pesan = {"Stok baru untuk " + p.nama + ":", input};
        int ok = JOptionPane.showConfirmDialog(this, pesan, "Ubah Stok",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (ok == JOptionPane.OK_OPTION) {
            try {
                int baru = Integer.parseInt(input.getText().trim());
                if (baru < 0) {
                    UIs.error(this, "Stok tidak boleh negatif.");
                    return;
                }
                String pesan2 = ctl.ubahStok(p.id, baru);
                UIs.info(this, pesan2);
                muatUlang();
            } catch (NumberFormatException ex) {
                UIs.error(this, "Stok harus berupa angka bulat.");
            }
        }
    }

    public void muatUlang() {
        model.setRowCount(0);
        produkTampil = ctl.semuaProduk();
        for (Produk p : produkTampil) {
            model.addRow(new Object[]{
                p.gambar == null ? "" : p.gambar,
                p.id,
                p.nama,
                p.namaKategori,
                UIs.money(p.hargaSatuan) + " / " + p.satuan,
                p.stok,
                p.status,
                ""
            });
        }
    }


    private class ProdukFormDialog extends javax.swing.JDialog {

        private final Produk edit;
        private File gambarTerpilih;

        private final JTextField tfNama = UIs.textField();
        private final JTextField tfHarga = UIs.textField();
        private final JTextField tfStok = UIs.textField();
        private final JTextField tfSatuan = UIs.textField();
        private final javax.swing.JComboBox<String> cbKategori = new javax.swing.JComboBox<>();
        private final javax.swing.JComboBox<String> cbStatus = new javax.swing.JComboBox<>(new String[]{"Aktif", "Nonaktif"});
        private final JLabel lblGambar = new JLabel();
        private final List<Kategori> kategoriList;

        private ProdukFormDialog(Produk edit) {
            super(javax.swing.SwingUtilities.getWindowAncestor(KelolaProdukPanel.this),
                    edit == null ? "Tambah Produk" : "Edit Produk", ModalityType.APPLICATION_MODAL);
            this.edit = edit;
            kategoriList = ctl.daftarKategori();
            for (Kategori k : kategoriList) {
                cbKategori.addItem(k.nama);
            }
            if (edit != null) {
                tfNama.setText(edit.nama);
                tfHarga.setText(String.valueOf(edit.hargaSatuan));
                tfStok.setText(String.valueOf(edit.stok));
                tfSatuan.setText(edit.satuan);
                for (int i = 0; i < kategoriList.size(); i++) {
                    if (kategoriList.get(i).id.equals(edit.idKategori)) {
                        cbKategori.setSelectedIndex(i);
                        break;
                    }
                }
                cbStatus.setSelectedItem(edit.status);
                lblGambar.setIcon(UIs.productImage(edit.gambar, 96, 84));
                lblGambar.setText(edit.belumAdaGambar() ? "produk ini belum ada gambar" : null);
            } else {
                lblGambar.setIcon(UIs.productImage(null, 96, 84));
                lblGambar.setText(null);
            }
            buildUi();
        }

        private void buildUi() {
            setLayout(new java.awt.BorderLayout());
            getContentPane().setBackground(Theme.PAGE_BG);
            JPanel card = UIs.card(16);
            card.setLayout(new java.awt.BorderLayout(0, 12));
            card.setBorder(BorderFactory.createEmptyBorder(24, 28, 24, 28));

            JLabel judul = new JLabel(edit == null ? "Tambah Produk Baru" : "Edit Produk " + edit.id);
            judul.setFont(Theme.h2());
            judul.setForeground(Theme.TEXT);
            card.add(judul, java.awt.BorderLayout.NORTH);

            JPanel form = new JPanel(new java.awt.GridBagLayout());
            form.setOpaque(false);
            java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = java.awt.GridBagConstraints.WEST;
            gbc.insets = new java.awt.Insets(6, 4, 6, 12);
            gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;

            JLabel pratinjau = new JLabel("Gambar produk (opsional):");
            pratinjau.setFont(Theme.h3());
            form.add(pratinjau, gbc);
            gbc.gridx = 1;
            JPanel gambarPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
            gambarPanel.setOpaque(false);
            lblGambar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
            lblGambar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            lblGambar.setFont(Theme.small());
            lblGambar.setForeground(Theme.TEXT_MUTED);
            var btnPilihGambar = UIs.button("Pilih Gambar", UIs.Btn.SECONDARY);
            btnPilihGambar.addActionListener(e -> pilihGambar());
            var btnHapusGambar = UIs.button("Hapus", UIs.Btn.GHOST);
            btnHapusGambar.addActionListener(e -> {
                gambarTerpilih = null;
                if (edit != null) {
                    edit.gambar = null;
                }
                lblGambar.setIcon(UIs.productImage(null, 96, 84));
                lblGambar.setText(null);
            });
            gambarPanel.add(lblGambar);
            gambarPanel.add(btnPilihGambar);
            gambarPanel.add(btnHapusGambar);
            form.add(gambarPanel, gbc);

            tambahBaris(form, gbc, "Nama produk", tfNama);
            tambahBaris(form, gbc, "Harga satuan (Rp)", tfHarga);
            tambahBaris(form, gbc, "Stok", tfStok);
            tambahBaris(form, gbc, "Satuan barang", tfSatuan);

            gbc.gridx = 0;
            gbc.gridy += 1;
            form.add(UIs.fieldLabel("Kategori"), gbc);
            gbc.gridx = 1;
            cbKategori.setPreferredSize(new Dimension(240, 36));
            form.add(cbKategori, gbc);
            gbc.gridx = 0;
            gbc.gridy += 1;
            form.add(UIs.fieldLabel("Status produk"), gbc);
            gbc.gridx = 1;
            cbStatus.setPreferredSize(new Dimension(240, 36));
            form.add(cbStatus, gbc);

            card.add(form, java.awt.BorderLayout.CENTER);

            JPanel tombol = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
            tombol.setOpaque(false);
            var btnBatal = UIs.button("Batal", UIs.Btn.GHOST);
            btnBatal.addActionListener(e -> dispose());
            var btnSimpan = UIs.button(edit == null ? "Konfirmasi" : "Konfirmasi Perubahan", UIs.Btn.PRIMARY);
            btnSimpan.addActionListener(e -> simpan());
            tombol.add(btnBatal);
            tombol.add(btnSimpan);
            card.add(tombol, java.awt.BorderLayout.SOUTH);

            add(card, java.awt.BorderLayout.CENTER);
            pack();
            setResizable(false);
            setLocationRelativeTo(getOwner());
            getRootPane().setDefaultButton(btnSimpan);
        }

        private void tambahBaris(JPanel form, java.awt.GridBagConstraints gbc, String label, JTextField field) {
            gbc.gridx = 0;
            gbc.gridy += 1;
            form.add(UIs.fieldLabel(label), gbc);
            gbc.gridx = 1;
            field.setPreferredSize(new Dimension(240, 36));
            form.add(field, gbc);
        }

        private void pilihGambar() {
            JFileChooser fc = new JFileChooser();
            fc.setFileFilter(new FileNameExtensionFilter("Gambar (jpg, png, gif)", "jpg", "jpeg", "png", "gif"));
            if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                gambarTerpilih = fc.getSelectedFile();
                java.awt.Image img = new javax.swing.ImageIcon(gambarTerpilih.getPath())
                        .getImage().getScaledInstance(96, 84, java.awt.Image.SCALE_SMOOTH);
                lblGambar.setIcon(new javax.swing.ImageIcon(img));
                lblGambar.setText(null);
            }
        }

        private void simpan() {
            int idxKategori = cbKategori.getSelectedIndex();
            if (idxKategori < 0 || idxKategori >= kategoriList.size()) {
                UIs.error(this, "Kategori produk wajib dipilih.");
                return;
            }
            String idKategori = kategoriList.get(idxKategori).id;
            String status = (String) cbStatus.getSelectedItem();
            String pesan;
            try {
                if (edit == null) {
                    pesan = ctl.tambahProduk(tfNama.getText(), tfHarga.getText(), tfStok.getText(),
                            tfSatuan.getText(), idKategori, status, gambarTerpilih, username);
                } else {
                    pesan = ctl.ubahProduk(edit, tfNama.getText(), tfHarga.getText(), tfStok.getText(),
                            tfSatuan.getText(), idKategori, status, gambarTerpilih);
                }
                if (pesan.startsWith("Berhasil")) {
                    UIs.info(this, pesan);
                    dispose();
                    muatUlang();
                } else {
                    UIs.error(this, pesan); // pesan error sesuai kesalahannya
                }
            } catch (RuntimeException ex) {
                UIs.error(this, ex.getMessage());
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.pocketly.component.RoundButton btnTambah;
    private com.pocketly.component.RoundPanel kartu;
    private javax.swing.JLabel lblCatatan;
    private javax.swing.JLabel lblJudul;
    private javax.swing.JPanel panelAtas;
    private javax.swing.JScrollPane scrollTabel;
    private javax.swing.JTable tblProduk;
    // End of variables declaration//GEN-END:variables
}
