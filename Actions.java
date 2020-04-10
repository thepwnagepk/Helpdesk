
/**
 * The Parent / Super class of Resolutions and Updates, holding the variables and methods relevant to both.
 *
 * @author Thomas Parker
 * @version 1
 */
abstract class Actions implements java.io.Serializable
{
    int actionID;
    String date;
    String time;
    String receptionistID;
    
    

    /**
     * Constructor for objects of class Actions
     * 
     * @param actionID - a Unique ID for the Update or Resolution
     * @param date - Houses a typed in date as a string, gives license to choose the format
     * @param time - The time the update was entered
     * @param receptionistID - The receptionist giving the updates     * 
     */
    
    public Actions(int actionID, String date, String time,String receptionistID)
    {
        this.actionID = actionID;
        this.date = date;
        this.time = time;
        this.receptionistID = receptionistID;
        
    }
    
    public int getID(){
        return actionID;
    }
    
    
}
