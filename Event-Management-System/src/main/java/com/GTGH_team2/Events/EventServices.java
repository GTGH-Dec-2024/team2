package com.GTGH_team2.Events;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GTGH_team2.Employees.Employee;
import com.GTGH_team2.Employees.EmployeeServices;
import com.GTGH_team2.Organizers.Organizer;
import com.GTGH_team2.Organizers.OrganizerServices;
import com.GTGH_team2.Reservations.Reservation;
import com.GTGH_team2.Reservations.ReservationServices;
import com.GTGH_team2.Visitors.Visitor;
import com.GTGH_team2.Visitors.VisitorServices;

@Service
public class EventServices {

	private List<Event> allEvents = new ArrayList<>();

	@Autowired
	ReservationServices reservationServices;
	@Autowired
	EmployeeServices employeeServices;
	@Autowired
	OrganizerServices organizerServices;
	@Autowired
	VisitorServices visitorServices;



	public List<Event> getAllEvents() {
		return allEvents;
	}

	public void setAllEvents(ArrayList<Event> allEvents) {
		this.allEvents = allEvents;
	}
	
	public Boolean isValidMonth(Integer month) {
		if((month >=1 && month <= 12))
			return true;
		return false;
	}
	
	public Boolean isValidDay(Integer day) {
		if(day >=1 && day <= 31)
			return true;
		return false;
	}
	
//	public Boolean isValidYear(Integer year) {
//		if(Event.getDate().getYear() < year)
//			return false;
//		return true;
//	}

	public List<Event> viewApprovedEvents() {
		List<Event> approvedEvents = new ArrayList<>();
		System.out.println("------------------------------------------------------------------------");
		if(allEvents.isEmpty() ) {
			System.out.println("There are no events");
		}else {
			System.out.println("Approved Events");
			for (Event event : allEvents) {
				if(event.getStatus() == "Approved")
					approvedEvents.add(event);
					System.out.println(event + " ");
			}
		}
		System.out.println("------------------------------------------------------------------------");
		return approvedEvents;
	}

	// Add an Event to the list

	public void addEvent(Event event) {
		int newId = 1;
		if(allEvents.size() > 0) {
			newId = allEvents.get(allEvents.size() - 1).getId()+1;
		}
		if (!allEvents.contains(event)) { // It checks if the list contains the event given and if not the event is added 
			event.setId(newId);
			allEvents.add(event);
			System.out.println("The event " + event.getTitle() + " is added!");
		} else {
			System.out.println("This event already exists in the list");
		}
	}

	// Remove an Event from the list - If it is approved

	public List<Event> removeEvent(Integer id) {
//		Event eventToBeRemoved = null;
//		for (Event event : allEvents) {
//			if (event.getId() == id) {
//				eventToBeRemoved = event;
//				break;
//			}
//		}
//		if (eventToBeRemoved != null) {
//			allEvents.remove(eventToBeRemoved);
//			System.out.println("The event " + eventToBeRemoved.getTitle() + " is removed successfully!");
//		} else {
//			System.out.println("The event does not exists in the list!");
//		}
		allEvents.removeIf(event -> event.getId() == id);
		return allEvents;
	}

	// Update an Event

	public List<Event> updateEvent(Integer id, String newTitle, String newTheme, String newDescription, String newLocation,
			Integer newMaxCapacity, Integer newDay, Integer newMonth, Integer newYear, Integer newHour, Integer newMinute,
			String newDuration) {
		for (Event event : allEvents) {
			if (newTitle != null)
				event.setTitle(newTitle);
			if (newTheme != null)
				event.setTheme(newTheme);
			if (newDescription != null)
				event.setDescription(newDescription);
			if (newLocation != null)
				event.setTitle(newLocation);
			if (newMaxCapacity != null)
				event.setMaxCapacity(newMaxCapacity);
			if (newDay != null)
				do {
					if(isValidDay(newDay))
						event.setDay(newDay);
				}while (!isValidDay(newDay));
			//if (newMonth != null)
//				do {
//					if(isValidDay(newMonth))
//						event.setMonth(newMonth);
//				}while (!isValidMonth(newMonth));
			//do {
//				if(isValidYear(newYear)) {
			//		event.setYear(newYear);
//				}
//			}while(!isValidYear(newYear));
			if (newYear != null)
				event.setYear(newYear);
			if (newHour != null)
				event.setHour(newHour);
			if (newMinute != null)
				event.setMinutes(newMinute);
			if (newDuration != null)
				event.setDuration(newDuration);
		}
		return allEvents;
	}

	// Update specific attributes of an event
	
	public List<Event> updateLocation(Integer idEvent, String newLocation) {
		for(Event event : allEvents) {
			if(event.getId() == idEvent) {
				if(newLocation != null)
					event.setLocation(newLocation);
			}	
		}
		return allEvents;
		
	}
	
