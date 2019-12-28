### 包装类
object类最大的特点是所有类的父类。
-   数字和基本数据类型不是类。
-   为了将基本数据和数组以类的方式传递，定义了一些包装类

**装箱**：将基本数据类型保存到类中叫装箱
**拆箱**：从包装类中取出基本数据类叫拆箱
####    包装类的作用
-   基部数据类型可以想对象一用进行引用传递，同时可以使用object接收

#### 8种包装类
-   数值型包装类，都是Number抽象类的子类
    -   Integer
    -   Byte
    -   Long
    -   Short
    -   Float
    -   Double
-   对象型包装类
    -   Character
    -   Boolean

#### 装箱与拆箱操作
基本数据类型的包装类都是为了基本数据类型转为对象提供

基本数据类型与包装类之间的关系
-   数据装箱：将基本数据类型保存到包装类中，初始化使用构造方法。
    -   Integer：
    -   Double：
    -   Boolean：
-   数据拆箱：从包装类中获取基本数据类型
    -   数值型包装类已经由number定义了拆箱方法了
    -   Boolean：booleanValue()
-   jdk1.5已经实现了自动的装箱和拆箱，jdk1.9已经开始 deprecated 了包装类
-   自动装箱拆箱，可以用obj接收基本数据类型了

#### Number抽象类的6个方法
Modifier and Type修饰符类型	|Method方法|	描述Description
:--|:--|:--
byte|   byteValue​()   |从指定Number对象实例返回byte类型的值
abstract double|    doubleValue​()  |从指定Number对象实例返回double类型的值
abstract float| floatValue​()    |从指定Number对象实例返回float类型的值
abstract int|   intValue​()    |从指定Number对象实例返回int类型的值
abstract long|  longValue​()  |从指定Number对象实例返回long类型的值
short|  shortValue​() |从指定Number对象实例返回short类型的值