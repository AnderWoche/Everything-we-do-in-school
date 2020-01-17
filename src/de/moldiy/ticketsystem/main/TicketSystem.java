package de.moldiy.ticketsystem.main;

import de.moldiy.ticketsystem.console.ConsoleControl;
import de.moldiy.ticketsystem.console.command.ContactCommand;
import de.moldiy.ticketsystem.console.command.DiceThrowCommand;
import de.moldiy.ticketsystem.console.command.ExitCommand;
import de.moldiy.ticketsystem.console.command.FibonacciCommand;
import de.moldiy.ticketsystem.console.command.OpenTicketCommand;
import de.moldiy.ticketsystem.console.command.Sieb_des_EratosthenesCommand;
import de.moldiy.ticketsystem.console.command.ein_dim_arrays.CommandDieZweiGroessten;
import de.moldiy.ticketsystem.console.command.ein_dim_arrays.CommandDreiSummen;
import de.moldiy.ticketsystem.console.command.ein_dim_arrays.CommandDreiSummen2;
import de.moldiy.ticketsystem.console.command.ein_dim_arrays.Glaetten;
import de.moldiy.ticketsystem.console.command.zwei_dim_arrays.Kleine1x1eins;
import de.moldiy.ticketsystem.console.command.zwei_dim_arrays.Kundendaten;
import de.moldiy.ticketsystem.console.command.zwei_dim_arrays.ZweiDArrayVerwaltungsProgramm;
import de.moldiy.ticketsystem.console.command.zwei_dim_arrays.ZweiDArraySumme;
import de.moldiy.ticketsystem.ticket.TicketDatabase;
import de.moldiy.ticketsystem.ticket.TicketDatabaseTestImpl;

public class TicketSystem {
	
	private static ConsoleControl console;
	private static TicketDatabase ticketbase;
	
	public TicketSystem() {
		TicketSystem.console = new ConsoleControl();
		TicketSystem.ticketbase = new TicketDatabaseTestImpl();
		
		TicketSystem.console.registerCommand(new ExitCommand());
		TicketSystem.console.registerCommand(new ZweiDArraySumme());
		TicketSystem.console.registerCommand(new OpenTicketCommand());
		TicketSystem.console.registerCommand(new ContactCommand());
		TicketSystem.console.registerCommand(new DiceThrowCommand());
		TicketSystem.console.registerCommand(new Sieb_des_EratosthenesCommand());
		TicketSystem.console.registerCommand(new FibonacciCommand());
		
		TicketSystem.console.registerCommand(new CommandDreiSummen());
		TicketSystem.console.registerCommand(new CommandDreiSummen2());
		TicketSystem.console.registerCommand(new CommandDieZweiGroessten());
		TicketSystem.console.registerCommand(new Glaetten());
		TicketSystem.console.registerCommand(new ZweiDArrayVerwaltungsProgramm());
		TicketSystem.console.registerCommand(new Kleine1x1eins());
		TicketSystem.console.registerCommand(new Kundendaten());
	}
	
	public static ConsoleControl getConsole() {
		return TicketSystem.console;
	}
	
	public static TicketDatabase getTicketDataBase() {
		return TicketSystem.ticketbase;
	}

}
