### 浮点型数据
主要用于描述小数，任意的小数常量默认为double。
-   自动类型转换，由小类型到大类型转换
-   默认浮点数类型为double，也可以定义范围更小的float必须要加强制转型或加F
-   整型计算是不包含小数点的。若要精确需要对其中一个变量转浮点型。
-   选择的数据类型，将决定计算精度。
```
public class JavaDemo{
    public static void main(String args[]){
        double x=10.2;
        int y=10;
        float z=10.0F;
        double result=x*y
        System.out.println(result);
    }
}
```