
                                              简单工厂设计模式（版本0.1：抽象类）
总的来说这个初级版本的简单工厂初步完成了把生成对象这个步骤剥离出来，使得开发更加高效。
根据下面代码即将要举的例子详细说来就是：先定义一个抽象类Product（里面包含了一个不太需要关注的普通方法methodSame和一个这里需要重点关注的抽象方法methodDiff），
随后定义两个（或者更多个，看你需要生产多少个类型的）具体的产品类ConcreteProductA，ConcreteProductB 来继承Product(当然，必须重写抽象方法methodDiff)，然后，重头戏来了，定义一个工厂类Factory，根据输入返回不同的Product，这也就是这个初级版本简单工厂模式的精髓所在；最后定义一个测试类Client即可。
****
```java
public abstract class Product {
    public void methodSame(){
    }

    public abstract void methodDiff();
}

public class ConcreteProcuctA extends Product
{
    @Override
    public void methodDiff() {
    }
}

public class Factory {
    public static Product getProduct(String arg){
        Product product=null;
        if (arg.equalsIgnoreCase("A")){
            product = new ConcreteProcuctA();
            //初始化完成设置product
        }
        else if (arg.equalsIgnoreCase("B")){
            product = new ConcreteProcuctB();
            //初始化完成设置product
        }
        return product;
    }
}

public class Client {
    public static void main(String[] args) {
        Product product;
        product=Factory.getProduct("A");
        product.methodSame();
        product.methodDiff();
    }
}
```
****
To Be Continued~
