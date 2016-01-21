package Model;

import org.hibernate.Session;

import Controller.Sensored;

public class Sensor {
	private int sensorID, typeID;
	private String name, location;
	private SensorType SensorType;
	
	public Sensor() {
		
	}
	
	/**
	 * If there is an instance of Sensor in the database that has the given id number, retrieves and returns it.
	 * Otherwise, creates a new instance of Sensor with that id, saves it to the database, and returns it.
	 * 
	 * @param id the id number to retrieve or create.
	 * @return the instance of Sensor that has the ID given by 'id'; which is in the database.
	 */
	public static Sensor getSensor(int id)
	{
		Sensor ret;
		Session session = Sensored.getDatabaseSession();
		ret = session.get(Sensor.class, id);
		Sensored.doneWithDatabaseSession();
		return ret;
	}
	
	public int getSensorID() {
		return sensorID;
	}

	public void setSensorID(int sensorID) {
		this.sensorID = sensorID;
	}

	public int getTypeID() {
		return typeID;
	}

	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public SensorType getSensorType() {
		return SensorType;
	}

	public void setSensorType(SensorType sensorType) {
		SensorType = sensorType;
	}

	@Override
	public String toString() {
		return "Sensor [sensorID=" + sensorID + ", typeID=" + typeID
				+ ", name=" + name + ", location=" + location + ", SensorType="
				+ SensorType + "]";
	}
	
	
}
