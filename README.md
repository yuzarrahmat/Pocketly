# Pocketly
<img width="2500" height="1250" alt="PPT CAPSTONE" src="https://github.com/user-attachments/assets/402ccb00-0b75-4346-8670-591d06079bfa" />

---

Pocketly adalah sistem informasi manajemen ritel dan pemesanan daring terintegrasi (*omnichannel*) yang menghubungkan operasional kasir gerai fisik (*Point of Sale*/POS) dengan platform belanja daring secara terpusat guna menyinkronkan stok barang secara *real-time* dan mengeliminasi kendala *siloed system* (kondisi di mana aplikasi, database, atau sistem informasi dalam suatu organisasi berjalan secara terpisah, mandiri, dan tidak saling terhubung atau berkomunikasi satu sama lain).

Sistem ini menggunakan arsitektur *supertype-subtype* pada pengelolaan akun pengguna dan transaksi, menerapkan aturan bisnis di mana pemotongan stok utama hanya tereksekusi setelah pembayaran terverifikasi lunas, serta menyediakan layanan fleksibel berbasis *Pick-up* maupun Pesan antar. Didukung oleh pengamanan hak akses DCL untuk mengunci jejak audit transaksi kasir dan kemampuan pelaporan inventaris terpadu, Pocketly dirancang untuk mengoptimalkan operasional ritel sekaligus mendukung pencapaian SDGs 9 (Industri, Inovasi, dan Infrastruktur) dan SDGs 12 (Konsumsi dan Produksi yang Bertanggung Jawab).

---

## Kontributor

| Nama | NIM | Kelas | Kontribusi |
|------|-------|------|----------|
| Wahid Nur Hakim | 2509116016 | A | Perancangan dan pembuatan ERD, Membuat Laporan, Pembuatan Database, eksekusi query, membantu Slide Deck |
| Yuzar Rahmat Rafi Alhaq (**`Ketua Kelompok`**) | 2509116025 | A | Perancangan rencana pengerjaan, membantu laporan dan pencarian jurnal, perancangan dan membantu program, memastikan beban kerja yang merata, membantu revisi masing-masing anggota, Membuat Readme |
| Muhammad Ihsan Kamil | 2509116035 | A | Pembuatan laporan, Perancangan ERD, Perancangan dan Pembuatan Flowchart, eksekusi query, pembuatan prototype UI, Membuat Slide Deck |
| Riaz Ramadhan Al Fattah | 2509116106 | C | Perancangan dan pembuatan program, pembuatan GUI, pembuatan usecase, pembuatan laporan, Membantu Readme, membantu Slide Deck |

---

## Fitur Utama Program

**Pocketly** dirancang dengan pendekatan *Omnichannel (Click-and-Mortar)* yang menyatukan operasional kasir gerai fisik (*Point of Sale*) dan pemesanan daring pelanggan ke dalam satu basis data relasional terpusat guna mengeliminasi selisih stok (*stock discrepancy*) :

1. **Autentikasi Multi-Peran & Registrasi Akun**
   * Memvalidasi kredensial pengguna berbasis peran (`peran_pengguna`) dan mengarahkan sesi secara otomatis ke antarmuka khusus **Pelanggan** (`PelangganFrame`) atau **Petugas** (`PetugasFrame`).
   * Menyediakan fitur registrasi mandiri bagi pelanggan baru dengan validasi keunikan `username` dan `email`, disertai pencatatan otomatis `tanggal_registrasi` serta alamat pengiriman bawaan.
2. **Katalog Produk & Keranjang Belanja**
   * **Eksplorasi & Manajemen Katalog:** Menampilkan daftar produk berstatus `'Aktif'` dalam 8 kategori kebutuhan harian beserta sisa stok aktual bagi pelanggan, sekaligus memfasilitasi petugas (Admin) untuk menambah produk, memperbarui harga/stok, memetakan lokasi rak (`Rak A1` s.d. `Rak H1`), dan menerapkan *soft delete* (`status_produk = 'Nonaktif'`) guna menjaga keutuhan riwayat pada `detail_transaksi`.
   * **Keranjang Belanja Persisten (*Cart Persistence*):** Menyimpan item pilihan pelanggan pada tabel `keranjang`, memvalidasi kecukupan stok secara *real-time* saat penyesuaian kuantitas, menghitung `subtotal_estimasi` otomatis, dan mendukung pengubahan alamat pengiriman sebelum *checkout*.
3. **Pemesanan Daring (Pick-up & Delivery)**
   * **Layanan Ambil di Toko (*Pick up*):** Bebas biaya pengiriman (`Rp 0`), mendukung pembayaran tunai di kasir menggunakan *Kode Transaksi Cash* unik (contoh: `CSH-261008-001`) maupun pembayaran non-tunai (*E-Wallet* / *M-Banking*).
   * **Layanan Pesan Antar (*Delivery*):** Mencatat alamat pengiriman pelanggan dengan penambahan biaya ongkos kirim tetap sebesar `Rp 5.000` ke dalam `total_bayar` serta fitur unggah bukti pembayaran digital (`bukti_pembayaran`).
