package qj.amazon.parking;

public class ParkingSpace {
	private int id;
	private boolean isVacant;
	private Vehicle vehicle;
	private ParkingType parkingType;
	private int distance;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isVacant() {
		return isVacant;
	}
	public void setVacant(boolean isVacant) {
		this.isVacant = isVacant;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public ParkingType getParkingType() {
		return parkingType;
	}
	public void setParkingType(ParkingType parkingType) {
		this.parkingType = parkingType;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}	
}
