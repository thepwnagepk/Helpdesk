
/**
 * Inheriting all but updateNotes from Actions, this houses all the Updates that will go into the HashMap in Tickets
 *
 * @author Thomas Parker
 * @version 1
 */
public class Updates extends Actions
{
    String updateNotes;
    /**
     * Constructor for objects of class Updates
     * @param actionID - a Unique ID for the Update 
     * @param date - Houses a typed in date as a string, gives license to choose the format
     * @param time - The time the update was entered
     * @param receptionistID - The receptionist giving the updates
     * @param updateNotes - Notes on the what the update entails
     */
    public Updates(int actionID, String date, String time,String receptionistID, String updateNotes )
    {
        super(actionID,date,time,receptionistID);
        this.updateNotes = updateNotes; 
    }

}