4. **Kasir Fisik (POS) & Verifikasi Pembayaran**
   * **Layanan Kasir Luring (*POS Offline*):** Memfasilitasi petugas kasir dalam menginput ID produk dan jumlah pembelian langsung di gerai tanpa mewajibkan pembeli memiliki akun pelanggan (cukup mencatat `nama_pembeli` opsional), lengkap dengan kalkulasi otomatis `nominal_kembalian` untuk pembayaran tunai maupun konfirmasi non-tunai.
   * **Verifikasi Pembayaran & Sinkronisasi Stok:** Menerapkan aturan bisnis di mana pemotongan stok fisik pada tabel `produk` dan pencatatan `waktu_lunas` hanya dieksekusi secara otomatis setelah pembayaran terverifikasi lunas (`'Berhasil'`) oleh petugas.
5. **Pelacakan Pesanan & Dashboard Pendapatan**
   * **Pelacakan Status Logistik & Riwayat:** Memisahkan status keuangan (`Menunggu verifikasi`, `Berhasil`, `Dibatalkan`) dari tahapan pemenuhan pesanan daring (`Dikemas`, `Siap diambil`, `Dikirim`, `Selesai`, `Dibatalkan`) yang dapat dipantau pelanggan secara *real-time*.
   * **Dashboard Analitik Penjualan:** Menyajikan ringkasan total akumulasi pendapatan, jumlah transaksi berhasil, visualisasi grafik batang pendapatan harian (`ChartPanel`), serta tabel rekapitulasi transaksi terpadu (*Online* dan *Offline*) bagi petugas.
   
---

### Tech Stack & Lingkungan Pengembangan

| Kategori | Teknologi / Pustaka | Spesifikasi & Peran dalam Proyek |
| --- | --- | --- |
| **Bahasa Pemrograman** | Java (JDK 17+) | Bahasa utama pengembangan aplikasi desktop berorientasi objek (OOP). |
| **Kerangka Kerja Antarmuka (GUI)** | Java Swing (`javax.swing`, `java.awt`) + Custom Flat UI | Membangun antarmuka pengguna grafis modern dengan komponen kustom (`RoundPanel`, `RoundButton`, `ChartPanel`, `BadgeLabel`, `NavPill`, `AvatarLabel`, `RoundTextField`, `RoundPasswordField`). |
| **Arsitektur Perangkat Lunak** | MVC + DAO Pattern | Memisahkan *Model* (POJO entitas data), *View* (JFrame/JPanel), *Controller* (logika bisnis & event handler), dan *Data Access Object* (isolasi query JDBC). |
| **Sistem Manajemen Basis Data** | MySQL Server 8.0 (`InnoDB`, `utf8mb4`) | Penyimpanan basis data relasional `db_pocketly` yang mendukung *Foreign Key Constraints*, *Transactions* (TCL), dan manajemen hak akses (DCL). |
| **Konektor Basis Data** | MySQL Connector/J (JDBC) | Jembatan komunikasi antara aplikasi Java dan MySQL menggunakan `PreparedStatement` dan konfigurasi eksternal `db.properties`. |
| **Build Automation & Dependency** | Apache Maven (`pom.xml`) | Manajemen siklus kompilasi, *packaging*, dan dependensi pustaka proyek secara terstandarisasi. |
| **IDE & Version Control** | Apache NetBeans IDE & Git / GitHub | Lingkungan pengembangan terpadu (termasuk perancangan `.form` GUI Builder) dan kolaborasi kode sumber pada cabang `main`. |

---

### Perancangan Sistem (ERD, Use Case, & Flowchart)

#### 1. Arsitektur Basis Data (ERD Logical & Relational)
<img width="10533" height="7457" alt="ERD Relational Model" src="https://github.com/user-attachments/assets/d2b411b0-a4c7-49d6-a2fc-12158f9e6930" />
<img width="8940" height="5194" alt="ERD Logical Model" src="https://github.com/user-attachments/assets/a6d6b496-fa20-4b70-8ca6-99d0ffb17f93" />

---

Basis data `db_pocketly` dirancang menggunakan **Notasi Barker** pada model logis dan diimplementasikan menjadi **10 tabel relasional** yang menerapkan pola **Supertype–Subtype (Generalization/Specialization)** pada dua domain utama:

1. **Hierarki Akun Pengguna (`pengguna` $\rightarrow$ `pelanggan` & `petugas`):**
* **Tabel Induk `pengguna`:** Menyimpan kredensial utama (`username` sebagai *Primary Key*, `password`, dan `peran_pengguna` bertipe `ENUM('Petugas', 'Pelanggan')`).
* **Tabel Subtype `pelanggan`:** Mewarisi `username` sebagai *Primary Key* sekaligus *Foreign Key* ke `pengguna(username)`, serta menyimpan atribut spesifik pelanggan (`nama`, `email`, `alamat`, `tanggal_registrasi`).
* **Tabel Subtype `petugas`:** Mewarisi `username` sebagai *Primary Key* sekaligus *Foreign Key* ke `pengguna(username)`, serta menyimpan atribut kepegawaian internal (`nip`, `jabatan` yaitu `'Admin'` atau `'Kasir'`).


