package Model;

import java.util.List;

import org.hibernate.Session;
import java.util.Set;

import Controller.Sensored;

public class DataType {
	private int dataTypeID;
	private String name;
	private Set<SensorType> sensorTypes;
	
	public DataType() {
		
	}
	
	/**
	 * If there is an instance of DataType in the database that has the given name, retrieves and returns it.
	 * Otherwise, creates a new instance of DataType with that name (and the next id available), saves it to the database, and returns it.
	 * 
	 * @author Jim
	 * @param name the name to retrieve or create.
	 * @return the instance of DataType that has the ID given by 'id'; which is in the database, or null if there is no such DataType.
	 * @throws IllegalStateException if there are multiple DataTypes with that name.
	 */
	public static DataType getDataTypeByName(String name) throws IllegalStateException
	{
		Session session = Sensored.getDatabaseSession();
		@SuppressWarnings("unchecked")
		List<DataType> list = (List<DataType>) session.createQuery("SELECT dt FROM DataType AS dt WHERE name = '"+name+"'").list();
		Sensored.doneWithDatabaseSession();
		System.out.println(list);
		if (list.size() == 1)
			return list.get(0);
		else if (list.isEmpty())
			return null;
		else
			throw new IllegalStateException("There are "+list.size()+" DataTypes with the name '" + name + "'!");
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

	public Set<SensorType> getSensorTypes() {
		return sensorTypes;
	}

	public void setSensorTypes(Set<SensorType> sensorTypes) {
		this.sensorTypes = sensorTypes;
	}

	@Override
	public String toString() {
		return "DataType [dataTypeID=" + dataTypeID + ", name=" + name + "]";
	}
	
	

}
