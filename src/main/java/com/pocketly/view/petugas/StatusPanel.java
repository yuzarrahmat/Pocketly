package com.pocketly.view.petugas;

import com.pocketly.controller.StatusController;
import com.pocketly.model.OnlineOrder;
import com.pocketly.util.Theme;
import com.pocketly.util.UIs;
import java.awt.Color;
import java.awt.FlowLayout;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class StatusPanel extends javax.swing.JPanel {
    private final String username;
    private final PetugasNav nav;
    private final StatusController ctl = new StatusController();

    private DefaultTableModel model;
    private List<OnlineOrder> data;

    private static final int KOLOM_AKSI = 5;

    public StatusPanel(String username, PetugasNav nav) {
        this.username = username;
        this.nav = nav;
        initComponents();
        siapkanTabel();
    }

    public StatusPanel() {
        this(null, null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblJudul = new javax.swing.JLabel();
        kartu = new com.pocketly.component.RoundPanel();
        scrollTabel = new javax.swing.JScrollPane();
        tblStatus = new javax.swing.JTable();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(22, 26, 22, 26));
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(1920, 1080));

        lblJudul.setFont(Theme.font(java.awt.Font.BOLD, 22));
        lblJudul.setForeground(Theme.TEXT);
        lblJudul.setText("Ubah Status Pesanan Online");

        kartu.setBackground(Theme.CARD);
        kartu.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 12, 10, 12));
        kartu.setRadius(18);
        kartu.setLayout(new java.awt.BorderLayout());

        scrollTabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        scrollTabel.setOpaque(false);

        tblStatus.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID Pesanan", "Tanggal", "Pelanggan", "Tipe", "Status Saat Ini", "Ubah Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblStatus.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblStatus.setFillsViewportHeight(true);
        tblStatus.setRowHeight(40);
        scrollTabel.setViewportView(tblStatus);

        kartu.add(scrollTabel, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblJudul)
                    .addComponent(kartu, javax.swing.GroupLayout.PREFERRED_SIZE, 1575, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(293, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblJudul)
                .addGap(6, 6, 6)
                .addComponent(kartu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void siapkanTabel() {
        UIs.styleTable(tblStatus);
        tblStatus.setRowHeight(40);
        model = (DefaultTableModel) tblStatus.getModel();
        int[] lebarKolom = {100, 100, 170, 120, 150, 150};
        for (int i = 0; i < lebarKolom.length && i < tblStatus.getColumnCount(); i++) {
            tblStatus.getColumnModel().getColumn(i).setPreferredWidth(lebarKolom[i]);
        }

        tblStatus.getColumnModel().getColumn(4).setCellRenderer(new DefaultTableCellRenderer() {
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

        UIs.pasangAksiKolom(tblStatus, KOLOM_AKSI, "Ubah Status", UIs.Btn.SECONDARY, baris -> {
            if (data != null && baris < data.size()) {
                bukaDropdown(data.get(baris));
            }
        });
    }

    public void muatUlang() {
        model.setRowCount(0);
        data = ctl.daftarPesanan();
        for (OnlineOrder o : data) {
            String nama = o.namaPelanggan == null || o.namaPelanggan.isBlank()
                    ? o.usernamePelanggan : o.namaPelanggan;
            model.addRow(new Object[]{
                o.idTransaksi,
                UIs.dateInd(o.tanggal),
                nama,
                o.tipePemesanan,
                o.statusPesanan,
                ""
            });
        }
    }

    private void bukaDropdown(OnlineOrder o) {
        JComboBox<String> cb = new JComboBox<>(StatusController.STATUS);
        cb.setSelectedItem(o.statusPesanan);
        Object[] pesan = {"Status baru untuk pesanan " + o.idTransaksi + ":", cb};
        int ok = javax.swing.JOptionPane.showConfirmDialog(this, pesan, "Ubah Status Pesanan",
                javax.swing.JOptionPane.OK_CANCEL_OPTION, javax.swing.JOptionPane.PLAIN_MESSAGE);
        if (ok == javax.swing.JOptionPane.OK_OPTION) {
            String statusBaru = (String) cb.getSelectedItem();
            try {
                String pesan2 = ctl.ubahStatus(o.idTransaksi, statusBaru);
                UIs.info(this, pesan2); 
                muatUlang(); 
            } catch (RuntimeException ex) {
                UIs.error(this, ex.getMessage());
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.pocketly.component.RoundPanel kartu;
    private javax.swing.JLabel lblJudul;
    private javax.swing.JScrollPane scrollTabel;
    private javax.swing.JTable tblStatus;
    // End of variables declaration//GEN-END:variables
}
