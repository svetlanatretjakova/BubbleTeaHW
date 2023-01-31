
//decorator for "BubbleTea" objects
abstract class BubbleTeaDecorator implements BubbleTea {
    BubbleTea bubbleTea;


    //constructor that takes a "BubbleTea" object as an argument,
    // which it assigns to the instance variable "bubbleTea"
    public BubbleTeaDecorator(BubbleTea bubbleTea) {
        this.bubbleTea = bubbleTea;
    }

    @Override
    public double cost(){
        return bubbleTea.cost();
    }
}
