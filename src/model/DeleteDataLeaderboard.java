/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.SQLException;

/**
 *
 * @author KLaZ
 */
public class DeleteDataLeaderboard extends Connector{
    public void deleteAllData(){
        try {
            statement = koneksi.createStatement();
            String query = "DELETE FROM leaderboard";
            statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
        }
    }
}
