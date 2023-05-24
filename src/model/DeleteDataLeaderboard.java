package model;

import java.sql.SQLException;

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
