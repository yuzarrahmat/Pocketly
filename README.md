# Pocketly

Pocketly adalah sistem informasi manajemen ritel dan pemesanan daring terintegrasi (*omnichannel*) yang menghubungkan operasional kasir gerai fisik (*Point of Sale*/POS) dengan platform belanja daring secara terpusat guna menyinkronkan stok barang secara *real-time* dan mengeliminasi kendala *siloed system* (kondisi di mana aplikasi, database, atau sistem informasi dalam suatu organisasi berjalan secara terpisah, mandiri, dan tidak saling terhubung atau berkomunikasi satu sama lain).

Sistem ini menggunakan arsitektur *supertype-subtype* pada pengelolaan akun pengguna dan transaksi, menerapkan aturan bisnis di mana pemotongan stok utama hanya tereksekusi setelah pembayaran terverifikasi lunas, serta menyediakan layanan fleksibel berbasis *Pick-up* maupun Pesan antar. Didukung oleh pengamanan hak akses DCL untuk mengunci jejak audit transaksi kasir dan kemampuan pelaporan inventaris terpadu, Pocketly dirancang untuk mengoptimalkan operasional ritel sekaligus mendukung pencapaian SDGs 9 (Industri, Inovasi, dan Infrastruktur) dan SDGs 12 (Konsumsi dan Produksi yang Bertanggung Jawab).

---

## Kontributor

| Nama | NIM | Kelas | Kontribusi |
|------|-------|------|----------|
| Wahid Nur Hakim | 2509116016 | A | Perancangan dan pembuatan ERD, Membuat Laporan, Pembuatan Database, eksekusi query |
| Yuzar Rahmat Rafi Alhaq | 2509116025 | A | Perancangan rencana pengerjaan, membantu laporan dan pencarian jurnal, perancangan dan pembuatan program, memastikan beban kerja yang merata, membantu revisi masing-masing anggota |
| Muhammad Ihsan Kamil | 2509116035 | A | Pembuatan laporan, Perancangan ERD, Perancangan dan Pembuatan Flowchart, eksekusi query, pembuatan prototype UI |
| Riaz Ramadhan Al Fattah | 2509116106 | C | Perancangan dan pembuatan program, pembuatan GUI, pembuatan usecase, pembuatan laporan |

---

## Fitur Utama Program

**Pocketly** dirancang dengan pendekatan *Omnichannel (Click-and-Mortar)* yang menyatukan operasional kasir gerai fisik (*Point of Sale*) dan pemesanan daring pelanggan ke dalam satu basis data relasional terpusat guna mengeliminasi selisih stok (*stock discrepancy*) :

1. **Autentikasi Multi-Peran (*Role-Based Access Control*) & Registrasi Mandiri**
* Memisahkan alur masuk pengguna berdasarkan atribut `peran_pengguna` pada entitas induk `pengguna` menjadi antarmuka khusus **Pelanggan** (`PelangganFrame`) dan **Petugas** (`PetugasFrame`).
* Menyediakan fitur registrasi akun pelanggan baru dengan validasi keunikan `username` dan `email`, serta pencatatan otomatis `tanggal_registrasi` dan alamat pengiriman bawaan.

2. **Katalog Produk Dinamis & Manajemen Inventaris Terpusat**
* **Sisi Pelanggan:** Menampilkan katalog produk berstatus `'Aktif'` yang dikelompokkan ke dalam 8 kategori kebutuhan harian (`Makanan`, `Minuman`, `Dapur dan Bahan Masak`, `Ibu dan Anak`, `Makanan Hewan`, `Perawatan Diri`, `Kesehatan dan Kebersihan`, serta `Lainnya`) beserta informasi harga satuan, satuan barang, dan sisa stok terkini.
* **Sisi Petugas (Admin):** Menyediakan fitur tambah produk baru, pembaruan harga/informasi barang, penyesuaian stok cepat melalui kontrol tambah/kurang (`+/-`) maupun input angka langsung, informasi lokasi rak (`Rak A1` s.d. `Rak H1`), serta mekanisme *soft delete* (mengubah status produk menjadi `'Nonaktif'`) agar riwayat penjualan masa lalu pada `detail_transaksi` tetap terjaga utuh.

