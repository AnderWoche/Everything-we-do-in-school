package de.moldiy.ticketsystem.main;

import java.util.ArrayList;


import de.moldiy.ticketsystem.ticket.Ticket;

public class TicketSystem {
	
	private ArrayList<Ticket> tickets = new ArrayList<Ticket>();
	
	public void removeTicket(Ticket ticket) {
		this.tickets.remove(ticket);
	}
	
	public void addTicket(Ticket ticket) {
		this.tickets.add(ticket);
	}
	
	public Ticket findTicket(String title) {
		for(Ticket t : tickets) {
			if(t.getTitle().equals(title)) {
				return t; 
			}
		}
		return null;
	}
	
	public Ticket findTicket(int id) {
		for(Ticket t : tickets) {
			if(t.getId() == id) {
				return t; 
			}
		}
		return null;
	}
	
}
