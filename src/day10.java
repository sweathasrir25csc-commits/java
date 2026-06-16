import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;

/*import java.util.ArrayList;
public class day10 {
    static void main() {
        ArrayList<String> list= new ArrayList<String> ();
        String[] StudentsList={"Menaga","Mithra","Ram","Narthi","Nivetha"};
        System.out.println(StudentsList.length);
        list.add("Menaga");
        list.add("Mithra");
        list.add("Ram");
        list.add("Narthi");
        list.add("nivetha");
        for (String s:  list){
            System.out.println(s);
        }
        list.remove("Ram");
        list.add("Swea");
        System.out.println();
        for (String s:  list){
            System.out.println(s);
        }
    }
}*/
/*public class Day10 {
    static void main() {
        String[] alpha = {"A","B","C","D"};
        System.out.println(alpha.length);
        ArrayList<String> list = new ArrayList<String>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        for(String s: list) {
            System.out.print(s);
        }
        list.add("E");
        list.remove("C");
        System.out.println();
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println();
        for(String s: list) {
            System.out.print(s);
        }
        System.out.println();
        System.out.println(list.get(2));
        list.addAll(list);
        System.out.println();
        for(String s: list) {
            System.out.print(s);
        }
   }
}
 */
public class day10 {
    static void main() {
       /* LinkedList<String> queue = new LinkedList<String>();
        queue.add("Sweatha");
        queue.add("Menaga");
        queue.add("Narthika");
        queue.add("Mithra");
        queue.add("Nivetha");
        while(!queue.isEmpty()) {
            process(queue);
        }
    }
    static void process(LinkedList<String> queue){
        String removed=queue.removeFirst();
        System.out.println("Removed:"+removed);

    }
}
*/
        void takeout(ArrayDeque<String> bucket){
            String plate=bucket.pollLast();
            System.out.print("Taking out of plate");
        }
        ArrayDeque<String> deque = new ArrayDeque<String>();
        deque.offerLast("p1");
        deque.offerLast("p2");
        deque.offerLast("p3");
        deque.offerLast("p4");
        System.out.println(deque);
        while(deque .size()>0) {


    }
}