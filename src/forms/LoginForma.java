package forms;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main.DB;
import main.Stats;

public class LoginForma extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
                
        Label label1 = new Label("Username:");
        label1.setLayoutX(80);
        label1.setLayoutY(30);
        Label label2 = new Label("Password:");
        label2.setLayoutX(80);
        label2.setLayoutY(90);
        
        TextField username = new TextField();
        username.setLayoutX(80);
        username.setLayoutY(50);
        username.setPrefHeight(20);
        username.setPrefWidth(140);
        username.setAlignment(Pos.CENTER);
        
        PasswordField password = new PasswordField();
        password.setLayoutX(80);
        password.setLayoutY(110);
        password.setPrefHeight(20);
        password.setPrefWidth(140);
        password.setAlignment(Pos.CENTER);
        
        Button loginButton = new Button("Login");
        loginButton.setLayoutX(90);
        loginButton.setLayoutY(160);
        loginButton.setPrefHeight(20);
        loginButton.setPrefWidth(120);
        
        Button register = new Button("New player?");
        register.setLayoutX(90);
        register.setLayoutY(220);
        register.setPrefHeight(20);
        register.setPrefWidth(120);
        
        AnchorPane root = new AnchorPane();
        root.getChildren().add(label1);
        root.getChildren().add(label2);
        root.getChildren().add(username);
        root.getChildren().add(password);
        root.getChildren().add(loginButton);
        root.getChildren().add(register);
        
        Scene scene = new Scene(root, 300, 280);
        
            loginButton.setOnAction((ActionEvent event) -> {
            try {
                DB con = new DB();
                
                ResultSet rs = con.query("SELECT * FROM korisnik WHERE username = '" + username.getText() + "' AND password = '" + password.getText()+ "'");
                
                String user = "";
                int id = 0;
                
                if (rs.first()) {
                    user = rs.getString("username");
                    id = rs.getInt("idKorisnika");
                    ResultSet rs2 = con.query("SELECT * FROM stats WHERE idKorisnika = " + id);
                    
                    Stats stats = new Stats();
                    stats.setId(id);
                    
                    if (rs2.first()){
                        stats.setBestScoreEasy(rs2.getFloat("bestScoreEasy"));
                        stats.setBestScoreMed(rs2.getFloat("bestScoreMed"));
                        stats.setBestScoreHard(rs2.getFloat("bestScoreHard"));
                        stats.setGamesPlayedEasy(rs2.getInt("gamesPlayedEasy"));
                        stats.setGamesPlayedMed(rs2.getInt("gamesPlayedMed"));
                        stats.setGamesPlayedHard(rs2.getInt("gamesPlayedHard"));
                    }
                            
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setScene(MainForma.getMainForma(user, stats, scene));
                    stage.setTitle("Program - Main");
                    stage.show();
                } else {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Greska!");
                    alert.setHeaderText("Greska prilikom logovanja");
                    alert.setContentText("Proverite podatke i pokusajte ponovo!");
                    
                    alert.showAndWait();
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(LoginForma.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(LoginForma.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(LoginForma.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
                
        register.setOnAction((ActionEvent event) -> {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(RegisterForma.getRegisterForma(scene));
            stage.setTitle("Program - Register");
            stage.show();
        });
        
        primaryStage.setTitle("Program - Login");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
