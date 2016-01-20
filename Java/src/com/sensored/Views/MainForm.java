package com.sensored.Views;

import javax.swing.*;

/**
 * Created by Katie on 19/01/2016.
 */
public class MainForm {
    private JTabbedPane tabbedPane;
    public JPanel panel1;
    private JPanel sessionPanel;
    private JPanel sensorsPanel;
    private JPanel aboutPanel;

    private void createUIComponents() {
        sensorsPanel = new SensorForm().getRoot();
    }
}
