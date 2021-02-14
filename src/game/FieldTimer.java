package game;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Paint;

public class FieldTimer extends Thread {
    private Field polje;
    private int duration;

    public FieldTimer(Field polje, int duration) {
        this.polje = polje;
        this.duration = duration;
        this.start();
    }
    
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(1);
                this.duration -= 1;
                if (this.duration < 10)
                    break;
            } catch (InterruptedException ex) {
                Logger.getLogger(FieldTimer.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        this.polje.setClicked(false);
        this.polje.getPolje().setBackground(new Background(new BackgroundFill(Paint.valueOf("gray"), new CornerRadii(25), Insets.EMPTY)));
    }
}
