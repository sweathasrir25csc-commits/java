public class Day15 {
/*static void main() throws InterruptedException {
        Runnable chefTask = () -> {
            String[] items = {"Bun", "Biscuit", "tea"};
            for (int i = 0; i < items.length; i++) {
                System.out.println("Cooking item: " + items[i]);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Thread chefThread = new Thread(chefTask, "chef-task");
        chefThread.start();
        chefThread.join();
    }*/

/*    static String[] items = {"Burger","Dosa","Coffee"};
    private static int nextOrderIndex = 0;
    static void pickOrder(){
        while(nextOrderIndex<items.length){
            int currentOrderIndex = nextOrderIndex;
            try{
                Thread.sleep(50);
            } catch (InterruptedException e){
                throw new RuntimeException(e);
            }
            nextOrderIndex++;
            if(nextOrderIndex<items.length){
                System.out.println(Thread.currentThread().getName()+" is preparing : "+items[currentOrderIndex]);
            }
        }
    }
    static void main() throws InterruptedException {
        Thread chefOne = new Thread(()->pickOrder(), "chef-one");
        Thread chefTwo = new Thread(()->pickOrder(), "chef-two");
        chefOne.start();
        chefTwo.start();
        chefOne.join();
        chefTwo.join();
    }
}
*/


    static String[] items = {"Burger","Dosa","Coffee"};
    private static int nextOrderIndex = 0;
    private static final Object LOCK = new Object();
    static void pickOrder(){
        String order;
        while(true){
            synchronized(LOCK){
                if(nextOrderIndex>=items.length){
                    return;
                }
                order = items[nextOrderIndex];
                nextOrderIndex++;
            }
            System.out.println(Thread.currentThread().getName()+" is preparing : "+order);
        }
    }
    static void main() throws InterruptedException {
        Thread chefOne = new Thread(()->pickOrder(), "chef-one");
        Thread chefTwo = new Thread(()->pickOrder(), "chef-two");
        chefOne.start();
        chefTwo.start();
        chefOne.join();
        chefTwo.join();
    }
}