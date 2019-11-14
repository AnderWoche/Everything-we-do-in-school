package de.moldiy.ticketsystem.main;

import de.moldiy.ticketsystem.console.ComandExecuter;
import de.moldiy.ticketsystem.console.ConsoleControl;
import de.moldiy.ticketsystem.ticket.Ticket;

public class Main {
	
	public static TicketSystem ticketsystem = new TicketSystem();
	public static ConsoleControl console = new ConsoleControl();
	
	public static void main(String[] args) {
		
		ticketsystem.addTicket(new Ticket(1, "einTicket", "schrechloicker Inhalt"));
		
		ComandExecuter openCommand = new ComandExecuter() {
			@Override
			public void executeComand(String[] args) {
				if(args == null) {
					System.out.println("befehl falsch: "+ getComandDescription());
				} else {
					Ticket ticket = ticketsystem.findTicket(args[0]);
					if(ticket != null) {
						System.out.println(ticket.toString());
					} else {
						System.out.println("ticket exestiert nicht!");
					}
				}
			}
		};
		openCommand.setComandDescription("open <name des Tickets> (zeigt den inhalt des tickets an)");
		console.registerComand("open", openCommand);
		
		ComandExecuter contactCommand = new ComandExecuter() {
			@Override
			public void executeComand(String[] args) {
				if(args == null) {
					System.out.println("befehl falsch: " + getComandDescription());
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
		};
		contactCommand.setComandDescription("contact <ticketName> <betreff> <Nachricht>");
		console.registerComand("contact", contactCommand);
		
	}

}
