
/**
 * General Tickets, not IT Tickets. Inherited from Ticket
 *
 * @author Thomas Parker
 * @version 1
 */
public class GeneralTicket extends Ticket
{

    /**
     * Constructor for objects of class GeneralTicket
     * @param ticketID - Unique ID for the Ticket
     * @param date - The date the ticket was created
     * @param time - The tiem the ticket was created
     * @param receptionist - The receptionist creating the ticket
     * @param details - The details of the ticket
     */
    public GeneralTicket(int ticketID, String date, String time, String receptionist, String details)
    {
        super(ticketID, date,time,receptionist,details);
      
    }

    public String viewTicket()
    {
        
        return super.viewTicket();
    }
}

