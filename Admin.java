
/**
 * Subclass / child of Staff, similar to Receptionist but has to be distinct
 *
 * @author Thomas Parker
 * @version 1
 */
public class Admin extends Staff
{
    

    /**
     * Constructor for objects of class Admin
     * @param ID - Unique ID for the Admin or Receptionist
     * @param name - this is the name of the account holder
     * @param username - username used to log into the account
     * @param password - password used to log into the account
     */
    public Admin(int ID, String name,String username, String password)
    {
      super(ID, name, username, password);
      
    }

   
}
