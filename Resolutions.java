
/**
 * Inheriting all but Rdetails from Actions, this houses all the Updates that will go into the HashMap in Tickets
 *
 * @author Thomas Parker
 * @version 1
 */
public class Resolutions extends Actions
{
    String Rdetails;
    /**
     * Constructor for objects of class Resolutions
     * @param actionID - a Unique ID for the Resolution
     * @param date - Houses a typed in date as a string, gives license to choose the format
     * @param time - The time the update was entered
     * @param receptionistID - The receptionist giving the updates
     * @param Rdetails - Details on how the ticket is Resolved
     */
    public Resolutions(int actionID, String date, String time,String receptionistID, String Rdetails)
    {
        super(actionID,date,time,receptionistID);
        this.Rdetails = Rdetails; 
    }

}
