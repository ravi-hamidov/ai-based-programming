public class Main {
    public static void main(String[] args) {
        System.out.println("--- NumberTool<Integer> Testi ---");
        NumberTool<Integer> integerTool = new NumberTool<>();
        int intValue = 5;
        double integerCube = integerTool.cube(intValue);
        System.out.println(intValue + " reqemin kubu: " + integerCube);
        System.out.println();

        System.out.println("--- NumberTool<Double> Testi ---");
        NumberTool<Double> doubleTool = new NumberTool<>();
        double doubleValue = 2.5;
        double doubleCube = doubleTool.cube(doubleValue);
        System.out.println(doubleValue + " reqeminin kubu: " + doubleCube);
        System.out.println();

        // NumberTool<String> stringTool = new NumberTool<>();
        // String uchun numberTool yaradila bilmez chunki number deyil
    }
}