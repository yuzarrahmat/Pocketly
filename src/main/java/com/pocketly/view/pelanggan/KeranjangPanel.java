package com.pocketly.view.pelanggan;

import com.pocketly.controller.KeranjangController;
import com.pocketly.dao.PelangganDAO;
import com.pocketly.model.KeranjangItem;
import com.pocketly.model.Pelanggan;
import com.pocketly.util.Theme;
import com.pocketly.util.UIs;
import java.awt.Dimension;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Halaman keranjang pelanggan sesuai desain Figma: kartu tipe pemesanan
 * dan alamat, daftar produk dengan tombol +/&#8722; dan hapus, rincian total,
 * lalu checkout (Cash / E-Wallet / M-Bangking).
 * Form NetBeans GUI Builder - buka KeranjangPanel.form di tab Design.
 */
public class KeranjangPanel extends javax.swing.JPanel {
    private final String username;
    private final PelangganNav nav;
    private final KeranjangController ctl = new KeranjangController();
    private final PelangganDAO pelangganDao = new PelangganDAO();

    private final List<KeranjangBaris> baris = new ArrayList<>();

    public KeranjangPanel(String username, PelangganNav nav) {
        this.username = username;
        this.nav = nav;
        initComponents();
        scrollDaftar.getViewport().setOpaque(false);
        scrollDaftar.getVerticalScrollBar().setUnitIncrement(18);
        scrollDaftar.getVerticalScrollBar().setPreferredSize(new Dimension(8, 0));
    }

