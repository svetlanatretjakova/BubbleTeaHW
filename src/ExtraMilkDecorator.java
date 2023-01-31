public class ExtraMilkDecorator extends BubbleTeaDecorator{
    public ExtraMilkDecorator(BubbleTea bubbleTea) {
        super(bubbleTea);
    }

    @Override
    public double cost() {
        return super.cost() + 1.50;
    }

    @Override
    public String description() {
        return "Tea with some extra milk";
    }
}
