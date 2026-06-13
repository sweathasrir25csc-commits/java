public class day8 {
    /* interface Employee {
         String Name();
         String id();
         String Salary();
     }
     static class BankEmployee implements Employee {
         @Override
         public String Name() {
             return "Menaga";
         }
         @Override
         public String id() {
             return "101";
         }
         @Override
         public String Salary() {
             return "50000";
         }
         public String solveprogram() {
             System.out.println("solution");
             return "solution";
         }
     }
     static class CheckingEmployee implements Employee {
         @Override
         public String Name() {
             return "Narthika";
         }
         @Override
         public String id() {
             return "102";
         }
         @Override
         public String Salary() {
             return "45000";
         }
         public String work() {
             System.out.println("process");
             return "process";
         }
     }
     public static void main(String[] args) {
         BankEmployee bank = new BankEmployee();
         System.out.println("Name : " + bank.Name());
         System.out.println("ID : " + bank.id());
         System.out.println("Salary : " + bank.Salary());
         bank.solveprogram();
         System.out.println();
         CheckingEmployee checking = new CheckingEmployee();
         System.out.println("Name : " + checking.Name());
         System.out.println("ID : " + checking.id());
         System.out.println("Salary : " + checking.Salary());
         checking.work();
     }
}
*/
    record Courserecord(int course, int dept) {
    }
    static void main() {
        Courserecord course = new Courserecord(123, 234);
        System.out.println(course.course());
        System.out.println(course.dept());
    }
}

