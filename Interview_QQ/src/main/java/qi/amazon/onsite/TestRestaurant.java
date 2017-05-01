package qi.amazon.onsite;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class TestRestaurant {

	public static void main(String[] args) {
		ReservationOnline reservationOnline = new ReservationOnline();
		
		Table table1 = new Table(1, 4);
		Table table2 = new Table(2, 4);
		Table table3 = new Table(3, 4);
		Table table4 = new Table(4, 4);
		Table table5 = new Table(5, 6);
		Table table6 = new Table(6, 6);
		Table table7 = new Table(7, 6);
		Table table8 = new Table(8, 6);
		Table table9 = new Table(9, 10);
		Table table10 = new Table(10, 10);
		Table table11 = new Table(11, 10);
		Table table12 = new Table(12, 20);
		List<Table> tables = new ArrayList<Table>();
		tables.add(table1);
		tables.add(table2);
		tables.add(table3);
		tables.add(table4);
		tables.add(table5);
		tables.add(table6);
		tables.add(table7);
		tables.add(table8);
		tables.add(table9);
		tables.add(table10);
		tables.add(table11);
		tables.add(table12);
		
		reservationOnline.tables.addAll(tables);
		
		String rId = reservationOnline.makeReservation(5, "24235234", new Date() , addMinutesToDate(60, new Date()));
		//reservationOnline.cancelReservation(rId, null);
		String rId2 = reservationOnline.makeReservation(6, "623241", addMinutesToDate(30, new Date()) , addMinutesToDate(60, new Date()));
		
		for(Reservation res: reservationOnline.reservations){
			System.out.println(res.reservationNum);
			System.out.println(res.reservationTime);
			System.out.println(res.endTime);
			System.out.println(res.tableId);
		}
	}
	
	private static Date addMinutesToDate(int minutes, Date beforeTime){
	    final long ONE_MINUTE_IN_MILLIS = 60000;//millisecs

	    long curTimeInMs = beforeTime.getTime();
	    Date afterAddingMins = new Date(curTimeInMs + (minutes * ONE_MINUTE_IN_MILLIS));
	    return afterAddingMins;
	}

}
