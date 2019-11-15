package de.moldiy.ticketsystem.ticket;

public abstract class TicketDatabase {
	
	public abstract Ticket findTicket(String name);
	
	public abstract Ticket findTicket(int  id);
	
	public abstract void addTicket(Ticket ticket);
	
	public abstract void removeTicket(Ticket ticket);
	
	public abstract void removeTicket(int id);

}
