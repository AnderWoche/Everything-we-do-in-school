package de.moldiy.ticketsystem.ticket;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TicketDataBaseTest {

	public static TicketDatabase dataBase;
	public static Ticket testTicket;

	@BeforeAll
	public static void init() {
		TicketDataBaseTest.dataBase = new TicketDatabaseTestImpl();
		testTicket = new Ticket(1, "testTitle", "text");
		assertNotNull(testTicket);
		TicketDataBaseTest.dataBase.addTicket(testTicket);
	}

	@Test
	public void findTicketByIDTest() {
		Ticket t = TicketDataBaseTest.dataBase.findTicket(testTicket.getId());
		System.out.println(t.getId());
		if(TicketDataBaseTest.testTicket != t) {
			Assert.fail();
		}
		assertEquals(testTicket, t);
		
		t = TicketDataBaseTest.dataBase.findTicket(Integer.MAX_VALUE);
		assertNull(t);
	}

	@Test
	public void findTicketByStringTest() {
		Ticket t = TicketDataBaseTest.dataBase.findTicket("testTitle");
		assertEquals("testTitle", t.getTitle());
		
		t = TicketDataBaseTest.dataBase.findTicket("edhgkldfglsflhsrfdlkviokjabg");
		assertNull(t);
	}
	
	@Test
	public void removeTicketBy() {
		TicketDataBaseTest.dataBase.removeTicket(1);
		
		Ticket t = TicketDataBaseTest.dataBase.findTicket(1);
		
		assertNull(t);
	}
	
	@Test
	public void removeTicketByString() {
		TicketDataBaseTest.dataBase.removeTicket(TicketDataBaseTest.testTicket.getId());
		
		assertNull(TicketDataBaseTest.dataBase.findTicket(TicketDataBaseTest.testTicket.getId()));
	}
	
}
