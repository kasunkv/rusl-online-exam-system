
package rusl.online.examination.system.client;

import de.javasoft.plaf.synthetica.SyntheticaBlueSteelLookAndFeel;
import javax.swing.UIManager;

public class RUSLOnlineExaminationSystemClient {

    public static void main(String[] args) {
        try {
           //UIManager.setLookAndFeel(new SyntheticaBlackMoonLookAndFeel());
            UIManager.setLookAndFeel(new SyntheticaBlueSteelLookAndFeel());
        } catch (Exception e) 
        {
            System.err.println(e.toString());
        }  
        new ClientLogin().setVisible(true);
    }
}
