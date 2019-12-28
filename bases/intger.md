### 整数数据
整型共四种，由小到大byte、short、int、long，那么在java中任何的一个整型常量默认类型位int型（只要是整型）
```
public class JavaDemo{
    public static void main(String args[]){
        //10不会改变，x指针可以发生变化
    int x=10;
    System.out.println(x*x);
    }
}
```
数据超过了范围
-   将类型变大类型，整型运算范围按最大计算 long+int=long 
-   将类型变小类型，用强制类型转换，考虑溢出
-   long型请用大写L方便阅读（大小写均可执行）
-   没有超过byte范围的常量可以由int变为byte
-   对常量可以自动转换，对变量必须用强制类型转换
```
public class JavaDemo{
    public static void main(String args[]){
        int max=Integer.MAX_VALUE;
        int min=Integer.MIN_VALUE;
        System.out.println(max+1);
        System.out.println(min-1);
        long num=max+2L;
        num=(int) num;
        //溢出
        System.out.println(num);
    }
}
```