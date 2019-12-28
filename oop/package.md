### package 包
#### 包的定义与使用
现代开发中一个软件项目往往由多个成员进行开发，为了避免类和方法的重名，引入了包的概念。  
-   包的本质就是一种目录
-   程序中有包之后，就需要将*.class放入包中
-   javac -d . Hello.java进行打包编译 .表示当前目录
-   java com.moneygc.demo.Hello 进行执行
```
package com.moneygc.demo;//定义包，其中.表示分割子目录
public class Hello{
    public static void main(){
        System.out.println("hello world");
    }
}
```
#### 包的导入
利用包的定义实际上是将不同的功能的类保存到包中，包之间支持导入引用.  
-   import关键字，在引入包内所以类时 使用通配符(包.*),只会加载需要的程序类
-   多个子类需要编译用javac -d . *.java进行编译

导入规则
-   public class：类名称必须与文件名称保存一致，一个*.java文件只能有一个public 类，其他类想引用就必须使用public修饰
-   class：类名称可以与文件名称不一致，并且一个*.java文件里面可提供多个class类定义，编译后将形成不同的*.class文件 ，但这些类只能在本包所访问，外包无法访问
-   实际开发中*.java只会提供一个public class主类
-   包名称使用小写

思考🤔？引用的两个包中有两个相同的类名怎么办？
-   直接跟上包名，使用完整名称进行实例化
#### 包的静态导入
假如一个类中全部都是static静态方法。就可以直接使用静态导入处理。
```
public class Math{
    public static void add(){sysout};
    public static void cut(){sysout};
}
```
-   import static com.moneygc.demo.Math.*;
-   可以在主方法中直接调用
#### Jar命令
当一个项目开发完成后会存在大量的*.class文件，那么对这些文件就需要进行压缩打包处理，在java中称为jar文件，可直接使用jdk提供的jar命令使用完成  
-   对程序进行编译与打包处理
    -   javac -d . Class.java
    -   此时会形成com的包，暴力包含子包和*.class，将其打包为moneygc.jar,命令jar -cvf moneygc.jar com 
        -   c:创建一个新的jar文件
        -   v：得到一个详细输出信息
        -   f：设置jar文件的名称
        -   m：包含文件清单消息

每一个jar文件都是一个独立的程序路径，如果想要java使用此路径，必须通过SET CLASSPATH=.;jar文件路径\moneygc.jar 进行设置  

-   jdk1.9以前，实际上提供的是所有类的*.jar文件（tool.jar、rt.jar）,传统的开发之中只要启动了JVM虚拟机，就需要加载几十兆的文件
-   jdk1.9之后提供了一个模块的设计，将原本很大的*.jar文件变成了若干个文件，在启动程序时加载指定的模块，提高了程序启动速度

#### 系统常见包
java提供了大量的支持类库
-   java自身提供的jdk类库
-   java自身提供的类库标准
-   第三方开发的第三方类库，并且支持的厂商很多

常见包
-   java.lang：String、Number、Object等类在这个包里面，这个包在1.1jdk之后会自动加载不用import
-   java.lang.reflect:反射机制处理包，所有的设计从这里开始
-   java.util:工具类，包括数据结构的定义
-   java.io:输入输出流操作的程序包
-   java.net:网络程序开发的程序包
-   java.sql:数据库编程的开发包
-   java.applet:java的最原始的使用形式，直接嵌套在网页上执行的程序类
    -   现在的程序已经以Application为主了
-   java.awt\javax.swing:java的图形界面开发包（Gui），其中awt属于重类型组件，swing属于轻类型的组件，swing是jdk1.2的更新标志

