/**
 * Class that contains dialog where you set data.
 */

package Views;

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
import java.io.IOException;
import java.util.List;
import javax.swing.event.ListSelectionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;



import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.DefaultComboBoxModel;

public class SettingDialog extends JDialog {
	JTextField textFieldDBIP, textFieldUsername, textFieldDBPassword,
	textFieldDBPort,textFieldDBName;
	JLabel lblDBIP, lblDBPort,
	lblUsername, lblPassword, lblDBName;
	JComboBox selectTypeComboBox = new JComboBox();
	private JLabel lblPortSpeed;
	private JTextField textFieldPortSpeed;
	private JTextField textFieldPortDataBits;
	private JLabel lblPortdatabits;
	private JLabel lblPortstopbits;
	private JLabel lblPortParity;
	private JTextField textFieldPortStopBits;
	private JTextField txtParitynone;
	

	/**
	 * shows the Message dialog 
	 */
	public void showAbout(){
		JOptionPane.showMessageDialog(this,
			    "Settings App Version 1.4.",
			    "About Settings App",
			    JOptionPane.INFORMATION_MESSAGE);
		}
	


	/**
	 * @param owner is the Main Window
	 * @param mainListEmpty is true or false if the list from the Main Window have some items or not
	 */
public SettingDialog(JFrame owner) {
	super(owner, "Setting for the HW connection", true);
	setTitle("Setting");
	setPreferredSize(new Dimension(500, 350));
	setSize(500, 350);
	setLocationRelativeTo(null);

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
							textFieldDBIP
									.setBackground(new Color(255, 255, 153));
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

					// isbn
					textFieldDBPassword = new JTextField();
					textFieldDBPassword.addFocusListener(new FocusAdapter() {
						@Override
						public void focusGained(FocusEvent e) {
							textFieldDBPassword.setBackground(Color.ORANGE);
						}

						@Override
						public void focusLost(FocusEvent e) {
							textFieldDBPassword.setBackground(new Color(255, 255, 153));
						}
					});
					textFieldDBPassword.setBackground(new Color(255, 255, 153));
					textFieldDBPassword.setFont(new Font("Arial", Font.PLAIN, 12));
					
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
					gbl_layeredPaneSettings.columnWidths = new int[] {200, 200};
					gbl_layeredPaneSettings.rowHeights = new int[] {110, 100};
					gbl_layeredPaneSettings.columnWeights = new double[]{1.0, 1.0};
					gbl_layeredPaneSettings.rowWeights = new double[]{1.0, 1.0};
					layeredPaneSettings.setLayout(gbl_layeredPaneSettings);
					
					JPanel leftPanelTop = new JPanel();
					leftPanelTop.setBackground(Color.WHITE);
					GridBagConstraints gbc_leftPanelTop = new GridBagConstraints();
					gbc_leftPanelTop.insets = new Insets(0, 0, 2, 0);
					gbc_leftPanelTop.gridx = 0;
					gbc_leftPanelTop.gridy = 0;
					layeredPaneSettings.add(leftPanelTop, gbc_leftPanelTop);
					leftPanelTop.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 3));
					
					JPanel rightPanelTop = new JPanel();
					FlowLayout flowLayout = (FlowLayout) rightPanelTop.getLayout();
					flowLayout.setVgap(3);
					flowLayout.setHgap(3);
					rightPanelTop.setBackground(Color.WHITE);
					GridBagConstraints gbc_rightPanelTop = new GridBagConstraints();
					gbc_rightPanelTop.insets = new Insets(0, 0, 2, 0);
					gbc_rightPanelTop.fill = GridBagConstraints.BOTH;
					gbc_rightPanelTop.gridx = 1;
					gbc_rightPanelTop.gridy = 0;
					layeredPaneSettings.add(rightPanelTop, gbc_rightPanelTop);
					
					// add button that add books to the library
					JButton btnAdd = new JButton("Accept");
					btnAdd.setFont(new Font("Tahoma", Font.BOLD, 11));
					rightPanelTop.add(btnAdd);

					btnAdd.setBackground(new Color(0, 204, 255));
					btnAdd.setForeground(new Color(0, 153, 0));
					selectTypeComboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
					selectTypeComboBox.setModel(new DefaultComboBoxModel(new String[] {"Select COM Port", "COM1", "COM2"}));
					rightPanelTop.add(selectTypeComboBox);
					
					
					selectTypeComboBox.setForeground(new Color(0, 0, 153));
					selectTypeComboBox.setBackground(SystemColor.activeCaption);
					selectTypeComboBox.addItem("Select Type of Book");
					selectTypeComboBox.addItem("Computing");
					selectTypeComboBox.addItem("Featured History");
					selectTypeComboBox.addItem("Fiction");
					
					JPanel LeftPanel = new JPanel();
					LeftPanel.setBackground(SystemColor.activeCaption);
					GridBagConstraints gbc_LeftPanel = new GridBagConstraints();
					gbc_LeftPanel.insets = new Insets(0, 0, 5, 5);
					gbc_LeftPanel.fill = GridBagConstraints.BOTH;
					gbc_LeftPanel.gridx = 0;
					gbc_LeftPanel.gridy = 1;
					layeredPaneSettings.add(LeftPanel, gbc_LeftPanel);
					GridBagLayout gbl_LeftPanel = new GridBagLayout();
					gbl_LeftPanel.columnWidths = new int[] {50, 140};
					gbl_LeftPanel.rowHeights = new int[] {30, 30, 30, 30, 30, 30, 30, 30, 30, 30};
					gbl_LeftPanel.columnWeights = new double[]{1.0, 1.0};
					gbl_LeftPanel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0};
					LeftPanel.setLayout(gbl_LeftPanel);
					
					lblPortSpeed = new JLabel("Port Speed");
					lblPortSpeed.setFont(new Font("Arial", Font.PLAIN, 14));
					GridBagConstraints gbc_lblPortSpeed = new GridBagConstraints();
					gbc_lblPortSpeed.anchor = GridBagConstraints.EAST;
					gbc_lblPortSpeed.insets = new Insets(0, 0, 5, 5);
					gbc_lblPortSpeed.gridx = 0;
					gbc_lblPortSpeed.gridy = 1;
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
					gbc_textFieldPortSpeed.gridy = 1;
					LeftPanel.add(textFieldPortSpeed, gbc_textFieldPortSpeed);
					
					lblPortdatabits = new JLabel("Port Data Bits");
					lblPortdatabits.setFont(new Font("Arial", Font.PLAIN, 14));
					GridBagConstraints gbc_lblPortdatabits = new GridBagConstraints();
					gbc_lblPortdatabits.insets = new Insets(0, 0, 5, 5);
					gbc_lblPortdatabits.anchor = GridBagConstraints.EAST;
					gbc_lblPortdatabits.gridx = 0;
					gbc_lblPortdatabits.gridy = 2;
					LeftPanel.add(lblPortdatabits, gbc_lblPortdatabits);
					
					textFieldPortDataBits = new JTextField();
					textFieldPortDataBits.setText("8");
					textFieldPortDataBits.setFont(new Font("Arial", Font.PLAIN, 12));
					textFieldPortDataBits.setColumns(10);
					textFieldPortDataBits.setBackground(new Color(255, 255, 153));
					GridBagConstraints gbc_textFieldPortDataBits = new GridBagConstraints();
					gbc_textFieldPortDataBits.insets = new Insets(0, 0, 5, 0);
					gbc_textFieldPortDataBits.fill = GridBagConstraints.HORIZONTAL;
					gbc_textFieldPortDataBits.gridx = 1;
					gbc_textFieldPortDataBits.gridy = 2;
					LeftPanel.add(textFieldPortDataBits, gbc_textFieldPortDataBits);
					
					lblPortstopbits = new JLabel("Port Stop Bits");
					lblPortstopbits.setFont(new Font("Arial", Font.PLAIN, 14));
					GridBagConstraints gbc_lblPortstopbits = new GridBagConstraints();
					gbc_lblPortstopbits.anchor = GridBagConstraints.EAST;
					gbc_lblPortstopbits.insets = new Insets(0, 0, 5, 5);
					gbc_lblPortstopbits.gridx = 0;
					gbc_lblPortstopbits.gridy = 3;
					LeftPanel.add(lblPortstopbits, gbc_lblPortstopbits);
					
					textFieldPortStopBits = new JTextField();
					textFieldPortStopBits.setText("1");
					textFieldPortStopBits.setFont(new Font("Arial", Font.PLAIN, 12));
					textFieldPortStopBits.setColumns(10);
					textFieldPortStopBits.setBackground(new Color(255, 255, 153));
					GridBagConstraints gbc_textFieldPortStopBits = new GridBagConstraints();
					gbc_textFieldPortStopBits.insets = new Insets(0, 0, 5, 0);
					gbc_textFieldPortStopBits.fill = GridBagConstraints.HORIZONTAL;
					gbc_textFieldPortStopBits.gridx = 1;
					gbc_textFieldPortStopBits.gridy = 3;
					LeftPanel.add(textFieldPortStopBits, gbc_textFieldPortStopBits);
					
					lblPortParity = new JLabel("Port Parity");
					lblPortParity.setFont(new Font("Arial", Font.PLAIN, 14));
					GridBagConstraints gbc_lblPortParity = new GridBagConstraints();
					gbc_lblPortParity.anchor = GridBagConstraints.EAST;
					gbc_lblPortParity.insets = new Insets(0, 0, 5, 5);
					gbc_lblPortParity.gridx = 0;
					gbc_lblPortParity.gridy = 4;
					LeftPanel.add(lblPortParity, gbc_lblPortParity);
					
					txtParitynone = new JTextField();
					txtParitynone.setText("PARITY_NONE");
					txtParitynone.setFont(new Font("Arial", Font.PLAIN, 12));
					txtParitynone.setColumns(10);
					txtParitynone.setBackground(new Color(255, 255, 153));
					GridBagConstraints gbc_txtParitynone = new GridBagConstraints();
					gbc_txtParitynone.insets = new Insets(0, 0, 5, 0);
					gbc_txtParitynone.fill = GridBagConstraints.HORIZONTAL;
					gbc_txtParitynone.gridx = 1;
					gbc_txtParitynone.gridy = 4;
					LeftPanel.add(txtParitynone, gbc_txtParitynone);
					
					JPanel rightPanel = new JPanel();
					rightPanel.setBackground(SystemColor.activeCaption);
					GridBagConstraints gbc_rightPanel = new GridBagConstraints();
					gbc_rightPanel.insets = new Insets(0, 0, 5, 0);
					gbc_rightPanel.fill = GridBagConstraints.BOTH;
					gbc_rightPanel.gridx = 1;
					gbc_rightPanel.gridy = 1;
					layeredPaneSettings.add(rightPanel, gbc_rightPanel);
					GridBagLayout gbl_rightPanel = new GridBagLayout();
					gbl_rightPanel.columnWidths = new int[] {50, 140};
					gbl_rightPanel.rowHeights = new int[] {30, 30, 30, 30, 30, 30, 30, 30, 30, 30};
					gbl_rightPanel.columnWeights = new double[]{0.0, 1.0};
					gbl_rightPanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
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
					
					GridBagConstraints gbc_textFieldDBPassword = new GridBagConstraints();
					gbc_textFieldDBPassword.insets = new Insets(0, 0, 5, 0);
					gbc_textFieldDBPassword.fill = GridBagConstraints.HORIZONTAL;
					gbc_textFieldDBPassword.gridx = 1; 
					gbc_textFieldDBPassword.gridy = 4; 
					rightPanel.add(textFieldDBPassword, gbc_textFieldDBPassword);
					textFieldDBPassword.setColumns(10);
					
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
					
					// save file from the menu
					JMenuItem mntmSave = new JMenuItem("Save");

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

					
	
	
	
	
	   }
	
}