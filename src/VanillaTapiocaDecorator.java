public class VanillaTapiocaDecorator extends BubbleTeaDecorator implements TapiocaDecorator{
    public VanillaTapiocaDecorator(BubbleTea bubbleTea) {
        super(bubbleTea);
    }

    @Override
    public double cost() {
        return super.cost() + vanillaCost;
    }
}
