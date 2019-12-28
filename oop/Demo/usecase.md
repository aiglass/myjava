#   案例分析一
定义一个ClassName接口，接口中只有一个抽象方法getClassName();  
设计一个类Company,并实现getClassName()方法，功能是获取该类的名称;   
编写应用程序使用Company类
```
interface IClassName {
    public abstract String getClassName();
}
class Company implements IClassName {
    public String getClassName(){
        return "Company";
    }
}
public class CompanyDemo {
    public static void main(String[] args) {
        IClassName ica=new Company();
        System.out.println(ica.getClassName());
    }
}
```
# 案例分析二  
考虑一个绘图的标准，并且可以更具不同的图形来进行绘制；
keywords：graphical dot line circular square rectangle trangle 
![屏幕快照 2019-12-09 上午12.47.31](http://mysource.moneygc.com/%E5%B1%8F%E5%B9%95%E5%BF%AB%E7%85%A7%202019-12-09%20%E4%B8%8A%E5%8D%8812.47.31.png)

#   案例分析三
定义类Shape，用来表示一般二维图新。Shape具有抽象方法area和perimeter。  
定义一些二维形状（如矩形、三角形、圆形、椭圆形等），这些均为shape子类  

**使用工厂设计模式**：是为了隐藏子类
![屏幕快照 2019-12-09 上午1.05.08](http://mysource.moneygc.com/%E5%B1%8F%E5%B9%95%E5%BF%AB%E7%85%A7%202019-12-09%20%E4%B8%8A%E5%8D%881.05.08.png)

