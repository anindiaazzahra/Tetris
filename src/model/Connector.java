/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Connector {
    String DBurl = "jdbc:mysql://localhost/tetris";
    String DBusername = "root";
    String DBpassword = "";
    static Connection koneksi;
    Statement statement;
    public Connector(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            koneksi = (Connection) DriverManager.getConnection(DBurl,DBusername,DBpassword);
            System.out.println("Berhasil connect ke database");
        }catch(Exception ex){  
            System.out.println("Gagal connect ke database");
        }
    }
}
