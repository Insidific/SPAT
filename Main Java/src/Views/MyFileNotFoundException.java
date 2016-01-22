package Views;
/**
 * My exception class 
 */


import java.io.FileNotFoundException;

public class MyFileNotFoundException extends FileNotFoundException {
    
	/**
	 * @return message when the file is not found
	 */
    public String toString(){
	
	return " Message from Petr\r\n  Your file do not exist! \r\n " + super.toString();
    }

}
