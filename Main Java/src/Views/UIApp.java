package Views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;

import javax.swing.JTextField;
import javax.swing.BoxLayout;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;

import java.awt.SystemColor;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;

import java.awt.BorderLayout;

public class UIApp extends JFrame {
	// add member variable JSplit split the window to 2 parts
	JSplitPane contentPane;
	private final JPanel panel = new JPanel();
	private final JComboBox comboBoxCOMPortMain = new JComboBox();
	private final JButton btnStart = new JButton("Start");
	private final JButton btnWebsite = new JButton("Website");
	private final JMenuBar menuBar = new JMenuBar();
	private final JMenu mnFile = new JMenu("File");
	private final JMenuItem mntmStartStop = new JMenuItem("Start/Stop");
	private final JMenu mnHelp = new JMenu("Help");
	private final JMenuItem mntmSetting = new JMenuItem("Setting");
	private final JMenuItem mntmAbout = new JMenuItem("About");
	private final JMenuItem mntmHelp = new JMenuItem("Help");
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private final JLayeredPane layeredPaneStart = new JLayeredPane();
	private final JLayeredPane layeredPaneAchieveSensors = new JLayeredPane();
	private final JLayeredPane layeredPaneLiveData = new JLayeredPane();
	private final JScrollPane rightScrollPane = new JScrollPane();
	private final JList rightJlist = new JList();
	private SettingDialog myDialog;
	
