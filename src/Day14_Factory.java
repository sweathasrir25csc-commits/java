public class Day14_Factory {
    interface Notification {
        void send(String to,String message);
    }
    class EmailNotification implements Notification{
        @Override
        public void send(String to,String message) {
            System.out.println("Sending Email:"+message+", to "+to);
        }
    }
    class WhatsappNotification implements Notification{
        @Override
        public void send(String to, String message) {
            System.out.println("Sending Whatsapp: "+message +", to "+to);
        }
    }
    static Notification getNotification(Day14_Factory factory, String type){
        return switch (type){
            case "Email"-> factory.new EmailNotification();
            case "Whatsapp"-> factory.new WhatsappNotification();
            default -> throw new IllegalArgumentException("Invalid notification type: "+type);
        };
    }
    static void main(){
        Day14_Factory factory=new Day14_Factory();
        String type="Whatsapp";
        getNotification(factory,type).send("7845789028","I Hate You");
    }
}
