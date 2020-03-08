
                                      简单工厂设计模式（版本0.3：xml配置文件版本）
这个版本算是简单工程模式的究极版本。
总的来说呢，这个版本的进化之处就在于它把参数的操作（比如增加一个参数）从客户端剥离了出来。
具体的说就是弥补了上一个版本缺点，如果我们要添加新的chart，那么我们必须要更改client客户端里面的代码，每次都需要重新对代码进行修改和编译，也就是违反了我们客户端代码的开闭原则。解决方法就是我们把要新放入的参数写在一个XML文档里面。以后修改的时候就在这个文档里面做修改，做增加就行了。不去修改客户端的代码。
放参数的config.xml：
```xml
<?xml version="1.0" encoding="utf-8" ?>
<config>
    <chartType>
        histogram
    </chartType>
</config>
```
精髓之处：
```java
package Way3;

import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;

public class XMLUtil {
    public static String getChartType(){
        try {
            //创建文档对象
            DocumentBuilderFactory dFactory=DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dFactory.newDocumentBuilder();
            Document doc;
            doc=builder.parse(new File("config.xml"));
            //获取包含图表类型的文本节点
            NodeList nl=doc.getElementsByTagName("chartType");
            Node classNode=nl.item(0).getFirstChild();
            String chartType= classNode.getNodeValue().trim();
            return chartType;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
```
Client稍作修改：
```java
package Way3;


public class Client {
    public static void main(String[] args) {
        Chart chart;
        //读取配置文件中的参数
        String type=XMLUtil.getChartType();
        //创建产品对象
        chart=ChartFactory.getChart(type);
        chart.display();
    }
}
```
其他类同上一篇文章：
Design Pattern 005 SimpleFactory2 

SimpleFactory 到此结束

下期预告：FactoryPattern


To Be Continued~


