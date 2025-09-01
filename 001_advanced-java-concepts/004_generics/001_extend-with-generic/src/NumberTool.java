public class NumberTool<T extends Number>{
    public double cube(T value) {
        return Math.pow(value.doubleValue(),3);
    }
}

