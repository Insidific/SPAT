import com.sensored.Views.MainForm;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * Created by Katie on 19/01/2016.
 */
public class Main {
    public static void main(String args[])
    {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        MainForm mainPanel = new MainForm();
        JFrame frame = new JFrame();
        frame.setTitle("Sensored");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 700);

        JMenuBar menu = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem settings = new JMenuItem("Settings");

        file.add(settings);
        menu.add(file);

        frame.setJMenuBar(menu);

        frame.setContentPane(mainPanel.panel1);
        frame.setVisible(true);
    }
}
