package BallSim;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowListener extends WindowAdapter {

    public void windowClosing(WindowEvent e)
    {
        System.out.println("GUI closed.");
        System.exit(0);
    }

}
