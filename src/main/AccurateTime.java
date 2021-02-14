package main;

import game.Game;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.NtpV3Packet;
import org.apache.commons.net.ntp.TimeInfo;

public class AccurateTime extends Thread {
    private Game game;
    private int flag;
    
    public AccurateTime(Game game, int flag)
    {
        this.game = game;
        this.flag = flag;
        this.start();
    }
    
    @Override
    public void run() {
        try {
            String TIME_SERVER = "pool.ntp.org"; //"time.nist.gov"; 
            NTPUDPClient timeClient = new NTPUDPClient();
            timeClient.open();
            InetAddress inetAddress = InetAddress.getByName(TIME_SERVER);
            TimeInfo timeInfo = timeClient.getTime(inetAddress);
            NtpV3Packet message = timeInfo.getMessage();
            
            long serverTime = message.getTransmitTimeStamp().getTime();
            if (this.flag == 0){
                this.game.setStartTime(serverTime);
            } else {
                this.game.setEndTime(serverTime);
            }
            System.out.println(serverTime);
            
            timeClient.close();
        } catch (UnknownHostException ex) {
            Logger.getLogger(AccurateTime.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AccurateTime.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
