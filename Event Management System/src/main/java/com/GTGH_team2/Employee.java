package com.GTGH_team2;


public class Employee {
	private String name; //name of the employee
	private String surname; //surname of the employee
	private String email; //email of the employee
	

	// Constructor
	public class Employee extends User {
	    public Employee(String name, String surname, String email) {
	        super(name, surname, email);
	        }
	
	public void approveEvent(Event event) {
	    if (event.getStatus().equals("Pending")) {
	    	event.setStatus("Approved");
	        System.out.println("Event : " + event.getTitle() + " has been approved.");
	        } 
	    else {
	         System.out.println("Event: " + event.getTitle() + " is already " + event.getStatus() + ".");
		    }
	}
	
	public void rejectEvent(Event event) {
	    if (event.getStatus().equals("Pending")) {
	    	event.setStatus("Rejected");
	        System.out.println("Event : " + event.getTitle() + " has been rejected.");
	        } 
	    else {
         System.out.println("Event: " + event.getTitle() + " is already " + event.getStatus() + ".");
	    }
	}
	
	public void deleteEvent(String title) {
		 if (Event.deleteEvent(title)) {
	        System.out.println("Event : " + title + " has been deleted by Employee " + name + " " + surname + ".");
	    } else {
	        System.out.println("Event not found.");
	    }
    }
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", surname=" + surname + ", email=" + email + "]";
	}
	
	
}