    /** Konstruktor kosong untuk kompatibilitas. */
    public KeranjangPanel() {
        this(null, null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelAtas = new javax.swing.JPanel();
        lblJudul = new javax.swing.JLabel();
        strut1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 12), new java.awt.Dimension(0, 12), new java.awt.Dimension(32767, 12));
        info = new javax.swing.JPanel();
        kartuTipe = new com.pocketly.component.RoundPanel();
        lblIkonAntar = new javax.swing.JLabel();
        teksTipe = new javax.swing.JPanel();
        lblTipe = new javax.swing.JLabel();
        strutTipe = new javax.swing.Box.Filler(new java.awt.Dimension(0, 6), new java.awt.Dimension(0, 6), new java.awt.Dimension(32767, 6));
        barisTipe = new javax.swing.JPanel();
        cbTipe = new javax.swing.JComboBox();
        kartuAlamat = new com.pocketly.component.RoundPanel();
        lblIkonAlamat = new javax.swing.JLabel();
        teksAlamat = new javax.swing.JPanel();
        lblAlamat = new javax.swing.JLabel();
        strutAlamat = new javax.swing.Box.Filler(new java.awt.Dimension(0, 4), new java.awt.Dimension(0, 4), new java.awt.Dimension(32767, 4));
        lblAlamatTampil = new javax.swing.JLabel();
        strutAlamat2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 4), new java.awt.Dimension(0, 4), new java.awt.Dimension(32767, 4));
        btnUbahAlamat = new com.pocketly.component.RoundButton();
        scrollDaftar = new javax.swing.JScrollPane();
        pnlDaftar = new javax.swing.JPanel();
        footer = new com.pocketly.component.RoundPanel();
        rincian = new javax.swing.JPanel();
        barisSubtotal = new javax.swing.JPanel();
        lblbarisSubtotal = new javax.swing.JLabel();
        lblSubtotalV = new javax.swing.JLabel();
        barisOngkir = new javax.swing.JPanel();
        lblbarisOngkir = new javax.swing.JLabel();
        lblOngkirV = new javax.swing.JLabel();
        barisTotal = new javax.swing.JPanel();
        lblTotal = new javax.swing.JLabel();
        lblTotalV = new javax.swing.JLabel();
        aksi = new javax.swing.JPanel();
        btnTambahProduk = new com.pocketly.component.RoundButton();
        btnHapus = new com.pocketly.component.RoundButton();
        btnCheckout = new com.pocketly.component.RoundButton();

        setOpaque(false);
        setBorder(javax.swing.BorderFactory.createEmptyBorder(22, 26, 22, 26));
        setLayout(new java.awt.BorderLayout(0, 14));

        panelAtas.setOpaque(false);

        lblJudul.setFont(Theme.font(java.awt.Font.BOLD, 24));
        lblJudul.setForeground(Theme.TEXT);
        lblJudul.setText("Keranjang");

        info.setMaximumSize(new java.awt.Dimension(32767, 110));
        info.setOpaque(false);
        info.setLayout(new java.awt.GridLayout(1, 2, 14, 0));

        kartuTipe.setBackground(Theme.CARD);
        kartuTipe.setRadius(20);
        kartuTipe.setBorder(javax.swing.BorderFactory.createEmptyBorder(14, 16, 14, 16));
        kartuTipe.setLayout(new java.awt.BorderLayout(14, 0));

        lblIkonAntar.setIcon(UIs.asset("icon-antar.png", 44, 36));
        kartuTipe.add(lblIkonAntar);

        teksTipe.setOpaque(false);

        lblTipe.setFont(Theme.font(java.awt.Font.BOLD, 15));
        lblTipe.setForeground(Theme.NAVY);
        lblTipe.setText("Tipe Pemesanan");

        barisTipe.setOpaque(false);
        barisTipe.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 8, 0));

        cbTipe.setPreferredSize(new java.awt.Dimension(160, 34));
        cbTipe.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "- Pilih tipe -", "Pesan antar", "Pick up" }));
        cbTipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipeActionPerformed(evt);
            }
        });
        barisTipe.add(cbTipe);

        javax.swing.GroupLayout teksTipeLayout = new javax.swing.GroupLayout(teksTipe);
        teksTipe.setLayout(teksTipeLayout);
        teksTipeLayout.setHorizontalGroup(
            teksTipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(teksTipeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTipe))
            .addComponent(strutTipe, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(barisTipe, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        teksTipeLayout.setVerticalGroup(
            teksTipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(teksTipeLayout.createSequentialGroup()
                .addComponent(lblTipe)
                .addGap(0, 0, 0)
                .addComponent(strutTipe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(barisTipe, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        kartuTipe.add(teksTipe, java.awt.BorderLayout.CENTER);

        info.add(kartuTipe);

        kartuAlamat.setBackground(Theme.CARD);
        kartuAlamat.setRadius(20);
        kartuAlamat.setBorder(javax.swing.BorderFactory.createEmptyBorder(14, 16, 14, 16));
        kartuAlamat.setLayout(new java.awt.BorderLayout(14, 0));

        lblIkonAlamat.setIcon(UIs.asset("icon-alamat.png", 34, 40));
        kartuAlamat.add(lblIkonAlamat);

        teksAlamat.setOpaque(false);
        teksAlamat.setLayout(new javax.swing.BoxLayout(teksAlamat, javax.swing.BoxLayout.PAGE_AXIS));

        lblAlamat.setText("Alamat Pengiriman");
        lblAlamat.setFont(Theme.font(java.awt.Font.BOLD, 15));
        lblAlamat.setForeground(Theme.NAVY);
        teksAlamat.add(lblAlamat);
        teksAlamat.add(strutAlamat);

        lblAlamatTampil.setText("-");
        lblAlamatTampil.setFont(Theme.font(java.awt.Font.PLAIN, 12));
        lblAlamatTampil.setForeground(Theme.TEXT);
        teksAlamat.add(lblAlamatTampil);
        teksAlamat.add(strutAlamat2);

        btnUbahAlamat.setText("Ubah Alamat");
        btnUbahAlamat.setStyleName("ghost");
        btnUbahAlamat.setPreferredSize(new java.awt.Dimension(120, 32));
        btnUbahAlamat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahAlamatActionPerformed(evt);
            }
        });
        teksAlamat.add(btnUbahAlamat);

        kartuAlamat.add(teksAlamat, java.awt.BorderLayout.CENTER);

        info.add(kartuAlamat);

        javax.swing.GroupLayout panelAtasLayout = new javax.swing.GroupLayout(panelAtas);
        panelAtas.setLayout(panelAtasLayout);
        panelAtasLayout.setHorizontalGroup(
            panelAtasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAtasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblJudul))
            .addComponent(strut1, javax.swing.GroupLayout.PREFERRED_SIZE, 848, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(info, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        panelAtasLayout.setVerticalGroup(
            panelAtasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAtasLayout.createSequentialGroup()
                .addComponent(lblJudul)
                .addGap(0, 0, 0)
                .addComponent(strut1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(info, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(panelAtas, java.awt.BorderLayout.NORTH);

        scrollDaftar.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        scrollDaftar.setOpaque(false);

        pnlDaftar.setOpaque(false);
        pnlDaftar.setLayout(new javax.swing.BoxLayout(pnlDaftar, javax.swing.BoxLayout.PAGE_AXIS));
        scrollDaftar.setViewportView(pnlDaftar);

        add(scrollDaftar, java.awt.BorderLayout.CENTER);

        footer.setBackground(Theme.CARD);
        footer.setRadius(20);
        footer.setBorder(javax.swing.BorderFactory.createEmptyBorder(14, 20, 14, 20));
        footer.setLayout(new java.awt.BorderLayout(18, 0));

        rincian.setOpaque(false);
        rincian.setLayout(new javax.swing.BoxLayout(rincian, javax.swing.BoxLayout.PAGE_AXIS));

        barisSubtotal.setOpaque(false);
        barisSubtotal.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 6, 2));

        lblbarisSubtotal.setText("Subtotal produk:");
        lblbarisSubtotal.setFont(Theme.font(java.awt.Font.PLAIN, 13));
        lblbarisSubtotal.setForeground(Theme.TEXT_MUTED);
        barisSubtotal.add(lblbarisSubtotal);

        lblSubtotalV.setText("Rp 0");
        lblSubtotalV.setFont(Theme.font(java.awt.Font.PLAIN, 13));
        lblSubtotalV.setForeground(Theme.TEXT);
        barisSubtotal.add(lblSubtotalV);

        rincian.add(barisSubtotal);

        barisOngkir.setOpaque(false);
        barisOngkir.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 6, 2));

        lblbarisOngkir.setText("Biaya pengiriman:");
        lblbarisOngkir.setFont(Theme.font(java.awt.Font.PLAIN, 13));
        lblbarisOngkir.setForeground(Theme.TEXT_MUTED);
        barisOngkir.add(lblbarisOngkir);

        lblOngkirV.setText("-");
        lblOngkirV.setFont(Theme.font(java.awt.Font.PLAIN, 13));
        lblOngkirV.setForeground(Theme.TEXT);
        barisOngkir.add(lblOngkirV);

        rincian.add(barisOngkir);

        barisTotal.setOpaque(false);
        barisTotal.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 6, 2));

        lblTotal.setText("Total bayar: ");
        lblTotal.setFont(Theme.font(java.awt.Font.BOLD, 18));
        lblTotal.setForeground(Theme.NAVY);
        barisTotal.add(lblTotal);

        lblTotalV.setText("Rp 0");
        lblTotalV.setFont(Theme.font(java.awt.Font.BOLD, 18));
        lblTotalV.setForeground(Theme.NAVY);
        barisTotal.add(lblTotalV);

        rincian.add(barisTotal);

        footer.add(rincian, java.awt.BorderLayout.WEST);

        aksi.setOpaque(false);
        aksi.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 10, 0));

        btnTambahProduk.setText("+ Tambah Produk");
        btnTambahProduk.setStyleName("ghost");
        btnTambahProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahProdukActionPerformed(evt);
            }
        });
        aksi.add(btnTambahProduk);

        btnHapus.setText("Hapus Terpilih");
        btnHapus.setStyleName("dangerSoft");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        aksi.add(btnHapus);

        btnCheckout.setText("Checkout");
        btnCheckout.setStyleName("action");
        btnCheckout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckoutActionPerformed(evt);
            }
        });
        aksi.add(btnCheckout);

        footer.add(aksi, java.awt.BorderLayout.EAST);

        add(footer, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void cbTipeActionPerformed(java.awt.event.ActionEvent evt) {
        hitungTotal(); // ongkir dan total berubah sesuai tipe pemesanan
    }

    private void btnUbahAlamatActionPerformed(java.awt.event.ActionEvent evt) {
        ubahAlamat();
    }

    private void btnTambahProdukActionPerformed(java.awt.event.ActionEvent evt) {
        nav.keBeranda(); // kembali mencari produk
    }

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {
        hapusTerpilih();
    }

    private void btnCheckoutActionPerformed(java.awt.event.ActionEvent evt) {
        checkout();
    }

    /** Dimuat setiap kali halaman dibuka. */
    public void muatUlang() {
        List<KeranjangItem> items = ctl.isiKeranjang(username);

        Pelanggan p = pelangganDao.getByUsername(username);
        lblAlamatTampil.setText(p != null && p.alamat != null ? p.alamat : "-");

        // flowchart: keranjang kosong -> notifikasi -> kembali ke beranda
        if (items.isEmpty()) {
            nav.perbaruiBadgeKeranjang();
            UIs.info(this, "Keranjang belanjamu masih kosong");
            nav.keBeranda();
            return;
        }
        nav.perbaruiBadgeKeranjang();

        // tipe pemesanan tersimpan; bila belum pernah dipilih tetap kosong
        String tipe = ctl.tipePemesanan(username);
        cbTipe.setSelectedItem(tipe == null ? "- Pilih tipe -" : tipe);

        pnlDaftar.removeAll();
        baris.clear();
        for (KeranjangItem item : items) {
            KeranjangBaris b = new KeranjangBaris(item);
            baris.add(b);
            pnlDaftar.add(b);
            pnlDaftar.add(Box.createVerticalStrut(10));
        }
        hitungTotal();
        pnlDaftar.revalidate();
        pnlDaftar.repaint();
    }

    private List<KeranjangItem> terpilih() {
        List<KeranjangItem> list = new ArrayList<>();
        for (KeranjangBaris b : baris) {
            if (b.chk.isSelected()) {
                list.add(b.item);
            }
        }
        return list;
    }

    /** Tipe pemesanan terpilih pada dropdown; null bila masih kosong. */
    private String tipeTerpilih() {
        Object v = cbTipe.getSelectedItem();
        return v == null || v.toString().isBlank() || v.toString().startsWith("-") ? null : v.toString();
    }

    private void hitungTotal() {
        List<KeranjangItem> pilih = terpilih();
        double subtotal = ctl.subtotal(pilih);
        if (tipeTerpilih() == null) {
            lblSubtotalV.setText(UIs.money(subtotal));
            lblOngkirV.setText("-");
            lblTotalV.setText("-");
        } else {
            double ongkir = pilih.isEmpty() ? 0 : ctl.ongkir(tipeTerpilih());
            lblSubtotalV.setText(UIs.money(subtotal));
            lblOngkirV.setText(UIs.money(ongkir));
            lblTotalV.setText(UIs.money(subtotal + ongkir));
        }
    }

    private void ubahAlamat() {
        JTextField input = UIs.textField();
        Pelanggan p = pelangganDao.getByUsername(username);
        if (p != null) {
            input.setText(p.alamat == null ? "" : p.alamat);
        }
        Object[] pesan = {"Alamat baru:", input};
        int ok = JOptionPane.showConfirmDialog(this, pesan, "Ubah Alamat",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (ok == JOptionPane.OK_OPTION && !input.getText().isBlank()) {
            try {
                ctl.simpanAlamatBaru(username, input.getText().trim());
                UIs.info(this, "Alamat berhasil diperbarui.");
                muatUlang();
            } catch (RuntimeException ex) {
                UIs.error(this, ex.getMessage());
            }
        }
    }

    private void hapusTerpilih() {
        List<KeranjangItem> pilih = terpilih();
        if (pilih.isEmpty()) {
            UIs.error(this, "Centang dulu produk yang ingin dihapus.");
            return;
        }
        // flowchart: pop up konfirmasi -> konfirmasi -> hapus
        if (!UIs.confirm(this, "Hapus " + pilih.size() + " produk dari keranjang?")) {
            return;
        }
        try {
            for (KeranjangItem item : pilih) {
                ctl.hapusItem(item);
            }
            UIs.info(this, "Produk dihapus dari Keranjang");
            muatUlang();
        } catch (RuntimeException ex) {
            UIs.error(this, ex.getMessage());
        }
    }

    private void checkout() {
        List<KeranjangItem> pilih = terpilih();
        if (pilih.isEmpty()) {
            UIs.error(this, "Centang dulu produk yang ingin di-checkout.");
            return;
        }
        String tipe = tipeTerpilih();
        if (tipe == null) {
            UIs.error(this, "Pilih tipe pemesanan (Pesan antar / Pick up) terlebih dahulu.");
            return;
        }
        // simpan pilihan tipe agar tersimpan di database
        ctl.simpanTipePemesanan(username, tipe);
        new PilihPembayaranDialog(tipe, pilih).setVisible(true);
    }


    // ================= Dialog pilihan pembayaran =================

    /** Flowchart: "Tampilan pilihan pembayaran cash atau e-wallet". */
    private class PilihPembayaranDialog extends javax.swing.JDialog {

        private final String tipe;
        private final List<KeranjangItem> items;

        private PilihPembayaranDialog(String tipe, List<KeranjangItem> items) {
            super(javax.swing.SwingUtilities.getWindowAncestor(KeranjangPanel.this), "Pembayaran",
                    ModalityType.APPLICATION_MODAL);
            this.tipe = tipe;
            this.items = items;
            setLayout(new java.awt.BorderLayout());
            getContentPane().setBackground(Theme.PAGE_BG);

            JPanel card = UIs.card(16);
            card.setLayout(new java.awt.BorderLayout(0, 16));
            card.setBorder(BorderFactory.createEmptyBorder(28, 32, 28, 32));

            JLabel judul = new JLabel("Pilih metode pembayaran");
            judul.setFont(Theme.h2());
            judul.setForeground(Theme.TEXT);
            card.add(judul, java.awt.BorderLayout.NORTH);

            JPanel ringkasan = new JPanel();
            ringkasan.setOpaque(false);
            ringkasan.setLayout(new javax.swing.BoxLayout(ringkasan, javax.swing.BoxLayout.Y_AXIS));
            ringkasan.add(rincinan("Tipe pemesanan", tipe));
            ringkasan.add(rincinan("Jumlah produk", items.size() + " produk"));
            ringkasan.add(rincinan("Subtotal", UIs.money(ctl.subtotal(items))));
            ringkasan.add(rincinan("Ongkir", UIs.money(ctl.ongkir(tipe))));
            JLabel tot = new JLabel(UIs.money(ctl.totalBayar(items, tipe)));
            tot.setFont(Theme.font(java.awt.Font.BOLD, 20f));
            tot.setForeground(Theme.NAVY);
            JPanel totP = new JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 6, 2));
            totP.setOpaque(false);
            JLabel tl = new JLabel("Total bayar:");
            tl.setFont(Theme.h3());
            totP.add(tl);
            totP.add(tot);
            ringkasan.add(totP);
            card.add(ringkasan, java.awt.BorderLayout.CENTER);

            JPanel tombol = new JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 10, 0));
            tombol.setOpaque(false);
            var btnCash = UIs.button("Cash (bayar di toko)", UIs.Btn.SUCCESS);
            btnCash.addActionListener(e -> bayarCash());
            var btnEwallet = UIs.button("E-Wallet", UIs.Btn.PRIMARY);
            btnEwallet.addActionListener(e -> bayarEwallet("E-Wallet"));
            var btnMbangking = UIs.button("M-Bangking", UIs.Btn.SECONDARY);
            btnMbangking.addActionListener(e -> bayarEwallet("M-Bangking"));
            var btnBatal = UIs.button("Batal", UIs.Btn.GHOST);
            btnBatal.addActionListener(e -> dispose());
            tombol.add(btnBatal);
            tombol.add(btnCash);
            tombol.add(btnEwallet);
            tombol.add(btnMbangking);
            card.add(tombol, java.awt.BorderLayout.SOUTH);

            add(card, java.awt.BorderLayout.CENTER);
            pack();
            setLocationRelativeTo(KeranjangPanel.this);
        }

        private JPanel rincinan(String k, String v) {
            JPanel p = new JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 6, 2));
            p.setOpaque(false);
            JLabel a = new JLabel(k + ":");
            a.setFont(Theme.body());
            a.setForeground(Theme.TEXT_MUTED);
            JLabel b = new JLabel(v);
            b.setFont(Theme.body());
            b.setForeground(Theme.TEXT);
            p.add(a);
            p.add(b);
            return p;
        }

        /** Flowchart: Cash -> tampilkan halaman kode transaksi -> kembali ke beranda. */
        private void bayarCash() {
            String kode = ctl.buatKodeCash();
            JPanel card = UIs.card(16);
            card.setLayout(new java.awt.BorderLayout(0, 14));
            card.setBorder(BorderFactory.createEmptyBorder(28, 32, 28, 32));

            JLabel judul = new JLabel("Pesanan dibuat!");
            judul.setFont(Theme.h2());
            card.add(judul, java.awt.BorderLayout.NORTH);

            JPanel isi = new JPanel();
            isi.setOpaque(false);
            isi.setLayout(new javax.swing.BoxLayout(isi, javax.swing.BoxLayout.Y_AXIS));
            JLabel lblKode = new JLabel("Kode Transaksi Anda:");
            lblKode.setFont(Theme.h3());
            isi.add(lblKode);
            JLabel kodeBesar = new JLabel(kode, JLabel.CENTER);
            kodeBesar.setFont(Theme.font(java.awt.Font.BOLD, 30f));
            kodeBesar.setForeground(Theme.BLUE);
            kodeBesar.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
            isi.add(kodeBesar);
            JLabel note = new JLabel("<html><div style='width:300px;text-align:center'>"
                    + "Tunjukkan kode ini ke kasir saat mengambil / membayar pesanan.<br>"
                    + "Pesanan berstatus <b>menunggu verifikasi</b> hingga pembayaran diterima.</div></html>");
            note.setFont(Theme.body());
            note.setForeground(Theme.TEXT_MUTED);
            note.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
            note.setBorder(BorderFactory.createEmptyBorder(6, 0, 0, 0));
            isi.add(note);
            card.add(isi, java.awt.BorderLayout.CENTER);

            var btnKembali = UIs.button("Kembali ke beranda", UIs.Btn.PRIMARY);
            btnKembali.addActionListener(e -> {
                try {
                    ctl.checkoutCash(username, items, tipe);
                    dispose();
                    UIs.info(KeranjangPanel.this, "Menunggu verifikasi");
                    nav.keBeranda();
                } catch (RuntimeException ex) {
                    UIs.error(KeranjangPanel.this, ex.getMessage());
                }
            });
            JPanel bwrap = new JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 0, 0));
            bwrap.setOpaque(false);
            bwrap.add(btnKembali);
            card.add(bwrap, java.awt.BorderLayout.SOUTH);

            setContentPane(wrapBg(card));
            pack();
            setLocationRelativeTo(KeranjangPanel.this);
        }

        /** E-Wallet / M-Bangking: unggah bukti transfer lalu konfirmasi. */
        private void bayarEwallet(String metode) {
            File[] bukti = {null};
            JLabel lblFile = new JLabel("Belum memilih file bukti pembayaran.");
            lblFile.setFont(Theme.small());
            lblFile.setForeground(Theme.TEXT_MUTED);

            JPanel card = UIs.card(16);
            card.setLayout(new java.awt.BorderLayout(0, 14));
            card.setBorder(BorderFactory.createEmptyBorder(28, 32, 28, 32));

            JLabel judul = new JLabel("Unggah bukti pembayaran " + metode);
            judul.setFont(Theme.h2());
            card.add(judul, java.awt.BorderLayout.NORTH);

            JPanel isi = new JPanel();
            isi.setOpaque(false);
            isi.setLayout(new javax.swing.BoxLayout(isi, javax.swing.BoxLayout.Y_AXIS));
            JLabel note = new JLabel("Transfer " + UIs.money(ctl.totalBayar(items, tipe))
                    + " ke " + (metode.equals("M-Bangking") ? "rekening bank toko" : "e-wallet toko")
                    + ", lalu unggah tangkapan layar buktinya.");
            note.setFont(Theme.body());
            note.setForeground(Theme.TEXT);
            note.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
            isi.add(note);
            isi.add(lblFile);
            card.add(isi, java.awt.BorderLayout.CENTER);

            JPanel tombol = new JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 10, 0));
            tombol.setOpaque(false);
            var btnPilih = UIs.button("Pilih File", UIs.Btn.SECONDARY);
            btnPilih.addActionListener(e -> {
                // JFileChooser: komponen bawaan Swing yang membuka
                // file manager sistem (tanpa library tambahan)
                JFileChooser fc = new JFileChooser();
                fc.setFileFilter(new FileNameExtensionFilter("Gambar (jpg, png, gif)", "jpg", "jpeg", "png", "gif"));
                if (fc.showOpenDialog(PilihPembayaranDialog.this) == JFileChooser.APPROVE_OPTION) {
                    bukti[0] = fc.getSelectedFile();
                    lblFile.setText("File dipilih: " + bukti[0].getName());
                }
            });
            var btnKonfirmasi = UIs.button("Konfirmasi", UIs.Btn.PRIMARY);
            btnKonfirmasi.addActionListener(e -> {
                if (bukti[0] == null) {
                    UIs.error(PilihPembayaranDialog.this, "Silakan unggah bukti pembayaran terlebih dahulu.");
                    return;
                }
                String idAcuan = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
                String err = ctl.checkoutEwallet(username, items, tipe, bukti[0], idAcuan, metode);
                if (err != null) {
                    UIs.error(PilihPembayaranDialog.this, err);
                    return;
                }
                dispose();
                UIs.info(KeranjangPanel.this, "Menunggu verifikasi");
                nav.keBeranda();
            });
            var btnBatal = UIs.button("Batal", UIs.Btn.GHOST);
            btnBatal.addActionListener(e -> dispose());
            tombol.add(btnBatal);
            tombol.add(btnPilih);
            tombol.add(btnKonfirmasi);
            card.add(tombol, java.awt.BorderLayout.SOUTH);

            setContentPane(wrapBg(card));
            pack();
            setLocationRelativeTo(KeranjangPanel.this);
        }

        private JPanel wrapBg(JPanel card) {
            JPanel bg = new JPanel(new java.awt.GridBagLayout()) {
                @Override
                protected void paintComponent(java.awt.Graphics g) {
                    super.paintComponent(g);
                    g.setColor(Theme.PAGE_BG);
                    g.fillRect(0, 0, getWidth(), getHeight());
                }
            };
            bg.setOpaque(false);
            bg.add(card);
            return bg;
        }
    }

    // ================= Satu baris item keranjang =================

    private class KeranjangBaris extends JPanel {

        private final KeranjangItem item;
        private final JCheckBox chk = new JCheckBox();
        private final JTextField tfJumlah = UIs.textField();

        private KeranjangBaris(KeranjangItem item) {
            this.item = item;
            setLayout(new java.awt.BorderLayout(14, 0));
            setOpaque(false);

            JPanel card = UIs.card(18);
            card.setLayout(new java.awt.BorderLayout(14, 0));
            card.setBorder(BorderFactory.createEmptyBorder(12, 14, 12, 14));

            // kiri: centang + gambar + nama produk
            JPanel kiri = new JPanel(new java.awt.BorderLayout(10, 0));
            kiri.setOpaque(false);
            chk.setOpaque(false);
            chk.setSelected(true); // tercentang awal agar subtotal langsung terhitung
            chk.addItemListener(e -> hitungTotal());
            kiri.add(chk, java.awt.BorderLayout.WEST);

            JPanel identitas = new JPanel(new java.awt.BorderLayout(10, 0));
            identitas.setOpaque(false);
            JLabel img = new JLabel(UIs.productImage(item.gambar, 64, 64));
            identitas.add(img, java.awt.BorderLayout.WEST);
            JPanel teks = new JPanel();
            teks.setOpaque(false);
            teks.setLayout(new javax.swing.BoxLayout(teks, javax.swing.BoxLayout.Y_AXIS));
            JLabel nama = new JLabel(item.namaProduk);
            nama.setFont(Theme.font(java.awt.Font.BOLD, 15f));
            nama.setForeground(Theme.NAVY);
            teks.add(nama);
            JLabel harga = new JLabel(UIs.money(item.hargaSatuan) + " / " + item.satuan);
            harga.setFont(Theme.small());
            harga.setForeground(Theme.TEXT_MUTED);
            teks.add(harga);
            identitas.add(teks, java.awt.BorderLayout.CENTER);
            kiri.add(identitas, java.awt.BorderLayout.CENTER);
            card.add(kiri, java.awt.BorderLayout.CENTER);

            // kanan: tombol - jumlah + , subtotal, hapus
            JPanel kanan = new JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 8, 0));
            kanan.setOpaque(false);

            var btnMinus = UIs.button("\u2212", UIs.Btn.NAVY);
            btnMinus.setPreferredSize(new Dimension(34, 34));
            btnMinus.setBorder(BorderFactory.createEmptyBorder());
            btnMinus.addActionListener(e -> ubahJumlah(item.jumlah - 1));
            tfJumlah.setPreferredSize(new Dimension(56, 34));
            tfJumlah.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            UIs.jadikanFieldKompak(tfJumlah);
            tfJumlah.setText(String.valueOf(item.jumlah));
            tfJumlah.addActionListener(e -> konfirmasiInput());
            var btnPlus = UIs.button("+", UIs.Btn.NAVY);
            btnPlus.setPreferredSize(new Dimension(34, 34));
            btnPlus.setBorder(BorderFactory.createEmptyBorder());
            btnPlus.addActionListener(e -> ubahJumlah(item.jumlah + 1));

            var btnOk = UIs.button("OK", UIs.Btn.SECONDARY);
            btnOk.setPreferredSize(new Dimension(58, 34));
            btnOk.addActionListener(e -> konfirmasiInput());

            var btnHapusBaris = UIs.button("Hapus", UIs.Btn.DANGER_SOFT);
            btnHapusBaris.setPreferredSize(new Dimension(92, 34));
            btnHapusBaris.addActionListener(e -> {
                if (UIs.confirm(KeranjangPanel.this, "Hapus produk ini dari keranjang?")) {
                    try {
                        ctl.hapusItem(item);
                        UIs.info(KeranjangPanel.this, "Produk dihapus dari Keranjang");
                        muatUlang();
                    } catch (RuntimeException ex) {
                        UIs.error(KeranjangPanel.this, ex.getMessage());
                    }
                }
            });

            kanan.add(btnMinus);
            kanan.add(tfJumlah);
            kanan.add(btnPlus);
            kanan.add(btnOk);
            JLabel sub = new JLabel(UIs.money(item.hargaSatuan * item.jumlah));
            sub.setFont(Theme.font(java.awt.Font.BOLD, 14f));
            sub.setForeground(Theme.NAVY);
            sub.setPreferredSize(new Dimension(110, 24));
            sub.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
            kanan.add(sub);
            kanan.add(btnHapusBaris);
            card.add(kanan, java.awt.BorderLayout.EAST);

            add(card, java.awt.BorderLayout.CENTER);
        }

        @Override
        public Dimension getMaximumSize() {
            return new Dimension(Integer.MAX_VALUE, getPreferredSize().height);
        }

        private void ubahJumlah(int baru) {
            String pesan = ctl.ubahJumlah(item, baru);
            if (pesan.startsWith("Berhasil") || pesan.startsWith("Produk dihapus")) {
                if (baru <= 0) {
                    UIs.info(KeranjangPanel.this, "Produk dihapus dari Keranjang");
                }
                muatUlang();
            } else {
                UIs.error(KeranjangPanel.this, pesan); // "Stok tidak mencukupi"
                tfJumlah.setText(String.valueOf(item.jumlah));
            }
        }

        private void konfirmasiInput() {
            int n;
            try {
                n = Integer.parseInt(tfJumlah.getText().trim());
            } catch (NumberFormatException ex) {
                UIs.error(KeranjangPanel.this, "Jumlah harus berupa angka bulat.");
                tfJumlah.setText(String.valueOf(item.jumlah));
                return;
            }
            ubahJumlah(n);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel aksi;
    private javax.swing.JPanel barisOngkir;
    private javax.swing.JPanel barisSubtotal;
    private javax.swing.JPanel barisTipe;
    private javax.swing.JPanel barisTotal;
    private com.pocketly.component.RoundButton btnCheckout;
    private com.pocketly.component.RoundButton btnHapus;
    private com.pocketly.component.RoundButton btnTambahProduk;
    private com.pocketly.component.RoundButton btnUbahAlamat;
    private javax.swing.JComboBox cbTipe;
    private com.pocketly.component.RoundPanel footer;
    private javax.swing.JPanel info;
    private com.pocketly.component.RoundPanel kartuAlamat;
    private com.pocketly.component.RoundPanel kartuTipe;
    private javax.swing.JLabel lblAlamat;
    private javax.swing.JLabel lblAlamatTampil;
    private javax.swing.JLabel lblIkonAlamat;
    private javax.swing.JLabel lblIkonAntar;
    private javax.swing.JLabel lblJudul;
    private javax.swing.JLabel lblOngkirV;
    private javax.swing.JLabel lblSubtotalV;
    private javax.swing.JLabel lblTipe;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblTotalV;
    private javax.swing.JLabel lblbarisOngkir;
    private javax.swing.JLabel lblbarisSubtotal;
    private javax.swing.JPanel panelAtas;
    private javax.swing.JPanel pnlDaftar;
    private javax.swing.JPanel rincian;
    private javax.swing.JScrollPane scrollDaftar;
    private javax.swing.Box.Filler strut1;
    private javax.swing.Box.Filler strutAlamat;
    private javax.swing.Box.Filler strutAlamat2;
    private javax.swing.Box.Filler strutTipe;
    private javax.swing.JPanel teksAlamat;
    private javax.swing.JPanel teksTipe;
    // End of variables declaration//GEN-END:variables
}
