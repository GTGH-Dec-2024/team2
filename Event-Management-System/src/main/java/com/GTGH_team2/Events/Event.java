package com.GTGH_team2.Events;

import org.springframework.beans.factory.annotation.Autowired;

import com.GTGH_team2.Organizers.Organizer;
import com.GTGH_team2.Organizers.OrganizerServices;

public class Event {
	
	@Autowired
	OrganizerServices organizerServices;
	
	private static int nextId = 1; // Initializing the counter for auto-uncrementing IDs
	private int id;
    private String title;
    private String theme;
    private String description;
    private String location;
    private int maxCapacity;
    private String day;
    private String month;
    private Integer year;
    private int hour;
    private int minutes;
    private String duration;
    private Organizer organizer;
    private String status;

    public Event(String title, String theme, String description, String location, int maxCapacity, String day, String month, Integer year, Integer hour, int minutes, String duration,Integer idOrganizer, String status) {
        this.title = title;
        this.theme = theme;
        this.description = description;
        this.location = location;
        this.maxCapacity = maxCapacity;
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.minutes = minutes;
        this.duration = duration;
        this.organizer = organizerServices.findOrganizerById(idOrganizer);
        this.status = status;
        this.id = nextId;
        
    }
   
    // Setters & Getters

    public int getId() {
		return id;
	}
    
	public String getTitle() {
		return title;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		switch(day) {
		case "Monday":
		case "Tuesday":
		case "Wednesday":
		case "Thursday" :
		case "Friday" :
		case "Saturday":
		case "Sunday":
			this.day = day;
		default:
			System.out.println("No valid day");
		}
		
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer newYear) {
		this.year = newYear;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Organizer getOrganizer() {
		return organizer;
	}

	public void setOrganizer(Organizer organizer) {
		this.organizer = organizer;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	
    @Override
    public String toString() {
        return  "Id: " + id +
        		"Event title: " + title  +
                "\nTheme: " + theme +
                "\nDescription: " + description  +
                "\nLocation: " + location +
                "\nMax Capacity: " + maxCapacity +
                "\nDay: " + day +
                "\nMonth: " + month +
                "\nYear: " + year  +
                "\nHour: " + hour +
                "\nMinutes: " + minutes +
                "\nDuration: " + duration  +
                "\nOrganizer: " + organizer +
                "\nStatus: " + status;
    }
    
	
}

