
/**
 * IT Tickets are like general tickets, but shows who reported the incident and any IT Equipment affected by the incident. Inherited from Ticket.
 *
 * @author Thomas Parker
 * @version 1
 */
public class ITTicket extends Ticket
{
    String reportedBy;
    String ITEquipmentAffected;

    /**
     * Constructor for objects of class ITTicket
     * @param ticketID - Unique ID for the Ticket
     * @param date - The date the ticket was created
     * @param time - The tiem the ticket was created
     * @param receptionist - The receptionist creating the ticket
     * @param details - The details of the ticket
     * @param reportedBy - The person reporting the incident that created the ticket
     * @param ITEquipmentAffected - Any IT Equipment affected by the incident
     */
    public ITTicket(int ticketID, String date, String time, String receptionist, String details,String reportedBy ,String ITEquipmentAffected )
    {
        super(ticketID,date,time,receptionist,details);
      this.reportedBy = reportedBy;
      this.ITEquipmentAffected = ITEquipmentAffected;
    }

    public String viewTicket()
    {
        
        return super.viewTicket() + "\n" + "Reported By; " + reportedBy + "\n" + "IT Equipment Affected: " + ITEquipmentAffected;
    }
    
    public String getReportedBy()
    {
        return reportedBy;
        
    }
    
    public String getITEquipmentAffected()
    {
        
        return ITEquipmentAffected;
        
    }
    
    /**
     * @param newReportedBy - a string that holds who reported the incident
     */
    public String setReportedBy(String newReportedBy)
    {
        reportedBy = newReportedBy;
        return reportedBy;
        
    }
    
    /**
     * @param newITEquipmentAffected - a string that holds the IT Equipment affected
     */
    public String setITEquipmentAffected(String newITEquipmentAffected)
    {
        ITEquipmentAffected = newITEquipmentAffected;
        return ITEquipmentAffected;
        
    }
}
