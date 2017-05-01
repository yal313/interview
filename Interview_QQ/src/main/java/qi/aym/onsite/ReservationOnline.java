package qi.aym.onsite;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Problem: design a restaurant reservation system that can take in customer reservation
 * 			and cancel customer reservation. 
 * 
 * Yesterday: 	
 * 1.	The old design was to put reservations to table, so one table will be multiple reservations.
 * 		But I found that makes cancel reservation harder. 
 * 2.	If customer provides a confirmation number and wants to cancel, with the old design, we then need 
 * 		to look at all the tables to find a reservation. 
 * 3.	So I redesign it to have each reservation link to one table, this makes checking table availbility easier
 * 		and cancellation can simply refer to the confirmation number and free up the table. 
 * 
 * Design: 
 * 1. 	2 objects: Reservation and Table
 * 				 Reservation will contain Table.tableId
 * 2. 	Assume tables are ordered from small size to large size
 * 3. 	2 operations are available: 
 * 		makeReservation: 1)reservation is made based on number of people, customer's cellphone#, and reserve time.
 * 						 2)A reservation can be made when 
 * 							a) a table's capacity can fit the number of people.
 * 							b) the table is available in the reserve time frame.
 * 						 3)When reservation is made successfully, reservationNum is returned. 
 * 						 4)ReservationNum is generated based on reservation time.
 * 		cancelReservation: reservation can be cancelled match on either reservation number or customer's cellphone#.
 * 	
 */
public class ReservationOnline {
	List<Reservation> reservations;
	List<Table> tables;
	
	public ReservationOnline(){
		reservations = new ArrayList<Reservation>();
		tables = new ArrayList<Table>();
	}	
	
	public String makeReservation(int numberOfPeople, String customerTel, Date reservationTime, Date endTime){
		Table table = null;
		//find a table based on capacity and availability
		for(Table t : tables){
			if(t.numberOfSeat >= numberOfPeople && isTableAvailable(t, reservationTime, endTime)){
				table = t;
				break;
			}
		}
		//if a table can be found, add it to the reservation list and return confirmation number.
		if(table != null){
			Reservation reservation = new Reservation(table.tableId, customerTel, reservationTime, endTime);
			reservation.reservationNum = generateReservationConfirmation(reservationTime);
			reservations.add(reservation);
			return reservation.reservationNum;
		}
		return null;	
	}
	
	public boolean cancelReservation(String reservationNum, String customerTel){
		Reservation tobeCancel = null;
		//if a reservation can be found based on reservation number and customer phone
		//remove it from the reservationlist
		for(Reservation reserv: reservations){
			if(reserv.reservationNum.equals(reservationNum) 
					|| reserv.getCustomerTel().equals(customerTel)){
				tobeCancel = reserv;
				break;
			}
		}
		if(tobeCancel == null){
			return false;
		}
		reservations.remove(tobeCancel);
		return true;
	}
	
	private String generateReservationConfirmation(Date reservationTime){
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyMMddhhmmss");
		return dateFormatter.format(reservationTime);
	}
	
	//Check whether the table is available at the request time
	//Will go through all reservation fiter by tableId and then check time
	private boolean isTableAvailable(Table table, Date reservationTime, Date endTime){
		for(Reservation reser: reservations
				.stream()
				.filter(a -> a.tableId == table.tableId)
				.collect(Collectors.toList())){
			if(reservationTime.after(reser.reservationTime) && reservationTime.before(reser.endTime)
					|| endTime.after(reser.reservationTime) && endTime.before(reser.endTime)){
				return false;
			}
		}
		return true;
	}
}

class Table{
	int tableId;
	int numberOfSeat;
	
	public Table(int id, int seats){
		this.tableId = id;
		this.numberOfSeat = seats;
	}		
}

class Reservation{
	int tableId;
	private String customerTel;
	Date reservationTime;
	Date endTime;
	String reservationNum;
	
	public Reservation(int id, String tel, Date reservationTime, Date endTime){
		this.tableId = id;
		this.customerTel = tel;
		this.reservationTime = reservationTime;
		this.endTime = endTime;
	}
	
	public String getCustomerTel(){
		return this.customerTel;
	}
}