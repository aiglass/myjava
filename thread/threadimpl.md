### 多线程的实现
要在java中进行多线程的定义，需要一个专门的线程主体类进行线程的执行任务的定义，只有继承特定的接口或特定的父类才能实现

#### 继承thread类实现多线程
java 中提供java.lang.Thread的程序类，一个类只要继承了此类就是多线程的主体类。
1.  引入java.lang.Thread 
2.  新建MyThread 继承Thread。
3.  覆写run()
    -   多线程要实现的功能都应该在run()方法中执行。
    -   run()方法不能直接被调用，因为run()方法牵扯到系统资源调用，要想启用run()方法，必须用Start()执行(public void start())。
4.  实例化MyThread
5.  实例化对象调用start()
    -   start()会抛出一个IllegalThreadStateException，一定是RuntimException的子类。
    -   每一个线程类只能启动一次。如果重复启动了threadStatus！=0 并抛出IllegalThreadStateException异常
    -   多线程必须调用start（），因为只有start0（）能调用操作系统的资源
    -   native 关节字：表示本地底层方法

#### JNI（java native interface）
java考虑到对不同层次开发者的需求，所以其支持有本地的操作系统函数，称为JNI。但是开发过程中不推荐这样使用，利用JNI可以调用操作系统底层系统，而在thread类里面提供的start0（）就表示需要将此方法依赖于不同的操作系统实现。
![屏幕快照 2019-12-11 下午8.38.27](http://mysource.moneygc.com/%E5%B1%8F%E5%B9%95%E5%BF%AB%E7%85%A7%202019-12-11%20%E4%B8%8B%E5%8D%888.38.27.png)

#### 基于Runnable接口实现多线程
虽然thread类的继承可以实现多线程的定义。但是java程序面对于继承永远都存在有单继承局限的。所以在java中又提了第二种多线程的主体实现形式：实现java.lang.runnable的接口。Runnable从jdk1.8引入lambda表达式之后就变为了函数式的接口。

对Runnable接口实现后，发现Start()方法不能直接调用。然后不用Thread.start()就无法进行多线程的启动的。那么这个时候就需要对Thread类提供的构造方法进行观察。
-   构造方法：public Thread(Runnable target);
-   由于只是实现了Runnable接口的对象，所以此时线程主体类上就没有了单继承的局限，那么这样的设计才是一个标准的设计。
-   由于Runnable接口使用了函数式接口定义，那么可以使用lambda方法进行多线程的实现

以后的多线程尽量使用runnable来实现，runnable可以避免单继承局限，同时可以更方便的进行功能的扩展。

从结构上观察Thread与Runnable的联系，打开Thread类的定义。
>public  class Thread implements Runnable

发现Thread类也是Runnable的接口的子类，那么在之前继承Thread类的时候，实际上还是覆写的Runnable的润run方法

![屏幕快照 2019-12-11 下午9.22.47](http://mysource.moneygc.com/%E5%B1%8F%E5%B9%95%E5%BF%AB%E7%85%A7%202019-12-11%20%E4%B8%8B%E5%8D%889.22.47.png)
多线程的设计之中，使用了代理设计模式的结构，用户自定义的线程主体只负责项目核心功能的实现，而所以的辅助实现全部由Thread类实现。

在Thread启动多线程的时候调用的是start（）方法，而后找到的是run（）方法。但通过Thread传递了一个runnable接口对象的时候，会用一个target属性保存，在start方法执行的时候会调用thread类中的run（）方法，而这个run（）方法去调用的是Runnable 的接口子类的run（）方法。

多线程开发的本质实质上是在于多个线程可以进行同一资源的抢占，那么Thread主要描述的线程，runnable描述的是资源。

![屏幕快照 2019-12-11 下午9.49.04](http://mysource.moneygc.com/%E5%B1%8F%E5%B9%95%E5%BF%AB%E7%85%A7%202019-12-11%20%E4%B8%8B%E5%8D%889.49.04.png)

思考🤔？写一个卖票的程序
```
class Ticket implements Runnable {
    private String name;
    private int ticket = 5;
    public Ticket(String name) {
        this.name = name;
    }
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(this.ticket==0)break;
            System.out.println(this.name + "卖票.ticket=" + this.ticket--);
        }}}
public class TicketsDemo {
    public static void main(String[] args) {
        Ticket piao=new Ticket("大麦网");
        new Thread(piao).start();
        new Thread(piao).start();
        new Thread(piao).start();}}
```
![屏幕快照 2019-12-11 下午10.11.32](http://mysource.moneygc.com/%E5%B1%8F%E5%B9%95%E5%BF%AB%E7%85%A7%202019-12-11%20%E4%B8%8B%E5%8D%8810.11.32.png)

#### Callable实现多线程
从传统的开发来讲如果要进行多线程的开发肯定要依靠Runnable，但是Runnable的接口又一个缺点，线程完成之后无法获取返回值，不能保障执行结果的成功！所以从jdk1.5之后提出了一个新的线程实现接口，java.util.concurrent.Callable.
Callable 也是一个函数式接口
```
public interface Callable<v>{
    public V call() throws Exception;
}
```
可以发现Callable定义的时候可以设置一个泛型，此泛型的类型就是返回数据的类型。这样的好处是可以避免向下转型带来的安全隐患。
![屏幕快照 2019-12-11 下午10.31.16](http://mysource.moneygc.com/%E5%B1%8F%E5%B9%95%E5%BF%AB%E7%85%A7%202019-12-11%20%E4%B8%8B%E5%8D%8810.31.16.png)

Runnable与Callable的区别
-   Runnable是在jdk1.0提出的多线程实现接口，而Callable是在jdk1.5后提出的
-   java.lang.Runnable接口之中只提供了一个run（）方法，并且没有返回值
-   java.util.concurrent.Callable接口提供有Call（）方法，并且可以获得返回值。

#### 线程运行状态
对于多线程的开发而言，编写程序的过程之中总是按照：定义线程主体类，而后通过Thread类进行线程类启动。并不是意味着调用了Start（）方法就开始运行线程了，因为整体的线程处理有自己的一套运行的状态。

![屏幕快照 2019-12-11 下午11.02.18](http://mysource.moneygc.com/%E5%B1%8F%E5%B9%95%E5%BF%AB%E7%85%A7%202019-12-11%20%E4%B8%8B%E5%8D%8811.02.18.png)

1.  任何一个线程的对象都应该使用Thread类进行封装，所以线程的启动使用Start（），但是启动的时候，线程都进入一种就绪状态，现在并没有执行。
2.  进入到就绪状态之后就需要等待资源调度，当某一个线程调度成功之后则进入到运行状态（run方法），但是所有的线程都不可能一致持续执行下去，中间需要产生一些暂停的状态，例如：耨个线程执行一段时间之后就需要让出资源；而后这个线程就将进入阻塞状态，随后重新回归到就绪状态。
3.  当run方法执行完毕后，实际上主要的任务也就完成了，此时线程进入到终止的状态。