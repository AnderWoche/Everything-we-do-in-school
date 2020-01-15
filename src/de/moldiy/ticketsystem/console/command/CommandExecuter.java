package de.moldiy.ticketsystem.console.command;

/**
 * Extends this class and set the proteted Methods
 * @author humann
 *
 */
public abstract class CommandExecuter {

	private String comandDescription = "";
	
	public CommandExecuter() {
	}
	
	public abstract void executeComand(String[] args);
	
	protected void setComandDescription(String s) {
		this.comandDescription = s;
	}
	
	public String getComandDescription() {
		return this.comandDescription;
	}
}