	public UIApp(){
	    // set windows not resizable
		setResizable(false);
		setPreferredSize(new Dimension(500, 350));
		

		// close the window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// set title for the window
		setTitle("GUI App");
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.setBackground(Color.WHITE);
		
		setJMenuBar(menuBar);
		mnFile.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnFile.setHorizontalAlignment(SwingConstants.CENTER);
		
		menuBar.add(mnFile);
		mntmStartStop.setHorizontalAlignment(SwingConstants.CENTER);
		
		mnFile.add(mntmStartStop);
		mntmSetting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (myDialog == null) // first time
					myDialog = new SettingDialog(UIApp.this);
				myDialog.setVisible(true); // pop up dialog
			}
		});
		
		mnFile.add(mntmSetting);
		mnHelp.setFont(new Font("Segoe UI", Font.BOLD, 12));
		
		menuBar.add(mnHelp);
		
		mnHelp.add(mntmHelp);
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			    showAbout();
			}
		});
		
		mnHelp.add(mntmAbout);
		
	
		pack();// last in the code
		
		setLocationRelativeTo(null);
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(tabbedPane, BorderLayout.NORTH);
		layeredPaneStart.setToolTipText("Start");
		layeredPaneStart.setForeground(new Color(102, 204, 0));
		layeredPaneStart.setBackground(SystemColor.inactiveCaption);
		
		tabbedPane.addTab("Start", null, layeredPaneStart, null);
		tabbedPane.setBackgroundAt(0, SystemColor.inactiveCaption);
		tabbedPane.setForegroundAt(0, new Color(0, 0, 51));
		GridBagLayout gbl_layeredPaneStart = new GridBagLayout();
		gbl_layeredPaneStart.columnWidths = new int[] {390, 0};
		gbl_layeredPaneStart.rowHeights = new int[] {275, 0};
		gbl_layeredPaneStart.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_layeredPaneStart.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		layeredPaneStart.setLayout(gbl_layeredPaneStart);
		
		// Create a JSplitPane and set it as the main content pane
		contentPane = new JSplitPane();
		GridBagConstraints gbc_contentPane = new GridBagConstraints();
		gbc_contentPane.fill = GridBagConstraints.BOTH;
		gbc_contentPane.gridx = 0;
		gbc_contentPane.gridy = 0;
		layeredPaneStart.add(contentPane, gbc_contentPane);
		contentPane.setForeground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		// Create two panels and make them the left and right component of the main content pane:
		JPanel leftPanel = new JPanel();
		leftPanel.setBackground(SystemColor.activeCaption);
		contentPane.setLeftComponent(leftPanel);
		JPanel rightPanel = new JPanel();
		rightPanel.setBackground(SystemColor.activeCaption);
		contentPane.setRightComponent(rightPanel);
		GridBagLayout gbl_rightPanel = new GridBagLayout();
		gbl_rightPanel.columnWidths = new int[] {325};
		gbl_rightPanel.rowHeights = new int[] {252};
		gbl_rightPanel.columnWeights = new double[]{1.0};
		gbl_rightPanel.rowWeights = new double[]{1.0};
		rightPanel.setLayout(gbl_rightPanel);
		
		GridBagConstraints gbc_rightScrollPane = new GridBagConstraints();
		gbc_rightScrollPane.fill = GridBagConstraints.BOTH;
		gbc_rightScrollPane.gridx = 0;
		gbc_rightScrollPane.gridy = 0;
		rightPanel.add(rightScrollPane, gbc_rightScrollPane);
		rightJlist.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rightJlist.setBackground(SystemColor.activeCaption);
		
		rightScrollPane.setViewportView(rightJlist);
		GridBagLayout gbl_leftPanel = new GridBagLayout();
		gbl_leftPanel.columnWidths = new int[] {150};
		gbl_leftPanel.rowHeights = new int[] {252};
		gbl_leftPanel.columnWeights = new double[]{1.0};
		gbl_leftPanel.rowWeights = new double[]{0.0};
		leftPanel.setLayout(gbl_leftPanel);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		panel.setBackground(SystemColor.activeCaption);
		leftPanel.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {100};
		gbl_panel.rowHeights = new int[] {36, 108, 108};
		gbl_panel.columnWeights = new double[]{1.0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0};
		panel.setLayout(gbl_panel);
		
		GridBagConstraints gbc_comboBoxCOMPortMain = new GridBagConstraints();
		gbc_comboBoxCOMPortMain.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxCOMPortMain.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxCOMPortMain.gridx = 0;
		gbc_comboBoxCOMPortMain.gridy = 0;
		
		// set comboBox Font, color and add temporary data
		comboBoxCOMPortMain.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBoxCOMPortMain.setBackground(SystemColor.activeCaption);
		comboBoxCOMPortMain.setForeground(new Color(255, 0, 0));
		panel.add(comboBoxCOMPortMain, gbc_comboBoxCOMPortMain);
		comboBoxCOMPortMain.addItem("Select COM Port");
		comboBoxCOMPortMain.addItem("COM1");
		comboBoxCOMPortMain.addItem("COM2");
		
		GridBagConstraints gbc_btnStart = new GridBagConstraints();
		gbc_btnStart.fill = GridBagConstraints.BOTH;
		gbc_btnStart.insets = new Insets(0, 0, 5, 0);
		gbc_btnStart.gridx = 0;
		gbc_btnStart.gridy = 1;
		// set Font and color for the Start button
		btnStart.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel.add(btnStart, gbc_btnStart);
		btnStart.setBackground(new Color(0, 204, 255));
		btnStart.setForeground(new Color(0, 153, 0));
		
		GridBagConstraints gbc_btnWebsite = new GridBagConstraints();
		gbc_btnWebsite.fill = GridBagConstraints.BOTH;
		gbc_btnWebsite.gridx = 0;
		gbc_btnWebsite.gridy = 2;
		// set Font and color for the Web button
		btnWebsite.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel.add(btnWebsite, gbc_btnWebsite);
		btnWebsite.setBackground(new Color(0, 204, 255));
		btnWebsite.setForeground(new Color(0, 128, 128));
		layeredPaneAchieveSensors.setToolTipText("Achive Sensors");
		
		tabbedPane.addTab("Achieve Sensors", null, layeredPaneAchieveSensors, null);
		tabbedPane.setForegroundAt(1, new Color(0, 0, 51));
		layeredPaneLiveData.setToolTipText("Live Sensors");
		
		tabbedPane.addTab("Live Data", null, layeredPaneLiveData, null);
		tabbedPane.setForegroundAt(2, new Color(0, 0, 51));
	}
	
	
	/**
	 * show message with informations about the application
	 */
	public void showAbout() {
		JOptionPane.showMessageDialog(this, "UI App Version 1.4.",
				"UI App", JOptionPane.INFORMATION_MESSAGE);
	}
	
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		    UIApp frame = new UIApp();
		    frame.setVisible(true);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});

    }

}