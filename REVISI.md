# Pocketly — Catatan Revisi (Capstone)

Revisi ini menerapkan seluruh catatan asisten lab, saran asisten, dan desain
UI/UX dari file Figma "TIM 4 - UI/UX". Berikut rincian perubahan per poin.

## 1. Catatan Asisten Lab

| # | Catatan | Status |
|---|---------|--------|
| 1 | Terapkan Prepared Statement | Semua query memakai `PreparedStatement` (termasuk seed gambar pada `DB.ensurePatch`) |
| 2 | Hapus komentar tidak perlu | Komentar dirapikan; tampilan kini dibangun lewat **NetBeans GUI Builder murni** (file `.form` + `initComponents` ter-guard) — lihat bagian 7 |
| 3 | Min–maks username & password + hash | Username 5–20 karakter, password 8–20; password baru disimpan sebagai **hash PBKDF2** (kelas `util/PasswordHasher`). Akun lama tetap bisa masuk (login mode ganda) |
| 4 | Error validation bila database error | Semua aksi DB dibungkus try-catch; kegagalan ditampilkan sebagai dialog yang jelas (contoh: "Gagal menyimpan checkout: …") |
| 5a | Validasi input untuk setiap inputan | Tiap field punya validasi sendiri: username (pola), nama (3–50), alamat (≥5), email (format), no. telp (10–13 digit awalan 0), harga/stok/jumlah (angka) |
| 5b | Tombol + − dan hapus di keranjang pelanggan | Baris keranjang punya tombol − / jumlah / + / OK / Hapus; perubahan langsung tersimpan ke database (stok ikut disesuaikan) |
| 6 | Library untuk unggah file dari file manager | Memakai **`javax.swing.JFileChooser`** — komponen bawaan Java Swing (bukan library tambahan) yang membuka file manager sistem operasi. File bukti disalin ke folder `bukti/` dan hanya **namanya** (VARCHAR) yang disimpan di MySQL |
| 7 | Tombol membulat (rounded) | `UIs.ModernButton`: tombol pill (radius penuh) sesuai Figma (radius 25,5) |
| 8 | Chart pendapatan di dashboard petugas | Grafik batang pendapatan per tanggal, digambar sendiri dengan **Java2D tanpa library tambahan**; otomatis memakai bulan terakhir yang ada datanya bila bulan berjalan kosong |
| 9a | Ubah Stok: tombol +/- tidak bisa diklik | **Diperbaiki.** Penyebab: tombol dibuat di dalam `TableCellRenderer` (hanya gambar, tidak menerima klik). Sekarang klik ditangani `MouseListener` pada tabel → stok tersimpan ke database |
| 9b | Lihat Bukti Pembayaran | **Diperbaiki** dengan pola yang sama; klik membuka pop up bukti + tombol Valid / Tidak Valid |
| 9c | Mengubah Status Verifikasi | **Diperbaiki**; tombol Valid / Tidak Valid pada pop up bukti memperbarui status pembayaran (dan mengembalikan stok bila ditolak) |
| 9d | Ubah Status Pesanan | **Diperbaiki**; tombol "Ubah Status" membuka dropdown status (Dikemas/Siap diambil/Dikirim/Selesai) lalu menyimpan |
| 10 | Pakai UI/UX dari file Figma | Palet warna, font **Lato** (dibundel di `src/main/resources/fonts`), sidebar putih dengan pil navigasi + ikon, kartu bersudut membulat, kolom input `#F1EEEE`, tombol navy `#062349` / aksi `#0071E1` / hapus `#FFC4C4` — semuanya diekstrak langsung dari file `.fig` |

## 2. Saran Asisten

- **Tipe pemesanan memakai dropdown dengan default kosong**: sudah.
  `keranjang.tipe_pemesanan` kini `ENUM('Pesan antar','Pick up') NULL DEFAULT NULL`;
  dropdown di halaman keranjang menampilkan "- Pilih tipe -" (tidak otomatis
  memilih apa pun). Checkout menolak bila belum memilih tipe.

## 3. Perubahan Database (db_pocketly.sql)

1. `produk.foto_produk` diganti **`produk.gambar_produk VARCHAR(255) NULL`**
   berisi nama file gambar di folder `img/produk/` (sesuai kode). 21 produk
   aktif sudah terisi gambarnya — foto asli dari arsip tim (3 produk
   Nonaktif dibiarkan tanpa gambar).
2. `keranjang` ditambah kolom **`tipe_pemesanan`** (boleh kosong).
3. `pengguna.password` diperlebar menjadi **`VARCHAR(255)`** agar muat hash
   PBKDF2 (`pbkdf2$120000$salt$hash`). Akun lama tetap berupa teks biasa
   dan tetap bisa login.
4. `sql/patch_pocketly.sql` disediakan untuk memperbarui database lama tanpa
   import ulang (aplikasi juga menjalankan patch serupa otomatis saat start).

## 4. Perbaikan Bug Tambahan yang Ditemukan Saat Pengujian

- **Checkout multi-item gagal** ("Duplicate entry DTL018"): `DB.nextId`
  membuka koneksi baru sehingga baris yang belum di-commit tidak terlihat →
  ID detail duplikat. Sekarang ID dihitung lewat koneksi transaksi yang sama.
