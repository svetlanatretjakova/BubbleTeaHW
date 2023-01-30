public class Main {
    public static void main(String[] args) throws Exception {

        OrderSession session = OrderSession.getInstance();
        BubbleTeaOrderObserver observer = new BubbleTeaOrderObserver();
        session.registerObserver(observer);

        BubbleTea tea = new Tea();
        tea.setDescription("Order taken");
        BubbleTea order = session.orderBubbleTea(tea);
        if (order == null) {
            System.out.println("Failed to order bubble tea");
            return;
        }
        System.out.println("Basic tea without tapioca: " + order.cost());

        session.notifyObservers(tea);

        session.finishOrderSession(); //if comment this out then tea with milk fails,
        //because one session is allowed at one time (SINGLETON PATTERN)

        BubbleTea teaWithMilk = new ExtraMilkDecorator(tea);
        BubbleTea orderWithMilk = session.orderBubbleTea(teaWithMilk);
        if (orderWithMilk == null) {
            System.out.println("Failed to order bubble tea with milk");
            return;
        }
        System.out.println("Basic tea with milk costs: " + orderWithMilk.cost());

        session.finishOrderSession();

        BubbleTea teaWithStrawberryTapioca = TapiocaDecorator.of(tea, TapiocaType.STRAWBERRY);
        BubbleTea orderWithStrawberryTapioca = session.orderBubbleTea(teaWithStrawberryTapioca);
        if (orderWithStrawberryTapioca == null) {
            System.out.println("Failed to order bubble tea with strawberry tapioca");
            return;
        }
        System.out.println("Basic tea with strawberry tapioca costs: " + orderWithStrawberryTapioca.cost());

        session.finishOrderSession();

        BubbleTea teaWithMilkAndStrawberryTapioca = TapiocaDecorator.of(teaWithMilk, TapiocaType.STRAWBERRY);
        BubbleTea orderWithMilkAndStrawberryTapioca = session.orderBubbleTea(teaWithMilkAndStrawberryTapioca);
        if (orderWithMilkAndStrawberryTapioca == null) {
            System.out.println("Failed to order bubble tea with milk and strawberry tapioca");
            return;
        }
        System.out.println("Basic tea with milk and strawberry tapioca cost: " + orderWithMilkAndStrawberryTapioca.cost());
    }

}
