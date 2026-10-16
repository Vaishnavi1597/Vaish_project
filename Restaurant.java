import java.util.ArrayList;

public class Restaurant {

    private ArrayList<Food> menu;
    private ArrayList<Order> orders;
    private int orderCounter = 101;

    public Restaurant() {
        menu = new ArrayList<>();
        orders = new ArrayList<>();
    }

    // Add Food
    public void addFood(Food food) {
        menu.add(food);
        System.out.println(food.getFoodName() + " added successfully.");
    }

    // Remove Food
    public void removeFood(int foodId) {

        Food food = findFood(foodId);

        if (food != null) {
            menu.remove(food);
            System.out.println("Food Removed Successfully.");
        } else {
            System.out.println("Food Not Found.");
        }
    }

    // Update Price
    public void updateFoodPrice(int foodId, double newPrice) {

        Food food = findFood(foodId);

        if (food != null) {
            food.setPrice(newPrice);
            System.out.println("Price Updated Successfully.");
        } else {
            System.out.println("Food Not Found.");
        }
    }

    // Display Menu
    public void displayMenu() {

        System.out.println("\n========= MENU =========");

        for (Food food : menu) {

            if (food.isAvailable()) {
                System.out.println(food);
            }

        }
    }

    // Find Food
    public Food findFood(int foodId) {

        for (Food food : menu) {

            if (food.getFoodId() == foodId) {
                return food;
            }

        }

        return null;
    }

    // Place Order
    public Order placeOrder(Customer customer, int foodId, int quantity)
            throws FoodNotFoundException,
            FoodUnavailableException {

        Food food = findFood(foodId);

        if (food == null) {
            throw new FoodNotFoundException("Food ID Not Found.");
        }

        if (!food.isAvailable()) {
            throw new FoodUnavailableException("Food Currently Unavailable.");
        }

        String orderId = "O" + orderCounter++;

        Order order = new Order(orderId, customer, food, quantity);

        orders.add(order);

        customer.addOrder(order);

        return order;
    }

    // Cancel Order
    public void cancelOrder(String orderId)
            throws InvalidOrderException {

        for (Order order : orders) {

            if (order.getOrderId().equals(orderId)) {

                if (order.getStatus() == OrderStatus.PLACED) {

                    order.setStatus(OrderStatus.CANCELLED);

                    System.out.println("Order Cancelled Successfully.");

                    return;
                }

                throw new InvalidOrderException(
                        "Order Already Preparing.");
            }
        }

        throw new InvalidOrderException("Order Not Found.");
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }
}
