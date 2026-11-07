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

        setBackground(Theme.PAGE_BG);
        setBorder(javax.swing.BorderFactory.createEmptyBorder(22, 26, 22, 26));
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setName(""); // NOI18N
        setOpaque(false);
        setLayout(new java.awt.BorderLayout());

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

        lblPromo1.setFont(Theme.font(java.awt.Font.BOLD, 15));
        lblPromo1.setForeground(Theme.NAVY);
        lblPromo1.setText("Jangan lupa checkout");
        teksPromo.add(lblPromo1);

        lblPromo2.setFont(Theme.font(java.awt.Font.BOLD, 15));
        lblPromo2.setForeground(Theme.NAVY);
        lblPromo2.setText("keranjangmu ya!");
        teksPromo.add(lblPromo2);

        lblGambarPromo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ui/promo-checkout.png"))); // NOI18N

        javax.swing.GroupLayout promoCardLayout = new javax.swing.GroupLayout(promoCard);
        promoCard.setLayout(promoCardLayout);
        promoCardLayout.setHorizontalGroup(
            promoCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(promoCardLayout.createSequentialGroup()
                .addComponent(teksPromo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 551, Short.MAX_VALUE)
                .addComponent(lblGambarPromo)
                .addGap(17, 17, 17))
        );
        promoCardLayout.setVerticalGroup(
            promoCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(promoCardLayout.createSequentialGroup()
                .addGroup(promoCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(promoCardLayout.createSequentialGroup()
                        .addComponent(teksPromo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(promoCardLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblGambarPromo)))
                .addContainerGap())
        );

        promoWrap.add(promoCard);

        promoTeks.setBackground(Theme.CARD);
        promoTeks.setBorder(javax.swing.BorderFactory.createEmptyBorder(16, 18, 16, 18));
        promoTeks.setPreferredSize(new java.awt.Dimension(0, 130));
        promoTeks.setRadius(20);
        promoTeks.setLayout(new java.awt.BorderLayout());

        teksPromoTeks.setOpaque(false);
        teksPromoTeks.setLayout(new javax.swing.BoxLayout(teksPromoTeks, javax.swing.BoxLayout.PAGE_AXIS));

        lblPromoJudul.setFont(Theme.font(java.awt.Font.BOLD, 17));
        lblPromoJudul.setForeground(Theme.NAVY);
        lblPromoJudul.setText("<html><div style='width:220px'>Belanja low effort dengan Pocketly</div></html>");
        teksPromoTeks.add(lblPromoJudul);
        teksPromoTeks.add(strutPromo);

        lblPromoIsi.setFont(Theme.font(java.awt.Font.PLAIN, 11));
        lblPromoIsi.setForeground(Theme.TEXT_MUTED);
        lblPromoIsi.setText("<html><div style='width:240px'>Belanja offline dan online ritel pocket kini terintegrasi. Kenyamanan anda adalah prioritas kami.</div></html>");
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

        lblIkonchipAntar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ui/icon-antar.png"))); // NOI18N
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

        lblIkonchipPickup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ui/icon-pickup.png"))); // NOI18N
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

        panelTengah.setMaximumSize(new java.awt.Dimension(1920, 1080));
        panelTengah.setMinimumSize(new java.awt.Dimension(1920, 1080));
        panelTengah.setOpaque(false);
        panelTengah.setPreferredSize(new java.awt.Dimension(1920, 1080));

        lblJudulKategori.setFont(Theme.font(java.awt.Font.BOLD, 16));
        lblJudulKategori.setForeground(Theme.TEXT);
        lblJudulKategori.setText("Kategori Produk");

        pnlKategori.setMaximumSize(new java.awt.Dimension(1920, 1080));
        pnlKategori.setOpaque(false);
        pnlKategori.setLayout(new java.awt.GridLayout(2, 4, 14, 14));

        lblJudulProduk.setFont(Theme.font(java.awt.Font.BOLD, 16));
        lblJudulProduk.setForeground(Theme.TEXT);
        lblJudulProduk.setText("Produk");

        scrollProduk.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        scrollProduk.setOpaque(false);

        pnlProduk.setMaximumSize(new java.awt.Dimension(1920, 1080));
        pnlProduk.setOpaque(false);
        pnlProduk.setLayout(new java.awt.GridLayout(0, 3, 14, 14));
        scrollProduk.setViewportView(pnlProduk);

        javax.swing.GroupLayout panelTengahLayout = new javax.swing.GroupLayout(panelTengah);
        panelTengah.setLayout(panelTengahLayout);
        panelTengahLayout.setHorizontalGroup(
            panelTengahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTengahLayout.createSequentialGroup()
                .addGroup(panelTengahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlKategori, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrollProduk, javax.swing.GroupLayout.DEFAULT_SIZE, 1602, Short.MAX_VALUE)
                    .addGroup(panelTengahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblJudulProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 893, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panelTengahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(strut1, javax.swing.GroupLayout.PREFERRED_SIZE, 899, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(strut2, javax.swing.GroupLayout.PREFERRED_SIZE, 899, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(strut3, javax.swing.GroupLayout.PREFERRED_SIZE, 899, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelTengahLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblJudulKategori)))))
                .addContainerGap(318, Short.MAX_VALUE))
        );
        panelTengahLayout.setVerticalGroup(
            panelTengahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTengahLayout.createSequentialGroup()
                .addComponent(lblJudulKategori)
                .addGap(0, 0, 0)
                .addComponent(strut1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(strut2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblJudulProduk)
                .addGap(0, 0, 0)
                .addComponent(strut3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(panelTengah, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

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
            UIs.info(this, "Item ditambahkan"); 
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
            UIs.error(this, pesan); 
        }
    }

    private class KartuKategori extends JPanel {

        private final Kategori kategori;
        private boolean dipilih;

        private KartuKategori(Kategori k) {
            this.kategori = k;
            setLayout(new java.awt.BorderLayout(0, 2));
            setOpaque(false);
            setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    pilihKategori(kategori);
                }
            });

            JPanel card = UIs.card(16);
            card.setLayout(new java.awt.BorderLayout(0, 2));
            card.setBorder(BorderFactory.createEmptyBorder(6, 6, 4, 6));

            String file = GAMBAR_KATEGORI.getOrDefault(k.id, "");
            JLabel img = new JLabel(UIs.kategoriImage(file));
            img.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            card.add(img, java.awt.BorderLayout.CENTER);

            JLabel nama = new JLabel(k.nama, JLabel.CENTER);
            nama.setFont(Theme.font(Font.PLAIN, 11f));
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
