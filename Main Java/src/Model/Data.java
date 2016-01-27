package Model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

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
		this();
		this.timeStamp = OffsetDateTime.now();
		this.data = data;
		this.sensor = sensor;
		this.session = session;
		this.dataType = dataType;
	}
	
	public Data(double data, Sensor sensor, String dataTypeName)
	{
		this(data, sensor, Sensored.getCurrentDataSession(), DataType.getDataTypeByName(dataTypeName));
	}

	/**
	 * Parses a data line from the Arduino into a set of Data objects.
	 * @param dataline the data line to parse.
	 */
	public static Set<Data> parseData(String dataline)
	{
		Set<Data> ret = new HashSet<>();
		try
		{
			
			String[] split = dataline.split(",");
			int nodeID = Integer.parseInt(split[0]);
			String sensorTypeName = split[1];
			String sensorName = split[2];
			double airTemp;
			double surfaceTemp;
			
			SensorType sensorType = SensorType.getSensorTypeByName(sensorTypeName);
			Sensor sensor = Sensor.getSensor(nodeID, sensorName, sensorType);
			sensor.setName(sensorName);
			
			Sensored.getCurrentDataSession();
			
			Session session = Sensored.getDatabaseSession();
			session.beginTransaction();
			
			
			if(sensorTypeName.equals("HFT"))
			{
				airTemp = Double.parseDouble(split[4]);
				surfaceTemp = Double.parseDouble(split[5]);
				double heatFlux = Double.parseDouble(split[3]);
				Data heatFluxData = new Data(heatFlux, sensor, "Heatflux");
				ret.add(heatFluxData);
				session.save(heatFluxData);
			}
			else if (sensorTypeName.equals("Temp"))
			{
				airTemp = Double.parseDouble(split[3]);
				surfaceTemp = Double.parseDouble(split[4]);
			}
			else
			{
				throw new IllegalArgumentException("Unrecognised sensor type!");
			}
			Data airTempData = new Data(airTemp, sensor, "Air");
			Data surfTempData = new Data(surfaceTemp, sensor, "Surface");
			ret.add(surfTempData);
			ret.add(airTempData);
			session.save(airTempData);
			session.save(surfTempData);
			session.saveOrUpdate(sensor);
			session.getTransaction().commit();
			Sensored.doneWithDatabaseSession();
			
		}
		catch(IllegalStateException ex)
		{
			System.out.println("Data ignored: no current logging session");
			
		}
		catch (NumberFormatException | ArrayIndexOutOfBoundsException ex)
		{
			System.err.println("Data validation failed; " + ex.getMessage());
		}
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

	@Override
	public String toString() {
		return "Data [id=" + id + ", timeStamp=" + timeStamp + ", data=" + data
				+ ", sensor=" + sensor + ", session=" + session + ", dataType="
				+ dataType + "]";
	}
	
	
	
}
