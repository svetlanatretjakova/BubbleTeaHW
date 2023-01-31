import java.util.ArrayList;
import java.util.List;

public class OrderSession extends Subject {
    private static OrderSession instance;
    private boolean sessionInProgress;
    private List<BubbleTea> orders = new ArrayList<>();

    private OrderSession() {
        this.sessionInProgress = false;
    }

    public boolean isSessionInProgress() {
        return sessionInProgress;
    }

    public static OrderSession getInstance() {
        if (instance == null) {
            instance = new OrderSession();
        }
        return instance;
    }

    public BubbleTea orderBubbleTea(BubbleTea bubbleTea) {
        if(!sessionInProgress) {
            sessionInProgress = true;
            notifyObservers(bubbleTea);
            return bubbleTea;
        } else {
            System.out.println("A session is already in progress, wait for it to finish or start a new session");
            return null;
        }
    }

    public void finishOrderSession() {
        if (orders.isEmpty()) {
            sessionInProgress = false;
        } else {
            BubbleTea bubbleTea = orders.remove(0);
            notifyObservers(bubbleTea);
        }
    }
}
