import java.util.ArrayList;
import java.util.List;

public class OrderQueue { //method that will process the orders in an order queue.
    private List<OrderCommand> orderCommands =  new ArrayList<>();

    public void addOrder(OrderCommand orderCommand) { //
        //adds the given order command to the list,
        // and processOrders iterates through all the commands in orderCommands
        orderCommands.add(orderCommand);
    }
//then removes them from the list so they can be executed again later
    public void processOrders() {
       for (OrderCommand orderCommand : orderCommands) {
           orderCommand.execute();
       }
       orderCommands.clear();
    }
}
