package de.moldiy.ticketsystem.console.command;

@ExecuteCommand({"exit"})
public class ExitCommand extends CommandExecuter {

	@Override
	public void executeComand(String[] args) {
		System.exit(0);
	}

}
