package de.moldiy.ticketsystem.console.command;

/**
 * Extends this class and set the proteted Methods
 * @author humann
 *
 */
public abstract class CommandExecuter {

	private String command = null;
	
	private String comandDescription = "";
	
	public CommandExecuter(String command) {
		this.command = command;
	}
	
	public abstract void executeComand(String[] args);
	
	protected void setComandDescription(String s) {
		this.comandDescription = s;
	}
	
	public String getComandDescription() {
		return this.comandDescription;
	}
	
	public String getCommand() {
		return this.command;
	}
}
