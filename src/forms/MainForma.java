package forms;

import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import main.Stats;

public class MainForma{

    public static Scene getMainForma(String user, Stats stats, Scene scene) throws UnknownHostException, IOException {
        Label userLabel = new Label(user);
        userLabel.setLayoutX(330);
        userLabel.setLayoutY(15);
        userLabel.setStyle("-fx-text-fill: dodgerblue; -fx-font-size: 22px; -fx-font-weight: lighter");
        
        Label stat = new Label("Stats");
        stat.setFont(new Font(24));
        stat.setLayoutX(40);
        stat.setLayoutY(30);
        
        Label easy = new Label("Easy");
        easy.setStyle("-fx-text-fill: forestgreen;");
        easy.setFont(new Font(16));
        easy.setLayoutX(40);
        easy.setLayoutY(65);

        Label easy_stats = new Label();
        easy_stats.setText("Best: " + String.format("%.3f", stats.getBestScoreEasy()) + " - Games played: " + stats.getGamesPlayedEasy());
        easy_stats.setStyle("-fx-text-fill: forestgreen;");
        easy_stats.setFont(new Font(16));
        easy_stats.setLayoutX(55);
        easy_stats.setLayoutY(85);
        
        Label med = new Label("Medium");
        med.setStyle("-fx-text-fill: chocolate ;");
        med.setFont(new Font(16));
        med.setLayoutX(40);
        med.setLayoutY(115);
        
        Label med_stats = new Label();
        med_stats.setText("Best: " + String.format("%.3f", stats.getBestScoreMed()) + " - Games played: " + stats.getGamesPlayedMed());
        med_stats.setStyle("-fx-text-fill: chocolate;");
        med_stats.setFont(new Font(16));
        med_stats.setLayoutX(55);
        med_stats.setLayoutY(135);
        
        Label hard = new Label("Hard");
        hard.setStyle("-fx-text-fill: crimson ;");
        hard.setFont(new Font(16));
        hard.setLayoutX(40);
        hard.setLayoutY(165);
        
        Label hard_stats = new Label();
        hard_stats.setText("Best: " + String.format("%.3f", stats.getBestScoreHard()) + " - Games played: " + stats.getGamesPlayedHard());
        hard_stats.setStyle("-fx-text-fill: crimson;");
        hard_stats.setFont(new Font(16));
        hard_stats.setLayoutX(55);
        hard_stats.setLayoutY(185);
        
        Button btn_easy = new Button("New Game");
        btn_easy.setStyle("-fx-text-fill: forestgreen;");
        btn_easy.setLayoutX(290);
        btn_easy.setLayoutY(85);
        btn_easy.setOnAction((ActionEvent event) -> {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            try {
                stage.setScene(GameForma.getGameForma(stats.getId(), 8, stats, stage, scene));
            } catch (IOException ex) {
                Logger.getLogger(MainForma.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(MainForma.class.getName()).log(Level.SEVERE, null, ex);
            }
            stage.setTitle("Program - Game");
            stage.show();
        });
        
        Button btn_med = new Button("New Game");
        btn_med.setStyle("-fx-text-fill: chocolate;");
        btn_med.setLayoutX(290);
        btn_med.setLayoutY(135);
        btn_med.setOnAction((ActionEvent event) -> {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            try {
                stage.setScene(GameForma.getGameForma(stats.getId(), 12, stats, stage, scene));
            } catch (IOException ex) {
                Logger.getLogger(MainForma.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(MainForma.class.getName()).log(Level.SEVERE, null, ex);
            }
            stage.setTitle("Program - Game");
            stage.show();
        });
        
        Button btn_hard = new Button("New Game");
        btn_hard.setStyle("-fx-text-fill: crimson;");
        btn_hard.setLayoutX(290);
        btn_hard.setLayoutY(185);
        btn_hard.setOnAction((ActionEvent event) -> {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            try {
                stage.setScene(GameForma.getGameForma(stats.getId(), 16, stats, stage, scene));
            } catch (IOException ex) {
                Logger.getLogger(MainForma.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(MainForma.class.getName()).log(Level.SEVERE, null, ex);
            }
            stage.setTitle("Program - Game");
            stage.show();
        });
        
        Button btn_reset_easy = new Button("Reset");
        btn_reset_easy.setStyle("-fx-text-fill: forestgreen;");
        btn_reset_easy.setLayoutX(380);
        btn_reset_easy.setLayoutY(85);
        btn_reset_easy.setOnAction((ActionEvent event) -> {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Resetovanje statistike");
            alert.setContentText("Da li ste sigurni da zelite resetovati statistiku?");
            alert.setHeaderText("Resetovanje statistike.");
            Optional<ButtonType> result = alert.showAndWait();
            
            if (result.get() == ButtonType.OK)
            {
                stats.setBestScoreEasy(0);
                stats.setGamesPlayedEasy(0);
                try {
                    stats.saveStats();
                    easy_stats.setText("Best: " + String.format("%.3f", stats.getBestScoreEasy()) + " - Games played: " + stats.getGamesPlayedEasy());
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MainForma.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(MainForma.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        Button btn_reset_med = new Button("Reset");
        btn_reset_med.setStyle("-fx-text-fill: chocolate;");
        btn_reset_med.setLayoutX(380);
        btn_reset_med.setLayoutY(135);
        btn_reset_med.setOnAction((ActionEvent event) -> {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Resetovanje statistike");
            alert.setContentText("Da li ste sigurni da zelite resetovati statistiku?");
            alert.setHeaderText("Resetovanje statistike.");
            Optional<ButtonType> result = alert.showAndWait();
            
            if (result.get() == ButtonType.OK)
            {
                stats.setBestScoreMed(0);
                stats.setGamesPlayedMed(0);
                try {
                    stats.saveStats();
                    med_stats.setText("Best: " + String.format("%.3f", stats.getBestScoreMed()) + " - Games played: " + stats.getGamesPlayedMed());
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MainForma.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(MainForma.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        Button btn_reset_hard = new Button("Reset");
        btn_reset_hard.setStyle("-fx-text-fill: crimson;");
        btn_reset_hard.setLayoutX(380);
        btn_reset_hard.setLayoutY(185);
        btn_reset_hard.setOnAction((ActionEvent event) -> {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Resetovanje statistike");
            alert.setContentText("Da li ste sigurni da zelite resetovati statistiku?");
            alert.setHeaderText("Resetovanje statistike.");
            Optional<ButtonType> result = alert.showAndWait();
            
            if (result.get() == ButtonType.OK)
            {
                stats.setBestScoreHard(0);
                stats.setGamesPlayedHard(0);
                try {
                    stats.saveStats();
                    hard_stats.setText("Best: " + String.format("%.3f", stats.getBestScoreHard()) + " - Games played: " + stats.getGamesPlayedHard());
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MainForma.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(MainForma.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        Button logout = new Button("< Logout");
        logout.setLayoutX(250);
        logout.setLayoutY(20);
        logout.setOnAction((ActionEvent event) -> {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Program - Login");
            stage.show();
        });
        
        AnchorPane root = new AnchorPane();
        root.getChildren().add(userLabel);
        root.getChildren().add(stat);
        root.getChildren().add(easy);
        root.getChildren().add(easy_stats);
        root.getChildren().add(btn_easy);
        root.getChildren().add(med);
        root.getChildren().add(med_stats);
        root.getChildren().add(btn_med);
        root.getChildren().add(hard);
        root.getChildren().add(hard_stats);
        root.getChildren().add(btn_hard);
        root.getChildren().add(btn_reset_easy);
        root.getChildren().add(btn_reset_med);
        root.getChildren().add(btn_reset_hard);
        root.getChildren().add(logout);
        
        return new Scene(root, 460, 240);
    }
}
