public class CashPayment implements Payment {

    @Override
    public void processPayment(double amount) {

        System.out.println("Cash Payment Successful");
        System.out.println("Amount Paid : ₹" + amount);

    }

}