public class ExtraMilkDecorator extends BubbleTeaDecorator{
    public ExtraMilkDecorator(BubbleTea bubbleTea) {
        super(bubbleTea);
    }

    @Override
    public double cost() {
        return super.cost() + 1.50;
    }
}
