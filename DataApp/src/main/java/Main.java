
import com.github.dateapp.Database;
import com.github.dateapp.Util;
import com.github.dateapp.gui.FrameLogin;

/**
 * Main. Created on 20 Apr 2018 8:34:26 PM by Matthew.
 *
 * @author Matthew Van der Bijl (xq9x3wv31)
 */
public final class Main {

    /**
     * @param args Arguments from the command line
     */
    public static void main(String[] args) {
        Database.init();
        try {
            new FrameLogin(null).setVisible(true);
        } catch (Throwable t) {
            Util.err(t, null);
            main(args);
        }
        // Database.dispose();
    }
}
