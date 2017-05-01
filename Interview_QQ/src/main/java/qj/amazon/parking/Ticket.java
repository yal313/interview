package qj.amazon.parking;

import java.util.Date;

public class Ticket {
	private ParkingSpace parkingSpace;	
	private double charge;
	
	public ParkingSpace getParkingSpace() {
		return parkingSpace;
	}
	public void setParkingSpace(ParkingSpace parkingSpace) {
		this.parkingSpace = parkingSpace;
	}
	public double getCharge() {
		return charge;
	}
	public void setCharge(double charge) {
		this.charge = charge;
	}	
}
