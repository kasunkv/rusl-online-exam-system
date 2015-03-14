
package rusl.online.examination.system.client.utility;

import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;


public class CountdownTimer {
    private static Timer timer;
    private static int mins;
    private static int secs;
    private static int seconds;
    private static int period = 1000;
    private static int delay = 1000;   
    private static JLabel lbl = null;

    public static Timer getTimer() {
        return timer;
    }
    
    
    public static void startTimer() {
        try {
            timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    String temp = executeTime();
                    if(temp == null)
                        return;
                    lbl.setText(temp);
                    //System.out.println(temp);
                }
            }, delay, period);         
            
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }
    
    public static void start(JLabel lable, int sec) {
        seconds = sec;
        lbl = lable;              
        startTimer();
        //stopTimer();
    }
    
    public static String executeTime() {                
        String time;        
        mins = (int)Math.floor(seconds / 60.0);
        secs = seconds - (mins * 60);  
        if(secs == 0) {
           mins--;
           secs = 59;
        }
        time = createTimeString(mins, secs);        
        if(mins < 0) {
            time = createTimeString(0, 0); 
        }
        //System.out.println(time);        
        seconds--;
        if(seconds == -2) {
            timer.cancel();
            return null;        
        } else
            return time;
    }
    
    public static String createTimeString(int mins, int secs) {
        String minutes;
        String seconds;
        
        minutes = (mins < 10) ? String.format("%02d", mins) : String.valueOf(mins);
        seconds = (secs < 10) ? String.format("%02d", secs) : String.valueOf(secs);
        
        StringBuilder sb = new StringBuilder();
        sb.append(minutes);
        sb.append(":");
        sb.append(seconds);
        
        return sb.toString();
    }
    
    private static void stopTimer() {
        timer.cancel();
    }
   
}



