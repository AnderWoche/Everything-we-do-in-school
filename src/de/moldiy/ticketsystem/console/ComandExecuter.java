package de.moldiy.ticketsystem.console;

public abstract class ComandExecuter {
	
	
	private String comandDescription = "";
	
	public abstract void executeComand(String[] args);
	
	public void setComandDescription(String s) {
		this.comandDescription = s;
	}
	
	public String getComandDescription() {
		return this.comandDescription;
	}
}
