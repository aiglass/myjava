### 异常处理模型
```
public void fun throws Exception(){
//普通模型
try{
}catch{
}finally{
}
}
```
#### RuntimeException
RuntimException和Exception的区别
-   RuntimeException是Exceptin的子类
-   RuntimeException标注的异常可以不进行强制的异常处理
-   Exception必须强制性的处理

RuntimeException的常见子类
    -   NoPointerException
    -   ClassCastException
    -   NumberFormatException

#### java自定义异常
实际开发过程中，自定义异常会大量的使用  
两种方案：
-   继承Exception
-   继承RuntimeException
#### assert 断言
确定代码执行到某行之后，一定是期待的结果。在实际开发中不一定是准确的。作为一种检测手段使用。  
启用断言java -ea Demo 才会执行断言
```
public class Demo{
    public static void main(String args[]){
        int x=10;
        //省略中间步骤
        assert x ==100:"x的内容不是100";
        System.out.println(x);
    }
}
```