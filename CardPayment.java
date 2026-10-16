public class CardPayment implements Payment {

    @Override
    public void processPayment(double amount) {

        System.out.println("Card Payment Successful");
        System.out.println("Amount Paid : ₹" + amount);

    }

}