2. **Hierarki Transaksi Penjualan (`transaksi` $\rightarrow$ `online` & `offline`):**
* **Tabel Induk `transaksi`:** Mencatat data umum seluruh penjualan (`id_transaksi` PK, `tanggal_transaksi`, `jenis_transaksi` ENUM `'Offline'`/`'Online'`, `metode_pembayaran` ENUM `'Cash'`/`'E-Wallet'`/`'M-Bangking'`, `status_pembayaran` ENUM `'Menunggu verifikasi'`/`'Berhasil'`/`'Dibatalkan'`, `total_bayar`, `waktu_lunas`, serta `petugas_username` FK).
* **Tabel Subtype `online`:** Menggunakan `id_transaksi` sebagai PK/FK ke `transaksi(id_transaksi)` dan berelasi ke `pelanggan(username)`, memuat atribut khusus pesanan daring (`tipe_pemesanan` ENUM `'Pick up'`/`'Pesan antar'`, `kode_transaksi_cash`, `bukti_pembayaran`, `status_pesanan` ENUM `'Dikemas'`/`'Siap diambil'`/`'Dikirim'`/`'Selesai'`/`'Dibatalkan'`, dan `biaya_ongkir`).
* **Tabel Subtype `offline`:** Menggunakan `id_transaksi` sebagai PK/FK ke `transaksi(id_transaksi)`, memuat rincian pembayaran kasir fisik (`nominal_bayar`, `nominal_kembalian`, `nama_pembeli`).


3. **Entitas Inventaris, Keranjang, & Rincian Item (`kategori_produk`, `produk`, `keranjang`, `detail_transaksi`):**
* `kategori_produk` mengelompokkan banyak `produk` (1:M) beserta penempatan `lokasi_rak`.
* `produk` dikelola oleh satu `petugas` penanggung jawab (M:1) dan dirujuk oleh `keranjang` (1:M) serta `detail_transaksi` (1:M).
* `detail_transaksi` menjembatani relasi *Many-to-Many* antara `transaksi` dan `produk` dengan menyimpan `harga_transaksi` historis saat pembelian terjadi agar perubahan harga produk di masa depan tidak merusak catatan keuangan masa lalu.

---

#### 2. Pemetaan Use Case Diagram
<img width="1381" height="844" alt="Use Case Pocketly" src="https://github.com/user-attachments/assets/4652fa01-fdcc-4c96-9328-23cc5140d1f9" />

---

Interaksi fungsional dalam sistem melibatkan dua aktor utama (**Pelanggan** dan **Petugas**) dengan rincian relasi `<<include>>` dan `<<extend>>` sebagai berikut:

| No | Nama Use Case | Aktor | Relasi UML (`<<include>>` / `<<extend>>`) | Implementasi Kelas (`Controller` & `View`) |
| --- | --- | --- | --- | --- |
| 1 | **Registrasi Akun** | Pelanggan | `<<include>>` ke *Login Sistem* | `AuthController` (`PelangganDAO`, `PenggunaDAO`) |
| 2 | **Login Sistem** | Pelanggan, Petugas | Use Case pusat yang memvalidasi sesi seluruh fitur | `AuthController`, `Main.java` |
| 3 | **Melihat / Mengelola Katalog & Kategori Produk** | Pelanggan, Petugas | `<<include>>` ke *Login Sistem* | `KatalogController` (`BerandaPanel`) & `ProdukAdminController` (`KelolaProdukPanel`) |
| 4 | **Mengelola Keranjang Belanja** | Pelanggan | `<<include>>` ke *Login Sistem*; memiliki `<<extend>>` *Hapus Produk* & *Checkout Pesanan* | `KeranjangController` (`KeranjangPanel`, `KeranjangDAO`) |
| 5 | **Melakukan Pesanan Online** | Pelanggan | `<<include>>` ke *Login Sistem*; memiliki `<<extend>>` *Pilih Tipe Pesanan* (*Pickup Pesanan* / *Pesan Antar*) & *Pilih Pembayaran* (*E-Wallet / M-Banking* / *Cash*) | `KeranjangController` (`KeranjangPanel`, `TransaksiDAO`) |
| 6 | **Melihat Riwayat & Status Pesanan** | Pelanggan | `<<include>>` ke *Login Sistem* | `RiwayatController` (`TransaksiPanel`, `ProfilPanel`) |
| 7 | **Memverifikasi Pembayaran Pelanggan** | Petugas | `<<include>>` ke *Login Sistem* & `<<include>>` ke *Mencatat Pendapatan Nilai* | `VerifikasiController` (`VerifikasiPanel`, `TransaksiDAO`, `ProdukDAO`) |
| 8 | **Memproses Status Pesanan Online** | Petugas | `<<include>>` ke *Login Sistem* | `StatusController` (`StatusPanel`, `TransaksiDAO`) |
| 9 | **Melayani Transaksi Kasir Offline** | Petugas | `<<include>>` ke *Login Sistem* & `<<include>>` ke *Input Barang Pembayaran* | `KasirController` (`KasirPanel`, `TransaksiDAO`, `ProdukDAO`) |
| 10 | **Melihat Rekap Laporan Penjualan** | Petugas | `<<include>>` ke *Login Sistem* | `PendapatanController` (`BerandaPetugasPanel`, `ChartPanel`) |

