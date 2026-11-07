package com.pocketly.view.petugas;

import com.pocketly.controller.KasirController;
import com.pocketly.model.KasirItem;
import com.pocketly.util.Theme;
import com.pocketly.util.UIs;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class KasirPanel extends javax.swing.JPanel {
    private final String username;
    private final PetugasNav nav;
    private final KasirController ctl = new KasirController();

    private final List<KasirItem> items = new ArrayList<>();
    private DefaultTableModel model;

    private static final int KOLOM_JUMLAH = 3;

    public KasirPanel(String username, PetugasNav nav) {
        this.username = username;
        this.nav = nav;
        initComponents();
        siapkanTabel();
        pasangAksiTabel();
    }

    public KasirPanel() {
        this(null, null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelAtas = new javax.swing.JPanel();
        formCard = new com.pocketly.component.RoundPanel();
        baris1 = new javax.swing.JPanel();
        lblIdProduk = new javax.swing.JLabel();
        tfIdProduk = new com.pocketly.component.RoundTextField();
        lblJumlah = new javax.swing.JLabel();
        tfJumlah = new com.pocketly.component.RoundTextField();
        baris2 = new javax.swing.JPanel();
        lblNamaPembeli = new javax.swing.JLabel();
        tfNamaPembeli = new com.pocketly.component.RoundTextField();
        btnTambah = new com.pocketly.component.RoundButton();
        lblJudul = new javax.swing.JLabel();
        btnKembali = new com.pocketly.component.RoundButton();
        tabelCard = new com.pocketly.component.RoundPanel();
        scrollTabel = new javax.swing.JScrollPane();
        tblKasir = new javax.swing.JTable();
        footCard = new com.pocketly.component.RoundPanel();
        tot = new javax.swing.JPanel();
        lblTotalK = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        kanan = new javax.swing.JPanel();
        btnBayar = new com.pocketly.component.RoundButton();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(22, 26, 22, 26));
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(1920, 1080));

        panelAtas.setOpaque(false);

        formCard.setBackground(Theme.CARD);
        formCard.setBorder(javax.swing.BorderFactory.createEmptyBorder(14, 18, 14, 18));
        formCard.setRadius(18);

        baris1.setOpaque(false);

        lblIdProduk.setFont(Theme.font(java.awt.Font.BOLD, 15));
        lblIdProduk.setForeground(Theme.TEXT_DARK);
        lblIdProduk.setText("ID Produk");

        tfIdProduk.setPreferredSize(new java.awt.Dimension(140, 36));
        tfIdProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIdProdukActionPerformed(evt);
            }
        });

        lblJumlah.setFont(Theme.font(java.awt.Font.BOLD, 15));
        lblJumlah.setForeground(Theme.TEXT_DARK);
        lblJumlah.setText("Jumlah");

        tfJumlah.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfJumlah.setPreferredSize(new java.awt.Dimension(90, 36));
        tfJumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfJumlahActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout baris1Layout = new javax.swing.GroupLayout(baris1);
        baris1.setLayout(baris1Layout);
        baris1Layout.setHorizontalGroup(
            baris1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(baris1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblIdProduk)
                .addGap(10, 10, 10)
                .addComponent(tfIdProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(lblJumlah)
                .addGap(10, 10, 10)
                .addComponent(tfJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(121, Short.MAX_VALUE))
        );
        baris1Layout.setVerticalGroup(
            baris1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(baris1Layout.createSequentialGroup()
                .addGroup(baris1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(baris1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(lblIdProduk))
                    .addGroup(baris1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(tfIdProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(baris1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(lblJumlah))
                    .addGroup(baris1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(tfJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );

        baris2.setOpaque(false);
        baris2.setLayout(new java.awt.FlowLayout(0, 10, 0));

        lblNamaPembeli.setText("Nama pembeli (opsional)");
        lblNamaPembeli.setFont(Theme.font(java.awt.Font.BOLD, 15));
        lblNamaPembeli.setForeground(Theme.TEXT_DARK);
        baris2.add(lblNamaPembeli);

        tfNamaPembeli.setPreferredSize(new java.awt.Dimension(280, 36));
        baris2.add(tfNamaPembeli);

        btnTambah.setText("Tambah");
        btnTambah.setPreferredSize(new java.awt.Dimension(110, 38));
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout formCardLayout = new javax.swing.GroupLayout(formCard);
        formCard.setLayout(formCardLayout);
        formCardLayout.setHorizontalGroup(
            formCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formCardLayout.createSequentialGroup()
                .addComponent(baris2, javax.swing.GroupLayout.PREFERRED_SIZE, 892, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(252, Short.MAX_VALUE))
            .addGroup(formCardLayout.createSequentialGroup()
                .addComponent(baris1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        formCardLayout.setVerticalGroup(
            formCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formCardLayout.createSequentialGroup()
                .addGroup(formCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(baris1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(baris2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        lblJudul.setFont(Theme.font(java.awt.Font.BOLD, 22));
        lblJudul.setForeground(Theme.TEXT);
        lblJudul.setText("Kasir Offline");

        btnKembali.setText("Kembali");
        btnKembali.setStyleName("ghost");
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelAtasLayout = new javax.swing.GroupLayout(panelAtas);
        panelAtas.setLayout(panelAtasLayout);
        panelAtasLayout.setHorizontalGroup(
            panelAtasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAtasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblJudul, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelAtasLayout.createSequentialGroup()
                .addComponent(formCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelAtasLayout.setVerticalGroup(
            panelAtasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAtasLayout.createSequentialGroup()
                .addGroup(panelAtasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblJudul, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(formCard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabelCard.setBackground(Theme.CARD);
        tabelCard.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 12, 10, 12));
        tabelCard.setRadius(18);

        scrollTabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        scrollTabel.setOpaque(false);

        tblKasir.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nama Produk", "Harga", "Ubah Jumlah", "Subtotal"
            }
        ));
        tblKasir.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblKasir.setFillsViewportHeight(true);
        tblKasir.setRowHeight(40);
        scrollTabel.setViewportView(tblKasir);

        javax.swing.GroupLayout tabelCardLayout = new javax.swing.GroupLayout(tabelCard);
        tabelCard.setLayout(tabelCardLayout);
        tabelCardLayout.setHorizontalGroup(
            tabelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabelCardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollTabel, javax.swing.GroupLayout.DEFAULT_SIZE, 1148, Short.MAX_VALUE)
                .addContainerGap())
        );
        tabelCardLayout.setVerticalGroup(
            tabelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollTabel)
        );

        footCard.setBackground(Theme.CARD);
        footCard.setBorder(javax.swing.BorderFactory.createEmptyBorder(14, 20, 14, 20));
        footCard.setRadius(18);
        footCard.setLayout(new java.awt.BorderLayout(18, 0));

        tot.setOpaque(false);
        tot.setLayout(new java.awt.FlowLayout(0, 8, 0));

        lblTotalK.setText("Total belanja:");
        lblTotalK.setFont(Theme.font(java.awt.Font.BOLD, 15));
        lblTotalK.setForeground(Theme.TEXT_DARK);
        tot.add(lblTotalK);

        lblTotal.setText("Rp 0");
        lblTotal.setFont(Theme.font(java.awt.Font.BOLD, 20));
        lblTotal.setForeground(Theme.NAVY);
        tot.add(lblTotal);

        footCard.add(tot, java.awt.BorderLayout.WEST);

        kanan.setOpaque(false);
        kanan.setLayout(new java.awt.FlowLayout(2, 10, 0));

        btnBayar.setText("Bayar");
        btnBayar.setStyleName("success");
        btnBayar.setPreferredSize(new java.awt.Dimension(140, 42));
        btnBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBayarActionPerformed(evt);
            }
        });
        kanan.add(btnBayar);

        footCard.add(kanan, java.awt.BorderLayout.EAST);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(footCard, javax.swing.GroupLayout.PREFERRED_SIZE, 1103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelAtas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tabelCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelAtas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(tabelCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 323, Short.MAX_VALUE)
                .addComponent(footCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {
        nav.keBeranda(); // kembali ke beranda petugas
    }

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {
        tambahProduk(); // validasi form lalu tambah ke tabel belanja
    }

    private void tfIdProdukActionPerformed(java.awt.event.ActionEvent evt) {
        tambahProduk(); // tombol Enter pada kolom ID Produk
    }

    private void tfJumlahActionPerformed(java.awt.event.ActionEvent evt) {
        tambahProduk(); // tombol Enter pada kolom Jumlah
    }

    private void btnBayarActionPerformed(java.awt.event.ActionEvent evt) {
        bayar(); // pop up ringkasan pembelian
    }

    private void siapkanTabel() {
        UIs.styleTable(tblKasir);
        tblKasir.setRowHeight(40);
        model = (DefaultTableModel) tblKasir.getModel();
        int[] lebarKolom = {90, 280, 130, 160, 140};
        for (int i = 0; i < lebarKolom.length && i < tblKasir.getColumnCount(); i++) {
            tblKasir.getColumnModel().getColumn(i).setPreferredWidth(lebarKolom[i]);
        }

        tblKasir.getColumnModel().getColumn(KOLOM_JUMLAH).setCellRenderer((t, value, isSelected, hasFocus, row, column) -> {
            JPanel p = new JPanel(new FlowLayout(FlowLayout.CENTER, 3, 0)) {
                @Override
                protected void paintComponent(Graphics g) {
                    g.setColor(isSelected ? Theme.BLUE_LIGHT : Color.WHITE);
                    g.fillRect(0, 0, getWidth(), getHeight());
                }
            };
            p.setOpaque(false);
            int modelRow = tblKasir.convertRowIndexToModel(row);
            if (items.isEmpty() || modelRow < 0 || modelRow >= items.size()) {
                return p;
            }
            KasirItem item = items.get(modelRow);
            p.add(tombolMini("\u2212"));
            JLabel l = new JLabel(String.valueOf(item.jumlah));
            l.setFont(Theme.font(Font.BOLD, 14f));
            l.setPreferredSize(new Dimension(34, 24));
            l.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            p.add(l);
            p.add(tombolMini("+"));
            return p;
        });

        DefaultTableCellRenderer kanan2 = new DefaultTableCellRenderer();
        kanan2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tblKasir.getColumnModel().getColumn(2).setCellRenderer(kanan2);
        tblKasir.getColumnModel().getColumn(4).setCellRenderer(kanan2);
    }

    private JButton tombolMini(String teks) {
        JButton b = new JButton(teks) {
            @Override
            protected void paintComponent(Graphics g) {
                java.awt.Graphics2D g2 = (java.awt.Graphics2D) g.create();
                g2.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING,
                        java.awt.RenderingHints.VALUE_ANTIALIAS_ON);
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
        tblKasir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int kolom = tblKasir.columnAtPoint(e.getPoint());
                int barisTampil = tblKasir.rowAtPoint(e.getPoint());
                if (barisTampil < 0 || kolom != KOLOM_JUMLAH) {
                    return;
                }
                int baris = tblKasir.convertRowIndexToModel(barisTampil);
                if (baris < 0 || baris >= items.size()) {
                    return;
                }
                KasirItem item = items.get(baris);
                java.awt.Rectangle sel = tblKasir.getCellRect(barisTampil, kolom, false);
                double relatif = (e.getPoint().x - sel.x) / (double) sel.width;
                int arah = relatif < 0.36 ? -1 : (relatif > 0.64 ? +1 : 0);
                if (arah != 0) {
                    ubahJumlah(item, arah);
                } else {
                    inputJumlah(item);
                }
            }
        });
        tblKasir.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                int kolom = tblKasir.columnAtPoint(e.getPoint());
                tblKasir.setCursor(kolom == KOLOM_JUMLAH
                        ? Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)
                        : Cursor.getDefaultCursor());
            }
        });
    }

    public void muatUlang() {
        items.clear();
        tfIdProduk.setText("");
        tfJumlah.setText("");
        tfNamaPembeli.setText("");
        muatTabel();
    }

    private void muatTabel() {
        model.setRowCount(0);
        for (KasirItem i : items) {
            model.addRow(new Object[]{i.idProduk, i.nama, UIs.money(i.harga), "", UIs.money(i.subtotal())});
        }
        lblTotal.setText(UIs.money(ctl.totalBelanja(items)));
    }

    private void tambahProduk() {
        var hasil = ctl.tambahItem(items, tfIdProduk.getText(), tfJumlah.getText());
        if (!hasil.sukses()) {
            UIs.error(this, hasil.pesan()); // pesan error sesuai kesalahannya
            return;
        }
        
        KasirItem baru = hasil.item();
        var ada = items.stream().filter(i -> i.idProduk.equals(baru.idProduk)).findFirst();
        if (ada.isPresent()) {
            KasirItem i = ada.get();
            i.jumlah += baru.jumlah;
        } else {
            items.add(baru);
        }
        tfIdProduk.setText("");
        tfJumlah.setText("");
        tfIdProduk.requestFocusInWindow();
        muatTabel();
    }

    private void ubahJumlah(KasirItem item, int arah) {
        String pesan = ctl.ubahJumlah(items, item, item.jumlah + arah);
        if (!pesan.startsWith("Berhasil") && !pesan.startsWith("Item dihapus")) {
            UIs.error(this, pesan);
        }
        muatTabel();
    }

    private void inputJumlah(KasirItem item) {
        JTextField input = UIs.textField();
        input.setText(String.valueOf(item.jumlah));
        Object[] pesan = {"Jumlah baru untuk " + item.nama + ":", input};
        int ok = javax.swing.JOptionPane.showConfirmDialog(this, pesan, "Ubah Jumlah",
                javax.swing.JOptionPane.OK_CANCEL_OPTION, javax.swing.JOptionPane.PLAIN_MESSAGE);
        if (ok == javax.swing.JOptionPane.OK_OPTION) {
            try {
                int n = Integer.parseInt(input.getText().trim());
                String pesan2 = ctl.ubahJumlah(items, item, n);
                if (pesan2.startsWith("Berhasil") || pesan2.startsWith("Item dihapus")) {
                    UIs.info(this, "Berhasil merubah data produk");
                } else {
                    UIs.error(this, pesan2);
                }
                muatTabel();
            } catch (NumberFormatException ex) {
                UIs.error(this, "Jumlah harus berupa angka bulat.");
            }
        }
    }

    private void bayar() {
        if (items.isEmpty()) {
            UIs.error(this, "Belum ada produk yang diinput.");
            return;
        }
        new RingkasanBayarDialog().setVisible(true);
    }


    private class RingkasanBayarDialog extends javax.swing.JDialog {

        private RingkasanBayarDialog() {
            super(javax.swing.SwingUtilities.getWindowAncestor(KasirPanel.this), "Ringkasan Pembelian",
                    java.awt.Dialog.ModalityType.APPLICATION_MODAL);
            setLayout(new java.awt.BorderLayout());
            getContentPane().setBackground(Theme.PAGE_BG);

            JPanel card = UIs.card(16);
            card.setLayout(new java.awt.BorderLayout(0, 14));
            card.setBorder(BorderFactory.createEmptyBorder(24, 28, 24, 28));

            JLabel judul = new JLabel("Ringkasan Pembelian");
            judul.setFont(Theme.h2());
            card.add(judul, java.awt.BorderLayout.NORTH);

            JPanel isi = new JPanel();
            isi.setOpaque(false);
            isi.setLayout(new javax.swing.BoxLayout(isi, javax.swing.BoxLayout.Y_AXIS));
            for (KasirItem i : items) {
                JLabel l = new JLabel(i.nama + "  (" + i.jumlah + "x)  -  " + UIs.money(i.subtotal()));
                l.setFont(Theme.body());
                l.setBorder(BorderFactory.createEmptyBorder(2, 0, 2, 0));
                isi.add(l);
            }
            JLabel tot = new JLabel("Total: " + UIs.money(ctl.totalBelanja(items)));
            tot.setFont(Theme.font(Font.BOLD, 16f));
            tot.setForeground(Theme.NAVY);
            tot.setBorder(BorderFactory.createEmptyBorder(8, 0, 0, 0));
            isi.add(tot);
            card.add(isi, java.awt.BorderLayout.CENTER);

            JPanel tombol = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
            tombol.setOpaque(false);
            var btnBatal = UIs.button("Batal", UIs.Btn.GHOST);
            btnBatal.addActionListener(e -> dispose());
            var btnTunai = UIs.button("Tunai", UIs.Btn.SUCCESS);
            btnTunai.addActionListener(e -> bayarTunai());
            var btnEwallet = UIs.button("E-Wallet", UIs.Btn.PRIMARY);
            btnEwallet.addActionListener(e -> tanyaDigital("E-Wallet"));
            var btnMbangking = UIs.button("M-Bangking", UIs.Btn.SECONDARY);
            btnMbangking.addActionListener(e -> tanyaDigital("M-Bangking"));
            tombol.add(btnBatal);
            tombol.add(btnTunai);
            tombol.add(btnEwallet);
            tombol.add(btnMbangking);
            card.add(tombol, java.awt.BorderLayout.SOUTH);

            add(card, java.awt.BorderLayout.CENTER);
            pack();
            setLocationRelativeTo(KasirPanel.this);
        }

        private void tanyaDigital(String metode) {
            Object[] opsi = {"Pembayaran " + metode + " berhasil?"};
            int pilih = javax.swing.JOptionPane.showOptionDialog(RingkasanBayarDialog.this, opsi,
                    "Konfirmasi " + metode, javax.swing.JOptionPane.YES_NO_OPTION,
                    javax.swing.JOptionPane.QUESTION_MESSAGE, null,
                    new String[]{"Iya", "Tidak"}, "Iya");
            if (pilih != 0) {
                UIs.info(RingkasanBayarDialog.this, "pembayaran dibatalkan");
                return;
            }
            try {
                String pesan = ctl.bayarDigital(items, tfNamaPembeli.getText(), username, metode);
                selesai(pesan);
            } catch (RuntimeException ex) {
                UIs.error(RingkasanBayarDialog.this, ex.getMessage());
            }
        }

        private void bayarTunai() {
            double total = ctl.totalBelanja(items);
            JTextField tfUang = UIs.textField();
            JLabel lblKembalian = new JLabel("-");
            lblKembalian.setFont(Theme.h3());
            lblKembalian.setForeground(Theme.NAVY);
            tfUang.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
                public void insertUpdate(javax.swing.event.DocumentEvent e) {
                    hitung();
                }

                public void removeUpdate(javax.swing.event.DocumentEvent e) {
                    hitung();
                }

                public void changedUpdate(javax.swing.event.DocumentEvent e) {
                    hitung();
                }

                private void hitung() {
                    try {
                        double uang = Double.parseDouble(tfUang.getText().trim().replace(",", "."));
                        double kembali = uang - total;
                        lblKembalian.setText(UIs.money(Math.max(0, kembali)));
                        lblKembalian.setForeground(kembali < 0 ? new Color(0xB9, 0x1C, 0x1C) : Theme.NAVY);
                    } catch (NumberFormatException ex) {
                        lblKembalian.setText("-");
                    }
                }
            });

            JPanel panel = new JPanel(new java.awt.GridBagLayout());
            panel.setOpaque(false);
            java.awt.GridBagConstraints g = new java.awt.GridBagConstraints();
            g.gridx = 0;
            g.gridy = 0;
            g.anchor = java.awt.GridBagConstraints.WEST;
            g.insets = new java.awt.Insets(6, 4, 6, 12);
            panel.add(new JLabel("Total bayar:"), g);
            g.gridx = 1;
            JLabel t = new JLabel(UIs.money(total));
            t.setFont(Theme.font(Font.BOLD, 16f));
            panel.add(t, g);
            g.gridx = 0;
            g.gridy = 1;
            panel.add(new JLabel("Uang pelanggan:"), g);
            g.gridx = 1;
            tfUang.setPreferredSize(new Dimension(200, 34));
            panel.add(tfUang, g);
            g.gridx = 0;
            g.gridy = 2;
            panel.add(new JLabel("Uang kembalian:"), g);
            g.gridx = 1;
            panel.add(lblKembalian, g);

            Object[] pesan = {panel};
            int ok = javax.swing.JOptionPane.showConfirmDialog(RingkasanBayarDialog.this, pesan,
                    "Pembayaran Tunai", javax.swing.JOptionPane.OK_CANCEL_OPTION,
                    javax.swing.JOptionPane.PLAIN_MESSAGE);
            if (ok != javax.swing.JOptionPane.OK_OPTION) {
                return;
            }
            double uang;
            try {
                uang = Double.parseDouble(tfUang.getText().trim().replace(",", "."));
            } catch (NumberFormatException ex) {
                UIs.error(RingkasanBayarDialog.this, "Uang pelanggan harus berupa angka.");
                return;
            }
            try {
                String hasil = ctl.bayarTunai(items, uang, tfNamaPembeli.getText(), username);
                if (!hasil.equals("transaksi selesai")) {
                    UIs.error(RingkasanBayarDialog.this, hasil);
                    return;
                }
                selesai(hasil);
            } catch (RuntimeException ex) {
                UIs.error(RingkasanBayarDialog.this, ex.getMessage());
            }
        }

        private void selesai(String pesan) {
            UIs.info(KasirPanel.this, pesan); 
            dispose();
            muatUlang();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel baris1;
    private javax.swing.JPanel baris2;
    private com.pocketly.component.RoundButton btnBayar;
    private com.pocketly.component.RoundButton btnKembali;
    private com.pocketly.component.RoundButton btnTambah;
    private com.pocketly.component.RoundPanel footCard;
    private com.pocketly.component.RoundPanel formCard;
    private javax.swing.JPanel kanan;
    private javax.swing.JLabel lblIdProduk;
    private javax.swing.JLabel lblJudul;
    private javax.swing.JLabel lblJumlah;
    private javax.swing.JLabel lblNamaPembeli;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblTotalK;
    private javax.swing.JPanel panelAtas;
    private javax.swing.JScrollPane scrollTabel;
    private com.pocketly.component.RoundPanel tabelCard;
    private javax.swing.JTable tblKasir;
    private com.pocketly.component.RoundTextField tfIdProduk;
    private com.pocketly.component.RoundTextField tfJumlah;
    private com.pocketly.component.RoundTextField tfNamaPembeli;
    private javax.swing.JPanel tot;
    // End of variables declaration//GEN-END:variables
}
