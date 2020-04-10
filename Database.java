import java.util.HashMap;
import java.util.ArrayList;
import java.io.File;
import java.io.ObjectOutputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.GZIPInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
/**
 * Creates the Files, Saves and Loads from these files whenever it is needed
 *
 * @author Thomas Parker
 * @version 1
 */
public class Database
{
    private File file1; //1 is always tickets
    private File file2; //2 is always staff
    private File file3; //3 is always students
    HashMap[] maps = new HashMap[3];
    
    /**
     * Constructor for objects of class Database
     * @param HashMap<Integer, Ticket> map1 - HashMap of Tickets
     * @param HashMap<Integer, Staff> map2 - HashMap of Staff
     * @param HashMap<Integer, Student> map3 - HashMap of Students
     */
    public Database(HashMap<Integer, Ticket> map1,HashMap<Integer, Staff> map2, HashMap<Integer, Student> map3) throws IOException
    {
        file1 = new File ("tickets.dat");
        file2 = new File ("staff.dat");
        file3 = new File ("students.dat");
        
        if (!file1.exists())        
        {
            file1.createNewFile();
            if (!file2.exists())            
            {
                file2.createNewFile();
                    if (!file3.exists())
                {
                    file3.createNewFile();
                    
                    
                }
            }
    }else{
        //save(map1, map2, map3);
    }
  
    }

    /**
     * save each HashMap to its corresponding file
     * @param HashMap<Integer, Ticket> map1 - HashMap of Tickets
     * @param HashMap<Integer, Staff> map2 - HashMap of Staff
     * @param HashMap<Integer, Student> map3 - HashMap of Students
     */
    public void save(HashMap<Integer, Ticket> map1, HashMap<Integer, Staff> map2, HashMap<Integer, Student> map3 ) throws IOException
    {
        ObjectOutputStream output1 = new ObjectOutputStream(new GZIPOutputStream(new FileOutputStream(file1))); 
        output1.writeObject(map1);//get map 1, and put it in file 1, repeat for 2 and 3, keep the order consistent
        output1.flush();
        output1.close();
        ObjectOutputStream output2 = new ObjectOutputStream(new GZIPOutputStream(new FileOutputStream(file2))); 
        output2.writeObject(map2);
        output2.flush();
        output2.close();
        ObjectOutputStream output3 = new ObjectOutputStream(new GZIPOutputStream(new FileOutputStream(file3)));
        output3.writeObject(map3);
        output3.flush();
        output3.close();
    }
    
    /**
     * load each HashMap from its corresponding file, put them into an Array to send them back, to keep it contained to 1 function.
     * @return HashMap[] maps - HashMap Array of all 3 HashMaps from the 3 files.   
     */
    public HashMap[] load() throws IOException, ClassNotFoundException
    {

        ObjectInputStream input1 = new ObjectInputStream(new GZIPInputStream(new FileInputStream(file1)));
        Object readObject1 = input1.readObject();
        input1.close();
        ObjectInputStream input2 = new ObjectInputStream(new GZIPInputStream(new FileInputStream(file2)));
        Object readObject2 = input2.readObject();
        input2.close();
        ObjectInputStream input3 = new ObjectInputStream(new GZIPInputStream(new FileInputStream(file3)));
        Object readObject3 = input3.readObject();
        input3.close();
        maps[0] = (HashMap<Integer , Ticket>) readObject1; //put objects 1,2,3 in the array in that order
        maps[1] = (HashMap<Integer, Staff>) readObject2;
        maps[2] = (HashMap<Integer, Student>) readObject3;         
        //check that the objects are HashMaps, if not throw and exception
        if(!(readObject1 instanceof HashMap)) 
        {
            throw new IOException("Data 1 is not a hashmap");
        }
        else if(!(readObject2 instanceof HashMap)) 
        {
            throw new IOException("Data 2 is not a hashmap");
        }
        else if(!(readObject3 instanceof HashMap)) 
        {
            throw new IOException("Data 3 is not a hashmap");
        }
        else
        {
            return  maps; //return the array of HashMaps
        }
     
    }
}
