package Model;

import java.util.ArrayList;

import org.hibernate.mapping.Set;

public class SensorType {
	private int sensorTypeID;
	private String name;
	private Set dataTypes;
	
	public SensorType() {
		
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

	public Set getDataTypes() {
		return dataTypes;
	}

	public void setDataTypes(Set dataTypes) {
		this.dataTypes = dataTypes;
	}


}
