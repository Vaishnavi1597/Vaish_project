public class Admin extends User {

    public Admin(int userId, String name, String mobileNumber) {
        super(userId, name, mobileNumber);
    }

    @Override
    public void displayDetails() {
        System.out.println("Admin ID : " + getUserId());
        System.out.println("Name : " + getName());
    }

    public void addFood(Restaurant restaurant, Food food) {
        restaurant.addFood(food);
    }

    public void removeFood(Restaurant restaurant, int foodId) {
        restaurant.removeFood(foodId);
    }

    public void updateFoodPrice(Restaurant restaurant, int foodId, double price) {
        restaurant.updateFoodPrice(foodId, price);
    }
}
