package main;

import java.sql.SQLException;

public class Stats {
    private float bestScoreEasy = 0;
    private float bestScoreMed = 0;
    private float bestScoreHard = 0;
    private int gamesPlayedEasy = 0;
    private int gamesPlayedMed = 0;
    private int gamesPlayedHard = 0;
    private int id = 0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public float getBestScoreEasy() {
        return bestScoreEasy;
    }

    public void setBestScoreEasy(float bestScoreEasy) {
        this.bestScoreEasy = bestScoreEasy;
    }

    public float getBestScoreMed() {
        return bestScoreMed;
    }

    public void setBestScoreMed(float bestScoreMed) {
        this.bestScoreMed = bestScoreMed;
    }

    public float getBestScoreHard() {
        return bestScoreHard;
    }

    public void setBestScoreHard(float bestScoreHard) {
        this.bestScoreHard = bestScoreHard;
    }

    public int getGamesPlayedEasy() {
        return gamesPlayedEasy;
    }

    public void setGamesPlayedEasy(int gamesPlayedEasy) {
        this.gamesPlayedEasy = gamesPlayedEasy;
    }

    public int getGamesPlayedMed() {
        return gamesPlayedMed;
    }

    public void setGamesPlayedMed(int gamesPlayedMed) {
        this.gamesPlayedMed = gamesPlayedMed;
    }

    public int getGamesPlayedHard() {
        return gamesPlayedHard;
    }

    public void setGamesPlayedHard(int gamesPlayedHard) {
        this.gamesPlayedHard = gamesPlayedHard;
    }
    
    public void saveStats() throws ClassNotFoundException, SQLException{
         DB con = new DB();
         con.execute("UPDATE stats SET bestScoreEasy = " + this.bestScoreEasy + ","
                 + " bestScoreMed = " + this.bestScoreMed + ","
                 + " bestScoreHard = " + this.bestScoreHard + ","
                 + " gamesPlayedEasy = " + this.gamesPlayedEasy + ","
                 + " gamesPlayedMed = " + this.gamesPlayedMed + ","
                 + " gamesPlayedHard = " + this.gamesPlayedHard + " WHERE idKorisnika = " + this.id);
         con.close();
    }
}
