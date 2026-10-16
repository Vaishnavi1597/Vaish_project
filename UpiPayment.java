public class UpiPayment implements Payment {

    @Override
    public void processPayment(double amount) {

        System.out.println("UPI Payment Successful");
        System.out.println("Amount Paid : ₹" + amount);

    }

}
