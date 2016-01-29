package Controller;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Logging {
	
	String filename= "Log-%DATE%.txt";
	FileWriter fw = null;
	LocalDate fileDate = null;
	
	public Logging() 
	{
		try 
		{
			openFileWriter();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void newRawData(String rawData) {
		try
		{
		    if (fw == null || fileDate.isBefore(LocalDate.now()))
		    {
		    	if (fw != null)
		    		closeFileWriter();
		    	openFileWriter();
		    }
		    
		    fw.write(rawData + "\n");
		}
		catch(IOException ioe)
		{
		    System.err.println("IOException in class Logging: " + ioe.getMessage());
		}
	}
	
	private void openFileWriter() throws IOException
	{
		fileDate = LocalDate.now();
		String nameWithDate = filename.replaceAll("%DATE%", fileDate.format(DateTimeFormatter.ISO_LOCAL_DATE));
		fw = new FileWriter(filename,true);
	}
	
	private void closeFileWriter() throws IOException
	{
		fw.close();
		fw = null;
	}
}
