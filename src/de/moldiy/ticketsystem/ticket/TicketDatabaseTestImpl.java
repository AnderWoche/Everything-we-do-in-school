package de.moldiy.ticketsystem.ticket;

import java.util.ArrayList;

public class TicketDatabaseTestImpl extends TicketDatabase {
	
	private ArrayList<Ticket> tickets = new ArrayList<Ticket>();

	@Override
	public Ticket findTicket(String title) {
		for(Ticket t : tickets) {
			if(t.getTitle().equals(title)) {
				return t; 
			}
		}
		return null;
	}

	@Override
	public Ticket findTicket(int id) {
		for(Ticket t : tickets) {
			if(t.getId() == id) {
				return t; 
			}
		}
		return null;
	}

	@Override
	public void addTicket(Ticket ticket) {
		this.tickets.add(ticket);
	}

	@Override
	public void removeTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTicket(int id) {
		this.tickets.remove(this.findTicket(id));
	}

}
