package forms;

import java.util.ArrayList;
import java.util.Random;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Paint;
import game.Field;
import game.Game;
import java.io.IOException;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import main.Stats;

public class GameForma {
    public static String[] colors = {"darkred", "crimson", "darkorchid", "indigo",
                                     "green", "goldenrod", "darkturquoise", "coral", "cyan", "lightskyblue",
                                     "limegreen", "deeppink"};
    
    public static Scene getGameForma(int userID, int num_of_fields, Stats stats, Stage stage, Scene scene) throws IOException, InterruptedException {
        int x = 4;
        int y = num_of_fields/4;
        
        AnchorPane root = new AnchorPane();
        
        ArrayList<String> selectedColors = new ArrayList<>();
        ArrayList<String> legitColors = new ArrayList<>();
        
        for (int i = 0; i < GameForma.colors.length; i++)
        {
            legitColors.add(GameForma.colors[i]);
        }
        
        Random randomizer = new Random();
        
        while (selectedColors.size() < num_of_fields) {
            String color = legitColors.get(randomizer.nextInt(legitColors.size()));
            legitColors.remove(color);
            selectedColors.add(color);
            selectedColors.add(color);
        }
        
        Label time_l = new Label("Vreme:");
        time_l.setAlignment(Pos.CENTER);
        time_l.setFont(new Font(20));
        time_l.setLayoutX(20);
        time_l.setLayoutY(num_of_fields/4 * 100 + 19);
        root.getChildren().add(time_l);
        
        Label time = new Label("0");
        time.setAlignment(Pos.CENTER);
        time.setFont(new Font(20));
        time.setLayoutX(90);
        time.setLayoutY(num_of_fields/4 * 100 + 20);
        root.getChildren().add(time);
        
        Label polja_l = new Label("Polja:");
        polja_l.setAlignment(Pos.CENTER);
        polja_l.setFont(new Font(20));
        polja_l.setLayoutX(280);
        polja_l.setLayoutY(num_of_fields/4 * 100 + 20);
        root.getChildren().add(polja_l);
        
        Label polja = new Label("0/" + num_of_fields);
        polja.setAlignment(Pos.CENTER);
        polja.setFont(new Font(20));
        polja.setLayoutX(350);
        polja.setLayoutY(num_of_fields/4 * 100 + 20);
        root.getChildren().add(polja);
        
        Game game = new Game(time, stats, scene, polja);
        
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override public void handle(WindowEvent t) {
                    game.getTimer().end();
                }
            });
        
        for (int i = 0; i < y; i++)
        {
            for (int j = 0; j < x; j++)
            {
                int rnd = randomizer.nextInt(selectedColors.size());
                Field btn = new Field("" + (i*x + (j+1)), selectedColors.get(rnd), game);
                selectedColors.remove(rnd);
                btn.getPolje().setStyle("-fx-underline: false; -fx-text-fill: #FFF");
                btn.getPolje().setAlignment(Pos.CENTER);
                btn.getPolje().setBackground(new Background(new BackgroundFill(Paint.valueOf("gray"), new CornerRadii(25), Insets.EMPTY)));//.setStyle("-fx-background: " + selectedColors.get(i*y + j));
                btn.getPolje().setLayoutX(100 * j + 10);
                btn.getPolje().setLayoutY(100 * i + 10);
                btn.getPolje().setPrefHeight(80);
                btn.getPolje().setPrefWidth(80);
                root.getChildren().add(btn.getPolje());
                game.addField(btn);
            }
        }
        
        
        return new Scene(root, 400, num_of_fields/4 * 100 + 100);
    }
}
