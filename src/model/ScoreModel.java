package model;

import java.sql.SQLException;
import java.sql.Statement;

public class ScoreModel extends Connector{
    
    public ScoreModel(String namaPlayer, int finalScore){
        try{
            String query = "INSERT INTO leaderboard(username,score) VALUES ('" + namaPlayer + "', '" + finalScore + " ')";
            statement = (Statement) koneksi.createStatement();
            statement.executeUpdate(query);
            System.out.println("Berhasil insert score");
        }catch(SQLException e){
            System.out.println("gagal insert score");
        }
    }
}
