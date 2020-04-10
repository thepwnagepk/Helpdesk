
/**
 * Parent / Superclass of Admin and Receptionist
 *
 * @author Thomas Parker
 * @version 1
 */
abstract class Staff extends Person
{
    String username;
    String password;
    
    /**
     * Constructor for objects of class Staff
     * @param ID - Unique ID for the Admin or Receptionist
     * @param name - this is the name of the account holder
     * @param username - username used to log into the account
     * @param password - password used to log into the account
     */
    public Staff(int ID, String name,String username, String password)
    {
        super(ID, name);       
        
        this.username = username;
        this.password = password;
        
    }
    
    public String getUsername()
    {
        return username;
    }
    
      
    public String getPassword()
    {
        return password;
    }
    
    
    /**
     * @param newUsername - a string that holds the username
     */
    public String setUsername(String newUsername)
    {
        return username;
    }
    
      /**
       * @param newPassword - a string that holds the password
       */
    public String setPassword(String newPassword)
    {
        return password;
    }
    
    public String viewStaff()
    {
        String staffInfo = "ID: " + getID() + " Name: " + getName() + " Username: " + getUsername() + " Password: " + getPassword();
        return staffInfo;
    }
}
