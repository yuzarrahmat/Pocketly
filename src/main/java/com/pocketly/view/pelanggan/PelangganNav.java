package com.pocketly.view.pelanggan;

/** Kontrak navigasi yang dipakai panel-panel pelanggan untuk pindah halaman. */
public interface PelangganNav {

    void keBeranda();

    void keKeranjang();

    void keTransaksi();

    void keProfil();

    void perbaruiBadgeKeranjang();

    void logout();
}
