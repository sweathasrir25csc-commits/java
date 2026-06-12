 void main() {
         int[] marks={87,32,44,89,23};
         System.out.println("Pass mark");
         for(int mark:marks){
             if(mark>=40){
                 System.out.println(mark+"");
             }
         }
         System.out.print("fail mark");
         for(int mark:marks){
             if(mark<40) {
                 System.out.print(mark +"");
             }
        }
    }