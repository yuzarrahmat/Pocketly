/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.pocketly.model;

public class Pengguna {

    public String username;
    public String password;
    public String peran; // "Petugas" atau "Pelanggan"

    public Pengguna() {
    }

    public Pengguna(String username, String password, String peran) {
        this.username = username;
        this.password = password;
        this.peran = peran;
    }

    public boolean isPetugas() {
        return "Petugas".equals(peran);
    }
}
