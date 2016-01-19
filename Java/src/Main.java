import com.sensored.Views.MainForm;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * Created by Katie on 19/01/2016.
 */
public class Main {
    public static void main(String args[])
    {
        MainForm mainPanel = new MainForm();
        JFrame frame = new JFrame();
        frame.setTitle("Library Book Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 700);

        frame.setContentPane(mainPanel.panel1);
        frame.setVisible(true);
    }
}
