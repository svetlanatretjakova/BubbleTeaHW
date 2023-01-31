public class StrawberryTapiocaDecorator extends BubbleTeaDecorator implements TapiocaDecorator{
    public StrawberryTapiocaDecorator(BubbleTea bubbleTea) {
        super(bubbleTea);
    }

    @Override
    public double cost() {
        return super.cost() + strawberryCost;
    }

    @Override
    public String description() {
        return "Tea with strawberry tapioca";
    }
}
