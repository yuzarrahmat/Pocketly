package com.pocketly.view.petugas;

import com.pocketly.controller.PendapatanController;
import com.pocketly.model.PendapatanRow;
import com.pocketly.util.Theme;
import com.pocketly.util.UIs;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * Beranda petugas: kartu ringkasan, grafik batang pendapatan per tanggal
 * pada bulan berjalan (komponen ChartPanel, digambar dengan Java2D tanpa
 * library tambahan), serta tabel pendapatan terbaru.
 * Form NetBeans GUI Builder - buka BerandaPetugasPanel.form di tab Design.
 */
public class BerandaPetugasPanel extends javax.swing.JPanel {
    private final String username;
    private final PetugasNav nav;
    private final PendapatanController ctl = new PendapatanController();

    public BerandaPetugasPanel(String username, PetugasNav nav) {
        this.username = username;
        this.nav = nav;
        initComponents();
        lblJudul.setText("Selamat bertugas, " + (username == null ? "petugas" : username) + "!");
    }

    /** Konstruktor kosong untuk kompatibilitas. */
    public BerandaPetugasPanel() {
        this(null, null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        panelAtas = new javax.swing.JPanel();
        lblJudul = new javax.swing.JLabel();
        lblSub = new javax.swing.JLabel();
        strut1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 14), new java.awt.Dimension(0, 14), new java.awt.Dimension(32767, 14));
        kartu = new javax.swing.JPanel();
        kartuTotal = new com.pocketly.component.RoundPanel();
        lblkartuTotal = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        kartuJumlah = new com.pocketly.component.RoundPanel();
        lblkartuJumlah = new javax.swing.JLabel();
        lblJumlah = new javax.swing.JLabel();
        kartuHariIni = new com.pocketly.component.RoundPanel();
        lblkartuHariIni = new javax.swing.JLabel();
        lblHariIni = new javax.swing.JLabel();
        panelTengah = new javax.swing.JPanel();
        kartuGrafik = new com.pocketly.component.RoundPanel();
        lblJudulGrafik = new javax.swing.JLabel();
        grafik = new com.pocketly.component.ChartPanel();
        strut2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 14), new java.awt.Dimension(0, 14), new java.awt.Dimension(32767, 14));
        kartuTabel = new com.pocketly.component.RoundPanel();
        lblJudulTabel = new javax.swing.JLabel();
        tabelWrap = new javax.swing.JPanel();

        setOpaque(false);
        setBorder(javax.swing.BorderFactory.createEmptyBorder(22, 26, 22, 26));
        this.setLayout(new java.awt.BorderLayout(0, 16));
        panelAtas.setOpaque(false);
        panelAtas.setLayout(new javax.swing.BoxLayout(panelAtas, javax.swing.BoxLayout.Y_AXIS));
        lblJudul.setText("Selamat bertugas!");
        lblJudul.setFont(Theme.font(java.awt.Font.BOLD, 22));
        lblJudul.setForeground(Theme.TEXT);
        lblSub.setText("Pantau pendapatan toko dan kelola operasional lewat menu di samping.");
        lblSub.setFont(Theme.font(java.awt.Font.PLAIN, 13));
        lblSub.setForeground(Theme.TEXT_MUTED);
        strut1.setMaximumSize(new java.awt.Dimension(32767, 14));
        strut1.setMinimumSize(new java.awt.Dimension(0, 14));
        strut1.setPreferredSize(new java.awt.Dimension(0, 14));
        kartu.setOpaque(false);
        kartu.setMaximumSize(new java.awt.Dimension(32767, 92));
        kartu.setLayout(new java.awt.GridLayout(1, 3, 14, 0));
        kartuTotal.setBackground(Theme.BLUE_LIGHT);
        kartuTotal.setRadius(20);
        kartuTotal.setBorder(javax.swing.BorderFactory.createEmptyBorder(14, 20, 14, 16));
        kartuTotal.setPreferredSize(new java.awt.Dimension(0, 86));
        kartuTotal.setLayout(new javax.swing.BoxLayout(kartuTotal, javax.swing.BoxLayout.Y_AXIS));
        lblkartuTotal.setText("Total Pendapatan");
        lblkartuTotal.setFont(Theme.font(java.awt.Font.PLAIN, 13));
        lblkartuTotal.setForeground(Theme.TEXT_MUTED);
        lblTotal.setText("Rp 0");
        lblTotal.setFont(Theme.font(java.awt.Font.BOLD, 21));
        lblTotal.setForeground(Theme.NAVY);
        kartuTotal.add(lblkartuTotal);
        kartuTotal.add(lblTotal);
        kartuJumlah.setBackground(Theme.SUCCESS_LT);
        kartuJumlah.setRadius(20);
        kartuJumlah.setBorder(javax.swing.BorderFactory.createEmptyBorder(14, 20, 14, 16));
        kartuJumlah.setPreferredSize(new java.awt.Dimension(0, 86));
        kartuJumlah.setLayout(new javax.swing.BoxLayout(kartuJumlah, javax.swing.BoxLayout.Y_AXIS));
        lblkartuJumlah.setText("Transaksi Berhasil");
        lblkartuJumlah.setFont(Theme.font(java.awt.Font.PLAIN, 13));
        lblkartuJumlah.setForeground(Theme.TEXT_MUTED);
        lblJumlah.setText("Rp 0");
        lblJumlah.setFont(Theme.font(java.awt.Font.BOLD, 21));
        lblJumlah.setForeground(Theme.NAVY);
        kartuJumlah.add(lblkartuJumlah);
        kartuJumlah.add(lblJumlah);
        kartuHariIni.setBackground(Theme.WARNING_LT);
        kartuHariIni.setRadius(20);
        kartuHariIni.setBorder(javax.swing.BorderFactory.createEmptyBorder(14, 20, 14, 16));
        kartuHariIni.setPreferredSize(new java.awt.Dimension(0, 86));
        kartuHariIni.setLayout(new javax.swing.BoxLayout(kartuHariIni, javax.swing.BoxLayout.Y_AXIS));
        lblkartuHariIni.setText("Pendapatan Hari Ini");
        lblkartuHariIni.setFont(Theme.font(java.awt.Font.PLAIN, 13));
        lblkartuHariIni.setForeground(Theme.TEXT_MUTED);
        lblHariIni.setText("Rp 0");
        lblHariIni.setFont(Theme.font(java.awt.Font.BOLD, 21));
        lblHariIni.setForeground(Theme.NAVY);
        kartuHariIni.add(lblkartuHariIni);
        kartuHariIni.add(lblHariIni);
        kartu.add(kartuTotal);
        kartu.add(kartuJumlah);
        kartu.add(kartuHariIni);
        panelAtas.add(lblJudul);
        panelAtas.add(lblSub);
        panelAtas.add(strut1);
        panelAtas.add(kartu);
        panelTengah.setOpaque(false);
        panelTengah.setLayout(new javax.swing.BoxLayout(panelTengah, javax.swing.BoxLayout.Y_AXIS));
        kartuGrafik.setBackground(Theme.CARD);
        kartuGrafik.setRadius(20);
        kartuGrafik.setBorder(javax.swing.BorderFactory.createEmptyBorder(16, 20, 12, 20));
        kartuGrafik.setMaximumSize(new java.awt.Dimension(32767, 280));
        kartuGrafik.setLayout(new java.awt.BorderLayout(0, 8));
        lblJudulGrafik.setText("Grafik Pendapatan");
        lblJudulGrafik.setFont(Theme.font(java.awt.Font.BOLD, 15));
        lblJudulGrafik.setForeground(Theme.NAVY);
        grafik.setPreferredSize(new java.awt.Dimension(0, 210));
        kartuGrafik.add(lblJudulGrafik, java.awt.BorderLayout.NORTH);
        kartuGrafik.add(grafik, java.awt.BorderLayout.CENTER);
        strut2.setMaximumSize(new java.awt.Dimension(32767, 14));
        strut2.setMinimumSize(new java.awt.Dimension(0, 14));
        strut2.setPreferredSize(new java.awt.Dimension(0, 14));
        kartuTabel.setBackground(Theme.CARD);
        kartuTabel.setRadius(20);
        kartuTabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(16, 20, 16, 20));
        kartuTabel.setLayout(new java.awt.BorderLayout(0, 10));
        lblJudulTabel.setText("Tabel Pendapatan");
        lblJudulTabel.setFont(Theme.font(java.awt.Font.BOLD, 15));
        lblJudulTabel.setForeground(Theme.NAVY);
        tabelWrap.setOpaque(false);
        tabelWrap.setLayout(new java.awt.BorderLayout(0, 0));
        kartuTabel.add(lblJudulTabel, java.awt.BorderLayout.NORTH);
        kartuTabel.add(tabelWrap, java.awt.BorderLayout.CENTER);
        panelTengah.add(kartuGrafik);
        panelTengah.add(strut2);
        panelTengah.add(kartuTabel);
        this.add(panelAtas, java.awt.BorderLayout.NORTH);
        this.add(panelTengah, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    /** Dimuat setiap kali halaman dibuka. */
    public void muatUlang() {
        List<PendapatanRow> rows = ctl.barisPendapatan();
        var bulanGrafik = ctl.bulanGrafik();

        lblTotal.setText(UIs.money(ctl.totalPendapatan()));
        lblJumlah.setText(rows.size() + " transaksi");
        lblHariIni.setText(UIs.money(bulanGrafik.data().getOrDefault(LocalDate.now(), 0.0)));

        lblJudulGrafik.setText("Grafik Pendapatan - "
                + java.time.Month.of(bulanGrafik.bulan()).getDisplayName(
                        java.time.format.TextStyle.FULL, new Locale("id", "ID"))
                + " " + bulanGrafik.tahun());
        grafik.setData(bulanGrafik.tahun(), bulanGrafik.bulan(), bulanGrafik.data());

        tabelWrap.removeAll();
        if (rows.isEmpty()) {
            // flowchart: tampilkan "Belum ada pendapatan"
            JLabel kosong = new JLabel("Belum ada pendapatan");
            kosong.setFont(Theme.body());
            kosong.setForeground(Theme.TEXT_MUTED);
            kosong.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            tabelWrap.add(kosong, java.awt.BorderLayout.CENTER);
        } else {
            String[] kolom = {"Tanggal", "ID Transaksi", "Jenis", "Metode", "Total"};
            String[][] data = new String[rows.size()][5];
            for (int i = 0; i < rows.size(); i++) {
                PendapatanRow r = rows.get(i);
                data[i][0] = UIs.dateInd(r.tanggal);
                data[i][1] = r.idTransaksi;
                data[i][2] = r.jenis;
                data[i][3] = r.metode;
                data[i][4] = UIs.money(r.total);
            }
            JTable table = new JTable(data, kolom);
            UIs.styleTable(table);
            table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            // kolom total rata kanan
            DefaultTableCellRenderer kanan = new DefaultTableCellRenderer();
            kanan.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
            table.getColumnModel().getColumn(4).setCellRenderer(kanan);
            JScrollPane scroll = new JScrollPane(table);
            scroll.setBorder(BorderFactory.createEmptyBorder());
            tabelWrap.add(scroll, java.awt.BorderLayout.CENTER);
        }
        tabelWrap.revalidate();
        tabelWrap.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelAtas;
    private javax.swing.JLabel lblJudul;
    private javax.swing.JLabel lblSub;
    private javax.swing.Box.Filler strut1;
    private javax.swing.JPanel kartu;
    private com.pocketly.component.RoundPanel kartuTotal;
    private javax.swing.JLabel lblkartuTotal;
    private javax.swing.JLabel lblTotal;
    private com.pocketly.component.RoundPanel kartuJumlah;
    private javax.swing.JLabel lblkartuJumlah;
    private javax.swing.JLabel lblJumlah;
    private com.pocketly.component.RoundPanel kartuHariIni;
    private javax.swing.JLabel lblkartuHariIni;
    private javax.swing.JLabel lblHariIni;
    private javax.swing.JPanel panelTengah;
    private com.pocketly.component.RoundPanel kartuGrafik;
    private javax.swing.JLabel lblJudulGrafik;
    private com.pocketly.component.ChartPanel grafik;
    private javax.swing.Box.Filler strut2;
    private com.pocketly.component.RoundPanel kartuTabel;
    private javax.swing.JLabel lblJudulTabel;
    private javax.swing.JPanel tabelWrap;
    // End of variables declaration//GEN-END:variables
}
