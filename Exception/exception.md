### 异常 exception
异常是导致程序中断执行的一种指令流。
程序出现错误后，整个程序将不会按照既定的方式进行执行，而是中断执行。  
为了保障程序在非致命错误出现之后依然能顺利执行，就需要一个办法对异常进行处理。  
>10/0 会报错，导致内存被占满

#### 异常处理 Exception Handling
try、catch、finally
```
try{
    //可能出现异常的语句
}catch(异常类型 异常对象){
    //异常处理
}[finally{
    //不管异常是否处理都要执行
}]
```
异常相关函数
Name                |   description
:--                 |:--
e.printStackTrace() |展示异常的详细信息
e.getString()       |展示异常的部分信息

#### 处理多个异常
程序中可能产生多个异常，可以通过多个catch进行异常的捕获和处理。
-   如果没有正确的catch到异常，那么程序也会中断，finally的代码依然执行
java异常处理流程
![屏幕快照 2019-12-09 下午7.50.11](http://mysource.moneygc.com/%E5%B1%8F%E5%B9%95%E5%BF%AB%E7%85%A7%202019-12-09%20%E4%B8%8B%E5%8D%887.50.11.png)

-   程序运行的过程中才会产生异常
-   异常产生后会自动实例化相关的异常类对象
-   如果没有找到相关的异常，直接打印异常信息，程序中断执行（JVM默认异常的处理模式）
-   如果try捕获到异常，会与catch中的类进行匹配，匹配则输出，不匹配则继续下一个catch
-   不管有没有没有匹配成功，都会执行final代码。
-   final执行后会判断是否处理了异常，没处理则进行JVM默认的异常处理模式，处理了则继续执行其他代码。

程序当中能够处理的最大的异常类型就是Throwable  
>object >Throwable >Exception >RuntimException >ArithmeticException(范围比较)

Throwable中常见的类
-   Error：此时程序还未执行出现的错误，开发者无法处理
-   Exception：程序中出现的异常，开发者可以处理，实际开发中需要关注的类
-   实际所有的异常都可以使用Exception类进行处理。虽然很方便，但描述的信息不方便异常的查找

#### throws关键字
定义一个方法，就应该明确告诉使用者可能产生的异常。可以在方法声明使用throws关键字
```
//表示代码执行时可能产生异常，如果异常产生调用ArithmeticException类
public static int div(int x,int y) throws ArithmeticExcepion{
    return x/y;
}
```
#### throw关键字
与throws对应的throw关键字，主要作用表示手工抛出异常。
>throw new Exception("手工抛异常");

**面试题**：简述Throw和throws的区别
-   throw：代码块中使用，手工抛出异常对象
-   throws：是在方法定义时使用，表示将此方法中可能产生的异常明确的告诉给调用处，进行异常的处理