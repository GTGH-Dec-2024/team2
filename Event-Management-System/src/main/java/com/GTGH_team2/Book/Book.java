package com.GTGH_team2.Book;

import com.GTGH_team2.Events.Event;
import com.GTGH_team2.Visitors.Visitor;

// Class Book is an entity created for the event booking from a visitor

public class Book {
	private Visitor visitor;
	private Event event;
	private String Date;
	
	public Visitor getVisitor() {
		return visitor;
	}
	public void setVisitor(Visitor visitor) {
		this.visitor = visitor;
	}
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	@Override
	public String toString() {
		return "The visitor: " + visitor.getName() + " booked the event " + event.getTitle();
	}
	
}
