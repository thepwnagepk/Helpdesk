
/**
 * Child/Subclass of Person, inherits both variables from it
 *
 * @author Thomas Parker
 * @version 1
 */
public class Student extends Person
{
    
    /**
     * Constructor for objects of class Student
     * @param ID - Unique ID for the Admin or Receptionist
     * @param name - this is the name of the account holder
     */
    public Student(int ID, String name)
    {        
        super(ID, name);// inherits ID, name, but doesnt get a username and password for the helpdesk         
    
    }

    
}
