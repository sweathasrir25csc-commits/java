public class Day15 {
    static void main() throws InterruptedException {
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
    }
}
