public class day7 {
    /*static class Request {
        String name;
        String date;
        String reason;
        Request(String name, String date, String reason){
            this.name = name;
            this.date = date;
            this.reason = reason;
        }
        void approve() {
            System.out.println("Approving request");
        }
        void reject() {
            System.out.println("Reject request");
        }
    }
    static class LeaveRequest extends Request {
        LeaveRequest(String name, String date, String reason) {
            super(name, date, reason);
        }
        void approveLeaveRequest() {
            System.out.println("Approving leave request");
        }
        void rejectLeaveRequest() {
            System.out.println("Reject leave request");
        }
    }
    static class OnDutyRequest extends Request {
        OnDutyRequest(String name, String date, String reason) {
            super(name, date, reason);
        }
        void approveOnDutyRequest() {
            System.out.println("Approving on duty request");
        }
        void rejectOnDutyRequest() {
            System.out.println("Reject on duty request");
        }
    }
    static void main() {
        LeaveRequest leaveRequest = new LeaveRequest("Sweatha sri R","12-04-2026","High Fever");
        leaveRequest.approveLeaveRequest();
        OnDutyRequest onDutyRequest = new OnDutyRequest("Menaga sri R","21-04-2026","Marriage Function");
        onDutyRequest.rejectOnDutyRequest();
    }
}
*/
    static class payment {
        String amount;
        void transfer() {
            System.out.println("make a payment");
        }
    }
    static class Upipayment extends payment {
        void transfer() {
            System.out.println("upipayment");
        }
    }
    static class Cardpayment extends payment {
        void transfer() {
            System.out.println("Cardpayment");
        }
    }
    static class NBpayment extends payment {
        void transfer() {
            System.out.println("NBpayment");
        }
    }
    static void main() {
        Upipayment upipayment = new Upipayment();
        upipayment.transfer();

        Cardpayment cardpayment = new Cardpayment();
        cardpayment.transfer();

        NBpayment nBpayment = new NBpayment();
        nBpayment.transfer();
    }
}






