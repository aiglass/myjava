### 枚举 enum
java从jdk1.5开始提供枚举。

枚举主要用于定义有限个数对象的一种结构（多例模式）。枚举就属于多利设计，并且比普通的多例设计结构更简单。
-   多利设计在编译时就能发现问题，但普通多例模式不行
-   枚举还可以使用values()方法获取所有的值，普通多例模式只能通过数组实现
-   foreach、switch都支持enum的使用
```
enum Color{//定义枚举类
    RED、GREEN、BLUE;//实例化对象
}
public class JavaDemo{
    public static void main(String args[]){
        Color c=Color.RED;//获取实例化对象
        System.out.println(c)//输出RED
}
```
#### enum类
严格讲枚举不是一个新的数据结构。枚举就是继承于Enum类的。
-   枚举中，每一个对象的序号是由定义对象时的顺序决定的
-   枚举类中可以直接定义抽象方法，每一个枚举实例必须覆写抽象方法
-   枚举还可以继承接口
-   实际生产过程中枚举用来限定实例对象的范围，不进行其他的结构的定义

enum和Enum的区别？
-   enum：是从jdk1.5之后提供的一个关键字，用于定义枚举类
-   Enum：是一个抽象类，所有使用enum关键字定义的类就默认继承了Enum

#### 定义枚举结构
**强调**，枚举类是一种多例设计模式。枚举类中的构造方法必须使用private私有化。

在枚举类中定义其他的结构
```
enum Color{//定义枚举类
    RED("红色")、GREEN("绿色")、BLUE("蓝色");//枚举对象必须写在首航
    private String title;
    private Color(String title){this.title=title};
    public String toString(){return this.title;}}
```


