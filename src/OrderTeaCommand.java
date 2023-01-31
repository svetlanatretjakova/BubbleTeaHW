public class OrderTeaCommand implements OrderCommand {
    private BubbleTea bubbleTea;

    public OrderTeaCommand(BubbleTea bubbleTea) {
        this.bubbleTea = bubbleTea;
    }

    // . It gets the singleton instance of "OrderSession" and checks if an order session
    // is in progress. If it is, it prints a message indicating so and returns null.
    // If not, it calls the "orderBubbleTea" method on the "OrderSession"
    // instance and passes in the "bubbleTea" field as a parameter,
    // and returns the resul
    @Override
    public BubbleTea execute() {
        OrderSession orderSession = OrderSession.getInstance();
        if (orderSession.isSessionInProgress()) {
            System.out.println("Ordering is in process, wait, maybe something went wrong");
            return null;
        }
        return orderSession.orderBubbleTea(bubbleTea);
    }
}
