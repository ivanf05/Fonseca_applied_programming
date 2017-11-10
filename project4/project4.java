import java.util.*;
import java.io.*;
 
class HashObject {
    public String element;
    public int count = 1;
    // Constructor
    HashObject(String input) {
            element = input;   
    }

    // Find appropriate base class to override that include the hashCode
    // and equals member functions
    public int hashCode() {
            //System.out.println(" Code " + element.hashCode() + " Element " + element );
            return element.hashCode();
    }       
    public boolean equals(Object inputParam) {
       HashObject inputObject = (HashObject) inputParam;
       //System.out.println(element + " - = - " + inputObject.element);
       if (element.equals( inputObject.element)) {	
    	   //System.out.println("The current element is " + hashObject3element      
    	   inputObject.count++;
           return true;
        }
            else {
            	return false;
            }
    }
}
 
class project4{
	
	
	static List<String> list = new ArrayList<String>();
    public static void main(String args[]) {
    	project4 p4 =new project4();
    	HashSet<HashObject> hashSet = new HashSet<HashObject>();
       
        p4.printFile("input.txt");
        //iterates through Array list of words and
        //adds them to hash set.
        for(String s:list) {
        	
        	HashObject hashObject = new HashObject(s);
            hashSet.add(hashObject);  
        }
        p4.hashSetPrint(hashSet);
    }
    
    public void hashSetPrint(HashSet<HashObject> hashSet){
    	Iterator<HashObject> iter = hashSet.iterator();
        HashObject hashObject3;
        //Prints how many times a word occurs.
        while (iter.hasNext()) {
                hashObject3 = iter.next();
                if(hashObject3.count !=1){
                	System.out.println("Word: " + hashObject3.element + " Occurs " + hashObject3.count +" Times");
                }
        } 
        Iterator<HashObject> iter2 = hashSet.iterator();
        HashObject hashObject4;
        //Prints Unique Words.
        while (iter2.hasNext()) {
            hashObject4 = iter2.next();
            if(hashObject4.count ==1){
            	System.out.println( hashObject4.element +" is a Unique Word");
            }
        } 
    }
    public void printFile(String fileName) {
    	try {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            Scanner inputStream = new Scanner(fr);         
            while (inputStream.hasNextLine()) {        
                String line = inputStream.next();
          
             for ( String element : line.split(" ")) {
            	 //Adds each word into an array
            	 list.add(element);
                }
            }
            fr.close();
            inputStream.close();
        } catch ( IOException e ) {
            System.out.println(" Exception error -- " );
        } catch ( java.util.NoSuchElementException e ) {
            System.out.println(" At the end of the file " );
        }
    }
}