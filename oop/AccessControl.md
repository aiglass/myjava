### 访问控制权限
#### 面向对象的三大特点：
-   抽象和封装
-   继承
-   多态

#### 四种权限控制
NO.|访问范围|private|default|protected|public
:--:|:--|:--|:--|:--|:--
1|同一个包中的类    | ok  |ok   |ok   |ok   
2|同一个包的不同类  |  -   |ok   |ok  |ok   
3|不同包的子类      |  -   |  -  |ok  |ok   
4|不同包的所有类    |   -   |  - | -  |ok   

protected受保护  
在程序之中封装一共有三种对应的访问权限：private、default、protected。  
-   只要是进行属性定义使用private
-   只要是方法的定义用public