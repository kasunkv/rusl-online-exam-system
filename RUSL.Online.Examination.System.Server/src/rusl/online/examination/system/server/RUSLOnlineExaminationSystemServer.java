
package rusl.online.examination.system.server;
import de.javasoft.plaf.synthetica.SyntheticaBlackMoonLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaBlueSteelLookAndFeel;
import javax.swing.UIManager;
public class RUSLOnlineExaminationSystemServer {

    public static void main(String[] args) {       

        try {
           //UIManager.setLookAndFeel(new SyntheticaBlackMoonLookAndFeel());
            UIManager.setLookAndFeel(new SyntheticaBlueSteelLookAndFeel());
        } catch (Exception e) 
        {
            System.err.println(e.toString());
        }    
        
        new ServerLogin().setVisible(true);
    }
}
