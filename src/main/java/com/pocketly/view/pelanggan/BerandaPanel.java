package com.pocketly.view.pelanggan;

import com.pocketly.controller.KatalogController;
import com.pocketly.controller.KeranjangController;
import com.pocketly.model.Kategori;
import com.pocketly.model.Produk;
import com.pocketly.util.Theme;
import com.pocketly.util.UIs;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Beranda pelanggan sesuai desain Figma: kartu promo di atas,
 * deretan kartu kategori bergambar, lalu produk pada kategori terpilih.
 * Form NetBeans GUI Builder - buka BerandaPanel.form di tab Design.
 */
public class BerandaPanel extends javax.swing.JPanel {
    private final String username;
    private final PelangganNav nav;
    private final KatalogController katalog = new KatalogController();
    private final KeranjangController keranjangCtl = new KeranjangController();

    private String kategoriAktif;

    /** Peta id kategori -> nama file gambar di img/kategori. */
    private static final Map<String, String> GAMBAR_KATEGORI = Map.of(
            "KTG01", "makanan.png",
            "KTG02", "minuman.png",
            "KTG03", "dapur.png",
            "KTG04", "ibu-anak.png",
            "KTG05", "makanan-hewan.png",
            "KTG06", "perawatan-diri.png",
            "KTG07", "kesehatan.png",
            "KTG08", "lainnya.png");

    public BerandaPanel(String username, PelangganNav nav) {
        this.username = username;
        this.nav = nav;
        initComponents();
        scrollProduk.getViewport().setOpaque(false);
        scrollProduk.getVerticalScrollBar().setUnitIncrement(18);
        scrollProduk.getVerticalScrollBar().setPreferredSize(new Dimension(8, 0));
    }

