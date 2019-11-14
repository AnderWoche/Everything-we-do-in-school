package de.moldiy.ticketsystem.ticket;


public class Ticket {
	
	private String title;
	private int id;
	
	private String inhalt;
	
	public Ticket(int id, String title, String inhalt) {
		this.id = id;
		this.inhalt = inhalt;
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInhalt() {
		return inhalt;
	}

	public void setInhalt(String inhalt) {
		this.inhalt = inhalt;
	}

	@Override
	public String toString() {
		return "Ticket [title=" + title + ", id=" + id + ", inhalt=" + inhalt + "]";
	}
	
	

}
