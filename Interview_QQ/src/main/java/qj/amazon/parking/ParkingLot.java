package qj.amazon.parking;

import java.util.Date;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

public class ParkingLot {
    
	private static Level level1 = new Level(1, 50);
	private static Level level2 = new Level(2, 50);
	private static final double chargePerMin = 0.5;
	
	public static void main(String[] args) {
		
		ParkingLot parkingLot = new ParkingLot();
		Vehicle vehicle = new Vehicle();
		vehicle.setTitle("13r2526");
		vehicle.setParkingType(ParkingType.REGULAR);
		vehicle.setEntryTime(new Date());
		
		Ticket ticket = new Ticket();
		ParkingSpace parkingSpace = null;
		if(!level1.isFull()){
			parkingSpace = parkingLot.parkVehicle(level1, vehicle);
			ticket.setParkingSpace(parkingSpace);
		}
		
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		parkingSpace = parkingLot.releaseVehicle(level1, vehicle);
		vehicle.setExistTime(new Date());
		ticket.setCharge(TimeUnit.MILLISECONDS.toMinutes(vehicle.getExistTime().getTime()-vehicle.getEntryTime().getTime())*chargePerMin);
		String ti = parkingLot.printTicket(ticket);
		//parkingSpace.setVehicle(null);
		
		System.out.println(ti);
	}
	
	public ParkingSpace findNearestVacant(Level level, ParkingType type){
		Iterator<ParkingSpace> itr = level.getVacantParkingSpaces().iterator();
        while(itr.hasNext()){
            ParkingSpace parkingSpace = itr.next();
            if(parkingSpace.getParkingType() == type){
                return parkingSpace;
            }
        }
        return null;
	}
	
	public ParkingSpace parkVehicle(Level level, Vehicle vehicle){
        if(!level.isFull()) {
            ParkingSpace parkingSpace = findNearestVacant(level, vehicle.getParkingType());
            if(parkingSpace != null) {
                parkingSpace.setVehicle(vehicle);
                parkingSpace.setVacant(false);

                level.getVacantParkingSpaces().remove(parkingSpace);
                level.getFullParkingSpaces().add(parkingSpace);
                level.setRemainingSpaceNum(level.getRemainingSpaceNum()-1);
                if(level.getFullParkingSpaces().size() == level.getTotalSpaceNum()){
                    level.setFull(true);
                }
                return parkingSpace;
            }
        }
        return null;
    }
	
	public ParkingSpace releaseVehicle(Level level, Vehicle vehicle){
        Iterator<ParkingSpace> itr = level.getFullParkingSpaces().iterator();

        while(itr.hasNext()){
            ParkingSpace parkingSpace = itr.next();

            if(parkingSpace.getVehicle().equals(vehicle)){
                level.getFullParkingSpaces().remove(parkingSpace);
                level.getVacantParkingSpaces().add(parkingSpace);
                level.setRemainingSpaceNum(level.getRemainingSpaceNum()+1);
                
                parkingSpace.setVacant(true);
                //parkingSpace.setVehicle(null);

                if(level.isFull()){
                	level.setFull(false);
                }
                
                return parkingSpace;
            }
        }
        
        return null;
    }
	
	public String printTicket(Ticket ticket){
		StringBuffer sb = new StringBuffer();
		sb.append("Total charge: " + ticket.getCharge());
		sb.append("Vehicle title: " + ticket.getParkingSpace().getVehicle().getTitle());
		sb.append("Entry time: " + ticket.getParkingSpace().getVehicle().getEntryTime());
		sb.append("Exit time: " + ticket.getParkingSpace().getVehicle().getExistTime());
		
		return sb.toString();
	}
	
	

}
