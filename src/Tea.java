public class Tea implements BubbleTea {
    @Override
    public double cost() {
        return 3.0;
    }

    @Override
    public String description() {
        return "Just a simple green tea";
    }
}
