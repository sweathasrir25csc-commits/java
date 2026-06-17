import java.lang.classfile.Interfaces;
import java.lang.reflect.Array;
import java.util.*;

/*public class day11 {
      static void main() {
            String name = null;
            try {
                name = null;
                System.out.println(name.charAt(0));
                System.out.println(45/0);
            } catch (ArithmeticException e) {
                System.out.println("Arithmetic Exception");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Array Index of Bound Exception");
            } catch (Exception e) {
                System.out.println("Exception");
            } finally {
                System.out.println("This will always execute");
               // name="";
            }
            System.out.println("Still running");
            System.out.println("Name:" + name);
        }
        */
    /*public static void main(String[] args) {
       Set<String> set = new HashSet<>();
       set.add("Sweatha");
       set.add("Menaga");
       set.add("Narthika");
       set.add("Mithra");
       set.add("Mithra");
       System.out.println("set:");
       for(String s:set) {
           System.out.println(s);
       }
   }
}*/
public class day11{
    public static void main(String[] args) {
        Map<String, Object> person = new HashMap<>();
        person.put("Ram",89);
        person.put("John",78);
        person.put("Aravindh",67);
        person.put("Ramesh",90);
        System.out.println(person.get("percent"));
        person.entrySet().forEach(entry ->{
            System.out.println(entry.getKey() + " : " + entry.getValue());
        });
    }
}



