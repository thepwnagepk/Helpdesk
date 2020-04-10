import java.util.HashMap;
/**
 * Parent / Super class of GeneralTicket and ITTicket
 *
 * @author Thomas Parker
 * @version 1
 */
abstract class Ticket implements java.io.Serializable
{
    private HashMap<Integer , Actions> actions;//(hashmap with ACTION ID and actions)
    int ticketID;
    String date;
    String time;
    String receptionistID;
    String details;
    boolean isClosed = false; //doesnt need this in the constructor since it will always be false when its created
    

    /**
     * Constructor for objects of class Ticket
     * @param ticketID - Unique ID for the Ticket
     * @param date - The date the ticket was created
     * @param time - The tiem the ticket was created
     * @param receptionist - The receptionist creating the ticket
     * @param details - The details of the ticket
     */
    public Ticket(int ticketID, String date, String time, String receptionistID, String details)
    {
        actions = new HashMap<Integer , Actions>();
        
        this.date = date;
        this.time = time;
        this.receptionistID = receptionistID;
        this.details = details;
        this.ticketID = ticketID;
    }
    
    public String viewTicket()
    {
        return "Ticket ID: " + ticketID + "\n" + "Date: " + date + "\n" + "Time: " + time + "\n" + "Receptionist: " + receptionistID + "\n" + "Details: " + details;
        
    }
    
    public int getID()
    {
        return ticketID;
        
    }
    
    public String getDate()
    {
        return date;
        
    }
    
    public String getTime()
    {
        return time;
        
    }
    
    public String getReceptionistID()
    {
        return receptionistID;
        
    }
    
    public String getDetails()
    {
        return details;
        
    }
    
    /**
     * @param newID - a string that holds the unique ID of the ticket
     */
    public int setID(int newID)
    {
        ticketID = newID;
        return ticketID;
        
    }
    
    /**
     * @param newDate - a string that holds the date fo the ticket's creation
     */
    public String setDate(String newDate)
    {
        date = newDate;
        return date;
        
    }
    
    /**
     * @param newTime - a string that holds the time of the ticket's creation
     */
    public String setTime(String newTime)
    {
        time = newTime;
        return time;
        
    }
    
    /**
     * @param newReceptionistID - a string that holds the receptionist who made the ticket
     */
    public String setReceptionist(String newReceptionistID)
    {
        receptionistID = newReceptionistID;
        return receptionistID;
        
    }
    
    /**
     * @param newDetails - a string that holds the details of the ticket
     */
    public String setDetails(String newDetails)
    {
        details = newDetails;
        return details;
        
    }
    
    public int nextActionID(){
        
            for (int i = 1; i <= actions.size(); i++)
            {
                if (!actions.containsKey(i)){
                    
                    return i;
            }
        
        
         }
        
        return -1;
    }
    
    /**
     * @param newUpdate - the update that is to be passed into the hashmap, of class Updates
     */
    public boolean addUpdate(Updates newUpdate)
    {
        if(isClosed == false) {
                    actions.put(newUpdate.getID() ,newUpdate);
                    return true;
        }
        return false;
    }
    
    /**
     * @param newResolution - the resolution that is to be passed into the hashmap, of class Resolution
     */
    public boolean addResolution(Resolutions newResolution)
    {
        if(isClosed == false) {
            
                    actions.put(newResolution.getID() ,newResolution);
                    isClosed = true;
                    return true;
            
        }
        return false;
    }
    
    
    //Edit/Resolve open tickets : 

}

