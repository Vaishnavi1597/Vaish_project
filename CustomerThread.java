public class CustomerThread extends Thread {

    private Restaurant restaurant;
    private Customer customer;
    private int foodId;
    private int quantity;
    private Payment payment;

    public CustomerThread(Restaurant restaurant, Customer customer,
                          int foodId, int quantity, Payment payment) {

        this.restaurant = restaurant;
        this.customer = customer;
        this.foodId = foodId;
        this.quantity = quantity;
        this.payment = payment;
    }

    @Override
    public void run() {

        try {

            Order order = restaurant.placeOrder(customer, foodId, quantity);

            payment.processPayment(order.getTotalAmount());

            System.out.println("\nOrder Placed Successfully");
            System.out.println(order);

        }

        catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
