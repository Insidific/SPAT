package Controller;

import java.io.FileWriter;
import java.io.IOException;

public class Logging {
	public Logging() {
		
	}
	
	public void newRawData(String rawData) {
		try
		{
		    String filename= "LogDate.txt";
		    FileWriter fw = new FileWriter(filename,true);
		    fw.write(rawData + "\n");
		    fw.close();
		}
		catch(IOException ioe)
		{
		    System.err.println("IOException: " + ioe.getMessage());
		}
	}
}
