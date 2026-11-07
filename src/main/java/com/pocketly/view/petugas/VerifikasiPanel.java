package com.pocketly.view.petugas;

import com.pocketly.controller.VerifikasiController;
import com.pocketly.model.OnlineOrder;
import com.pocketly.util.Theme;
import com.pocketly.util.UIs;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class VerifikasiPanel extends javax.swing.JPanel {
    private final String username;
    private final PetugasNav nav;
    private final VerifikasiController ctl = new VerifikasiController();

    private DefaultTableModel model;
    private List<OnlineOrder> data;

    private static final int KOLOM_BUKTI = 5;

    public VerifikasiPanel(String username, PetugasNav nav) {
        this.username = username;
        this.nav = nav;
        initComponents();
        siapkanTabel();
    }

    public VerifikasiPanel() {
        this(null, null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblJudul = new javax.swing.JLabel();
        kartu = new com.pocketly.component.RoundPanel();
        scrollTabel = new javax.swing.JScrollPane();
        tblVerifikasi = new javax.swing.JTable();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(22, 26, 22, 26));
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(1920, 1080));

        lblJudul.setFont(Theme.font(java.awt.Font.BOLD, 22));
        lblJudul.setForeground(Theme.TEXT);
        lblJudul.setText("Verifikasi Pembayaran");

        kartu.setBackground(Theme.CARD);
        kartu.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 12, 10, 12));
        kartu.setRadius(18);

        scrollTabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        scrollTabel.setOpaque(false);

        tblVerifikasi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Transaksi", "Tanggal", "Pelanggan", "Metode", "Total", "Bukti Pembayaran", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblVerifikasi.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblVerifikasi.setFillsViewportHeight(true);
        tblVerifikasi.setRowHeight(40);
        scrollTabel.setViewportView(tblVerifikasi);

        javax.swing.GroupLayout kartuLayout = new javax.swing.GroupLayout(kartu);
        kartu.setLayout(kartuLayout);
        kartuLayout.setHorizontalGroup(
            kartuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kartuLayout.createSequentialGroup()
                .addComponent(scrollTabel, javax.swing.GroupLayout.PREFERRED_SIZE, 1500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        kartuLayout.setVerticalGroup(
            kartuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kartuLayout.createSequentialGroup()
                .addComponent(scrollTabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblJudul)
                    .addComponent(kartu, javax.swing.GroupLayout.PREFERRED_SIZE, 1515, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblJudul)
                .addGap(18, 18, 18)
                .addComponent(kartu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void siapkanTabel() {
        UIs.styleTable(tblVerifikasi);
        tblVerifikasi.setRowHeight(40);
        model = (DefaultTableModel) tblVerifikasi.getModel();
        int[] lebarKolom = {96, 96, 150, 96, 110, 150, 140};
        for (int i = 0; i < lebarKolom.length && i < tblVerifikasi.getColumnCount(); i++) {
            tblVerifikasi.getColumnModel().getColumn(i).setPreferredWidth(lebarKolom[i]);
        }

        tblVerifikasi.getColumnModel().getColumn(6).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public java.awt.Component getTableCellRendererComponent(javax.swing.JTable t, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                JPanel p = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0)) {
                    @Override
                    protected void paintComponent(java.awt.Graphics g) {
                        g.setColor(isSelected ? Theme.BLUE_LIGHT : Color.WHITE);
                        g.fillRect(0, 0, getWidth(), getHeight());
                    }
                };
                p.setOpaque(false);
                p.add(UIs.statusBadge(String.valueOf(value)));
                return p;
            }
        });
        DefaultTableCellRenderer kanan = new DefaultTableCellRenderer();
        kanan.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tblVerifikasi.getColumnModel().getColumn(4).setCellRenderer(kanan);

        UIs.pasangAksiKolom(tblVerifikasi, KOLOM_BUKTI, "Lihat Bukti", UIs.Btn.SECONDARY, baris -> {
            if (data != null && baris < data.size()) {
                bukaBukti(data.get(baris));
            }
        });
    }

    public void muatUlang() {
        model.setRowCount(0);
        data = ctl.antrean();
        for (OnlineOrder o : data) {
            String nama = o.namaPelanggan == null || o.namaPelanggan.isBlank()
                    ? o.usernamePelanggan : o.namaPelanggan;
            model.addRow(new Object[]{
                o.idTransaksi,
                UIs.dateInd(o.tanggal),
                nama,
                o.metodePembayaran,
                UIs.money(o.totalBayar),
                "",
                o.statusPembayaran
            });
        }
    }

    private void bukaBukti(OnlineOrder o) {
        javax.swing.JDialog dlg = new javax.swing.JDialog(
                javax.swing.SwingUtilities.getWindowAncestor(this),
                "Bukti Pembayaran - " + o.idTransaksi,
                java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        dlg.setLayout(new BorderLayout());
        dlg.getContentPane().setBackground(Theme.PAGE_BG);

        JPanel card = UIs.card(16);
        card.setLayout(new BorderLayout(0, 14));
        card.setBorder(BorderFactory.createEmptyBorder(24, 28, 24, 28));

        JPanel info = new JPanel();
        info.setOpaque(false);
        info.setLayout(new javax.swing.BoxLayout(info, javax.swing.BoxLayout.Y_AXIS));
        JLabel t1 = new JLabel(o.idTransaksi + " - "
                + (o.namaPelanggan == null ? o.usernamePelanggan : o.namaPelanggan));
        t1.setFont(Theme.h2());
        t1.setForeground(Theme.TEXT);
        info.add(t1);
        JLabel t2 = new JLabel(UIs.money(o.totalBayar) + " - " + o.metodePembayaran
                + (o.bayarTunai() ? " (kode: " + o.kodeTransaksiCash + ")" : ""));
        t2.setFont(Theme.body());
        t2.setForeground(Theme.TEXT_MUTED);
        info.add(t2);
        card.add(info, BorderLayout.NORTH);

        JLabel gambar;
        if (o.bayarTunai()) {
            JPanel kodePanel = UIs.card(12);
            kodePanel.setLayout(new BorderLayout());
            kodePanel.setBorder(BorderFactory.createEmptyBorder(20, 24, 20, 24));
            JLabel lblKode = new JLabel(o.kodeTransaksiCash, javax.swing.SwingConstants.CENTER);
            lblKode.setFont(Theme.font(java.awt.Font.BOLD, 28f));
            lblKode.setForeground(Theme.NAVY);
            kodePanel.add(lblKode, BorderLayout.CENTER);
            JLabel note = new JLabel("Pembayaran tunai di toko. Terima pembayaran sesuai total, "
                    + "lalu klik Valid.", javax.swing.SwingConstants.CENTER);
            note.setFont(Theme.small());
            note.setForeground(Theme.TEXT_MUTED);
            kodePanel.add(note, javax.swing.SwingConstants.SOUTH);
            gambar = new JLabel();
            gambar.setLayout(new BorderLayout());
            gambar.add(kodePanel, BorderLayout.CENTER);
        } else {
            gambar = new JLabel(UIs.buktiImage(o.buktiPembayaran, 420, 300),
                    javax.swing.SwingConstants.CENTER);
        }
        card.add(gambar, BorderLayout.CENTER);

        JPanel tombol = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        tombol.setOpaque(false);
        var btnTutup = UIs.button("Tutup", UIs.Btn.GHOST);
        btnTutup.addActionListener(e -> dlg.dispose());
        var btnTidak = UIs.button("Tidak Valid", UIs.Btn.DANGER);
        btnTidak.addActionListener(e -> {
            try {
                String pesan = ctl.verifikasi(o.idTransaksi, false, username);
                UIs.info(this, pesan);
                dlg.dispose();
                muatUlang();
            } catch (RuntimeException ex) {
                UIs.error(this, ex.getMessage());
            }
        });
        var btnValid = UIs.button("Valid", UIs.Btn.SUCCESS);
        btnValid.addActionListener(e -> {
            try {
                String pesan = ctl.verifikasi(o.idTransaksi, true, username);
                UIs.info(this, pesan);
                dlg.dispose();
                muatUlang();
            } catch (RuntimeException ex) {
                UIs.error(this, ex.getMessage());
            }
        });
        tombol.add(btnTutup);
        tombol.add(btnTidak);
        tombol.add(btnValid);
        card.add(tombol, BorderLayout.SOUTH);

        dlg.add(card, BorderLayout.CENTER);
        dlg.pack();
        dlg.setLocationRelativeTo(null);
        dlg.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.pocketly.component.RoundPanel kartu;
    private javax.swing.JLabel lblJudul;
    private javax.swing.JScrollPane scrollTabel;
    private javax.swing.JTable tblVerifikasi;
    // End of variables declaration//GEN-END:variables
}
