### 方法
-   java中的方法用method，函数用function
-   方法为了方便程序的重复调用
#### 方法的基本定义
-   方法名称采用**第一个字母小写**的驼峰命名
-   方法定义的前提：方法在主类中，并且由主方法直接调用
-   方法可以被重复调用
-   方法可以进行返回数据的处理
-   return的返回值需与方法声明的返回值类型相同
-   不返回数据则该方法可以使用void进行声明
-   return执行跳出当前方法
-   java方法通常不会有太多行
```
public static 返回值类型 方法名([参数类型 变量]){
    //执行代码
    [return [返回值];]//
}
```
#### 方法重载
-   当方法名相同，参数类型或个数不同时就称为方法重载。
-   同一个方法名称，可以通过输入不同的数据类型调用对应方法。
-   方法的重载与方法的返回值类型没有直接关系
-   强烈建议方法重载的返回值类型相同
-   System.out.println就是方法重载
#### 方法的递归调用
方法调用自己的情况，利用递归调用可以解决一些复杂重复的问题。
-   一定要设置方法的结束条件
-   每一次调用一定要修改传递的参数条件
-   实际开发中减少递归的使用。空间复杂度高
-   处理不当会导致栈帧溢出
-   有一部分递归可以用循环结构替代
```
//计算1到90的阶乘的和
//考虑数据类型用double
public class JavaDemo{
    public static void main(String args[]){
        System.out.println(sum(90));
    }
    public static double sum(double x) {//计算从1到x的和
        if(x==1){
            return fan(1);
        }
        return fan(x)+sum(x-1);//当前的值+下一个值的阶乘
    }
    public static double fan(double y) {//计算从1到y的乘积
        if(y==1){
            return 1;
        }
        return y*fan(y-1);//当前的乘积*下一个值
    }
}
```