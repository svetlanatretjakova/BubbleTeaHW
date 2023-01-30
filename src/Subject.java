import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class Subject {

    private List<OrderObserver> observers = new ArrayList<>();


    public void registerObserver(OrderObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers(BubbleTea bubbleTea) {
        for (OrderObserver observer : observers) {
            observer.update(bubbleTea);
        }
    }
}
