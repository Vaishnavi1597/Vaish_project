public class ChefThread extends Thread {

    private Restaurant restaurant;

    public ChefThread(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {

        for (Order order : restaurant.getOrders()) {

            synchronized (order) {

                if (order.getStatus() == OrderStatus.PLACED) {

                    order.setStatus(OrderStatus.PREPARING);

                    System.out.println("\nChef is preparing "
                            + order.getOrderId());

                    try {
                        Thread.sleep(3000);
                    }

                    catch (InterruptedException e) {
                    }

                    order.setStatus(OrderStatus.READY);

                    System.out.println(order.getOrderId()
                            + " is READY");
                }

            }

        }

    }

}
