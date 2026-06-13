/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laundryapp;

/**
 *
 * @author danarbonarbuwono
 */

import java.sql.Connection;
import java.sql.DriverManager;

public class Koneksi {

    public static Connection getConnection() {

        try {

            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/laundry_db",
                    "root",
                    "");

            System.out.println("Koneksi Berhasil");

            return conn;

        } catch (Exception e) {

            System.out.println("Koneksi Gagal : " + e.getMessage());

            return null;
        }
    }
}