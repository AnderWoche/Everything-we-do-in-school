package de.moldiy.ticketsystem.main;

import de.moldiy.ticketsystem.ticket.Ticket;

public class Main {
	
	public static void main(String[] args) {
		TicketSystem system = new TicketSystem();
		
		TicketSystem.getTicketDataBase().addTicket(new Ticket(1, "testTicket", "inhalt"));
		
	}

}
