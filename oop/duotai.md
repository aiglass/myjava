### 多态
**多态**：多态性是在继承性的基础上拓展出来的概念，实现父子类之间的互相转换处理
#### 多态的基本概念
-   方法的多态性
    -   重载：同一方法名，根据传递参数的类型和个数不同选择性执行
    -   覆写：同一个方法，可能因为子类的不同使用而得到覆写
-   对象的多态性：父子实例之间的转换处理，两种模式。类似基本类型间的转换
    -   对象向上转型：父类 父类实例=子类实例【自动完成转换】
    -   对象向下转型：子类 子类实例=（子类）父类实例【强制完成转换】
    -   实际开发过程中，经常采用向上转型（90%）。需要使用子类的特殊功能时采用向下转型（3%）。

#### 对象转型
对象转型的处理属于多态性。这一特性必须在继承的基础上才能实现
**向上转型的优势**
-   可以实现接收参数的统一设计
-   可实现返回参数的统一设计
```
class A {    
    public void print(){System.out.println("a");}
}
class B extends A{
    public void print(){System.out.println("b");}
}
class C extends A{
    public void print(){System.out.println("c");}
}
public class Demo {
    public static void getClass(A a){a.print();}
    public static void main(String[] args) {
        getClass(new B());
        getClass(new C());
    }}
```
**向下转型**
可以调用子类自己定义的一些特殊处理。
-   向下转型的前提是必须要先向上转型
-   使用向下转型时先用instanceof先进行判断
```
class Supperman extends Human {
    public void fly(){System.out.println("我会飞");};
    public void fire(){System.out.println("我会喷火");};
}
public class DuotaiDemo {
    public static void main(String[] args) {
        Human man=new Supperman();//向上转型
        man.speak();
        Supperman man2=(Supperman) man;//向下转型
        man2.fly();
    }
}
```

#### instanceof关键字
向下转型本身是存在一件安全隐患的事，使用关键字instanceof可以判断某个实例是不是某个类的对象
```
// 对象 instanceof 类
```