---

#### 3. Alur Proses (FlowChart)

1. **Alur Login & Registrasi** 
<img width="1201" height="752" alt="Picture1" src="https://github.com/user-attachments/assets/9173556a-d282-4fe1-a92a-a607e2baa3a4" />
Menampilkan halaman masuk; jika pengguna memilih registrasi, sistem memvalidasi ketersediaan `username` di database pengguna (menolak jika duplikat, menyimpan jika unik). Saat login, sistem memverifikasi kredensial dan mengarahkan antarmuka berdasarkan *role* (`Petugas` ke `PetugasFrame`, `Pelanggan` ke `PelangganFrame`).

---

2. **Alur Beranda Pelanggan** 
<img width="1200" height="427" alt="Picture2" src="https://github.com/user-attachments/assets/ae2a52d1-7461-481e-ba17-a5b5a1ceebec" />
Menampilkan katalog produk berdasarkan kategori. Ketika pelanggan menekan tombol tambah (`+`), sistem memeriksa stok pada database produk; jika mencukupi, item masuk ke database keranjang disertai notifikasi `"Item ditambahkan"`.

---

3. **Alur Keranjang Belanja & Checkout** 
<img width="1186" height="770" alt="Picture3" src="https://github.com/user-attachments/assets/d8305690-cf52-4222-bc64-afba0a8f0194" />
Memeriksa isi keranjang pelanggan; mendukung pemilihan tipe pemesanan (*Pesan Antar* atau *Pick Up*), pengubahan alamat profil, penyesuaian jumlah item dengan validasi stok, penghapusan item, hingga proses *Checkout* menggunakan *E-Wallet* (unggah bukti pembayaran) atau *Cash* (menampilkan kode transaksi) yang menetapkan status awal `"Menunggu verifikasi"`.

---

4. **Alur Riwayat Transaksi & Profil Pelanggan** 
<img width="1198" height="643" alt="Picture4" src="https://github.com/user-attachments/assets/b3b946ad-e5c8-4597-9c37-f0b7bc39f26c" />
Menampilkan daftar pesanan pelanggan beserta tampilan rincian lengkap (ID transaksi, tanggal, status pesanan, status pembayaran, penerima, alamat, item produk, metode bayar, ongkir, subtotal) dan informasi profil yang dilengkapi fitur *Logout*.

---

5. **Alur Beranda & Laporan Pendapatan Petugas** 
<img width="1193" height="809" alt="Picture5" src="https://github.com/user-attachments/assets/ad7a9892-b465-465b-b338-19ab10786c2b" />
Menampilkan navigasi utama petugas serta rekapitulasi pendapatan dari database transaksi. Jika terdapat riwayat transaksi lunas, sistem merender total akumulasi pendapatan beserta tabel dan grafik penjualan harian.

---

6. **Alur Kelola Produk Petugas** 
<img width="1096" height="753" alt="Picture6" src="https://github.com/user-attachments/assets/f257441d-4b16-40d1-a972-4f537b32fefb" />
Memfasilitasi penambahan produk baru, pengeditan atribut produk melalui validasi input, penyesuaian stok langsung (`+/-` atau angka), serta pengubahan status produk (`Aktif` / `Nonaktif`) melalui *dropdown*.

---

7. **Alur Verifikasi Pembayaran Petugas** 
<img width="913" height="532" alt="Picture7" src="https://github.com/user-attachments/assets/db2c83d4-000b-4266-9243-7270b28f1c40" />
Menampilkan daftar transaksi pelanggan beserta pratinjau bukti pembayaran atau kode kas. Saat petugas memilih status `"Valid"`, sistem memperbarui status pembayaran di database transaksi menjadi `'Berhasil'`, memotong stok di database produk, dan menampilkan notifikasi `"Bukti pembayaran diterima"`. Jika `"Tidak Valid"`, status menjadi `'Dibatalkan'`.

---

8. **Alur Ubah Status Pesanan Petugas** 
<img width="522" height="251" alt="Picture8" src="https://github.com/user-attachments/assets/51761ae1-f37b-4a7d-abc2-b24af03f372d" />

Memungkinkan petugas memperbarui tahapan logistik pesanan daring melalui *dropdown* (`Dikemas`, `Dikirim`, `Siap diambil`, `Selesai`) yang langsung disimpan ke tabel `online`.

---

9. **Alur Kasir Offline Petugas** 
<img width="1206" height="851" alt="Picture9" src="https://github.com/user-attachments/assets/e952e7bf-fe64-41c4-8e59-ff83534b570b" />
Memvalidasi input ID produk dan jumlah beli terhadap ketersediaan stok, menampilkan ringkasan pembayaran (*Tunai* dengan kalkulasi uang bayar dan kembalian, atau konfirmasi *E-Wallet*), lalu menyimpan transaksi sekaligus memotong stok produk secara permanen.

---

## Struktur Folder / Package

Program disusun rapi mengikuti pola arsitektur **Model-View-Controller (MVC)** yang dikombinasikan dengan pola **Data Access Object (DAO)** untuk memisahkan logika antarmuka, logika bisnis, dan query basis data:

