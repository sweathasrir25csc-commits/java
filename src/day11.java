public class day11 {
    static void main() {
        String name = null;
        try {
            name = null;
            System.out.println(name.charAt(0));
            System.out.println(45 / 0);
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array Index of Bound Exception");
        } catch (Exception e) {
            System.out.println("Exception");
        } finally {
            System.out.println("This will always execute");
            //name="";
        }
        System.out.println("Still running");
        System.out.println("Name:" + name);
    }
}
