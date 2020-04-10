 import java.io.IOException;
import java.io.*; 
/**
 * Initialises the CLI and Helpdesk and goes to the CLI
 *
 * @author Thomas Parker
 * @version 1
 */
public class Tester
{
    /**
     * Constructor for objects of class Tester
     */
    public Tester()
    {
        
        try
        {
             Helpdesk helpdesk = new Helpdesk();
             CLI  cli = new CLI(helpdesk);
             cli.main();
             
        }
        catch (IOException  | ClassNotFoundException e)
        {
            System.out.println(e);
        }       
        
    }
    
}
