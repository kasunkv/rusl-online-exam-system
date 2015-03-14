package rusl.online.examination.system.client.utility;


import rusl.online.examination.system.server.utility.*;
import java.io.Serializable;

public class Message implements Serializable{
    private String message;
    private int index;
    private float average;

    public float getAverage() {
        return average;
    }

    public int getIndex() {
        return index;
    }

    public String getMessage() {
        return message;
    }

    public void setAverage(float average) {
        this.average = average;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}
