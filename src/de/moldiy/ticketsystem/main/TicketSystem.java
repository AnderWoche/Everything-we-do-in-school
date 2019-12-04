package de.moldiy.ticketsystem.main;

import de.moldiy.ticketsystem.console.ConsoleControl;
import de.moldiy.ticketsystem.console.command.ContactCommand;
import de.moldiy.ticketsystem.console.command.DiceThrowCommand;
import de.moldiy.ticketsystem.console.command.ExitCommand;
import de.moldiy.ticketsystem.console.command.OpenTicketCommand;
import de.moldiy.ticketsystem.ticket.TicketDatabase;
import de.moldiy.ticketsystem.ticket.TicketDatabaseTestImpl;

public class TicketSystem {
	
	private static ConsoleControl console;
	private static TicketDatabase ticketbase;
	
	public TicketSystem() {
		TicketSystem.console = new ConsoleControl();
		TicketSystem.ticketbase = new TicketDatabaseTestImpl();
		
		TicketSystem.console.registerCommand(new ExitCommand());
		TicketSystem.console.registerCommand(new OpenTicketCommand());
		TicketSystem.console.registerCommand(new ContactCommand());
		TicketSystem.console.registerCommand(new DiceThrowCommand());
	}
	
	public static ConsoleControl getConsole() {
		return TicketSystem.console;
	}
	
	public static TicketDatabase getTicketDataBase() {
		return TicketSystem.ticketbase;
	}

}