3. **Manajemen Keranjang Belanja Interaktif (*Cart Persistence*)**
* Menyimpan pilihan belanja pelanggan secara persisten pada tabel `keranjang` di basis data sebelum dilakukan *checkout*.
* Mendukung penyesuaian kuantitas barang dengan pengecekan ketersediaan stok secara langsung ke basis data, penghapusan item terpilih, kalkulasi `subtotal_estimasi` otomatis, dan pembaruan alamat pengiriman langsung dari panel keranjang.

4. **Pemesanan Daring Fleksibel (*Pick-up* & *Pesan Antar*)**
* **Layanan Ambil di Toko (*Pick up*):** Bebas biaya pengiriman (`biaya_ongkir = Rp0`), mendukung metode pembayaran tunai di kasir menggunakan *Kode Transaksi Cash* unik (contoh: `CSH-261008-001`) maupun pembayaran non-tunai (*E-Wallet* / *M-Banking*).
* **Layanan Pesan Antar (*Delivery*):** Mencatat alamat pengiriman pelanggan dengan penambahan biaya ongkos kirim tetap sebesar `Rp5.000,00` ke dalam `total_bayar` serta mekanisme unggah bukti pembayaran digital (`bukti_pembayaran`).

5. **Sistem Kasir Gerai Fisik (*Point of Sale* / POS *Offline*)**
* Memfasilitasi petugas kasir dalam menginput ID produk dan kuantitas pembelian langsung di gerai tanpa mewajibkan pembeli memiliki akun pelanggan (cukup mencatat `nama_pembeli` opsional).
* Menghitung total tagihan, memproses pembayaran tunai beserta kalkulasi otomatis `nominal_kembalian`, serta melayani pembayaran kasir non-tunai (*E-Wallet* / *M-Banking*).

6. **Verifikasi Pembayaran Berjenjang & Pelacakan Status Pesanan**
* Menerapkan aturan bisnis di mana pemotongan stok fisik pada tabel `produk` dan pencatatan `waktu_lunas` hanya dieksekusi setelah petugas memverifikasi bukti pembayaran pelanggan menjadi `'Berhasil'`.
* Memisahkan status keuangan (`status_pembayaran`: `'Menunggu verifikasi'`, `'Berhasil'`, `'Dibatalkan'`) dari siklus pemenuhan logistik pesanan (`status_pesanan`: `'Dikemas'`, `'Siap diambil'`, `'Dikirim'`, `'Selesai'`, `'Dibatalkan'`).

7. **Dashboard Analitik & Rekapitulasi Laporan Penjualan**
* Menyajikan rekapitulasi pendapatan harian terpadu dari kanal penjualan *Online* dan *Offline* yang telah berstatus lunas (`'Berhasil'`) menggunakan visualisasi grafik kustom (`ChartPanel`) dan tabel rincian pendapatan (`PendapatanRow`).

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

#### 2. Pemetaan Use Case Diagram
<img width="1381" height="844" alt="Use Case Pocketly" src="https://github.com/user-attachments/assets/4652fa01-fdcc-4c96-9328-23cc5140d1f9" />

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



#### 3. Rangkuman Alur Proses (9 Flowchart Sistem)