- **Registrasi gagal** karena `pelanggan.no_telp` NOT NULL tetapi form lama
  tidak mengisinya. Form baru mengisi nama, email, dan no. telepon.
- **Registrasi gagal** karena hash PBKDF2 (83 karakter) melebihi kolom
  `password VARCHAR(80)` → kolom diperlebar ke 255.
- Judul keranjang "Keranjang Belanja hahahhahahyyuuk" dibereskan.
- Tombol kecil ("OK", "Hapus", +/−) sempat terpotong teksnya karena padding
  tombol terlalu besar — sudah dirapikan.
- Kolom "Edit" pada tabel produk sempat terpotong tepi kanan — lebar kolom
  disesuaikan agar semua tombol tampil utuh.

## 5. Struktur Folder Gambar

```
img/
  produk/    21 foto produk (dari arsip "image Pocketly")
  kategori/  8 ilustrasi kategori (diekstrak dari file Figma)
  ui/        logo, hero, ikon navigasi, ikon fitur (dari file Figma)
bukti/       contoh bukti pembayaran (data demo)
```

## 6. Cara Menjalankan

1. Import `sql/db_pocketly.sql` ke MySQL (phpMyAdmin) — atau pakai database
   lama + jalankan `sql/patch_pocketly.sql`.
2. Buka projek di NetBeans → **Clean and Build** (Maven mengunduh driver MySQL).
3. Run (F6). Login contoh: `rina_ayu` / `RinaAyu#2026a` (pelanggan),
   `ptg_andi` / `Andi@Pocket#01` (petugas).

## 7. NetBeans GUI Builder (Java Form Builder) Murni

Seluruh tampilan kini adalah **form NetBeans asli** — setiap halaman terdiri
dari **2 file**: *Java class* (mis. `LoginFrame.java`) dan *form file*
(`LoginFrame.form`). Buka file `.java`-nya lalu klik tab **Design** (atau
klik dua kali file `.form`): semua komponen tampil di kanvas GUI Builder,
bisa dilihat, dipilih, digeser, dan diubah propertinya lewat jendela
Properties. Kode tata letak berada di dalam blok ter-guard
`//GEN-BEGIN:initComponents` … `//GEN-END:initComponents` dan otomatis
diperbarui NetBeans saat form diedit — logika aplikasi tetap aman di luar blok.

### 7.1 Daftar 13 form

| Form file | Jenis | Isi |
|---|---|---|
| `view/LoginFrame.form` | JFrame | Halaman login (ilustrasi + kartu form) |
| `view/RegistrasiDialog.form` | JDialog | Registrasi akun pelanggan |
| `view/pelanggan/PelangganFrame.form` | JFrame | Kerangka pelanggan: sidebar + CardLayout |
| `view/pelanggan/BerandaPanel.form` | JPanel | Promo, chip fitur, kategori, produk |
| `view/pelanggan/KeranjangPanel.form` | JPanel | Tipe pemesanan, alamat, daftar item, checkout |
| `view/pelanggan/TransaksiPanel.form` | JPanel | Riwayat transaksi online |
| `view/pelanggan/ProfilPanel.form` | JPanel | Profil + statistik + logout |
| `view/petugas/PetugasFrame.form` | JFrame | Kerangka petugas: sidebar + CardLayout |
| `view/petugas/BerandaPetugasPanel.form` | JPanel | Ringkasan + grafik pendapatan + tabel |
| `view/petugas/KelolaProdukPanel.form` | JPanel | Tabel produk + stok +/- + edit |
| `view/petugas/KasirPanel.form` | JPanel | Kasir offline (input, tabel, bayar) |
| `view/petugas/VerifikasiPanel.form` | JPanel | Verifikasi pembayaran |
| `view/petugas/StatusPanel.form` | JPanel | Ubah status pesanan online |

### 7.2 Komponen kustom (JavaBean) di package `com.pocketly.component`

Supaya desain Figma (tombol pill, kartu membulat, dsb.) tetap muncul di
GUI Builder, komponen kustom berikut adalah JavaBean yang bisa dipakai
langsung di form — atur lewat jendela Properties:

| Bean | Properti khas | Fungsi |
|---|---|---|
| `RoundButton` | `styleName` (primary/action/success/danger/dangerSoft/secondary/ghost/navy) | Tombol pill membulat |
| `RoundTextField` | `placeholder` | Kolom input abu `#F1EEEE` bersudut membulat |
| `RoundPasswordField` | `placeholder` | Kolom password bergaya sama |
| `RoundPanel` | `radius`, `background` | Kartu/panel bersudut membulat |
| `NavPill` | `text`, `iconFile`, `dipilih` | Pil navigasi sidebar dengan ikon |
| `AvatarLabel` | `text` | Avatar lingkaran navy dengan inisial |
| `BadgeLabel` | `text` | Badge bulat jumlah item keranjang |
| `ChartPanel` | data diisi lewat `setData(...)` | Grafik batang pendapatan (Java2D) |

### 7.3 Cara membuka form (penting)