```
Pocketly Capstone/
├── dependency-reduced-pom.xml
├── pom.xml
├── img/
│   └── produk/
├── lib/
│   └── unknown/binary/AbsoluteLayout/SNAPSHOT/
├── sql/
│   └── db_pocketly.sql
└── src/
    └── main/
        └── java/
            └── com/
                └── pocketly/
                    ├── Main.java
                    ├── component/
                    │   ├── AvatarLabel.java
                    │   ├── BadgeLabel.java
                    │   ├── ChartPanel.java
                    │   ├── NavPill.java
                    │   ├── RoundButton.java
                    │   ├── RoundPanel.java
                    │   ├── RoundPasswordField.java
                    │   └── RoundTextField.java
                    ├── controller/
                    │   ├── AuthController.java
                    │   ├── KasirController.java
                    │   ├── KatalogController.java
                    │   ├── KeranjangController.java
                    │   ├── PendapatanController.java
                    │   ├── ProdukAdminController.java
                    │   ├── ProfilController.java
                    │   ├── RiwayatController.java
                    │   ├── StatusController.java
                    │   └── VerifikasiController.java
                    ├── dao/
                    │   ├── KategoriDAO.java
                    │   ├── KeranjangDAO.java
                    │   ├── PelangganDAO.java
                    │   ├── PenggunaDAO.java
                    │   ├── PetugasDAO.java
                    │   ├── ProdukDAO.java
                    │   └── TransaksiDAO.java
                    ├── model/
                    │   ├── DetailTransaksi.java
                    │   ├── KasirItem.java
                    │   ├── Kategori.java
                    │   ├── KeranjangItem.java
                    │   ├── OnlineOrder.java
                    │   ├── Pelanggan.java
                    │   ├── PendapatanRow.java
                    │   ├── Pengguna.java
                    │   ├── Petugas.java
                    │   └── Produk.java
                    └── view/
                        ├── pelanggan/
                        │   ├── BerandaPanel.java (.form)
                        │   ├── KeranjangPanel.java (.form)
                        │   ├── PelangganFrame.java (.form)
                        │   ├── PelangganNav.java
                        │   ├── ProfilPanel.java (.form)
                        │   └── TransaksiPanel.java (.form)
                        └── petugas/
                            ├── BerandaPetugasPanel.java (.form)
                            ├── KasirPanel.java (.form)
                            ├── KelolaProdukPanel.java (.form)
                            ├── PetugasFrame.java (.form)
                            ├── PetugasNav.java
                            ├── StatusPanel.java (.form)
                            └── VerifikasiPanel.java (.form)
```

### Rincian Peran Package

| Package / Directory | Kelas / Berkas Utama | Deskripsi Peran & Fungsi |
| --- | --- | --- |
| **`com.pocketly`** | `Main.java` | *Entry point* utama aplikasi Java Swing untuk menginisialisasi tema antarmuka dan memuat antarmuka *login*. |
| **`com.pocketly.component`** | `RoundPanel`, `RoundButton`, `ChartPanel`, `AvatarLabel`, `NavPill`, `BadgeLabel`, `RoundTextField`, `RoundPasswordField` | Kumpulan komponen GUI kustom (*custom Swing UI*) untuk tampilan modern dengan sudut membulat, grafik pendapatan, badge status, dan bidang input khusus. |
| **`com.pocketly.controller`** | `AuthController`, `KasirController`, `KatalogController`, `KeranjangController`, `ProdukAdminController`, `PendapatanController`, `VerifikasiController`, `StatusController`, `RiwayatController`, `ProfilController` | Lapisan *Controller* yang mengendalikan alur logika bisnis, memproses aksi antarmuka (`view`), memvalidasi aturan bisnis pemotongan stok, serta menjembatani alur ke lapisan DAO. |
| **`com.pocketly.dao`** | `PenggunaDAO`, `PelangganDAO`, `PetugasDAO`, `ProdukDAO`, `KategoriDAO`, `TransaksiDAO`, `KeranjangDAO` | Lapisan *Data Access Object* (DAO) yang mengisolasi seluruh eksekusi query SQL (`SELECT`, `INSERT`, `UPDATE`, `DELETE`) ke basis data `db_pocketly` menggunakan `PreparedStatement`. |
| **`com.pocketly.model`** | `Pengguna`, `Pelanggan`, `Petugas`, `Produk`, `Kategori`, `DetailTransaksi`, `KeranjangItem`, `KasirItem`, `OnlineOrder`, `PendapatanRow` | Lapisan *Model* yang mengenkapsulasi entitas data dan representasi baris tabel basis data ke dalam objek Java (*POJO*). |
| **`com.pocketly.view.pelanggan`** | `PelangganFrame`, `BerandaPanel`, `KeranjangPanel`, `TransaksiPanel`, `ProfilPanel`, `PelangganNav` | Jendela utama dan panel antarmuka khusus pengguna ber-role **Pelanggan** (katalog produk daring, keranjang belanja, pelacakan pesanan *Pick-up/Delivery*, dan profil). |
| **`com.pocketly.view.petugas`** | `PetugasFrame`, `BerandaPetugasPanel`, `KasirPanel`, `KelolaProdukPanel`, `StatusPanel`, `VerifikasiPanel`, `PetugasNav` | Jendela utama dan panel antarmuka khusus pengguna ber-role **Petugas / Admin** (operasional POS kasir fisik, manajemen persediaan barang, verifikasi pesanan, dan laporan pendapatan). |
| **`sql/`** | `db_pocketly.sql` | Direktori penampung berkas skrip SQL yang memuat struktur tabel (*supertype-subtype* pengguna, produk, transaksi) dan data awal basis data `db_pocketly`. |


