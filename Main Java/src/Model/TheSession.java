package Model;

import java.time.OffsetDateTime;

import org.hibernate.mapping.Set;

public class TheSession {
	private int sessionID;
	private String name;
	private OffsetDateTime start, stop;	
	private Set datas;
	
	public TheSession() {
		
	}

	public int getSessionID() {
		return sessionID;
	}

	public void setSessionID(int sessionID) {
		this.sessionID = sessionID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public OffsetDateTime getStart() {
		return start;
	}

	public void setStart(OffsetDateTime start) {
		this.start = start;
	}

	public OffsetDateTime getStop() {
		return stop;
	}

	public void setStop(OffsetDateTime stop) {
		this.stop = stop;
	}

	public Set getDatas() {
		return datas;
	}

	public void setDatas(Set datas) {
		this.datas = datas;
	}	
	
	public void start() throws IllegalStateException
	{
		if (start != null)
		{
			throw new IllegalStateException("This session has already been started (and possibly stopped too)");
		}
		else
		{
			start = OffsetDateTime.now();
		}
	}
	
	public void stop() throws IllegalStateException
	{
		if (stop != null)
		{
			throw new IllegalStateException("This session has already been stopped");
		}
		else if (start == null)
		{
			throw new IllegalStateException("This session hasn't been started yet");
		}
		else
		{
			stop = OffsetDateTime.now();
		}
	}

}
