package controller;

import java.util.ArrayList;
import java.util.List;

public class LeaderboardData {
    private List<String[]> data;

    public LeaderboardData() {
        data = new ArrayList<>();
    }

    public void add(String rank, String username, String score) {
        String[] row = {rank, username, score};
        data.add(row);
    }

    public List<String[]> getData() {
        return data;
    }
}
