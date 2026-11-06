-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Nov 04, 2026 at 11:08 AM
-- Server version: 8.0.30
-- PHP Version: 8.1.10

-- =====================================================================
-- Pocketly - Database db_pocketly (Revisi)
-- Perubahan dari versi sebelumnya:
--   1. produk.gambar_produk : VARCHAR(255) nama file gambar di img/produk
--      (21 produk aktif sudah diisi; file gambar disertakan di projek)
--   2. keranjang.tipe_pemesanan : ENUM('Pesan antar','Pick up') NULL
--      (default kosong; dipilih pelanggan lewat dropdown saat checkout)
-- Catatan: password akun lama masih berupa teks biasa; akun yang dibuat
-- lewat form registrasi baru otomatis tersimpan sebagai hash PBKDF2.
-- =====================================================================

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_pocketly`
--

-- --------------------------------------------------------

--
-- Table structure for table `detail_transaksi`
--

CREATE TABLE `detail_transaksi` (
  `id_detail_transaksi` varchar(20) NOT NULL,
  `jumlah_beli` int NOT NULL,
  `harga_transaksi` decimal(10,2) NOT NULL,
  `subtotal_item` decimal(10,2) NOT NULL,
  `id_transaksi` varchar(20) NOT NULL,
  `id_produk` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `detail_transaksi`
--

INSERT INTO `detail_transaksi` (`id_detail_transaksi`, `jumlah_beli`, `harga_transaksi`, `subtotal_item`, `id_transaksi`, `id_produk`) VALUES
('DTL001', 5, '3500.00', '17500.00', 'TRX001', 'PRD001'),
('DTL002', 6, '4000.00', '24000.00', 'TRX002', 'PRD004'),
('DTL003', 2, '21000.00', '42000.00', 'TRX003', 'PRD007'),
('DTL004', 3, '15500.00', '46500.00', 'TRX004', 'PRD017'),
('DTL005', 4, '17500.00', '70000.00', 'TRX005', 'PRD009'),
('DTL006', 10, '6000.00', '60000.00', 'TRX006', 'PRD005'),
('DTL007', 2, '19500.00', '39000.00', 'TRX007', 'PRD016'),
('DTL008', 5, '8500.00', '42500.00', 'TRX008', 'PRD022'),
('DTL009', 3, '17000.00', '51000.00', 'TRX009', 'PRD024'),
('DTL010', 1, '72000.00', '72000.00', 'TRX021', 'PRD008'),
('DTL011', 2, '98000.00', '196000.00', 'TRX022', 'PRD010'),
('DTL012', 1, '59000.00', '59000.00', 'TRX023', 'PRD013'),
('DTL013', 4, '11000.00', '44000.00', 'TRX024', 'PRD019'),
('DTL014', 2, '18000.00', '36000.00', 'TRX025', 'PRD020'),
('DTL015', 3, '16500.00', '49500.00', 'TRX026', 'PRD002'),
('DTL016', 2, '62000.00', '124000.00', 'TRX027', 'PRD011'),
('DTL017', 5, '27000.00', '135000.00', 'TRX028', 'PRD015');

-- --------------------------------------------------------

--
-- Table structure for table `kategori_produk`
--

CREATE TABLE `kategori_produk` (
  `id_kategori` varchar(20) NOT NULL,
  `nama_kategori` enum('Makanan','Minuman','Dapur dan Bahan Masak','Ibu dan Anak','Makanan Hewan','Perawatan Diri','Kesehatan dan Kebersihan','Lainnya') NOT NULL,
  `lokasi_rak` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `kategori_produk`
--

INSERT INTO `kategori_produk` (`id_kategori`, `nama_kategori`, `lokasi_rak`) VALUES
('KTG01', 'Makanan', 'Rak A1'),
('KTG02', 'Minuman', 'Rak B1'),
('KTG03', 'Dapur dan Bahan Masak', 'Rak C1'),
('KTG04', 'Ibu dan Anak', 'Rak D1'),
('KTG05', 'Makanan Hewan', 'Rak E1'),
('KTG06', 'Perawatan Diri', 'Rak F1'),
('KTG07', 'Kesehatan dan Kebersihan', 'Rak G1'),
('KTG08', 'Lainnya', 'Rak H1');

-- --------------------------------------------------------

--
-- Table structure for table `keranjang`
--

CREATE TABLE `keranjang` (
  `id_keranjang` varchar(20) NOT NULL,
  `jumlah_barang` int NOT NULL,
  `subtotal_estimasi` decimal(10,2) NOT NULL,
  `tipe_pemesanan` enum('Pesan antar','Pick up') DEFAULT NULL,
  `id_produk` varchar(20) NOT NULL,
  `pelanggan_username` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `keranjang`
--

INSERT INTO `keranjang` (`id_keranjang`, `jumlah_barang`, `subtotal_estimasi`, `tipe_pemesanan`, `id_produk`, `pelanggan_username`) VALUES
('KRJ001', 10, '35000.00', NULL, 'PRD001', 'rina_ayu'),
('KRJ002', 6, '24000.00', NULL, 'PRD004', 'rina_ayu'),
('KRJ003', 2, '42000.00', NULL, 'PRD007', 'budi_san'),
('KRJ004', 1, '18500.00', NULL, 'PRD012', 'siti_aminah'),
('KRJ005', 2, '118000.00', NULL, 'PRD013', 'agus_prayitno'),
('KRJ006', 3, '58500.00', NULL, 'PRD016', 'dewi_angg'),
('KRJ007', 2, '35000.00', NULL, 'PRD009', 'eko_wahyudi'),
('KRJ008', 1, '98000.00', NULL, 'PRD010', 'fitri_handayani'),
('KRJ009', 2, '22000.00', NULL, 'PRD019', 'hasan_basri'),
('KRJ010', 3, '28500.00', NULL, 'PRD021', 'indah_permata'),
('KRJ011', 12, '72000.00', NULL, 'PRD005', 'joko_susilo'),
('KRJ012', 5, '22500.00', NULL, 'PRD018', 'kartika_sari'),
('KRJ013', 1, '62000.00', NULL, 'PRD011', 'laila_rahma'),
('KRJ014', 1, '18000.00', NULL, 'PRD020', 'muh_ridwan'),
('KRJ015', 4, '34000.00', NULL, 'PRD022', 'nanda_pratama'),
('KRJ016', 2, '34000.00', NULL, 'PRD024', 'putri_melati'),
('KRJ017', 3, '81000.00', NULL, 'PRD015', 'rina_ayu'),
('KRJ018', 2, '33000.00', NULL, 'PRD002', 'budi_san'),
('KRJ019', 10, '30000.00', NULL, 'PRD023', 'joko_susilo'),
('KRJ020', 1, '72000.00', NULL, 'PRD008', 'indah_permata');

-- --------------------------------------------------------

--
-- Table structure for table `offline`
--

CREATE TABLE `offline` (
  `id_transaksi` varchar(20) NOT NULL,
  `nominal_bayar` decimal(10,2) NOT NULL,
  `nominal_kembalian` decimal(10,2) NOT NULL,
  `nama_pembeli` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `offline`
--

INSERT INTO `offline` (`id_transaksi`, `nominal_bayar`, `nominal_kembalian`, `nama_pembeli`) VALUES
('TRX001', '20000.00', '2500.00', 'Ahmad Fauzi'),
('TRX002', '25000.00', '1000.00', 'Yuliana Putri'),
('TRX003', '42000.00', '0.00', 'Bambang Hermawan'),
('TRX004', '46500.00', '0.00', 'Sri Wahyuni'),
('TRX005', '100000.00', '30000.00', 'Rahmat Hidayat'),
('TRX006', '60000.00', '0.00', 'Tri Handoko'),
('TRX007', '39000.00', '0.00', 'Lia Kurniasih'),
('TRX008', '0.00', '0.00', 'Dedi Kurniawan'),
('TRX009', '0.00', '0.00', 'Nurul Fadilah'),
('TRX010', '35000.00', '2000.00', 'Reza Mahendra'),
('TRX011', '28500.00', '0.00', 'Ayu Lestiani'),
('TRX012', '87000.00', '0.00', 'Hendri Gunawan'),
('TRX013', '20000.00', '5000.00', 'Mega Safitri'),
('TRX014', '55000.00', '1000.00', 'Imam Syafii'),
('TRX015', '22500.00', '0.00', 'Winda Oktaviani'),
('TRX016', '65000.00', '0.00', 'Taufik Rahman'),
('TRX017', '15000.00', '3000.00', 'Erna Susanti'),
('TRX018', '36000.00', '0.00', 'Rizki Ramadhan'),
('TRX019', '50000.00', '2000.00', 'Fani Anggraeni'),
('TRX020', '0.00', '0.00', 'Yusuf Maulana');

-- --------------------------------------------------------

--
-- Table structure for table `online`
--

CREATE TABLE `online` (
  `id_transaksi` varchar(20) NOT NULL,
  `tipe_pemesanan` enum('Pick up','Pesan antar') NOT NULL,
  `kode_transaksi_cash` varchar(30) DEFAULT NULL,
  `bukti_pembayaran` varchar(255) DEFAULT NULL,
  `status_pesanan` enum('Dikemas','Siap diambil','Dikirim','Selesai','Dibatalkan') NOT NULL DEFAULT 'Dikemas',
  `biaya_ongkir` decimal(10,2) NOT NULL,
  `pelanggan_username` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `online`
--

INSERT INTO `online` (`id_transaksi`, `tipe_pemesanan`, `kode_transaksi_cash`, `bukti_pembayaran`, `status_pesanan`, `biaya_ongkir`, `pelanggan_username`) VALUES
('TRX021', 'Pesan antar', 'CSH-261008-001', NULL, 'Selesai', '5000.00', 'rina_ayu'),
('TRX022', 'Pesan antar', NULL, 'bukti/TRX022_ewallet.jpg', 'Dikirim', '5000.00', 'budi_san'),
('TRX023', 'Pick up', NULL, 'bukti/TRX023_transfer.jpg', 'Siap diambil', '0.00', 'siti_aminah'),
('TRX024', 'Pick up', 'CSH-261011-002', NULL, 'Selesai', '0.00', 'agus_prayitno'),
('TRX025', 'Pesan antar', NULL, 'bukti/TRX025_ewallet.jpg', 'Dikemas', '5000.00', 'dewi_angg'),
('TRX026', 'Pick up', NULL, 'bukti/TRX026_transfer.jpg', 'Dikemas', '0.00', 'eko_wahyudi'),
('TRX027', 'Pesan antar', 'CSH-261014-003', NULL, 'Dibatalkan', '5000.00', 'fitri_handayani'),
('TRX028', 'Pick up', NULL, 'bukti/TRX028_ewallet.jpg', 'Dibatalkan', '0.00', 'hasan_basri'),
('TRX029', 'Pick up', 'CSH-261015-004', NULL, 'Selesai', '0.00', 'indah_permata'),
('TRX030', 'Pesan antar', NULL, 'bukti/TRX030_ewallet.jpg', 'Selesai', '5000.00', 'joko_susilo'),
('TRX031', 'Pesan antar', NULL, 'bukti/TRX031_transfer.jpg', 'Dikirim', '5000.00', 'kartika_sari'),
('TRX032', 'Pick up', 'CSH-261018-005', NULL, 'Siap diambil', '0.00', 'laila_rahma'),
('TRX033', 'Pick up', NULL, 'bukti/TRX033_ewallet.jpg', 'Selesai', '0.00', 'muh_ridwan'),
('TRX034', 'Pesan antar', NULL, 'bukti/TRX034_transfer.jpg', 'Selesai', '5000.00', 'nanda_pratama'),
('TRX035', 'Pick up', 'CSH-261021-006', NULL, 'Selesai', '0.00', 'putri_melati'),
('TRX036', 'Pesan antar', NULL, 'bukti/TRX036_ewallet.jpg', 'Dikemas', '5000.00', 'rina_ayu'),
('TRX037', 'Pesan antar', NULL, 'bukti/TRX037_transfer.jpg', 'Dikemas', '5000.00', 'budi_san'),
('TRX038', 'Pesan antar', 'CSH-261024-007', NULL, 'Dikirim', '5000.00', 'siti_aminah'),
('TRX039', 'Pick up', NULL, 'bukti/TRX039_ewallet.jpg', 'Dibatalkan', '0.00', 'agus_prayitno'),
('TRX040', 'Pesan antar', NULL, 'bukti/TRX040_transfer.jpg', 'Dibatalkan', '5000.00', 'dewi_angg');

-- --------------------------------------------------------

--
-- Table structure for table `pelanggan`
--

CREATE TABLE `pelanggan` (
  `username` varchar(80) NOT NULL,
  `alamat` varchar(255) NOT NULL,
  `tanggal_registrasi` date NOT NULL,
  `email` varchar(254) DEFAULT NULL,
  `nama` varchar(50) DEFAULT NULL,
  `no_telp` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `pelanggan`
--

INSERT INTO `pelanggan` (`username`, `alamat`, `tanggal_registrasi`, `email`, `nama`, `no_telp`) VALUES
('agus_prayitno', 'Jl. Anggrek No. 3 RT 01', '2026-02-18', 'agus.prayitno@gmail.com', 'Agus Prayitno', '081352748196'),
('budi_san', 'Jl. Melati No. 7 RT 02', '2026-01-24', 'budi.santoso88@gmail.com', 'Budi Santoso', '085779312045'),
('dewi_angg', 'Jl. Dahlia No. 15 RT 06', '2026-03-05', 'dewi.anggraini@outlook.com', 'Dewi Anggraini', '082189467320'),
('eko_wahyudi', 'Jl. Cempaka No. 9 RT 04', '2026-03-22', 'eko.wahyudi@gmail.com', 'Eko Wahyudi', '087854109632'),
('fitri_handayani', 'Jl. Flamboyan No. 30 RT 03', '2026-04-08', 'fitriani.handayani@yahoo.co.id', 'Fitriani Handayani', '081236985074'),
('hasan_basri', 'Jl. Teratai No. 18 RT 07', '2026-04-27', 'hasan.basri@gmail.com', 'Hasan Basri', '089674231587'),
('indah_permata', 'Jl. Bougenville No. 5 RT 09', '2026-05-12', 'indah.permatasari@gmail.com', 'Indah Permatasari', '085238764910'),
('joko_susilo', 'Jl. Seruni No. 44 RT 10', '2026-06-01', 'joko.susilo@yahoo.com', 'Joko Susilo', '081917356428'),
('kartika_sari', 'Jl. Sedap Malam No. 8 RT 02', '2026-06-19', 'kartika.sari@gmail.com', 'Kartika Sari', '082251890673'),
('laila_rahma', 'Jl. Kamboja No. 26 RT 05', '2026-07-07', 'laila.rahmawati@outlook.com', 'Laila Rahmawati', '087739502841'),
('muh_ridwan', 'Jl. Pelita No. 11 RT 01', '2026-07-30', 'm.ridwan@gmail.com', 'Muhammad Ridwan', '081298437615'),
('nanda_pratama', 'Jl. Harapan No. 2 RT 06', '2026-08-14', 'nanda.pratama@gmail.com', 'Nanda Pratama', '085604172398'),
('putri_melati', 'Jl. Sejahtera No. 19 RT 03', '2026-09-02', 'putri.melati@yahoo.com', 'Putri Melati', '089512860347'),
('rina_ayu', 'Jl. Mawar No. 12 RT 05', '2026-01-10', 'rina.ayuningtyas@gmail.com', 'Rina Ayuningtyas', '081374905286'),
('siti_aminah', 'Jl. Kenanga No. 21 RT 08', '2026-02-03', 'siti.aminah@yahoo.com', 'Siti Aminah', '082347618059');

-- --------------------------------------------------------

--
-- Table structure for table `pengguna`
--

CREATE TABLE `pengguna` (
  `username` varchar(80) NOT NULL,
  `password` varchar(255) NOT NULL,
  `peran_pengguna` enum('Petugas','Pelanggan') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `pengguna`
--

INSERT INTO `pengguna` (`username`, `password`, `peran_pengguna`) VALUES
('agus_prayitno', 'AgusPr$9953', 'Pelanggan'),
('budi_san', 'BudiSan!7731', 'Pelanggan'),
('dewi_angg', 'DewiAn#1064', 'Pelanggan'),
('eko_wahyudi', 'EkoWah!2175', 'Pelanggan'),
('fitri_handayani', 'FitriHd@3286', 'Pelanggan'),
('hasan_basri', 'HasanBs$4397', 'Pelanggan'),
('indah_permata', 'IndahPm#5408', 'Pelanggan'),
('joko_susilo', 'JokoSu!6519', 'Pelanggan'),
('kartika_sari', 'KartikaS@7620', 'Pelanggan'),
('laila_rahma', 'LailaRh$8731', 'Pelanggan'),
('muh_ridwan', 'MuhRidw#9842', 'Pelanggan'),
('nanda_pratama', 'NandaPr!1953', 'Pelanggan'),
('ptg_andi', 'Andi@Pocket#01', 'Petugas'),
('ptg_dewi', 'Dewi*Kasir@04', 'Petugas'),
('ptg_rudi', 'Rudi!Kasir#03', 'Petugas'),
('ptg_siti', 'SitiAdm$Pk02', 'Petugas'),
('putri_melati', 'PutriMl@2064', 'Pelanggan'),
('rina_ayu', 'RinaAyu#2026a', 'Pelanggan'),
('siti_aminah', 'SitiAm@8842', 'Pelanggan');

-- --------------------------------------------------------

--
-- Table structure for table `petugas`
--

CREATE TABLE `petugas` (
  `username` varchar(80) NOT NULL,
  `nip` varchar(30) NOT NULL,
  `jabatan` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `petugas`
--

INSERT INTO `petugas` (`username`, `nip`, `jabatan`) VALUES
('ptg_andi', 'PTG-2026-001', 'Admin'),
('ptg_dewi', 'PTG-2026-004', 'Kasir'),
('ptg_rudi', 'PTG-2026-003', 'Kasir'),
('ptg_siti', 'PTG-2026-002', 'Admin');

-- --------------------------------------------------------

--
-- Table structure for table `produk`
--

CREATE TABLE `produk` (
  `id_produk` varchar(20) NOT NULL,
  `nama_produk` varchar(150) NOT NULL,
  `harga_satuan` decimal(10,2) NOT NULL,
  `stok` int NOT NULL DEFAULT '0',
  `satuan_barang` varchar(20) NOT NULL,
  `id_kategori` varchar(20) NOT NULL,
  `petugas_username` varchar(80) NOT NULL,
  `status_produk` enum('Aktif','Nonaktif') DEFAULT NULL,
  `gambar_produk` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `produk`
--

INSERT INTO `produk` (`id_produk`, `nama_produk`, `harga_satuan`, `stok`, `satuan_barang`, `id_kategori`, `petugas_username`, `status_produk`, `gambar_produk`) VALUES
('PRD001', 'Indomie Goreng', '3500.00', 200, 'bungkus', 'KTG01', 'ptg_andi', 'Aktif', 'indomie-goreng.jpg'),
('PRD002', 'Roti Tawar Sari Roti', '16500.00', 40, 'bungkus', 'KTG01', 'ptg_andi', 'Aktif', 'roti-sari-roti.jpg'),
('PRD003', 'Chitato Sapi Panggang 68g', '11000.00', 80, 'bungkus', 'KTG01', 'ptg_siti', 'Nonaktif', NULL),
('PRD004', 'Aqua Botol 600ml', '4000.00', 240, 'botol', 'KTG02', 'ptg_andi', 'Aktif', 'aqua-600ml.jpg'),
('PRD005', 'Teh Botol Sosro 450ml', '6000.00', 120, 'botol', 'KTG02', 'ptg_siti', 'Aktif', 'teh-botol-sosro.jpg'),
('PRD006', 'Ultra Milk Cokelat 250ml', '7500.00', 0, 'kotak', 'KTG02', 'ptg_siti', 'Nonaktif', NULL),
('PRD007', 'Minyak Goreng Bimoli 1L', '21000.00', 60, 'pouch', 'KTG03', 'ptg_andi', 'Aktif', 'minyak-bimoli.jpg'),
('PRD008', 'Beras Pandan Wangi 5kg', '72000.00', 30, 'karung', 'KTG03', 'ptg_siti', 'Aktif', 'beras-pandan-wangi.jpg'),
('PRD009', 'Gula Pasir Gulaku 1kg', '17500.00', 70, 'bungkus', 'KTG03', 'ptg_andi', 'Aktif', 'gula-pasir.jpg'),
('PRD010', 'Pampers Baby Dry Size M', '98000.00', 25, 'pak', 'KTG04', 'ptg_siti', 'Aktif', 'pampers-baby-dry.jpg'),
('PRD011', 'SGM Eksplor 1+ 400g', '62000.00', 20, 'kotak', 'KTG04', 'ptg_andi', 'Aktif', 'sgm-eksplor.jpg'),
('PRD012', 'Bedak Bayi Zwitsal 100g', '18500.00', 35, 'pcs', 'KTG04', 'ptg_siti', 'Aktif', 'bedak-bayi-zwitsal.jpg'),
('PRD013', 'Whiskas Tuna 1.2kg', '59000.00', 15, 'pak', 'KTG05', 'ptg_andi', 'Aktif', 'whiskas-tuna.jpg'),
('PRD014', 'Pedigree Beef 1.5kg', '78000.00', 12, 'pak', 'KTG05', 'ptg_siti', 'Nonaktif', NULL),
('PRD015', 'Me-O Kitten 400g', '27000.00', 30, 'pak', 'KTG05', 'ptg_andi', 'Aktif', 'meo-kitten.jpg'),
('PRD016', 'Sunsilk Shampoo 170ml', '19500.00', 50, 'botol', 'KTG06', 'ptg_siti', 'Aktif', 'sunsilk-shampoo.jpg'),
('PRD017', 'Pepsodent Pasta Gigi 190g', '15500.00', 90, 'tube', 'KTG06', 'ptg_andi', 'Aktif', 'pepsodent-pasta-gigi.jpg'),
('PRD018', 'Lifebuoy Sabun Mandi 100g', '4500.00', 150, 'batang', 'KTG06', 'ptg_siti', 'Aktif', 'lifebuoy-sabun.jpg'),
('PRD019', 'Panadol Biru 10 Tablet', '11000.00', 60, 'strip', 'KTG07', 'ptg_andi', 'Aktif', 'panadol-biru.jpg'),
('PRD020', 'Wipol Karbol 750ml', '18000.00', 45, 'botol', 'KTG07', 'ptg_siti', 'Aktif', 'wipol-karbol.jpg'),
('PRD021', 'Antis Hand Sanitizer 55ml', '9500.00', 70, 'botol', 'KTG07', 'ptg_andi', 'Aktif', 'antis-hand-sanitizer.jpg'),
('PRD022', 'Baterai ABC AA 2 pcs', '8500.00', 80, 'pak', 'KTG08', 'ptg_siti', 'Aktif', 'baterai-abc-aa.jpg'),
('PRD023', 'Korek Api Tokai', '3000.00', 100, 'pcs', 'KTG08', 'ptg_andi', 'Aktif', 'korek-api-tokai.jpg'),
('PRD024', 'Tisu Paseo 250 Sheet', '17000.00', 55, 'pak', 'KTG08', 'ptg_siti', 'Aktif', 'tisu-paseo.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `id_transaksi` varchar(20) NOT NULL,
  `tanggal_transaksi` date NOT NULL,
  `jenis_transaksi` enum('Offline','Online') NOT NULL,
  `metode_pembayaran` enum('Cash','E-Wallet','M-Bangking') NOT NULL,
  `status_pembayaran` enum('Menunggu verifikasi','Berhasil','Dibatalkan') NOT NULL DEFAULT 'Menunggu verifikasi',
  `total_bayar` decimal(15,2) NOT NULL,
  `waktu_lunas` date DEFAULT NULL,
  `petugas_username` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`id_transaksi`, `tanggal_transaksi`, `jenis_transaksi`, `metode_pembayaran`, `status_pembayaran`, `total_bayar`, `waktu_lunas`, `petugas_username`) VALUES
('TRX001', '2026-10-01', 'Offline', 'Cash', 'Berhasil', '17500.00', '2026-10-01', 'ptg_rudi'),
('TRX002', '2026-10-01', 'Offline', 'Cash', 'Berhasil', '24000.00', '2026-10-01', 'ptg_dewi'),
('TRX003', '2026-10-02', 'Offline', 'E-Wallet', 'Berhasil', '42000.00', '2026-10-02', 'ptg_rudi'),
('TRX004', '2026-10-02', 'Offline', 'M-Bangking', 'Berhasil', '46500.00', '2026-10-02', 'ptg_dewi'),
('TRX005', '2026-10-03', 'Offline', 'Cash', 'Berhasil', '70000.00', '2026-10-03', 'ptg_rudi'),
('TRX006', '2026-10-03', 'Offline', 'E-Wallet', 'Menunggu verifikasi', '60000.00', NULL, 'ptg_dewi'),
('TRX007', '2026-10-04', 'Offline', 'M-Bangking', 'Menunggu verifikasi', '39000.00', NULL, 'ptg_rudi'),
('TRX008', '2026-10-04', 'Offline', 'Cash', 'Dibatalkan', '42500.00', NULL, 'ptg_dewi'),
('TRX009', '2026-10-05', 'Offline', 'E-Wallet', 'Dibatalkan', '51000.00', NULL, 'ptg_rudi'),
('TRX010', '2026-10-05', 'Offline', 'Cash', 'Berhasil', '33000.00', '2026-10-05', 'ptg_dewi'),
('TRX011', '2026-10-06', 'Offline', 'E-Wallet', 'Berhasil', '28500.00', '2026-10-06', 'ptg_rudi'),
('TRX012', '2026-10-06', 'Offline', 'M-Bangking', 'Berhasil', '87000.00', '2026-10-06', 'ptg_dewi'),
('TRX013', '2026-10-07', 'Offline', 'Cash', 'Berhasil', '15000.00', '2026-10-07', 'ptg_rudi'),
('TRX014', '2026-10-08', 'Offline', 'Cash', 'Berhasil', '54000.00', '2026-10-08', 'ptg_dewi'),
('TRX015', '2026-10-09', 'Offline', 'E-Wallet', 'Berhasil', '22500.00', '2026-10-09', 'ptg_rudi'),
('TRX016', '2026-10-10', 'Offline', 'M-Bangking', 'Berhasil', '65000.00', '2026-10-10', 'ptg_dewi'),
('TRX017', '2026-10-12', 'Offline', 'Cash', 'Berhasil', '12000.00', '2026-10-12', 'ptg_rudi'),
('TRX018', '2026-10-14', 'Offline', 'E-Wallet', 'Menunggu verifikasi', '36000.00', NULL, 'ptg_dewi'),
('TRX019', '2026-10-15', 'Offline', 'Cash', 'Berhasil', '48000.00', '2026-10-15', 'ptg_rudi'),
('TRX020', '2026-10-16', 'Offline', 'M-Bangking', 'Dibatalkan', '77000.00', NULL, 'ptg_dewi'),
('TRX021', '2026-10-08', 'Online', 'Cash', 'Berhasil', '77000.00', '2026-10-10', 'ptg_rudi'),
('TRX022', '2026-10-09', 'Online', 'E-Wallet', 'Berhasil', '201000.00', '2026-10-09', 'ptg_dewi'),
('TRX023', '2026-10-10', 'Online', 'M-Bangking', 'Berhasil', '59000.00', '2026-10-10', 'ptg_rudi'),
('TRX024', '2026-10-11', 'Online', 'Cash', 'Berhasil', '44000.00', '2026-10-12', 'ptg_dewi'),
('TRX025', '2026-10-12', 'Online', 'E-Wallet', 'Menunggu verifikasi', '41000.00', NULL, 'ptg_rudi'),
('TRX026', '2026-10-13', 'Online', 'M-Bangking', 'Menunggu verifikasi', '49500.00', NULL, 'ptg_dewi'),
('TRX027', '2026-10-14', 'Online', 'Cash', 'Dibatalkan', '129000.00', NULL, 'ptg_rudi'),
('TRX028', '2026-10-15', 'Online', 'E-Wallet', 'Dibatalkan', '135000.00', NULL, 'ptg_dewi'),
('TRX029', '2026-10-15', 'Online', 'Cash', 'Berhasil', '56000.00', '2026-10-16', 'ptg_rudi'),
('TRX030', '2026-10-16', 'Online', 'E-Wallet', 'Berhasil', '88000.00', '2026-10-16', 'ptg_dewi'),
('TRX031', '2026-10-17', 'Online', 'M-Bangking', 'Berhasil', '121500.00', '2026-10-17', 'ptg_rudi'),
('TRX032', '2026-10-18', 'Online', 'Cash', 'Menunggu verifikasi', '37000.00', NULL, 'ptg_dewi'),
('TRX033', '2026-10-19', 'Online', 'E-Wallet', 'Berhasil', '64500.00', '2026-10-19', 'ptg_rudi'),
('TRX034', '2026-10-20', 'Online', 'M-Bangking', 'Berhasil', '205000.00', '2026-10-20', 'ptg_dewi'),
('TRX035', '2026-10-21', 'Online', 'Cash', 'Berhasil', '29000.00', '2026-10-22', 'ptg_rudi'),
('TRX036', '2026-10-22', 'Online', 'E-Wallet', 'Berhasil', '77000.00', '2026-10-22', 'ptg_dewi'),
('TRX037', '2026-10-23', 'Online', 'M-Bangking', 'Menunggu verifikasi', '96000.00', NULL, 'ptg_rudi'),
('TRX038', '2026-10-24', 'Online', 'Cash', 'Menunggu verifikasi', '45500.00', NULL, 'ptg_dewi'),
('TRX039', '2026-10-25', 'Online', 'E-Wallet', 'Dibatalkan', '39000.00', NULL, 'ptg_rudi'),
('TRX040', '2026-10-26', 'Online', 'M-Bangking', 'Dibatalkan', '153000.00', NULL, 'ptg_dewi');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `detail_transaksi`
--
ALTER TABLE `detail_transaksi`
  ADD PRIMARY KEY (`id_detail_transaksi`),
  ADD KEY `id_transaksi` (`id_transaksi`),
  ADD KEY `id_produk` (`id_produk`);

--
-- Indexes for table `kategori_produk`
--
ALTER TABLE `kategori_produk`
  ADD PRIMARY KEY (`id_kategori`);

--
-- Indexes for table `keranjang`
--
ALTER TABLE `keranjang`
  ADD PRIMARY KEY (`id_keranjang`),
  ADD KEY `id_produk` (`id_produk`),
  ADD KEY `pelanggan_username` (`pelanggan_username`);

--
-- Indexes for table `offline`
--
ALTER TABLE `offline`
  ADD PRIMARY KEY (`id_transaksi`);

--
-- Indexes for table `online`
--
ALTER TABLE `online`
  ADD PRIMARY KEY (`id_transaksi`),
  ADD KEY `pelanggan_username` (`pelanggan_username`);

--
-- Indexes for table `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `pengguna`
--
ALTER TABLE `pengguna`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `petugas`
--
ALTER TABLE `petugas`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `produk`
--
ALTER TABLE `produk`
  ADD PRIMARY KEY (`id_produk`),
  ADD KEY `id_kategori` (`id_kategori`),
  ADD KEY `petugas_username` (`petugas_username`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id_transaksi`),
  ADD KEY `petugas_username` (`petugas_username`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `detail_transaksi`
--
ALTER TABLE `detail_transaksi`
  ADD CONSTRAINT `detail_transaksi_ibfk_1` FOREIGN KEY (`id_transaksi`) REFERENCES `transaksi` (`id_transaksi`),
  ADD CONSTRAINT `detail_transaksi_ibfk_2` FOREIGN KEY (`id_produk`) REFERENCES `produk` (`id_produk`);

--
-- Constraints for table `keranjang`
--
ALTER TABLE `keranjang`
  ADD CONSTRAINT `keranjang_ibfk_1` FOREIGN KEY (`id_produk`) REFERENCES `produk` (`id_produk`),
  ADD CONSTRAINT `keranjang_ibfk_2` FOREIGN KEY (`pelanggan_username`) REFERENCES `pelanggan` (`username`);

--
-- Constraints for table `offline`
--
ALTER TABLE `offline`
  ADD CONSTRAINT `offline_ibfk_1` FOREIGN KEY (`id_transaksi`) REFERENCES `transaksi` (`id_transaksi`);

--
-- Constraints for table `online`
--
ALTER TABLE `online`
  ADD CONSTRAINT `online_ibfk_1` FOREIGN KEY (`id_transaksi`) REFERENCES `transaksi` (`id_transaksi`),
  ADD CONSTRAINT `online_ibfk_2` FOREIGN KEY (`pelanggan_username`) REFERENCES `pelanggan` (`username`);

--
-- Constraints for table `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD CONSTRAINT `pelanggan_ibfk_1` FOREIGN KEY (`username`) REFERENCES `pengguna` (`username`);

--
-- Constraints for table `petugas`
--
ALTER TABLE `petugas`
  ADD CONSTRAINT `petugas_ibfk_1` FOREIGN KEY (`username`) REFERENCES `pengguna` (`username`);

--
-- Constraints for table `produk`
--
ALTER TABLE `produk`
  ADD CONSTRAINT `produk_ibfk_1` FOREIGN KEY (`id_kategori`) REFERENCES `kategori_produk` (`id_kategori`),
  ADD CONSTRAINT `produk_ibfk_2` FOREIGN KEY (`petugas_username`) REFERENCES `petugas` (`username`);

--
-- Constraints for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `transaksi_ibfk_1` FOREIGN KEY (`petugas_username`) REFERENCES `petugas` (`username`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
