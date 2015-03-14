package rusl.online.examination.system.client.utility;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;

public class Helper {
    
    // get input from the command prompt
    public static String getInput(String prompt)  {
        BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
        // Print the Prompt and clear the stream
        System.out.println(prompt);
        System.out.flush();
        
        try {
                return strin.readLine();
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
        
    }
    
    // Convert given String to MD5 hash string
    public static String toMD5(String str) {
        MessageDigest md = null;
        String hash = null;
        
        try {
            md = MessageDigest.getInstance("MD5");   
            hash = byteArrayToHexString(md.digest(str.getBytes("UTF-8")));
        } catch (Exception e) {
            System.err.println("Error: " + e.toString());
        }
        return hash;
    }
    
    // Convert byte Array to Hex String (Helper Method for toMD5() function
    public static String byteArrayToHexString(byte[] ary) {
        String result = "";
        for (int i=0; i < ary.length; i++) {
            result += Integer.toString(( ary[i] & 0xff) + 0x100, 16).substring(1);
        }
        return result;
    }
    
    // get the text of the selected button in a button group
    public static String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return button.getText();
            }
        }
        return null;
    }
    
    // checks to see if a button is selected in a button group
    public static boolean isRadioButtonSelected(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if(button.isSelected()) {
                return true;
            }
        }        
        return false;
    }    
    
}
