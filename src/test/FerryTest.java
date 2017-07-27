package test;

import model.Ferry;
import model.Passenger;
import model.Ticket;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FerryTest {

    private Ferry testFerry;
    private int testPrice;
    private Date testDate;

    @Before
    public void setUp() {
        testPrice = 20;
        testDate = new Date();
        testFerry = new Ferry("Nanaimo", testDate, testPrice);
    }

    @Test
    public void testFerryConstructor() {
        assertEquals(testFerry.getDestination(), "Nanaimo");
        assertEquals(testFerry.getSailingDate(), testDate);
        assertEquals(testFerry.getTicketPrice(), testPrice);
        assertTrue(testFerry.getTicketSet().isEmpty());
    }

    @Test
    public void testAddTicket() {
        Passenger testPassenger = new Passenger("Bruce Wayne");
        Ticket testTicket = new Ticket(testFerry, testPassenger);
        testFerry.addTicket(testTicket);
    }


}
