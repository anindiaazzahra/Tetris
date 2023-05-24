package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

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
