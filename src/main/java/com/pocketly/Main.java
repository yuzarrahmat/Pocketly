/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.pocketly;

import com.pocketly.util.DB;
import com.pocketly.util.Theme;
import com.pocketly.view.LoginFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;


public class Main {

    public static void main(String[] args) {
        // Coba pakai Nimbus Look and Feel sebagai dasar tampilan modern
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getName());
                    break;
                }
            }
        } catch (Exception ex) {
            // fallback ke Look and Feel bawaan sistem
        }

        
        try {
            DB.ensurePatch();
        } catch (Throwable ex) {
            // ditangkap Throwable agar ExceptionInInitializerError / NoClassDefFoundError
            // (mis. driver MySQL hilang dari classpath) tidak membuat window tidak muncul
            System.err.println("[DB] Patch skema gagal (aplikasi tetap dijalankan): " + ex.getMessage());
        }
        if (!DB.driverTersedia()) {
            System.err.println("[DB] Aplikasi berjalan TANPA koneksi database.");
            System.err.println("[DB] Cek: (1) XAMPP/MySQL aktif, (2) database db_pocketly ada,");
            System.err.println("[DB] (3) klik kanan project -> Clean and Build agar dependensi Maven terunduh.");
        }

        SwingUtilities.invokeLater(() -> {
            try {
                Theme.installGlobalFonts();
                new LoginFrame().setVisible(true);
            } catch (Throwable ex) {
                // jangan biarkan window "hilang" tanpa jejak: tampilkan penyebabnya di konsol
                System.err.println("[MAIN] Gagal membuka jendela Login: " + ex);
                ex.printStackTrace();
            }
        });
    }
}
