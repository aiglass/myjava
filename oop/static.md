### static关键字
可以用来定义属性和方法

#### static定义属性
在一个类中，所有属性一旦定义了，实际内容都交由堆内存空间进行保存。
思考？如果50000个对象有同一个属性需要修改，怎么办？
-   用static进行修饰。将属性修改为公共属性
-   static属性将会保存到全局数据区
-   static属性由于是公共属性，理论上可以通过对象访问，但是最最好的方法是通过所有对象的最高代表(类)进行访问，所以**static属性可以通过类名称访问**。
-   static属性不受类的实例化对象控制，不实例化对象也可以调用
-   类设计中首选非static属性（95%），只有在存在公共属性时使用static（5%）
-   非static属性必须在实例化对象后才能访问

#### static定义方法
-   static方法的主要特点是可以直接使用类名称调用，不需要经过对象实例化
-   static方法只能调用static属性
-   非static方法允许调用static方法和static属性
-   static定义的方法或属性都不是在编码之初所需要考虑的内容，当回避实例化对象调用或需要公共属性时才调用。
```
class Chinese{
    private static String county="中华民国";
    private String name;
    public Chinese(){
    }
    public Chinese(String name){
        this.name=name;
    }
    public static void setCounty(String county) {
        Chinese.county = county;
    }
    public String getInfo() {
        return "国籍："+Chinese.county+"，姓名"+this.name;
    }
}
public class StaticDemo{
    public static void main(String[] args) {
        Chinese chi=new Chinese("李四");
        Chinese.setCounty("中华人民共和国");
        System.out.println(chi.getInfo());
    }
}
```