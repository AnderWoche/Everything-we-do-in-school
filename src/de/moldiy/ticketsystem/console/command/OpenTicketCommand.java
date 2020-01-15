package de.moldiy.ticketsystem.console.command;

import de.moldiy.ticketsystem.main.TicketSystem;
import de.moldiy.ticketsystem.ticket.Ticket;

@ExecuteCommand({"open"})
public class OpenTicketCommand extends CommandExecuter {
	
	public OpenTicketCommand() {
		super.setComandDescription("open <TicketTitle / TicketID>");
	}

	@Override
	public void executeComand(String[] args) {
		if(args == null) {
			System.out.println("incorrect arguments. "+ getComandDescription());
			return;
		}
			Ticket ticket;
			try {
				int ticketID  = Integer.parseInt(args[0]);
				ticket = TicketSystem.getTicketDataBase().findTicket(ticketID);
			} catch (NumberFormatException e) {
				ticket = TicketSystem.getTicketDataBase().findTicket(args[0]);
			}
			if(ticket != null) {
				System.out.println(ticket.toString());
			} else {
				System.out.println("Ticket don't exist!");
			}
	}

}
