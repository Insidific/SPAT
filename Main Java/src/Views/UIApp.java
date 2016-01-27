package Views;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Point;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.DefaultListModel;
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
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
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

import Controller.Sensored;
import Controller.SerialManager;
import Model.Data;

import java.awt.BorderLayout;
import java.io.IOException;
import java.net.URI;
import java.net.URL;

import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;

import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;

public class UIApp extends JFrame
{
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
    private final JTable tableLiveData;
    
    private final DefaultListModel defaultListModel = new DefaultListModel();
    private final DefaultTableModel defaultTableModel = new DefaultTableModel();
    
    private SettingDialog myDialog;

    public UIApp() {
	
	  JList rightJlistStartTab = new JList();
	  rightJlistStartTab.setModel(defaultListModel);
	  
	  
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
	gbl_layeredPaneStart.columnWidths = new int[] { 390, 0 };
	gbl_layeredPaneStart.rowHeights = new int[] { 275, 0 };
	gbl_layeredPaneStart.columnWeights = new double[] { 0.0,
		Double.MIN_VALUE };
	gbl_layeredPaneStart.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
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

	// Create two panels and make them the left and right component of the
	// main content pane:
	JPanel leftPanel = new JPanel();
	leftPanel.setBackground(SystemColor.activeCaption);
	contentPane.setLeftComponent(leftPanel);
	JPanel rightPanel = new JPanel();
	rightPanel.setBackground(SystemColor.activeCaption);
	contentPane.setRightComponent(rightPanel);
	GridBagLayout gbl_rightPanel = new GridBagLayout();
	gbl_rightPanel.columnWidths = new int[] { 325 };
	gbl_rightPanel.rowHeights = new int[] { 252 };
	gbl_rightPanel.columnWeights = new double[] { 1.0 };
	gbl_rightPanel.rowWeights = new double[] { 1.0 };
	rightPanel.setLayout(gbl_rightPanel);

	GridBagConstraints gbc_rightScrollPane = new GridBagConstraints();
	gbc_rightScrollPane.fill = GridBagConstraints.BOTH;
	gbc_rightScrollPane.gridx = 0;
	gbc_rightScrollPane.gridy = 0;
	rightPanel.add(rightScrollPane, gbc_rightScrollPane);
	rightJlistStartTab.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	rightJlistStartTab.setFont(new Font("Tahoma", Font.PLAIN, 12));
	rightJlistStartTab.setBackground(SystemColor.activeCaption);
//	rightJlistStartTab.setModel(defaultListModel);
	rightScrollPane.setViewportView(rightJlistStartTab);
	
	GridBagLayout gbl_leftPanel = new GridBagLayout();
	gbl_leftPanel.columnWidths = new int[] { 150 };
	gbl_leftPanel.rowHeights = new int[] { 252 };
	gbl_leftPanel.columnWeights = new double[] { 1.0 };
	gbl_leftPanel.rowWeights = new double[] { 0.0 };
	leftPanel.setLayout(gbl_leftPanel);
	GridBagConstraints gbc_panel = new GridBagConstraints();
	gbc_panel.insets = new Insets(0, 0, 5, 0);
	gbc_panel.gridx = 0;
	gbc_panel.gridy = 0;
	panel.setBackground(SystemColor.activeCaption);
	leftPanel.add(panel, gbc_panel);
	GridBagLayout gbl_panel = new GridBagLayout();
	gbl_panel.columnWidths = new int[] { 100 };
	gbl_panel.rowHeights = new int[] { 36, 108, 108 };
	gbl_panel.columnWeights = new double[] { 1.0 };
	gbl_panel.rowWeights = new double[] { 0.0, 0.0 };
	panel.setLayout(gbl_panel);

	GridBagConstraints gbc_comboBoxCOMPortMain = new GridBagConstraints();
	gbc_comboBoxCOMPortMain.insets = new Insets(0, 0, 5, 0);
	gbc_comboBoxCOMPortMain.fill = GridBagConstraints.HORIZONTAL;
	gbc_comboBoxCOMPortMain.gridx = 0;
	gbc_comboBoxCOMPortMain.gridy = 0;
	comboBoxCOMPortMain.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		String selected = (String) comboBoxCOMPortMain
			.getSelectedItem();
		System.out.println("User selected port: " + selected);
		if (selected != null)
		    Sensored.getSerialManager().setPort(selected);
		comboBoxCOMPortMain.setForeground(new Color(255, 0, 0));
	    }
	});

	// set comboBox Font, color and add temporary data
	comboBoxCOMPortMain.setFont(new Font("Tahoma", Font.BOLD, 14));
	comboBoxCOMPortMain.setBackground(SystemColor.activeCaption);
	comboBoxCOMPortMain.setForeground(new Color(255, 0, 0));
	panel.add(comboBoxCOMPortMain, gbc_comboBoxCOMPortMain);
	comboBoxCOMPortMain.addItem("Select COM Port");
	comboBoxCOMPortMain.addPopupMenuListener(new PopupMenuListener() {
	    public void popupMenuCanceled(PopupMenuEvent arg0) {
	    }

	    public void popupMenuWillBecomeInvisible(PopupMenuEvent arg0) {
	    }

	    public void popupMenuWillBecomeVisible(PopupMenuEvent arg0) {
		System.out.println("Ports Available: ");
		System.out.println(SerialManager.listPorts());
		comboBoxCOMPortMain.removeAllItems();
		for (String port : SerialManager.listPorts()) {
		    comboBoxCOMPortMain.addItem(port);
		}
		comboBoxCOMPortMain.setForeground(new Color(255, 0, 0));
	    }
	});

	GridBagConstraints gbc_btnStart = new GridBagConstraints();
	gbc_btnStart.fill = GridBagConstraints.BOTH;
	gbc_btnStart.insets = new Insets(0, 0, 5, 0);
	gbc_btnStart.gridx = 0;
	gbc_btnStart.gridy = 1;
	// set Font and color for the Start button
	btnStart.setFont(new Font("Tahoma", Font.BOLD, 17));
	panel.add(btnStart, gbc_btnStart);
	btnStart.setBackground(new Color(135, 206, 235));
	btnStart.setForeground(new Color(0, 153, 0));

	btnStart.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		if (Sensored.isDataSessionRunning()) {
		    Sensored.stopDataSession();
		    btnStart.setText("Start");
		} else {
		    Sensored.startDataSession();
		    btnStart.setText("Stop");
		}

	    }
	});

	GridBagConstraints gbc_btnWebsite = new GridBagConstraints();
	gbc_btnWebsite.fill = GridBagConstraints.BOTH;
	gbc_btnWebsite.gridx = 0;
	gbc_btnWebsite.gridy = 2;
	btnWebsite.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {

		// check if java.awt.Desktop is available on the current
		// platform
		java.awt.Desktop.isDesktopSupported();

		System.out.println(java.awt.Desktop.isDesktopSupported());

		// check the current platform and security policy will let you
		// browse to a url
		Desktop desktop = java.awt.Desktop.getDesktop();

		// check if desktop is supported and  browser .
		String osName = System.getProperty("os.name");
		System.out.println(osName);
		String url = "http://www.google.com";
		if (desktop.isDesktopSupported() == true && desktop.isSupported(Desktop.Action.BROWSE) == true){
		try {
		    if (osName.startsWith("Windows")) {
			Runtime.getRuntime().exec(
				"rundll32 url.dll,FileProtocolHandler " + url);
		    } else {
			// for other systems`
		    }

		} catch (Exception e) {
		    JOptionPane.showMessageDialog(
			    null,
			    "Error in opening browser" + ":\n"
				    + e.getLocalizedMessage());
		}
		
	    }

	    }

	});
	// set Font and color for the Web button
	btnWebsite.setFont(new Font("Tahoma", Font.BOLD, 17));
	panel.add(btnWebsite, gbc_btnWebsite);
	btnWebsite.setBackground(new Color(135, 206, 235));
	btnWebsite.setForeground(new Color(0, 128, 128));
	layeredPaneAchieveSensors.setBackground(SystemColor.inactiveCaption);
	layeredPaneAchieveSensors.setToolTipText("Active Sensors");

	tabbedPane.addTab("Active Sensors", null, layeredPaneAchieveSensors,
		null);
	GridBagLayout gbl_layeredPaneAchieveSensors = new GridBagLayout();
	gbl_layeredPaneAchieveSensors.columnWidths = new int[] {480};
	gbl_layeredPaneAchieveSensors.rowHeights = new int[] {275};
	gbl_layeredPaneAchieveSensors.columnWeights = new double[]{1.0};
	gbl_layeredPaneAchieveSensors.rowWeights = new double[]{1.0, 1.0};
	layeredPaneAchieveSensors.setLayout(gbl_layeredPaneAchieveSensors);
	
	JScrollPane scrollPaneActiveSensors = new JScrollPane();
	scrollPaneActiveSensors.setVisible(true);
	scrollPaneActiveSensors.setSize(400, 300);
	scrollPaneActiveSensors.setBackground(new Color(135, 206, 235));
	    String categories[] = { "Household", "Office", "Extended Family",
		        "Company (US)", "Company (World)", "Team", "Will",
		        "Birthday Card List", "High School", "Country", "Continent",
		        "Planet" };
	    JList listLiveData = new JList(categories);
	    listLiveData.setVisibleRowCount(11);
	    listLiveData.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    listLiveData.setEnabled(false);
	    listLiveData.setModel(new AbstractListModel() {
	    	String[] values = new String[] {};
	    	public int getSize() {
	    		return values.length;
	    	}
	    	public Object getElementAt(int index) {
	    		return values[index];
	    	}
	    });
	    listLiveData.setBackground(new Color(135, 206, 235));
	    listLiveData.setSize(400, 400);
	    scrollPaneActiveSensors = new JScrollPane(listLiveData);    
	    
	
	
	GridBagConstraints gbc_scrollPaneActiveSensors = new GridBagConstraints();
	gbc_scrollPaneActiveSensors.gridheight = 2;
	gbc_scrollPaneActiveSensors.gridx = 0;
	gbc_scrollPaneActiveSensors.gridy = 0;
	layeredPaneAchieveSensors.add(scrollPaneActiveSensors, gbc_scrollPaneActiveSensors);
	tabbedPane.setForegroundAt(1, new Color(0, 0, 51));
	layeredPaneLiveData.setBackground(SystemColor.inactiveCaption);
	layeredPaneLiveData.setToolTipText("Live Sensors");

	tabbedPane.addTab("Live Data", null, layeredPaneLiveData, null);
	GridBagLayout gbl_layeredPaneLiveData = new GridBagLayout();
	gbl_layeredPaneLiveData.columnWidths = new int[] {480};
	gbl_layeredPaneLiveData.rowHeights = new int[] { 275 };
	gbl_layeredPaneLiveData.columnWeights = new double[] { 1.0 };
	gbl_layeredPaneLiveData.rowWeights = new double[] { 1.0 };
	layeredPaneLiveData.setLayout(gbl_layeredPaneLiveData);

	GridBagConstraints gbc_tableLiveData = new GridBagConstraints();
	gbc_tableLiveData.insets = new Insets(0, 0, 0, 5);
	gbc_tableLiveData.fill = GridBagConstraints.BOTH;
	gbc_tableLiveData.gridx = 0;
	gbc_tableLiveData.gridy = 0;