    /** Konstruktor kosong untuk kompatibilitas. */
    public BerandaPanel() {
        this(null, null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelAtas = new javax.swing.JPanel();
        promoWrap = new javax.swing.JPanel();
        promoCard = new com.pocketly.component.RoundPanel();
        teksPromo = new javax.swing.JPanel();
        lblPromo1 = new javax.swing.JLabel();
        lblPromo2 = new javax.swing.JLabel();
        lblGambarPromo = new javax.swing.JLabel();
        promoTeks = new com.pocketly.component.RoundPanel();
        teksPromoTeks = new javax.swing.JPanel();
        lblPromoJudul = new javax.swing.JLabel();
        strutPromo = new javax.swing.Box.Filler(new java.awt.Dimension(0, 6), new java.awt.Dimension(0, 6), new java.awt.Dimension(32767, 6));
        lblPromoIsi = new javax.swing.JLabel();
        panelChips = new javax.swing.JPanel();
        chipAntar = new com.pocketly.component.RoundPanel();
        lblIkonchipAntar = new javax.swing.JLabel();
        tekschipAntar = new javax.swing.JPanel();
        lblJudulchipAntar = new javax.swing.JLabel();
        lblSubchipAntar = new javax.swing.JLabel();
        strutChip = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 10));
        chipPickup = new com.pocketly.component.RoundPanel();
        lblIkonchipPickup = new javax.swing.JLabel();
        tekschipPickup = new javax.swing.JPanel();
        lblJudulchipPickup = new javax.swing.JLabel();
        lblSubchipPickup = new javax.swing.JLabel();
        panelTengah = new javax.swing.JPanel();
        lblJudulKategori = new javax.swing.JLabel();
        strut1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 10));
        pnlKategori = new javax.swing.JPanel();
        strut2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 16), new java.awt.Dimension(0, 16), new java.awt.Dimension(32767, 16));
        lblJudulProduk = new javax.swing.JLabel();
        strut3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 10));
        scrollProduk = new javax.swing.JScrollPane();
        pnlProduk = new javax.swing.JPanel();

        setOpaque(false);
        setBorder(javax.swing.BorderFactory.createEmptyBorder(22, 26, 22, 26));
        setLayout(new java.awt.BorderLayout(0, 16));

        panelAtas.setOpaque(false);
        panelAtas.setLayout(new java.awt.BorderLayout(14, 0));

        promoWrap.setOpaque(false);
        promoWrap.setLayout(new java.awt.GridLayout(1, 2, 14, 0));

        promoCard.setBackground(Theme.CARD);
        promoCard.setBorder(javax.swing.BorderFactory.createEmptyBorder(14, 16, 14, 8));
        promoCard.setPreferredSize(new java.awt.Dimension(0, 132));
        promoCard.setRadius(20);

        teksPromo.setOpaque(false);
        teksPromo.setLayout(new javax.swing.BoxLayout(teksPromo, javax.swing.BoxLayout.PAGE_AXIS));

        lblPromo1.setText("Jangan lupa checkout");
        lblPromo1.setFont(Theme.font(java.awt.Font.BOLD, 15));
        lblPromo1.setForeground(Theme.NAVY);
        teksPromo.add(lblPromo1);

        lblPromo2.setText("keranjangmu ya!");
        lblPromo2.setFont(Theme.font(java.awt.Font.BOLD, 15));
        lblPromo2.setForeground(Theme.NAVY);
        teksPromo.add(lblPromo2);

        lblGambarPromo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ui/promo-checkout.png"))); // NOI18N

        javax.swing.GroupLayout promoCardLayout = new javax.swing.GroupLayout(promoCard);
        promoCard.setLayout(promoCardLayout);
        promoCardLayout.setHorizontalGroup(
            promoCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(promoCardLayout.createSequentialGroup()
                .addComponent(teksPromo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblGambarPromo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        promoCardLayout.setVerticalGroup(
            promoCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(promoCardLayout.createSequentialGroup()
                .addGroup(promoCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(teksPromo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(promoCardLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblGambarPromo, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        promoWrap.add(promoCard);

        promoTeks.setBackground(Theme.CARD);
        promoTeks.setRadius(20);
        promoTeks.setBorder(javax.swing.BorderFactory.createEmptyBorder(16, 18, 16, 18));
        promoTeks.setPreferredSize(new java.awt.Dimension(0, 130));
        promoTeks.setLayout(new java.awt.BorderLayout());

        teksPromoTeks.setOpaque(false);
        teksPromoTeks.setLayout(new javax.swing.BoxLayout(teksPromoTeks, javax.swing.BoxLayout.PAGE_AXIS));

        lblPromoJudul.setText("<html><div style='width:220px'>Belanja low effort dengan Pocketly</div></html>");
        lblPromoJudul.setFont(Theme.font(java.awt.Font.BOLD, 17));
        lblPromoJudul.setForeground(Theme.NAVY);
        teksPromoTeks.add(lblPromoJudul);
        teksPromoTeks.add(strutPromo);

        lblPromoIsi.setText("<html><div style='width:240px'>Belanja offline dan online ritel pocket kini terintegrasi. Kenyamanan anda adalah prioritas kami.</div></html>");
        lblPromoIsi.setFont(Theme.font(java.awt.Font.PLAIN, 11));
        lblPromoIsi.setForeground(Theme.TEXT_MUTED);
        teksPromoTeks.add(lblPromoIsi);

        promoTeks.add(teksPromoTeks, java.awt.BorderLayout.CENTER);

        promoWrap.add(promoTeks);

        panelAtas.add(promoWrap, java.awt.BorderLayout.CENTER);

        panelChips.setOpaque(false);
        panelChips.setLayout(new javax.swing.BoxLayout(panelChips, javax.swing.BoxLayout.PAGE_AXIS));

        chipAntar.setBackground(Theme.CARD);
        chipAntar.setPreferredSize(new java.awt.Dimension(218, 56));
        chipAntar.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 12, 8, 6));
        chipAntar.setLayout(new java.awt.BorderLayout(10, 0));

        lblIkonchipAntar.setIcon(UIs.asset("icon-antar.png", 30, 30));
        chipAntar.add(lblIkonchipAntar);

        tekschipAntar.setOpaque(false);
        tekschipAntar.setLayout(new javax.swing.BoxLayout(tekschipAntar, javax.swing.BoxLayout.PAGE_AXIS));

        lblJudulchipAntar.setText("Pengantaran Cepat");
        lblJudulchipAntar.setFont(Theme.font(java.awt.Font.BOLD, 12));
        lblJudulchipAntar.setForeground(Theme.TEXT);
        tekschipAntar.add(lblJudulchipAntar);

        lblSubchipAntar.setText("Kurir sampai dalam 30 menit");
        lblSubchipAntar.setFont(Theme.font(java.awt.Font.PLAIN, 10));
        lblSubchipAntar.setForeground(Theme.TEXT_MUTED);
        tekschipAntar.add(lblSubchipAntar);

        chipAntar.add(tekschipAntar, java.awt.BorderLayout.CENTER);

        panelChips.add(chipAntar);
        panelChips.add(strutChip);

        chipPickup.setBackground(Theme.CARD);
        chipPickup.setPreferredSize(new java.awt.Dimension(218, 56));
        chipPickup.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 12, 8, 6));
        chipPickup.setLayout(new java.awt.BorderLayout(10, 0));

        lblIkonchipPickup.setIcon(UIs.asset("icon-pickup.png", 30, 30));
        chipPickup.add(lblIkonchipPickup);

        tekschipPickup.setOpaque(false);
        tekschipPickup.setLayout(new javax.swing.BoxLayout(tekschipPickup, javax.swing.BoxLayout.PAGE_AXIS));

        lblJudulchipPickup.setText("Pick Up pesanan");
        lblJudulchipPickup.setFont(Theme.font(java.awt.Font.BOLD, 12));
        lblJudulchipPickup.setForeground(Theme.TEXT);
        tekschipPickup.add(lblJudulchipPickup);

        lblSubchipPickup.setText("Ambil pesananmu tanpa antri");
        lblSubchipPickup.setFont(Theme.font(java.awt.Font.PLAIN, 10));
        lblSubchipPickup.setForeground(Theme.TEXT_MUTED);
        tekschipPickup.add(lblSubchipPickup);

        chipPickup.add(tekschipPickup, java.awt.BorderLayout.CENTER);

        panelChips.add(chipPickup);

        panelAtas.add(panelChips, java.awt.BorderLayout.EAST);

        add(panelAtas, java.awt.BorderLayout.NORTH);

        panelTengah.setOpaque(false);
        panelTengah.setLayout(new javax.swing.BoxLayout(panelTengah, javax.swing.BoxLayout.PAGE_AXIS));

        lblJudulKategori.setText("Kategori Produk");
        lblJudulKategori.setFont(Theme.font(java.awt.Font.BOLD, 16));
        lblJudulKategori.setForeground(Theme.TEXT);
        panelTengah.add(lblJudulKategori);
        panelTengah.add(strut1);

        pnlKategori.setOpaque(false);
        pnlKategori.setLayout(new java.awt.GridLayout(2, 4, 14, 14));
        panelTengah.add(pnlKategori);
        panelTengah.add(strut2);

        lblJudulProduk.setText(" ");
        lblJudulProduk.setFont(Theme.font(java.awt.Font.BOLD, 16));
        lblJudulProduk.setForeground(Theme.TEXT);
        panelTengah.add(lblJudulProduk);
        panelTengah.add(strut3);

        scrollProduk.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        scrollProduk.setOpaque(false);

        pnlProduk.setOpaque(false);
        pnlProduk.setLayout(new java.awt.GridLayout(0, 3, 14, 14));
        scrollProduk.setViewportView(pnlProduk);

        panelTengah.add(scrollProduk);

        add(panelTengah, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    /** Dimuat setiap kali halaman dibuka. */
    public void muatUlang() {
        nav.perbaruiBadgeKeranjang();
        muatKategori();
        if (kategoriAktif == null && pnlKategori.getComponentCount() > 0) {
            if (pnlKategori.getComponent(0) instanceof KartuKategori kk) {
                pilihKategori(kk.kategori);
            }
        } else if (kategoriAktif != null) {
            tampilkanProduk(kategoriAktif);
        }
    }

    private void muatKategori() {
        pnlKategori.removeAll();
        List<Kategori> list = katalog.daftarKategori();
        for (Kategori k : list) {
            pnlKategori.add(new KartuKategori(k));
        }
        pnlKategori.revalidate();
        pnlKategori.repaint();
    }

    private void pilihKategori(Kategori k) {
        kategoriAktif = k.id;
        lblJudulProduk.setText("Produk " + k.nama);
        for (int i = 0; i < pnlKategori.getComponentCount(); i++) {
            if (pnlKategori.getComponent(i) instanceof KartuKategori kk) {
                kk.setPilih(kk.kategori.id.equals(k.id));
            }
        }
        tampilkanProduk(k.id);
    }

    private void tampilkanProduk(String idKategori) {
        pnlProduk.removeAll();
        List<Produk> list = katalog.produkPerKategori(idKategori);
        if (list.isEmpty()) {
            JLabel kosong = new JLabel("Belum ada produk pada kategori ini.");
            kosong.setFont(Theme.body());
            kosong.setForeground(Theme.TEXT_MUTED);
            pnlProduk.add(kosong);
        }
        for (Produk p : list) {
            pnlProduk.add(new ProdukCard(p));
        }
        pnlProduk.revalidate();
        pnlProduk.repaint();
    }

    private void tambahKeKeranjang(Produk p) {
        String pesan = katalog.tambahKeKeranjang(username, p.id, 1);
        nav.perbaruiBadgeKeranjang();
        if ("Item ditambahkan".equals(pesan)) {
            UIs.info(this, "Item ditambahkan"); // notifikasi sukses (flowchart)
            int buka = javax.swing.JOptionPane.showConfirmDialog(this,
                    "Item ditambahkan ke keranjang. Buka keranjang sekarang?",
                    "Keranjang", javax.swing.JOptionPane.YES_NO_OPTION,
                    javax.swing.JOptionPane.QUESTION_MESSAGE);
            if (buka == javax.swing.JOptionPane.YES_OPTION) {
                nav.keKeranjang();
            } else {
                muatUlang();
            }
        } else {
            UIs.error(this, pesan); // "Stok tidak mencukupi"
        }
    }


    // ================= Kartu kategori (Figma: Group 34-41) =================

    private class KartuKategori extends JPanel {

        private final Kategori kategori;
        private boolean dipilih;

        private KartuKategori(Kategori k) {
            this.kategori = k;
            setLayout(new java.awt.BorderLayout(0, 4));
            setOpaque(false);
            setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    pilihKategori(kategori);
                }
            });

            JPanel card = UIs.card(18);
            card.setLayout(new java.awt.BorderLayout(0, 2));
            card.setBorder(BorderFactory.createEmptyBorder(8, 8, 6, 8));

            String file = GAMBAR_KATEGORI.getOrDefault(k.id, "");
            JLabel img = new JLabel(UIs.kategoriImage(file, 140, 92));
            img.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            card.add(img, java.awt.BorderLayout.CENTER);

            JLabel nama = new JLabel(k.nama, JLabel.CENTER);
            nama.setFont(Theme.font(Font.PLAIN, 12f));
            nama.setForeground(Theme.TEXT);
            card.add(nama, java.awt.BorderLayout.SOUTH);

            add(card, java.awt.BorderLayout.CENTER);
        }

        private void setPilih(boolean p) {
            this.dipilih = p;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            if (!dipilih) {
                return;
            }
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(Theme.NAVY);
            g2.setStroke(new BasicStroke(2f));
            g2.drawRoundRect(1, 1, getWidth() - 3, getHeight() - 3, 18, 18);
            g2.dispose();
        }
    }

    // ================= Kartu produk =================

    private class ProdukCard extends JPanel {

        private ProdukCard(Produk p) {
            setLayout(new java.awt.BorderLayout(0, 8));
            setOpaque(false);

            JPanel card = UIs.card(14);
            card.setLayout(new java.awt.BorderLayout(0, 10));
            card.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));

            JLabel img = new JLabel(UIs.productImage(p.gambar, 170, 120));
            img.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            card.add(img, java.awt.BorderLayout.CENTER);

            JPanel info = new JPanel();
            info.setOpaque(false);
            info.setLayout(new javax.swing.BoxLayout(info, javax.swing.BoxLayout.Y_AXIS));
            JLabel nama = new JLabel(p.nama);
            nama.setFont(Theme.h3());
            nama.setForeground(Theme.TEXT);
            info.add(nama);
            JLabel kategori = new JLabel(p.namaKategori == null ? "-" : p.namaKategori);
            kategori.setFont(Theme.small());
            kategori.setForeground(Theme.TEXT_MUTED);
            info.add(kategori);
            info.add(Box.createVerticalStrut(4));
            JLabel harga = new JLabel(UIs.money(p.hargaSatuan) + " / " + p.satuan);
            harga.setFont(Theme.font(Font.BOLD, 14f));
            harga.setForeground(Theme.BLUE);
            info.add(harga);
            JLabel stok = new JLabel("Stok: " + p.stok + " " + p.satuan);
            stok.setFont(Theme.small());
            stok.setForeground(p.stok > 0 ? Theme.TEXT_MUTED : new Color(0xB9, 0x1C, 0x1C));
            info.add(stok);
            card.add(info, java.awt.BorderLayout.SOUTH);

            add(card, java.awt.BorderLayout.CENTER);

            var plus = UIs.button("+  Tambah", UIs.Btn.PRIMARY);
            plus.setEnabled(p.stok > 0);
            plus.setPreferredSize(new Dimension(132, 34));
            plus.addActionListener(e -> tambahKeKeranjang(p));
            JPanel btnWrap = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
            btnWrap.setOpaque(false);
            btnWrap.add(plus);
            add(btnWrap, java.awt.BorderLayout.SOUTH);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.pocketly.component.RoundPanel chipAntar;
    private com.pocketly.component.RoundPanel chipPickup;
    private javax.swing.JLabel lblGambarPromo;
    private javax.swing.JLabel lblIkonchipAntar;
    private javax.swing.JLabel lblIkonchipPickup;
    private javax.swing.JLabel lblJudulKategori;
    private javax.swing.JLabel lblJudulProduk;
    private javax.swing.JLabel lblJudulchipAntar;
    private javax.swing.JLabel lblJudulchipPickup;
    private javax.swing.JLabel lblPromo1;
    private javax.swing.JLabel lblPromo2;
    private javax.swing.JLabel lblPromoIsi;
    private javax.swing.JLabel lblPromoJudul;
    private javax.swing.JLabel lblSubchipAntar;
    private javax.swing.JLabel lblSubchipPickup;
    private javax.swing.JPanel panelAtas;
    private javax.swing.JPanel panelChips;
    private javax.swing.JPanel panelTengah;
    private javax.swing.JPanel pnlKategori;
    private javax.swing.JPanel pnlProduk;
    private com.pocketly.component.RoundPanel promoCard;
    private com.pocketly.component.RoundPanel promoTeks;
    private javax.swing.JPanel promoWrap;
    private javax.swing.JScrollPane scrollProduk;
    private javax.swing.Box.Filler strut1;
    private javax.swing.Box.Filler strut2;
    private javax.swing.Box.Filler strut3;
    private javax.swing.Box.Filler strutChip;
    private javax.swing.Box.Filler strutPromo;
    private javax.swing.JPanel teksPromo;
    private javax.swing.JPanel teksPromoTeks;
    private javax.swing.JPanel tekschipAntar;
    private javax.swing.JPanel tekschipPickup;
    // End of variables declaration//GEN-END:variables
}
