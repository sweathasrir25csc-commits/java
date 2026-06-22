/*public class Day14_Adapter {
    interface NewPrinter{
        void print(String text);
    }
    class OldPrinter{
        void printText(String text){
            System.out.println("OLD Printer :"+text);
        }
    }
    class OldPrinterAdapter implements NewPrinter{
        private final OldPrinter printer;
        OldPrinterAdapter(OldPrinter printer) {
            this.printer=printer;
        }
        @Override
        public void print(String text){
            printer.printText(text);
        }
    }
    static void main() {
        NewPrinter printer = new OldPrinterAdapter(OldPrinterAdapter);
        printer.print("Hello World");
    }
}*/
