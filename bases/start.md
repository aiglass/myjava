java编程起步
---
#### java需经过两次处理后才可正常执行
1.  对源代码进行编译：javac Demo.java 
    - 利用jvm进行编译，生成字节码文件（*.class）
2. 在jvm上进行程序的解释执行： java Demo
    - 对字节码文件进行解释，字节码文件的后缀不需要编写
#### java类
类是java程序开发中最基础的单元，所有程序都必须封装在类中执行,
-   类的基本定义
-   类的命名采用首字母大写的驼峰命名法
    ```
    //实际项目开发过程中一个*.java中一般只有一个class
    //方式一:类名称必须和文件名称保持一直
    public class ClassName{    }
    //方式二:一个*.java文件可以有多个class,编译后会生成多个*.class文件
    class ClassName{    }
    ```
#### java主方法
-   主方法是所有程序执行的起点，并且一定要定义在类中
-   通常main()主方法所在类被称为主类，用public class来定义
    ```
    [public] class ClassName{
        public static void main(String[] args){
            //程序代码由此开始执行
        }
    }
    ```
#### 屏幕打印
-   输出后换行：System.out.println();
-   输出后不换行：System.out.print()；**ln:表示换行**