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
/*public class day10 {
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
       /* void takeout(ArrayDeque<String> bucket){
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
*/



import java.util.LinkedList;

        public class day10 {
            static class Student {
                String name;
                int regNo;
                int marks;
                Student(String name, int regNo, int marks) {
                    this.name = name;
                    this.regNo = regNo;
                    this.marks = marks;
                }
            }
            static void removeStudent(LinkedList<Student> students) {
                System.out.println("Removed : " + students.removeFirst().name);
            }
            static void updateStudent(LinkedList<Student> students) {
                for (Student s : students) {
                    if (s.name.equals("Deepa")) {
                        s.marks = 95;
                    }
                }
            }
            public static void main(String[] args) {
                    LinkedList<Student> students = new LinkedList<>();
                students.add(new Student("Arun", 101, 80));
                students.add(new Student("Bala", 102, 75));
                students.add(new Student("Charan", 103, 90));
                students.add(new Student("Deepa", 104, 85));
                students.add(new Student("Esha", 105, 88));
                removeStudent(students);
                updateStudent(students);
                System.out.println("\nStudent Details");
                for (Student s : students) {
                    System.out.println(
                            s.name + " " +
                                    s.regNo + " " +
                                    s.marks
                    );
                }
            }
        }