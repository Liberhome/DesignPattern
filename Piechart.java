package Way2;

public class Piechart implements Chart{
    @Override
    public void display() {
        System.out.println("显示饼状图");
    }

    public Piechart() {
        System.out.println("创建饼状图");
    }
}
