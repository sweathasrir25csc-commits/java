/*public class day6 {
    static class Car {
        String Brand;
        String Color;
        int Speed;
        int Fuel;

        Car() {
            System.out.println("constructer called");
        }

        Car(String Brand, String Color, int Speed, int Fuel) {
            this.Brand = Brand;
            this.Color = Color;
            this.Speed = Speed;
            this.Fuel = Fuel;
        }

        void accelarate(int speed) {
            this.Speed += speed;
            //this.Speed=Speed;
        }

        void declarate(int speed) {
            this.Speed -= speed;
        }

        void refill(int fuel) {
            this.Fuel += fuel;
        }

        void showFuel() {
            System.out.println("Your Fuel is : " + Fuel);
        }

        void printDetails() {
            System.out.println("Brand" + Brand);
            System.out.println("Color" + Color);
            System.out.println("Speed" + Speed);
            System.out.println("Fuel" + Fuel);
        }
    }

    public static void main(String[] args) {
        Car car = new Car("Mahendra", "Black", 500, 90);
        // car.Speed(500);
        car.printDetails();
        car.accelarate(500);
        car.declarate(40);
        car.refill(20);
    }

    void main() {
        int marks[] = {87, 32, 44, 89, 23};
        String pass = "";
        String fail = "";
        for (int i = 0; i < marks.length; i++) {
            if (marks[i] > 40) {
                pass += marks[i] + ", ";
            } else if (marks[i] < 40) {
                fail += marks[i] + ", ";
            }
        }
        System.out.print("Pass Marks : ");
        System.out.print(pass.substring(0, pass.length() - 2));
        System.out.print("\nFail Marks : ");
        System.out.print(fail.substring(0, fail.length() - 2));
    }
}
*/
/*void main() {
    static class Student {
        String name;
        String regNo;
        String dept;
        int mathsMarks;
        int phyMarks;
        int cseMarks;
        Student() {
            System.out.println("constructer called");
        }
        Student(String name,String regNo,String dept,int mathsMarks,int phyMarks,int cseMarks){
            this.name=name;
            this.regNo=regNo;
            this.dept=dept;
            this.mathsMarks=mathsMarks;
            this.phyMarks=phyMarks;
            this.cseMarks=cseMarks;
        }
        void printDetails() {
            System.out.println("name" + name);
            System.out.println("regNo" + regNo);
            System.out.println("dept" + dept);
            System.out.println("mathsMarks" + mathsMarks);
            System.out.println("phyMarks" + phyMarks);
            System.out.println("cseMarks" + cseMarks);
        }
        public static void main(String[] args) {
            Student student = new Student("Menaga sri R","2522K1830","Computer Science",89,94,98);
            Student.printD();
            Student.name("Menaga sri R");
            Student.regNo("2522k1830");
            Student.dept("computer science");
            Student.mathsMarks(89);
            Student.phyMarks(94);
            Student.cseMarks(98);
        }
    }
}
*/


