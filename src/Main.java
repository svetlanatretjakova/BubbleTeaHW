public class Main {


    public static void main(String[] args) throws Exception {

        OrderSession session = OrderSession.getInstance();

        BubbleTeaOrderObserver observer = new BubbleTeaOrderObserver();
        session.registerObserver(observer);

        BubbleTea tea = new Tea();
        //OrderCommand teaCommand = new OrderTeaCommand(tea);
        //OrderQueue orderQueue = new OrderQueue();
        //orderQueue.addOrder(teaCommand);
        //orderQueue.processOrders();

        BubbleTea order = session.orderBubbleTea(tea);
        if (order == null) {
            System.out.println("Failed to order bubble tea");
            return;
        }
        System.out.println("Basic tea without tapioca: " + order.cost());
        session.finishOrderSession();




        //start a new order session
        session = OrderSession.getInstance();

        BubbleTea teaWithMilk = new ExtraMilkDecorator(tea);
        BubbleTea orderWithMilk = session.orderBubbleTea(teaWithMilk);
        if (orderWithMilk == null) {
            System.out.println("Failed to order bubble tea with milk");
            return;
        }
        System.out.println("Basic tea with milk costs: " + orderWithMilk.cost());
        session.finishOrderSession();



        session = OrderSession.getInstance();

        BubbleTea teaWithOneExtraMilk = new ExtraMilkDecorator(tea);
        BubbleTea teaWithTwoExtraMilks = new ExtraMilkDecorator(teaWithOneExtraMilk);
        BubbleTea orderWithTwoExtraMilks = session.orderBubbleTea(teaWithTwoExtraMilks);
        if (orderWithTwoExtraMilks == null) {
            System.out.println("Failed to order bubble tea with two extra milks");
            return;
        }
        System.out.println("Basic tea with two extra milks costs: " + orderWithTwoExtraMilks.cost());
        session.finishOrderSession();





        //start a new order session
        session = OrderSession.getInstance();
        BubbleTea teaWithStrawberryTapioca = TapiocaDecorator.of(tea, TapiocaType.STRAWBERRY);
        BubbleTea orderWithStrawberryTapioca = session.orderBubbleTea(teaWithStrawberryTapioca);
        if (orderWithStrawberryTapioca == null) {
            System.out.println("Failed to order bubble tea with strawberry tapioca");
            return;
        }
        System.out.println("Basic tea with strawberry tapioca costs: " + orderWithStrawberryTapioca.cost());
      //  session.finishOrderSession();



        session = OrderSession.getInstance();
        BubbleTea teaWithTwoStrawberryTapiocas = TapiocaDecorator.of(TapiocaDecorator.of(tea, TapiocaType.STRAWBERRY), TapiocaType.STRAWBERRY);
        BubbleTea orderWithTwoStrawberryTapiocas = session.orderBubbleTea(teaWithTwoStrawberryTapiocas);
        if (orderWithTwoStrawberryTapiocas == null) {
            System.out.println("Failed to order bubble tea with two strawberry tapiocas");
            return;
        }
        System.out.println("Basic tea with two strawberry tapiocas costs: " + orderWithTwoStrawberryTapiocas.cost());
        session.finishOrderSession();

    }
}
