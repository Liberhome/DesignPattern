package Way2;

public class HistogramChart implements Chart{
    @Override
    public void display() {
        System.out.println("显示柱状图");
    }

    public HistogramChart() {
        System.out.println("创建柱状图");
    }
}
