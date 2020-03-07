
                                             简单工厂设计模式（版本0.2：接口）
总的来说，同样是把实例化对象这个动作完成，这个方法来得更高明。
这个方法选择使用Interface接口而非抽象类，这避免了类与类之间的继承的同时实现了面向接口编程。
****
具体来说:
第一步，抽象出所有类的接口，并且这个接口呢包含着所有类公共的方法：
```java
package Way2;

public interface Chart {
    public void display();
}
```
第二步，把所有类都定义出来，实现这个接口，并实现这个接口的抽象方法。当然了，在这个题目里面我们还加上了那本身的构造方法。构造方法的优先级是最高的，所以他会最先打印：
```java
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
```
第三步，定义一个静态工厂，根据输入的不同返回不同的输出（也就是所谓的工厂生产出不同的产品）：
```java
package Way2;

public class ChartFactory {
    //静态工厂方法
    public static Chart getChart(String type){
        Chart chart=null;
        if (type.equalsIgnoreCase("histogram")){
            chart=new HistogramChart();
            System.out.println("初始化设置柱状图");
        }
        else if (type.equalsIgnoreCase("pie")){
            chart=new Piechart();
            System.out.println("初始化设置饼状图");
        }
        else if (type.equalsIgnoreCase("line")){
            chart=new LineChart();
            System.out.println("初始化设置折线图");
        }
        return chart;
    }
}
最后来一个client测试一下：
package Way2;

public class Client {
    public static void main(String[] args) {
        Chart chart;
        chart=ChartFactory.getChart("pie");
        chart.display();
    }
}
```
****
To be continued~
