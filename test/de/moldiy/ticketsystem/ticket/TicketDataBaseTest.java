package de.moldiy.ticketsystem.ticket;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TicketDataBaseTest {

	public TicketDatabase dataBase;
	public Ticket testTicket;

	@BeforeEach
	public void init() {
		this.dataBase = new TicketDatabaseTestImpl();
		testTicket = new Ticket(1, "testTitle", "text");
		assertNotNull(testTicket);
		this.dataBase.addTicket(testTicket);
	}

	@Test
	public void findTicketByIDTest() {
		Ticket t = this.dataBase.findTicket(testTicket.getId());
		System.out.println(t.getId());
		if(this.testTicket != t) {
			Assert.fail();
		}
		assertEquals(testTicket, t);
		
		t = this.dataBase.findTicket(Integer.MAX_VALUE);
		assertNull(t);
	}

	@Test
	public void findTicketByStringTest() {
		Ticket t = this.dataBase.findTicket("testTitle");
		assertEquals("testTitle", t.getTitle());
		
		t = this.dataBase.findTicket("edhgkldfglsflhsrfdlkviokjabg");
		assertNull(t);
	}
	
	@Test
	public void removeTicketBy() {
		this.dataBase.removeTicket(1);
		
		Ticket t = this.dataBase.findTicket(1);
		
		assertNull(t);
	}
	
	@Test
	public void removeTicketByString() {
		this.dataBase.removeTicket(this.testTicket.getId());
		
		assertNull(this.dataBase.findTicket(this.testTicket.getId()));
	}
	
}
