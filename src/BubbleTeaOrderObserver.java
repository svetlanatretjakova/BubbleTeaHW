public class BubbleTeaOrderObserver implements OrderObserver {
    @Override
    public void update(BubbleTea bubbleTea) {
        System.out.println("Order status updated: " + bubbleTea.getDescription());
    }
}

