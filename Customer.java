import java.util.ArrayList;

public class Customer extends User {

    private ArrayList<Order> orderHistory;

    public Customer(int userId, String name, String mobileNumber) {
        super(userId, name, mobileNumber);
        orderHistory = new ArrayList<>();
    }

    @Override
    public void displayDetails() {
        System.out.println("Customer ID : " + getUserId());
        System.out.println("Name : " + getName());
        System.out.println("Mobile : " + getMobileNumber());
    }

    public void addOrder(Order order) {
        orderHistory.add(order);
    }

    public void viewOrderHistory() {
        for (Order order : orderHistory) {
            System.out.println(order);
        }
    }
}