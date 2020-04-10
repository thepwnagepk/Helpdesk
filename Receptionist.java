
/**
 * Subclass / child of Staff, similar to Admin but has to be distinct
 *
 * @author Thomas Parker
 * @version 1
 */
public class Receptionist extends Staff
{
    

    /**
     * Constructor for objects of class Receptionist
     * @param ID - Unique ID for the Admin or Receptionist
     * @param name - this is the name of the account holder
     * @param username - username used to log into the account
     * @param password - password used to log into the account
     */
    public Receptionist(int ID, String name,String username, String password)
    {
        super(ID, name, username, password);
      
    }

   
}