---

## Penjelasan Penerapan 4 Pilar OOP
**Pocketly** dibangun di atas arsitektur **MVC (*Model-View-Controller*) + DAO (*Data Access Object*)** pada paket utama `com.pocketly` dengan menerapkan keempat pilar *Object-Oriented Programming* (OOP) secara menyeluruh:

* **1. Encapsulation (Enkapsulasi)**
* **Proteksi Entitas Data (`com.pocketly.model`):** Seluruh kelas representasi tabel (*POJO*)—meliputi `Pengguna.java`, `Pelanggan.java`, `Petugas.java`, `Produk.java`, `Kategori.java`, `DetailTransaksi.java`, `KeranjangItem.java`, `KasirItem.java`, `OnlineOrder.java`, dan `PendapatanRow.java`—mendeklarasikan atribut internalnya menggunakan pengubah akses `private` (seperti `idProduk`, `hargaSatuan`, `stok`, `subtotalEstimasi`, dan `totalBayar`). Manipulasi maupun pembacaan nilai atribut dari luar kelas hanya diizinkan melalui metode *getter* dan *setter* berakses `public` untuk menjamin validitas state objek di memori.
* **Isolasi Akses Basis Data (`com.pocketly.dao`):** Detail teknis koneksi JDBC, pembacaan konfigurasi kredensial pada berkas `db.properties`, serta penyusunan sintaks SQL (`SELECT`, `INSERT`, `UPDATE`, `DELETE`) dibungkus sepenuhnya di dalam lapisan DAO (`PenggunaDAO.java`, `PelangganDAO.java`, `PetugasDAO.java`, `ProdukDAO.java`, `KategoriDAO.java`, `KeranjangDAO.java`, dan `TransaksiDAO.java`) menggunakan `PreparedStatement`. Hal ini mencegah kelas antarmuka pada paket `com.pocketly.view` memodifikasi basis data `db_pocketly` secara langsung tanpa melewati validasi aturan bisnis.


* **2. Inheritance (Pewarisan)**
* **Hierarki Model Supertype–Subtype (`com.pocketly.model`):** Selaras dengan skema generalisasi pada ERD basis data, kelas `Pelanggan.java` (yang menyimpan atribut spesifik `alamat`, `tanggalRegistrasi`, `email`, dan `nama`) serta kelas `Petugas.java` (yang menyimpan atribut `nip` dan `jabatan`) mewarisi (`extends`) atribut kredensial dasar (`username`, `password`, dan `peranPengguna`) dari kelas induk `Pengguna.java`.
* **Pewarisan Komponen Antarmuka Swing (`com.pocketly.view` & `com.pocketly.component`):** Jendela utama aplikasi (`PelangganFrame.java` dan `PetugasFrame.java`) mewarisi sifat dan perilaku kelas `javax.swing.JFrame`, sedangkan seluruh panel menu (`BerandaPanel.java`, `KeranjangPanel.java`, `TransaksiPanel.java`, `ProfilPanel.java`, `BerandaPetugasPanel.java`, `KasirPanel.java`, `KelolaProdukPanel.java`, `StatusPanel.java`, dan `VerifikasiPanel.java`) mewarisi kelas `javax.swing.JPanel`. Selain itu, komponen antarmuka kustom pada paket `com.pocketly.component` memperluas komponen standar Java Swing, seperti `RoundPanel.java` dan `ChartPanel.java` yang mewarisi `JPanel`, `RoundButton.java` yang mewarisi `JButton`, `RoundTextField.java` yang mewarisi `JTextField`, `RoundPasswordField.java` yang mewarisi `JPasswordField`, serta `AvatarLabel.java`, `BadgeLabel.java`, dan `NavPill.java` yang mewarisi komponen teks/label dasar.


* **3. Polymorphism (Polimorfisme)**
* **Custom UI Rendering melalui *Method Overriding* (`com.pocketly.component`):** Komponen visual kustom menerapkan polimorfisme melalui mekanisme *overriding* (`@Override`) terhadap metode `paintComponent(Graphics g)` dan `paintBorder(Graphics g)` milik kelas induk Swing. Di dalam `RoundPanel.java`, `RoundButton.java`, `BadgeLabel.java`, dan `AvatarLabel.java`, metode tersebut ditulis ulang menggunakan objek `Graphics2D` (`RenderingHints.KEY_ANTIALIASING`) untuk merender sudut melengkung (*rounded corners*) dan indikator warna status transaksi secara dinamis, sedangkan pada `ChartPanel.java` metode yang sama dioverride untuk menggambar visualisasi grafik batang laporan pendapatan harian.
* **Resolusi Peran & Penanganan Event (`com.pocketly.controller`):** Saat proses autentikasi pada `AuthController.java`, objek referensi bertipe induk `Pengguna` dapat diperlakukan secara polimorfik menjadi instans `Pelanggan` atau `Petugas` untuk mengarahkan sesi login ke frame yang sesuai. Polimorfisme juga diterapkan melalui implementasi antarmuka pendengar aksi (*event listener* seperti `ActionListener` dan `MouseListener`) pada kesepuluh kelas kontroler, di mana metode penanganan aksi memberikan respons logika yang berbeda sesuai konteks tombol dan panel yang sedang aktif.


