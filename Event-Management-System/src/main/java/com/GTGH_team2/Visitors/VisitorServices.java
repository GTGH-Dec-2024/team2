package com.GTGH_team2.Visitors;

	import java.util.ArrayList;
	import java.util.List;

import org.springframework.stereotype.Service;

	@Service
	public class VisitorServices {
		
	    private List<Visitor> visitors = new ArrayList<Visitor>();

	    public List<Visitor> getVisitors() {
			return visitors;
		}

		public List<Visitor> getAllVisitors() {
	        return visitors;
	    }

	    public List<Visitor> addVisitor(Visitor visitor) {
	        visitors.add(visitor);
	        return visitors;
	    }
	    
	   
	    public List<Visitor> removeVisitor(Integer id) {
	    	visitors.removeIf(visitor -> visitor.getId() == id);
	//    	reservationServices.deleteReservationsByVisitorId(id);//remove reservations of visitor
	        return visitors;
	    }
	  
	    public List<Visitor> updateVisitor(Integer id, String newName, String newSurname, String newEmail) {
	        for (Visitor visitor : visitors) {
	            if (id == visitor.getId()) {
	                if (newName != null)
	                	visitor.setName(newName);
	                if (newSurname != null) 
	                	visitor.setSurname(newSurname);
	                if (newEmail != null)
	                	visitor.setEmail(newEmail);
	            }
	        }
	        return visitors;
	    }

		public List<Visitor> addVisitors(List<Visitor> visitorList) {
			for(Visitor visitor : visitorList) {
				this.addVisitor(visitor);
			}
			return visitors;
		}
	    
	    	    
	}
