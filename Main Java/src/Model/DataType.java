package Model;

public class DataType {
	private int dataTypeID;
	private String name;
	
	public DataType() {
		
	}
	
	/**
	 * If there is an instance of DataType in the database that has the given name, retrieves and returns it.
	 * Otherwise, creates a new instance of DataType with that name (and the next id available), saves it to the database, and returns it.
	 * 
	 * @param name the name to retrieve or create.
	 * @return the instance of DataType that has the ID given by 'id'; which is in the database.
	 */
	public static DataType getDataTypeByName(String name)
	{
		// TODO: return something
		throw new UnsupportedOperationException("NYI!");
	}
	
	public int getDataTypeID() {
		return dataTypeID;
	}

	public void setDataTypeID(int dataTypeID) {
		this.dataTypeID = dataTypeID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
