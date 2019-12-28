### 分支与循环
三种程序逻辑
-   顺序结构：程序按照代码定义的顺序依次执行，只执行一次
-   分支结构：进行多个条件的判断if、switch
-   循环结构：循环执行多次
#### if分支结构
针对关系表达式进行判断处理的分支操作
-   关节字if、else、else if
-   只有if分支结构可以进行多个条件的判断
```
if(bool表达式){
    //满足条件时执行
}else if(bool表达式){
    //满足条件时执行
}else{
}
```
#### switch开关语句
switch判断的数据类型只能是int、char、枚举（jdk1.5开始支持）、string（jdk1.7开始支持）而不能使用逻辑判断。
-   switch中break未追加，会在第一个匹配的case执行后继续执行下一个case直到遇到break退出或运行完最后一个。
-   switch中支持字符串等了10年在jdk1.7才开始支持
```
switch(数值){
    case 数值：
        满足条件执行;
        [break]可选;
     case 数值：
        满足条件执行;
        [break]可选;
    defalut:
        默认执行;
        [break]可选;
}
```
#### while循环结构
-   while循环:先判断后执行
-   do while循环：先执行后判断，循环至少会执行一次。
-   开发中首选while
```
while(布尔表达式){
    条件满足时执行；
    修改循环条件；
}
do{
条件满足时执行；
修改循环条件；
}while(布尔表达式)
```
#### for循环
-   定义循环初始化值：
-   循环判断
-   修改循环条件
```
for(定义循环初始化值；循环判断；修改循环数据){
    执行语句
}
```
#### Java 增强 for 循环
Java5 引入了一种主要用于数组的增强型 for 循环。
-   声明语句：声明新的局部变量，该变量的类型必须和数组元素的类型匹配。其作用域限定在循环语句块，其值与此时数组元素的值相等。
-   表达式：表达式是要访问的数组名，或者是返回值为数组的方法。
```
for(声明语句 : 表达式)
{
   //代码句子
}
    int [] numbers = {10, 20, 30, 40, 50};
    for(int x : numbers ){
        System.out.print( x );
        System.out.print(",");
    }
    System.out.print("\n");
    String [] names ={"James", "Larry", "Tom", "Lacy"};
    for( String name : names ) {
        System.out.print( name );
        System.out.print(",");
    }
```

#### 循环选择
-   明确知道循环次数时使用for循环
-   明确知道循环条件时使用while循环
#### 循环控制
-   break：退出整个循环
-   continue：从continue处跳出当前循环
-   在java中可以使用continue实现类似goto的部分功能,***不建议使用***
```
point:  for(int x=0;x<10;x++){
            for(int y=0;y<3;y++){
                if(x==y) continue point;
                System.out.print(x);
            }
            System.out.print("\n");
        }
```
#### 循环嵌套
-   在一个循环语句中嵌套其他的循环语句，循环次数越多时间复杂度越高