abstract class BubbleTeaDecorator implements BubbleTea {
    BubbleTea bubbleTea;

    public BubbleTeaDecorator(BubbleTea bubbleTea) {
        this.bubbleTea = bubbleTea;
    }

    @Override
    public double cost(){
        return bubbleTea.cost();
    }
}
