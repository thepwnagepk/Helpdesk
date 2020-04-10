
/**
 * Write a description of class Dump here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Dump
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Dump
     */
    public Dump()
    {
        // initialise instance variables
        x = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int sampleMethod(int y)
    {
        // put your code here
        /*
        Admin pk = new Admin(1,"Thomas Parker","pk", "123");//have to add ID and name first becasue of person
             Receptionist jane = new Receptionist(2, "Jane Doe","janedoe", "12345");
             GeneralTicket ticket1 = new GeneralTicket(1,"01/01/2000","3:30","jane","kid stabbed");
             ITTicket ticket2 = new ITTicket(2,"01/01/2001","3:40","john","kid mauled", "steve", "mac");
             Resolutions res = new Resolutions(1,"01/01/2002","3:50", "jane", "arrested");
             Updates Updates = new Updates(1,"01/01/2002","3:50", "jane", "");
             
             
             helpdesk.addStaff(pk);
             helpdesk.addStaff(jane);
             
             
             System.out.println("Administrator Test: Username: " + pk.getUsername() + " Password: " + pk.getPassword() + " ID: " + pk.getID() + " Name: " + pk.getName() +"\n" );
             System.out.println("Receptionist Test: Username: " + jane.getUsername() + " Password: " + jane.getPassword() + " ID: " + jane.getID() + " Name: " + jane.getName()  + "\n");
             System.out.println("General Ticket Test: " + ticket1.viewTicket() + "\n");
             System.out.println("IT Ticket Test: " + ticket2.viewTicket() + "\n");
             
             //view staff for admin - working
             System.out.println(helpdesk.viewAllStaff());
             
             //input and login checker - working
             InputStreamReader r=new InputStreamReader(System.in);    
             BufferedReader br=new BufferedReader(r);
             
             System.out.println("Enter your username");    
            String userInput = br.readLine();    
            System.out.println("Enter your password");
            String passInput = br.readLine();
            System.out.println("Username: " + userInput + " Password: " + passInput);
            helpdesk.loginchecker(userInput, passInput);
            */
        return x + y;
        
    }
}
