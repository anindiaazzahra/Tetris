package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.Arrays;
import controller.LeaderboardData;


public class LeaderboardModel extends Connector {

    public int getbannyakdata(){
        int Jmldata = 0;
        try {
            statement = koneksi.createStatement();
            String query = "SELECT * FROM leaderboard";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                Jmldata++;
            }
            return Jmldata;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
    
    public LeaderboardData readLeaderboard() {
        try {
        int jumlahdata = 0;
        String[][] data = new String[getbannyakdata()][2];
        String query = "SELECT username, score FROM leaderboard";
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            data[jumlahdata][0] = resultSet.getString("username");
            data[jumlahdata][1] = resultSet.getString("score");
            jumlahdata++;
        }

        // Mengurutkan data berdasarkan skor dari tertinggi ke terendah
        Arrays.sort(data, new Comparator<String[]>() {
            @Override
            public int compare(String[] row1, String[] row2) {
                int score1 = Integer.parseInt(row1[1]);
                int score2 = Integer.parseInt(row2[1]);
                return Integer.compare(score2, score1);
            }
        });

        // Membuat objek LeaderboardData yang berisi peringkat (rank) dan data yang sudah diurutkan
        LeaderboardData leaderboardData = new LeaderboardData();
        for (int i = 0; i < data.length; i++) {
            String[] row = data[i];
            String rank = String.valueOf(i + 1);
            leaderboardData.add(rank, row[0], row[1]);
        }

        return leaderboardData;
    } catch (SQLException e) {
        System.out.println(e.getMessage());
        System.out.println("SQL Error");
        return null;
    }
    }

    
}
