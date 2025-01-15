package com.GTGH_team2.Organizers;

import com.GTGH_team2.Events.Event;
import com.GTGH_team2.Users.User;

public class Organizer extends User{
    private String afm;
    private String description;
    private Event events;

    public Organizer(String afm, String name, String surname, String description) {
    	super(name, surname, null); 
        this.afm = afm;
        this.description = description;
    }

	public String getAfm() {
	     return afm;
	}
	
	public void setAfm(String afm) {
		this.afm = afm;
	}


    public Event getEvents() {
		return events;
	}

	public void setEvents(Event events) {
		this.events = events;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
        return description;
    }


}

