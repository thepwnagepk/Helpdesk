
/**
 * Parent / Superclass of Student and Staff
 *
 * @author Thomas Parker
 * @version 1
 */
abstract class Person implements java.io.Serializable
{
    int ID;
    String name;
    
    /**
     * Constructor for objects of class Person
     * @param ID - Unique ID for the Admin or Receptionist
     * @param name - this is the name of the account holder
     */
    public Person(int ID, String name)
    {
        this.ID = ID;
        this.name = name;
        
    }
    
    public int getID()
    {
        return ID;
    }
    
      
    public String getName()
    {
        return name;
    }
    
    public int setID(int newID)
    {
        ID = newID;
        return ID;
    }
    
    /**
     * @param newName - a string that holds the name to be set
     */  
    public String setName(String newName)
    {
        name = newName;
        return name;
    }
    
    public String ToString()
    {
       return Integer.toString(ID);
    }
    
}