1. **Alur Login & Registrasi:** Menampilkan halaman masuk; jika pengguna memilih registrasi, sistem memvalidasi ketersediaan `username` di database pengguna (menolak jika duplikat, menyimpan jika unik). Saat login, sistem memverifikasi kredensial dan mengarahkan antarmuka berdasarkan *role* (`Petugas` ke `PetugasFrame`, `Pelanggan` ke `PelangganFrame`).
2. **Alur Beranda Pelanggan:** Menampilkan katalog produk berdasarkan kategori. Ketika pelanggan menekan tombol tambah (`+`), sistem memeriksa stok pada database produk; jika mencukupi, item masuk ke database keranjang disertai notifikasi `"Item ditambahkan"`.
3. **Alur Keranjang Belanja & Checkout:** Memeriksa isi keranjang pelanggan; mendukung pemilihan tipe pemesanan (*Pesan Antar* atau *Pick Up*), pengubahan alamat profil, penyesuaian jumlah item dengan validasi stok, penghapusan item, hingga proses *Checkout* menggunakan *E-Wallet* (unggah bukti pembayaran) atau *Cash* (menampilkan kode transaksi) yang menetapkan status awal `"Menunggu verifikasi"`.
4. **Alur Riwayat Transaksi & Profil Pelanggan:** Menampilkan daftar pesanan pelanggan beserta tampilan rincian lengkap (ID transaksi, tanggal, status pesanan, status pembayaran, penerima, alamat, item produk, metode bayar, ongkir, subtotal) dan informasi profil yang dilengkapi fitur *Logout*.
5. **Alur Beranda & Laporan Pendapatan Petugas:** Menampilkan navigasi utama petugas serta rekapitulasi pendapatan dari database transaksi. Jika terdapat riwayat transaksi lunas, sistem merender total akumulasi pendapatan beserta tabel dan grafik penjualan harian.
6. **Alur Kelola Produk Petugas:** Memfasilitasi penambahan produk baru, pengeditan atribut produk melalui validasi input, penyesuaian stok langsung (`+/-` atau angka), serta pengubahan status produk (`Aktif` / `Nonaktif`) melalui *dropdown*.
7. **Alur Verifikasi Pembayaran Petugas:** Menampilkan daftar transaksi pelanggan beserta pratinjau bukti pembayaran atau kode kas. Saat petugas memilih status `"Valid"`, sistem memperbarui status pembayaran di database transaksi menjadi `'Berhasil'`, memotong stok di database produk, dan menampilkan notifikasi `"Bukti pembayaran diterima"`. Jika `"Tidak Valid"`, status menjadi `'Dibatalkan'`.
8. **Alur Ubah Status Pesanan Petugas:** Memungkinkan petugas memperbarui tahapan logistik pesanan daring melalui *dropdown* (`Dikemas`, `Dikirim`, `Siap diambil`, `Selesai`) yang langsung disimpan ke tabel `online`.
9. **Alur Kasir Offline Petugas:** Memvalidasi input ID produk dan jumlah beli terhadap ketersediaan stok, menampilkan ringkasan pembayaran (*Tunai* dengan kalkulasi uang bayar dan kembalian, atau konfirmasi *E-Wallet*), lalu menyimpan transaksi sekaligus memotong stok produk secara permanen.

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

1. **Encapsulation (Enkapsulasi)**
* Seluruh atribut entitas data pada package `com.pocketly.model` (seperti `id_pengguna`, `nama`, `stok`, `harga`, `total_harga`) dideklarasikan berakses **`private`**.
* Pengaksesan dan modifikasi data wajib melalui fungsi **`getter`** dan **`setter`** publik untuk menjaga integritas data agar tidak diubah secara bebas di luar kelasnya.

2. **Inheritance (Pewarisan)**
* **Supertype-Subtype Pengguna:** Kelas `Pengguna` bertindak sebagai *superclass* (parent) yang memuat variabel umum (`id`, `username`, `password`, `role`), kemudian diturunkan (*extends*) menjadi kelas *subclass* seperti `Petugas` (Admin/Kasir) dan `Pelanggan`.
* Memungkinkan penggunaan ulang kode (*code reusability*) secara efisien tanpa perlu mendeklarasikan ulang variabel umum.

