package Views;
/**
 * Class that helps us to read and save data from the file.
 */

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

public class ReaderWriter {	
	private String fileName;

	/**
	 * @param fileName name of the file where are saved data about the settings
	 */
	public ReaderWriter(String fileName) {
		super();
		this.fileName = fileName;
	}
	
	/**
	 * @param serialManager is the list where we store information about settings(temporary)
	 * @throws IOException
	 */
	public void write(String stringPort,String  portSpeed,String portDataBits,
		String portStopBits,String portParity,
		String dbIP, String dbUsername, String dbPassword, String dbName ) 
			throws IOException {
	    if(stringPort .isEmpty() || stringPort .startsWith("Select") 
		    || portSpeed .isEmpty() ||  portDataBits .isEmpty()
		    ||  portStopBits .isEmpty() ||  portParity .isEmpty()  
			    ||  dbIP .isEmpty() ||  dbUsername .isEmpty() 
			    ||  dbPassword .isEmpty()
				    ||  dbName .isEmpty() ){ 
		
	    } else {
	  
	    
	    try {
		// Change int to String
//	     String stringPortSpeed = Integer.toString(portSpeed);
//	     String stringPortDataBits = Integer.toString(portDataBits);
//	     String stringPortStopBits = Integer.toString(portStopBits);
	     
	     
	    // Assume default encoding.
	    FileWriter fileWriter =  new FileWriter(fileName);
            // Wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);   
            
            
            // Write data.
            bufferedWriter.write(stringPort);
            bufferedWriter.newLine();
            bufferedWriter.write(portSpeed);
            bufferedWriter.newLine();
            bufferedWriter.write(portDataBits);           
            bufferedWriter.newLine();
            bufferedWriter.write(portStopBits);    
            bufferedWriter.newLine();
            bufferedWriter.write(portParity);         
            bufferedWriter.newLine();
            bufferedWriter.write(dbIP);    
            bufferedWriter.newLine();
            bufferedWriter.write(dbUsername);           
            bufferedWriter.newLine();
            bufferedWriter.write(dbPassword);    
            bufferedWriter.newLine();
            bufferedWriter.write(dbName);
            // Close files.
            bufferedWriter.close();
	    }
	        catch(IOException ex) {
	            System.out.println(
	                "Error writing to file '"
	                + fileName + "'");
	             ex.printStackTrace();
	        }
	    
	    }
	}
	
	

}
