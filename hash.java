import java.util.*;
 
// Set is an interface so you must use extend operator
class HashObject {
        public String element;
        public int count = 1;
         
        // Constructor
        HashObject(String input) {
                element = input;
        }
         
        // Find appropriate base class to override that include the hashCode
        // and equals memeber functions
        public int hashCode() {
                System.out.println(" Code " + element.hashCode() + " Element " + element );
                return element.hashCode();
        }       
 
        public boolean equals(Object inputParam) {
 
            HashObject inputObject = (HashObject) inputParam;
            System.out.println(element + " - = - " + inputObject.element);
           if (element == inputObject.element) {
                        element.count++;
                        return true;
            }
                else {
                        return false;
                }
        }
}
 
public class HashDemo {
        public static void main(String[] args) {
                HashSet<HashObject> hashSet = new HashSet<HashObject>();
                HashObject hashObject = new HashObject("Mary");
                hashSet.add(hashObject);
 
                HashObject hashObject01 = new HashObject("Mary");
                hashSet.add(hashObject01);
                 
                HashObject hashObject1 = new HashObject("Thomas");
                hashSet.add(hashObject1);
                 
                HashObject hashObject2 = new HashObject("Kevin");
                hashSet.add(hashObject2);
 
                HashObject hashObject4 = new HashObject("Thomas");
                hashSet.add(hashObject4);
                 
                // Iterate over the hash set
                Iterator<HashObject> iter = hashSet.iterator();
                 
                HashObject hashObject3;
                while (iter.hasNext()) {
                        hashObject3 = iter.next();
                        System.out.println("The current element is " + hashObject3.element + " " + hashObject3.count);
                } 
        }
}