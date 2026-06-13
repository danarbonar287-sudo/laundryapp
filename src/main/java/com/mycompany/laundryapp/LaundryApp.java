/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.laundryapp;

/**
 *
 * @author danarbonarbuwono
 */
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;



public class LaundryApp {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("==============================");
        System.out.println("        SARII LAUNDRY ");
        System.out.println("==============================");

        System.out.println("\n======== LOGIN ========");
        System.out.print("Apakah sudah punya akun? (sudah/belum) ; ");
        String akun = input.nextLine();

        String username, password;

        if (akun.equalsIgnoreCase("belum")) {

            System.out.println("\n========= REGISTRASI =========");
            System.out.print("Buat username  : ");
            username = input.nextLine();

            System.out.print("Buat password  : ");
            password = input.nextLine();

            System.out.println("\nRegistrasi Berhasil");     
    }

        System.out.println("\n========= LOGIN AKUN =========");
        System.out.print("masukkan username  : ");
        username = input.nextLine();

        System.out.print("masukkan password  : ");
        password = input.nextLine();

        System.out.println("\nLogin Completed");
        System.out.println("\n====== BERANDA APLIKASI =======");

    char ulang;

    do {
        
        System.out.println("\n===== INPUT DATA CUSTOMER =====");

        System.out.print("Nama Customer : ");
        String nama = input.nextLine();

        System.out.print("No HP         : ");
        String noHP = input.nextLine();

        System.out.print("Alamat rumah  : ");
        String alamat = input.nextLine();
        
    try {
        
        System.out.println("MASUK TRY DATABASE");

        Connection conn = Koneksi.getConnection();

        String sql =
            "INSERT INTO pelanggan(nama,no_hp,alamat) VALUES (?,?,?)";

        PreparedStatement pst =
            conn.prepareStatement(sql);

        pst.setString(1, nama);
        pst.setString(2, noHP);
        pst.setString(3, alamat);

        pst.executeUpdate();

        System.out.println("Data customer tersimpan");

    } catch (Exception e) {

        System.out.println("Gagal simpan customer : " + e.getMessage());

    }

        System.out.println("\n===== PILIH PAKET LAUNDRY =====");
        System.out.println("1. Cuci Kering");
        System.out.println("2. Cuci + Setrika");
        System.out.println("3. Express");

        System.out.print("Masukkan Pilihan Paket : ");
        int pilihan = input.nextInt();
        
        String paket = "";
        int harga = 0;
        String estimasi = "";

        switch (pilihan) {

            case 1:
                paket = "Cuci Kering";
                harga = 50000;
                estimasi = "3 hari";
                break;

            case 2:
                paket = "Cuci + Setrika";
                harga = 70000;
                estimasi = "4 hari";
                break;

            case 3:
                paket = "Express";
                harga = 10000;
                estimasi = "1 hari";
                break;

            default:
                System.out.println("Paket tidak tersedia");
        }

        System.out.println("\ninput berat pakaian (Kg) : ");
        double berat = input.nextDouble();

        double totalBiaya = berat * harga;
        
    try {

        Connection conn = Koneksi.getConnection();

        String sql =
            "INSERT INTO transaksi(nama_customer,paket,harga_perkg,berat,total_biaya,estimasi) VALUES (?,?,?,?,?,?)";

        PreparedStatement pst =
            conn.prepareStatement(sql);

        pst.setString(1, nama);
        pst.setString(2, paket);
        pst.setInt   (3, harga);
        pst.setDouble(4, berat);
        pst.setDouble(5, totalBiaya);
        pst.setString(6, estimasi);

        pst.executeUpdate();

        System.out.println("Transaksi tersimpan");

    } catch (Exception e) {

        System.out.println("Gagal simpan transaksi : " + e.getMessage());

    }

        int jumlahMesin = 2;
        int staffSetrika = 2;


        System.out.println("=========================================");
        System.out.println("            NOTANYAA SAYANG");
        System.out.println("=========================================");

        System.out.println("Data Customer");
        System.out.println("---------------------------------");
        System.out.println("Nama Customer : " + nama);
        System.out.println("No HP         : " + noHP);
        System.out.println("Alamat rumah  : " + alamat);

        System.out.println("\nPaket Laundry");
        System.out.println("---------------------------------");
        System.out.println("Paket         : " + paket);
        System.out.println("Harga / Kg    : Rp " + harga);
        System.out.println("Berat Pakaian : " + berat + " Kg");

        System.out.println("\nPerhitungan");
        System.out.println("---------------------------------");
        System.out.println("Total Biaya   : Rp." + totalBiaya);
        System.out.println("Estimasi      : " + estimasi);

        System.out.println("Jumlah Mesin  : " + jumlahMesin);
        System.out.println("Staff Setrika : " + staffSetrika);
        System.out.println("---------------------------------");


        System.out.print("\n Mau laundry lagi? (Y/T) :");
        ulang = input.next().charAt(0);

    } while (ulang == 'Y' || ulang == 'y');

        System.out.println("==========================================");
        System.out.println("              SELESAIII");
        System.out.println("==========================================");

        System.out.println("              TERIMA KASIH                ");
        System.out.println("==========================================");

        input.close();
    }

}
     
        
        
        