	// Update Description for a specific event
	
	public List<Event> updateDescription(Integer idEvent, String newDescription) {
		for(Event event : allEvents) {
			if(event.getId() == idEvent) {
				if(newDescription != null)
					event.setLocation(newDescription);
			}	
		}
		return allEvents;
	}
	
	public List<Event> updateDateOfEvent(Integer idEvent, Integer newDay, Integer newMonth, Integer newYear){
		for(Event event : allEvents) {
			if (newDay != null)
				do {
					if(isValidDay(newDay))
						event.setDay(newDay);
				}while (!isValidDay(newDay));
			if (newMonth != null)
				do {
					if(isValidDay(newMonth))
						event.setMonth(newMonth);
				}while (!isValidMonth(newMonth));
//			do {
//				if(isValidYear(newYear)) {
//					event.setYear(newYear);
//				}
//			}while(!isValidYear(newYear));
		}
		return allEvents;
	}
	
	// Update Hour & Minutes Method
	
	// Update Event Status
	
	public List<Event> updateEventStatus(Integer idEvent, String newStatus) {
		for(Event event : allEvents) {
			if(event.getId() == idEvent)
				if(newStatus!=null)
					event.setStatus(newStatus);
		}
		return allEvents;
	}
	
	// Searching for an event in the existing events list - filter : multiple methods 
	
	public List<Event> searchingAnEvent(Integer day, Integer month, Integer year, String theme) {
		List<Event> eventByCriteria = new ArrayList<>(); // The events which are found is stored in this list
		for(Event event : allEvents) {
			if(event.getDay() == day)
				eventByCriteria.add(event);
			if(event.getMonth() == month) {
				
			}
				eventByCriteria.add(event);
			if(event.getYear() == year)
				eventByCriteria.add(event);
			if(event.getTheme() == theme)
				eventByCriteria.add(event);		
		}
		return eventByCriteria;
	}
	
	// Find an event by its Id
	
	public Event findEventById(Integer id) {
		for(Event event : allEvents) {
			if(event.getId().equals(id));
				return event;
		}
		return null;
	}

	// Cancel an Event and the relative reservations 
	
	public List<Event> eventCancellation(Integer idEvent) {
		for(Event event : allEvents) {
			if(event.getId() == idEvent) {
				reservationServices.deleteReservationsByEventId(idEvent);
			}
			removeEvent(idEvent);
			break;
		}
		return allEvents;
	}
	
	//This method allows the Employee to delete an Event
	
	public List<Event> deleteEvent(Integer idEvent, Integer idEmployee) {
		for (Employee employee : employeeServices.getAllEmployees()) {
			if (idEmployee == employee.getId()) {
				for (Event event : allEvents) {
					if (event.getId() == idEvent) {
						removeEvent(idEvent);
					}
				}
			}
		}
		return allEvents;
	}
	
	// A method for searching only the available events (< max capacity)
	
	public void searchingAvailableEvents(Integer idReservation, Integer maxCapacity) {
		List<Event> availableEvents = new ArrayList<>();
		for(Event event : allEvents) {
			if(reservationServices.reservationsByEvent(idReservation) < maxCapacity) 
				availableEvents.add(event);
		}
	}

	// Partcipants of a specific event
	
	public List<Visitor> participantsOfAnEvent(Integer idVisitor, Event event) {
		List<Visitor> participants = new ArrayList<>();
		for(Visitor visitor : visitorServices.getVisitors()) {
			if(visitor.getId() == idVisitor) {
				if(reservationServices.visitorIsParticipant(visitor, event))
					participants.add(visitor);
			}			
		}
		return participants;	
	}
	
	   
		// Booking an Event
		// This method allows a visitor to book an event by their IDs , it checks if the
		// reservation already exists and creates a new one if not.
		public List<Reservation> bookingAnEvent(Integer visitorId, Integer eventId) {
			for (Visitor visitor : visitorServices.getAllVisitors()) {
				if (visitor.getId() == visitorId)
					for (Event event : allEvents) {
						if (event.getId() == eventId && reservationServices.visitorHasMadeARes(visitor,event) && event.getStatus().equals("Accepted")) {
							reservationServices.addReservation(visitor, event);
						}
					}
			}
			return reservationServices.getReservations();
		}
		
		public Event createAnEvent(String title, String theme, String description, String location, Integer maxCapacity, Integer day, Integer month, Integer year, Integer hour, Integer minutes, String duration,Organizer organizer) {
			Event event = new Event(title, theme, description, location, maxCapacity, day, month, year, hour, minutes, duration, organizer);
			addEvent(event);
			return event;
		}
		
}


