import java.util.ArrayList;
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
        System.out.println();
        for (String s:  list){
            System.out.println(s);
        }
    }
}
