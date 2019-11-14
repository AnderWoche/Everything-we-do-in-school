package de.moldiy.ticketsystem.main;

import de.moldiy.ticketsystem.ComandExecuted;
import de.moldiy.ticketsystem.ConsoleControl;
import de.moldiy.ticketsystem.ticket.Ticket;

public class Main {
	
	public static TicketSystem ticketsystem = new TicketSystem();
	public static ConsoleControl console = new ConsoleControl();
	
	public static void main(String[] args) {
		
		ticketsystem.addTicket(new Ticket(1, "fehler", "schrechloicker inhalt"));
		
		console.registerComand("open", new ComandExecuted() {
			@Override
			public void executeComand(String[] args) {
				if(args == null) {
					System.out.println("befehl falsch: open <name des Tickets>");
				} else {
					Ticket ticket = ticketsystem.findTicket(args[0]);
					if(ticket != null) {
						System.out.println(ticket.toString());
					} else {
						System.out.println("ticket exestiert nicht!");
					}
					
				}
				
			}
		});
		
		console.registerComand("contact", new ComandExecuted() {
			@Override
			public void executeComand(String[] args) {
				if(args == null) {
					System.out.println("befehl falsch: contact <ticketName> <betreff> <Nachricht>");
				} else {
					if(args.length == 3) {
						Ticket ticket = ticketsystem.findTicket(args[0]);
						if(ticket == null) {
							System.out.println("ticket exestiert nicht!");
						}
						System.out.println("Nachrich wurde versendet");
					}
				}
			}
		});
	}

}
