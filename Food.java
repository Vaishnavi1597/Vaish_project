public class Food {

    private int foodId;
    private String foodName;
    private double price;
    private String category;
    private boolean available;

    public Food(int foodId, String foodName, double price,
                String category, boolean available) {

        this.foodId = foodId;
        this.foodName = foodName;
        this.price = price;
        this.category = category;
        this.available = available;
    }

    public int getFoodId() {
        return foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return foodId + "  " + foodName + "  ₹" + price + "  " + category;
    }
}
