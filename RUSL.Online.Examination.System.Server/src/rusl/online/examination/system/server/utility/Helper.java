
package rusl.online.examination.system.server.utility;

import java.awt.Toolkit;
import java.security.MessageDigest;
import java.util.Enumeration;
import java.util.LinkedList;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import rusl.online.examination.system.client.utility.Answer;
import rusl.online.examination.system.server.bean.Question;
import rusl.online.examination.system.server.bean.tables.QuestionManager;

public class Helper {
    
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
     /**************************/
    public static boolean checkAnswer(Answer ans) {
        Question fromDB = QuestionManager.getQuestionById(ans.getQuestionId());
        if (fromDB.getCorrectAns() == ans.getAnswer()) {
            return true;
        } else {
            return false;
        }
    }
    
    public static float calculateMarks(LinkedList<Answer> answerList, int numberofQuestions) {
        int total = 0;
        for (int i = 0; i < answerList.size(); i++) {
            if(checkAnswer(answerList.get(i))) {
                total += 1;
            }
        }
        return ((float)total / numberofQuestions * 100);
    }
    
    public static String calculateGrade(float marks) {
        return (marks > 50.0f) ? "Passed" : "Failed";
    }
    
    
}
