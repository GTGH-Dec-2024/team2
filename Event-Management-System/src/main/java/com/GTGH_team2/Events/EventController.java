package com.GTGH_team2.Events;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // Set the class as a rest controller 
@RequestMapping("/events") // The Path
public class EventController {
	
	@Autowired 
	EventServices eventServices;
	
	@GetMapping("/all")
	public List<Event> getAllEvents() {
		return eventServices.getAllEvents();
	}
	
	@PostMapping("/addEvent")
	public List<Event> addEvent(@RequestBody Event event) {
		eventServices.addEvent(event);
		return eventServices.getAllEvents();
	}
	
	@DeleteMapping("/deleteEvent")
	public List<Event> deleteEvent(@RequestParam Integer id) {
		eventServices.removeEvent(id);
		return eventServices.getAllEvents();
	}
	
	@PutMapping("/Update")
	public List<Event> updateEvent(@RequestParam int id, @RequestParam String newTitle, @RequestParam String newTheme,@RequestParam  String newDescription,@RequestParam  String newLocation, @RequestParam int newMaxCapacity, @RequestParam String newDay, String newMonth, @RequestParam int newYear, @RequestParam int newHour, @RequestParam int newMinute,@RequestParam  String newDuration){
		eventServices.updateEvent(id, newTitle, newTheme, newDescription, newLocation, newMaxCapacity, newDay, newMonth, newYear, newHour, newMinute, newDuration);
		return eventServices.getAllEvents();
	}
	
	
	
}
