### lamda表达式
从jdk1.8开始简化使用者进行代码的开发。专门提供了lamda表达式的支持。
利用函数式编程可以避免面向对象繁琐的代码结构

函数式编程的代表：haskell、Scala
```
@FunctionalInterface
interface IMessage{
    public void send(String str);
}
public class LamdaDemo{
    public static void main(String args[]){
        IMessage msg=(str)->{
            System.out.println("发送消息"+str);
        };
        msg.send("message");
    }
}
```

lamda的实现要求：SAM（single Abstract Method），只有一个抽象方法，以IMessage接口为例只提供了一个send方法，这样的方法就称为函数式接口。为了方便说明使用@FunctionalInterface注释。函数式接口里面的方法只能有一个。

#### 实现格式 
-   方法没有参数：()->{}
-   方法有参数：(参数1、参数2)->{}
-   如果只有一行语句返回：(参数1、参数2)->语句;
```
@FunctionalInterface
interface IMessage<R>{
    public R send();
}
public class LamdaDemo{
    public static void main(String args[]){
        IMessage<String> msg=()->"sdg";
        System.out.println(msg.send());
    }
}
```
#### 方法引用
引用数据类型最大的特点是进行内存指向处理。jdk1.8之前只有对象的引用。jdk1.8开始支持方法的引用。最多至少弥补了引用支持功能的不足。

-   引用静态方法：类名称：：static方法名称
-   引用某个实例对象的方法：实例话对象::普通方法
-   引用特定类型的方法：特定类：：普通方法
    -   实现不实例化类，直接引用方法
-   引用构造方法：类名称::new

方法引用的好处  
可以实现方法名称的定义，可以给一个方法多个名字
```
//引用静态方法实例
@FunctionalInterface
interface IMessage<R>{
    public R upper();
}
public class LamdaDemo{public static void main(String args[]){
    IMessage<String> fun="www.moneygc.com"::toUpperCase;
    System.out.println(fun.upper());
}
}
```
```
//引用特定类的方法
@FunctionalInterface
interface IMessage<R>{
    public int compare(R r1,R r2);
}
public class LamdaDemo{public static void main(String args[]){
    IMessage<String> fun=String::compareTo;
    System.out.println(fun.compare("a", "A"));}}
```
