package qi.amazon.onsite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Problem: 
 * 1. You have a bag of tickets, unsorted. 
 * 2. Each ticket has a origin station and a destination station.
 * 3. Link all tickets together into a complete trip.
 * 
 * Yesterday: 
 * The design is pretty much the same as what I designed yesterday, 
 * but I make the code cleaner and finish from where I left. 
 * 
 * Design: 
 * 1. Use two HashMap to save the ticket and trip
 * For example: we have tickets: NYC-BOS, PHL-ATL, ATL-SFO, BOS-SEA, SEA-PHL, SEA-VAN
 * 				Each ticket will be saved with
 * 				1) 	Arrival-Departure pair map: 
 * 					(BOS=NYC, ATL=PHL)
 * 				2)	Arrival-Ticket pair map: 
 * 					(BOS=NYC-BOS, ATL=PHL-ATL)
 * 2. if we find the new ticket's departure matches any key in the map, we add the ticket to existing map
 *    and update the key to be the new arrival
 *    1) 	Arrival-Departure pair map: 
 * 			(BOS=NYC, SFO=PHL)
 * 	  2)	Arrival-Ticket pair map: 
 * 			(BOS=NYC-BOS, SFO=PHL-ATL,ATL-SFO) 
 * 3. repeat above step for all tickets
 * 4. look at the final map and see whether there are any trip can be connect together.
 * 
 * Assumptions: 
 * 1. All origin and destination station are using the same naming format. 
 *    eg. if depart from or arrive at New York, station name will be the same - NYC
 * 2. All tickets in the bag and result in one or more trip to different destinations. 
 * 3. There is no two tickets having the same destination or same origin point.
 * (I tried different ways to allow this but cannot figure out a good way to do it.) 
 * 4. No roundtrip.
 * 
 * Time Complexity: O(n) -- need to loop through every ticket in the list.
 */
public class Trip {

	public static void main(String[] args) {
		Trip trip = new Trip();
		Ticket t1 = new Ticket("NYC", "BOS");
		Ticket t2 = new Ticket("PHL", "ATL");
		Ticket t3 = new Ticket("ATL", "SFO");
		Ticket t4 = new Ticket("BOS", "SEA");
		Ticket t5 = new Ticket("SEA", "PHL");
		Ticket t9 = new Ticket("EWR", "ACT");
		Ticket t10 = new Ticket("ACT", "CDE");
		Ticket t11 = new Ticket("TWE", "NYC");
		List<Ticket> ticketList = new ArrayList<Ticket>();
		ticketList.add(t10);
		ticketList.add(t1);
		ticketList.add(t2);
		ticketList.add(t3);
		ticketList.add(t4);
		ticketList.add(t5);
		ticketList.add(t9);
		ticketList.add(t11);
		List<List<String>> finalTrips = trip.getTrip(ticketList);
		for(int i = 0; i < finalTrips.size(); i++){
			System.out.println("Trip #" + (i+1) + ": " + Arrays.toString(finalTrips.get(i).toArray()));
		}
	}
	
	//HashMap for arrival-departure pair
	Map<String, String> departArriveMap;
	//HashMap for arrival-trip pair
	Map<String, List<String>> tripMap;
	
	public Trip(){
		departArriveMap = new HashMap<String, String>();
		tripMap = new HashMap<String, List<String>>();
	}
	
	public List<List<String>> getTrip(List<Ticket> tickets){
		//No ticket in the bag, trip will be null;
		if(tickets == null || tickets.size()==0){
			return null;
		}
		
		for(Ticket ticket: tickets){
			//if the ticket's departure is not in the arrival-departure pair
			//meaning either it is a new ticket, or it cannot connect to any existing 
			//ticket yet
			if(!departArriveMap.containsKey(ticket.depart)){				
				List<String> t1 = new ArrayList<String>();
				t1.add(ticket.depart);
				t1.add(ticket.arrive);
				//add to two map
				departArriveMap.put(ticket.arrive, ticket.depart);
				tripMap.put(ticket.arrive, t1);			
			}
			//if the ticket's departure already in the arrival-departure pair
			//meaning the new ticket is the next trip of an existing ticket
			else{				
				List<String> newList = new ArrayList<String>();
				//retrieve the existing ticket
				newList = tripMap.remove(ticket.depart);
				newList.add(ticket.arrive);
				//overwrite existing ticket
				departArriveMap.put(ticket.arrive, departArriveMap.remove(ticket.depart));
				tripMap.put(ticket.arrive, newList);			
			}
		}
		
		//review each arrival-departure pair in the map
		//to see whether they can be connected
		//because the two maps are 1-1 relationship
		//update tripMap accordingly
		departArriveMap.forEach((a,d) -> {
			if(tripMap.containsKey(d)){
				tripMap.get(d).remove(tripMap.get(d).size()-1);
				tripMap.get(d).addAll(tripMap.remove(a));
				tripMap.put(a, tripMap.remove(d));
			}
		});
		
		return new ArrayList<List<String>>(tripMap.values());		
	}	
}

class Ticket{
	String depart;
	String arrive;
	Ticket next;
	
	Ticket(String d, String a){
		this.depart = d;
		this.arrive = a;
	}
}
