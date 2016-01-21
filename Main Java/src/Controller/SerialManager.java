package Controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;
import jssc.SerialPortList;


public class SerialManager implements SerialPortEventListener {
    
    String stringPort = null;
    int portSpeed = 115200;
    int portDataBits = 8;
    int portStopBits = 1;
    String portParity = "PARITY_NONE";
    SerialPort port = new SerialPort(getPort());
    StringBuffer buffer = new StringBuffer();
    
    public static Set<String> listPorts()
    {
	String[] portNames = SerialPortList.getPortNames();
	Set<String> ret = new HashSet<>();
	ret.addAll(Arrays.asList(portNames));
	return ret;
    }
    
    public void setPort(String stringPort){
	this.stringPort = stringPort;
    }
    
    public String getPort(){
	return stringPort;
    }
    
    public void setPortSpeed(int portSpeed ){
	this.portSpeed  = portSpeed ;
    }
    
    public int getPortSpeed(){
	return portSpeed ;
    }
    
    public void setPortDataBits(int portDataBits ){
	this.portDataBits  = portDataBits ;
    }
    
    public int getPortDataBits(){
	return portDataBits ;
    }
    
    public void setPortStopBits(int portStopBits ){
	this.portStopBits  = portStopBits ;
    }
    
    public int getPortStopBits(){
	return portDataBits ;
    }
    
    public void setPortParity(String portParity){
	this.portParity = portParity;
    }
    
    public String getPortParity(){
	return portParity;
    }

    public void serialEvent(SerialPortEvent serialPortEvent)
    {
	if (serialPortEvent.getEventType() == SerialPortEvent.RXCHAR && stringPort != null)
	{
	    try
	    {
		final String read = port.readString();
		if (read != null)
		{
		    buffer.append(read);
		    for (int i = 0; i < buffer.length(); i++)
		    {
			char c = buffer.charAt(i);
			if (c == '\n')
			{
			    String out = buffer.substring(0, i);
			    buffer.delete(0, i + 1);
			   // Data.parse(out);
			}
		    }
		}
	    } catch (SerialPortException ex)
	    {
		Logger.getLogger(SerialTest.class.getName()).log(Level.SEVERE, null, ex);
	    }

	}
    }
    
//    public void parse(String message)
//    {
////	System.out.println("Message: " + toParse);
//	String[] split = message.split(",");
//	int nodeID = Integer.parseInt(split[0]);
//	String sensorType = split[1];
//	String sensorName = split[2];
//	double airTemp = 0.0;
//	double surfaceTemp = 0.0;
//
//	System.out.println("Node ID: " + nodeID);
//	System.out.println("\tSensor Type: " + sensorType);
//	System.out.println("\tSensor Name: " + sensorName);
//
//	if (sensorType.equals("HFT"))
//	{
//	    double heatFlux = Double.parseDouble(split[3]);
//	    airTemp = Double.parseDouble(split[4]);
//	    surfaceTemp = Double.parseDouble(split[5]);
//	    System.out.println("\tHeat Flux: " + heatFlux);
//	} else if (sensorType.equals("Temp"))
//	{
//	    airTemp = Double.parseDouble(split[3]);
//	    surfaceTemp = Double.parseDouble(split[4]);
//	}
//	System.out.println("\tAir Temperature: " + airTemp);
//	System.out.println("\tSurface Temperature: " + surfaceTemp);
//    }
    
    

}
