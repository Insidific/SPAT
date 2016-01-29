package Controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import Model.Data;
import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;
import jssc.SerialPortList;

public class SerialManager implements SerialPortEventListener {

	String portNumber = "COM6";
	int portSpeed = 115200;
	int portDataBits = 8;
	int portStopBits = 1;
	int portParity = SerialPort.PARITY_NONE;
	SerialPort port = null;
	StringBuffer buffer = new StringBuffer();

	public static Set<String> listPorts() {
		String[] portNames = SerialPortList.getPortNames();
		Set<String> ret = new HashSet<>();
		ret.addAll(Arrays.asList(portNames));
		return ret;
	}
	
	public SerialManager() {
    
	}

	public void init()
	{
		System.out.println("Initialising port.");
		try
		{
			if (port != null && port.getPortName() != portNumber)
			{
				System.out.println("\tClosing existing port.");
				if (port.isOpened())
				    port.closePort();
				port = null;
			}
			if (port == null || port.getPortName() != portNumber)
			{
				System.out.println("\tOpening port "+portNumber+".");
				port = new SerialPort(portNumber);
				port.openPort();
				port.addEventListener(this);
			}
			port.setParams(portSpeed, portDataBits, portStopBits, portParity);
			port.setFlowControlMode(SerialPort.FLOWCONTROL_XONXOFF_IN | SerialPort.FLOWCONTROL_XONXOFF_OUT);
		}
		catch (SerialPortException ex)
		{
			System.err.println("Exception while initialising serial port: " + ex.getMessage());
		}
	}

	public void setPort(String stringPort) {
		this.portNumber = stringPort;
		init();
	}

	public String getPort() {
		return portNumber;
	}

	public void setPortSpeed(int portSpeed) {
		this.portSpeed = portSpeed;
		init();
	}

	public int getPortSpeed() {
		return portSpeed;
	}

	public void setPortDataBits(int portDataBits) {
		this.portDataBits = portDataBits;
		init();
	}

	public int getPortDataBits() {
		return portDataBits;
	}

	public void setPortStopBits(int portStopBits) {
		this.portStopBits = portStopBits;
		init();
	}

	public int getPortStopBits() {
		return portDataBits;
	}

	public void setPortParity(int portParity) {
		this.portParity = portParity;
		init();
	}

	public int getPortParity() {
		return portParity;
	}

	public void serialEvent(SerialPortEvent serialPortEvent) {
		if (serialPortEvent.getEventType() == SerialPortEvent.RXCHAR
				&& portNumber != null) {
			try {
				final String read = port.readString();
				if (read != null) {
					buffer.append(read);
					for (int i = 0; i < buffer.length(); i++) {
						char c = buffer.charAt(i);
						if (c == '\n') {
							String out = buffer.substring(0, i);
							System.out.println("Got message from Arduino: " + out);
							buffer.delete(0, i + 1);
							Sensored.newDataReceived(out);
						}
					}
				}
			} catch (SerialPortException ex) {
				Logger.getLogger(SerialManager.class.getName()).log(
						Level.SEVERE, null, ex);
			}

		}
	}


}
