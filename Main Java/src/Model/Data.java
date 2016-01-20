package Model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import Controller.Sensored;

public class Data {
	private int id;
	private OffsetDateTime timeStamp;
	private double data;
	private Sensor sensor;
	private TheSession session;
	private DataType dataType;
	
	public Data() {
		
	}
	
	public Data(double data, Sensor sensor, TheSession session, DataType dataType) 
	{
		super();
		this.timeStamp = OffsetDateTime.now();
		this.data = data;
		this.sensor = sensor;
		this.session = session;
		this.dataType = dataType;
	}
	
	public Data(double data, int sensorID, String dataTypeName)
	{
		this(data, Sensor.getSensor(sensorID), Sensored.getDataSession(), DataType.getDataTypeByName(dataTypeName));
	}

	/**
	 * Parses a data line from the Arduino into a set of Data objects.
	 * @param dataline the data line to parse.
	 * @return A List object filled with Data objects.
	 */
	public static List<Data> parseData(String dataline)
	{
		List<Data> ret = new ArrayList<>();
		String[] split = dataline.split(",");
		int nodeID = Integer.parseInt(split[0]);
		String sensorType = split[1];
		String sensorName = split[2];
		double airTemp;
		double surfaceTemp;
		
		Sensor sensor = Sensor.getSensor(nodeID);
		sensor.setName(sensorName);
		
		
		if(sensorType.equals("HFT"))
		{
			airTemp = Double.parseDouble(split[4]);
			surfaceTemp = Double.parseDouble(split[5]);
			double heatFlux = Double.parseDouble(split[3]);
			Data heatFluxData = new Data(heatFlux, nodeID, "heat_flux");
			Sensored.getSession().save(heatFluxData);
		}
		else if (sensorType.equals("Temp"))
		{
			airTemp = Double.parseDouble(split[3]);
			surfaceTemp = Double.parseDouble(split[4]);
		}
		else
		{
			throw new IllegalArgumentException("Unrecognised sensor type!");
		}
		Data airTempData = new Data(airTemp, nodeID, "air");
		Data surfTempData = new Data(surfaceTemp, nodeID, "heat_flux");
		Sensored.getSession().save(airTempData);
		Sensored.getSession().save(surfTempData);
		Sensored.getSession().save(sensor);
		Sensored.doneWithSession();
		return ret;
	}

	public OffsetDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(OffsetDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	public double getData() {
		return data;
	}

	public void setData(double data) {
		this.data = data;
	}

	public Sensor getSensor() {
		return sensor;
	}

	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}

	public TheSession getSession() {
		return session;
	}

	public void setSession(TheSession session) {
		this.session = session;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public DataType getDataType() {
		return dataType;
	}

	public void setDataType(DataType dataType) {
		this.dataType = dataType;
	}
	
	
	
}
