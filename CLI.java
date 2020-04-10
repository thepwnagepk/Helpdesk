import java.io.*; 
/**
* The Starter point for I/O before going onto specialized interfaces
*
* @author Thomas 'PK' Parker
* @version 1
*/
public class CLI
{
 
   Helpdesk helpdesk;
   ITTicket currentITTicket;
    
/**
 * @param helpdesk - stores the instance of the helpdesk created by the Tester to use its method
 */
public CLI(Helpdesk helpdesk) throws IOException, ClassNotFoundException
{
     this.helpdesk = helpdesk;
}


/**
 * the main method, always follows the constructor.
 */
public  void main()throws IOException,ClassNotFoundException{             
        //createTickets(); //if you need to recreate the dummy data
        //createHashmaps();//if you need to recreate the dummy data
        //helpdesk.saveToDatabase();//if you need to recreate the dummy data
        helpdesk.loadFromDatabase();
        
        InputStreamReader r=new InputStreamReader(System.in);    
        BufferedReader br=new BufferedReader(r);
        
        System.out.println("Enter your username");    
        String userInput = br.readLine();    
        System.out.println("Enter your password");
        String passInput = br.readLine();
        System.out.println("Username: " + userInput + " Password: " + passInput);//testing    
        int type = helpdesk.loginchecker(userInput, passInput);
        switch(type){
        case 1:
        this.generalInterface();
        break;
        case 2:
        this.adminInterface(); 
        break;
        case -1:
        System.out.println("you are not recognised as a staff member");    
        this.main();
        break;
        }
        
    }    
    
    
    public String createHashmaps()throws IOException,ClassNotFoundException{ // should only run when you need to reset dummy data
        
             Admin pk = new Admin(1,"Thomas Parker","pk", "123");//have to add ID and name first becasue of person
             Receptionist jane = new Receptionist(2, "Jane Doe","janedoe", "12345");   
             helpdesk.addStaff(pk);
             helpdesk.addStaff(jane);
             helpdesk.saveToDatabase();
             return "Accounts have been made";
    }
    
     public String createTickets()throws IOException,ClassNotFoundException{ // should only run when you need to reset dummy data
        GeneralTicket ticket1 = new GeneralTicket(1,"01/01/2000","3:30","jane","kid stabbed");
        ITTicket ticket2 = new ITTicket(2,"01/01/2001","3:40","john","kid mauled", "steve", "mac");
        
        helpdesk.addTicket(ticket1);
        helpdesk.addTicket(ticket2);
        helpdesk.saveToDatabase();
        return "Tickets to test have been made";
        
    }
    
    
    /**
     * The Admin Interface, returns nothing.
     */
    public void adminInterface()throws IOException,ClassNotFoundException{
        
        InputStreamReader r=new InputStreamReader(System.in);    
        BufferedReader br=new BufferedReader(r);        
        System.out.println("1. Create an Account");
        System.out.println("2. Edit an Account");
        System.out.println("3. Search for an Account");
        System.out.println("4. View all Accounts");
        System.out.println("5. Delete Account");
        System.out.println("6. Exit");
        
        try{
        String adminChoice = br.readLine();        
        
        switch(Integer.parseInt(adminChoice)){
            case 1://create new user
            System.out.print("Admin [1] or Receptionist [2] Account? : " );
            String newAccAuthS = br.readLine();
            int newAccAuthI = Integer.parseInt(newAccAuthS);
            switch(newAccAuthI){
                case 1:// ID int - Strings - date,time,receptionistID
                int newAccIDA = helpdesk.nextEmptyID();
                
                System.out.print("Enter the Name of the Admin: " );
                String newAccNameA = br.readLine();
                System.out.print("Enter Username for " + newAccNameA + " ");
                String newAccUserA = br.readLine();
                System.out.print("Enter Password for " + newAccNameA + " ");
                String newAccPassA = br.readLine();
                Admin newAdmin = new Admin(newAccIDA,newAccNameA,newAccUserA, newAccPassA);
                helpdesk.addStaff(newAdmin);
                helpdesk.saveToDatabase();
                this.main();//test the login
                break;
                
                case 2://add Strings reportedby and Itequeipment affect
                int newAccIDR = helpdesk.nextEmptyID();
                
                System.out.print("Enter Name of the Receptionist: " );
                String newAccNameR = br.readLine();
                System.out.print("Enter Username for " + newAccNameR + " ");
                String newAccUserR = br.readLine();
                System.out.print("Enter Password for " + newAccNameR + " ");
                String newAccPassR = br.readLine();
                Receptionist newReceptionist = new Receptionist(newAccIDR, newAccNameR,newAccUserR, newAccPassR);
                helpdesk.addStaff(newReceptionist);
                helpdesk.saveToDatabase();
                this.main();
                break;
            }
            
            
            //DATABASE or LOGIN, MAKE CREATE ACC METHOD
            //load up hm, checks the key to make sure its unique, adds the string to thing then saves it
            break;
            case 2://edit user
            System.out.println("Which Staff, as their ID, do you want to edit: " );
            String editID1 = br.readLine();
            int editID2 = Integer.parseInt(editID1);
            Staff toBeEdited = helpdesk.getStaff(editID2);
            System.out.println("Which part of the account do you wish to edit");
            System.out.println("1. Name");
            System.out.println("2. Username");
            System.out.println("3. Password");
            String editChoice = br.readLine();
            int editChoice2 = Integer.parseInt(editChoice);
            System.out.println("What do you wish to change this to: ");
            String editValue = br.readLine();
            
            switch(editChoice2){       
                
                case 1://name
                toBeEdited.setName(editValue);
                break;
                case 2://username
                toBeEdited.setUsername(editValue);
                break;
                case 3://password
                toBeEdited.setPassword(editValue);
                break;
            }
            
            helpdesk.saveToDatabase();
            this.adminInterface();
            break;
            case 3:
            System.out.print("What ID are you looking for: " );
            String searchID = br.readLine();
            int searchID2 = Integer.parseInt(searchID);
            System.out.println(helpdesk.searchStaff(searchID2));
            this.adminInterface();
            break;
            
            case 4:
            System.out.println(helpdesk.viewAllStaff());   
            this.adminInterface();
            
            case 5:
            System.out.print("What ID are you looking for: " );
            String removeIDinput = br.readLine();
            //System.out.print("Are you sure you want to delete the account associated with " + removeIDinput + " - [Y/N]");
            //String removeConfirm = br.readLine();
            //if (removeConfirm == "y" ||removeConfirm == "Y"){
                int removeID = Integer.parseInt(removeIDinput);
                helpdesk.deleteStaff(removeID);
            //} // has a bonus use, if they do not put y or Y, it will assume its an error - making sure you must read it properly            
            helpdesk.saveToDatabase();            
            this.adminInterface();
            break;
            case 6:
            System.exit(0);
            break;
            //exit
        
        
        
        }
        
        }
        catch(IOException e){
            e.printStackTrace();
            System.out.println("Input not recognised");
            adminInterface();
        }
        
        
        
        
        
        
    }
    
