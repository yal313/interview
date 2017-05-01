package qj.amazon.parking;

import java.util.Date;

public class Vehicle {
	private String title;
	private ParkingType parkingType;
	private Date entryTime;
	private Date existTime;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public ParkingType getParkingType() {
		return parkingType;
	}
	public void setParkingType(ParkingType parkingType) {
		this.parkingType = parkingType;
	}
	public Date getEntryTime() {
		return entryTime;
	}
	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}
	public Date getExistTime() {
		return existTime;
	}
	public void setExistTime(Date existTime) {
		this.existTime = existTime;
	}
	
	
}
