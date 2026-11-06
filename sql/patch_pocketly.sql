-- =====================================================================
-- Pocketly - Patch skema (untuk database LAMA, opsional)
-- Jalankan SATU KALI bila memakai db_pocketly.sql versi lama.
-- Bila mengimpor db_pocketly.sql versi revisi, patch ini TIDAK diperlukan
-- (aplikasi juga menjalankan patch serupa otomatis saat start).
-- =====================================================================

-- 0. Perlebar kolom password untuk menampung hash PBKDF2
ALTER TABLE pengguna MODIFY COLUMN password VARCHAR(255) NOT NULL;

-- 1. Kolom gambar produk (nama file di folder img/produk)
ALTER TABLE produk ADD COLUMN gambar_produk VARCHAR(255) NULL;

-- 2. Kolom tipe pemesanan pada keranjang (kosong = belum dipilih)
ALTER TABLE keranjang ADD COLUMN tipe_pemesanan ENUM('Pesan antar','Pick up') NULL DEFAULT NULL;

-- 3. Isi gambar 21 produk aktif (file disertakan di folder img/produk)
UPDATE produk SET gambar_produk='indomie-goreng.jpg'       WHERE id_produk='PRD001' AND (gambar_produk IS NULL OR gambar_produk='');
UPDATE produk SET gambar_produk='roti-sari-roti.jpg'       WHERE id_produk='PRD002' AND (gambar_produk IS NULL OR gambar_produk='');
UPDATE produk SET gambar_produk='aqua-600ml.jpg'           WHERE id_produk='PRD004' AND (gambar_produk IS NULL OR gambar_produk='');
UPDATE produk SET gambar_produk='teh-botol-sosro.jpg'      WHERE id_produk='PRD005' AND (gambar_produk IS NULL OR gambar_produk='');
UPDATE produk SET gambar_produk='minyak-bimoli.jpg'        WHERE id_produk='PRD007' AND (gambar_produk IS NULL OR gambar_produk='');
UPDATE produk SET gambar_produk='beras-pandan-wangi.jpg'   WHERE id_produk='PRD008' AND (gambar_produk IS NULL OR gambar_produk='');
UPDATE produk SET gambar_produk='gula-pasir.jpg'           WHERE id_produk='PRD009' AND (gambar_produk IS NULL OR gambar_produk='');
UPDATE produk SET gambar_produk='pampers-baby-dry.jpg'     WHERE id_produk='PRD010' AND (gambar_produk IS NULL OR gambar_produk='');
UPDATE produk SET gambar_produk='sgm-eksplor.jpg'          WHERE id_produk='PRD011' AND (gambar_produk IS NULL OR gambar_produk='');
UPDATE produk SET gambar_produk='bedak-bayi-zwitsal.jpg'   WHERE id_produk='PRD012' AND (gambar_produk IS NULL OR gambar_produk='');
UPDATE produk SET gambar_produk='whiskas-tuna.jpg'         WHERE id_produk='PRD013' AND (gambar_produk IS NULL OR gambar_produk='');
UPDATE produk SET gambar_produk='meo-kitten.jpg'           WHERE id_produk='PRD015' AND (gambar_produk IS NULL OR gambar_produk='');
UPDATE produk SET gambar_produk='sunsilk-shampoo.jpg'      WHERE id_produk='PRD016' AND (gambar_produk IS NULL OR gambar_produk='');
UPDATE produk SET gambar_produk='pepsodent-pasta-gigi.jpg' WHERE id_produk='PRD017' AND (gambar_produk IS NULL OR gambar_produk='');
UPDATE produk SET gambar_produk='lifebuoy-sabun.jpg'       WHERE id_produk='PRD018' AND (gambar_produk IS NULL OR gambar_produk='');
UPDATE produk SET gambar_produk='panadol-biru.jpg'         WHERE id_produk='PRD019' AND (gambar_produk IS NULL OR gambar_produk='');
UPDATE produk SET gambar_produk='wipol-karbol.jpg'         WHERE id_produk='PRD020' AND (gambar_produk IS NULL OR gambar_produk='');
UPDATE produk SET gambar_produk='antis-hand-sanitizer.jpg' WHERE id_produk='PRD021' AND (gambar_produk IS NULL OR gambar_produk='');
UPDATE produk SET gambar_produk='baterai-abc-aa.jpg'       WHERE id_produk='PRD022' AND (gambar_produk IS NULL OR gambar_produk='');
UPDATE produk SET gambar_produk='korek-api-tokai.jpg'      WHERE id_produk='PRD023' AND (gambar_produk IS NULL OR gambar_produk='');
UPDATE produk SET gambar_produk='tisu-paseo.jpg'           WHERE id_produk='PRD024' AND (gambar_produk IS NULL OR gambar_produk='');
