package de.moldiy.ticketsystem.console.command;

import de.moldiy.ticketsystem.main.TicketSystem;
import de.moldiy.ticketsystem.ticket.Ticket;

@ExecuteCommand({"contact"})
public class ContactCommand extends CommandExecuter {

	public ContactCommand() {
		super.setComandDescription("contact <ticketName> <betreff> <Nachricht>");
	}

	@Override
	public void executeComand(String[] args) {
		if(args == null) {
			System.out.println("incorrect arguments. "+ getComandDescription());
			return;
		}
		if (args.length == 3) {
			Ticket ticket;
			try {
				int ticketID = Integer.parseInt(args[0]);
				ticket = TicketSystem.getTicketDataBase().findTicket(ticketID);
			} catch (NumberFormatException e) {
				ticket = TicketSystem.getTicketDataBase().findTicket(args[0]);
			}
			if (ticket == null) {
				System.out.println("ticket exestiert nicht!");
			}
			System.out.println("Nachrich wurde versendet");
		}

	}

}
