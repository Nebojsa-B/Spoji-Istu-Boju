package game;

import java.io.IOException;
import javafx.application.Platform;
import javafx.scene.control.Label;

public class Timer extends Thread {
    private long startTime;
    private long endTime;
    private float value;
    private boolean enabled;
    private Label lbl;
    
    public Timer(Label lbl) throws IOException {
        this.lbl = lbl;
        this.startTime = 0;
        this.endTime = 0;
        this.value = 0;
        this.enabled = true;
    }
    
    public float end(){
        this.enabled = false;
        return this.value;
    }
    
    @Override
    public void run() {
        try {
            while (this.enabled) {
                this.value += 0.002;
                Platform.runLater(() -> {
                    this.lbl.setText(String.format("%.3f", (this.value)));
                });
                
                Thread.sleep(2);
            }
            
            //this.endTime = AccurateTime.getTimeLong();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
