public class Order {

    private String orderId;
    private Customer customer;
    private Food food;
    private int quantity;
    private double totalAmount;
    private OrderStatus status;

    public Order(String orderId, Customer customer, Food food, int quantity) {
        this.orderId = orderId;
        this.customer = customer;
        this.food = food;
        this.quantity = quantity;
        this.totalAmount = food.getPrice() * quantity;
        this.status = OrderStatus.PLACED;
    }

    public String getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Food getFood() {
        return food;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {

        return "\nOrder ID : " + orderId +
                "\nCustomer : " + customer.getName() +
                "\nFood : " + food.getFoodName() +
                "\nQuantity : " + quantity +
                "\nTotal Amount : ₹" + totalAmount +
                "\nStatus : " + status;
    }
}
