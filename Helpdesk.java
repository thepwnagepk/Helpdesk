import java.io.IOException;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.ArrayList;
/**
* The main class that interacts with all of the other objects for the core functionality of the program
*
* @author Thomas 'PK' Parker
* @version 1
*/
public class Helpdesk
{
    private HashMap<Integer, Ticket> tickets; // key is integer for unique sequential ID's for easy comparison holds Ticket objects
    public HashMap<Integer, Staff> staff; // key is integer for unique sequential ID's for easy comparison holds Staff objects
    private HashMap<Integer, Student> students; // key is integer for unique sequential ID's for easy comparison holds Student objects
    private Database accountsDatabase;// instance of Database
    HashMap[] maps = new HashMap[3];//hashmap array to store what returns from the database.load() function
  

    /**
     * Creates/initialises the 3 Hashmaps for Tickets, Staff and Students, the Initialises the Database 
     */
    public Helpdesk() throws IOException, ClassNotFoundException
    {        
       tickets = new HashMap<Integer, Ticket>();
       staff = new  HashMap<Integer, Staff>();
       students = new  HashMap<Integer, Student>();
        
       accountsDatabase = new Database(tickets, staff, students);
       //loadFromDatabase();       
    }

    /**    
      * Checks if the userInput matches the username variable of the Staff object it retrieves, if it does it checks the password the same way, if not just iterates again
     * @param  String userInput  username input from CLI
     * @param  String passInput password input from CLI
     * @return  int  1 for admin interface, 2 for general [receptionist] interface, or -1, for errors and/or allows users to retry
     */
    public int loginchecker(String userInput, String passInput)     
    {
              
        // get staff via the key which should be an int based on the loop recur number, 
        //check if userInput matched username of the staff, until it does, then match password
        for (int i = 1; i < staff.size()+1; i++){
            if (staff.containsKey(i))
        {
            //System.out.println("ID " + i + " is in the database"); // for testing
            Staff currentStaff = staff.get(i);
            if (currentStaff.getUsername().equals(userInput)){
            System.out.println("Username matches");
                if (currentStaff.getPassword().equals(passInput))
                {
                    System.out.println("Password matches");
                    if (currentStaff instanceof Receptionist)
                    {
                       System.out.println("You are a receptionist");
                    
                       return 1;
                    }else{
                    System.out.println("You are an admin");
                
                        return 2;
                    }
                }
                else{
                System.out.println("Password didnt match");
                }
            
            
            }else{
                
            }
        }
        
      }
        return -1;
    }
    
    /**
     * @param searchID - an int used to search the HashMap for that ID
     */
    public String searchStaff(int searchID ){
        for (int i = 1; i < staff.size()+1; i++){
                if (staff.containsKey(searchID))
                {
                    System.out.println("ID " + searchID + " is in the database");
                    Staff searchedStaff = staff.get(searchID);
                    return searchedStaff.viewStaff();
                }
            }
            return "ID isnt in the database";
    }
    
    /**
     * @param staff2 - a Staff object to be added into the HashMap of Staff
     */
    public boolean addStaff(Staff staff2)
    {
        if (!staff.containsKey(staff2.getID())) 
        {
            staff.put(staff2.getID(), staff2);
            return true;
        }
        return false;
    }
    
    /**
     * @return allStaff - a String that has all the info of each Staff object in the HashMap concatenated together
     */
    public String viewAllStaff()
    {
        String allStaff = "";        
        for (int i = 1; i < staff.size()+1; i++){            
            allStaff = allStaff + "\n" + staff.get(i).viewStaff();     
        
        }        
        return allStaff;
    }
    
    
    /**
     * @param editChoice2 - an int used for the switch case evaluation
     * @param editID - an int used to search the database for that ID
     * @param editValue - a String of the value to set either the name, username or password to
     */    
    public void editUser(int editChoice2, int editID, String editValue) 
    {
               
        switch(editChoice2){       
                
                case 1://name
                staff.get(editID).setName(editValue);
                break;
                case 2://username
                staff.get(editID).setUsername(editValue);
                break;
                case 3://password
                staff.get(editID).setPassword(editValue);
                break;
            }
        
        
    }
    
    /**
     * @param editID - an int used to search the database for that ID
     * @return Staff object gotten through the HashMap method get()
     */    
    public Staff getStaff(int editID) 
    {
        return staff.get(editID);
        
    }
    
    /**
     * @param deleteStaff - an int used to search the database for that ID of the staff to be deleted
     */    
    public void deleteStaff(int deleteStaff) 
    {              
        staff.remove(deleteStaff);       
        
    }
    
    /**
     * @return int equal to either the number in the loop where the next number isnt in the HashMap as a key, or the size of the HashMap + 1
     */  
    public int nextEmptyID() 
    {
        for (int i = 1; i <= staff.size(); i++)
        {
            if (!staff.containsKey(i)){
                return i;
                
            }
            
        }
        return staff.size()+1; //returns the number of indexes, +1
    }
    
    //everything below here is ticket methods.
    /**
     * @param ticket - a Ticket objectt to be stored in the HashMap
     * @return boolean just to see if it went in or not
     */  
    public boolean addTicket(Ticket ticket)
    {
        if (!tickets.containsKey(ticket.getID())) //makes sure the HashMap doesnt have the Key which is the ID of the ticket
        {
            tickets.put(ticket.getID(), ticket); //put the ticket in the HashMap with the key of its ID, and the ticket object itself
            return true;
        }
        return false;
    }
    
    /**
     * @return allTickets - a String that has all the info of each Ticket object in the HashMap concatenated together
     */
    public String viewAllTickets() //works the same way as view all staff, but with tickets in it
    {
        String allTickets = "";        
        for (int i = 1; i < tickets.size()+1; i++){            
            allTickets = allTickets + tickets.get(i).viewTicket() + "\n";     
        
        }        
        return allTickets;
    }
    
    /**
     * @param searchID - an int used to search the HashMap for a Ticket of that ID
     */
    public String searchTickets(int searchID ){ //works the same way as search staff, but with tickets in it
        for (int i = 1; i < tickets.size()+1; i++){
                if (tickets.containsKey(searchID))
                {
                    System.out.println("Ticket with ID " + searchID + " is in the database");
                    Ticket searchedTicket = tickets.get(searchID);
                    return searchedTicket.viewTicket();
                }
            }
            return " Ticket with this ID isnt in the database";
    }
    
    /**
     * @return int equal to either the number in the loop where the next number isnt in the HashMap as a key, or the size of the HashMap + 1
     */ 
    public int nextEmptyTicketID() 
    {
        for (int i = 1; i <= tickets.size(); i++)
        {
            if (!tickets.containsKey(i)){
                return i;
                
            }
            
        }
        return tickets.size()+1; //returns the number of indexes, +1
    }
    
    /**
     * @param editID - an int used to search the database for that ID
     * @return Ticket object gotten through the HashMap method get()
     */    
    public Ticket getTicket(int editID) 
    {
        return tickets.get(editID);
        
    }
   // everything below here is database methods
   /**
     * Uses the local versions of the HashMaps to send to the database
     */    
    public void saveToDatabase() throws IOException
    {
        accountsDatabase.save(tickets,staff,students);
    }
    
    /**
     * Gets the array of HashMaps from the load function in the database and updates the local HashMaps with the new loaded HashMaps 
     */    
    public void loadFromDatabase() throws IOException, ClassNotFoundException
    {
        maps = accountsDatabase.load();
        tickets = maps[0];
        staff = maps[1];
        students = maps[2];
    }
}
