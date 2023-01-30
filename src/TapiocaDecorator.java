public interface TapiocaDecorator extends BubbleTea {
    double strawberryCost = 1.0;
    double vanillaCost = 1.0;

    static TapiocaDecorator of (BubbleTea bubbleTea, TapiocaType type) throws Exception {
        switch (type) {
            case STRAWBERRY:
                return new StrawberryTapiocaDecorator(bubbleTea);
            case VANILLA:
                return new VanillaTapiocaDecorator(bubbleTea);
            default:
                throw new Exception("No such tapioca " + type );
        }
    }
}
