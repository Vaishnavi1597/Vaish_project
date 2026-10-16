public class DeliveryThread extends Thread {

    private Restaurant restaurant;

    public DeliveryThread(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {

        for (Order order : restaurant.getOrders()) {

            synchronized (order) {

                if (order.getStatus() == OrderStatus.READY) {

                    try {
                        Thread.sleep(2000);
                    }

                    catch (InterruptedException e) {
                    }

                    order.setStatus(OrderStatus.DELIVERED);

                    System.out.println(order.getOrderId()
                            + " DELIVERED");

                }

            }

        }

    }

}