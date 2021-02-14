package forms;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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

public class RegisterForma {
    public static Scene getRegisterFormaTest(){
        AnchorPane root = new AnchorPane();
        return new Scene(root, 300, 300);
    };
    
    public static Scene getRegisterForma(Scene scene)
    {
        Label label1 = new Label("Username:");
        label1.setLayoutX(80);
        label1.setLayoutY(30);
        Label label2 = new Label("Password:");
        label2.setLayoutX(80);
        label2.setLayoutY(90);
        Label label3 = new Label("Repeat password:");
        label3.setLayoutX(80);
        label3.setLayoutY(150);
        
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
        
        PasswordField password2 = new PasswordField();
        password2.setLayoutX(80);
        password2.setLayoutY(170);
        password2.setPrefHeight(20);
        password2.setPrefWidth(140);
        password2.setAlignment(Pos.CENTER);
        
        Button back = new Button("<");
        back.setLayoutX(20);
        back.setLayoutY(20);
        back.setOnAction((ActionEvent event) -> {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Program - Login");
            stage.show();
        });
        
        Button registerButton = new Button("Register");
        registerButton.setLayoutX(90);
        registerButton.setLayoutY(220);
        registerButton.setPrefHeight(20);
        registerButton.setPrefWidth(120);
        registerButton.setOnAction((ActionEvent event) -> {
            if (!"".equals(username.getText()) && (password.getText() == null ? password2.getText() == null : password.getText().equals(password2.getText()))) {
            try {
                DB con = new DB();
                
                ResultSet rs = con.query("SELECT * FROM korisnik WHERE username = '" + username.getText() + "'");
                
                if (rs.first())
                {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Greska!");
                    alert.setHeaderText("Nalog sa istim username-om vec postoji.");
                    alert.setContentText("Promenite podatke i pokusajte ponovo!");
                    
                    alert.showAndWait();
                } else {
                    con.execute("INSERT INTO korisnik (username, password) VALUES ('" + username.getText() + "','" + password.getText() + "')");
                    ResultSet rs2 = con.query("SELECT * FROM korisnik WHERE username = '" + username.getText() + "' and password = '" + password.getText() + "'");
                    rs2.first();
                    int id = rs2.getInt("idKorisnika");
                    
                    con.execute("INSERT INTO stats (idKorisnika) VALUES (" + id + ")");
                    
                    Stats stats = new Stats();
                    stats.setId(id);
                    
                    stats.setBestScoreEasy(0);
                    stats.setBestScoreHard(0);
                    stats.setBestScoreMed(0);
                    stats.setGamesPlayedEasy(0);
                    stats.setGamesPlayedMed(0);
                    stats.setGamesPlayedHard(0);
                    
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setScene(MainForma.getMainForma(username.getText(), stats, scene));
                    stage.setTitle("Program - Main");
                    stage.show();
                }
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(RegisterForma.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(RegisterForma.class.getName()).log(Level.SEVERE, null, ex);
            }   catch (IOException ex) {
                    Logger.getLogger(RegisterForma.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Greska!");
                alert.setHeaderText("Greska prilikom registracije.");
                alert.setContentText("Proverite sve podatke i pokusajte ponovo!");

                alert.showAndWait();
            }
        });
        
        AnchorPane root = new AnchorPane();
        root.getChildren().add(username);
        root.getChildren().add(password);
        root.getChildren().add(password2);
        root.getChildren().add(registerButton);
        root.getChildren().add(label1);
        root.getChildren().add(label2);
        root.getChildren().add(label3);
        root.getChildren().add(back);
        
        return new Scene(root, 300, 280);
    }
}
