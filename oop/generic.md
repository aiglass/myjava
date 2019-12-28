### generic 泛型
泛型从jdk1.5开始使用，主要目的是为了解决ClassCastException。java向下转型永远都可能存在有安全隐患，java希望通过泛型慢慢减少问题。

#### 泛型的需求

假设：定义一个描述x、y坐标的处理类，并且这个类中允许报错多种数据类型
-   整型：x=10 y=20
-   浮点型：x=10.1 y=20.9
-   字符串型：x=东经120度 y=北纬30度  

设计：  
**原始的做法**  
利用object类进行定义，利用转型关系可实现
-   整型：int->Integer->int
-   浮点型：float->Floter->float
-  字符串型：String->自动转为对象    

问题：利用object方法编译时不会出错，而程序执行时会出现“ClassCastException”异常类型，所以本程序是存在安全隐患的。由于object能接收的范围太广，所以要想办法避免向下转型的出现。

#### 泛型的定义
如果要避免“ClassCastException”，最直接的办法是避免出现强制类型转换。jdk1.5开始应用的泛型技术，可以起到这种作用。  
泛型的本质在于，**类中的属性与方法的参数与返回值的类型可以由对象实例化之时动态设置**。  

**泛型标记**：在类定义的时候使用定义占位符（泛型标记）。  
```
class A <T>{
    public T say(T t){return t;}}
public class genericDemo {
    public static void main(String[] args) {
        A<Integer> a=new A<Integer>();
        System.out.println(a.say(1));
        A<String> b=new A<String>();
        System.out.println(b.say("我是b"));}}
```
-   \<T>  T表示type的简写
-   实例化对象对象时使用Integer就会将T全部替换为Integer（并局限在该对象中）
-   如果设置的内容不符合类型要求，编译就会提示错误
-   并且避免了对象的向下转型处理，也就避免了类型不能指定的安全隐患
-   泛型只支持引用数据类型
-   大部分的类对象的强制转换处理，使用泛型
-   jdk1.7之后可以new Class<>()进行简写  

*提示*：关于默认的泛型。（泛型属于jdk1.5之后的产物，为了保障1.5之前程序的接口或类在出现泛型之后，原始的程序类依然可以使用，在不设置泛型的情况下保障程序的正常执行，默认为object类。但是编译过程中会出现警告warning）
#### 泛型通配符
虽然泛型解决了数据类型的转换问题，但是又产生了新的问题，引用传递问题。
思考🤔？一个方法中传入多种数据类型，怎么搞？

-   如果接收方法中不指定泛型，则会有数据修改的漏洞，可以对传入的数据进行统一的修改
-   想要使用泛型，在面对多种类型时只有使用泛型通配符“？”
-   "?"通配符的基础上实际还提供了两类小的通配符
    -   ?extends 类：设置泛型的上限制
        > 例如：?extends Number:表示只能使用Number或Number的子类
    -   ?super 类：设置泛型的下限制
        > 例如：?super String:只能使用String或其父类
```
class A <T>{
    private T letter;
    public A(T letter){this.letter=letter;}
    public void setLetter(T letter) {this.letter = letter;}
    public T say(){return this.letter;}    
}
public class genericDemo {
    public static void main(String[] args) {
        A<Integer> a=new A<>(1);
        find(a);
    }
    public static void find(A<?> lettr){
        //letter.setLetter(1.1);
        System.out.println(lettr.say());}}
```
#### 泛型接口
泛型可以在类中使用，也可以在接口中使用
```
interface IMessage<T>{
    public String echo(T t);}
```
对泛型接口的子类有两种实现方式
```
//方式一：子类中继续设置泛型定义
class MessageImp1<S>implements IMessage<S>{
    public String echo(S t){return "[echo]"+t;}}
//方式二：在子类实现父接口的时候直接定义数据类型
class MessageImp2 implements IMessage<String>{
    public String echo(String t){return "[echo]"+t;}}
```
#### 泛型方法
在之前的程序类中可以发现泛型标记写到方法中，这样的方法就是泛型方法。  
**泛型方法不一定出现在泛型类中**  
后期开发中，泛型方法非常常见
```
public class Demo{
    public static void main(String args[]){
        sysout(fun("123"));}
    public static <T> T[] fun(T...args){
        return args;}}
```
###### 传统工厂设计模式通过泛型优化
![屏幕快照 2019-12-09 下午1.05.19](http://mysource.moneygc.com/%E5%B1%8F%E5%B9%95%E5%BF%AB%E7%85%A7%202019-12-09%20%E4%B8%8B%E5%8D%881.05.19.png)

通过泛型优化:在返回时用（T）进行限定
```
class FoodFactory{
    public static <T> T eatFood(String classname){
        System.out.println(classname);
        if("bread".equals(classname)){
            return (T) new Bread();
        }else{
            return (T) new Nofood();
        }
    }
}
```