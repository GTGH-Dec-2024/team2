package com.GTGH_team2.Reservations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.GTGH_team2.ApprovalRequests.ApprovalRequest;
import com.GTGH_team2.Employees.Employee;
import com.GTGH_team2.Events.Event;
import com.GTGH_team2.Events.EventServices;
import com.GTGH_team2.Organizers.Organizer;
import com.GTGH_team2.Visitors.Visitor;
import com.GTGH_team2.Visitors.VisitorServices;

public class ReservationServices {

	private List<Reservation> reservations = new ArrayList<Reservation>();
	@Autowired
	VisitorServices visitorServices;
	@Autowired
	EventServices eventsServices;

	public ReservationServices(VisitorServices visitorServices, EventServices eventsServices) {
		this.visitorServices = visitorServices;
		this.eventsServices = eventsServices;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public List<Reservation> addReservation(Visitor visitor, Event event) {
		reservations.add(new Reservation(visitor, event));
		return reservations;
	}

	// Deletes all reservations with a specific visitor id
	public void deleteReservationsByVisitorId(Integer visitorId) {
		reservations.removeIf(reservation -> reservation.getVisitor().getId() == visitorId); // Remove reservations
																								// where the visitor
																								// matches the id
		System.out.println("All reservations for visitor with id number " + visitorId + " have been deleted!");
	}

	// Deletes all reservations with a specific event id.
	public void deleteReservationsByEventId(int eventId) {
		reservations.removeIf(reservation -> reservation.getEvent().getId() == eventId); // Remove reservations where
																							// the event matches the id
		System.out.println("All reservations for event with id number " + eventId + " have been deleted!");
	}

	// Booking an Event
	// This method allows a visitor to book an event by their IDs , it checks if the
	// reservation already exists and creates a new one if not.
	public List<Reservation> bookingAnEvent(Integer visitorId, Integer eventId) {
		for (Visitor visitor : visitorServices.getAllVisitors()) {
			if (visitor.getId() == visitorId)
				for (Event event : eventsServices.getAllEvents()) {
					if (event.getId() == eventId && visitorHasMadeARes(visitor,event)) {
						addReservation(visitor, event);
					}
				}
		}
		return reservations;
	}

	//checking if the visitor has already made a reservation for the event
	public boolean visitorHasMadeARes(Visitor visitor, Event event) {
		for(Reservation res: reservations) {
			if(res.getVisitor() == visitor && res.getEvent()== event)
				return false;
		}
		return true;
	}

	// Canceling an Event
	// This method allows a visitor to cancel a booking for a specific event by
	// their IDs, it checks if the reservation exists and removes it if found
	public List<Reservation> ReservationCanceling(Integer visitorId, Integer reservationtId) {
		for (Visitor visitor : visitorServices.getAllVisitors()) {
			if (visitor.getId() == visitorId )
				for (Reservation res : reservations) {
					if (res.getId() == reservationtId && visitorHasMadeARes(visitor, res.getEvent()))
						reservations.remove(res);
				}
		}
		return reservations;
	}
			
	public void viewAllReservations() {
		if (reservations.isEmpty()) {
			System.out.println("There are no reservations.");
		} else {
			System.out.println("Reservations: ");
			for (Reservation res : reservations) {
				System.out.println(reservations);
			}
		}
	}
	
	public List<Visitor> participantsInEvent(Integer idOrganizer) {
    	List<Visitor> listParticipants = new ArrayList<Visitor>();
    	for(Organizer organizer : organizers) {
    		if(organizer.getId() == idOrganizer) {
    			for(Event event : organizer.getEvents()) {
    				
    				
    				
    				for(Visitor visitor : visitors) {
    					listParticipants.add(visitor);
    				}
    			}
    		}
    	}
    	return listParticipants;
    }
	
	//Checking whether a visitor is a participant (has made a reservation)
	public boolean visitorIsParticipant(Visitor visitor, Event event) {
		for(Reservation res: reservations) {
			if(res.getVisitor() == visitor && res.getEvent() == event) {
				return true;
			}
		}
		return false;	
	}


}
