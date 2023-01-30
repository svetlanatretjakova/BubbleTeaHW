import java.util.ArrayList;
import java.util.List;

public class OrderSession extends Subject {
    private static OrderSession instance;
    private boolean sessionInProgress;



    private OrderSession() {
        this.sessionInProgress = false;
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
            System.out.println("Ordering is in process, wait");
            return null;
        }
    }

    public void finishOrderSession() {
        sessionInProgress = false;
    }


}