3. **Polymorphism (Polimorfisme)**
* **Method Overriding:** Kelas turunan mengimplementasikan kembali metode dari kelas induk atau interface untuk memberikan perilaku spesifik. Contohnya kalkulasi total bayar atau pencetakan rincian transaksi antara transaksi kasir *offline* dan transaksi pesan-antar *online*.
* **Method Overloading:** Penggunaan nama metode yang sama dengan kombinasi parameter berbeda pada lapisan Controller/DAO (misalnya pemanggilan `pencarianProduk(String keyword)` dan `pencarianProduk(int idKategori)`).

4. **Abstraction (Abstraksi)**
* Penerapan pola **DAO (Data Access Object)** memisahkan secara total kompleksitas operasi basis data JDBC dari lapisan visual antarmuka pengguna.
* Controller hanya perlu memanggil metode abstrak seperti `transaksiDAO.tambahTransaksi(...)` atau `produkDAO.updateStok(...)` tanpa harus mengetahui detail implementasi sintaks SQL yang dieksekusi di tingkat basis data.


---

### Cara Penggunaan, Konfigurasi Database, & Akun Pengujian

#### 1. Prasyarat Sistem

* **Java Development Kit (JDK):** Versi 17 atau lebih baru.
* **Apache Maven:** Terinstal atau terbundel di dalam Apache NetBeans IDE.
* **MySQL Server:** Versi 8.0+ (misalnya melalui Laragon / XAMPP) berjalan pada port `3306`.



#### 2. Langkah Instalasi & Konfigurasi Basis Data

1. **Clone Repositori:**
```bash
git clone https://github.com/yuzarrahmat/Pocketly.git
cd Pocketly

```


2. **Impor Skema & Data Awal Basis Data (`db_pocketly`):**
Buat basis data `db_pocketly` di MySQL dan impor berkas skrip SQL yang tersedia di folder `sql/`:


```sql
CREATE DATABASE IF NOT EXISTS db_pocketly CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE db_pocketly;
SOURCE sql/db_pocketly.sql;

```


3. **Konfigurasi Hak Akses DCL (Opsional / Standar Keamanan Produksi):**
Sesuai standar keamanan basis data proyek, Anda dapat membuat akun pengguna basis data khusus untuk operasional aplikasi petugas dan administrator:


```sql
CREATE USER 'petugas'@'localhost' IDENTIFIED BY '1234';
GRANT SELECT, INSERT, UPDATE ON db_pocketly.produk TO 'petugas'@'localhost';
GRANT SELECT, INSERT, UPDATE ON db_pocketly.kategori_produk TO 'petugas'@'localhost';
GRANT SELECT, INSERT, UPDATE ON db_pocketly.transaksi TO 'petugas'@'localhost';
GRANT SELECT, INSERT, UPDATE ON db_pocketly.online TO 'petugas'@'localhost';
GRANT SELECT, INSERT, UPDATE ON db_pocketly.offline TO 'petugas'@'localhost';
GRANT SELECT, INSERT, UPDATE ON db_pocketly.detail_transaksi TO 'petugas'@'localhost';
GRANT SELECT ON db_pocketly.pengguna TO 'petugas'@'localhost';
GRANT SELECT ON db_pocketly.petugas TO 'petugas'@'localhost';
GRANT SELECT ON db_pocketly.pelanggan TO 'petugas'@'localhost';

CREATE USER 'db_administrator'@'localhost' IDENTIFIED BY '1234';
GRANT ALL PRIVILEGES ON db_pocketly.* TO 'db_administrator'@'localhost' WITH GRANT OPTION;
FLUSH PRIVILEGES;

```


4.  Atur Berkas Konfigurasi `db.properties`:
Salin berkas `db.properties.example` menjadi `db.properties` di direktori akar proyek, lalu sesuaikan parameter koneksi MySQL lokal Anda:
```properties
db.url=jdbc:mysql://localhost:3306/db_pocketly
db.user=root
db.password=

```


5. **Kompilasi & Jalankan Aplikasi:**
Buka proyek di **Apache NetBeans IDE** lalu jalankan `com.pocketly.Main`, atau eksekusi melalui terminal Maven:
```bash
mvn clean compile exec:java -Dexec.mainClass="com.pocketly.Main"

```