//	// add data to the header of the table
//	Object headers[] = { "ID", "Name", "Last reading", "Time stamp" };
//
//	// add actual data to the table
//	Object[][] data = {
//		{ "Mary", "Campione", "Snowboarding", new Integer(5) },
//		{ "Alison", "Huml", "Rowing", new Integer(3) },
//		{ "Kathy", "Walrath", "Knitting", new Integer(2) },
//		{ "Sharon", "Zakhour", "Speed reading", 20 },
//		{ "Sharon", "Zakhour", "Speed reading", new Integer(20) },
//		{ "Sharon", "Zakhour", "Speed reading", new Integer(20) },
//		{ "Sharon", "Zakhour", "Speed reading", new Integer(20) },
//		{ "Sharon", "Zakhour", "Speed reading", new Integer(20) },
//		{ "Sharon", "Zakhour", "Speed reading", new Integer(20) },
//		{ "Sharon", "Zakhour", "Speed reading", new Integer(20) },
//		{ "Sharon", "Zakhour", "Speed reading", new Integer(20) },
//		{ "Sharon", "Zakhour", "Speed reading", new Integer(20) },
//		{ "Sharon", "Zakhour", "Speed reading", new Integer(20) },
//		{ "Sharon", "Zakhour", "Speed reading", new Integer(20) },
//		{ "Sharon", "Zakhour", "Speed reading", new Integer(20) },
//		{ "Sharon", "Zakhour", "Speed reading", new Integer(20) },
//		{ "Sharon", "Zakhour", "Speed reading", new Integer(20) },
//		{ "Philip", "Milne", "Pool", new Integer(10) } };

	tableLiveData = new JTable(defaultTableModel);
	// set default column names
	defaultTableModel.setColumnIdentifiers(new Object[] { "ID", "Name", "Last reading", "Time stamp" });
	tableLiveData.setEnabled(false);
	tableLiveData.setForeground(new Color(0, 102, 153));
	tableLiveData.setFont(new Font("Tahoma", Font.BOLD, 12));
	tableLiveData.setBackground(SystemColor.activeCaption);
	layeredPaneLiveData.add(tableLiveData, gbc_tableLiveData);
	tabbedPane.setForegroundAt(2, new Color(0, 0, 51));
	// set size of the Scrollable Viewport
	tableLiveData
		.setPreferredScrollableViewportSize(new Dimension(460, 250));
	tableLiveData.setFillsViewportHeight(true);

	// set Table header color and set Font
	JTableHeader header = tableLiveData.getTableHeader();
	header.setFont(new Font("Tahoma", Font.BOLD, 12));
	header.setBackground(Color.black);
	header.setForeground(Color.yellow);
	// add JScrollPane to panel and add JTable to JScrollPane
	JScrollPane scrollPane = new JScrollPane(tableLiveData);
	scrollPane.setVisible(true);
	layeredPaneLiveData.add(scrollPane);
	

    }

    /**
     * show message with informations about the application
     */
    public void showAbout() {
	JOptionPane.showMessageDialog(this, "UI App Version 1.4.", "UI App",
		JOptionPane.INFORMATION_MESSAGE);
    }

    // public static void main(String[] args) {
    // EventQueue.invokeLater(new Runnable() {
    // public void run() {
    // try {
    // UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    // UIApp frame = new UIApp();
    // frame.setVisible(true);
    // } catch (Exception e) {
    // e.printStackTrace();
    // }
    // }
    // });
    //
    // }

    public void newRawData(String string){
	// add data to the list in Start Tab
	defaultListModel.addElement(string);
    }
    

    
    public void newParsedData(Data data){
	// add data to the table in Live Data Tab
	int id = data.getSensor().getSensorID();
	String name = data.getSensor().getName();
	double lastReading = data.getData();
	String timeStamp = data.getTimeStamp().format(DateTimeFormatter.ofPattern("dd/MM/yy HH:mm:ss"));
	defaultTableModel.addRow(new Object[]{id, name, lastReading, timeStamp});
    }
}