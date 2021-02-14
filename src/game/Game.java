package game;

import forms.MainForma;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import main.AccurateTime;
import main.DB;
import main.Stats;

public class Game {
    private ArrayList<Field> fields;
    private Timer timer;
    private long startTime;
    private long endTime;
    private int score;
    private Field openField;
    private Stats stats;
    private Scene loginForm;
    private Label polja;

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }
    
    public Game() {}
    
    public Game(Label lbl, Stats stats, Scene scene, Label polja) throws IOException, InterruptedException{
        AccurateTime t = new AccurateTime(this, 0);
        this.polja = polja;
        this.stats = stats;
        fields = new ArrayList<>();
        score = 0;
        openField = null;
        timer = new Timer(lbl);
        timer.start();
        this.loginForm = scene;
    }

    public Timer getTimer() {
        return timer;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int points) throws ClassNotFoundException, SQLException, IOException {
        this.score += points;
        this.polja.setText("" + (this.score*2) + "/" + fields.size());
        if (this.score == fields.size()/2){
            float time = timer.end();
            AccurateTime t = new AccurateTime(this, 1);
            
            if (fields.size() == 8)
            {
                if (time < this.stats.getBestScoreEasy() || this.stats.getBestScoreEasy() == 0)
                {
                    this.stats.setBestScoreEasy(time);
                }
                
                this.stats.setGamesPlayedEasy(this.stats.getGamesPlayedEasy() + 1);
            } else if (fields.size() == 12)
            {
                if (time < this.stats.getBestScoreMed() || this.stats.getBestScoreMed() == 0)
                {
                    this.stats.setBestScoreMed(time);
                }
                
                this.stats.setGamesPlayedMed(this.stats.getGamesPlayedMed() + 1);
            } else 
            {
                if (time < this.stats.getBestScoreHard() || this.stats.getBestScoreHard() == 0)
                {
                    this.stats.setBestScoreHard(time);
                }
                
                this.stats.setGamesPlayedHard(this.stats.getGamesPlayedHard() + 1);
            }
            
            this.stats.saveStats();
            
            Alert alert = new Alert(AlertType.INFORMATION);
            if (this.endTime != 0) {
               alert.setContentText("Na nasem tajmeru: " + (time * 1000) + " milisekundi\nVreme sa web servisa: " + (this.endTime - this.startTime) + " milisekundi");
            } else {
               alert.setContentText("Na nasem tajmeru: " + (time * 1000) + " milisekundi\nVreme sa web servisa: Nije dostupno trenutno :(");
            }
            alert.setTitle("Rezultati!");
            alert.setHeaderText("Evo vasih rezultata:");
            alert.showAndWait();
            
            String user = "";
            
            DB con = new DB();
            ResultSet rs = con.query("SELECT * FROM korisnik WHERE idKorisnika = " + this.stats.getId());
            rs.first();
            user = rs.getString("username");
            con.close();
            
            Stage stage = (Stage) ((Node) fields.get(0).getPolje()).getScene().getWindow();
            stage.setScene(MainForma.getMainForma(user, stats, loginForm));
            stage.setTitle("Program - Main");
            stage.show();
        }
    }

    public Field getOpenField() {
        return openField;
    }

    public void setOpenField(Field openField) {
        this.openField = openField;
    }
    
    public void clearOpenField(){
        this.openField = null;
    }
    
    public void addField(Field f) {
        this.fields.add(f);
    }

    void check() {
        for(Field f : this.fields)
        {
            if (!f.isSolved() && !f.isClicked()){
                f.getPolje().setBackground(new Background(new BackgroundFill(Paint.valueOf("gray"), new CornerRadii(25), Insets.EMPTY)));
            }
        }
    }
}
