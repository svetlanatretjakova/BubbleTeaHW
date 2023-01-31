

public interface TapiocaDecorator extends BubbleTea {

    // class that will be able to handle
    // two different types of tapioca: strawberry and vanilla
    double strawberryCost = 1.0;
    double vanillaCost = 1.0;

    // The switch statement in the method creates a decorator
    // based on what type of tapioca it is being asked for.


    //method is declared as static because it does not need to access any
    // instance variables or call any instance methods. Instead, it uses only
    // the input parameters and the switch statement to determine the return value.
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