1. Buka projek di NetBeans, tunggu scanning selesai.
2. **Clean and Build dulu (Shift+F11)** — komponen kustom di
   `com.pocketly.component` harus terkompilasi sebelum GUI Builder bisa
   menampilkannya (NetBeans memakai class hasil build untuk me-render bean).
3. Buka `Source Packages → com.pocketly → view → LoginFrame.java`
   lalu klik tab **Design**. Ulangi untuk form lain.
4. Saat form disimpan dari GUI Builder, NetBeans memperbarui isi
   `initComponents()` secara otomatis — tidak perlu (dan tidak boleh) mengedit
   blok ter-guard secara manual.

Catatan teknis: warna memakai *custom code* `Theme.NAVY` dst. dan font memakai
`Theme.font(...)` sehingga tipografi **Lato** tetap konsisten antara design
view dan aplikasi berjalan; properti tersebut bisa dilihat di Properties →
kode. Isi dinamis (baris keranjang, kartu produk, tabel data) tetap diisi
dari kode setelah `initComponents()` — pola standar form NetBeans.

## 8. Revisi GUI Builder — November 2026 (form bebas error + gambar lewat ikon)

### 8.1 Peringatan "Form Loaded With Errors" — DIPERBAIKI

Penyebab: properti `cursor` ditulis sebagai *custom code* di dalam file
`.form`. Properti ini **tidak didukung editor form NetBeans**, sehingga setiap
kali form dibuka muncul dialog
`Error in loading component property: ... ->cursor - No such property exists in the component.`

Perbaikan: properti `cursor` dihapus dari 5 file `.form`
(LoginFrame, RegistrasiDialog, PelangganFrame ×2, PetugasFrame) dan kursor
tangan kini dipasang **satu baris di luar blok ter-guard** setelah
`initComponents()` — GUI Builder tidak membaca kode di luar blok ter-guard,
jadi form terbuka 100% bersih dan efek kursor tangan tetap ada saat aplikasi
berjalan.

### 8.2 Gambar kini lewat properti ikon (Image Within Project) — bukan kode

Semua gambar yang tampil di form tidak lagi dipasang lewat kode
`UIs.asset("...", w, h)`; sekarang memakai **properti `icon` bawaan GUI
Builder** (ikon terlihat langsung di kanvas Design dan bisa diganti lewat
Properties → icon → Image Within Project, package `img.ui`):

| Form | Komponen | File ikon (ukuran asli file = ukuran tampil) |
|---|---|---|
| LoginFrame | `logoKanan` | `img/ui/logo-pocketly-login.png` (176×58) |
| LoginFrame | `jLabel1` (hero) | `img/ui/login-hero.png` (588×594; sebelumnya bernama `Your paragraph text (2).png`) |
| PelangganFrame / PetugasFrame | `logo` sidebar | `img/ui/logo-pocketly.png` (140×46) |
| BerandaPanel | `lblGambarPromo` | `img/ui/promo-checkout.png` (104×104) |
| BerandaPanel | ikon chip antar / pickup | `img/ui/icon-antar.png`, `img/ui/icon-pickup.png` (30×30) |
| KeranjangPanel | ikon antar / alamat | `img/ui/icon-antar-besar.png` (44×36), `img/ui/icon-alamat.png` (34×40) |

Semua file PNG di `src/main/resources/img/ui/` dan `img/kategori/` sudah
**diperkecil ke ukuran tampil persisnya** (logo 140×46, ikon navigasi NavPill
24×24, ikon kategori 104×68, foto produk 170×120), jadi tidak ada lagi
penskalaan lewat kode — **ingin mengganti gambar/ukurannya? cukup timpa file
PNG-nya** dengan ukuran yang diinginkan. Ikon NavPill juga kini dimuat pada
ukuran asli filenya (lihat `NavPill.setIconFile`); kasir memakai file baru
`icon-kasir.png` agar tidak bentrok dengan chip pickup 30×30.

### 8.3 Panel Profil & Kategori Produk diperkecil

- **ProfilPanel**: kartu 470→420px, avatar 86→64px, judul 24→20pt, nama
  20→17pt, angka statistik 26→21pt, jarak antar baris dan padding kartu
  dipadatkan, tombol Logout 195→170px (tinggi 44→40px).
- **Kategori Produk** (Beranda): ilustrasi kategori 140×92 → **104×68**,
  padding kartu dan jarak grid 14→12/10px, font nama kategori 12→11pt.
  Kartu kini jauh lebih pendek sehingga daftar produk langsung terlihat
  tanpa banyak menggulir.
- Bug kecil: tinggi label gambar promo di BerandaPanel sebelumnya terkunci
  di 312px (melebihi kartu 132px) — kini mengikuti ukuran asli gambar.

### 8.4 Catatan

Folder `target/` dihapus dari arsip agar tidak ada class/resource lama yang
terpakai; setelah dibuka di NetBeans lakukan **Clean and Build (Shift+F11)**
sekali seperti biasa (lihat bagian 7.3). Seluruh file `.form` tervalidasi XML
dan seluruh sumber berhasil dikompilasi tanpa error.
