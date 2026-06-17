public class day11 {
    static void main() {
        try{
            System.out.println(45/0);
        }catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Array Index of Bound Exception");
        }catch(Exception e){
            System.out.println("Exception");
        }finally {
            System.out.println("This will always execute");
        }
        System.out.println("Still running");
    }
}
