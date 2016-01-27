package Views;

/**
 * Class that contains dialog where you set data.
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortList;
import Controller.Sensored;
import Controller.SerialManager;
import javax.swing.event.PopupMenuListener;
import javax.swing.event.PopupMenuEvent;
import javax.swing.DefaultComboBoxModel;

//import library.ReaderWriter;
//import library.BookStorage;

public class SettingDialog extends JDialog implements SerialPortEventListener {
    JTextField textFieldDBIP, textFieldUsername, textFieldDBPort,
	    textFieldDBName;
    JLabel lblDBIP, lblDBPort, lblUsername, lblPassword, lblDBName;
    JComboBox selectComPortComboBox = new JComboBox();
    private JLabel lblPortSpeed;
    private JTextField textFieldPortSpeed;
    private JTextField textFieldPortDataBits;
    private JLabel lblPortdatabits;
    private JLabel lblPortstopbits;
    private JLabel lblPortParity;
    private JTextField textFieldPortStopBits;
    private JTextField textFieldParitynone;
    private JPasswordField passwordField;
    private JMenuItem mntmOpen;
    private JButton btnCheckArduinoConnection;
    private JButton btnCheckDatabaseConnection;
    private JLabel lblStatus;
    private JLabel lblStatus_1;
    private JTextField textFieldArduinoStatus;
    private JTextField textFieldDBStatus;

    private String stringPort;
    private String stringFieldPortSpeed;
    private String stringFieldPortDataBits;
    private String stringFieldPortStopBits;
    private String stringTextFieldParitynone;
    private String stringTextFieldDBIP;
    private String stringTextFieldUsername;
    private String stringpasswordField;
    private String stringTextFieldDBName;
    private JLabel lblSelectComPort;

    /**
     * shows the Message dialog
     */
    public void showAbout() {
	JOptionPane.showMessageDialog(this, "Settings App Version 1.4.",
		"About Settings App", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * @param owner
     *            is the Main Window
     * @param mainListEmpty
     *            is true or false if the list from the Main Window have some
     *            items or not
     */
    public SettingDialog(JFrame owner) {
	super(owner, "Setting for the HW connection", true);
	setTitle("Setting");
	setPreferredSize(new Dimension(500, 350));
	setSize(500, 350);
	setLocationRelativeTo(null);

	// stringPort = selectComPortComboBox.getSelectedItem().toString();
	// stringFieldPortSpeed = textFieldPortSpeed.getText();
	// stringFieldPortDataBits = textFieldPortDataBits.getText();
	// stringFieldPortStopBits = textFieldPortStopBits.getText();
	// stringTextFieldParitynone = textFieldParitynone.getText();
	// stringTextFieldDBIP = textFieldDBIP.getText();
	// stringTextFieldUsername = textFieldUsername.getText();
	// stringpasswordField = passwordField.getText();
	// stringTextFieldDBName = textFieldDBName.getText();

	lblDBIP = new JLabel("DB IP");
	lblDBIP.setFont(new Font("Arial", Font.PLAIN, 14));

	lblDBPort = new JLabel("DB Port");
	lblDBPort.setFont(new Font("Arial", Font.PLAIN, 14));

	lblUsername = new JLabel("Username");
	lblUsername.setFont(new Font("Arial", Font.PLAIN, 14));

	lblPassword = new JLabel("Password");
	lblPassword.setFont(new Font("Arial", Font.PLAIN, 14));

	lblDBName = new JLabel("DB Name");
	lblDBName.setFont(new Font("Arial", Font.PLAIN, 14));

	// publication date
	textFieldDBIP = new JTextField();
	textFieldDBIP.addFocusListener(new FocusAdapter() {
	    @Override
	    public void focusGained(FocusEvent e) {
		textFieldDBIP.setBackground(Color.ORANGE);
	    }

	    @Override
	    public void focusLost(FocusEvent e) {
		textFieldDBIP.setBackground(new Color(255, 255, 153));
	    }
	});
	textFieldDBIP.setBackground(new Color(255, 255, 153));
	textFieldDBIP.setFont(new Font("Arial", Font.PLAIN, 12));

	// pages
	textFieldDBPort = new JTextField();
	textFieldDBPort.addFocusListener(new FocusAdapter() {
	    @Override
	    public void focusGained(FocusEvent e) {
		textFieldDBPort.setBackground(Color.ORANGE);
	    }

	    @Override
	    public void focusLost(FocusEvent e) {
		textFieldDBPort.setBackground(new Color(255, 255, 153));
	    }
	});
	textFieldDBPort.setBackground(new Color(255, 255, 153));
	textFieldDBPort.setFont(new Font("Arial", Font.PLAIN, 12));

	// retail price
	textFieldUsername = new JTextField();
	textFieldUsername.addFocusListener(new FocusAdapter() {
	    @Override
	    public void focusGained(FocusEvent e) {
		textFieldUsername.setBackground(Color.ORANGE);
	    }

	    @Override
	    public void focusLost(FocusEvent e) {
		textFieldUsername.setBackground(new Color(255, 255, 153));
	    }
	});
	textFieldUsername.setBackground(new Color(255, 255, 153));
	textFieldUsername.setFont(new Font("Arial", Font.PLAIN, 12));

	// bookType

	textFieldDBName = new JTextField();
	textFieldDBName.addFocusListener(new FocusAdapter() {
	    @Override
	    public void focusGained(FocusEvent arg0) {
		textFieldDBName.setBackground(Color.ORANGE);
	    }

	    @Override
	    public void focusLost(FocusEvent e) {
		textFieldDBName.setBackground(new Color(255, 255, 153));
	    }
	});
	textFieldDBName.setBackground(new Color(255, 255, 153));
	textFieldDBName.setFont(new Font("Arial", Font.PLAIN, 12));

	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
	getContentPane().add(tabbedPane, BorderLayout.CENTER);

	JLayeredPane layeredPaneSettings = new JLayeredPane();
	layeredPaneSettings.setBackground(SystemColor.activeCaption);
	tabbedPane.addTab("Settings", null, layeredPaneSettings, null);
	tabbedPane.setForegroundAt(0, new Color(0, 102, 153));
	tabbedPane.setEnabledAt(0, true);
	GridBagLayout gbl_layeredPaneSettings = new GridBagLayout();
	gbl_layeredPaneSettings.columnWidths = new int[] { 200, 200 };
	gbl_layeredPaneSettings.rowHeights = new int[] { 110, 100 };
	gbl_layeredPaneSettings.columnWeights = new double[] { 1.0, 1.0 };
	gbl_layeredPaneSettings.rowWeights = new double[] { 1.0, 1.0 };
	layeredPaneSettings.setLayout(gbl_layeredPaneSettings);

	JPanel leftPanelTop = new JPanel();
	leftPanelTop.setBackground(SystemColor.text);
	GridBagConstraints gbc_leftPanelTop = new GridBagConstraints();
	gbc_leftPanelTop.fill = GridBagConstraints.BOTH;
	gbc_leftPanelTop.insets = new Insets(0, 0, 2, 0);
	gbc_leftPanelTop.gridx = 0;
	gbc_leftPanelTop.gridy = 0;
	layeredPaneSettings.add(leftPanelTop, gbc_leftPanelTop);
	leftPanelTop.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 3));

	JPanel rightPanelTop = new JPanel();
	FlowLayout flowLayout = (FlowLayout) rightPanelTop.getLayout();
	flowLayout.setAlignment(FlowLayout.LEFT);
	flowLayout.setVgap(3);
	flowLayout.setHgap(3);
	rightPanelTop.setBackground(SystemColor.text);
	GridBagConstraints gbc_rightPanelTop = new GridBagConstraints();
	gbc_rightPanelTop.insets = new Insets(0, 0, 2, 0);
	gbc_rightPanelTop.fill = GridBagConstraints.BOTH;
	gbc_rightPanelTop.gridx = 1;
	gbc_rightPanelTop.gridy = 0;
	layeredPaneSettings.add(rightPanelTop, gbc_rightPanelTop);
	
		// add button that add books to the library
		JButton btnAcceptAll = new JButton("Accept All");
		rightPanelTop.add(btnAcceptAll);
		btnAcceptAll.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent arg0) {
			saveToFile(selectComPortComboBox.getSelectedItem().toString(),
				textFieldPortSpeed.getText(),
				textFieldPortDataBits.getText(),
				textFieldPortStopBits.getText(),
				textFieldParitynone.getText(), textFieldDBIP.getText(),
				textFieldUsername.getText(), passwordField.getText(),
				textFieldDBName.getText());

		    }
		});
		btnAcceptAll.setFont(new Font("Tahoma", Font.BOLD, 11));
		
			btnAcceptAll.setBackground(new Color(135, 206, 235));
			btnAcceptAll.setForeground(new Color(0, 153, 0));

	JPanel LeftPanel = new JPanel();
	LeftPanel.setBackground(SystemColor.activeCaption);
	GridBagConstraints gbc_LeftPanel = new GridBagConstraints();
	gbc_LeftPanel.insets = new Insets(0, 0, 5, 5);
	gbc_LeftPanel.fill = GridBagConstraints.BOTH;
	gbc_LeftPanel.gridx = 0;
	gbc_LeftPanel.gridy = 1;
	layeredPaneSettings.add(LeftPanel, gbc_LeftPanel);
	GridBagLayout gbl_LeftPanel = new GridBagLayout();
	gbl_LeftPanel.columnWidths = new int[] { 50, 140 };
	gbl_LeftPanel.rowHeights = new int[] { 30, 30, 30, 30, 30, 30, 30, 30,
		30, 30 };
	gbl_LeftPanel.columnWeights = new double[] { 1.0, 1.0 };
	gbl_LeftPanel.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
	LeftPanel.setLayout(gbl_LeftPanel);

	lblPortSpeed = new JLabel("Port Speed");
	lblPortSpeed.setFont(new Font("Arial", Font.PLAIN, 14));
	GridBagConstraints gbc_lblPortSpeed = new GridBagConstraints();
	gbc_lblPortSpeed.anchor = GridBagConstraints.EAST;
	gbc_lblPortSpeed.insets = new Insets(0, 0, 5, 5);
	gbc_lblPortSpeed.gridx = 0;
	gbc_lblPortSpeed.gridy = 2;
	LeftPanel.add(lblPortSpeed, gbc_lblPortSpeed);

	textFieldPortSpeed = new JTextField();
	textFieldPortSpeed.setText("115200");
	textFieldPortSpeed.setFont(new Font("Arial", Font.PLAIN, 12));
	textFieldPortSpeed.setColumns(10);
	textFieldPortSpeed.setBackground(new Color(255, 255, 153));
	GridBagConstraints gbc_textFieldPortSpeed = new GridBagConstraints();
	gbc_textFieldPortSpeed.fill = GridBagConstraints.HORIZONTAL;
	gbc_textFieldPortSpeed.insets = new Insets(0, 0, 5, 0);
	gbc_textFieldPortSpeed.gridx = 1;
	gbc_textFieldPortSpeed.gridy = 2;
	LeftPanel.add(textFieldPortSpeed, gbc_textFieldPortSpeed);

	lblPortdatabits = new JLabel("Port Data Bits");
	lblPortdatabits.setFont(new Font("Arial", Font.PLAIN, 14));
	GridBagConstraints gbc_lblPortdatabits = new GridBagConstraints();
	gbc_lblPortdatabits.insets = new Insets(0, 0, 5, 5);
	gbc_lblPortdatabits.anchor = GridBagConstraints.EAST;
	gbc_lblPortdatabits.gridx = 0;
	gbc_lblPortdatabits.gridy = 3;
	LeftPanel.add(lblPortdatabits, gbc_lblPortdatabits);

	textFieldPortDataBits = new JTextField();
	textFieldPortDataBits.addFocusListener(new FocusAdapter() {
	    @Override
	    public void focusGained(FocusEvent e) {
		textFieldPortDataBits.setBackground(Color.ORANGE);
	    }

	    @Override
	    public void focusLost(FocusEvent e) {
		textFieldPortDataBits.setBackground(new Color(255, 255, 153));
	    }
	});
	textFieldPortDataBits.setText("8");
	textFieldPortDataBits.setFont(new Font("Arial", Font.PLAIN, 12));
	textFieldPortDataBits.setColumns(10);
	textFieldPortDataBits.setBackground(new Color(255, 255, 153));
	GridBagConstraints gbc_textFieldPortDataBits = new GridBagConstraints();
	gbc_textFieldPortDataBits.insets = new Insets(0, 0, 5, 0);
	gbc_textFieldPortDataBits.fill = GridBagConstraints.HORIZONTAL;
	gbc_textFieldPortDataBits.gridx = 1;
	gbc_textFieldPortDataBits.gridy = 3;
	LeftPanel.add(textFieldPortDataBits, gbc_textFieldPortDataBits);

	lblPortstopbits = new JLabel("Port Stop Bits");
	lblPortstopbits.setFont(new Font("Arial", Font.PLAIN, 14));
	GridBagConstraints gbc_lblPortstopbits = new GridBagConstraints();
	gbc_lblPortstopbits.anchor = GridBagConstraints.EAST;
	gbc_lblPortstopbits.insets = new Insets(0, 0, 5, 5);
	gbc_lblPortstopbits.gridx = 0;
	gbc_lblPortstopbits.gridy = 4;
	LeftPanel.add(lblPortstopbits, gbc_lblPortstopbits);

	textFieldPortStopBits = new JTextField();
	textFieldPortStopBits.addFocusListener(new FocusAdapter() {
	    @Override
	    public void focusGained(FocusEvent e) {
		textFieldPortStopBits.setBackground(Color.ORANGE);
	    }

	    @Override
	    public void focusLost(FocusEvent e) {
		textFieldPortStopBits.setBackground(new Color(255, 255, 153));
	    }
	});
	textFieldPortStopBits.setText("1");
	textFieldPortStopBits.setFont(new Font("Arial", Font.PLAIN, 12));
	textFieldPortStopBits.setColumns(10);
	textFieldPortStopBits.setBackground(new Color(255, 255, 153));
	GridBagConstraints gbc_textFieldPortStopBits = new GridBagConstraints();
	gbc_textFieldPortStopBits.insets = new Insets(0, 0, 5, 0);
	gbc_textFieldPortStopBits.fill = GridBagConstraints.HORIZONTAL;
	gbc_textFieldPortStopBits.gridx = 1;
	gbc_textFieldPortStopBits.gridy = 4;
	LeftPanel.add(textFieldPortStopBits, gbc_textFieldPortStopBits);

	lblPortParity = new JLabel("Port Parity");
	lblPortParity.setFont(new Font("Arial", Font.PLAIN, 14));
	GridBagConstraints gbc_lblPortParity = new GridBagConstraints();
	gbc_lblPortParity.anchor = GridBagConstraints.EAST;
	gbc_lblPortParity.insets = new Insets(0, 0, 5, 5);
	gbc_lblPortParity.gridx = 0;
	gbc_lblPortParity.gridy = 5;
	LeftPanel.add(lblPortParity, gbc_lblPortParity);

	textFieldParitynone = new JTextField();
	textFieldParitynone.addFocusListener(new FocusAdapter() {
	    @Override
	    public void focusGained(FocusEvent e) {
		textFieldParitynone.setBackground(Color.ORANGE);
	    }

	    @Override
	    public void focusLost(FocusEvent e) {
		textFieldParitynone.setBackground(new Color(255, 255, 153));

	    }
	});
	textFieldParitynone.setText("PARITY_NONE");
	textFieldParitynone.setFont(new Font("Arial", Font.PLAIN, 12));
	textFieldParitynone.setColumns(10);
	textFieldParitynone.setBackground(new Color(255, 255, 153));
	GridBagConstraints gbc_textFieldParitynone = new GridBagConstraints();
	gbc_textFieldParitynone.insets = new Insets(0, 0, 5, 0);
	gbc_textFieldParitynone.fill = GridBagConstraints.HORIZONTAL;
	gbc_textFieldParitynone.gridx = 1;
	gbc_textFieldParitynone.gridy = 5;
	LeftPanel.add(textFieldParitynone, gbc_textFieldParitynone);
	GridBagConstraints gbc_selectComPortComboBox = new GridBagConstraints();
	gbc_selectComPortComboBox.insets = new Insets(0, 0, 5, 0);
	gbc_selectComPortComboBox.gridx = 1;
	gbc_selectComPortComboBox.gridy = 6;
	selectComPortComboBox.setModel(new DefaultComboBoxModel(new String[] {"Select COM Port"}));
	selectComPortComboBox.addPopupMenuListener(new PopupMenuListener() {
		public void popupMenuCanceled(PopupMenuEvent arg0) {
		}
		public void popupMenuWillBecomeInvisible(PopupMenuEvent arg0) {
		}
		public void popupMenuWillBecomeVisible(PopupMenuEvent arg0) {
		    System.out.println("Ports Available: ");
		    System.out.println(SerialManager.listPorts());
		    selectComPortComboBox.removeAllItems();
		    for(String port: SerialManager.listPorts())
		    {
			selectComPortComboBox.addItem(port);
		    }
    		}
    	});
	selectComPortComboBox.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
	    }
	});
	
	lblSelectComPort = new JLabel("Select COM Port");
	lblSelectComPort.setFont(new Font("Arial", Font.PLAIN, 14));
	GridBagConstraints gbc_lblSelectComPort = new GridBagConstraints();
	gbc_lblSelectComPort.insets = new Insets(0, 0, 5, 5);
	gbc_lblSelectComPort.anchor = GridBagConstraints.EAST;
	gbc_lblSelectComPort.gridx = 0;
	gbc_lblSelectComPort.gridy = 6;
	LeftPanel.add(lblSelectComPort, gbc_lblSelectComPort);
	LeftPanel.add(selectComPortComboBox, gbc_selectComPortComboBox);
	selectComPortComboBox.setFont(new Font("Tahoma", Font.BOLD, 12));

	selectComPortComboBox.setForeground(Color.RED);
	selectComPortComboBox.setBackground(SystemColor.activeCaption);
	
	// selectComPortComboBox.addItem("Select COM Port");
	// selectComPortComboBox.addItem("COM1");
	// selectComPortComboBox.addItem("COM2");

	btnCheckArduinoConnection = new JButton("Check Arduino Connection");
	btnCheckArduinoConnection.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {
		stringPort = selectComPortComboBox.getSelectedItem().toString();
		stringFieldPortSpeed = textFieldPortSpeed.getText();
		stringFieldPortDataBits = textFieldPortDataBits.getText();
		stringFieldPortStopBits = textFieldPortStopBits.getText();
		stringTextFieldParitynone = textFieldParitynone.getText();

		// parseWithDefault(String number, int defaultVal)

		if (stringPort.isEmpty() || stringPort.startsWith("Select")
			|| stringTextFieldParitynone.isEmpty()
			|| stringFieldPortSpeed.isEmpty()
			|| stringFieldPortDataBits.isEmpty()
			|| stringFieldPortStopBits.isEmpty()
			|| stringTextFieldParitynone.isEmpty()

		) {

		} else {
		    // if is everything ok
		    int intTextFieldParitynone = parseWithDefault(
			    stringTextFieldParitynone, 0);
		    int intFieldPortSpeed = parseWithDefault(
			    stringFieldPortSpeed, 0);
		    int intFieldPortDataBits = parseWithDefault(
			    stringFieldPortDataBits, 0);
		    int intFieldPortStopBits = parseWithDefault(
			    stringFieldPortStopBits, 0);

		}

	    }
	});
	btnCheckArduinoConnection.setForeground(new Color(0, 153, 0));
	btnCheckArduinoConnection.setFont(new Font("Tahoma", Font.PLAIN, 9));
	btnCheckArduinoConnection.setBackground(new Color(135, 206, 235));
	GridBagConstraints gbc_btnCheckArduinoConnection = new GridBagConstraints();
	gbc_btnCheckArduinoConnection.insets = new Insets(0, 0, 5, 0);
	gbc_btnCheckArduinoConnection.gridx = 1;
	gbc_btnCheckArduinoConnection.gridy = 7;
	LeftPanel.add(btnCheckArduinoConnection, gbc_btnCheckArduinoConnection);

	lblStatus = new JLabel("Status:");
	lblStatus.setFont(new Font("Arial", Font.PLAIN, 14));
	GridBagConstraints gbc_lblStatus = new GridBagConstraints();
	gbc_lblStatus.anchor = GridBagConstraints.EAST;
	gbc_lblStatus.insets = new Insets(0, 0, 5, 5);
	gbc_lblStatus.gridx = 0;
	gbc_lblStatus.gridy = 8;
	LeftPanel.add(lblStatus, gbc_lblStatus);

	textFieldArduinoStatus = new JTextField();
	textFieldArduinoStatus.setEditable(false);
	textFieldArduinoStatus.setFont(new Font("Arial", Font.PLAIN, 12));
	textFieldArduinoStatus.setColumns(10);
	textFieldArduinoStatus.setBackground(new Color(255, 255, 153));
	GridBagConstraints gbc_textFieldArduinoStatus = new GridBagConstraints();
	gbc_textFieldArduinoStatus.insets = new Insets(0, 0, 5, 0);
	gbc_textFieldArduinoStatus.fill = GridBagConstraints.HORIZONTAL;
	gbc_textFieldArduinoStatus.gridx = 1;
	gbc_textFieldArduinoStatus.gridy = 8;
	LeftPanel.add(textFieldArduinoStatus, gbc_textFieldArduinoStatus);

	JPanel rightPanel = new JPanel();
	rightPanel.setBackground(SystemColor.activeCaption);
	GridBagConstraints gbc_rightPanel = new GridBagConstraints();
	gbc_rightPanel.insets = new Insets(0, 0, 5, 0);
	gbc_rightPanel.fill = GridBagConstraints.BOTH;
	gbc_rightPanel.gridx = 1;
	gbc_rightPanel.gridy = 1;
	layeredPaneSettings.add(rightPanel, gbc_rightPanel);
	GridBagLayout gbl_rightPanel = new GridBagLayout();
	gbl_rightPanel.columnWidths = new int[] { 50, 140 };
	gbl_rightPanel.rowHeights = new int[] { 30, 30, 30, 30, 30, 30, 30, 30,
		30, 30 };
	gbl_rightPanel.columnWeights = new double[] { 0.0, 1.0 };
	gbl_rightPanel.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
	rightPanel.setLayout(gbl_rightPanel);

	GridBagConstraints gbc_lblDBIP = new GridBagConstraints();
	gbc_lblDBIP.anchor = GridBagConstraints.EAST;
	gbc_lblDBIP.insets = new Insets(0, 0, 5, 5);
	gbc_lblDBIP.gridx = 0;
	gbc_lblDBIP.gridy = 1;
	rightPanel.add(lblDBIP, gbc_lblDBIP);

	GridBagConstraints gbc_lblDBPort = new GridBagConstraints();
	gbc_lblDBPort.anchor = GridBagConstraints.EAST;
	gbc_lblDBPort.insets = new Insets(0, 0, 5, 5);
	gbc_lblDBPort.gridx = 0;
	gbc_lblDBPort.gridy = 2;
	rightPanel.add(lblDBPort, gbc_lblDBPort);

	GridBagConstraints gbc_lblUsername = new GridBagConstraints();
	gbc_lblUsername.anchor = GridBagConstraints.EAST;
	gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
	gbc_lblUsername.gridx = 0;
	gbc_lblUsername.gridy = 3;
	rightPanel.add(lblUsername, gbc_lblUsername);

	GridBagConstraints gbc_lblPassword = new GridBagConstraints();
	gbc_lblPassword.anchor = GridBagConstraints.EAST;
	gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
	gbc_lblPassword.gridx = 0;
	gbc_lblPassword.gridy = 4;
	rightPanel.add(lblPassword, gbc_lblPassword);

	GridBagConstraints gbc_lblDBName = new GridBagConstraints();
	gbc_lblDBName.anchor = GridBagConstraints.EAST;
	gbc_lblDBName.insets = new Insets(0, 0, 5, 5);
	gbc_lblDBName.gridx = 0;
	gbc_lblDBName.gridy = 5;
	rightPanel.add(lblDBName, gbc_lblDBName);

	GridBagConstraints gbc_textFieldDBIP = new GridBagConstraints();
	gbc_textFieldDBIP.insets = new Insets(0, 0, 5, 0);
	gbc_textFieldDBIP.fill = GridBagConstraints.HORIZONTAL;
	gbc_textFieldDBIP.gridx = 1;
	gbc_textFieldDBIP.gridy = 1;
	rightPanel.add(textFieldDBIP, gbc_textFieldDBIP);
	textFieldDBIP.setColumns(10);

	GridBagConstraints gbc_textFieldDBPort = new GridBagConstraints();
	gbc_textFieldDBPort.insets = new Insets(0, 0, 5, 0);
	gbc_textFieldDBPort.fill = GridBagConstraints.HORIZONTAL;
	gbc_textFieldDBPort.gridx = 1;
	gbc_textFieldDBPort.gridy = 2;
	rightPanel.add(textFieldDBPort, gbc_textFieldDBPort);
	textFieldDBPort.setColumns(10);

	GridBagConstraints gbc_textFieldUsername = new GridBagConstraints();
	gbc_textFieldUsername.insets = new Insets(0, 0, 5, 0);
	gbc_textFieldUsername.fill = GridBagConstraints.HORIZONTAL;
	gbc_textFieldUsername.gridx = 1;
	gbc_textFieldUsername.gridy = 3;
	rightPanel.add(textFieldUsername, gbc_textFieldUsername);
	textFieldUsername.setColumns(10);

	GridBagConstraints gbc_textFieldDBName = new GridBagConstraints();
	gbc_textFieldDBName.insets = new Insets(0, 0, 5, 0);
	gbc_textFieldDBName.fill = GridBagConstraints.HORIZONTAL;
	gbc_textFieldDBName.gridx = 1;
	gbc_textFieldDBName.gridy = 5;
	rightPanel.add(textFieldDBName, gbc_textFieldDBName);

	JMenuBar menuBar = new JMenuBar();
	menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	setJMenuBar(menuBar);

	JMenu mnFile = new JMenu("File");
	mnFile.setFont(new Font("Segoe UI", Font.BOLD, 12));
	menuBar.add(mnFile);

	mntmOpen = new JMenuItem("Open");
	mnFile.add(mntmOpen);

	// save file from the menu
	JMenuItem mntmSave = new JMenuItem("Save");
	mntmSave.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		// pagesTextField.getText();
		selectComPortComboBox.getSelectedItem().toString();
		saveToFile(selectComPortComboBox.getSelectedItem().toString(),
			textFieldPortSpeed.getText(),
			textFieldPortDataBits.getText(),
			textFieldPortStopBits.getText(),
			textFieldParitynone.getText(), textFieldDBIP.getText(),
			textFieldUsername.getText(), passwordField.getText(),
			textFieldDBName.getText());
	    }
	});

	mnFile.add(mntmSave);

	// shows help
	JMenu mnHelp = new JMenu("Help");
	mnHelp.setFont(new Font("Segoe UI", Font.BOLD, 12));
	menuBar.add(mnHelp);

	// shows about
	JMenuItem mntmAbout = new JMenuItem("About");
	mntmAbout.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {
		showAbout();
	    }
	});
	mnHelp.add(mntmAbout);
	textFieldDBName.setColumns(10);

	passwordField = new JPasswordField();
	passwordField.addFocusListener(new FocusAdapter() {
	    @Override
	    public void focusGained(FocusEvent arg0) {
		passwordField.setBackground(Color.ORANGE);
	    }

	    @Override
	    public void focusLost(FocusEvent e) {
		passwordField.setBackground(new Color(255, 255, 153));
	    }
	});
	passwordField.setBackground(new Color(255, 255, 153));
	passwordField.setForeground(new Color(0, 0, 0));
	GridBagConstraints gbc_passwordField = new GridBagConstraints();
	gbc_passwordField.insets = new Insets(0, 0, 5, 0);
	gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
	gbc_passwordField.gridx = 1;
	gbc_passwordField.gridy = 4;
	rightPanel.add(passwordField, gbc_passwordField);

	btnCheckDatabaseConnection = new JButton("Check Database Connection");
	btnCheckDatabaseConnection.setForeground(new Color(0, 153, 0));
	btnCheckDatabaseConnection.setFont(new Font("Tahoma", Font.PLAIN, 9));
	btnCheckDatabaseConnection.setBackground(new Color(135, 206, 235));
	GridBagConstraints gbc_btnCheckDatabaseConnection = new GridBagConstraints();
	gbc_btnCheckDatabaseConnection.insets = new Insets(0, 0, 5, 0);
	gbc_btnCheckDatabaseConnection.gridx = 1;
	gbc_btnCheckDatabaseConnection.gridy = 7;
	rightPanel.add(btnCheckDatabaseConnection,
		gbc_btnCheckDatabaseConnection);

	lblStatus_1 = new JLabel("Status:");
	lblStatus_1.setFont(new Font("Arial", Font.PLAIN, 14));
	GridBagConstraints gbc_lblStatus_1 = new GridBagConstraints();
	gbc_lblStatus_1.anchor = GridBagConstraints.EAST;
	gbc_lblStatus_1.insets = new Insets(0, 0, 5, 5);
	gbc_lblStatus_1.gridx = 0;
	gbc_lblStatus_1.gridy = 8;
	rightPanel.add(lblStatus_1, gbc_lblStatus_1);

	textFieldDBStatus = new JTextField();
	textFieldDBStatus.setEditable(false);
	textFieldDBStatus.setFont(new Font("Arial", Font.PLAIN, 12));
	textFieldDBStatus.setColumns(10);
	textFieldDBStatus.setBackground(new Color(255, 255, 153));
	GridBagConstraints gbc_textFieldDBStatus = new GridBagConstraints();
	gbc_textFieldDBStatus.insets = new Insets(0, 0, 5, 0);
	gbc_textFieldDBStatus.fill = GridBagConstraints.HORIZONTAL;
	gbc_textFieldDBStatus.gridx = 1;
	gbc_textFieldDBStatus.gridy = 8;
	rightPanel.add(textFieldDBStatus, gbc_textFieldDBStatus);

    }

    /**
     * 
     * @param number
     * @param defaultVal
     * @return Wheh we take data from the text field the change data from string
     *         to String
     */
    protected static int parseWithDefault(String number, int defaultVal) {
	try {
	    return Integer.parseInt(number);
	} catch (NumberFormatException e) {
	    return defaultVal;
	}
    }

    /**
     * save settings to text file.
     */
    protected void saveToFile(String stringPort, String portSpeed,
	    String portDataBits, String portStopBits, String portParity,
	    String dbIP, String dbUsername, String dbPassword, String dbName) {
	File fileName = new File("settingsIO.txt");
	// check if they fill all fields
	ReaderWriter readerWriter = new ReaderWriter("settingsIO.txt");
	try {
	    readerWriter.write(stringPort, portSpeed, portDataBits,
		    portStopBits, portParity, dbIP, dbUsername, dbPassword,
		    dbName);
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    /**
     * open settings from the file
     */
    protected void openFromFile() {
	// https://www.caveofprogramming.com/java/java-file-reading-and-writing-files-in-java.html
	// int i = Integer.parseInt(myString);
	ReaderWriter readerWriter = new ReaderWriter("settingsIO.txt");

    }

    public static Set<String> listPorts() {
	String[] portNames = SerialPortList.getPortNames();
	Set<String> ret = new HashSet<>();
	ret.addAll(Arrays.asList(portNames));
	return ret;
    }

    @Override
    public void serialEvent(SerialPortEvent serialPortEvent) {
	// TODO Auto-generated method stub

    }

}