* **4. Abstraction (Abstraksi)**
* **Abstraksi Logika Bisnis & Transaksi (`com.pocketly.controller` & `com.pocketly.dao`):** Kompleksitas proses bisnis *omnichannel* disembunyikan dari lapisan antarmuka (`view`) melalui pemisahan peran antara kelas kontroler (`KasirController.java`, `KeranjangController.java`, `VerifikasiController.java`, `StatusController.java`, `ProdukAdminController.java`, `PendapatanController.java`, `KatalogController.java`, `RiwayatController.java`, dan `ProfilController.java`) dan lapisan DAO. Ketika petugas memverifikasi bukti pembayaran pada `VerifikasiPanel.java` atau menyelesaikan transaksi tunai pada `KasirPanel.java`, panel antarmuka cukup memanggil satu metode eksekusi pada kontroler tanpa perlu mengetahui proses penguncian transaksi (`START TRANSACTION`, `SAVEPOINT`, `COMMIT`, `ROLLBACK`), penggabungan tabel (`JOIN` antara `transaksi`, `online`, `offline`, dan `detail_transaksi`), maupun pemotongan stok otomatis pada `ProdukDAO.java`.
* **Abstraksi Navigasi Antarmuka (`PelangganNav.java` & `PetugasNav.java`):** Mekanisme perpindahan antar-halaman di dalam jendela aplikasi diabstraksikan ke dalam kelas navigator `PelangganNav.java` dan `PetugasNav.java` bersama komponen `NavPill.java`, sehingga setiap panel fitur dapat dipanggil secara modular tanpa membebani kode pada `Main.java` maupun frame utama.

---

## Cara Penggunaan & Screenshot GUI

### 1. Akun Pengujian Bawaan

Gunakan Akun bawaan dari `db_pocketly.sql` dibawah untuk menguji alur **Pelanggan** maupun **Petugas**:

| Peran | Jabatan / Status | Username | Password | Keterangan Penggunaan |
| --- | --- | --- | --- | --- |
| **Pelanggan** | Pelanggan Aktif | `budi_san` | `BudiSan!7731` | Budi Santoso — Pengujian katalog, keranjang & pemesanan *Online* |
| **Pelanggan** | Pelanggan Aktif | `rina_ayu` | `RinaAyu#2026a` | Rina Ayuningtyas — Pengujian keranjang & riwayat transaksi |
| **Petugas** | Admin | `ptg_andi` | `Andi@Pocket#01` | NIP: `PTG-2026-001` — Dashboard pendapatan, kelola produk & kasir |
| **Petugas** | Kasir | `ptg_rudi` | `Rudi!Kasir#03` | NIP: `PTG-2026-003` — Pelayanan transaksi POS *Kasir Offline* |

---

### 2. Panduan Alur Penggunaan & Tangkapan Layar (GUI)

#### A. Autentikasi & Login Sistem (`Main.java` & `AuthController.java`)

<img width="1600" height="903" alt="Login" src="https://github.com/user-attachments/assets/6ac41e80-6ffa-4271-bd54-5450f62f9418" />

* **Masuk ke Sistem:** Masukkan `Username` (contoh: `budi_san` untuk Pelanggan atau `ptg_andi` untuk Petugas) beserta `Password`, lalu klik tombol **Masuk**. Sistem secara otomatis mengenali peran pengguna dan mengarahkan sesi ke antarmuka yang sesuai (`PelangganFrame` atau `PetugasFrame`).
* **Registrasi Pelanggan Baru:** Bagi pelanggan yang belum memiliki akun, klik tautan **Buat Akun** di bagian bawah kartu login untuk membuka formulir pendaftaran akun baru.

---

#### B. Alur Penggunaan Sisi Pelanggan (`com.pocketly.view.pelanggan`)

##### 1. Eksplorasi Katalog & Kategori Produk (`BerandaPanel.java`)

<img width="1600" height="850" alt="Beranda Pelanggan" src="https://github.com/user-attachments/assets/09c97d82-62d8-40c5-ba27-fb01035a92de" />

* **Filter Kategori Produk:** Pada halaman **Beranda**, pelanggan dapat memilih kategori kebutuhan harian yang tersedia (*Makanan*, *Minuman*, *Dapur dan Bahan Masak*, *Makanan Hewan*, *Perawatan Diri*, atau *Kesehatan dan Kebersihan*).
* **Pemantauan Stok & Penambahan Item:** Setiap kartu produk menampilkan nama barang, kategori, harga satuan, serta jumlah stok aktual yang tersinkronisasi dengan gerai fisik (contoh: *Indomie Goreng* dengan stok 199 bungkus dan *Roti Tawar Sari Roti* dengan stok 39 bungkus). Klik tombol aksi pada kartu produk untuk menambahkan barang ke dalam keranjang belanja.
* **Navigasi Samping (`PelangganNav`):** Bilah navigasi di sisi kiri memudahkan perpindahan antara menu **Beranda**, **Keranjang** (dilengkapi indikator *badge* jumlah item aktif), **Transaksi**, dan profil pelanggan.

