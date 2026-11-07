package com.pocketly.view.pelanggan;

import com.pocketly.controller.RiwayatController;
import com.pocketly.model.DetailTransaksi;
import com.pocketly.model.OnlineOrder;
import com.pocketly.util.Theme;
import com.pocketly.util.UIs;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class TransaksiPanel extends javax.swing.JPanel {
    private final String username;
    private final PelangganNav nav;
    private final RiwayatController ctl = new RiwayatController();

    public TransaksiPanel(String username, PelangganNav nav) {
        this.username = username;
        this.nav = nav;
        initComponents();
        scrollDaftar.getViewport().setOpaque(false);
        scrollDaftar.getVerticalScrollBar().setUnitIncrement(18);
        scrollDaftar.getVerticalScrollBar().setPreferredSize(new Dimension(8, 0));
    }

    public TransaksiPanel() {
        this(null, null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblJudul = new javax.swing.JLabel();
        scrollDaftar = new javax.swing.JScrollPane();
        pnlDaftar = new javax.swing.JPanel();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(22, 26, 22, 26));
        setOpaque(false);

        lblJudul.setText("Transaksi Saya");
        lblJudul.setFont(Theme.font(java.awt.Font.BOLD, 24));
        lblJudul.setForeground(Theme.TEXT);

        scrollDaftar.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        scrollDaftar.setOpaque(false);

        pnlDaftar.setOpaque(false);
        pnlDaftar.setLayout(new javax.swing.BoxLayout(pnlDaftar, javax.swing.BoxLayout.PAGE_AXIS));
        scrollDaftar.setViewportView(pnlDaftar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblJudul)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(scrollDaftar, javax.swing.GroupLayout.PREFERRED_SIZE, 848, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblJudul)
                .addGap(6, 6, 6)
                .addComponent(scrollDaftar, javax.swing.GroupLayout.PREFERRED_SIZE, 596, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void muatUlang() {
        pnlDaftar.removeAll();
        List<OnlineOrder> riwayat = ctl.riwayat(username);
        
        if (riwayat.isEmpty()) {
            UIs.info(this, "Belum ada riwayat transaksi");
            nav.keBeranda();
            return;
        }

        for (OnlineOrder o : riwayat) {
            pnlDaftar.add(new TrxCard(o));
            pnlDaftar.add(Box.createVerticalStrut(10));
        }
        pnlDaftar.revalidate();
        pnlDaftar.repaint();
    }



    private class TrxCard extends JPanel {

        private TrxCard(OnlineOrder o) {
            setLayout(new BorderLayout());
            setOpaque(false);

            JPanel card = UIs.card(18);
            card.setLayout(new BorderLayout(16, 0));
            card.setBorder(BorderFactory.createEmptyBorder(14, 18, 14, 18));

            JPanel kiri = new JPanel();
            kiri.setOpaque(false);
            kiri.setLayout(new javax.swing.BoxLayout(kiri, javax.swing.BoxLayout.Y_AXIS));
            JLabel id = new JLabel(o.idTransaksi);
            id.setFont(Theme.font(Font.BOLD, 15f));
            id.setForeground(Theme.NAVY);
            kiri.add(id);
            JLabel tgl = new JLabel(UIs.dateInd(o.tanggal));
            tgl.setFont(Theme.small());
            tgl.setForeground(Theme.TEXT_MUTED);
            kiri.add(tgl);
            card.add(kiri, BorderLayout.WEST);

            JPanel tengah = new JPanel();
            tengah.setOpaque(false);
            tengah.setLayout(new javax.swing.BoxLayout(tengah, javax.swing.BoxLayout.Y_AXIS));
            tengah.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
            JLabel tipe = new JLabel("Tipe pemesanan: " + (o.tipePemesanan == null ? "-" : o.tipePemesanan));
            tipe.setFont(Theme.body());
            tengah.add(tipe);
            tengah.add(javax.swing.Box.createVerticalStrut(4));
            tengah.add(UIs.statusBadge(o.statusPesanan));
            card.add(tengah, BorderLayout.CENTER);

            var btnDetail = UIs.button("Selengkapnya", UIs.Btn.SECONDARY);
            btnDetail.setPreferredSize(new Dimension(160, 34));
            btnDetail.addActionListener(e -> new DetailTransaksiDialog(o).setVisible(true));
            JPanel kanan = new JPanel();
            kanan.setOpaque(false);
            kanan.add(btnDetail);
            card.add(kanan, BorderLayout.EAST);

            add(card, BorderLayout.CENTER);
        }

        @Override
        public Dimension getMaximumSize() {
            return new Dimension(Integer.MAX_VALUE, getPreferredSize().height);
        }
    }


 
    private class DetailTransaksiDialog extends javax.swing.JDialog {

        private DetailTransaksiDialog(OnlineOrder o) {
            super(javax.swing.SwingUtilities.getWindowAncestor(TransaksiPanel.this),
                    "Detail " + o.idTransaksi, ModalityType.APPLICATION_MODAL);
            setLayout(new BorderLayout());
            getContentPane().setBackground(Theme.PAGE_BG);

            JPanel card = UIs.card(16);
            card.setLayout(new BorderLayout(0, 14));
            card.setBorder(BorderFactory.createEmptyBorder(26, 30, 26, 30));

            // ===== kepala dialog =====
            JPanel head = new JPanel(new BorderLayout());
            head.setOpaque(false);
            JPanel ids = new JPanel();
            ids.setOpaque(false);
            ids.setLayout(new javax.swing.BoxLayout(ids, javax.swing.BoxLayout.Y_AXIS));
            JLabel judul = new JLabel(o.idTransaksi);
            judul.setFont(Theme.h3());
            judul.setForeground(Theme.TEXT);
            ids.add(judul);
            JLabel tgl = new JLabel(UIs.dateInd(o.tanggal));
            tgl.setFont(Theme.body());
            tgl.setForeground(Theme.TEXT_MUTED);
            ids.add(tgl);
            head.add(ids, BorderLayout.WEST);
            JPanel badges = new JPanel();
            badges.setOpaque(false);
            badges.add(UIs.statusBadge(o.statusPesanan));
            badges.add(javax.swing.Box.createHorizontalStrut(6));
            badges.add(UIs.statusBadge(o.statusPembayaran));
            head.add(badges, BorderLayout.EAST);
            card.add(head, BorderLayout.NORTH);


            JPanel isi = new JPanel();
            isi.setOpaque(false);
            isi.setLayout(new javax.swing.BoxLayout(isi, javax.swing.BoxLayout.Y_AXIS));

            JPanel penerima = UIs.card(10);
            penerima.setLayout(new BorderLayout(0, 4));
            penerima.setBorder(BorderFactory.createEmptyBorder(12, 16, 12, 16));
            JLabel lblPen = new JLabel("Detail penerima");
            lblPen.setFont(Theme.h3());
            lblPen.setForeground(Theme.NAVY);
            penerima.add(lblPen, BorderLayout.NORTH);
            JPanel penIsi = new JPanel();
            penIsi.setOpaque(false);
            penIsi.setLayout(new javax.swing.BoxLayout(penIsi, javax.swing.BoxLayout.Y_AXIS));
            String nama = o.namaPelanggan == null || o.namaPelanggan.isBlank()
                    ? o.usernamePelanggan : o.namaPelanggan;
            penIsi.add(baris("Nama", nama));
            penIsi.add(baris("Username", o.usernamePelanggan));
            penIsi.add(baris("Alamat", o.alamatPelanggan == null ? "-" : o.alamatPelanggan));
            penIsi.add(baris("Tipe pemesanan", o.tipePemesanan));
            penerima.add(penIsi, BorderLayout.CENTER);
            isi.add(penerima);
            isi.add(javax.swing.Box.createVerticalStrut(10));

            JPanel produk = UIs.card(10);
            produk.setLayout(new BorderLayout(0, 6));
            produk.setBorder(BorderFactory.createEmptyBorder(12, 16, 12, 16));
            JLabel lblProd = new JLabel("Produk dibeli");
            lblProd.setFont(Theme.h3());
            lblProd.setForeground(Theme.NAVY);
            produk.add(lblProd, BorderLayout.NORTH);

            String[] kolom = {"Produk", "Jumlah", "Harga", "Subtotal"};
            List<DetailTransaksi> items = ctl.itemTransaksi(o.idTransaksi);
            String[][] data = new String[items.size()][4];
            for (int i = 0; i < items.size(); i++) {
                var d = items.get(i);
                data[i][0] = d.namaProduk;
                data[i][1] = d.jumlahBeli + "x";
                data[i][2] = UIs.money(d.hargaSaatTransaksi);
                data[i][3] = UIs.money(d.subtotalItem);
            }
            var table = new javax.swing.JTable(data, kolom);
            UIs.styleTable(table);
            produk.add(new javax.swing.JScrollPane(table), BorderLayout.CENTER);
            isi.add(produk);
            isi.add(javax.swing.Box.createVerticalStrut(10));

            JPanel rincian = UIs.card(10);
            rincian.setLayout(new BorderLayout(0, 4));
            rincian.setBorder(BorderFactory.createEmptyBorder(12, 16, 12, 16));
            JLabel lblRin = new JLabel("Rincian belanja");
            lblRin.setFont(Theme.h3());
            lblRin.setForeground(Theme.NAVY);
            rincian.add(lblRin, BorderLayout.NORTH);
            JPanel rinIsi = new JPanel();
            rinIsi.setOpaque(false);
            rinIsi.setLayout(new javax.swing.BoxLayout(rinIsi, javax.swing.BoxLayout.Y_AXIS));
            rinIsi.add(baris("Metode pembayaran", o.metodePembayaran));
            if (o.bayarTunai()) {
                rinIsi.add(baris("Kode transaksi cash", o.kodeTransaksiCash));
            }
            rinIsi.add(baris("Subtotal produk", UIs.money(o.subtotalProduk())));
            rinIsi.add(baris("Biaya pengiriman", UIs.money(o.biayaOngkir)));
            JLabel total = new JLabel(UIs.money(o.totalBayar));
            total.setFont(Theme.font(Font.BOLD, 16f));
            total.setForeground(Theme.NAVY);
            JPanel totBaris = new JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 8, 2));
            totBaris.setOpaque(false);
            JLabel lblTot = new JLabel("Total bayar:");
            lblTot.setFont(Theme.h3());
            totBaris.add(lblTot);
            totBaris.add(total);
            rinIsi.add(totBaris);
            rincian.add(rinIsi, BorderLayout.CENTER);
            isi.add(rincian);

            JScrollPane scroll = new JScrollPane(isi);
            scroll.setOpaque(false);
            scroll.getViewport().setOpaque(false);
            scroll.setBorder(BorderFactory.createEmptyBorder());
            scroll.setPreferredSize(new Dimension(520, 380));
            card.add(scroll, BorderLayout.CENTER);


            var btnKembali = UIs.button("Kembali ke beranda", UIs.Btn.PRIMARY);
            btnKembali.addActionListener(e -> {
                dispose();
                nav.keBeranda();
            });
            JPanel bwrap = new JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 0, 0));
            bwrap.setOpaque(false);
            bwrap.add(btnKembali);
            card.add(bwrap, BorderLayout.SOUTH);

            add(card, BorderLayout.CENTER);
            pack();
            setLocationRelativeTo(getOwner());
        }

        private JPanel baris(String k, String v) {
            JPanel p = new JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 8, 2));
            p.setOpaque(false);
            JLabel a = new JLabel(k + ":");
            a.setFont(Theme.body());
            a.setForeground(Theme.TEXT_MUTED);
            a.setPreferredSize(new Dimension(150, 18));
            JLabel b = new JLabel(v == null ? "-" : v);
            b.setFont(Theme.body());
            b.setForeground(Theme.TEXT);
            p.add(a);
            p.add(b);
            return p;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblJudul;
    private javax.swing.JPanel pnlDaftar;
    private javax.swing.JScrollPane scrollDaftar;
    // End of variables declaration//GEN-END:variables
}
