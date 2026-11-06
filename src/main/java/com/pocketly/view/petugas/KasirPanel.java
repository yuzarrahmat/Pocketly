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

/**
 * Kasir offline: input produk, tabel belanja dengan tombol +/- jumlah
 * (klik ditangani MouseListener tabel sehingga benar-benar berfungsi),
 * lalu pembayaran Tunai / E-Wallet / M-Bangking.
 * Form NetBeans GUI Builder - buka KasirPanel.form di tab Design.
 */
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

    /** Konstruktor kosong untuk kompatibilitas. */
    public KasirPanel() {
        this(null, null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        panelAtas = new javax.swing.JPanel();
        judulBaris = new javax.swing.JPanel();
        lblJudul = new javax.swing.JLabel();
        btnKembali = new com.pocketly.component.RoundButton();
        formCard = new com.pocketly.component.RoundPanel();
        baris1 = new javax.swing.JPanel();
        lblIdProduk = new javax.swing.JLabel();
        tfIdProduk = new com.pocketly.component.RoundTextField();
        lblJumlah = new javax.swing.JLabel();
        tfJumlah = new com.pocketly.component.RoundTextField();
        btnTambah = new com.pocketly.component.RoundButton();
        baris2 = new javax.swing.JPanel();
        lblNamaPembeli = new javax.swing.JLabel();
        tfNamaPembeli = new com.pocketly.component.RoundTextField();
        tabelCard = new com.pocketly.component.RoundPanel();
        scrollTabel = new javax.swing.JScrollPane();
        tblKasir = new javax.swing.JTable();
        footCard = new com.pocketly.component.RoundPanel();
        tot = new javax.swing.JPanel();
        lblTotalK = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        kanan = new javax.swing.JPanel();
        btnBayar = new com.pocketly.component.RoundButton();

        setOpaque(false);
        setBorder(javax.swing.BorderFactory.createEmptyBorder(22, 26, 22, 26));
        this.setLayout(new java.awt.BorderLayout(0, 12));
        panelAtas.setOpaque(false);
        panelAtas.setLayout(new java.awt.BorderLayout(0, 12));
        judulBaris.setOpaque(false);
        judulBaris.setLayout(new java.awt.BorderLayout(0, 0));
        lblJudul.setText("Kasir Offline");
        lblJudul.setFont(Theme.font(java.awt.Font.BOLD, 22));
        lblJudul.setForeground(Theme.TEXT);
        btnKembali.setText("Kembali");
        btnKembali.setStyleName("ghost");
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });
        judulBaris.add(lblJudul, java.awt.BorderLayout.WEST);
        judulBaris.add(btnKembali, java.awt.BorderLayout.EAST);
        formCard.setBackground(Theme.CARD);
        formCard.setRadius(18);
        formCard.setBorder(javax.swing.BorderFactory.createEmptyBorder(14, 18, 14, 18));
        formCard.setLayout(new java.awt.BorderLayout(0, 10));
        baris1.setOpaque(false);
        baris1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 0));
        lblIdProduk.setText("ID Produk");
        lblIdProduk.setFont(Theme.font(java.awt.Font.BOLD, 15));
        lblIdProduk.setForeground(Theme.TEXT_DARK);
        tfIdProduk.setPreferredSize(new java.awt.Dimension(140, 36));
        tfIdProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIdProdukActionPerformed(evt);
            }
        });
        lblJumlah.setText("Jumlah");
        lblJumlah.setFont(Theme.font(java.awt.Font.BOLD, 15));
        lblJumlah.setForeground(Theme.TEXT_DARK);
        tfJumlah.setPreferredSize(new java.awt.Dimension(90, 36));
        tfJumlah.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tfJumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfJumlahActionPerformed(evt);
            }
        });
        btnTambah.setText("Tambah");
        btnTambah.setStyleName("primary");
        btnTambah.setPreferredSize(new java.awt.Dimension(110, 38));
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });
        baris1.add(lblIdProduk);
        baris1.add(tfIdProduk);
        baris1.add(lblJumlah);
        baris1.add(tfJumlah);
        baris1.add(btnTambah);
        baris2.setOpaque(false);
        baris2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 0));
        lblNamaPembeli.setText("Nama pembeli (opsional)");
        lblNamaPembeli.setFont(Theme.font(java.awt.Font.BOLD, 15));
        lblNamaPembeli.setForeground(Theme.TEXT_DARK);
        tfNamaPembeli.setPreferredSize(new java.awt.Dimension(280, 36));
        baris2.add(lblNamaPembeli);
        baris2.add(tfNamaPembeli);
        formCard.add(baris1, java.awt.BorderLayout.NORTH);
        formCard.add(baris2, java.awt.BorderLayout.SOUTH);
        panelAtas.add(judulBaris, java.awt.BorderLayout.NORTH);
        panelAtas.add(formCard, java.awt.BorderLayout.CENTER);
        tabelCard.setBackground(Theme.CARD);
        tabelCard.setRadius(18);
        tabelCard.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 12, 10, 12));
        tabelCard.setLayout(new java.awt.BorderLayout(0, 0));
        scrollTabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        scrollTabel.setOpaque(false);
        tblKasir.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {null, null, null, null, null}
                },
                new String [] { "ID", "Nama Produk", "Harga", "Ubah Jumlah", "Subtotal" }
              ) {
                boolean[] canEdit = new boolean [] { false, false, false, false, false };
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
              });
        tblKasir.setRowHeight(40);
        tblKasir.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblKasir.setFillsViewportHeight(true);
        scrollTabel.setViewportView(tblKasir);
        tabelCard.add(scrollTabel, java.awt.BorderLayout.CENTER);
        footCard.setBackground(Theme.CARD);
        footCard.setRadius(18);
        footCard.setBorder(javax.swing.BorderFactory.createEmptyBorder(14, 20, 14, 20));
        footCard.setLayout(new java.awt.BorderLayout(18, 0));
        tot.setOpaque(false);
        tot.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 8, 0));
        lblTotalK.setText("Total belanja:");
        lblTotalK.setFont(Theme.font(java.awt.Font.BOLD, 15));
        lblTotalK.setForeground(Theme.TEXT_DARK);
        lblTotal.setText("Rp 0");
        lblTotal.setFont(Theme.font(java.awt.Font.BOLD, 20));
        lblTotal.setForeground(Theme.NAVY);
        tot.add(lblTotalK);
        tot.add(lblTotal);
        kanan.setOpaque(false);
        kanan.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 10, 0));
        btnBayar.setText("Bayar");
        btnBayar.setStyleName("success");
        btnBayar.setPreferredSize(new java.awt.Dimension(140, 42));
        btnBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBayarActionPerformed(evt);
            }
        });
        kanan.add(btnBayar);
        footCard.add(tot, java.awt.BorderLayout.WEST);
        footCard.add(kanan, java.awt.BorderLayout.EAST);
        this.add(panelAtas, java.awt.BorderLayout.NORTH);
        this.add(tabelCard, java.awt.BorderLayout.CENTER);
        this.add(footCard, java.awt.BorderLayout.SOUTH);
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

    /** Gaya tabel, lebar kolom, dan renderer kolom ubah jumlah [- jumlah +]. */
    private void siapkanTabel() {
        UIs.styleTable(tblKasir);
        tblKasir.setRowHeight(40);
        model = (DefaultTableModel) tblKasir.getModel();
        int[] lebarKolom = {90, 280, 130, 160, 140};
        for (int i = 0; i < lebarKolom.length && i < tblKasir.getColumnCount(); i++) {
            tblKasir.getColumnModel().getColumn(i).setPreferredWidth(lebarKolom[i]);
        }

        // kolom ubah jumlah: tampilan [- jumlah +]
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

    /** Gambar tombol mini untuk renderer (tanpa aksi). */
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

    /** Aksi klik pada kolom ubah jumlah: area kiri = kurang, kanan = tambah. */
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

    /** Validasi form lalu menambah produk ke tabel belanja (flowchart). */
    private void tambahProduk() {
        var hasil = ctl.tambahItem(items, tfIdProduk.getText(), tfJumlah.getText());
        if (!hasil.sukses()) {
            UIs.error(this, hasil.pesan()); // pesan error sesuai kesalahannya
            return;
        }
        // gabungkan bila produk sama
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

    /** Mengubah jumlah satu item lewat tombol +/- pada tabel. */
    private void ubahJumlah(KasirItem item, int arah) {
        String pesan = ctl.ubahJumlah(items, item, item.jumlah + arah);
        if (!pesan.startsWith("Berhasil") && !pesan.startsWith("Item dihapus")) {
            UIs.error(this, pesan); // "Stok tidak mencukupi"
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

    /** Tombol bayar -> pop up ringkasan pembelian + tombol pembayaran. */
    private void bayar() {
        if (items.isEmpty()) {
            UIs.error(this, "Belum ada produk yang diinput.");
            return;
        }
        new RingkasanBayarDialog().setVisible(true);
    }


    // ================= Dialog pembayaran =================

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

        /** Flowchart e-wallet/m-bangking: pop up "pembayaran berhasil?" tombol iya/tidak. */
        private void tanyaDigital(String metode) {
            Object[] opsi = {"Pembayaran " + metode + " berhasil?"};
            int pilih = javax.swing.JOptionPane.showOptionDialog(RingkasanBayarDialog.this, opsi,
                    "Konfirmasi " + metode, javax.swing.JOptionPane.YES_NO_OPTION,
                    javax.swing.JOptionPane.QUESTION_MESSAGE, null,
                    new String[]{"Iya", "Tidak"}, "Iya");
            if (pilih != 0) {
                // flowchart: tampilkan "pembayaran dibatalkan" -> kembali ke ringkasan
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

        /** Flowchart tunai: pop up total bayar, form uang pelanggan, uang kembalian. */
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

        /** Simpan -> tampilkan "transaksi selesai" -> kembali ke kasir kosong. */
        private void selesai(String pesan) {
            UIs.info(KasirPanel.this, pesan); // "transaksi selesai"
            dispose();
            muatUlang();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelAtas;
    private javax.swing.JPanel judulBaris;
    private javax.swing.JLabel lblJudul;
    private com.pocketly.component.RoundButton btnKembali;
    private com.pocketly.component.RoundPanel formCard;
    private javax.swing.JPanel baris1;
    private javax.swing.JLabel lblIdProduk;
    private com.pocketly.component.RoundTextField tfIdProduk;
    private javax.swing.JLabel lblJumlah;
    private com.pocketly.component.RoundTextField tfJumlah;
    private com.pocketly.component.RoundButton btnTambah;
    private javax.swing.JPanel baris2;
    private javax.swing.JLabel lblNamaPembeli;
    private com.pocketly.component.RoundTextField tfNamaPembeli;
    private com.pocketly.component.RoundPanel tabelCard;
    private javax.swing.JScrollPane scrollTabel;
    private javax.swing.JTable tblKasir;
    private com.pocketly.component.RoundPanel footCard;
    private javax.swing.JPanel tot;
    private javax.swing.JLabel lblTotalK;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JPanel kanan;
    private com.pocketly.component.RoundButton btnBayar;
    // End of variables declaration//GEN-END:variables
}
