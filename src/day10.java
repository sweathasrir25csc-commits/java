import java.util.ArrayList;
/*public class day10 {
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
        System.out.println();
        for (String s:  list){
            System.out.println(s);
        }
    }
}*/
public class Day10 {
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
