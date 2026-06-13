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

public class Testkoneksi {

    public static void main(String[] args) {

        Connection conn = Koneksi.getConnection();

        if (conn != null) {
            System.out.println("Database Terhubung");
        }

    }
}