#### 3. Daftar Akun Pengujian Bawaan (`db_pocketly.sql`)

Gunakan kredensial resmi dari *seed data* `db_pocketly.sql` berikut untuk menguji seluruh fitur berdasarkan hak akses masing-masing aktor:

| Peran Pengguna | Sub-Peran / Jabatan | Username | Password | Identitas / Keterangan Pengujian |
| --- | --- | --- | --- | --- |
| **Petugas** | **Admin** | `ptg_andi` | `Andi@Pocket#01` | NIP: `PTG-2026-001` — Pengelolaan produk, verifikasi & laporan |
| **Petugas** | **Admin** | `ptg_siti` | `SitiAdm$Pk02` | NIP: `PTG-2026-002` — Pengelolaan produk, verifikasi & laporan |
| **Petugas** | **Kasir** | `ptg_rudi` | `Rudi!Kasir#03` | NIP: `PTG-2026-003` — Pelayanan POS Kasir Offline & pemrosesan pesanan |
| **Petugas** | **Kasir** | `ptg_dewi` | `Dewi*Kasir@04` | NIP: `PTG-2026-004` — Pelayanan POS Kasir Offline & pemrosesan pesanan |
| **Pelanggan** | Pelanggan Terdaftar | `rina_ayu` | `RinaAyu#2026a` | Rina Ayuningtyas (`Jl. Mawar No. 12 RT 05`) — Memiliki item keranjang & histori |
| **Pelanggan** | Pelanggan Terdaftar | `budi_san` | `BudiSan!7731` | Budi Santoso (`Jl. Melati No. 7 RT 02`) — Memiliki pesanan *Dikirim* (`TRX022`) |
| **Pelanggan** | Pelanggan Terdaftar | `siti_aminah` | `SitiAm@8842` | Siti Aminah (`Jl. Kenanga No. 21 RT 08`) — Memiliki pesanan *Siap diambil* (`TRX023`) |
| **Pelanggan** | Pelanggan Terdaftar | `dewi_angg` | `DewiAn#1064` | Dewi Anggraini (`Jl. Dahlia No. 15 RT 06`) — Memiliki pesanan *Menunggu verifikasi* (`TRX025`) |



#### 4. Struktur Tangkapan Layar Antarmuka (Screenshot GUI)

Susunan direktori dokumentasi visual antarmuka aplikasi pada `README.md`:

```markdown
### 🖥️ Tangkapan Layar Antarmuka (GUI)

#### A. Antarmuka Pelanggan (`com.pocketly.view.pelanggan`)
| Beranda & Katalog (`BerandaPanel`) | Keranjang & Checkout (`KeranjangPanel`) |
| :---: | :---: |
| ![Beranda Pelanggan](docs/screenshots/pelanggan_beranda.png) | ![Keranjang Belanja](docs/screenshots/pelanggan_keranjang.png) |
| **Riwayat & Status Pesanan (`TransaksiPanel`)** | **Profil Pelanggan (`ProfilPanel`)** |
| ![Transaksi Pelanggan](docs/screenshots/pelanggan_transaksi.png) | ![Profil Pelanggan](docs/screenshots/pelanggan_profil.png) |

#### B. Antarmuka Petugas / Admin (`com.pocketly.view.petugas`)
| Dashboard & Grafik Pendapatan (`BerandaPetugasPanel`) | POS Kasir Offline (`KasirPanel`) |
| :---: | :---: |
| ![Dashboard Petugas](docs/screenshots/petugas_beranda.png) | ![Kasir Offline](docs/screenshots/petugas_kasir.png) |
| **Manajemen Produk & Stok (`KelolaProdukPanel`)** | **Verifikasi Pembayaran & Status (`VerifikasiPanel` & `StatusPanel`)** |
| ![Kelola Produk](docs/screenshots/petugas_produk.png) | ![Verifikasi & Status](docs/screenshots/petugas_verifikasi.png) |

```

---
