package Model;

import org.hibernate.Session;

import Controller.Sensored;

public class Sensor {
	private int sensorID, typeID;
	private String name, location;
	private SensorType sensorType;
	
	public Sensor() {
		
	}
	
	public Sensor(int id, String sensorName, SensorType sensorType)
	{
		sensorID = id;
		name = sensorName;
		this.sensorType = sensorType;
	}
	
	/**
	 * If there is an instance of Sensor in the database that has the given id number, retrieves and returns it.
	 * Otherwise, creates a new instance of Sensor with that id, saves it to the database, and returns it.
	 * 
	 * @param id the id number to retrieve or create.
	 * @return the instance of Sensor that has the ID given by 'id'; which is in the database.
	 */
	public static Sensor getSensor(int id, String name, SensorType sensorType)
	{
		Sensor ret;
		Session session = Sensored.getDatabaseSession();
		ret = session.get(Sensor.class, id);
		System.out.println("Retreiving Sensor with ID# " + id + " = " + ret);
		if (ret == null)
		{
			ret = new Sensor(id, name, sensorType);
			System.out.println("Creating new Sensor: " + ret);
			session.beginTransaction();
			session.save(ret);
			session.getTransaction().commit();
		}
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
		return sensorType;
	}

	public void setSensorType(SensorType sensorType) {
		this.sensorType = sensorType;
	}

	@Override
	public String toString() {
		return "Sensor [sensorID=" + sensorID + ", typeID=" + typeID
				+ ", name=" + name + ", location=" + location + ", SensorType="
				+ sensorType + "]";
	}
	
	
}
