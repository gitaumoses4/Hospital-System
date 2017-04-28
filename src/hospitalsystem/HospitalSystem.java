package hospitalsystem;

import java.awt.EventQueue;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Moses Muigai Gitau
 */
public class HospitalSystem {

    public static void main(String args[]) {
        try {
            EventQueue.invokeAndWait(() -> {
                try {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
                    //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                    SplashScreen screen = new SplashScreen(0, 500) {

                        @Override
                        public void splashScreenHidden() {
//                            setVisible(false);
//                            MainWindow mainWindow = new MainWindow(new User("EMP0000",
//                                    "Moses",
//                                    "Muigai",
//                                    "gitaumoses4@gmail.com",
//                                    User.Type.ADMINISTRATOR.toString(),
//                                    "admin",
//                                    "admin"));
//                            mainWindow.setVisible(true);
                            LogIn logIn = new LogIn();
                            logIn.setVisible(true);
                        }

                    };
                    screen.setVisible(true);
                    screen.setMessage("Loading modules... Please wait.");
                    // mainWindow.setVisible(true);
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
                }
            });
        } catch (InterruptedException ex) {
            Logger.getLogger(HospitalSystem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(HospitalSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
