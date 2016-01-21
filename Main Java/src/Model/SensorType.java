package Model;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import Controller.Sensored;

public class SensorType {
	private int sensorTypeID;
	private String name;
	private Set<DataType> dataTypes;
	
	public SensorType() {
		
	}
	
	/**
	 * If there is an instance of SensorType in the database that has the given name, retrieves and returns it.
	 * Otherwise, creates a new instance of SensorType with that name (and the next id available), saves it to the database, and returns it.
	 * 
	 * @author Jim
	 * @param name the name to retrieve or create.
	 * @return the instance of SensorType that has the ID given by 'id'; which is in the database, or null if there is no such SensorType.
	 * @throws IllegalStateException if there are multiple SensorTypes with that name.
	 */
	public static SensorType getSensorTypeByName(String name) throws IllegalStateException
	{
		Session session = Sensored.getDatabaseSession();
		@SuppressWarnings("unchecked")
		List<SensorType> list = (List<SensorType>) session.createQuery("SELECT st FROM SensorType AS st WHERE st.name = '"+name+"'").list();
		Sensored.doneWithDatabaseSession();
		System.out.println(list);
		if (list.size() == 1)
			return list.get(0);
		else if (list.isEmpty())
			return null;
		else
			throw new IllegalStateException("There are "+list.size()+" SensorTypes with the name '" + name + "'!");
	}

	public int getSensorTypeID() {
		return sensorTypeID;
	}

	public void setSensorTypeID(int sensorTypeID) {
		this.sensorTypeID = sensorTypeID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<DataType> getDataTypes() {
		return dataTypes;
	}

	public void setDataTypes(Set<DataType> dataTypes) {
		this.dataTypes = dataTypes;
	}

	@Override
	public String toString() {
		return "SensorType [sensorTypeID=" + sensorTypeID + ", name=" + name
				+ "]";
	}

	
}
