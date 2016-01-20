package Model;

import java.time.OffsetDateTime;

public class Data {
	private int sensorID, dataTypeId, SessionID;
	private OffsetDateTime timeStamp;
	private double data;
	private Sensor sensor;
	private TheSession session;
	
	public Data() {
		
	}
	
	public int getSensorID() {
		return sensorID;
	}

	public void setSensorID(int sensorID) {
		this.sensorID = sensorID;
	}

	public int getDataTypeId() {
		return dataTypeId;
	}

	public void setDataTypeId(int dataTypeId) {
		this.dataTypeId = dataTypeId;
	}

	public int getSessionID() {
		return SessionID;
	}

	public void setSessionID(int sessionID) {
		SessionID = sessionID;
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