##### 2. Pengelolaan Keranjang Belanja & Tipe Pemesanan (`KeranjangPanel.java`)

<img width="1600" height="850" alt="Keranjang dan tipe" src="https://github.com/user-attachments/assets/b43bd27a-f61a-4c1d-b00b-dc700661cfed" />

* **Pemilihan Tipe Pemesanan:** Gunakan *dropdown* **Tipe Pemesanan** di bagian atas untuk memilih metode penyerahan barang:
* **Pesan antar:** Pesanan diantar ke alamat pelanggan dengan tambahan biaya pengiriman tetap sebesar `Rp 5.000`.
* **Pick up:** Pesanan diambil mandiri di gerai fisik tanpa biaya pengiriman (`Rp 0`).


* **Pengaturan Alamat Pengiriman:** Pelanggan dapat melihat alamat pengiriman bawaan (contoh: `Jl. Melati No. 7 RT 02`) atau menekan tombol **Ubah Alamat** untuk memperbarui lokasi pengantaran.
* **Penyesuaian Kuantitas & Seleksi Barang:** Centang produk yang ingin diproses, ubah kuantitas pembelian menggunakan tombol `-` / `+` lalu tekan **OK** untuk memperbarui subtotal item, atau klik **Hapus** / **Hapus Terpilih** untuk mengeluarkan barang dari keranjang.
* **Proses Checkout:** Setelah memeriksa rincian **Subtotal produk**, **Biaya pengiriman**, dan **Total bayar**, klik tombol **Checkout** di kanan bawah untuk memilih metode pembayaran (*Cash* dengan kode transaksi atau *E-Wallet* / *M-Banking* dengan unggah bukti pembayaran).

---

#### C. Alur Penggunaan Sisi Petugas / Admin (`com.pocketly.view.petugas`)

##### 1. Dashboard Analitik & Rekapitulasi Pendapatan (`BerandaPetugasPanel.java`)

<img width="1600" height="848" alt="Dashboard Petugas" src="https://github.com/user-attachments/assets/9ec67fe9-1998-4230-83ce-64a5f348cdeb" />

* **Ringkasan Metrik Kinerja:** Halaman beranda petugas menampilkan tiga kartu indikator utama secara langsung, yaitu **Total Pendapatan** akumulatif (`Rp 1.587.000`), jumlah **Transaksi Berhasil** (`25 transaksi`), serta **Pendapatan Hari Ini**.
* **Visualisasi Grafik Harian (`ChartPanel`):** Menampilkan grafik batang (*bar chart*) fluktuasi pendapatan harian toko dalam rentang satu bulan untuk memudahkan evaluasi performa penjualan.
* **Tabel Rekapitulasi Transaksi Terpadu:** Menyajikan daftar seluruh transaksi yang telah lunas beserta rincian **Tanggal**, **ID Transaksi**, **Jenis** kanal penjualan (*Online* maupun *Offline*), **Metode** pembayaran (*Cash*, *E-Wallet*, *M-Bangking*), dan **Total** nominal transaksi.
* **Navigasi Operasional (`PetugasNav`):** Petugas dapat mengakses seluruh fitur manajemen melalui bilah menu di sisi kiri yang mencakup **Beranda**, **Ubah Status**, **Verifikasi Bayar**, **Kasir Offline**, dan **Kelola Produk**.

##### 2. Pelayanan Transaksi Gerai Fisik / POS (`KasirPanel.java`)

<img width="1600" height="851" alt="Kasir Offline" src="https://github.com/user-attachments/assets/9a90083a-ae67-4a32-840e-f4ce1b9c5bac" />

* **Input Cepat Produk Kasir:** Masukkan kode barang pada kolom **ID Produk** (contoh: `PRD009`) beserta kuantitas pada kolom **Jumlah**, lalu klik tombol **Tambah**. Petugas juga dapat mencatat **Nama pembeli (opsional)** pada kolom yang tersedia.
* **Manajemen Daftar Belanja Kasir:** Tabel kasir menampilkan daftar barang yang dibeli pelanggan gerai fisik lengkap dengan harga satuan, kontrol **Ubah Jumlah** (`-` / `+`) yang tervalidasi langsung dengan sisa stok gudang, serta kalkulasi **Subtotal** per baris produk.
* **Penyelesaian Pembayaran:** Total tagihan dihitung secara otomatis pada bagian **Total belanja** (contoh: `Rp 257.500`). Klik tombol hijau **Bayar** di kanan bawah untuk memilih metode pembayaran (*Tunai* dengan perhitungan uang kembalian otomatis atau *Non-Tunai*), menyimpan transaksi ke basis data, dan memotong stok produk secara *real-time*.

```
