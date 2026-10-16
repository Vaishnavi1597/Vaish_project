public class Main {

    public static void main(String[] args) {

        Restaurant restaurant = new Restaurant();

        Admin admin = new Admin(1,
                "Admin",
                "9876543210");

        admin.addFood(restaurant,
                new Food(1,
                        "Veg Burger",
                        120,
                        "Fast Food",
                        true));

        admin.addFood(restaurant,
                new Food(2,
                        "Pizza",
                        250,
                        "Italian",
                        true));

        admin.addFood(restaurant,
                new Food(3,
                        "Sandwich",
                        100,
                        "Snacks",
                        true));

        restaurant.displayMenu();

        Customer c1 =
                new Customer(101,
                        "Akash",
                        "9999999999");

        Customer c2 =
                new Customer(102,
                        "Rahul",
                        "8888888888");

        Payment p1 = new UpiPayment();
        Payment p2 = new CashPayment();

        CustomerThread t1 =
                new CustomerThread(
                        restaurant,
                        c1,
                        1,
                        2,
                        p1);

        CustomerThread t2 =
                new CustomerThread(
                        restaurant,
                        c2,
                        2,
                        1,
                        p2);

        t1.start();
        t2.start();

        try {

            t1.join();
            t2.join();

        }

        catch (Exception e) {
        }

        ChefThread chef =
                new ChefThread(restaurant);

        chef.start();

        try {
            chef.join();
        }

        catch (Exception e) {
        }

        DeliveryThread delivery =
                new DeliveryThread(restaurant);

        delivery.start();

    }

}
