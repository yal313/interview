package qj.amazon.parking;

import java.util.Vector;

public class Level {
	private int levelId;
	private int totalSpaceNum;
	private int remainingSpaceNum;
	private boolean isFull;	
	Vector<ParkingSpace> vacantParkingSpaces = null;
    Vector<ParkingSpace> fullParkingSpaces = null;
    
	public Level(int levelId, int totalSpaceNum) {
		super();
		this.levelId = levelId;
		this.totalSpaceNum = totalSpaceNum;
		this.remainingSpaceNum = totalSpaceNum;
		this.isFull = false;
		this.vacantParkingSpaces = new Vector<ParkingSpace>();
		this.fullParkingSpaces = new Vector<ParkingSpace>();
	}
	
	public int getLevelId() {
		return levelId;
	}
	public void setLevelId(int levelId) {
		this.levelId = levelId;
	}
	public int getTotalSpaceNum() {
		return totalSpaceNum;
	}
	public void setTotalSpaceNum(int totalSpaceNum) {
		this.totalSpaceNum = totalSpaceNum;
	}
	public int getRemainingSpaceNum() {
		return remainingSpaceNum;
	}

	public void setRemainingSpaceNum(int remainingSpaceNum) {
		this.remainingSpaceNum = remainingSpaceNum;
	}

	public boolean isFull() {
		return isFull;
	}
	public void setFull(boolean isFull) {
		this.isFull = isFull;
	}
	public Vector<ParkingSpace> getVacantParkingSpaces() {
		return vacantParkingSpaces;
	}
	public void setVacantParkingSpaces(Vector<ParkingSpace> vacantParkingSpaces) {
		this.vacantParkingSpaces = vacantParkingSpaces;
	}
	public Vector<ParkingSpace> getFullParkingSpaces() {
		return fullParkingSpaces;
	}
	public void setFullParkingSpaces(Vector<ParkingSpace> fullParkingSpaces) {
		this.fullParkingSpaces = fullParkingSpaces;
	}
	
	
}
