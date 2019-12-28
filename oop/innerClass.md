### 内部类 the inner class
类中的基本组成是成员方法和属性，但是也允许在类中定义其他的类，称作内部类
#### 内部类的基本定义 the basic definition of the InnerClass
内部类本身是一个独立完善的类结构，能够进行完整的成员方法和属性的定义  
从结构性上讲内部类的结构并不合理，最大的缺陷在于破坏了程序的结构。破坏的前提是有目的的破坏。  

内部类的优势
-   减少对象实例化
-   轻松访问外部类的私有属性

#### 内部类的相关说明
-   内部类可以轻松访问外部类中私有成员方法和属性
-   外部类也可以轻松访问内部类的私有成员方法和属性
-   简化了setter、getter和其他结构

内部类实例化对象的格式如下。只有外部类实例化之后才能实例化内部类  
在内部类编译完成之后会自动形成一个“Outer\$Inner.class”的类文件。$符号对应代码中的.
>外部类.内部类 内部类对象=new 外部类().new 内部类();  

如果想要限制Inner类只在Outer类中使用，跟上关键字private

#### 接口内部接口、内部抽象类
接口也可以定义内部类
-   内部接口不一定需要实现
-   内部类也可以是抽象类
-   **接口中的内部类可以实现该接口**
```
//接口内部实现接口实现
interface IChannel{
    public void send();
    class ChannelImpl implements IChannel{
        public void send(){sysout("sdf")};}
    public Static IChannel getInstance(){
        return new ChannelImpl();}
}
public class Demo{
    public static void main(){
        IChannel channel=IChannel.getInstance();
        channel.send();
    }}
```
#### static 定义内部类
相当与将内部类变为了外部类，这个时候的实例化就会发生变化
>外部类.内部类 内部类对象=new 外部类.内部类(); 

使用static定义内部的接口，因为这些操作是属于一组相关的定义，有了static内部接口可以清晰明确的描述这些相关接口操作的主要目的。

**注意⚠️**：static定义的类或者方法只能调用Static的方法或属性;       
如果开发中发现类名称间有. 首先应该考虑这是一个内部类，如果可以直接进行实例化，则应该考虑这是一个static的内部类。static内部类定义内部接口的情况最多

#### 方法中定义内部类
实际开发中在方法中采用内部类的情况较多。对于内部类获取外部方法的参数从jdk1.8开始可以获取。如果是1.8以前，必须加上final。
主要是为了扩展函数式编程所提供的功能。
#### 匿名内部类
匿名内部类主要是接口和抽象类的子类中使用的。  
匿名内部类是一个没有名字的只能使用一次的，并且结构固定的子类
```
interface IMessage{
    public void send(String str);
}
public class LamdaDemo{
    public static void main(String args[]){
        IMessage message=new IMessage(){
            @Override
            public void send(String str){
                System.out.println(str);
            }
        };
        message.send("message");
    }
}
```