    /**
     * The Receptionist / General Interface, returns nothing.
     */
    public void generalInterface()throws IOException,ClassNotFoundException{ // receptionist interface
        
        InputStreamReader r=new InputStreamReader(System.in);    
        BufferedReader br=new BufferedReader(r);
        System.out.println("1. Create/Open a Ticket");
        System.out.println("2. Edit a Ticket");        
        System.out.println("3. Search for a Ticket");//done
        System.out.println("4. View all Tickets"); //done   
        System.out.println("5. Update a Ticket");
        System.out.println("6. Resolve a Ticket");
        System.out.println("7. Exit");
        
        try{
        String recepChoice = br.readLine();
        
            switch(Integer.parseInt(recepChoice)){
                case 1:
                
                System.out.print("General [1] or IT [2] Ticket? : " );
                String newTicTypeS = br.readLine();
                int newTicTypeI = Integer.parseInt(newTicTypeS);
                switch(newTicTypeI){
                    case 1:
                    int newTicIDA = helpdesk.nextEmptyTicketID();
                    
                    System.out.print("Todays Date: " );
                    String newTicDateG = br.readLine();
                    System.out.print("The Time currently");
                    String newTicTimeG = br.readLine();
                    System.out.print("ID of the Receptionist reporting this ");
                    String newTicRecIDG = br.readLine();
                    System.out.print("Notes for the Incident ");
                    String newTicNotesG = br.readLine();
                    GeneralTicket newGeneralTicket = new GeneralTicket(newTicIDA,newTicDateG,newTicTimeG, newTicRecIDG,newTicNotesG);
                    helpdesk.addTicket(newGeneralTicket);
                    helpdesk.saveToDatabase();
                    this.generalInterface();//test the ticket
                    break;
                    
                    case 2:
                    int newTicIDI = helpdesk.nextEmptyID();
                    
                    System.out.print("Todays Date: " );
                    String newTicDateI = br.readLine();
                    System.out.print("The Time currently: ");
                    String newTicTimeI = br.readLine();
                    System.out.print("ID of the Receptionist reporting this: ");
                    String newTicRecIDI = br.readLine();
                    System.out.print("Notes for the Incident: ");
                    String newTicNotesI = br.readLine();
                    System.out.print("The incident was reported by: ");
                    String newTicReportI = br.readLine();
                    System.out.print("Any IT Equipment Affected: ");
                    String newTicITEAI = br.readLine();
                    ITTicket newITTicket = new ITTicket(newTicIDI,newTicDateI,newTicTimeI, newTicRecIDI,newTicNotesI,newTicReportI,newTicITEAI);
                    helpdesk.addTicket(newITTicket);
                    helpdesk.saveToDatabase();
                    this.generalInterface(); //test the ticket
                    break;
            }
                
                break;
                case 2:
                
                System.out.println("Which Ticket, via its ID, do you want to edit: " );
            String editID1 = br.readLine();
            int editID2 = Integer.parseInt(editID1);
            Ticket toBeEdited = helpdesk.getTicket(editID2);
            System.out.println("Which part of the Ticket do you wish to edit");
            System.out.println("1. Date");
            System.out.println("2. Time");
            System.out.println("3. Receptionist");
            System.out.println("4. Notes");
            //check if tobeedited is an it ticket, if so add 3 more line, if not carry on
            if(toBeEdited instanceof ITTicket){
            currentITTicket = (ITTicket)toBeEdited;
            System.out.println("5. Reported By");
            System.out.println("6. It Equipment Affected");
            
            }
            
            String editChoice = br.readLine();
            int editChoice2 = Integer.parseInt(editChoice);
            System.out.println("What do you wish to change this to: ");
            String editValue = br.readLine();
            
            switch(editChoice2){       
                
                case 1://date
                toBeEdited.setDate(editValue);
                break;
                case 2://time
                toBeEdited.setTime(editValue);
                break;
                case 3://receptionist
                toBeEdited.setReceptionist(editValue);
                break;
                case 4://notes
                toBeEdited.setDetails(editValue);
                case 5://reported by
                currentITTicket.setReportedBy(editValue);
                break;
                case 6://it equipment affected
                currentITTicket.setITEquipmentAffected(editValue);
            }
            
            helpdesk.saveToDatabase();
            this.generalInterface();                
            break;
                
                case 3:
                System.out.print("What's the ID of the Ticket you are looking for: " );
                String ticketSearchID = br.readLine();
                int ticketSearchID2 = Integer.parseInt(ticketSearchID);
                System.out.println(helpdesk.searchTickets(ticketSearchID2));
                this.generalInterface();
                break;
                
                case 4:
                System.out.println(helpdesk.viewAllTickets() + "\n");
                this.generalInterface();
                break;
                
                case 5:
                System.out.println("Which Ticket, via its ID, do you want to add an Update to: " );
                String updateID1 = br.readLine();
                int updateID2 = Integer.parseInt(updateID1);
                Ticket toBeUpdated = helpdesk.getTicket(updateID2);
                //action creation
                int updateID = toBeUpdated.nextActionID();
                System.out.print("Todays Date: " );
                    String newUpdateDate = br.readLine();
                    System.out.print("The Time currently");
                    String newUpdateTime = br.readLine();
                    System.out.print("ID of the Receptionist reporting this ");
                    String newUpdateRecID = br.readLine();
                    System.out.print("Notes for the Incident ");
                    String newUpdateNotes = br.readLine();
                    Updates update = new Updates(updateID,newUpdateDate,newUpdateTime, newUpdateRecID,newUpdateNotes);
                    toBeUpdated.addUpdate(update);
                    helpdesk.saveToDatabase();
                    this.generalInterface();
                 break;
                case 6:
                System.out.println("Which Ticket, via its ID, do you want to Resolve and Close: " );
                String resolutionID1 = br.readLine();
                int resolutionID2 = Integer.parseInt(resolutionID1);
                Ticket toBeResolved = helpdesk.getTicket(resolutionID2);
                
                int resoID = toBeResolved.nextActionID();
                System.out.print("Todays Date: " );
                    String newResoDate = br.readLine();
                    System.out.print("The Time currently");
                    String newResoTime = br.readLine();
                    System.out.print("ID of the Receptionist reporting this ");
                    String newResoRecID = br.readLine();
                    System.out.print("Notes for the Resolution ");
                    String newResoNotes = br.readLine();
                    Resolutions resolution = new Resolutions(resoID,newResoDate,newResoTime, newResoRecID,newResoNotes);
                    toBeResolved.addResolution(resolution);
                    helpdesk.saveToDatabase();
                    this.generalInterface();
                 break;
                case 7:
                System.exit(0);
                break;
            }
            
        }
        catch(IOException e){
            e.printStackTrace();
            System.out.println("Input not recognised");
            adminInterface();
        }
    }
    
}
