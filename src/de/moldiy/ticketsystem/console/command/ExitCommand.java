package de.moldiy.ticketsystem.console.command;

public class ExitCommand extends CommandExecuter {

	public ExitCommand() {
		super("exit");
	}
	
	@Override
	public void executeComand(String[] args) {
		System.exit(0);
	}

}
