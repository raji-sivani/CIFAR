package com.adbms.dto;

import javax.xml.bind.annotation.XmlRootElement;


//DTO for accessing data from the database
@XmlRootElement
public class Transport {

	private String originName;
	
	private String destinationName;
	
	private String nextStopPointName;
	
	private String expectedArrivalTime;
	
	private String scheduledArrivalTime;

	public String getOriginName() {
		return originName;
	}

	public void setOriginName(String originName) {
		this.originName = originName;
	}

	public String getDestinationName() {
		return destinationName;
	}

	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}

	public String getNextStopPointName() {
		return nextStopPointName;
	}

	public void setNextStopPointName(String nextStopPointName) {
		this.nextStopPointName = nextStopPointName;
	}

	public String getExpectedArrivalTime() {
		return expectedArrivalTime;
	}

	public void setExpectedArrivalTime(String expectedArrivalTime) {
		this.expectedArrivalTime = expectedArrivalTime;
	}

	public String getScheduledArrivalTime() {
		return scheduledArrivalTime;
	}

	public void setScheduledArrivalTime(String scheduledArrivalTime) {
		this.scheduledArrivalTime = scheduledArrivalTime;
	}
	
	
}
