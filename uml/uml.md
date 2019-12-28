### uml
一个统一的建模语言，本质是利用图形化的关系类实现程序类关系的描述。  
常见设计工具
-   RationalRose
-   PowerDesign

#### 类图描述
一般用三层结构来表示类：
-   第一层：类名称 classname
    -   普通类：直接使用名称
    -   抽象类：斜体+abstract关键字
    -   接口：斜体+interface关键字
        -   早期接口用一个圈加下横线表示
-   第二层：属性 attribute
    -   使用格式“访问权限 属性名：属性类型”
-   第三次：方法 operations
    -   使用格式“访问权限 方法名称（）：返回值”，一般方法都是public
-   public（+）、private（-）、protected（#）

**关系**
-   子类实现接口“空心三角和虚线”
-   类的继承使用的是“空心三角加实线”

实际开发中，如果化大量的时间进行uml设计会浪费大量的时间和人力，通常使用一个工具进行转换
#### 时序图

```puml
title:工厂设计模式
javaDemo->Factory:getinstance
Factory->MessageImpl:实例化MessageImpl
MessageImpl->MessageImpl:connect()
MessageImpl-->Factory:获得实例化对象
Factory-->javaDemo:IMessage实例
javaDemo->IMessage:send()
```
#### 用例图
