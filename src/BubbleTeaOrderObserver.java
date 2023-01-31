public class BubbleTeaOrderObserver implements OrderObserver {
    @Override
    public void update(BubbleTea bubbleTea) {
        System.out.println("I am updating the observers about " +
                "what has just been ordered: " + bubbleTea.description() + " was ordered");
    }
}

