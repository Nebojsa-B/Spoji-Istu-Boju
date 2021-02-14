package game;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Paint;

public class Field {
    private Hyperlink polje;
    private String color;
    private boolean solved;
    private boolean clicked;
    private Game game;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    public void setPolje(Hyperlink polje) {
        this.polje = polje;
    }
    
    public Hyperlink getPolje() {
        return this.polje;
    }

    public boolean isClicked() {
        return clicked;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }

    public boolean isSolved() {
        return solved;
    }
    
    public Field(String text, String color, Game game) {
        this.game = game;
        this.solved = false;
        this.clicked = false;
        this.color = color;
        this.polje = new Hyperlink(text);
        this.polje.setOnAction((ActionEvent event) -> {
            if (this.clicked == false) {
                this.game.check();
                this.clicked = true;
            if (this.solved == false){
                Background bck = new Background(new BackgroundFill(Paint.valueOf(this.color), new CornerRadii(25), Insets.EMPTY));
                this.polje.setBackground(bck);
                if (this.game.getOpenField() != null)
                {
                   if (this.game.getOpenField().color.equals(this.color)) 
                   {
                        this.solved = true;
                       try {
                           this.game.setScore(1);
                       } catch (ClassNotFoundException ex) {
                           Logger.getLogger(Field.class.getName()).log(Level.SEVERE, null, ex);
                       } catch (SQLException ex) {
                           Logger.getLogger(Field.class.getName()).log(Level.SEVERE, null, ex);
                       } catch (IOException ex) {
                           Logger.getLogger(Field.class.getName()).log(Level.SEVERE, null, ex);
                       }
                        this.game.getOpenField().solved = true;
                        this.game.getOpenField().setClicked(false);
                        this.game.clearOpenField();
                        this.clicked = false;
                   }
                   else 
                   {
                       
                       FieldTimer ft = new FieldTimer(this, 300);
                       FieldTimer ft2 = new FieldTimer(this.game.getOpenField(), 300);
                       this.game.clearOpenField();
                   }
                } else {
                    this.game.setOpenField(this);
                }
            }
           }
        });
    }
}
